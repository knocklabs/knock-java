// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.tenants

import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.Params
import app.knock.api.core.checkRequired
import app.knock.api.core.http.Headers
import app.knock.api.core.http.QueryParams
import app.knock.api.errors.KnockInvalidDataException
import app.knock.api.models.recipients.channeldata.InlineChannelDataRequest
import app.knock.api.models.recipients.preferences.InlinePreferenceSetRequest
import app.knock.api.models.recipients.preferences.PreferenceSetRequest
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Set a tenant */
class TenantSetParams
private constructor(
    private val tenantId: String,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun tenantId(): String = tenantId

    /**
     * Allows inline setting channel data for a recipient
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun channelData(): Optional<InlineChannelDataRequest> = body.channelData()

    /**
     * Inline set preferences for a recipient, where the key is the preference set name
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun preferences(): Optional<InlinePreferenceSetRequest> = body.preferences()

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun settings(): Optional<Settings> = body.settings()

    /**
     * Returns the raw JSON value of [channelData].
     *
     * Unlike [channelData], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _channelData(): JsonField<InlineChannelDataRequest> = body._channelData()

    /**
     * Returns the raw JSON value of [preferences].
     *
     * Unlike [preferences], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _preferences(): JsonField<InlinePreferenceSetRequest> = body._preferences()

    /**
     * Returns the raw JSON value of [settings].
     *
     * Unlike [settings], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _settings(): JsonField<Settings> = body._settings()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [TenantSetParams].
         *
         * The following fields are required:
         * ```java
         * .tenantId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TenantSetParams]. */
    class Builder internal constructor() {

        private var tenantId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(tenantSetParams: TenantSetParams) = apply {
            tenantId = tenantSetParams.tenantId
            body = tenantSetParams.body.toBuilder()
            additionalHeaders = tenantSetParams.additionalHeaders.toBuilder()
            additionalQueryParams = tenantSetParams.additionalQueryParams.toBuilder()
        }

        fun tenantId(tenantId: String) = apply { this.tenantId = tenantId }

        /** Allows inline setting channel data for a recipient */
        fun channelData(channelData: InlineChannelDataRequest?) = apply {
            body.channelData(channelData)
        }

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
            body.channelData(channelData)
        }

        /** Inline set preferences for a recipient, where the key is the preference set name */
        fun preferences(preferences: InlinePreferenceSetRequest?) = apply {
            body.preferences(preferences)
        }

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
            body.preferences(preferences)
        }

        fun settings(settings: Settings) = apply { body.settings(settings) }

        /**
         * Sets [Builder.settings] to an arbitrary JSON value.
         *
         * You should usually call [Builder.settings] with a well-typed [Settings] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun settings(settings: JsonField<Settings>) = apply { body.settings(settings) }

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
         * Returns an immutable instance of [TenantSetParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .tenantId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TenantSetParams =
            TenantSetParams(
                checkRequired("tenantId", tenantId),
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    @JvmSynthetic internal fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> tenantId
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /**
     * A tenant to be set in the system. You can supply any additional properties on the tenant
     * object.
     */
    class Body
    private constructor(
        private val channelData: JsonField<InlineChannelDataRequest>,
        private val preferences: JsonField<InlinePreferenceSetRequest>,
        private val settings: JsonField<Settings>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("channel_data")
            @ExcludeMissing
            channelData: JsonField<InlineChannelDataRequest> = JsonMissing.of(),
            @JsonProperty("preferences")
            @ExcludeMissing
            preferences: JsonField<InlinePreferenceSetRequest> = JsonMissing.of(),
            @JsonProperty("settings")
            @ExcludeMissing
            settings: JsonField<Settings> = JsonMissing.of(),
        ) : this(channelData, preferences, settings, mutableMapOf())

        /**
         * Allows inline setting channel data for a recipient
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun channelData(): Optional<InlineChannelDataRequest> =
            Optional.ofNullable(channelData.getNullable("channel_data"))

        /**
         * Inline set preferences for a recipient, where the key is the preference set name
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun preferences(): Optional<InlinePreferenceSetRequest> =
            Optional.ofNullable(preferences.getNullable("preferences"))

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun settings(): Optional<Settings> = Optional.ofNullable(settings.getNullable("settings"))

        /**
         * Returns the raw JSON value of [channelData].
         *
         * Unlike [channelData], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("channel_data")
        @ExcludeMissing
        fun _channelData(): JsonField<InlineChannelDataRequest> = channelData

        /**
         * Returns the raw JSON value of [preferences].
         *
         * Unlike [preferences], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("preferences")
        @ExcludeMissing
        fun _preferences(): JsonField<InlinePreferenceSetRequest> = preferences

        /**
         * Returns the raw JSON value of [settings].
         *
         * Unlike [settings], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("settings") @ExcludeMissing fun _settings(): JsonField<Settings> = settings

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

            private var channelData: JsonField<InlineChannelDataRequest> = JsonMissing.of()
            private var preferences: JsonField<InlinePreferenceSetRequest> = JsonMissing.of()
            private var settings: JsonField<Settings> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                channelData = body.channelData
                preferences = body.preferences
                settings = body.settings
                additionalProperties = body.additionalProperties.toMutableMap()
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
             * [InlineChannelDataRequest] value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
             */
            fun channelData(channelData: JsonField<InlineChannelDataRequest>) = apply {
                this.channelData = channelData
            }

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

            fun settings(settings: Settings) = settings(JsonField.of(settings))

            /**
             * Sets [Builder.settings] to an arbitrary JSON value.
             *
             * You should usually call [Builder.settings] with a well-typed [Settings] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun settings(settings: JsonField<Settings>) = apply { this.settings = settings }

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
                Body(channelData, preferences, settings, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            channelData().ifPresent { it.validate() }
            preferences().ifPresent { it.validate() }
            settings().ifPresent { it.validate() }
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
            (channelData.asKnown().getOrNull()?.validity() ?: 0) +
                (preferences.asKnown().getOrNull()?.validity() ?: 0) +
                (settings.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && channelData == other.channelData && preferences == other.preferences && settings == other.settings && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(channelData, preferences, settings, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{channelData=$channelData, preferences=$preferences, settings=$settings, additionalProperties=$additionalProperties}"
    }

    class Settings
    private constructor(
        private val branding: JsonField<Branding>,
        private val preferenceSet: JsonField<PreferenceSetRequest>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("branding")
            @ExcludeMissing
            branding: JsonField<Branding> = JsonMissing.of(),
            @JsonProperty("preference_set")
            @ExcludeMissing
            preferenceSet: JsonField<PreferenceSetRequest> = JsonMissing.of(),
        ) : this(branding, preferenceSet, mutableMapOf())

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun branding(): Optional<Branding> = Optional.ofNullable(branding.getNullable("branding"))

        /**
         * Set preferences for a recipient
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun preferenceSet(): Optional<PreferenceSetRequest> =
            Optional.ofNullable(preferenceSet.getNullable("preference_set"))

        /**
         * Returns the raw JSON value of [branding].
         *
         * Unlike [branding], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("branding") @ExcludeMissing fun _branding(): JsonField<Branding> = branding

        /**
         * Returns the raw JSON value of [preferenceSet].
         *
         * Unlike [preferenceSet], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("preference_set")
        @ExcludeMissing
        fun _preferenceSet(): JsonField<PreferenceSetRequest> = preferenceSet

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

            /** Returns a mutable builder for constructing an instance of [Settings]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Settings]. */
        class Builder internal constructor() {

            private var branding: JsonField<Branding> = JsonMissing.of()
            private var preferenceSet: JsonField<PreferenceSetRequest> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(settings: Settings) = apply {
                branding = settings.branding
                preferenceSet = settings.preferenceSet
                additionalProperties = settings.additionalProperties.toMutableMap()
            }

            fun branding(branding: Branding) = branding(JsonField.of(branding))

            /**
             * Sets [Builder.branding] to an arbitrary JSON value.
             *
             * You should usually call [Builder.branding] with a well-typed [Branding] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun branding(branding: JsonField<Branding>) = apply { this.branding = branding }

            /** Set preferences for a recipient */
            fun preferenceSet(preferenceSet: PreferenceSetRequest?) =
                preferenceSet(JsonField.ofNullable(preferenceSet))

            /** Alias for calling [Builder.preferenceSet] with `preferenceSet.orElse(null)`. */
            fun preferenceSet(preferenceSet: Optional<PreferenceSetRequest>) =
                preferenceSet(preferenceSet.getOrNull())

            /**
             * Sets [Builder.preferenceSet] to an arbitrary JSON value.
             *
             * You should usually call [Builder.preferenceSet] with a well-typed
             * [PreferenceSetRequest] value instead. This method is primarily for setting the field
             * to an undocumented or not yet supported value.
             */
            fun preferenceSet(preferenceSet: JsonField<PreferenceSetRequest>) = apply {
                this.preferenceSet = preferenceSet
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
             * Returns an immutable instance of [Settings].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Settings =
                Settings(branding, preferenceSet, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): Settings = apply {
            if (validated) {
                return@apply
            }

            branding().ifPresent { it.validate() }
            preferenceSet().ifPresent { it.validate() }
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
            (branding.asKnown().getOrNull()?.validity() ?: 0) +
                (preferenceSet.asKnown().getOrNull()?.validity() ?: 0)

        class Branding
        private constructor(
            private val iconUrl: JsonField<String>,
            private val logoUrl: JsonField<String>,
            private val primaryColor: JsonField<String>,
            private val primaryColorContrast: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("icon_url")
                @ExcludeMissing
                iconUrl: JsonField<String> = JsonMissing.of(),
                @JsonProperty("logo_url")
                @ExcludeMissing
                logoUrl: JsonField<String> = JsonMissing.of(),
                @JsonProperty("primary_color")
                @ExcludeMissing
                primaryColor: JsonField<String> = JsonMissing.of(),
                @JsonProperty("primary_color_contrast")
                @ExcludeMissing
                primaryColorContrast: JsonField<String> = JsonMissing.of(),
            ) : this(iconUrl, logoUrl, primaryColor, primaryColorContrast, mutableMapOf())

            /**
             * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun iconUrl(): Optional<String> = Optional.ofNullable(iconUrl.getNullable("icon_url"))

            /**
             * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun logoUrl(): Optional<String> = Optional.ofNullable(logoUrl.getNullable("logo_url"))

            /**
             * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun primaryColor(): Optional<String> =
                Optional.ofNullable(primaryColor.getNullable("primary_color"))

            /**
             * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun primaryColorContrast(): Optional<String> =
                Optional.ofNullable(primaryColorContrast.getNullable("primary_color_contrast"))

            /**
             * Returns the raw JSON value of [iconUrl].
             *
             * Unlike [iconUrl], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("icon_url") @ExcludeMissing fun _iconUrl(): JsonField<String> = iconUrl

            /**
             * Returns the raw JSON value of [logoUrl].
             *
             * Unlike [logoUrl], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("logo_url") @ExcludeMissing fun _logoUrl(): JsonField<String> = logoUrl

            /**
             * Returns the raw JSON value of [primaryColor].
             *
             * Unlike [primaryColor], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("primary_color")
            @ExcludeMissing
            fun _primaryColor(): JsonField<String> = primaryColor

            /**
             * Returns the raw JSON value of [primaryColorContrast].
             *
             * Unlike [primaryColorContrast], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("primary_color_contrast")
            @ExcludeMissing
            fun _primaryColorContrast(): JsonField<String> = primaryColorContrast

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

                /** Returns a mutable builder for constructing an instance of [Branding]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Branding]. */
            class Builder internal constructor() {

                private var iconUrl: JsonField<String> = JsonMissing.of()
                private var logoUrl: JsonField<String> = JsonMissing.of()
                private var primaryColor: JsonField<String> = JsonMissing.of()
                private var primaryColorContrast: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(branding: Branding) = apply {
                    iconUrl = branding.iconUrl
                    logoUrl = branding.logoUrl
                    primaryColor = branding.primaryColor
                    primaryColorContrast = branding.primaryColorContrast
                    additionalProperties = branding.additionalProperties.toMutableMap()
                }

                fun iconUrl(iconUrl: String?) = iconUrl(JsonField.ofNullable(iconUrl))

                /** Alias for calling [Builder.iconUrl] with `iconUrl.orElse(null)`. */
                fun iconUrl(iconUrl: Optional<String>) = iconUrl(iconUrl.getOrNull())

                /**
                 * Sets [Builder.iconUrl] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.iconUrl] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun iconUrl(iconUrl: JsonField<String>) = apply { this.iconUrl = iconUrl }

                fun logoUrl(logoUrl: String?) = logoUrl(JsonField.ofNullable(logoUrl))

                /** Alias for calling [Builder.logoUrl] with `logoUrl.orElse(null)`. */
                fun logoUrl(logoUrl: Optional<String>) = logoUrl(logoUrl.getOrNull())

                /**
                 * Sets [Builder.logoUrl] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.logoUrl] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun logoUrl(logoUrl: JsonField<String>) = apply { this.logoUrl = logoUrl }

                fun primaryColor(primaryColor: String?) =
                    primaryColor(JsonField.ofNullable(primaryColor))

                /** Alias for calling [Builder.primaryColor] with `primaryColor.orElse(null)`. */
                fun primaryColor(primaryColor: Optional<String>) =
                    primaryColor(primaryColor.getOrNull())

                /**
                 * Sets [Builder.primaryColor] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.primaryColor] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun primaryColor(primaryColor: JsonField<String>) = apply {
                    this.primaryColor = primaryColor
                }

                fun primaryColorContrast(primaryColorContrast: String?) =
                    primaryColorContrast(JsonField.ofNullable(primaryColorContrast))

                /**
                 * Alias for calling [Builder.primaryColorContrast] with
                 * `primaryColorContrast.orElse(null)`.
                 */
                fun primaryColorContrast(primaryColorContrast: Optional<String>) =
                    primaryColorContrast(primaryColorContrast.getOrNull())

                /**
                 * Sets [Builder.primaryColorContrast] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.primaryColorContrast] with a well-typed [String]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun primaryColorContrast(primaryColorContrast: JsonField<String>) = apply {
                    this.primaryColorContrast = primaryColorContrast
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
                 * Returns an immutable instance of [Branding].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Branding =
                    Branding(
                        iconUrl,
                        logoUrl,
                        primaryColor,
                        primaryColorContrast,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Branding = apply {
                if (validated) {
                    return@apply
                }

                iconUrl()
                logoUrl()
                primaryColor()
                primaryColorContrast()
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
                (if (iconUrl.asKnown().isPresent) 1 else 0) +
                    (if (logoUrl.asKnown().isPresent) 1 else 0) +
                    (if (primaryColor.asKnown().isPresent) 1 else 0) +
                    (if (primaryColorContrast.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Branding && iconUrl == other.iconUrl && logoUrl == other.logoUrl && primaryColor == other.primaryColor && primaryColorContrast == other.primaryColorContrast && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(iconUrl, logoUrl, primaryColor, primaryColorContrast, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Branding{iconUrl=$iconUrl, logoUrl=$logoUrl, primaryColor=$primaryColor, primaryColorContrast=$primaryColorContrast, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Settings && branding == other.branding && preferenceSet == other.preferenceSet && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(branding, preferenceSet, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Settings{branding=$branding, preferenceSet=$preferenceSet, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is TenantSetParams && tenantId == other.tenantId && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(tenantId, body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "TenantSetParams{tenantId=$tenantId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
