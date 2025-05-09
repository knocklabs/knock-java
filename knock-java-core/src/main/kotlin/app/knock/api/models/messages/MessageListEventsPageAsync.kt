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

/** @see [MessageServiceAsync.listEvents] */
class MessageListEventsPageAsync
private constructor(
    private val service: MessageServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: MessageListEventsParams,
    private val response: MessageListEventsPageResponse,
) : PageAsync<MessageEvent> {

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

    override fun nextPage(): CompletableFuture<MessageListEventsPageAsync> =
        service.listEvents(nextPageParams())

    fun autoPager(): AutoPagerAsync<MessageEvent> = AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): MessageListEventsParams = params

    /** The response that this page was parsed from. */
    fun response(): MessageListEventsPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [MessageListEventsPageAsync].
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

    /** A builder for [MessageListEventsPageAsync]. */
    class Builder internal constructor() {

        private var service: MessageServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: MessageListEventsParams? = null
        private var response: MessageListEventsPageResponse? = null

        @JvmSynthetic
        internal fun from(messageListEventsPageAsync: MessageListEventsPageAsync) = apply {
            service = messageListEventsPageAsync.service
            streamHandlerExecutor = messageListEventsPageAsync.streamHandlerExecutor
            params = messageListEventsPageAsync.params
            response = messageListEventsPageAsync.response
        }

        fun service(service: MessageServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: MessageListEventsParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: MessageListEventsPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [MessageListEventsPageAsync].
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
        fun build(): MessageListEventsPageAsync =
            MessageListEventsPageAsync(
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

        return /* spotless:off */ other is MessageListEventsPageAsync && service == other.service && streamHandlerExecutor == other.streamHandlerExecutor && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, streamHandlerExecutor, params, response) /* spotless:on */

    override fun toString() =
        "MessageListEventsPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
