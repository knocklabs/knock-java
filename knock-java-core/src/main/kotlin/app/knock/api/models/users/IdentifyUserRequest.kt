// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.errors.KnockInvalidDataException
import app.knock.api.models.recipients.channeldata.InlineChannelDataRequest
import app.knock.api.models.recipients.preferences.InlinePreferenceSetRequest
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * A set of parameters to identify a user with. Does not include the user ID, as that's specified
 * elsewhere in the request. You can supply any additional properties you'd like to upsert against
 * the user.
 */
class IdentifyUserRequest
private constructor(
    private val channelData: JsonField<InlineChannelDataRequest>,
    private val createdAt: JsonField<OffsetDateTime>,
    private val preferences: JsonField<InlinePreferenceSetRequest>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("channel_data")
        @ExcludeMissing
        channelData: JsonField<InlineChannelDataRequest> = JsonMissing.of(),
        @JsonProperty("created_at")
        @ExcludeMissing
        createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("preferences")
        @ExcludeMissing
        preferences: JsonField<InlinePreferenceSetRequest> = JsonMissing.of(),
    ) : this(channelData, createdAt, preferences, mutableMapOf())

    /**
     * Allows inline setting channel data for a recipient
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun channelData(): Optional<InlineChannelDataRequest> =
        Optional.ofNullable(channelData.getNullable("channel_data"))

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun createdAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(createdAt.getNullable("created_at"))

    /**
     * Inline set preferences for a recipient, where the key is the preference set name
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun preferences(): Optional<InlinePreferenceSetRequest> =
        Optional.ofNullable(preferences.getNullable("preferences"))

    /**
     * Returns the raw JSON value of [channelData].
     *
     * Unlike [channelData], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("channel_data")
    @ExcludeMissing
    fun _channelData(): JsonField<InlineChannelDataRequest> = channelData

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created_at")
    @ExcludeMissing
    fun _createdAt(): JsonField<OffsetDateTime> = createdAt

    /**
     * Returns the raw JSON value of [preferences].
     *
     * Unlike [preferences], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("preferences")
    @ExcludeMissing
    fun _preferences(): JsonField<InlinePreferenceSetRequest> = preferences

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

        /** Returns a mutable builder for constructing an instance of [IdentifyUserRequest]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [IdentifyUserRequest]. */
    class Builder internal constructor() {

        private var channelData: JsonField<InlineChannelDataRequest> = JsonMissing.of()
        private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var preferences: JsonField<InlinePreferenceSetRequest> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(identifyUserRequest: IdentifyUserRequest) = apply {
            channelData = identifyUserRequest.channelData
            createdAt = identifyUserRequest.createdAt
            preferences = identifyUserRequest.preferences
            additionalProperties = identifyUserRequest.additionalProperties.toMutableMap()
        }

        /** Allows inline setting channel data for a recipient */
        fun channelData(channelData: InlineChannelDataRequest?) =
            channelData(JsonField.ofNullable(channelData))

        /** Alias for calling [Builder.channelData] with `channelData.orElse(null)`. */
        fun channelData(channelData: Optional<InlineChannelDataRequest>) =
            channelData(channelData.getOrNull())

        /**
         * Sets [Builder.channelData] to an arbitrary JSON value.
         *
         * You should usually call [Builder.channelData] with a well-typed
         * [InlineChannelDataRequest] value instead. This method is primarily for setting the field
         * to an undocumented or not yet supported value.
         */
        fun channelData(channelData: JsonField<InlineChannelDataRequest>) = apply {
            this.channelData = channelData
        }

        fun createdAt(createdAt: OffsetDateTime?) = createdAt(JsonField.ofNullable(createdAt))

        /** Alias for calling [Builder.createdAt] with `createdAt.orElse(null)`. */
        fun createdAt(createdAt: Optional<OffsetDateTime>) = createdAt(createdAt.getOrNull())

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply { this.createdAt = createdAt }

        /** Inline set preferences for a recipient, where the key is the preference set name */
        fun preferences(preferences: InlinePreferenceSetRequest?) =
            preferences(JsonField.ofNullable(preferences))

        /** Alias for calling [Builder.preferences] with `preferences.orElse(null)`. */
        fun preferences(preferences: Optional<InlinePreferenceSetRequest>) =
            preferences(preferences.getOrNull())

        /**
         * Sets [Builder.preferences] to an arbitrary JSON value.
         *
         * You should usually call [Builder.preferences] with a well-typed
         * [InlinePreferenceSetRequest] value instead. This method is primarily for setting the
         * field to an undocumented or not yet supported value.
         */
        fun preferences(preferences: JsonField<InlinePreferenceSetRequest>) = apply {
            this.preferences = preferences
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
         * Returns an immutable instance of [IdentifyUserRequest].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): IdentifyUserRequest =
            IdentifyUserRequest(
                channelData,
                createdAt,
                preferences,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): IdentifyUserRequest = apply {
        if (validated) {
            return@apply
        }

        channelData().ifPresent { it.validate() }
        createdAt()
        preferences().ifPresent { it.validate() }
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
        (channelData.asKnown().getOrNull()?.validity() ?: 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (preferences.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is IdentifyUserRequest && channelData == other.channelData && createdAt == other.createdAt && preferences == other.preferences && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(channelData, createdAt, preferences, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "IdentifyUserRequest{channelData=$channelData, createdAt=$createdAt, preferences=$preferences, additionalProperties=$additionalProperties}"
}
