// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages

import app.knock.api.core.checkRequired
import app.knock.api.models.shared.PageInfo
import app.knock.api.services.blocking.MessageService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** @see [MessageService.listEvents] */
class MessageListEventsPage
private constructor(
    private val service: MessageService,
    private val params: MessageListEventsParams,
    private val response: MessageListEventsPageResponse,
) {

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
    fun pageInfo(): Optional<PageInfo> = response._pageInfo().getOptional("page_info")

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

    fun getNextPage(): Optional<MessageListEventsPage> =
        getNextPageParams().map { service.listEvents(it) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): MessageListEventsParams = params

    /** The response that this page was parsed from. */
    fun response(): MessageListEventsPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [MessageListEventsPage].
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

    /** A builder for [MessageListEventsPage]. */
    class Builder internal constructor() {

        private var service: MessageService? = null
        private var params: MessageListEventsParams? = null
        private var response: MessageListEventsPageResponse? = null

        @JvmSynthetic
        internal fun from(messageListEventsPage: MessageListEventsPage) = apply {
            service = messageListEventsPage.service
            params = messageListEventsPage.params
            response = messageListEventsPage.response
        }

        fun service(service: MessageService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: MessageListEventsParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: MessageListEventsPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [MessageListEventsPage].
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
        fun build(): MessageListEventsPage =
            MessageListEventsPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is MessageListEventsPage && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "MessageListEventsPage{service=$service, params=$params, response=$response}"
}
