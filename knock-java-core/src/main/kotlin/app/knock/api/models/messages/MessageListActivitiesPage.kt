// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages

import app.knock.api.services.blocking.MessageService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** List activities */
class MessageListActivitiesPage
private constructor(
    private val messagesService: MessageService,
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

        return /* spotless:off */ other is MessageListActivitiesPage && messagesService == other.messagesService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(messagesService, params, response) /* spotless:on */

    override fun toString() =
        "MessageListActivitiesPage{messagesService=$messagesService, params=$params, response=$response}"

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

    fun getNextPage(): Optional<MessageListActivitiesPage> {
        return getNextPageParams().map { messagesService.listActivities(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            messagesService: MessageService,
            params: MessageListActivitiesParams,
            response: MessageListActivitiesPageResponse,
        ) = MessageListActivitiesPage(messagesService, params, response)
    }

    class AutoPager(private val firstPage: MessageListActivitiesPage) : Iterable<Activity> {

        override fun iterator(): Iterator<Activity> = iterator {
            var page = firstPage
            var index = 0
            while (true) {
                while (index < page.items().size) {
                    yield(page.items()[index++])
                }
                page = page.getNextPage().getOrNull() ?: break
                index = 0
            }
        }

        fun stream(): Stream<Activity> {
            return StreamSupport.stream(spliterator(), false)
        }
    }
}
