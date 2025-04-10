// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages

import app.knock.api.services.async.MessageServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** List messages */
class MessageListPageAsync
private constructor(
    private val messagesService: MessageServiceAsync,
    private val params: MessageListParams,
    private val response: MessageListPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): MessageListPageResponse = response

    /**
     * Delegates to [MessageListPageResponse], but gracefully handles missing data.
     *
     * @see [MessageListPageResponse.entries]
     */
    fun entries(): List<Message> =
        response._entries().getOptional("entries").getOrNull() ?: emptyList()

    /**
     * Delegates to [MessageListPageResponse], but gracefully handles missing data.
     *
     * @see [MessageListPageResponse.pageInfo]
     */
    fun pageInfo(): Optional<MessageListPageResponse.PageInfo> =
        response._pageInfo().getOptional("page_info")

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is MessageListPageAsync && messagesService == other.messagesService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(messagesService, params, response) /* spotless:on */

    override fun toString() =
        "MessageListPageAsync{messagesService=$messagesService, params=$params, response=$response}"

    fun hasNextPage(): Boolean =
        entries().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun getNextPageParams(): Optional<MessageListParams> {
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

    fun getNextPage(): CompletableFuture<Optional<MessageListPageAsync>> {
        return getNextPageParams()
            .map { messagesService.list(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            messagesService: MessageServiceAsync,
            params: MessageListParams,
            response: MessageListPageResponse,
        ) = MessageListPageAsync(messagesService, params, response)
    }

    class AutoPager(private val firstPage: MessageListPageAsync) {

        fun forEach(action: Predicate<Message>, executor: Executor): CompletableFuture<Void> {
            fun CompletableFuture<Optional<MessageListPageAsync>>.forEach(
                action: (Message) -> Boolean,
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

        fun toList(executor: Executor): CompletableFuture<List<Message>> {
            val values = mutableListOf<Message>()
            return forEach(values::add, executor).thenApply { values }
        }
    }
}
