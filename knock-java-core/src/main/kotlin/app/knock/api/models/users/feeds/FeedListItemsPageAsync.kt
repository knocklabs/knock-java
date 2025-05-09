// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users.feeds

import app.knock.api.core.AutoPagerAsync
import app.knock.api.core.PageAsync
import app.knock.api.core.checkRequired
import app.knock.api.models.shared.PageInfo
import app.knock.api.services.async.users.FeedServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see [FeedServiceAsync.listItems] */
class FeedListItemsPageAsync
private constructor(
    private val service: FeedServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: FeedListItemsParams,
    private val response: FeedListItemsPageResponse,
) : PageAsync<FeedListItemsResponse> {

    /**
     * Delegates to [FeedListItemsPageResponse], but gracefully handles missing data.
     *
     * @see [FeedListItemsPageResponse.entries]
     */
    fun entries(): List<FeedListItemsResponse> =
        response._entries().getOptional("entries").getOrNull() ?: emptyList()

    /**
     * Delegates to [FeedListItemsPageResponse], but gracefully handles missing data.
     *
     * @see [FeedListItemsPageResponse.pageInfo]
     */
    fun pageInfo(): Optional<PageInfo> = response._pageInfo().getOptional("page_info")

    override fun items(): List<FeedListItemsResponse> = entries()

    override fun hasNextPage(): Boolean =
        items().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun nextPageParams(): FeedListItemsParams {
        val nextCursor =
            pageInfo().flatMap { it._after().getOptional("after") }.getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): CompletableFuture<FeedListItemsPageAsync> =
        service.listItems(nextPageParams())

    fun autoPager(): AutoPagerAsync<FeedListItemsResponse> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): FeedListItemsParams = params

    /** The response that this page was parsed from. */
    fun response(): FeedListItemsPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [FeedListItemsPageAsync].
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

    /** A builder for [FeedListItemsPageAsync]. */
    class Builder internal constructor() {

        private var service: FeedServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: FeedListItemsParams? = null
        private var response: FeedListItemsPageResponse? = null

        @JvmSynthetic
        internal fun from(feedListItemsPageAsync: FeedListItemsPageAsync) = apply {
            service = feedListItemsPageAsync.service
            streamHandlerExecutor = feedListItemsPageAsync.streamHandlerExecutor
            params = feedListItemsPageAsync.params
            response = feedListItemsPageAsync.response
        }

        fun service(service: FeedServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: FeedListItemsParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: FeedListItemsPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [FeedListItemsPageAsync].
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
        fun build(): FeedListItemsPageAsync =
            FeedListItemsPageAsync(
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

        return /* spotless:off */ other is FeedListItemsPageAsync && service == other.service && streamHandlerExecutor == other.streamHandlerExecutor && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, streamHandlerExecutor, params, response) /* spotless:on */

    override fun toString() =
        "FeedListItemsPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
