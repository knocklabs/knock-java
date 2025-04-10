// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages

import app.knock.api.services.async.MessageServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** List activities */
class MessageListActivitiesPageAsync
private constructor(
    private val messagesService: MessageServiceAsync,
    private val params: MessageListActivitiesParams,
    private val response: MessageListActivitiesPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): MessageListActivitiesPageResponse = response

    /**
     * Delegates to [MessageListActivitiesPageResponse], but gracefully handles missing data.
     *
     * @see [MessageListActivitiesPageResponse.items]
     */
    fun items(): List<Activity> = response._items().getOptional("items").getOrNull() ?: emptyList()

    /**
     * Delegates to [MessageListActivitiesPageResponse], but gracefully handles missing data.
     *
     * @see [MessageListActivitiesPageResponse.pageInfo]
     */
    fun pageInfo(): Optional<MessageListActivitiesPageResponse.PageInfo> =
        response._pageInfo().getOptional("page_info")

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is MessageListActivitiesPageAsync && messagesService == other.messagesService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(messagesService, params, response) /* spotless:on */

    override fun toString() =
        "MessageListActivitiesPageAsync{messagesService=$messagesService, params=$params, response=$response}"

    fun hasNextPage(): Boolean =
        items().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun getNextPageParams(): Optional<MessageListActivitiesParams> {
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

    fun getNextPage(): CompletableFuture<Optional<MessageListActivitiesPageAsync>> {
        return getNextPageParams()
            .map { messagesService.listActivities(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            messagesService: MessageServiceAsync,
            params: MessageListActivitiesParams,
            response: MessageListActivitiesPageResponse,
        ) = MessageListActivitiesPageAsync(messagesService, params, response)
    }

    class AutoPager(private val firstPage: MessageListActivitiesPageAsync) {

        fun forEach(action: Predicate<Activity>, executor: Executor): CompletableFuture<Void> {
            fun CompletableFuture<Optional<MessageListActivitiesPageAsync>>.forEach(
                action: (Activity) -> Boolean,
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

        fun toList(executor: Executor): CompletableFuture<List<Activity>> {
            val values = mutableListOf<Activity>()
            return forEach(values::add, executor).thenApply { values }
        }
    }
}
