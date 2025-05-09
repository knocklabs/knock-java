// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages

import app.knock.api.core.AutoPagerAsync
import app.knock.api.core.PageAsync
import app.knock.api.core.checkRequired
import app.knock.api.models.shared.PageInfo
import app.knock.api.services.async.MessageServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see [MessageServiceAsync.listDeliveryLogs] */
class MessageListDeliveryLogsPageAsync
private constructor(
    private val service: MessageServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: MessageListDeliveryLogsParams,
    private val response: MessageListDeliveryLogsPageResponse,
) : PageAsync<MessageDeliveryLog> {

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

    override fun nextPage(): CompletableFuture<MessageListDeliveryLogsPageAsync> =
        service.listDeliveryLogs(nextPageParams())

    fun autoPager(): AutoPagerAsync<MessageDeliveryLog> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): MessageListDeliveryLogsParams = params

    /** The response that this page was parsed from. */
    fun response(): MessageListDeliveryLogsPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [MessageListDeliveryLogsPageAsync].
         *
         * The following fields are required:
         * ```java
         * .service()
         * .streamHandlerExecutor()
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MessageListDeliveryLogsPageAsync]. */
    class Builder internal constructor() {

        private var service: MessageServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: MessageListDeliveryLogsParams? = null
        private var response: MessageListDeliveryLogsPageResponse? = null

        @JvmSynthetic
        internal fun from(messageListDeliveryLogsPageAsync: MessageListDeliveryLogsPageAsync) =
            apply {
                service = messageListDeliveryLogsPageAsync.service
                streamHandlerExecutor = messageListDeliveryLogsPageAsync.streamHandlerExecutor
                params = messageListDeliveryLogsPageAsync.params
                response = messageListDeliveryLogsPageAsync.response
            }

        fun service(service: MessageServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: MessageListDeliveryLogsParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: MessageListDeliveryLogsPageResponse) = apply {
            this.response = response
        }

        /**
         * Returns an immutable instance of [MessageListDeliveryLogsPageAsync].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .service()
         * .streamHandlerExecutor()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): MessageListDeliveryLogsPageAsync =
            MessageListDeliveryLogsPageAsync(
                checkRequired("service", service),
                checkRequired("streamHandlerExecutor", streamHandlerExecutor),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is MessageListDeliveryLogsPageAsync && service == other.service && streamHandlerExecutor == other.streamHandlerExecutor && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, streamHandlerExecutor, params, response) /* spotless:on */

    override fun toString() =
        "MessageListDeliveryLogsPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
