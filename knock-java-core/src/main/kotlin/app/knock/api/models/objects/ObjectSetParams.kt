// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.core.BaseDeserializer
import app.knock.api.core.BaseSerializer
import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.Params
import app.knock.api.core.allMaxBy
import app.knock.api.core.checkKnown
import app.knock.api.core.checkRequired
import app.knock.api.core.getOrThrow
import app.knock.api.core.http.Headers
import app.knock.api.core.http.QueryParams
import app.knock.api.core.toImmutable
import app.knock.api.errors.KnockInvalidDataException
import app.knock.api.models.UnnamedSchemaWithArrayParent0
import app.knock.api.models.UnnamedSchemaWithArrayParent1
import app.knock.api.models.recipients.channeldata.DiscordChannelData
import app.knock.api.models.recipients.channeldata.MsTeamsChannelData
import app.knock.api.models.recipients.channeldata.OneSignalChannelData
import app.knock.api.models.recipients.channeldata.PushChannelData
import app.knock.api.models.recipients.channeldata.SlackChannelData
import app.knock.api.models.recipients.preferences.PreferenceSetChannelTypes
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Creates a new object or updates an existing one in the specified collection. This operation is
 * used to identify objects with their properties, as well as optional preferences and channel data.
 */
class ObjectSetParams
private constructor(
    private val collection: String,
    private val id: String,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun collection(): String = collection

    fun id(): String = id

    /**
     * A request to set channel data for a type of channel inline.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun channelData(): Optional<List<UnnamedSchemaWithArrayParent0>> = body.channelData()

    /**
     * The locale of the object. Used for [message localization](/concepts/translations).
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun locale(): Optional<String> = body.locale()

    /**
     * Inline set preferences for a recipient, where the key is the preference set name
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun preferences(): Optional<List<UnnamedSchemaWithArrayParent1>> = body.preferences()

    /**
     * The timezone of the object. Must be a valid
     * [tz database time zone string](https://en.wikipedia.org/wiki/List_of_tz_database_time_zones).
     * Used for
     * [recurring schedules](/concepts/schedules#scheduling-workflows-with-recurring-schedules-for-recipients).
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun timezone(): Optional<String> = body.timezone()

    /**
     * Returns the raw JSON value of [channelData].
     *
     * Unlike [channelData], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _channelData(): JsonField<List<UnnamedSchemaWithArrayParent0>> = body._channelData()

    /**
     * Returns the raw JSON value of [locale].
     *
     * Unlike [locale], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _locale(): JsonField<String> = body._locale()

    /**
     * Returns the raw JSON value of [preferences].
     *
     * Unlike [preferences], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _preferences(): JsonField<List<UnnamedSchemaWithArrayParent1>> = body._preferences()

    /**
     * Returns the raw JSON value of [timezone].
     *
     * Unlike [timezone], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _timezone(): JsonField<String> = body._timezone()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ObjectSetParams].
         *
         * The following fields are required:
         * ```java
         * .collection()
         * .id()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ObjectSetParams]. */
    class Builder internal constructor() {

        private var collection: String? = null
        private var id: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(objectSetParams: ObjectSetParams) = apply {
            collection = objectSetParams.collection
            id = objectSetParams.id
            body = objectSetParams.body.toBuilder()
            additionalHeaders = objectSetParams.additionalHeaders.toBuilder()
            additionalQueryParams = objectSetParams.additionalQueryParams.toBuilder()
        }

        fun collection(collection: String) = apply { this.collection = collection }

        fun id(id: String) = apply { this.id = id }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [channelData]
         * - [locale]
         * - [preferences]
         * - [timezone]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** A request to set channel data for a type of channel inline. */
        fun channelData(channelData: List<UnnamedSchemaWithArrayParent0>) = apply {
            body.channelData(channelData)
        }

        /**
         * Sets [Builder.channelData] to an arbitrary JSON value.
         *
         * You should usually call [Builder.channelData] with a well-typed
         * `List<UnnamedSchemaWithArrayParent0>` value instead. This method is primarily for setting
         * the field to an undocumented or not yet supported value.
         */
        fun channelData(channelData: JsonField<List<UnnamedSchemaWithArrayParent0>>) = apply {
            body.channelData(channelData)
        }

        /**
         * Adds a single [UnnamedSchemaWithArrayParent0] to [Builder.channelData].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addChannelData(channelData: UnnamedSchemaWithArrayParent0) = apply {
            body.addChannelData(channelData)
        }

        /** The locale of the object. Used for [message localization](/concepts/translations). */
        fun locale(locale: String?) = apply { body.locale(locale) }

        /** Alias for calling [Builder.locale] with `locale.orElse(null)`. */
        fun locale(locale: Optional<String>) = locale(locale.getOrNull())

        /**
         * Sets [Builder.locale] to an arbitrary JSON value.
         *
         * You should usually call [Builder.locale] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun locale(locale: JsonField<String>) = apply { body.locale(locale) }

        /** Inline set preferences for a recipient, where the key is the preference set name */
        fun preferences(preferences: List<UnnamedSchemaWithArrayParent1>) = apply {
            body.preferences(preferences)
        }

        /**
         * Sets [Builder.preferences] to an arbitrary JSON value.
         *
         * You should usually call [Builder.preferences] with a well-typed
         * `List<UnnamedSchemaWithArrayParent1>` value instead. This method is primarily for setting
         * the field to an undocumented or not yet supported value.
         */
        fun preferences(preferences: JsonField<List<UnnamedSchemaWithArrayParent1>>) = apply {
            body.preferences(preferences)
        }

        /**
         * Adds a single [UnnamedSchemaWithArrayParent1] to [preferences].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addPreference(preference: UnnamedSchemaWithArrayParent1) = apply {
            body.addPreference(preference)
        }

        /**
         * The timezone of the object. Must be a valid
         * [tz database time zone string](https://en.wikipedia.org/wiki/List_of_tz_database_time_zones).
         * Used for
         * [recurring schedules](/concepts/schedules#scheduling-workflows-with-recurring-schedules-for-recipients).
         */
        fun timezone(timezone: String?) = apply { body.timezone(timezone) }

        /** Alias for calling [Builder.timezone] with `timezone.orElse(null)`. */
        fun timezone(timezone: Optional<String>) = timezone(timezone.getOrNull())

        /**
         * Sets [Builder.timezone] to an arbitrary JSON value.
         *
         * You should usually call [Builder.timezone] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun timezone(timezone: JsonField<String>) = apply { body.timezone(timezone) }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [ObjectSetParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .collection()
         * .id()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ObjectSetParams =
            ObjectSetParams(
                checkRequired("collection", collection),
                checkRequired("id", id),
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> collection
            1 -> id
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /** A set of parameters to set an object with. Does not include the object id or collection. */
    class Body
    private constructor(
        private val channelData: JsonField<List<UnnamedSchemaWithArrayParent0>>,
        private val locale: JsonField<String>,
        private val preferences: JsonField<List<UnnamedSchemaWithArrayParent1>>,
        private val timezone: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("channel_data")
            @ExcludeMissing
            channelData: JsonField<List<UnnamedSchemaWithArrayParent0>> = JsonMissing.of(),
            @JsonProperty("locale") @ExcludeMissing locale: JsonField<String> = JsonMissing.of(),
            @JsonProperty("preferences")
            @ExcludeMissing
            preferences: JsonField<List<UnnamedSchemaWithArrayParent1>> = JsonMissing.of(),
            @JsonProperty("timezone") @ExcludeMissing timezone: JsonField<String> = JsonMissing.of(),
        ) : this(channelData, locale, preferences, timezone, mutableMapOf())

        /**
         * A request to set channel data for a type of channel inline.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun channelData(): Optional<List<UnnamedSchemaWithArrayParent0>> =
            channelData.getOptional("channel_data")

        /**
         * The locale of the object. Used for [message localization](/concepts/translations).
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun locale(): Optional<String> = locale.getOptional("locale")

        /**
         * Inline set preferences for a recipient, where the key is the preference set name
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun preferences(): Optional<List<UnnamedSchemaWithArrayParent1>> =
            preferences.getOptional("preferences")

        /**
         * The timezone of the object. Must be a valid
         * [tz database time zone string](https://en.wikipedia.org/wiki/List_of_tz_database_time_zones).
         * Used for
         * [recurring schedules](/concepts/schedules#scheduling-workflows-with-recurring-schedules-for-recipients).
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun timezone(): Optional<String> = timezone.getOptional("timezone")

        /**
         * Returns the raw JSON value of [channelData].
         *
         * Unlike [channelData], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("channel_data")
        @ExcludeMissing
        fun _channelData(): JsonField<List<UnnamedSchemaWithArrayParent0>> = channelData

        /**
         * Returns the raw JSON value of [locale].
         *
         * Unlike [locale], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("locale") @ExcludeMissing fun _locale(): JsonField<String> = locale

        /**
         * Returns the raw JSON value of [preferences].
         *
         * Unlike [preferences], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("preferences")
        @ExcludeMissing
        fun _preferences(): JsonField<List<UnnamedSchemaWithArrayParent1>> = preferences

        /**
         * Returns the raw JSON value of [timezone].
         *
         * Unlike [timezone], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("timezone") @ExcludeMissing fun _timezone(): JsonField<String> = timezone

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

            /** Returns a mutable builder for constructing an instance of [Body]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var channelData: JsonField<MutableList<UnnamedSchemaWithArrayParent0>>? = null
            private var locale: JsonField<String> = JsonMissing.of()
            private var preferences: JsonField<MutableList<UnnamedSchemaWithArrayParent1>>? = null
            private var timezone: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                channelData = body.channelData.map { it.toMutableList() }
                locale = body.locale
                preferences = body.preferences.map { it.toMutableList() }
                timezone = body.timezone
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** A request to set channel data for a type of channel inline. */
            fun channelData(channelData: List<UnnamedSchemaWithArrayParent0>) =
                channelData(JsonField.of(channelData))

            /**
             * Sets [Builder.channelData] to an arbitrary JSON value.
             *
             * You should usually call [Builder.channelData] with a well-typed
             * `List<UnnamedSchemaWithArrayParent0>` value instead. This method is primarily for
             * setting the field to an undocumented or not yet supported value.
             */
            fun channelData(channelData: JsonField<List<UnnamedSchemaWithArrayParent0>>) = apply {
                this.channelData = channelData.map { it.toMutableList() }
            }

            /**
             * Adds a single [UnnamedSchemaWithArrayParent0] to [Builder.channelData].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addChannelData(channelData: UnnamedSchemaWithArrayParent0) = apply {
                this.channelData =
                    (this.channelData ?: JsonField.of(mutableListOf())).also {
                        checkKnown("channelData", it).add(channelData)
                    }
            }

            /**
             * The locale of the object. Used for [message localization](/concepts/translations).
             */
            fun locale(locale: String?) = locale(JsonField.ofNullable(locale))

            /** Alias for calling [Builder.locale] with `locale.orElse(null)`. */
            fun locale(locale: Optional<String>) = locale(locale.getOrNull())

            /**
             * Sets [Builder.locale] to an arbitrary JSON value.
             *
             * You should usually call [Builder.locale] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun locale(locale: JsonField<String>) = apply { this.locale = locale }

            /** Inline set preferences for a recipient, where the key is the preference set name */
            fun preferences(preferences: List<UnnamedSchemaWithArrayParent1>) =
                preferences(JsonField.of(preferences))

            /**
             * Sets [Builder.preferences] to an arbitrary JSON value.
             *
             * You should usually call [Builder.preferences] with a well-typed
             * `List<UnnamedSchemaWithArrayParent1>` value instead. This method is primarily for
             * setting the field to an undocumented or not yet supported value.
             */
            fun preferences(preferences: JsonField<List<UnnamedSchemaWithArrayParent1>>) = apply {
                this.preferences = preferences.map { it.toMutableList() }
            }

            /**
             * Adds a single [UnnamedSchemaWithArrayParent1] to [preferences].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addPreference(preference: UnnamedSchemaWithArrayParent1) = apply {
                preferences =
                    (preferences ?: JsonField.of(mutableListOf())).also {
                        checkKnown("preferences", it).add(preference)
                    }
            }

            /**
             * The timezone of the object. Must be a valid
             * [tz database time zone string](https://en.wikipedia.org/wiki/List_of_tz_database_time_zones).
             * Used for
             * [recurring schedules](/concepts/schedules#scheduling-workflows-with-recurring-schedules-for-recipients).
             */
            fun timezone(timezone: String?) = timezone(JsonField.ofNullable(timezone))

            /** Alias for calling [Builder.timezone] with `timezone.orElse(null)`. */
            fun timezone(timezone: Optional<String>) = timezone(timezone.getOrNull())

            /**
             * Sets [Builder.timezone] to an arbitrary JSON value.
             *
             * You should usually call [Builder.timezone] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun timezone(timezone: JsonField<String>) = apply { this.timezone = timezone }

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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Body =
                Body(
                    (channelData ?: JsonMissing.of()).map { it.toImmutable() },
                    locale,
                    (preferences ?: JsonMissing.of()).map { it.toImmutable() },
                    timezone,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            channelData().ifPresent { it.forEach { it.validate() } }
            locale()
            preferences().ifPresent { it.forEach { it.validate() } }
            timezone()
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
            (channelData.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (locale.asKnown().isPresent) 1 else 0) +
                (preferences.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (timezone.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && channelData == other.channelData && locale == other.locale && preferences == other.preferences && timezone == other.timezone && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(channelData, locale, preferences, timezone, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{channelData=$channelData, locale=$locale, preferences=$preferences, timezone=$timezone, additionalProperties=$additionalProperties}"
    }

    /** A request to set channel data for a type of channel inline. */
    class UnnamedSchemaWithArrayParent0
    private constructor(
        private val channelId: JsonField<String>,
        private val data: JsonField<Data>,
        private val provider: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("channel_id")
            @ExcludeMissing
            channelId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("data") @ExcludeMissing data: JsonField<Data> = JsonMissing.of(),
            @JsonProperty("provider") @ExcludeMissing provider: JsonField<String> = JsonMissing.of(),
        ) : this(channelId, data, provider, mutableMapOf())

        /**
         * The ID of the channel to associate data with.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun channelId(): String = channelId.getRequired("channel_id")

        /**
         * Channel data for a given channel type.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun data(): Data = data.getRequired("data")

        /**
         * The provider identifier (must match the data.type value)
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun provider(): String = provider.getRequired("provider")

        /**
         * Returns the raw JSON value of [channelId].
         *
         * Unlike [channelId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("channel_id") @ExcludeMissing fun _channelId(): JsonField<String> = channelId

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Data> = data

        /**
         * Returns the raw JSON value of [provider].
         *
         * Unlike [provider], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("provider") @ExcludeMissing fun _provider(): JsonField<String> = provider

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
             * [UnnamedSchemaWithArrayParent0].
             *
             * The following fields are required:
             * ```java
             * .channelId()
             * .data()
             * .provider()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [UnnamedSchemaWithArrayParent0]. */
        class Builder internal constructor() {

            private var channelId: JsonField<String>? = null
            private var data: JsonField<Data>? = null
            private var provider: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(unnamedSchemaWithArrayParent0: UnnamedSchemaWithArrayParent0) =
                apply {
                    channelId = unnamedSchemaWithArrayParent0.channelId
                    data = unnamedSchemaWithArrayParent0.data
                    provider = unnamedSchemaWithArrayParent0.provider
                    additionalProperties =
                        unnamedSchemaWithArrayParent0.additionalProperties.toMutableMap()
                }

            /** The ID of the channel to associate data with. */
            fun channelId(channelId: String) = channelId(JsonField.of(channelId))

            /**
             * Sets [Builder.channelId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.channelId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun channelId(channelId: JsonField<String>) = apply { this.channelId = channelId }

            /** Channel data for a given channel type. */
            fun data(data: Data) = data(JsonField.of(data))

            /**
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed [Data] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun data(data: JsonField<Data>) = apply { this.data = data }

            /** Alias for calling [data] with `Data.ofPushChannel(pushChannel)`. */
            fun data(pushChannel: PushChannelData) = data(Data.ofPushChannel(pushChannel))

            /** Alias for calling [data] with `Data.ofOneSignalChannel(oneSignalChannel)`. */
            fun data(oneSignalChannel: OneSignalChannelData) =
                data(Data.ofOneSignalChannel(oneSignalChannel))

            /** Alias for calling [data] with `Data.ofSlackChannel(slackChannel)`. */
            fun data(slackChannel: SlackChannelData) = data(Data.ofSlackChannel(slackChannel))

            /** Alias for calling [data] with `Data.ofMsTeamsChannel(msTeamsChannel)`. */
            fun data(msTeamsChannel: MsTeamsChannelData) =
                data(Data.ofMsTeamsChannel(msTeamsChannel))

            /** Alias for calling [data] with `Data.ofDiscordChannel(discordChannel)`. */
            fun data(discordChannel: DiscordChannelData) =
                data(Data.ofDiscordChannel(discordChannel))

            /** The provider identifier (must match the data.type value) */
            fun provider(provider: String) = provider(JsonField.of(provider))

            /**
             * Sets [Builder.provider] to an arbitrary JSON value.
             *
             * You should usually call [Builder.provider] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun provider(provider: JsonField<String>) = apply { this.provider = provider }

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
             * Returns an immutable instance of [UnnamedSchemaWithArrayParent0].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .channelId()
             * .data()
             * .provider()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): UnnamedSchemaWithArrayParent0 =
                UnnamedSchemaWithArrayParent0(
                    checkRequired("channelId", channelId),
                    checkRequired("data", data),
                    checkRequired("provider", provider),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): UnnamedSchemaWithArrayParent0 = apply {
            if (validated) {
                return@apply
            }

            channelId()
            data().validate()
            provider()
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
            (if (channelId.asKnown().isPresent) 1 else 0) +
                (data.asKnown().getOrNull()?.validity() ?: 0) +
                (if (provider.asKnown().isPresent) 1 else 0)

        /** Channel data for a given channel type. */
        @JsonDeserialize(using = Data.Deserializer::class)
        @JsonSerialize(using = Data.Serializer::class)
        class Data
        private constructor(
            private val pushChannel: PushChannelData? = null,
            private val oneSignalChannel: OneSignalChannelData? = null,
            private val slackChannel: SlackChannelData? = null,
            private val msTeamsChannel: MsTeamsChannelData? = null,
            private val discordChannel: DiscordChannelData? = null,
            private val _json: JsonValue? = null,
        ) {

            /** The content of a push notification. */
            fun pushChannel(): Optional<PushChannelData> = Optional.ofNullable(pushChannel)

            /** OneSignal channel data. */
            fun oneSignalChannel(): Optional<OneSignalChannelData> =
                Optional.ofNullable(oneSignalChannel)

            /** Slack channel data */
            fun slackChannel(): Optional<SlackChannelData> = Optional.ofNullable(slackChannel)

            /** Microsoft Teams channel connection. */
            fun msTeamsChannel(): Optional<MsTeamsChannelData> = Optional.ofNullable(msTeamsChannel)

            /** Discord channel data. */
            fun discordChannel(): Optional<DiscordChannelData> = Optional.ofNullable(discordChannel)

            fun isPushChannel(): Boolean = pushChannel != null

            fun isOneSignalChannel(): Boolean = oneSignalChannel != null

            fun isSlackChannel(): Boolean = slackChannel != null

            fun isMsTeamsChannel(): Boolean = msTeamsChannel != null

            fun isDiscordChannel(): Boolean = discordChannel != null

            /** The content of a push notification. */
            fun asPushChannel(): PushChannelData = pushChannel.getOrThrow("pushChannel")

            /** OneSignal channel data. */
            fun asOneSignalChannel(): OneSignalChannelData =
                oneSignalChannel.getOrThrow("oneSignalChannel")

            /** Slack channel data */
            fun asSlackChannel(): SlackChannelData = slackChannel.getOrThrow("slackChannel")

            /** Microsoft Teams channel connection. */
            fun asMsTeamsChannel(): MsTeamsChannelData = msTeamsChannel.getOrThrow("msTeamsChannel")

            /** Discord channel data. */
            fun asDiscordChannel(): DiscordChannelData = discordChannel.getOrThrow("discordChannel")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    pushChannel != null -> visitor.visitPushChannel(pushChannel)
                    oneSignalChannel != null -> visitor.visitOneSignalChannel(oneSignalChannel)
                    slackChannel != null -> visitor.visitSlackChannel(slackChannel)
                    msTeamsChannel != null -> visitor.visitMsTeamsChannel(msTeamsChannel)
                    discordChannel != null -> visitor.visitDiscordChannel(discordChannel)
                    else -> visitor.unknown(_json)
                }

            private var validated: Boolean = false

            fun validate(): Data = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitPushChannel(pushChannel: PushChannelData) {
                            pushChannel.validate()
                        }

                        override fun visitOneSignalChannel(oneSignalChannel: OneSignalChannelData) {
                            oneSignalChannel.validate()
                        }

                        override fun visitSlackChannel(slackChannel: SlackChannelData) {
                            slackChannel.validate()
                        }

                        override fun visitMsTeamsChannel(msTeamsChannel: MsTeamsChannelData) {
                            msTeamsChannel.validate()
                        }

                        override fun visitDiscordChannel(discordChannel: DiscordChannelData) {
                            discordChannel.validate()
                        }
                    }
                )
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
                accept(
                    object : Visitor<Int> {
                        override fun visitPushChannel(pushChannel: PushChannelData) =
                            pushChannel.validity()

                        override fun visitOneSignalChannel(oneSignalChannel: OneSignalChannelData) =
                            oneSignalChannel.validity()

                        override fun visitSlackChannel(slackChannel: SlackChannelData) =
                            slackChannel.validity()

                        override fun visitMsTeamsChannel(msTeamsChannel: MsTeamsChannelData) =
                            msTeamsChannel.validity()

                        override fun visitDiscordChannel(discordChannel: DiscordChannelData) =
                            discordChannel.validity()

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Data && pushChannel == other.pushChannel && oneSignalChannel == other.oneSignalChannel && slackChannel == other.slackChannel && msTeamsChannel == other.msTeamsChannel && discordChannel == other.discordChannel /* spotless:on */
            }

            override fun hashCode(): Int = /* spotless:off */ Objects.hash(pushChannel, oneSignalChannel, slackChannel, msTeamsChannel, discordChannel) /* spotless:on */

            override fun toString(): String =
                when {
                    pushChannel != null -> "Data{pushChannel=$pushChannel}"
                    oneSignalChannel != null -> "Data{oneSignalChannel=$oneSignalChannel}"
                    slackChannel != null -> "Data{slackChannel=$slackChannel}"
                    msTeamsChannel != null -> "Data{msTeamsChannel=$msTeamsChannel}"
                    discordChannel != null -> "Data{discordChannel=$discordChannel}"
                    _json != null -> "Data{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid Data")
                }

            companion object {

                /** The content of a push notification. */
                @JvmStatic
                fun ofPushChannel(pushChannel: PushChannelData) = Data(pushChannel = pushChannel)

                /** OneSignal channel data. */
                @JvmStatic
                fun ofOneSignalChannel(oneSignalChannel: OneSignalChannelData) =
                    Data(oneSignalChannel = oneSignalChannel)

                /** Slack channel data */
                @JvmStatic
                fun ofSlackChannel(slackChannel: SlackChannelData) =
                    Data(slackChannel = slackChannel)

                /** Microsoft Teams channel connection. */
                @JvmStatic
                fun ofMsTeamsChannel(msTeamsChannel: MsTeamsChannelData) =
                    Data(msTeamsChannel = msTeamsChannel)

                /** Discord channel data. */
                @JvmStatic
                fun ofDiscordChannel(discordChannel: DiscordChannelData) =
                    Data(discordChannel = discordChannel)
            }

            /**
             * An interface that defines how to map each variant of [Data] to a value of type [T].
             */
            interface Visitor<out T> {

                /** The content of a push notification. */
                fun visitPushChannel(pushChannel: PushChannelData): T

                /** OneSignal channel data. */
                fun visitOneSignalChannel(oneSignalChannel: OneSignalChannelData): T

                /** Slack channel data */
                fun visitSlackChannel(slackChannel: SlackChannelData): T

                /** Microsoft Teams channel connection. */
                fun visitMsTeamsChannel(msTeamsChannel: MsTeamsChannelData): T

                /** Discord channel data. */
                fun visitDiscordChannel(discordChannel: DiscordChannelData): T

                /**
                 * Maps an unknown variant of [Data] to a value of type [T].
                 *
                 * An instance of [Data] can contain an unknown variant if it was deserialized from
                 * data that doesn't match any known variant. For example, if the SDK is on an older
                 * version than the API, then the API may respond with new variants that the SDK is
                 * unaware of.
                 *
                 * @throws KnockInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw KnockInvalidDataException("Unknown Data: $json")
                }
            }

            internal class Deserializer : BaseDeserializer<Data>(Data::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): Data {
                    val json = JsonValue.fromJsonNode(node)

                    val bestMatches =
                        sequenceOf(
                                tryDeserialize(node, jacksonTypeRef<PushChannelData>())?.let {
                                    Data(pushChannel = it, _json = json)
                                },
                                tryDeserialize(node, jacksonTypeRef<OneSignalChannelData>())?.let {
                                    Data(oneSignalChannel = it, _json = json)
                                },
                                tryDeserialize(node, jacksonTypeRef<SlackChannelData>())?.let {
                                    Data(slackChannel = it, _json = json)
                                },
                                tryDeserialize(node, jacksonTypeRef<MsTeamsChannelData>())?.let {
                                    Data(msTeamsChannel = it, _json = json)
                                },
                                tryDeserialize(node, jacksonTypeRef<DiscordChannelData>())?.let {
                                    Data(discordChannel = it, _json = json)
                                },
                            )
                            .filterNotNull()
                            .allMaxBy { it.validity() }
                            .toList()
                    return when (bestMatches.size) {
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from boolean).
                        0 -> Data(_json = json)
                        1 -> bestMatches.single()
                        // If there's more than one match with the highest validity, then use the
                        // first completely valid match, or simply the first match if none are
                        // completely valid.
                        else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                    }
                }
            }

            internal class Serializer : BaseSerializer<Data>(Data::class) {

                override fun serialize(
                    value: Data,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.pushChannel != null -> generator.writeObject(value.pushChannel)
                        value.oneSignalChannel != null ->
                            generator.writeObject(value.oneSignalChannel)
                        value.slackChannel != null -> generator.writeObject(value.slackChannel)
                        value.msTeamsChannel != null -> generator.writeObject(value.msTeamsChannel)
                        value.discordChannel != null -> generator.writeObject(value.discordChannel)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid Data")
                    }
                }
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is UnnamedSchemaWithArrayParent0 && channelId == other.channelId && data == other.data && provider == other.provider && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(channelId, data, provider, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "UnnamedSchemaWithArrayParent0{channelId=$channelId, data=$data, provider=$provider, additionalProperties=$additionalProperties}"
    }

    /** Inline set preferences for a recipient, where the key is the preference set name */
    class UnnamedSchemaWithArrayParent1
    private constructor(
        private val id: JsonField<String>,
        private val categories: JsonField<Categories>,
        private val channelTypes: JsonField<PreferenceSetChannelTypes>,
        private val workflows: JsonField<Workflows>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("categories")
            @ExcludeMissing
            categories: JsonField<Categories> = JsonMissing.of(),
            @JsonProperty("channel_types")
            @ExcludeMissing
            channelTypes: JsonField<PreferenceSetChannelTypes> = JsonMissing.of(),
            @JsonProperty("workflows")
            @ExcludeMissing
            workflows: JsonField<Workflows> = JsonMissing.of(),
        ) : this(id, categories, channelTypes, workflows, mutableMapOf())

        /**
         * The ID of the preference set
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * An object where the key is the category and the values are the preference settings for
         * that category.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun categories(): Optional<Categories> = categories.getOptional("categories")

        /**
         * Channel type preferences.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun channelTypes(): Optional<PreferenceSetChannelTypes> =
            channelTypes.getOptional("channel_types")

        /**
         * An object where the key is the workflow key and the values are the preference settings
         * for that workflow.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun workflows(): Optional<Workflows> = workflows.getOptional("workflows")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [categories].
         *
         * Unlike [categories], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("categories")
        @ExcludeMissing
        fun _categories(): JsonField<Categories> = categories

        /**
         * Returns the raw JSON value of [channelTypes].
         *
         * Unlike [channelTypes], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("channel_types")
        @ExcludeMissing
        fun _channelTypes(): JsonField<PreferenceSetChannelTypes> = channelTypes

        /**
         * Returns the raw JSON value of [workflows].
         *
         * Unlike [workflows], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("workflows")
        @ExcludeMissing
        fun _workflows(): JsonField<Workflows> = workflows

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
             * [UnnamedSchemaWithArrayParent1].
             *
             * The following fields are required:
             * ```java
             * .id()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [UnnamedSchemaWithArrayParent1]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var categories: JsonField<Categories> = JsonMissing.of()
            private var channelTypes: JsonField<PreferenceSetChannelTypes> = JsonMissing.of()
            private var workflows: JsonField<Workflows> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(unnamedSchemaWithArrayParent1: UnnamedSchemaWithArrayParent1) =
                apply {
                    id = unnamedSchemaWithArrayParent1.id
                    categories = unnamedSchemaWithArrayParent1.categories
                    channelTypes = unnamedSchemaWithArrayParent1.channelTypes
                    workflows = unnamedSchemaWithArrayParent1.workflows
                    additionalProperties =
                        unnamedSchemaWithArrayParent1.additionalProperties.toMutableMap()
                }

            /** The ID of the preference set */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /**
             * An object where the key is the category and the values are the preference settings
             * for that category.
             */
            fun categories(categories: Categories?) = categories(JsonField.ofNullable(categories))

            /** Alias for calling [Builder.categories] with `categories.orElse(null)`. */
            fun categories(categories: Optional<Categories>) = categories(categories.getOrNull())

            /**
             * Sets [Builder.categories] to an arbitrary JSON value.
             *
             * You should usually call [Builder.categories] with a well-typed [Categories] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun categories(categories: JsonField<Categories>) = apply {
                this.categories = categories
            }

            /** Channel type preferences. */
            fun channelTypes(channelTypes: PreferenceSetChannelTypes?) =
                channelTypes(JsonField.ofNullable(channelTypes))

            /** Alias for calling [Builder.channelTypes] with `channelTypes.orElse(null)`. */
            fun channelTypes(channelTypes: Optional<PreferenceSetChannelTypes>) =
                channelTypes(channelTypes.getOrNull())

            /**
             * Sets [Builder.channelTypes] to an arbitrary JSON value.
             *
             * You should usually call [Builder.channelTypes] with a well-typed
             * [PreferenceSetChannelTypes] value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
             */
            fun channelTypes(channelTypes: JsonField<PreferenceSetChannelTypes>) = apply {
                this.channelTypes = channelTypes
            }

            /**
             * An object where the key is the workflow key and the values are the preference
             * settings for that workflow.
             */
            fun workflows(workflows: Workflows?) = workflows(JsonField.ofNullable(workflows))

            /** Alias for calling [Builder.workflows] with `workflows.orElse(null)`. */
            fun workflows(workflows: Optional<Workflows>) = workflows(workflows.getOrNull())

            /**
             * Sets [Builder.workflows] to an arbitrary JSON value.
             *
             * You should usually call [Builder.workflows] with a well-typed [Workflows] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun workflows(workflows: JsonField<Workflows>) = apply { this.workflows = workflows }

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
             * Returns an immutable instance of [UnnamedSchemaWithArrayParent1].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): UnnamedSchemaWithArrayParent1 =
                UnnamedSchemaWithArrayParent1(
                    checkRequired("id", id),
                    categories,
                    channelTypes,
                    workflows,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): UnnamedSchemaWithArrayParent1 = apply {
            if (validated) {
                return@apply
            }

            id()
            categories().ifPresent { it.validate() }
            channelTypes().ifPresent { it.validate() }
            workflows().ifPresent { it.validate() }
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
                (categories.asKnown().getOrNull()?.validity() ?: 0) +
                (channelTypes.asKnown().getOrNull()?.validity() ?: 0) +
                (workflows.asKnown().getOrNull()?.validity() ?: 0)

        /**
         * An object where the key is the category and the values are the preference settings for
         * that category.
         */
        class Categories
        @JsonCreator
        private constructor(
            @com.fasterxml.jackson.annotation.JsonValue
            private val additionalProperties: Map<String, JsonValue>
        ) {

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                /** Returns a mutable builder for constructing an instance of [Categories]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Categories]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(categories: Categories) = apply {
                    additionalProperties = categories.additionalProperties.toMutableMap()
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Categories].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Categories = Categories(additionalProperties.toImmutable())
            }

            private var validated: Boolean = false

            fun validate(): Categories = apply {
                if (validated) {
                    return@apply
                }

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
                additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Categories && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() = "Categories{additionalProperties=$additionalProperties}"
        }

        /**
         * An object where the key is the workflow key and the values are the preference settings
         * for that workflow.
         */
        class Workflows
        @JsonCreator
        private constructor(
            @com.fasterxml.jackson.annotation.JsonValue
            private val additionalProperties: Map<String, JsonValue>
        ) {

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                /** Returns a mutable builder for constructing an instance of [Workflows]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Workflows]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(workflows: Workflows) = apply {
                    additionalProperties = workflows.additionalProperties.toMutableMap()
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Workflows].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Workflows = Workflows(additionalProperties.toImmutable())
            }

            private var validated: Boolean = false

            fun validate(): Workflows = apply {
                if (validated) {
                    return@apply
                }

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
                additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Workflows && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() = "Workflows{additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is UnnamedSchemaWithArrayParent1 && id == other.id && categories == other.categories && channelTypes == other.channelTypes && workflows == other.workflows && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(id, categories, channelTypes, workflows, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "UnnamedSchemaWithArrayParent1{id=$id, categories=$categories, channelTypes=$channelTypes, workflows=$workflows, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ObjectSetParams && collection == other.collection && id == other.id && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(collection, id, body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "ObjectSetParams{collection=$collection, id=$id, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
