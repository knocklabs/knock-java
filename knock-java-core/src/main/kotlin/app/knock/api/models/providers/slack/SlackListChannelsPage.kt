// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.providers.slack

import app.knock.api.services.blocking.providers.SlackService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** List Slack channels for a Slack workspace */
class SlackListChannelsPage
private constructor(
    private val slackService: SlackService,
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

        return /* spotless:off */ other is SlackListChannelsPage && slackService == other.slackService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(slackService, params, response) /* spotless:on */

    override fun toString() =
        "SlackListChannelsPage{slackService=$slackService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = slackChannels().isNotEmpty() && nextCursor().isPresent

    fun getNextPageParams(): Optional<SlackListChannelsParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(
            params.toBuilder().apply { nextCursor().ifPresent { queryOptionsCursor(it) } }.build()
        )
    }

    fun getNextPage(): Optional<SlackListChannelsPage> {
        return getNextPageParams().map { slackService.listChannels(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            slackService: SlackService,
            params: SlackListChannelsParams,
            response: SlackListChannelsPageResponse,
        ) = SlackListChannelsPage(slackService, params, response)
    }

    class AutoPager(private val firstPage: SlackListChannelsPage) :
        Iterable<SlackListChannelsResponse> {

        override fun iterator(): Iterator<SlackListChannelsResponse> = iterator {
            var page = firstPage
            var index = 0
            while (true) {
                while (index < page.slackChannels().size) {
                    yield(page.slackChannels()[index++])
                }
                page = page.getNextPage().getOrNull() ?: break
                index = 0
            }
        }

        fun stream(): Stream<SlackListChannelsResponse> {
            return StreamSupport.stream(spliterator(), false)
        }
    }
}
