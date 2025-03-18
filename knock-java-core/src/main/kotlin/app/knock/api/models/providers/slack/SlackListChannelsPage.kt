// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.providers.slack

import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.NoAutoDetect
import app.knock.api.core.immutableEmptyMap
import app.knock.api.core.toImmutable
import app.knock.api.services.blocking.providers.SlackService
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
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
    private val response: Response,
) {

    fun response(): Response = response

    fun nextCursor(): Optional<String> = response().nextCursor()

    fun slackChannels(): List<SlackListChannelsResponse> = response().slackChannels()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is SlackListChannelsPage && slackService == other.slackService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(slackService, params, response) /* spotless:on */

    override fun toString() =
        "SlackListChannelsPage{slackService=$slackService, params=$params, response=$response}"

    fun hasNextPage(): Boolean {
        if (slackChannels().isEmpty()) {
            return false
        }

        return nextCursor().isPresent
    }

    fun getNextPageParams(): Optional<SlackListChannelsParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(
            SlackListChannelsParams.builder()
                .from(params)
                .apply { nextCursor().ifPresent { this.queryOptionsCursor(it) } }
                .build()
        )
    }

    fun getNextPage(): Optional<SlackListChannelsPage> {
        return getNextPageParams().map { slackService.listChannels(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(slackService: SlackService, params: SlackListChannelsParams, response: Response) =
            SlackListChannelsPage(slackService, params, response)
    }

    @NoAutoDetect
    class Response
    @JsonCreator
    constructor(
        @JsonProperty("next_cursor") private val nextCursor: JsonField<String> = JsonMissing.of(),
        @JsonProperty("slack_channels")
        private val slackChannels: JsonField<List<SlackListChannelsResponse>> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun nextCursor(): Optional<String> =
            Optional.ofNullable(nextCursor.getNullable("next_cursor"))

        fun slackChannels(): List<SlackListChannelsResponse> =
            slackChannels.getNullable("slack_channels") ?: listOf()

        @JsonProperty("next_cursor")
        fun _nextCursor(): Optional<JsonField<String>> = Optional.ofNullable(nextCursor)

        @JsonProperty("slack_channels")
        fun _slackChannels(): Optional<JsonField<List<SlackListChannelsResponse>>> =
            Optional.ofNullable(slackChannels)

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Response = apply {
            if (validated) {
                return@apply
            }

            nextCursor()
            slackChannels().map { it.validate() }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Response && nextCursor == other.nextCursor && slackChannels == other.slackChannels && additionalProperties == other.additionalProperties /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(nextCursor, slackChannels, additionalProperties) /* spotless:on */

        override fun toString() =
            "Response{nextCursor=$nextCursor, slackChannels=$slackChannels, additionalProperties=$additionalProperties}"

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [SlackListChannelsPage].
             */
            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var nextCursor: JsonField<String> = JsonMissing.of()
            private var slackChannels: JsonField<List<SlackListChannelsResponse>> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(page: Response) = apply {
                this.nextCursor = page.nextCursor
                this.slackChannels = page.slackChannels
                this.additionalProperties.putAll(page.additionalProperties)
            }

            fun nextCursor(nextCursor: String) = nextCursor(JsonField.of(nextCursor))

            fun nextCursor(nextCursor: JsonField<String>) = apply { this.nextCursor = nextCursor }

            fun slackChannels(slackChannels: List<SlackListChannelsResponse>) =
                slackChannels(JsonField.of(slackChannels))

            fun slackChannels(slackChannels: JsonField<List<SlackListChannelsResponse>>) = apply {
                this.slackChannels = slackChannels
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            /**
             * Returns an immutable instance of [Response].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Response =
                Response(nextCursor, slackChannels, additionalProperties.toImmutable())
        }
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
