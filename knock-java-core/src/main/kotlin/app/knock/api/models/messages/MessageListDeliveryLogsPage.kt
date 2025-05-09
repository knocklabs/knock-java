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

/** @see [MessageService.listDeliveryLogs] */
class MessageListDeliveryLogsPage
private constructor(
    private val service: MessageService,
    private val params: MessageListDeliveryLogsParams,
    private val response: MessageListDeliveryLogsPageResponse,
) : Page<MessageDeliveryLog> {

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
    fun pageInfo(): Optional<PageInfo> = response._pageInfo().getOptional("page_info")

    override fun items(): List<MessageDeliveryLog> = entries()

    override fun hasNextPage(): Boolean =
        items().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun nextPageParams(): MessageListDeliveryLogsParams {
        val nextCursor =
            pageInfo().flatMap { it._after().getOptional("after") }.getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): MessageListDeliveryLogsPage =
        service.listDeliveryLogs(nextPageParams())

    fun autoPager(): AutoPager<MessageDeliveryLog> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): MessageListDeliveryLogsParams = params

    /** The response that this page was parsed from. */
    fun response(): MessageListDeliveryLogsPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [MessageListDeliveryLogsPage].
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

    /** A builder for [MessageListDeliveryLogsPage]. */
    class Builder internal constructor() {

        private var service: MessageService? = null
        private var params: MessageListDeliveryLogsParams? = null
        private var response: MessageListDeliveryLogsPageResponse? = null

        @JvmSynthetic
        internal fun from(messageListDeliveryLogsPage: MessageListDeliveryLogsPage) = apply {
            service = messageListDeliveryLogsPage.service
            params = messageListDeliveryLogsPage.params
            response = messageListDeliveryLogsPage.response
        }

        fun service(service: MessageService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: MessageListDeliveryLogsParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: MessageListDeliveryLogsPageResponse) = apply {
            this.response = response
        }

        /**
         * Returns an immutable instance of [MessageListDeliveryLogsPage].
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
        fun build(): MessageListDeliveryLogsPage =
            MessageListDeliveryLogsPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is MessageListDeliveryLogsPage && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "MessageListDeliveryLogsPage{service=$service, params=$params, response=$response}"
}
