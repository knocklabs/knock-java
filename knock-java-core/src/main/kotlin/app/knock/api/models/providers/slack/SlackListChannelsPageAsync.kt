// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.providers.slack

import app.knock.api.services.async.providers.SlackServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** List Slack channels for a Slack workspace */
class SlackListChannelsPageAsync
private constructor(
    private val slackService: SlackServiceAsync,
    private val params: SlackListChannelsParams,
    private val response: SlackListChannelsPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): SlackListChannelsPageResponse = response

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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is SlackListChannelsPageAsync && slackService == other.slackService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(slackService, params, response) /* spotless:on */

    override fun toString() =
        "SlackListChannelsPageAsync{slackService=$slackService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = slackChannels().isNotEmpty() && nextCursor().isPresent

    fun getNextPageParams(): Optional<SlackListChannelsParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(
            params.toBuilder().apply { nextCursor().ifPresent { queryOptionsCursor(it) } }.build()
        )
    }

    fun getNextPage(): CompletableFuture<Optional<SlackListChannelsPageAsync>> {
        return getNextPageParams()
            .map { slackService.listChannels(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            slackService: SlackServiceAsync,
            params: SlackListChannelsParams,
            response: SlackListChannelsPageResponse,
        ) = SlackListChannelsPageAsync(slackService, params, response)
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
}
