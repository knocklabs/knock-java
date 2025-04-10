// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.providers.slack

import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.checkKnown
import app.knock.api.core.checkRequired
import app.knock.api.core.toImmutable
import app.knock.api.errors.KnockInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** The response from a Slack channels for provider request */
class SlackListChannelsPageResponse
private constructor(
    private val nextCursor: JsonField<String>,
    private val slackChannels: JsonField<List<SlackListChannelsResponse>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("next_cursor")
        @ExcludeMissing
        nextCursor: JsonField<String> = JsonMissing.of(),
        @JsonProperty("slack_channels")
        @ExcludeMissing
        slackChannels: JsonField<List<SlackListChannelsResponse>> = JsonMissing.of(),
    ) : this(nextCursor, slackChannels, mutableMapOf())

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun nextCursor(): Optional<String> = nextCursor.getOptional("next_cursor")

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun slackChannels(): List<SlackListChannelsResponse> =
        slackChannels.getRequired("slack_channels")

    /**
     * Returns the raw JSON value of [nextCursor].
     *
     * Unlike [nextCursor], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("next_cursor") @ExcludeMissing fun _nextCursor(): JsonField<String> = nextCursor

    /**
     * Returns the raw JSON value of [slackChannels].
     *
     * Unlike [slackChannels], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("slack_channels")
    @ExcludeMissing
    fun _slackChannels(): JsonField<List<SlackListChannelsResponse>> = slackChannels

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [SlackListChannelsPageResponse].
         *
         * The following fields are required:
         * ```java
         * .nextCursor()
         * .slackChannels()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SlackListChannelsPageResponse]. */
    class Builder internal constructor() {

        private var nextCursor: JsonField<String>? = null
        private var slackChannels: JsonField<MutableList<SlackListChannelsResponse>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(slackListChannelsPageResponse: SlackListChannelsPageResponse) = apply {
            nextCursor = slackListChannelsPageResponse.nextCursor
            slackChannels = slackListChannelsPageResponse.slackChannels.map { it.toMutableList() }
            additionalProperties = slackListChannelsPageResponse.additionalProperties.toMutableMap()
        }

        fun nextCursor(nextCursor: String?) = nextCursor(JsonField.ofNullable(nextCursor))

        /** Alias for calling [Builder.nextCursor] with `nextCursor.orElse(null)`. */
        fun nextCursor(nextCursor: Optional<String>) = nextCursor(nextCursor.getOrNull())

        /**
         * Sets [Builder.nextCursor] to an arbitrary JSON value.
         *
         * You should usually call [Builder.nextCursor] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun nextCursor(nextCursor: JsonField<String>) = apply { this.nextCursor = nextCursor }

        fun slackChannels(slackChannels: List<SlackListChannelsResponse>) =
            slackChannels(JsonField.of(slackChannels))

        /**
         * Sets [Builder.slackChannels] to an arbitrary JSON value.
         *
         * You should usually call [Builder.slackChannels] with a well-typed
         * `List<SlackListChannelsResponse>` value instead. This method is primarily for setting the
         * field to an undocumented or not yet supported value.
         */
        fun slackChannels(slackChannels: JsonField<List<SlackListChannelsResponse>>) = apply {
            this.slackChannels = slackChannels.map { it.toMutableList() }
        }

        /**
         * Adds a single [SlackListChannelsResponse] to [slackChannels].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addSlackChannel(slackChannel: SlackListChannelsResponse) = apply {
            slackChannels =
                (slackChannels ?: JsonField.of(mutableListOf())).also {
                    checkKnown("slackChannels", it).add(slackChannel)
                }
        }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        /**
         * Returns an immutable instance of [SlackListChannelsPageResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .nextCursor()
         * .slackChannels()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): SlackListChannelsPageResponse =
            SlackListChannelsPageResponse(
                checkRequired("nextCursor", nextCursor),
                checkRequired("slackChannels", slackChannels).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): SlackListChannelsPageResponse = apply {
        if (validated) {
            return@apply
        }

        nextCursor()
        slackChannels().forEach { it.validate() }
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: KnockInvalidDataException) {
            false
        }

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (nextCursor.asKnown().isPresent) 1 else 0) +
            (slackChannels.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is SlackListChannelsPageResponse && nextCursor == other.nextCursor && slackChannels == other.slackChannels && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(nextCursor, slackChannels, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SlackListChannelsPageResponse{nextCursor=$nextCursor, slackChannels=$slackChannels, additionalProperties=$additionalProperties}"
}
