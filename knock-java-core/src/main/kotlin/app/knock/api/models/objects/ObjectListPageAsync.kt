// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.core.AutoPagerAsync
import app.knock.api.core.PageAsync
import app.knock.api.core.checkRequired
import app.knock.api.models.shared.PageInfo
import app.knock.api.services.async.ObjectServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see [ObjectServiceAsync.list] */
class ObjectListPageAsync
private constructor(
    private val service: ObjectServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: ObjectListParams,
    private val response: ObjectListPageResponse,
) : PageAsync<Object> {

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

    override fun items(): List<Object> = entries()

    override fun hasNextPage(): Boolean =
        items().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun nextPageParams(): ObjectListParams {
        val nextCursor =
            pageInfo().flatMap { it._after().getOptional("after") }.getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): CompletableFuture<ObjectListPageAsync> = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<Object> = AutoPagerAsync.from(this, streamHandlerExecutor)

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
         * .streamHandlerExecutor()
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ObjectListPageAsync]. */
    class Builder internal constructor() {

        private var service: ObjectServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: ObjectListParams? = null
        private var response: ObjectListPageResponse? = null

        @JvmSynthetic
        internal fun from(objectListPageAsync: ObjectListPageAsync) = apply {
            service = objectListPageAsync.service
            streamHandlerExecutor = objectListPageAsync.streamHandlerExecutor
            params = objectListPageAsync.params
            response = objectListPageAsync.response
        }

        fun service(service: ObjectServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

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
         * .streamHandlerExecutor()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ObjectListPageAsync =
            ObjectListPageAsync(
                checkRequired("service", service),
                checkRequired("streamHandlerExecutor", streamHandlerExecutor),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ObjectListPageAsync && service == other.service && streamHandlerExecutor == other.streamHandlerExecutor && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, streamHandlerExecutor, params, response) /* spotless:on */

    override fun toString() =
        "ObjectListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
