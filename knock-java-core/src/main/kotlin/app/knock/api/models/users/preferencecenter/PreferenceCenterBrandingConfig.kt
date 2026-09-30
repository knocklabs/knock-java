// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users.preferencecenter

import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.errors.KnockInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** The branding for the preference center, sourced from public environment variables. */
class PreferenceCenterBrandingConfig
private constructor(
    private val iconUrl: JsonField<String>,
    private val logoUrl: JsonField<String>,
    private val primaryColor: JsonField<String>,
    private val primaryColorContrast: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("icon_url") @ExcludeMissing iconUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("logo_url") @ExcludeMissing logoUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("primary_color")
        @ExcludeMissing
        primaryColor: JsonField<String> = JsonMissing.of(),
        @JsonProperty("primary_color_contrast")
        @ExcludeMissing
        primaryColorContrast: JsonField<String> = JsonMissing.of(),
    ) : this(iconUrl, logoUrl, primaryColor, primaryColorContrast, mutableMapOf())

    /**
     * The icon URL for the preference center. Must point to a valid image with an image MIME type.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun iconUrl(): Optional<String> = iconUrl.getOptional("icon_url")

    /**
     * The logo URL for the preference center. Must point to a valid image with an image MIME type.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun logoUrl(): Optional<String> = logoUrl.getOptional("logo_url")

    /**
     * The primary color for the preference center, provided as a hex value.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun primaryColor(): Optional<String> = primaryColor.getOptional("primary_color")

    /**
     * The primary color contrast for the preference center, provided as a hex value.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun primaryColorContrast(): Optional<String> =
        primaryColorContrast.getOptional("primary_color_contrast")

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
     * Unlike [primaryColor], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("primary_color")
    @ExcludeMissing
    fun _primaryColor(): JsonField<String> = primaryColor

    /**
     * Returns the raw JSON value of [primaryColorContrast].
     *
     * Unlike [primaryColorContrast], this method doesn't throw if the JSON field has an unexpected
     * type.
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

        /**
         * Returns a mutable builder for constructing an instance of
         * [PreferenceCenterBrandingConfig].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [PreferenceCenterBrandingConfig]. */
    class Builder internal constructor() {

        private var iconUrl: JsonField<String> = JsonMissing.of()
        private var logoUrl: JsonField<String> = JsonMissing.of()
        private var primaryColor: JsonField<String> = JsonMissing.of()
        private var primaryColorContrast: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(preferenceCenterBrandingConfig: PreferenceCenterBrandingConfig) = apply {
            iconUrl = preferenceCenterBrandingConfig.iconUrl
            logoUrl = preferenceCenterBrandingConfig.logoUrl
            primaryColor = preferenceCenterBrandingConfig.primaryColor
            primaryColorContrast = preferenceCenterBrandingConfig.primaryColorContrast
            additionalProperties =
                preferenceCenterBrandingConfig.additionalProperties.toMutableMap()
        }

        /**
         * The icon URL for the preference center. Must point to a valid image with an image MIME
         * type.
         */
        fun iconUrl(iconUrl: String?) = iconUrl(JsonField.ofNullable(iconUrl))

        /** Alias for calling [Builder.iconUrl] with `iconUrl.orElse(null)`. */
        fun iconUrl(iconUrl: Optional<String>) = iconUrl(iconUrl.getOrNull())

        /**
         * Sets [Builder.iconUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.iconUrl] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun iconUrl(iconUrl: JsonField<String>) = apply { this.iconUrl = iconUrl }

        /**
         * The logo URL for the preference center. Must point to a valid image with an image MIME
         * type.
         */
        fun logoUrl(logoUrl: String?) = logoUrl(JsonField.ofNullable(logoUrl))

        /** Alias for calling [Builder.logoUrl] with `logoUrl.orElse(null)`. */
        fun logoUrl(logoUrl: Optional<String>) = logoUrl(logoUrl.getOrNull())

        /**
         * Sets [Builder.logoUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.logoUrl] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun logoUrl(logoUrl: JsonField<String>) = apply { this.logoUrl = logoUrl }

        /** The primary color for the preference center, provided as a hex value. */
        fun primaryColor(primaryColor: String?) = primaryColor(JsonField.ofNullable(primaryColor))

        /** Alias for calling [Builder.primaryColor] with `primaryColor.orElse(null)`. */
        fun primaryColor(primaryColor: Optional<String>) = primaryColor(primaryColor.getOrNull())

        /**
         * Sets [Builder.primaryColor] to an arbitrary JSON value.
         *
         * You should usually call [Builder.primaryColor] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun primaryColor(primaryColor: JsonField<String>) = apply {
            this.primaryColor = primaryColor
        }

        /** The primary color contrast for the preference center, provided as a hex value. */
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
         * You should usually call [Builder.primaryColorContrast] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
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

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        /**
         * Returns an immutable instance of [PreferenceCenterBrandingConfig].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): PreferenceCenterBrandingConfig =
            PreferenceCenterBrandingConfig(
                iconUrl,
                logoUrl,
                primaryColor,
                primaryColorContrast,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): PreferenceCenterBrandingConfig = apply {
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
     * Returns a score indicating how many valid values are contained in this object recursively.
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

        return /* spotless:off */ other is PreferenceCenterBrandingConfig && iconUrl == other.iconUrl && logoUrl == other.logoUrl && primaryColor == other.primaryColor && primaryColorContrast == other.primaryColorContrast && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(iconUrl, logoUrl, primaryColor, primaryColorContrast, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "PreferenceCenterBrandingConfig{iconUrl=$iconUrl, logoUrl=$logoUrl, primaryColor=$primaryColor, primaryColorContrast=$primaryColorContrast, additionalProperties=$additionalProperties}"
}
