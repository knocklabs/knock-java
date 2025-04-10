// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.models.messages.Message
import app.knock.api.services.blocking.ObjectService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** List messages */
class ObjectListMessagesPage
private constructor(
    private val objectsService: ObjectService,
    private val params: ObjectListMessagesParams,
    private val response: ObjectListMessagesPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): ObjectListMessagesPageResponse = response

    /**
     * Delegates to [ObjectListMessagesPageResponse], but gracefully handles missing data.
     *
     * @see [ObjectListMessagesPageResponse.entries]
     */
    fun entries(): List<Message> =
        response._entries().getOptional("entries").getOrNull() ?: emptyList()

    /**
     * Delegates to [ObjectListMessagesPageResponse], but gracefully handles missing data.
     *
     * @see [ObjectListMessagesPageResponse.pageInfo]
     */
    fun pageInfo(): Optional<ObjectListMessagesPageResponse.PageInfo> =
        response._pageInfo().getOptional("page_info")

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ObjectListMessagesPage && objectsService == other.objectsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(objectsService, params, response) /* spotless:on */

    override fun toString() =
        "ObjectListMessagesPage{objectsService=$objectsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean =
        entries().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun getNextPageParams(): Optional<ObjectListMessagesParams> {
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

    fun getNextPage(): Optional<ObjectListMessagesPage> {
        return getNextPageParams().map { objectsService.listMessages(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            objectsService: ObjectService,
            params: ObjectListMessagesParams,
            response: ObjectListMessagesPageResponse,
        ) = ObjectListMessagesPage(objectsService, params, response)
    }

    class AutoPager(private val firstPage: ObjectListMessagesPage) : Iterable<Message> {

        override fun iterator(): Iterator<Message> = iterator {
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

        fun stream(): Stream<Message> {
            return StreamSupport.stream(spliterator(), false)
        }
    }
}
