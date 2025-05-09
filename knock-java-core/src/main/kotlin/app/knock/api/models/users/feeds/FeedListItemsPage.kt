// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users.feeds

import app.knock.api.core.AutoPager
import app.knock.api.core.Page
import app.knock.api.core.checkRequired
import app.knock.api.models.shared.PageInfo
import app.knock.api.services.blocking.users.FeedService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see [FeedService.listItems] */
class FeedListItemsPage
private constructor(
    private val service: FeedService,
    private val params: FeedListItemsParams,
    private val response: FeedListItemsPageResponse,
) : Page<FeedListItemsResponse> {

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

    override fun nextPage(): FeedListItemsPage = service.listItems(nextPageParams())

    fun autoPager(): AutoPager<FeedListItemsResponse> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): FeedListItemsParams = params

    /** The response that this page was parsed from. */
    fun response(): FeedListItemsPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [FeedListItemsPage].
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

    /** A builder for [FeedListItemsPage]. */
    class Builder internal constructor() {

        private var service: FeedService? = null
        private var params: FeedListItemsParams? = null
        private var response: FeedListItemsPageResponse? = null

        @JvmSynthetic
        internal fun from(feedListItemsPage: FeedListItemsPage) = apply {
            service = feedListItemsPage.service
            params = feedListItemsPage.params
            response = feedListItemsPage.response
        }

        fun service(service: FeedService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: FeedListItemsParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: FeedListItemsPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [FeedListItemsPage].
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
        fun build(): FeedListItemsPage =
            FeedListItemsPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FeedListItemsPage && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "FeedListItemsPage{service=$service, params=$params, response=$response}"
}
