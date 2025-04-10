// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages

import app.knock.api.services.blocking.MessageService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** List delivery logs */
class MessageListDeliveryLogsPage
private constructor(
    private val messagesService: MessageService,
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

        return /* spotless:off */ other is MessageListDeliveryLogsPage && messagesService == other.messagesService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(messagesService, params, response) /* spotless:on */

    override fun toString() =
        "MessageListDeliveryLogsPage{messagesService=$messagesService, params=$params, response=$response}"

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

    fun getNextPage(): Optional<MessageListDeliveryLogsPage> {
        return getNextPageParams().map { messagesService.listDeliveryLogs(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            messagesService: MessageService,
            params: MessageListDeliveryLogsParams,
            response: MessageListDeliveryLogsPageResponse,
        ) = MessageListDeliveryLogsPage(messagesService, params, response)
    }

    class AutoPager(private val firstPage: MessageListDeliveryLogsPage) :
        Iterable<MessageDeliveryLog> {

        override fun iterator(): Iterator<MessageDeliveryLog> = iterator {
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

        fun stream(): Stream<MessageDeliveryLog> {
            return StreamSupport.stream(spliterator(), false)
        }
    }
}
