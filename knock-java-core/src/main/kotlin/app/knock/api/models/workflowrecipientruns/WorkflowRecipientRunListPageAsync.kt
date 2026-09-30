// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.workflowrecipientruns

import app.knock.api.core.checkRequired
import app.knock.api.models.shared.PageInfo
import app.knock.api.services.async.WorkflowRecipientRunServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** @see [WorkflowRecipientRunServiceAsync.list] */
class WorkflowRecipientRunListPageAsync
private constructor(
    private val service: WorkflowRecipientRunServiceAsync,
    private val params: WorkflowRecipientRunListParams,
    private val response: WorkflowRecipientRunListPageResponse,
) {

    /**
     * Delegates to [WorkflowRecipientRunListPageResponse], but gracefully handles missing data.
     *
     * @see [WorkflowRecipientRunListPageResponse.items]
     */
    fun items(): List<WorkflowRecipientRun> =
        response._items().getOptional("items").getOrNull() ?: emptyList()

    /**
     * Delegates to [WorkflowRecipientRunListPageResponse], but gracefully handles missing data.
     *
     * @see [WorkflowRecipientRunListPageResponse.pageInfo]
     */
    fun pageInfo(): Optional<PageInfo> = response._pageInfo().getOptional("page_info")

    fun hasNextPage(): Boolean =
        items().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun getNextPageParams(): Optional<WorkflowRecipientRunListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(
            params
                .toBuilder()
                .apply {
                    pageInfo().flatMap { it._after().getOptional("after") }.ifPresent { after(it) }
                }
                .build()
        )
    }

    fun getNextPage(): CompletableFuture<Optional<WorkflowRecipientRunListPageAsync>> =
        getNextPageParams()
            .map { service.list(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): WorkflowRecipientRunListParams = params

    /** The response that this page was parsed from. */
    fun response(): WorkflowRecipientRunListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [WorkflowRecipientRunListPageAsync].
         *
         * The following fields are required:
         * ```java
         * .service()
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [WorkflowRecipientRunListPageAsync]. */
    class Builder internal constructor() {

        private var service: WorkflowRecipientRunServiceAsync? = null
        private var params: WorkflowRecipientRunListParams? = null
        private var response: WorkflowRecipientRunListPageResponse? = null

        @JvmSynthetic
        internal fun from(workflowRecipientRunListPageAsync: WorkflowRecipientRunListPageAsync) =
            apply {
                service = workflowRecipientRunListPageAsync.service
                params = workflowRecipientRunListPageAsync.params
                response = workflowRecipientRunListPageAsync.response
            }

        fun service(service: WorkflowRecipientRunServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: WorkflowRecipientRunListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: WorkflowRecipientRunListPageResponse) = apply {
            this.response = response
        }

        /**
         * Returns an immutable instance of [WorkflowRecipientRunListPageAsync].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .service()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): WorkflowRecipientRunListPageAsync =
            WorkflowRecipientRunListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    class AutoPager(private val firstPage: WorkflowRecipientRunListPageAsync) {

        fun forEach(
            action: Predicate<WorkflowRecipientRun>,
            executor: Executor,
        ): CompletableFuture<Void> {
            fun CompletableFuture<Optional<WorkflowRecipientRunListPageAsync>>.forEach(
                action: (WorkflowRecipientRun) -> Boolean,
                executor: Executor,
            ): CompletableFuture<Void> =
                thenComposeAsync(
                    { page ->
                        page
                            .filter { it.items().all(action) }
                            .map { it.getNextPage().forEach(action, executor) }
                            .orElseGet { CompletableFuture.completedFuture(null) }
                    },
                    executor,
                )
            return CompletableFuture.completedFuture(Optional.of(firstPage))
                .forEach(action::test, executor)
        }

        fun toList(executor: Executor): CompletableFuture<List<WorkflowRecipientRun>> {
            val values = mutableListOf<WorkflowRecipientRun>()
            return forEach(values::add, executor).thenApply { values }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is WorkflowRecipientRunListPageAsync && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "WorkflowRecipientRunListPageAsync{service=$service, params=$params, response=$response}"
}
