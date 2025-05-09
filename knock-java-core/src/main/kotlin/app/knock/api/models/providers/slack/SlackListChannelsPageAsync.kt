// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.providers.slack

import app.knock.api.core.AutoPagerAsync
import app.knock.api.core.PageAsync
import app.knock.api.core.checkRequired
import app.knock.api.services.async.providers.SlackServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see [SlackServiceAsync.listChannels] */
class SlackListChannelsPageAsync
private constructor(
    private val service: SlackServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: SlackListChannelsParams,
    private val response: SlackListChannelsPageResponse,
) : PageAsync<SlackListChannelsResponse> {

    /**
     * Delegates to [SlackListChannelsPageResponse], but gracefully handles missing data.
     *
     * @see [SlackListChannelsPageResponse.nextCursor]
     */
    fun nextCursor(): Optional<String> = response._nextCursor().getOptional("next_cursor")

    /**
     * Delegates to [SlackListChannelsPageResponse], but gracefully handles missing data.
     *
     * @see [SlackListChannelsPageResponse.slackChannels]
     */
    fun slackChannels(): List<SlackListChannelsResponse> =
        response._slackChannels().getOptional("slack_channels").getOrNull() ?: emptyList()

    override fun items(): List<SlackListChannelsResponse> = slackChannels()

    override fun hasNextPage(): Boolean = items().isNotEmpty() && nextCursor().isPresent

    fun nextPageParams(): SlackListChannelsParams {
        val nextCursor =
            nextCursor().getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().queryOptionsCursor(nextCursor).build()
    }

    override fun nextPage(): CompletableFuture<SlackListChannelsPageAsync> =
        service.listChannels(nextPageParams())

    fun autoPager(): AutoPagerAsync<SlackListChannelsResponse> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): SlackListChannelsParams = params

    /** The response that this page was parsed from. */
    fun response(): SlackListChannelsPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [SlackListChannelsPageAsync].
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

    /** A builder for [SlackListChannelsPageAsync]. */
    class Builder internal constructor() {

        private var service: SlackServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: SlackListChannelsParams? = null
        private var response: SlackListChannelsPageResponse? = null

        @JvmSynthetic
        internal fun from(slackListChannelsPageAsync: SlackListChannelsPageAsync) = apply {
            service = slackListChannelsPageAsync.service
            streamHandlerExecutor = slackListChannelsPageAsync.streamHandlerExecutor
            params = slackListChannelsPageAsync.params
            response = slackListChannelsPageAsync.response
        }

        fun service(service: SlackServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: SlackListChannelsParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: SlackListChannelsPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [SlackListChannelsPageAsync].
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
        fun build(): SlackListChannelsPageAsync =
            SlackListChannelsPageAsync(
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

        return /* spotless:off */ other is SlackListChannelsPageAsync && service == other.service && streamHandlerExecutor == other.streamHandlerExecutor && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, streamHandlerExecutor, params, response) /* spotless:on */

    override fun toString() =
        "SlackListChannelsPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
