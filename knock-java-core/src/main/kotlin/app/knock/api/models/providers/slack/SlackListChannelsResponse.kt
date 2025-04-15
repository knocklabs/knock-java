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
class SlackListChannelsResponse
private constructor(
    private val nextCursor: JsonField<String>,
    private val slackChannels: JsonField<List<SlackChannel>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("next_cursor")
        @ExcludeMissing
        nextCursor: JsonField<String> = JsonMissing.of(),
        @JsonProperty("slack_channels")
        @ExcludeMissing
        slackChannels: JsonField<List<SlackChannel>> = JsonMissing.of(),
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
    fun slackChannels(): List<SlackChannel> = slackChannels.getRequired("slack_channels")

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
    fun _slackChannels(): JsonField<List<SlackChannel>> = slackChannels

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
         * Returns a mutable builder for constructing an instance of [SlackListChannelsResponse].
         *
         * The following fields are required:
         * ```java
         * .nextCursor()
         * .slackChannels()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SlackListChannelsResponse]. */
    class Builder internal constructor() {

        private var nextCursor: JsonField<String>? = null
        private var slackChannels: JsonField<MutableList<SlackChannel>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(slackListChannelsResponse: SlackListChannelsResponse) = apply {
            nextCursor = slackListChannelsResponse.nextCursor
            slackChannels = slackListChannelsResponse.slackChannels.map { it.toMutableList() }
            additionalProperties = slackListChannelsResponse.additionalProperties.toMutableMap()
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

        fun slackChannels(slackChannels: List<SlackChannel>) =
            slackChannels(JsonField.of(slackChannels))

        /**
         * Sets [Builder.slackChannels] to an arbitrary JSON value.
         *
         * You should usually call [Builder.slackChannels] with a well-typed `List<SlackChannel>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun slackChannels(slackChannels: JsonField<List<SlackChannel>>) = apply {
            this.slackChannels = slackChannels.map { it.toMutableList() }
        }

        /**
         * Adds a single [SlackChannel] to [slackChannels].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addSlackChannel(slackChannel: SlackChannel) = apply {
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
         * Returns an immutable instance of [SlackListChannelsResponse].
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
        fun build(): SlackListChannelsResponse =
            SlackListChannelsResponse(
                checkRequired("nextCursor", nextCursor),
                checkRequired("slackChannels", slackChannels).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): SlackListChannelsResponse = apply {
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

    class SlackChannel
    private constructor(
        private val id: JsonField<String>,
        private val contextTeamId: JsonField<String>,
        private val isIm: JsonField<Boolean>,
        private val isPrivate: JsonField<Boolean>,
        private val name: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("context_team_id")
            @ExcludeMissing
            contextTeamId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("is_im") @ExcludeMissing isIm: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("is_private")
            @ExcludeMissing
            isPrivate: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        ) : this(id, contextTeamId, isIm, isPrivate, name, mutableMapOf())

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun contextTeamId(): String = contextTeamId.getRequired("context_team_id")

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun isIm(): Boolean = isIm.getRequired("is_im")

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun isPrivate(): Boolean = isPrivate.getRequired("is_private")

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun name(): String = name.getRequired("name")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [contextTeamId].
         *
         * Unlike [contextTeamId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("context_team_id")
        @ExcludeMissing
        fun _contextTeamId(): JsonField<String> = contextTeamId

        /**
         * Returns the raw JSON value of [isIm].
         *
         * Unlike [isIm], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("is_im") @ExcludeMissing fun _isIm(): JsonField<Boolean> = isIm

        /**
         * Returns the raw JSON value of [isPrivate].
         *
         * Unlike [isPrivate], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("is_private") @ExcludeMissing fun _isPrivate(): JsonField<Boolean> = isPrivate

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

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
             * Returns a mutable builder for constructing an instance of [SlackChannel].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .contextTeamId()
             * .isIm()
             * .isPrivate()
             * .name()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [SlackChannel]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var contextTeamId: JsonField<String>? = null
            private var isIm: JsonField<Boolean>? = null
            private var isPrivate: JsonField<Boolean>? = null
            private var name: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(slackChannel: SlackChannel) = apply {
                id = slackChannel.id
                contextTeamId = slackChannel.contextTeamId
                isIm = slackChannel.isIm
                isPrivate = slackChannel.isPrivate
                name = slackChannel.name
                additionalProperties = slackChannel.additionalProperties.toMutableMap()
            }

            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            fun contextTeamId(contextTeamId: String) = contextTeamId(JsonField.of(contextTeamId))

            /**
             * Sets [Builder.contextTeamId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.contextTeamId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun contextTeamId(contextTeamId: JsonField<String>) = apply {
                this.contextTeamId = contextTeamId
            }

            fun isIm(isIm: Boolean) = isIm(JsonField.of(isIm))

            /**
             * Sets [Builder.isIm] to an arbitrary JSON value.
             *
             * You should usually call [Builder.isIm] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun isIm(isIm: JsonField<Boolean>) = apply { this.isIm = isIm }

            fun isPrivate(isPrivate: Boolean) = isPrivate(JsonField.of(isPrivate))

            /**
             * Sets [Builder.isPrivate] to an arbitrary JSON value.
             *
             * You should usually call [Builder.isPrivate] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun isPrivate(isPrivate: JsonField<Boolean>) = apply { this.isPrivate = isPrivate }

            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

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
             * Returns an immutable instance of [SlackChannel].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .contextTeamId()
             * .isIm()
             * .isPrivate()
             * .name()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): SlackChannel =
                SlackChannel(
                    checkRequired("id", id),
                    checkRequired("contextTeamId", contextTeamId),
                    checkRequired("isIm", isIm),
                    checkRequired("isPrivate", isPrivate),
                    checkRequired("name", name),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): SlackChannel = apply {
            if (validated) {
                return@apply
            }

            id()
            contextTeamId()
            isIm()
            isPrivate()
            name()
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (contextTeamId.asKnown().isPresent) 1 else 0) +
                (if (isIm.asKnown().isPresent) 1 else 0) +
                (if (isPrivate.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is SlackChannel && id == other.id && contextTeamId == other.contextTeamId && isIm == other.isIm && isPrivate == other.isPrivate && name == other.name && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(id, contextTeamId, isIm, isPrivate, name, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "SlackChannel{id=$id, contextTeamId=$contextTeamId, isIm=$isIm, isPrivate=$isPrivate, name=$name, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is SlackListChannelsResponse && nextCursor == other.nextCursor && slackChannels == other.slackChannels && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(nextCursor, slackChannels, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SlackListChannelsResponse{nextCursor=$nextCursor, slackChannels=$slackChannels, additionalProperties=$additionalProperties}"
}
