// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages

import app.knock.api.services.blocking.MessageService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** List events */
class MessageListEventsPage
private constructor(
    private val messagesService: MessageService,
    private val params: MessageListEventsParams,
    private val response: MessageListEventsPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): MessageListEventsPageResponse = response

    /**
     * Delegates to [MessageListEventsPageResponse], but gracefully handles missing data.
     *
     * @see [MessageListEventsPageResponse.entries]
     */
    fun entries(): List<MessageEvent> =
        response._entries().getOptional("entries").getOrNull() ?: emptyList()

    /**
     * Delegates to [MessageListEventsPageResponse], but gracefully handles missing data.
     *
     * @see [MessageListEventsPageResponse.pageInfo]
     */
    fun pageInfo(): Optional<MessageListEventsPageResponse.PageInfo> =
        response._pageInfo().getOptional("page_info")

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is MessageListEventsPage && messagesService == other.messagesService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(messagesService, params, response) /* spotless:on */

    override fun toString() =
        "MessageListEventsPage{messagesService=$messagesService, params=$params, response=$response}"

    fun hasNextPage(): Boolean =
        entries().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun getNextPageParams(): Optional<MessageListEventsParams> {
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

    fun getNextPage(): Optional<MessageListEventsPage> {
        return getNextPageParams().map { messagesService.listEvents(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            messagesService: MessageService,
            params: MessageListEventsParams,
            response: MessageListEventsPageResponse,
        ) = MessageListEventsPage(messagesService, params, response)
    }

    class AutoPager(private val firstPage: MessageListEventsPage) : Iterable<MessageEvent> {

        override fun iterator(): Iterator<MessageEvent> = iterator {
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

        fun stream(): Stream<MessageEvent> {
            return StreamSupport.stream(spliterator(), false)
        }
    }
}
