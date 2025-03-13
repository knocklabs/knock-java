// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.tenants

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
import app.knock.api.models.recipients.preferences.PreferenceSetRequest
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A tenant to be set in the system */
@NoAutoDetect
class TenantRequest @JsonCreator private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("channel_data") @ExcludeMissing private val channelData: JsonField<InlineChannelDataRequest> = JsonMissing.of(),
    @JsonProperty("preferences") @ExcludeMissing private val preferences: JsonField<InlinePreferenceSetRequest> = JsonMissing.of(),
    @JsonProperty("settings") @ExcludeMissing private val settings: JsonField<Settings> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),

) {

    fun id(): String = id.getRequired("id")

    /** Allows inline setting channel data for a recipient */
    fun channelData(): Optional<InlineChannelDataRequest> = Optional.ofNullable(channelData.getNullable("channel_data"))

    /** Inline set preferences for a recipient, where the key is the preference set name */
    fun preferences(): Optional<InlinePreferenceSetRequest> = Optional.ofNullable(preferences.getNullable("preferences"))

    fun settings(): Optional<Settings> = Optional.ofNullable(settings.getNullable("settings"))

    @JsonProperty("id")
    @ExcludeMissing
    fun _id(): JsonField<String> = id

    /** Allows inline setting channel data for a recipient */
    @JsonProperty("channel_data")
    @ExcludeMissing
    fun _channelData(): JsonField<InlineChannelDataRequest> = channelData

    /** Inline set preferences for a recipient, where the key is the preference set name */
    @JsonProperty("preferences")
    @ExcludeMissing
    fun _preferences(): JsonField<InlinePreferenceSetRequest> = preferences

    @JsonProperty("settings")
    @ExcludeMissing
    fun _settings(): JsonField<Settings> = settings

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): TenantRequest =
        apply {
            if (validated) {
              return@apply
            }

            id()
            channelData().ifPresent { it.validate() }
            preferences().ifPresent { it.validate() }
            settings().ifPresent { it.validate() }
            validated = true
        }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [TenantRequest].
         *
         * The following fields are required:
         *
         * ```java
         * .id()
         * ```
         */
        @JvmStatic
        fun builder() = Builder()
    }

    /** A builder for [TenantRequest]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var channelData: JsonField<InlineChannelDataRequest> = JsonMissing.of()
        private var preferences: JsonField<InlinePreferenceSetRequest> = JsonMissing.of()
        private var settings: JsonField<Settings> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(tenantRequest: TenantRequest) =
            apply {
                id = tenantRequest.id
                channelData = tenantRequest.channelData
                preferences = tenantRequest.preferences
                settings = tenantRequest.settings
                additionalProperties = tenantRequest.additionalProperties.toMutableMap()
            }

        fun id(id: String) = id(JsonField.of(id))

        fun id(id: JsonField<String>) =
            apply {
                this.id = id
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

        fun settings(settings: Settings) = settings(JsonField.of(settings))

        fun settings(settings: JsonField<Settings>) =
            apply {
                this.settings = settings
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

        fun build(): TenantRequest =
            TenantRequest(
              checkRequired(
                "id", id
              ),
              channelData,
              preferences,
              settings,
              additionalProperties.toImmutable(),
            )
    }

    @NoAutoDetect
    class Settings @JsonCreator private constructor(
        @JsonProperty("branding") @ExcludeMissing private val branding: JsonField<Branding> = JsonMissing.of(),
        @JsonProperty("preference_set") @ExcludeMissing private val preferenceSet: JsonField<PreferenceSetRequest> = JsonMissing.of(),
        @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),

    ) {

        fun branding(): Optional<Branding> = Optional.ofNullable(branding.getNullable("branding"))

        /** Set preferences for a recipient */
        fun preferenceSet(): Optional<PreferenceSetRequest> = Optional.ofNullable(preferenceSet.getNullable("preference_set"))

        @JsonProperty("branding")
        @ExcludeMissing
        fun _branding(): JsonField<Branding> = branding

        /** Set preferences for a recipient */
        @JsonProperty("preference_set")
        @ExcludeMissing
        fun _preferenceSet(): JsonField<PreferenceSetRequest> = preferenceSet

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Settings =
            apply {
                if (validated) {
                  return@apply
                }

                branding().ifPresent { it.validate() }
                preferenceSet().ifPresent { it.validate() }
                validated = true
            }

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Settings]. */
            @JvmStatic
            fun builder() = Builder()
        }

        /** A builder for [Settings]. */
        class Builder internal constructor() {

            private var branding: JsonField<Branding> = JsonMissing.of()
            private var preferenceSet: JsonField<PreferenceSetRequest> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(settings: Settings) =
                apply {
                    branding = settings.branding
                    preferenceSet = settings.preferenceSet
                    additionalProperties = settings.additionalProperties.toMutableMap()
                }

            fun branding(branding: Branding) = branding(JsonField.of(branding))

            fun branding(branding: JsonField<Branding>) =
                apply {
                    this.branding = branding
                }

            /** Set preferences for a recipient */
            fun preferenceSet(preferenceSet: PreferenceSetRequest?) = preferenceSet(JsonField.ofNullable(preferenceSet))

            /** Set preferences for a recipient */
            fun preferenceSet(preferenceSet: Optional<PreferenceSetRequest>) = preferenceSet(preferenceSet.getOrNull())

            /** Set preferences for a recipient */
            fun preferenceSet(preferenceSet: JsonField<PreferenceSetRequest>) =
                apply {
                    this.preferenceSet = preferenceSet
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

            fun build(): Settings =
                Settings(
                  branding,
                  preferenceSet,
                  additionalProperties.toImmutable(),
                )
        }

        @NoAutoDetect
        class Branding @JsonCreator private constructor(
            @JsonProperty("icon_url") @ExcludeMissing private val iconUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("logo_url") @ExcludeMissing private val logoUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("primary_color") @ExcludeMissing private val primaryColor: JsonField<String> = JsonMissing.of(),
            @JsonProperty("primary_color_contrast") @ExcludeMissing private val primaryColorContrast: JsonField<String> = JsonMissing.of(),
            @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),

        ) {

            fun iconUrl(): Optional<String> = Optional.ofNullable(iconUrl.getNullable("icon_url"))

            fun logoUrl(): Optional<String> = Optional.ofNullable(logoUrl.getNullable("logo_url"))

            fun primaryColor(): Optional<String> = Optional.ofNullable(primaryColor.getNullable("primary_color"))

            fun primaryColorContrast(): Optional<String> = Optional.ofNullable(primaryColorContrast.getNullable("primary_color_contrast"))

            @JsonProperty("icon_url")
            @ExcludeMissing
            fun _iconUrl(): JsonField<String> = iconUrl

            @JsonProperty("logo_url")
            @ExcludeMissing
            fun _logoUrl(): JsonField<String> = logoUrl

            @JsonProperty("primary_color")
            @ExcludeMissing
            fun _primaryColor(): JsonField<String> = primaryColor

            @JsonProperty("primary_color_contrast")
            @ExcludeMissing
            fun _primaryColorContrast(): JsonField<String> = primaryColorContrast

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): Branding =
                apply {
                    if (validated) {
                      return@apply
                    }

                    iconUrl()
                    logoUrl()
                    primaryColor()
                    primaryColorContrast()
                    validated = true
                }

            fun toBuilder() = Builder().from(this)

            companion object {

                /** Returns a mutable builder for constructing an instance of [Branding]. */
                @JvmStatic
                fun builder() = Builder()
            }

            /** A builder for [Branding]. */
            class Builder internal constructor() {

                private var iconUrl: JsonField<String> = JsonMissing.of()
                private var logoUrl: JsonField<String> = JsonMissing.of()
                private var primaryColor: JsonField<String> = JsonMissing.of()
                private var primaryColorContrast: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(branding: Branding) =
                    apply {
                        iconUrl = branding.iconUrl
                        logoUrl = branding.logoUrl
                        primaryColor = branding.primaryColor
                        primaryColorContrast = branding.primaryColorContrast
                        additionalProperties = branding.additionalProperties.toMutableMap()
                    }

                fun iconUrl(iconUrl: String?) = iconUrl(JsonField.ofNullable(iconUrl))

                fun iconUrl(iconUrl: Optional<String>) = iconUrl(iconUrl.getOrNull())

                fun iconUrl(iconUrl: JsonField<String>) =
                    apply {
                        this.iconUrl = iconUrl
                    }

                fun logoUrl(logoUrl: String?) = logoUrl(JsonField.ofNullable(logoUrl))

                fun logoUrl(logoUrl: Optional<String>) = logoUrl(logoUrl.getOrNull())

                fun logoUrl(logoUrl: JsonField<String>) =
                    apply {
                        this.logoUrl = logoUrl
                    }

                fun primaryColor(primaryColor: String?) = primaryColor(JsonField.ofNullable(primaryColor))

                fun primaryColor(primaryColor: Optional<String>) = primaryColor(primaryColor.getOrNull())

                fun primaryColor(primaryColor: JsonField<String>) =
                    apply {
                        this.primaryColor = primaryColor
                    }

                fun primaryColorContrast(primaryColorContrast: String?) = primaryColorContrast(JsonField.ofNullable(primaryColorContrast))

                fun primaryColorContrast(primaryColorContrast: Optional<String>) = primaryColorContrast(primaryColorContrast.getOrNull())

                fun primaryColorContrast(primaryColorContrast: JsonField<String>) =
                    apply {
                        this.primaryColorContrast = primaryColorContrast
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

                fun build(): Branding =
                    Branding(
                      iconUrl,
                      logoUrl,
                      primaryColor,
                      primaryColorContrast,
                      additionalProperties.toImmutable(),
                    )
            }

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

            override fun toString() = "Branding{iconUrl=$iconUrl, logoUrl=$logoUrl, primaryColor=$primaryColor, primaryColorContrast=$primaryColorContrast, additionalProperties=$additionalProperties}"
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

        override fun toString() = "Settings{branding=$branding, preferenceSet=$preferenceSet, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
      if (this === other) {
          return true
      }

      return /* spotless:off */ other is TenantRequest && id == other.id && channelData == other.channelData && preferences == other.preferences && settings == other.settings && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, channelData, preferences, settings, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() = "TenantRequest{id=$id, channelData=$channelData, preferences=$preferences, settings=$settings, additionalProperties=$additionalProperties}"
}
