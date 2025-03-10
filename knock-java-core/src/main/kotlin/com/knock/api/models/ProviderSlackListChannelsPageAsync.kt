// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.knock.api.core.ExcludeMissing
import com.knock.api.core.JsonField
import com.knock.api.core.JsonMissing
import com.knock.api.core.JsonValue
import com.knock.api.core.NoAutoDetect
import com.knock.api.core.immutableEmptyMap
import com.knock.api.core.toImmutable
import com.knock.api.services.async.providers.SlackServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate

/** List Slack channels for a Slack workspace */
class ProviderSlackListChannelsPageAsync
private constructor(
    private val slackService: SlackServiceAsync,
    private val params: ProviderSlackListChannelsParams,
    private val response: Response,
) {

    fun response(): Response = response

    fun nextCursor(): Optional<String> = response().nextCursor()

    fun slackChannels(): List<ProviderSlackListChannelsResponse> = response().slackChannels()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ProviderSlackListChannelsPageAsync && slackService == other.slackService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(slackService, params, response) /* spotless:on */

    override fun toString() =
        "ProviderSlackListChannelsPageAsync{slackService=$slackService, params=$params, response=$response}"

    fun hasNextPage(): Boolean {
        if (slackChannels().isEmpty()) {
            return false
        }

        return nextCursor().isPresent
    }

    fun getNextPageParams(): Optional<ProviderSlackListChannelsParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(
            ProviderSlackListChannelsParams.builder()
                .from(params)
                .apply { nextCursor().ifPresent { this.queryOptionsCursor(it) } }
                .build()
        )
    }

    fun getNextPage(): CompletableFuture<Optional<ProviderSlackListChannelsPageAsync>> {
        return getNextPageParams()
            .map { slackService.listChannels(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            slackService: SlackServiceAsync,
            params: ProviderSlackListChannelsParams,
            response: Response,
        ) = ProviderSlackListChannelsPageAsync(slackService, params, response)
    }

    @NoAutoDetect
    class Response
    @JsonCreator
    constructor(
        @JsonProperty("next_cursor") private val nextCursor: JsonField<String> = JsonMissing.of(),
        @JsonProperty("slack_channels")
        private val slackChannels: JsonField<List<ProviderSlackListChannelsResponse>> =
            JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun nextCursor(): Optional<String> =
            Optional.ofNullable(nextCursor.getNullable("next_cursor"))

        fun slackChannels(): List<ProviderSlackListChannelsResponse> =
            slackChannels.getNullable("slack_channels") ?: listOf()

        @JsonProperty("next_cursor")
        fun _nextCursor(): Optional<JsonField<String>> = Optional.ofNullable(nextCursor)

        @JsonProperty("slack_channels")
        fun _slackChannels(): Optional<JsonField<List<ProviderSlackListChannelsResponse>>> =
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
             * Returns a mutable builder for constructing an instance of
             * [ProviderSlackListChannelsPageAsync].
             */
            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var nextCursor: JsonField<String> = JsonMissing.of()
            private var slackChannels: JsonField<List<ProviderSlackListChannelsResponse>> =
                JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(page: Response) = apply {
                this.nextCursor = page.nextCursor
                this.slackChannels = page.slackChannels
                this.additionalProperties.putAll(page.additionalProperties)
            }

            fun nextCursor(nextCursor: String) = nextCursor(JsonField.of(nextCursor))

            fun nextCursor(nextCursor: JsonField<String>) = apply { this.nextCursor = nextCursor }

            fun slackChannels(slackChannels: List<ProviderSlackListChannelsResponse>) =
                slackChannels(JsonField.of(slackChannels))

            fun slackChannels(slackChannels: JsonField<List<ProviderSlackListChannelsResponse>>) =
                apply {
                    this.slackChannels = slackChannels
                }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun build() = Response(nextCursor, slackChannels, additionalProperties.toImmutable())
        }
    }

    class AutoPager(private val firstPage: ProviderSlackListChannelsPageAsync) {

        fun forEach(
            action: Predicate<ProviderSlackListChannelsResponse>,
            executor: Executor,
        ): CompletableFuture<Void> {
            fun CompletableFuture<Optional<ProviderSlackListChannelsPageAsync>>.forEach(
                action: (ProviderSlackListChannelsResponse) -> Boolean,
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

        fun toList(executor: Executor): CompletableFuture<List<ProviderSlackListChannelsResponse>> {
            val values = mutableListOf<ProviderSlackListChannelsResponse>()
            return forEach(values::add, executor).thenApply { values }
        }
    }
}
