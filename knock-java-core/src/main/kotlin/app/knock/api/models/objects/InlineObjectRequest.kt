// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.NoAutoDetect
import app.knock.api.core.checkRequired
import app.knock.api.core.immutableEmptyMap
import app.knock.api.core.toImmutable
import app.knock.api.models.recipients.channeldata.InlineChannelDataRequest
import app.knock.api.models.recipients.preferences.InlinePreferenceSetRequest
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.OffsetDateTime
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Inline identifies a custom object belonging to a collection */
@NoAutoDetect
class InlineObjectRequest
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("collection")
    @ExcludeMissing
    private val collection: JsonField<String> = JsonMissing.of(),
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

    fun id(): String = id.getRequired("id")

    fun collection(): String = collection.getRequired("collection")

    /** Allows inline setting channel data for a recipient */
    fun channelData(): Optional<InlineChannelDataRequest> =
        Optional.ofNullable(channelData.getNullable("channel_data"))

    fun createdAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(createdAt.getNullable("created_at"))

    /** Inline set preferences for a recipient, where the key is the preference set name */
    fun preferences(): Optional<InlinePreferenceSetRequest> =
        Optional.ofNullable(preferences.getNullable("preferences"))

    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    @JsonProperty("collection") @ExcludeMissing fun _collection(): JsonField<String> = collection

    /** Allows inline setting channel data for a recipient */
    @JsonProperty("channel_data")
    @ExcludeMissing
    fun _channelData(): JsonField<InlineChannelDataRequest> = channelData

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

    fun validate(): InlineObjectRequest = apply {
        if (validated) {
            return@apply
        }

        id()
        collection()
        channelData().ifPresent { it.validate() }
        createdAt()
        preferences().ifPresent { it.validate() }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [InlineObjectRequest].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .collection()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [InlineObjectRequest]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var collection: JsonField<String>? = null
        private var channelData: JsonField<InlineChannelDataRequest> = JsonMissing.of()
        private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var preferences: JsonField<InlinePreferenceSetRequest> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(inlineObjectRequest: InlineObjectRequest) = apply {
            id = inlineObjectRequest.id
            collection = inlineObjectRequest.collection
            channelData = inlineObjectRequest.channelData
            createdAt = inlineObjectRequest.createdAt
            preferences = inlineObjectRequest.preferences
            additionalProperties = inlineObjectRequest.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        fun id(id: JsonField<String>) = apply { this.id = id }

        fun collection(collection: String) = collection(JsonField.of(collection))

        fun collection(collection: JsonField<String>) = apply { this.collection = collection }

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

        fun createdAt(createdAt: OffsetDateTime?) = createdAt(JsonField.ofNullable(createdAt))

        fun createdAt(createdAt: Optional<OffsetDateTime>) = createdAt(createdAt.getOrNull())

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

        fun build(): InlineObjectRequest =
            InlineObjectRequest(
                checkRequired("id", id),
                checkRequired("collection", collection),
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

        return /* spotless:off */ other is InlineObjectRequest && id == other.id && collection == other.collection && channelData == other.channelData && createdAt == other.createdAt && preferences == other.preferences && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, collection, channelData, createdAt, preferences, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "InlineObjectRequest{id=$id, collection=$collection, channelData=$channelData, createdAt=$createdAt, preferences=$preferences, additionalProperties=$additionalProperties}"
}
