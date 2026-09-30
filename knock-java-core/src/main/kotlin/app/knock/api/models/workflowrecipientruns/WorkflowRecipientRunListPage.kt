// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.workflowrecipientruns

import app.knock.api.core.checkRequired
import app.knock.api.models.shared.PageInfo
import app.knock.api.services.blocking.WorkflowRecipientRunService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** @see [WorkflowRecipientRunService.list] */
class WorkflowRecipientRunListPage
private constructor(
    private val service: WorkflowRecipientRunService,
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

    fun getNextPage(): Optional<WorkflowRecipientRunListPage> =
        getNextPageParams().map { service.list(it) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): WorkflowRecipientRunListParams = params

    /** The response that this page was parsed from. */
    fun response(): WorkflowRecipientRunListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [WorkflowRecipientRunListPage].
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

    /** A builder for [WorkflowRecipientRunListPage]. */
    class Builder internal constructor() {

        private var service: WorkflowRecipientRunService? = null
        private var params: WorkflowRecipientRunListParams? = null
        private var response: WorkflowRecipientRunListPageResponse? = null

        @JvmSynthetic
        internal fun from(workflowRecipientRunListPage: WorkflowRecipientRunListPage) = apply {
            service = workflowRecipientRunListPage.service
            params = workflowRecipientRunListPage.params
            response = workflowRecipientRunListPage.response
        }

        fun service(service: WorkflowRecipientRunService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: WorkflowRecipientRunListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: WorkflowRecipientRunListPageResponse) = apply {
            this.response = response
        }

        /**
         * Returns an immutable instance of [WorkflowRecipientRunListPage].
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
        fun build(): WorkflowRecipientRunListPage =
            WorkflowRecipientRunListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    class AutoPager(private val firstPage: WorkflowRecipientRunListPage) :
        Iterable<WorkflowRecipientRun> {

        override fun iterator(): Iterator<WorkflowRecipientRun> = iterator {
            var page = firstPage
            var index = 0
            while (true) {
                while (index < page.items().size) {
                    yield(page.items()[index++])
                }
                page = page.getNextPage().getOrNull() ?: break
                index = 0
            }
        }

        fun stream(): Stream<WorkflowRecipientRun> {
            return StreamSupport.stream(spliterator(), false)
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is WorkflowRecipientRunListPage && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "WorkflowRecipientRunListPage{service=$service, params=$params, response=$response}"
}
