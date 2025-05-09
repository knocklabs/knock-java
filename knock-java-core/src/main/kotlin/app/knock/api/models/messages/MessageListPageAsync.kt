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

/** @see [MessageServiceAsync.list] */
class MessageListPageAsync
private constructor(
    private val service: MessageServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: MessageListParams,
    private val response: MessageListPageResponse,
) : PageAsync<Message> {

    /**
     * Delegates to [MessageListPageResponse], but gracefully handles missing data.
     *
     * @see [MessageListPageResponse.entries]
     */
    fun entries(): List<Message> =
        response._entries().getOptional("entries").getOrNull() ?: emptyList()

    /**
     * Delegates to [MessageListPageResponse], but gracefully handles missing data.
     *
     * @see [MessageListPageResponse.pageInfo]
     */
    fun pageInfo(): Optional<PageInfo> = response._pageInfo().getOptional("page_info")

    override fun items(): List<Message> = entries()

    override fun hasNextPage(): Boolean =
        items().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun nextPageParams(): MessageListParams {
        val nextCursor =
            pageInfo().flatMap { it._after().getOptional("after") }.getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): CompletableFuture<MessageListPageAsync> =
        service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<Message> = AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): MessageListParams = params

    /** The response that this page was parsed from. */
    fun response(): MessageListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [MessageListPageAsync].
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

    /** A builder for [MessageListPageAsync]. */
    class Builder internal constructor() {

        private var service: MessageServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: MessageListParams? = null
        private var response: MessageListPageResponse? = null

        @JvmSynthetic
        internal fun from(messageListPageAsync: MessageListPageAsync) = apply {
            service = messageListPageAsync.service
            streamHandlerExecutor = messageListPageAsync.streamHandlerExecutor
            params = messageListPageAsync.params
            response = messageListPageAsync.response
        }

        fun service(service: MessageServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: MessageListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: MessageListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [MessageListPageAsync].
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
        fun build(): MessageListPageAsync =
            MessageListPageAsync(
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

        return /* spotless:off */ other is MessageListPageAsync && service == other.service && streamHandlerExecutor == other.streamHandlerExecutor && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, streamHandlerExecutor, params, response) /* spotless:on */

    override fun toString() =
        "MessageListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
