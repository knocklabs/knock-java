// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users.feeds

import app.knock.api.services.async.users.FeedServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** Returns a paginated list of feed items for a user, including metadata about the feed. */
class FeedListItemsPageAsync
private constructor(
    private val feedsService: FeedServiceAsync,
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

        return /* spotless:off */ other is FeedListItemsPageAsync && feedsService == other.feedsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(feedsService, params, response) /* spotless:on */

    override fun toString() =
        "FeedListItemsPageAsync{feedsService=$feedsService, params=$params, response=$response}"

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

    fun getNextPage(): CompletableFuture<Optional<FeedListItemsPageAsync>> {
        return getNextPageParams()
            .map { feedsService.listItems(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            feedsService: FeedServiceAsync,
            params: FeedListItemsParams,
            response: FeedListItemsPageResponse,
        ) = FeedListItemsPageAsync(feedsService, params, response)
    }

    class AutoPager(private val firstPage: FeedListItemsPageAsync) {

        fun forEach(
            action: Predicate<FeedListItemsResponse>,
            executor: Executor,
        ): CompletableFuture<Void> {
            fun CompletableFuture<Optional<FeedListItemsPageAsync>>.forEach(
                action: (FeedListItemsResponse) -> Boolean,
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

        fun toList(executor: Executor): CompletableFuture<List<FeedListItemsResponse>> {
            val values = mutableListOf<FeedListItemsResponse>()
            return forEach(values::add, executor).thenApply { values }
        }
    }
}
