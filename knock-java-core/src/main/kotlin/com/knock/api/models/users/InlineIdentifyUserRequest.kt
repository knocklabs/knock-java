// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models.users

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.knock.api.core.ExcludeMissing
import com.knock.api.core.JsonField
import com.knock.api.core.JsonMissing
import com.knock.api.core.JsonValue
import com.knock.api.core.NoAutoDetect
import com.knock.api.core.checkRequired
import com.knock.api.core.immutableEmptyMap
import com.knock.api.core.toImmutable
import com.knock.api.models.recipients.InlineChannelDataRequest
import com.knock.api.models.recipients.InlinePreferenceSetRequest
import java.time.OffsetDateTime
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * A set of parameters to inline-identify a user with. Inline identifying the user will ensure that
 * the user is available before the request is executed in Knock. It will perform an upsert against
 * the user you're supplying, replacing any properties specified.
 */
@NoAutoDetect
class InlineIdentifyUserRequest
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("channel_data")
    @ExcludeMissing
    private val channelData: JsonField<InlineChannelDataRequest> = JsonMissing.of(),
    @JsonProperty("created_at")
    @ExcludeMissing
    private val createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
    @JsonProperty("preferences")
    @ExcludeMissing
    private val preferences: JsonField<InlinePreferenceSetRequest> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The ID of the user to identify. This is an ID that you supply. */
    fun id(): String = id.getRequired("id")

    /** Allows inline setting channel data for a recipient */
    fun channelData(): Optional<InlineChannelDataRequest> =
        Optional.ofNullable(channelData.getNullable("channel_data"))

    /** The creation date of the user from your system. */
    fun createdAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(createdAt.getNullable("created_at"))

    /** Inline set preferences for a recipient, where the key is the preference set name */
    fun preferences(): Optional<InlinePreferenceSetRequest> =
        Optional.ofNullable(preferences.getNullable("preferences"))

    /** The ID of the user to identify. This is an ID that you supply. */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /** Allows inline setting channel data for a recipient */
    @JsonProperty("channel_data")
    @ExcludeMissing
    fun _channelData(): JsonField<InlineChannelDataRequest> = channelData

    /** The creation date of the user from your system. */
    @JsonProperty("created_at")
    @ExcludeMissing
    fun _createdAt(): JsonField<OffsetDateTime> = createdAt

    /** Inline set preferences for a recipient, where the key is the preference set name */
    @JsonProperty("preferences")
    @ExcludeMissing
    fun _preferences(): JsonField<InlinePreferenceSetRequest> = preferences

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): InlineIdentifyUserRequest = apply {
        if (validated) {
            return@apply
        }

        id()
        channelData().ifPresent { it.validate() }
        createdAt()
        preferences().ifPresent { it.validate() }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [InlineIdentifyUserRequest].
         *
         * The following fields are required:
         * ```java
         * .id()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [InlineIdentifyUserRequest]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var channelData: JsonField<InlineChannelDataRequest> = JsonMissing.of()
        private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var preferences: JsonField<InlinePreferenceSetRequest> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(inlineIdentifyUserRequest: InlineIdentifyUserRequest) = apply {
            id = inlineIdentifyUserRequest.id
            channelData = inlineIdentifyUserRequest.channelData
            createdAt = inlineIdentifyUserRequest.createdAt
            preferences = inlineIdentifyUserRequest.preferences
            additionalProperties = inlineIdentifyUserRequest.additionalProperties.toMutableMap()
        }

        /** The ID of the user to identify. This is an ID that you supply. */
        fun id(id: String) = id(JsonField.of(id))

        /** The ID of the user to identify. This is an ID that you supply. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Allows inline setting channel data for a recipient */
        fun channelData(channelData: InlineChannelDataRequest?) =
            channelData(JsonField.ofNullable(channelData))

        /** Allows inline setting channel data for a recipient */
        fun channelData(channelData: Optional<InlineChannelDataRequest>) =
            channelData(channelData.getOrNull())

        /** Allows inline setting channel data for a recipient */
        fun channelData(channelData: JsonField<InlineChannelDataRequest>) = apply {
            this.channelData = channelData
        }

        /** The creation date of the user from your system. */
        fun createdAt(createdAt: OffsetDateTime?) = createdAt(JsonField.ofNullable(createdAt))

        /** The creation date of the user from your system. */
        fun createdAt(createdAt: Optional<OffsetDateTime>) = createdAt(createdAt.getOrNull())

        /** The creation date of the user from your system. */
        fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply { this.createdAt = createdAt }

        /** Inline set preferences for a recipient, where the key is the preference set name */
        fun preferences(preferences: InlinePreferenceSetRequest?) =
            preferences(JsonField.ofNullable(preferences))

        /** Inline set preferences for a recipient, where the key is the preference set name */
        fun preferences(preferences: Optional<InlinePreferenceSetRequest>) =
            preferences(preferences.getOrNull())

        /** Inline set preferences for a recipient, where the key is the preference set name */
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

        fun build(): InlineIdentifyUserRequest =
            InlineIdentifyUserRequest(
                checkRequired("id", id),
                channelData,
                createdAt,
                preferences,
                additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is InlineIdentifyUserRequest && id == other.id && channelData == other.channelData && createdAt == other.createdAt && preferences == other.preferences && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, channelData, createdAt, preferences, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "InlineIdentifyUserRequest{id=$id, channelData=$channelData, createdAt=$createdAt, preferences=$preferences, additionalProperties=$additionalProperties}"
}
