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

/** @see [MessageServiceAsync.listActivities] */
class MessageListActivitiesPageAsync
private constructor(
    private val service: MessageServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: MessageListActivitiesParams,
    private val response: MessageListActivitiesPageResponse,
) : PageAsync<Activity> {

    /**
     * Delegates to [MessageListActivitiesPageResponse], but gracefully handles missing data.
     *
     * @see [MessageListActivitiesPageResponse.items]
     */
    override fun items(): List<Activity> =
        response._items().getOptional("items").getOrNull() ?: emptyList()

    /**
     * Delegates to [MessageListActivitiesPageResponse], but gracefully handles missing data.
     *
     * @see [MessageListActivitiesPageResponse.pageInfo]
     */
    fun pageInfo(): Optional<PageInfo> = response._pageInfo().getOptional("page_info")

    override fun hasNextPage(): Boolean =
        items().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun nextPageParams(): MessageListActivitiesParams {
        val nextCursor =
            pageInfo().flatMap { it._after().getOptional("after") }.getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): CompletableFuture<MessageListActivitiesPageAsync> =
        service.listActivities(nextPageParams())

    fun autoPager(): AutoPagerAsync<Activity> = AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): MessageListActivitiesParams = params

    /** The response that this page was parsed from. */
    fun response(): MessageListActivitiesPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [MessageListActivitiesPageAsync].
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

    /** A builder for [MessageListActivitiesPageAsync]. */
    class Builder internal constructor() {

        private var service: MessageServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: MessageListActivitiesParams? = null
        private var response: MessageListActivitiesPageResponse? = null

        @JvmSynthetic
        internal fun from(messageListActivitiesPageAsync: MessageListActivitiesPageAsync) = apply {
            service = messageListActivitiesPageAsync.service
            streamHandlerExecutor = messageListActivitiesPageAsync.streamHandlerExecutor
            params = messageListActivitiesPageAsync.params
            response = messageListActivitiesPageAsync.response
        }

        fun service(service: MessageServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: MessageListActivitiesParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: MessageListActivitiesPageResponse) = apply {
            this.response = response
        }

        /**
         * Returns an immutable instance of [MessageListActivitiesPageAsync].
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
        fun build(): MessageListActivitiesPageAsync =
            MessageListActivitiesPageAsync(
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

        return /* spotless:off */ other is MessageListActivitiesPageAsync && service == other.service && streamHandlerExecutor == other.streamHandlerExecutor && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, streamHandlerExecutor, params, response) /* spotless:on */

    override fun toString() =
        "MessageListActivitiesPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
