// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.core.checkRequired
import app.knock.api.models.shared.PageInfo
import app.knock.api.services.async.ObjectServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** @see [ObjectServiceAsync.list] */
class ObjectListPageAsync
private constructor(
    private val service: ObjectServiceAsync,
    private val params: ObjectListParams,
    private val response: ObjectListPageResponse,
) {

    /**
     * Delegates to [ObjectListPageResponse], but gracefully handles missing data.
     *
     * @see [ObjectListPageResponse.entries]
     */
    fun entries(): List<Object> =
        response._entries().getOptional("entries").getOrNull() ?: emptyList()

    /**
     * Delegates to [ObjectListPageResponse], but gracefully handles missing data.
     *
     * @see [ObjectListPageResponse.pageInfo]
     */
    fun pageInfo(): Optional<PageInfo> = response._pageInfo().getOptional("page_info")

    fun hasNextPage(): Boolean =
        entries().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun getNextPageParams(): Optional<ObjectListParams> {
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

    fun getNextPage(): CompletableFuture<Optional<ObjectListPageAsync>> =
        getNextPageParams()
            .map { service.list(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): ObjectListParams = params

    /** The response that this page was parsed from. */
    fun response(): ObjectListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ObjectListPageAsync].
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

    /** A builder for [ObjectListPageAsync]. */
    class Builder internal constructor() {

        private var service: ObjectServiceAsync? = null
        private var params: ObjectListParams? = null
        private var response: ObjectListPageResponse? = null

        @JvmSynthetic
        internal fun from(objectListPageAsync: ObjectListPageAsync) = apply {
            service = objectListPageAsync.service
            params = objectListPageAsync.params
            response = objectListPageAsync.response
        }

        fun service(service: ObjectServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ObjectListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ObjectListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ObjectListPageAsync].
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
        fun build(): ObjectListPageAsync =
            ObjectListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    class AutoPager(private val firstPage: ObjectListPageAsync) {

        fun forEach(action: Predicate<Object>, executor: Executor): CompletableFuture<Void> {
            fun CompletableFuture<Optional<ObjectListPageAsync>>.forEach(
                action: (Object) -> Boolean,
                executor: Executor,
            ): CompletableFuture<Void> =
                thenComposeAsync(
                    { page ->
                        page
                            .filter { it.entries().all(action) }
                            .map { it.getNextPage().forEach(action, executor) }
                            .orElseGet { CompletableFuture.completedFuture(null) }
                    },
                    executor,
                )
            return CompletableFuture.completedFuture(Optional.of(firstPage))
                .forEach(action::test, executor)
        }

        fun toList(executor: Executor): CompletableFuture<List<Object>> {
            val values = mutableListOf<Object>()
            return forEach(values::add, executor).thenApply { values }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ObjectListPageAsync && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "ObjectListPageAsync{service=$service, params=$params, response=$response}"
}
