// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.providers.slack

import app.knock.api.core.checkRequired
import app.knock.api.services.async.providers.SlackServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** @see [SlackServiceAsync.listChannels] */
class SlackListChannelsPageAsync
private constructor(
    private val service: SlackServiceAsync,
    private val params: SlackListChannelsParams,
    private val response: SlackListChannelsPageResponse,
) {

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

    fun hasNextPage(): Boolean = slackChannels().isNotEmpty() && nextCursor().isPresent

    fun getNextPageParams(): Optional<SlackListChannelsParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(
            params.toBuilder().apply { nextCursor().ifPresent { queryOptionsCursor(it) } }.build()
        )
    }

    fun getNextPage(): CompletableFuture<Optional<SlackListChannelsPageAsync>> =
        getNextPageParams()
            .map { service.listChannels(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }

    fun autoPager(): AutoPager = AutoPager(this)

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
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SlackListChannelsPageAsync]. */
    class Builder internal constructor() {

        private var service: SlackServiceAsync? = null
        private var params: SlackListChannelsParams? = null
        private var response: SlackListChannelsPageResponse? = null

        @JvmSynthetic
        internal fun from(slackListChannelsPageAsync: SlackListChannelsPageAsync) = apply {
            service = slackListChannelsPageAsync.service
            params = slackListChannelsPageAsync.params
            response = slackListChannelsPageAsync.response
        }

        fun service(service: SlackServiceAsync) = apply { this.service = service }

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
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): SlackListChannelsPageAsync =
            SlackListChannelsPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    class AutoPager(private val firstPage: SlackListChannelsPageAsync) {

        fun forEach(
            action: Predicate<SlackListChannelsResponse>,
            executor: Executor,
        ): CompletableFuture<Void> {
            fun CompletableFuture<Optional<SlackListChannelsPageAsync>>.forEach(
                action: (SlackListChannelsResponse) -> Boolean,
                executor: Executor,
            ): CompletableFuture<Void> =
                thenComposeAsync(
                    { page ->
                        page
                            .filter { it.slackChannels().all(action) }
                            .map { it.getNextPage().forEach(action, executor) }
                            .orElseGet { CompletableFuture.completedFuture(null) }
                    },
                    executor,
                )
            return CompletableFuture.completedFuture(Optional.of(firstPage))
                .forEach(action::test, executor)
        }

        fun toList(executor: Executor): CompletableFuture<List<SlackListChannelsResponse>> {
            val values = mutableListOf<SlackListChannelsResponse>()
            return forEach(values::add, executor).thenApply { values }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is SlackListChannelsPageAsync && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "SlackListChannelsPageAsync{service=$service, params=$params, response=$response}"
}
