// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages

import app.knock.api.services.async.MessageServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** List delivery logs */
class MessageListDeliveryLogsPageAsync
private constructor(
    private val messagesService: MessageServiceAsync,
    private val params: MessageListDeliveryLogsParams,
    private val response: MessageListDeliveryLogsPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): MessageListDeliveryLogsPageResponse = response

    /**
     * Delegates to [MessageListDeliveryLogsPageResponse], but gracefully handles missing data.
     *
     * @see [MessageListDeliveryLogsPageResponse.entries]
     */
    fun entries(): List<MessageDeliveryLog> =
        response._entries().getOptional("entries").getOrNull() ?: emptyList()

    /**
     * Delegates to [MessageListDeliveryLogsPageResponse], but gracefully handles missing data.
     *
     * @see [MessageListDeliveryLogsPageResponse.pageInfo]
     */
    fun pageInfo(): Optional<MessageListDeliveryLogsPageResponse.PageInfo> =
        response._pageInfo().getOptional("page_info")

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is MessageListDeliveryLogsPageAsync && messagesService == other.messagesService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(messagesService, params, response) /* spotless:on */

    override fun toString() =
        "MessageListDeliveryLogsPageAsync{messagesService=$messagesService, params=$params, response=$response}"

    fun hasNextPage(): Boolean =
        entries().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun getNextPageParams(): Optional<MessageListDeliveryLogsParams> {
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

    fun getNextPage(): CompletableFuture<Optional<MessageListDeliveryLogsPageAsync>> {
        return getNextPageParams()
            .map { messagesService.listDeliveryLogs(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            messagesService: MessageServiceAsync,
            params: MessageListDeliveryLogsParams,
            response: MessageListDeliveryLogsPageResponse,
        ) = MessageListDeliveryLogsPageAsync(messagesService, params, response)
    }

    class AutoPager(private val firstPage: MessageListDeliveryLogsPageAsync) {

        fun forEach(
            action: Predicate<MessageDeliveryLog>,
            executor: Executor,
        ): CompletableFuture<Void> {
            fun CompletableFuture<Optional<MessageListDeliveryLogsPageAsync>>.forEach(
                action: (MessageDeliveryLog) -> Boolean,
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

        fun toList(executor: Executor): CompletableFuture<List<MessageDeliveryLog>> {
            val values = mutableListOf<MessageDeliveryLog>()
            return forEach(values::add, executor).thenApply { values }
        }
    }
}
