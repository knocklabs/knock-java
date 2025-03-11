// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models.objects

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.knock.api.core.ExcludeMissing
import com.knock.api.core.JsonField
import com.knock.api.core.JsonMissing
import com.knock.api.core.JsonValue
import com.knock.api.core.NoAutoDetect
import com.knock.api.core.Params
import com.knock.api.core.checkRequired
import com.knock.api.core.http.Headers
import com.knock.api.core.http.QueryParams
import com.knock.api.core.immutableEmptyMap
import com.knock.api.core.toImmutable
import com.knock.api.models.recipients.InlineChannelDataRequest
import com.knock.api.models.recipients.InlinePreferenceSetRequest
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Set (identify) an object */
class ObjectSetParams private constructor(
    private val collection: String,
    private val objectId: String,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,

) : Params {

    fun collection(): String = collection

    fun objectId(): String = objectId

    /** Allows inline setting channel data for a recipient */
    fun channelData(): Optional<InlineChannelDataRequest> = body.channelData()

    /** Inline set preferences for a recipient, where the key is the preference set name */
    fun preferences(): Optional<InlinePreferenceSetRequest> = body.preferences()

    /** Allows inline setting channel data for a recipient */
    fun _channelData(): JsonField<InlineChannelDataRequest> = body._channelData()

    /** Inline set preferences for a recipient, where the key is the preference set name */
    fun _preferences(): JsonField<InlinePreferenceSetRequest> = body._preferences()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    @JvmSynthetic
    internal fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    fun getPathParam(index: Int): String {
      return when (index) {
          0 -> collection
          1 -> objectId
          else -> ""
      }
    }

    /**
     * A set of parameters to set an object with. Does not include the object id or
     * collection.
     */
    @NoAutoDetect
    class Body @JsonCreator private constructor(
        @JsonProperty("channel_data") @ExcludeMissing private val channelData: JsonField<InlineChannelDataRequest> = JsonMissing.of(),
        @JsonProperty("preferences") @ExcludeMissing private val preferences: JsonField<InlinePreferenceSetRequest> = JsonMissing.of(),
        @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),

    ) {

        /** Allows inline setting channel data for a recipient */
        fun channelData(): Optional<InlineChannelDataRequest> = Optional.ofNullable(channelData.getNullable("channel_data"))

        /** Inline set preferences for a recipient, where the key is the preference set name */
        fun preferences(): Optional<InlinePreferenceSetRequest> = Optional.ofNullable(preferences.getNullable("preferences"))

        /** Allows inline setting channel data for a recipient */
        @JsonProperty("channel_data")
        @ExcludeMissing
        fun _channelData(): JsonField<InlineChannelDataRequest> = channelData

        /** Inline set preferences for a recipient, where the key is the preference set name */
        @JsonProperty("preferences")
        @ExcludeMissing
        fun _preferences(): JsonField<InlinePreferenceSetRequest> = preferences

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Body =
            apply {
                if (validated) {
                  return@apply
                }

                channelData().ifPresent { it.validate() }
                preferences().ifPresent { it.validate() }
                validated = true
            }

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Body]. */
            @JvmStatic
            fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var channelData: JsonField<InlineChannelDataRequest> = JsonMissing.of()
            private var preferences: JsonField<InlinePreferenceSetRequest> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) =
                apply {
                    channelData = body.channelData
                    preferences = body.preferences
                    additionalProperties = body.additionalProperties.toMutableMap()
                }

            /** Allows inline setting channel data for a recipient */
            fun channelData(channelData: InlineChannelDataRequest?) = channelData(JsonField.ofNullable(channelData))

            /** Allows inline setting channel data for a recipient */
            fun channelData(channelData: Optional<InlineChannelDataRequest>) = channelData(channelData.getOrNull())

            /** Allows inline setting channel data for a recipient */
            fun channelData(channelData: JsonField<InlineChannelDataRequest>) =
                apply {
                    this.channelData = channelData
                }

            /** Inline set preferences for a recipient, where the key is the preference set name */
            fun preferences(preferences: InlinePreferenceSetRequest?) = preferences(JsonField.ofNullable(preferences))

            /** Inline set preferences for a recipient, where the key is the preference set name */
            fun preferences(preferences: Optional<InlinePreferenceSetRequest>) = preferences(preferences.getOrNull())

            /** Inline set preferences for a recipient, where the key is the preference set name */
            fun preferences(preferences: JsonField<InlinePreferenceSetRequest>) =
                apply {
                    this.preferences = preferences
                }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

            fun putAdditionalProperty(key: String, value: JsonValue) =
                apply {
                    additionalProperties.put(key, value)
                }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                apply {
                    this.additionalProperties.putAll(additionalProperties)
                }

            fun removeAdditionalProperty(key: String) =
                apply {
                    additionalProperties.remove(key)
                }

            fun removeAllAdditionalProperties(keys: Set<String>) =
                apply {
                    keys.forEach(::removeAdditionalProperty)
                }

            fun build(): Body =
                Body(
                  channelData,
                  preferences,
                  additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return /* spotless:off */ other is Body && channelData == other.channelData && preferences == other.preferences && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(channelData, preferences, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() = "Body{channelData=$channelData, preferences=$preferences, additionalProperties=$additionalProperties}"
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ObjectSetParams].
         *
         * The following fields are required:
         *
         * ```java
         * .collection()
         * .objectId()
         * ```
         */
        @JvmStatic
        fun builder() = Builder()
    }

    /** A builder for [ObjectSetParams]. */
    @NoAutoDetect
    class Builder internal constructor() {

        private var collection: String? = null
        private var objectId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(objectSetParams: ObjectSetParams) =
            apply {
                collection = objectSetParams.collection
                objectId = objectSetParams.objectId
                body = objectSetParams.body.toBuilder()
                additionalHeaders = objectSetParams.additionalHeaders.toBuilder()
                additionalQueryParams = objectSetParams.additionalQueryParams.toBuilder()
            }

        fun collection(collection: String) =
            apply {
                this.collection = collection
            }

        fun objectId(objectId: String) =
            apply {
                this.objectId = objectId
            }

        /** Allows inline setting channel data for a recipient */
        fun channelData(channelData: InlineChannelDataRequest?) =
            apply {
                body.channelData(channelData)
            }

        /** Allows inline setting channel data for a recipient */
        fun channelData(channelData: Optional<InlineChannelDataRequest>) = channelData(channelData.getOrNull())

        /** Allows inline setting channel data for a recipient */
        fun channelData(channelData: JsonField<InlineChannelDataRequest>) =
            apply {
                body.channelData(channelData)
            }

        /** Inline set preferences for a recipient, where the key is the preference set name */
        fun preferences(preferences: InlinePreferenceSetRequest?) =
            apply {
                body.preferences(preferences)
            }

        /** Inline set preferences for a recipient, where the key is the preference set name */
        fun preferences(preferences: Optional<InlinePreferenceSetRequest>) = preferences(preferences.getOrNull())

        /** Inline set preferences for a recipient, where the key is the preference set name */
        fun preferences(preferences: JsonField<InlinePreferenceSetRequest>) =
            apply {
                body.preferences(preferences)
            }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.additionalProperties(additionalBodyProperties)
            }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) =
            apply {
                body.putAdditionalProperty(
                  key, value
                )
            }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) =
            apply {
                body.removeAdditionalProperty(key)
            }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) =
            apply {
                body.removeAllAdditionalProperties(keys)
            }

        fun additionalHeaders(additionalHeaders: Headers) =
            apply {
                this.additionalHeaders.clear()
                putAllAdditionalHeaders(additionalHeaders)
            }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) =
            apply {
                this.additionalHeaders.clear()
                putAllAdditionalHeaders(additionalHeaders)
            }

        fun putAdditionalHeader(name: String, value: String) =
            apply {
                additionalHeaders.put(name, value)
            }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) =
            apply {
                additionalHeaders.put(name, values)
            }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) =
            apply {
                this.additionalHeaders.putAll(additionalHeaders)
            }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) =
            apply {
                this.additionalHeaders.putAll(additionalHeaders)
            }

        fun replaceAdditionalHeaders(name: String, value: String) =
            apply {
                additionalHeaders.replace(name, value)
            }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) =
            apply {
                additionalHeaders.replace(name, values)
            }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) =
            apply {
                this.additionalHeaders.replaceAll(additionalHeaders)
            }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) =
            apply {
                this.additionalHeaders.replaceAll(additionalHeaders)
            }

        fun removeAdditionalHeaders(name: String) =
            apply {
                additionalHeaders.remove(name)
            }

        fun removeAllAdditionalHeaders(names: Set<String>) =
            apply {
                additionalHeaders.removeAll(names)
            }

        fun additionalQueryParams(additionalQueryParams: QueryParams) =
            apply {
                this.additionalQueryParams.clear()
                putAllAdditionalQueryParams(additionalQueryParams)
            }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.clear()
                putAllAdditionalQueryParams(additionalQueryParams)
            }

        fun putAdditionalQueryParam(key: String, value: String) =
            apply {
                additionalQueryParams.put(key, value)
            }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) =
            apply {
                additionalQueryParams.put(key, values)
            }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) =
            apply {
                additionalQueryParams.replace(key, value)
            }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) =
            apply {
                additionalQueryParams.replace(key, values)
            }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) =
            apply {
                additionalQueryParams.remove(key)
            }

        fun removeAllAdditionalQueryParams(keys: Set<String>) =
            apply {
                additionalQueryParams.removeAll(keys)
            }

        fun build(): ObjectSetParams =
            ObjectSetParams(
              checkRequired(
                "collection", collection
              ),
              checkRequired(
                "objectId", objectId
              ),
              body.build(),
              additionalHeaders.build(),
              additionalQueryParams.build(),
            )
    }

    override fun equals(other: Any?): Boolean {
      if (this === other) {
          return true
      }

      return /* spotless:off */ other is ObjectSetParams && collection == other.collection && objectId == other.objectId && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(collection, objectId, body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() = "ObjectSetParams{collection=$collection, objectId=$objectId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
