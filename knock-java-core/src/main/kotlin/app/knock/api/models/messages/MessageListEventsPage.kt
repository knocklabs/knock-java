// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages

import app.knock.api.core.AutoPager
import app.knock.api.core.Page
import app.knock.api.core.checkRequired
import app.knock.api.models.shared.PageInfo
import app.knock.api.services.blocking.MessageService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see [MessageService.listEvents] */
class MessageListEventsPage
private constructor(
    private val service: MessageService,
    private val params: MessageListEventsParams,
    private val response: MessageListEventsPageResponse,
) : Page<MessageEvent> {

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

    override fun items(): List<MessageEvent> = entries()

    override fun hasNextPage(): Boolean =
        items().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun nextPageParams(): MessageListEventsParams {
        val nextCursor =
            pageInfo().flatMap { it._after().getOptional("after") }.getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): MessageListEventsPage = service.listEvents(nextPageParams())

    fun autoPager(): AutoPager<MessageEvent> = AutoPager.from(this)

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
