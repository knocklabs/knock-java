// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users.feeds

import app.knock.api.services.blocking.users.FeedService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** Returns a paginated list of feed items for a user, including metadata about the feed. */
class FeedListItemsPage
private constructor(
    private val feedsService: FeedService,
    private val params: FeedListItemsParams,
    private val response: FeedListItemsPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): FeedListItemsPageResponse = response

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
    fun pageInfo(): Optional<FeedListItemsPageResponse.PageInfo> =
        response._pageInfo().getOptional("page_info")

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FeedListItemsPage && feedsService == other.feedsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(feedsService, params, response) /* spotless:on */

    override fun toString() =
        "FeedListItemsPage{feedsService=$feedsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean =
        entries().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun getNextPageParams(): Optional<FeedListItemsParams> {
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

    fun getNextPage(): Optional<FeedListItemsPage> {
        return getNextPageParams().map { feedsService.listItems(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            feedsService: FeedService,
            params: FeedListItemsParams,
            response: FeedListItemsPageResponse,
        ) = FeedListItemsPage(feedsService, params, response)
    }

    class AutoPager(private val firstPage: FeedListItemsPage) : Iterable<FeedListItemsResponse> {

        override fun iterator(): Iterator<FeedListItemsResponse> = iterator {
            var page = firstPage
            var index = 0
            while (true) {
                while (index < page.entries().size) {
                    yield(page.entries()[index++])
                }
                page = page.getNextPage().getOrNull() ?: break
                index = 0
            }
        }

        fun stream(): Stream<FeedListItemsResponse> {
            return StreamSupport.stream(spliterator(), false)
        }
    }
}
