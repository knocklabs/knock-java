// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users.preferencecenter

import app.knock.api.core.Enum
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

/**
 * The preference center configuration for an environment. Controls whether the preference center is
 * enabled and defines the rows displayed in the UI.
 */
class PreferenceCenterGetConfigResponse
private constructor(
    private val accountName: JsonField<String>,
    private val branding: JsonField<Branding>,
    private val config: JsonField<Config>,
    private val enabled: JsonField<Boolean>,
    private val userEmail: JsonField<String>,
    private val knockBrandingRequired: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("account_name")
        @ExcludeMissing
        accountName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("branding") @ExcludeMissing branding: JsonField<Branding> = JsonMissing.of(),
        @JsonProperty("config") @ExcludeMissing config: JsonField<Config> = JsonMissing.of(),
        @JsonProperty("enabled") @ExcludeMissing enabled: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("user_email") @ExcludeMissing userEmail: JsonField<String> = JsonMissing.of(),
        @JsonProperty("knock_branding_required")
        @ExcludeMissing
        knockBrandingRequired: JsonField<Boolean> = JsonMissing.of(),
    ) : this(
        accountName,
        branding,
        config,
        enabled,
        userEmail,
        knockBrandingRequired,
        mutableMapOf(),
    )

    /**
     * The name of the account that the preference center is associated with.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun accountName(): Optional<String> = accountName.getOptional("account_name")

    /**
     * The branding for the preference center, sourced from public environment variables.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun branding(): Branding = branding.getRequired("branding")

    /**
     * The preference center configuration data containing the rows to display.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun config(): Config = config.getRequired("config")

    /**
     * Whether the preference center is enabled for this environment.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun enabled(): Boolean = enabled.getRequired("enabled")

    /**
     * A display label for the user that the preference center is associated with, resolved as
     * email, then user id.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun userEmail(): Optional<String> = userEmail.getOptional("user_email")

    /**
     * Whether Knock branding is required in the preference center.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun knockBrandingRequired(): Optional<Boolean> =
        knockBrandingRequired.getOptional("knock_branding_required")

    /**
     * Returns the raw JSON value of [accountName].
     *
     * Unlike [accountName], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("account_name")
    @ExcludeMissing
    fun _accountName(): JsonField<String> = accountName

    /**
     * Returns the raw JSON value of [branding].
     *
     * Unlike [branding], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("branding") @ExcludeMissing fun _branding(): JsonField<Branding> = branding

    /**
     * Returns the raw JSON value of [config].
     *
     * Unlike [config], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("config") @ExcludeMissing fun _config(): JsonField<Config> = config

    /**
     * Returns the raw JSON value of [enabled].
     *
     * Unlike [enabled], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("enabled") @ExcludeMissing fun _enabled(): JsonField<Boolean> = enabled

    /**
     * Returns the raw JSON value of [userEmail].
     *
     * Unlike [userEmail], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("user_email") @ExcludeMissing fun _userEmail(): JsonField<String> = userEmail

    /**
     * Returns the raw JSON value of [knockBrandingRequired].
     *
     * Unlike [knockBrandingRequired], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("knock_branding_required")
    @ExcludeMissing
    fun _knockBrandingRequired(): JsonField<Boolean> = knockBrandingRequired

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
         * [PreferenceCenterGetConfigResponse].
         *
         * The following fields are required:
         * ```java
         * .accountName()
         * .branding()
         * .config()
         * .enabled()
         * .userEmail()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [PreferenceCenterGetConfigResponse]. */
    class Builder internal constructor() {

        private var accountName: JsonField<String>? = null
        private var branding: JsonField<Branding>? = null
        private var config: JsonField<Config>? = null
        private var enabled: JsonField<Boolean>? = null
        private var userEmail: JsonField<String>? = null
        private var knockBrandingRequired: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(preferenceCenterGetConfigResponse: PreferenceCenterGetConfigResponse) =
            apply {
                accountName = preferenceCenterGetConfigResponse.accountName
                branding = preferenceCenterGetConfigResponse.branding
                config = preferenceCenterGetConfigResponse.config
                enabled = preferenceCenterGetConfigResponse.enabled
                userEmail = preferenceCenterGetConfigResponse.userEmail
                knockBrandingRequired = preferenceCenterGetConfigResponse.knockBrandingRequired
                additionalProperties =
                    preferenceCenterGetConfigResponse.additionalProperties.toMutableMap()
            }

        /** The name of the account that the preference center is associated with. */
        fun accountName(accountName: String?) = accountName(JsonField.ofNullable(accountName))

        /** Alias for calling [Builder.accountName] with `accountName.orElse(null)`. */
        fun accountName(accountName: Optional<String>) = accountName(accountName.getOrNull())

        /**
         * Sets [Builder.accountName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.accountName] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun accountName(accountName: JsonField<String>) = apply { this.accountName = accountName }

        /** The branding for the preference center, sourced from public environment variables. */
        fun branding(branding: Branding) = branding(JsonField.of(branding))

        /**
         * Sets [Builder.branding] to an arbitrary JSON value.
         *
         * You should usually call [Builder.branding] with a well-typed [Branding] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun branding(branding: JsonField<Branding>) = apply { this.branding = branding }

        /** The preference center configuration data containing the rows to display. */
        fun config(config: Config) = config(JsonField.of(config))

        /**
         * Sets [Builder.config] to an arbitrary JSON value.
         *
         * You should usually call [Builder.config] with a well-typed [Config] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun config(config: JsonField<Config>) = apply { this.config = config }

        /** Whether the preference center is enabled for this environment. */
        fun enabled(enabled: Boolean) = enabled(JsonField.of(enabled))

        /**
         * Sets [Builder.enabled] to an arbitrary JSON value.
         *
         * You should usually call [Builder.enabled] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun enabled(enabled: JsonField<Boolean>) = apply { this.enabled = enabled }

        /**
         * A display label for the user that the preference center is associated with, resolved as
         * email, then user id.
         */
        fun userEmail(userEmail: String?) = userEmail(JsonField.ofNullable(userEmail))

        /** Alias for calling [Builder.userEmail] with `userEmail.orElse(null)`. */
        fun userEmail(userEmail: Optional<String>) = userEmail(userEmail.getOrNull())

        /**
         * Sets [Builder.userEmail] to an arbitrary JSON value.
         *
         * You should usually call [Builder.userEmail] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun userEmail(userEmail: JsonField<String>) = apply { this.userEmail = userEmail }

        /** Whether Knock branding is required in the preference center. */
        fun knockBrandingRequired(knockBrandingRequired: Boolean) =
            knockBrandingRequired(JsonField.of(knockBrandingRequired))

        /**
         * Sets [Builder.knockBrandingRequired] to an arbitrary JSON value.
         *
         * You should usually call [Builder.knockBrandingRequired] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun knockBrandingRequired(knockBrandingRequired: JsonField<Boolean>) = apply {
            this.knockBrandingRequired = knockBrandingRequired
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
         * Returns an immutable instance of [PreferenceCenterGetConfigResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .accountName()
         * .branding()
         * .config()
         * .enabled()
         * .userEmail()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): PreferenceCenterGetConfigResponse =
            PreferenceCenterGetConfigResponse(
                checkRequired("account_name", accountName),
                checkRequired("branding", branding),
                checkRequired("config", config),
                checkRequired("enabled", enabled),
                checkRequired("user_email", userEmail),
                knockBrandingRequired,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): PreferenceCenterGetConfigResponse = apply {
        if (validated) {
            return@apply
        }

        accountName()
        branding().validate()
        config().validate()
        enabled()
        userEmail()
        knockBrandingRequired()
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
        (if (accountName.asKnown().isPresent) 1 else 0) +
            (branding.asKnown().getOrNull()?.validity() ?: 0) +
            (config.asKnown().getOrNull()?.validity() ?: 0) +
            (if (enabled.asKnown().isPresent) 1 else 0) +
            (if (userEmail.asKnown().isPresent) 1 else 0) +
            (if (knockBrandingRequired.asKnown().isPresent) 1 else 0)

    /** The branding for the preference center, sourced from public environment variables. */
    class Branding
    private constructor(
        private val iconUrl: JsonField<String>,
        private val logoUrl: JsonField<String>,
        private val primaryColor: JsonField<String>,
        private val primaryColorContrast: JsonField<String>,
        private val dark: JsonField<PreferenceCenterBrandingConfig>,
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
            @JsonProperty("dark")
            @ExcludeMissing
            dark: JsonField<PreferenceCenterBrandingConfig> = JsonMissing.of(),
        ) : this(iconUrl, logoUrl, primaryColor, primaryColorContrast, dark, mutableMapOf())

        /**
         * The icon URL for the preference center. Must point to a valid image with an image MIME
         * type.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun iconUrl(): Optional<String> = iconUrl.getOptional("icon_url")

        /**
         * The logo URL for the preference center. Must point to a valid image with an image MIME
         * type.
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
         * The branding for the preference center, sourced from public environment variables.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun dark(): Optional<PreferenceCenterBrandingConfig> = dark.getOptional("dark")

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

        /**
         * Returns the raw JSON value of [dark].
         *
         * Unlike [dark], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("dark")
        @ExcludeMissing
        fun _dark(): JsonField<PreferenceCenterBrandingConfig> = dark

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
            private var dark: JsonField<PreferenceCenterBrandingConfig> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(branding: Branding) = apply {
                iconUrl = branding.iconUrl
                logoUrl = branding.logoUrl
                primaryColor = branding.primaryColor
                primaryColorContrast = branding.primaryColorContrast
                dark = branding.dark
                additionalProperties = branding.additionalProperties.toMutableMap()
            }

            /**
             * The icon URL for the preference center. Must point to a valid image with an image
             * MIME type.
             */
            fun iconUrl(iconUrl: String?) = iconUrl(JsonField.ofNullable(iconUrl))

            /** Alias for calling [Builder.iconUrl] with `iconUrl.orElse(null)`. */
            fun iconUrl(iconUrl: Optional<String>) = iconUrl(iconUrl.getOrNull())

            /**
             * Sets [Builder.iconUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.iconUrl] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun iconUrl(iconUrl: JsonField<String>) = apply { this.iconUrl = iconUrl }

            /**
             * The logo URL for the preference center. Must point to a valid image with an image
             * MIME type.
             */
            fun logoUrl(logoUrl: String?) = logoUrl(JsonField.ofNullable(logoUrl))

            /** Alias for calling [Builder.logoUrl] with `logoUrl.orElse(null)`. */
            fun logoUrl(logoUrl: Optional<String>) = logoUrl(logoUrl.getOrNull())

            /**
             * Sets [Builder.logoUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.logoUrl] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun logoUrl(logoUrl: JsonField<String>) = apply { this.logoUrl = logoUrl }

            /** The primary color for the preference center, provided as a hex value. */
            fun primaryColor(primaryColor: String?) =
                primaryColor(JsonField.ofNullable(primaryColor))

            /** Alias for calling [Builder.primaryColor] with `primaryColor.orElse(null)`. */
            fun primaryColor(primaryColor: Optional<String>) =
                primaryColor(primaryColor.getOrNull())

            /**
             * Sets [Builder.primaryColor] to an arbitrary JSON value.
             *
             * You should usually call [Builder.primaryColor] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
             * You should usually call [Builder.primaryColorContrast] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun primaryColorContrast(primaryColorContrast: JsonField<String>) = apply {
                this.primaryColorContrast = primaryColorContrast
            }

            /**
             * The branding for the preference center, sourced from public environment variables.
             */
            fun dark(dark: PreferenceCenterBrandingConfig) = dark(JsonField.of(dark))

            /**
             * Sets [Builder.dark] to an arbitrary JSON value.
             *
             * You should usually call [Builder.dark] with a well-typed
             * [PreferenceCenterBrandingConfig] value instead. This method is primarily for setting
             * the field to an undocumented or not yet supported value.
             */
            fun dark(dark: JsonField<PreferenceCenterBrandingConfig>) = apply { this.dark = dark }

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
                    dark,
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
            dark().ifPresent { it.validate() }
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
                (if (primaryColorContrast.asKnown().isPresent) 1 else 0) +
                (dark.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Branding && iconUrl == other.iconUrl && logoUrl == other.logoUrl && primaryColor == other.primaryColor && primaryColorContrast == other.primaryColorContrast && dark == other.dark && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(iconUrl, logoUrl, primaryColor, primaryColorContrast, dark, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Branding{iconUrl=$iconUrl, logoUrl=$logoUrl, primaryColor=$primaryColor, primaryColorContrast=$primaryColorContrast, dark=$dark, additionalProperties=$additionalProperties}"
    }

    /** The preference center configuration data containing the rows to display. */
    class Config
    private constructor(
        private val body: JsonField<String>,
        private val rows: JsonField<List<Row>>,
        private val title: JsonField<String>,
        private val showAccountName: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("body") @ExcludeMissing body: JsonField<String> = JsonMissing.of(),
            @JsonProperty("rows") @ExcludeMissing rows: JsonField<List<Row>> = JsonMissing.of(),
            @JsonProperty("title") @ExcludeMissing title: JsonField<String> = JsonMissing.of(),
            @JsonProperty("show_account_name")
            @ExcludeMissing
            showAccountName: JsonField<Boolean> = JsonMissing.of(),
        ) : this(body, rows, title, showAccountName, mutableMapOf())

        /**
         * The body text displayed below the title.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun body(): String = body.getRequired("body")

        /**
         * An ordered list of rows to display in the preference center.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun rows(): List<Row> = rows.getRequired("rows")

        /**
         * The title displayed at the top of the preference center.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun title(): String = title.getRequired("title")

        /**
         * Whether the account name should be displayed in the preference center.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun showAccountName(): Optional<Boolean> = showAccountName.getOptional("show_account_name")

        /**
         * Returns the raw JSON value of [body].
         *
         * Unlike [body], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("body") @ExcludeMissing fun _body(): JsonField<String> = body

        /**
         * Returns the raw JSON value of [rows].
         *
         * Unlike [rows], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("rows") @ExcludeMissing fun _rows(): JsonField<List<Row>> = rows

        /**
         * Returns the raw JSON value of [title].
         *
         * Unlike [title], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("title") @ExcludeMissing fun _title(): JsonField<String> = title

        /**
         * Returns the raw JSON value of [showAccountName].
         *
         * Unlike [showAccountName], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("show_account_name")
        @ExcludeMissing
        fun _showAccountName(): JsonField<Boolean> = showAccountName

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
             * Returns a mutable builder for constructing an instance of [Config].
             *
             * The following fields are required:
             * ```java
             * .body()
             * .rows()
             * .title()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Config]. */
        class Builder internal constructor() {

            private var body: JsonField<String>? = null
            private var rows: JsonField<MutableList<Row>>? = null
            private var title: JsonField<String>? = null
            private var showAccountName: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(config: Config) = apply {
                body = config.body
                rows = config.rows.map { it.toMutableList() }
                title = config.title
                showAccountName = config.showAccountName
                additionalProperties = config.additionalProperties.toMutableMap()
            }

            /** The body text displayed below the title. */
            fun body(body: String) = body(JsonField.of(body))

            /**
             * Sets [Builder.body] to an arbitrary JSON value.
             *
             * You should usually call [Builder.body] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun body(body: JsonField<String>) = apply { this.body = body }

            /** An ordered list of rows to display in the preference center. */
            fun rows(rows: List<Row>) = rows(JsonField.of(rows))

            /**
             * Sets [Builder.rows] to an arbitrary JSON value.
             *
             * You should usually call [Builder.rows] with a well-typed `List<Row>` value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun rows(rows: JsonField<List<Row>>) = apply {
                this.rows = rows.map { it.toMutableList() }
            }

            /**
             * Adds a single [Row] to [rows].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addRow(row: Row) = apply {
                rows =
                    (rows ?: JsonField.of(mutableListOf())).also { checkKnown("rows", it).add(row) }
            }

            /** The title displayed at the top of the preference center. */
            fun title(title: String) = title(JsonField.of(title))

            /**
             * Sets [Builder.title] to an arbitrary JSON value.
             *
             * You should usually call [Builder.title] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun title(title: JsonField<String>) = apply { this.title = title }

            /** Whether the account name should be displayed in the preference center. */
            fun showAccountName(showAccountName: Boolean) =
                showAccountName(JsonField.of(showAccountName))

            /**
             * Sets [Builder.showAccountName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.showAccountName] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun showAccountName(showAccountName: JsonField<Boolean>) = apply {
                this.showAccountName = showAccountName
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
             * Returns an immutable instance of [Config].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .body()
             * .rows()
             * .title()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Config =
                Config(
                    checkRequired("body", body),
                    checkRequired("rows", rows).map { it.toImmutable() },
                    checkRequired("title", title),
                    showAccountName,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Config = apply {
            if (validated) {
                return@apply
            }

            body()
            rows().forEach { it.validate() }
            title()
            showAccountName()
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
            (if (body.asKnown().isPresent) 1 else 0) +
                (rows.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (title.asKnown().isPresent) 1 else 0) +
                (if (showAccountName.asKnown().isPresent) 1 else 0)

        /** A preference row in the preference center configuration. */
        class Row
        private constructor(
            private val name: JsonField<String>,
            private val type: JsonField<Type>,
            private val channelTypes: JsonField<List<ChannelType>>,
            private val description: JsonField<String>,
            private val identifier: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
                @JsonProperty("channel_types")
                @ExcludeMissing
                channelTypes: JsonField<List<ChannelType>> = JsonMissing.of(),
                @JsonProperty("description")
                @ExcludeMissing
                description: JsonField<String> = JsonMissing.of(),
                @JsonProperty("identifier")
                @ExcludeMissing
                identifier: JsonField<String> = JsonMissing.of(),
            ) : this(name, type, channelTypes, description, identifier, mutableMapOf())

            /**
             * The display name of the preference row.
             *
             * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * The type of this preference row. `workflow` targets a workflow, `channel` targets a
             * specific channel, `category` targets a workflow category, `channel_types` controls
             * per-channel-type opt-in/out, and `commercial_subscribed` is the commercial
             * notification toggle.
             *
             * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun type(): Type = type.getRequired("type")

            /**
             * The list of channel types this preference is scoped to. An empty list (or `null`)
             * means the preference applies to all channel types. Present for `workflow`,
             * `category`, and `channel_types` types.
             *
             * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun channelTypes(): Optional<List<ChannelType>> =
                channelTypes.getOptional("channel_types")

            /**
             * A description shown below the preference row name.
             *
             * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun description(): Optional<String> = description.getOptional("description")

            /**
             * The category name, workflow key, or channel ID this row controls (e.g. `marketing`,
             * `new-project-mentions`, or a channel UUID). Present for `workflow`, `channel`, and
             * `category` types.
             *
             * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun identifier(): Optional<String> = identifier.getOptional("identifier")

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [type].
             *
             * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

            /**
             * Returns the raw JSON value of [channelTypes].
             *
             * Unlike [channelTypes], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("channel_types")
            @ExcludeMissing
            fun _channelTypes(): JsonField<List<ChannelType>> = channelTypes

            /**
             * Returns the raw JSON value of [description].
             *
             * Unlike [description], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("description")
            @ExcludeMissing
            fun _description(): JsonField<String> = description

            /**
             * Returns the raw JSON value of [identifier].
             *
             * Unlike [identifier], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("identifier")
            @ExcludeMissing
            fun _identifier(): JsonField<String> = identifier

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
                 * Returns a mutable builder for constructing an instance of [Row].
                 *
                 * The following fields are required:
                 * ```java
                 * .name()
                 * .type()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Row]. */
            class Builder internal constructor() {

                private var name: JsonField<String>? = null
                private var type: JsonField<Type>? = null
                private var channelTypes: JsonField<MutableList<ChannelType>>? = null
                private var description: JsonField<String> = JsonMissing.of()
                private var identifier: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(row: Row) = apply {
                    name = row.name
                    type = row.type
                    channelTypes = row.channelTypes.map { it.toMutableList() }
                    description = row.description
                    identifier = row.identifier
                    additionalProperties = row.additionalProperties.toMutableMap()
                }

                /** The display name of the preference row. */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                /**
                 * The type of this preference row. `workflow` targets a workflow, `channel` targets
                 * a specific channel, `category` targets a workflow category, `channel_types`
                 * controls per-channel-type opt-in/out, and `commercial_subscribed` is the
                 * commercial notification toggle.
                 */
                fun type(type: Type) = type(JsonField.of(type))

                /**
                 * Sets [Builder.type] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.type] with a well-typed [Type] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonField<Type>) = apply { this.type = type }

                /**
                 * The list of channel types this preference is scoped to. An empty list (or `null`)
                 * means the preference applies to all channel types. Present for `workflow`,
                 * `category`, and `channel_types` types.
                 */
                fun channelTypes(channelTypes: List<ChannelType>?) =
                    channelTypes(JsonField.ofNullable(channelTypes))

                /** Alias for calling [Builder.channelTypes] with `channelTypes.orElse(null)`. */
                fun channelTypes(channelTypes: Optional<List<ChannelType>>) =
                    channelTypes(channelTypes.getOrNull())

                /**
                 * Sets [Builder.channelTypes] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.channelTypes] with a well-typed
                 * `List<ChannelType>` value instead. This method is primarily for setting the field
                 * to an undocumented or not yet supported value.
                 */
                fun channelTypes(channelTypes: JsonField<List<ChannelType>>) = apply {
                    this.channelTypes = channelTypes.map { it.toMutableList() }
                }

                /**
                 * Adds a single [ChannelType] to [channelTypes].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addChannelType(channelType: ChannelType) = apply {
                    channelTypes =
                        (channelTypes ?: JsonField.of(mutableListOf())).also {
                            checkKnown("channel_types", it).add(channelType)
                        }
                }

                /** A description shown below the preference row name. */
                fun description(description: String) = description(JsonField.of(description))

                /**
                 * Sets [Builder.description] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.description] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun description(description: JsonField<String>) = apply {
                    this.description = description
                }

                /**
                 * The category name, workflow key, or channel ID this row controls (e.g.
                 * `marketing`, `new-project-mentions`, or a channel UUID). Present for `workflow`,
                 * `channel`, and `category` types.
                 */
                fun identifier(identifier: String?) = identifier(JsonField.ofNullable(identifier))

                /** Alias for calling [Builder.identifier] with `identifier.orElse(null)`. */
                fun identifier(identifier: Optional<String>) = identifier(identifier.getOrNull())

                /**
                 * Sets [Builder.identifier] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.identifier] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun identifier(identifier: JsonField<String>) = apply {
                    this.identifier = identifier
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
                 * Returns an immutable instance of [Row].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .name()
                 * .type()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Row =
                    Row(
                        checkRequired("name", name),
                        checkRequired("type", type),
                        (channelTypes ?: JsonMissing.of()).map { it.toImmutable() },
                        description,
                        identifier,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Row = apply {
                if (validated) {
                    return@apply
                }

                name()
                type().validate()
                channelTypes().ifPresent { it.forEach { it.validate() } }
                description()
                identifier()
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
                (if (name.asKnown().isPresent) 1 else 0) +
                    (type.asKnown().getOrNull()?.validity() ?: 0) +
                    (channelTypes.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                    (if (description.asKnown().isPresent) 1 else 0) +
                    (if (identifier.asKnown().isPresent) 1 else 0)

            /**
             * The type of this preference row. `workflow` targets a workflow, `channel` targets a
             * specific channel, `category` targets a workflow category, `channel_types` controls
             * per-channel-type opt-in/out, and `commercial_subscribed` is the commercial
             * notification toggle.
             */
            class Type @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val WORKFLOW = of("workflow")

                    @JvmField val CHANNEL = of("channel")

                    @JvmField val CATEGORY = of("category")

                    @JvmField val CHANNEL_TYPES = of("channel_types")

                    @JvmField val COMMERCIAL_SUBSCRIBED = of("commercial_subscribed")

                    /** Not in the OpenAPI spec, but returned by the API in place of [WORKFLOW]. */
                    @JvmField val WORKFLOWS = of("workflows")

                    /** Not in the OpenAPI spec, but returned by the API in place of [CATEGORY]. */
                    @JvmField val CATEGORIES = of("categories")

                    @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                }

                /** An enum containing [Type]'s known values. */
                enum class Known {
                    WORKFLOW,
                    CHANNEL,
                    CATEGORY,
                    CHANNEL_TYPES,
                    COMMERCIAL_SUBSCRIBED,
                    WORKFLOWS,
                    CATEGORIES,
                }

                /**
                 * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Type] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    WORKFLOW,
                    CHANNEL,
                    CATEGORY,
                    CHANNEL_TYPES,
                    COMMERCIAL_SUBSCRIBED,
                    WORKFLOWS,
                    CATEGORIES,
                    /**
                     * An enum member indicating that [Type] was instantiated with an unknown value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                fun value(): Value =
                    when (this) {
                        WORKFLOW -> Value.WORKFLOW
                        CHANNEL -> Value.CHANNEL
                        CATEGORY -> Value.CATEGORY
                        CHANNEL_TYPES -> Value.CHANNEL_TYPES
                        COMMERCIAL_SUBSCRIBED -> Value.COMMERCIAL_SUBSCRIBED
                        WORKFLOWS -> Value.WORKFLOWS
                        CATEGORIES -> Value.CATEGORIES
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * Use the [value] method instead if you're uncertain the value is always known and
                 * don't want to throw for the unknown case.
                 *
                 * @throws KnockInvalidDataException if this class instance's value is a not a known
                 *   member.
                 */
                fun known(): Known =
                    when (this) {
                        WORKFLOW -> Known.WORKFLOW
                        CHANNEL -> Known.CHANNEL
                        CATEGORY -> Known.CATEGORY
                        CHANNEL_TYPES -> Known.CHANNEL_TYPES
                        COMMERCIAL_SUBSCRIBED -> Known.COMMERCIAL_SUBSCRIBED
                        WORKFLOWS -> Known.WORKFLOWS
                        CATEGORIES -> Known.CATEGORIES
                        else -> throw KnockInvalidDataException("Unknown Type: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws KnockInvalidDataException if this class instance's value does not have
                 *   the expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        KnockInvalidDataException("Value is not a String")
                    }

                private var validated: Boolean = false

                fun validate(): Type = apply {
                    if (validated) {
                        return@apply
                    }

                    known()
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
                @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is Type && value == other.value /* spotless:on */
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            class ChannelType
            @JsonCreator
            private constructor(private val value: JsonField<String>) : Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val EMAIL = of("email")

                    @JvmField val IN_APP = of("in_app")

                    @JvmField val IN_APP_FEED = of("in_app_feed")

                    @JvmField val IN_APP_GUIDE = of("in_app_guide")

                    @JvmField val SMS = of("sms")

                    @JvmField val PUSH = of("push")

                    @JvmField val CHAT = of("chat")

                    @JvmField val HTTP = of("http")

                    @JvmField val LOG = of("log")

                    @JvmField val DEFERRED_LOG = of("deferred_log")

                    @JvmStatic fun of(value: String) = ChannelType(JsonField.of(value))
                }

                /** An enum containing [ChannelType]'s known values. */
                enum class Known {
                    EMAIL,
                    IN_APP,
                    IN_APP_FEED,
                    IN_APP_GUIDE,
                    SMS,
                    PUSH,
                    CHAT,
                    HTTP,
                    LOG,
                    DEFERRED_LOG,
                }

                /**
                 * An enum containing [ChannelType]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [ChannelType] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    EMAIL,
                    IN_APP,
                    IN_APP_FEED,
                    IN_APP_GUIDE,
                    SMS,
                    PUSH,
                    CHAT,
                    HTTP,
                    LOG,
                    DEFERRED_LOG,
                    /**
                     * An enum member indicating that [ChannelType] was instantiated with an unknown
                     * value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                fun value(): Value =
                    when (this) {
                        EMAIL -> Value.EMAIL
                        IN_APP -> Value.IN_APP
                        IN_APP_FEED -> Value.IN_APP_FEED
                        IN_APP_GUIDE -> Value.IN_APP_GUIDE
                        SMS -> Value.SMS
                        PUSH -> Value.PUSH
                        CHAT -> Value.CHAT
                        HTTP -> Value.HTTP
                        LOG -> Value.LOG
                        DEFERRED_LOG -> Value.DEFERRED_LOG
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * Use the [value] method instead if you're uncertain the value is always known and
                 * don't want to throw for the unknown case.
                 *
                 * @throws KnockInvalidDataException if this class instance's value is a not a known
                 *   member.
                 */
                fun known(): Known =
                    when (this) {
                        EMAIL -> Known.EMAIL
                        IN_APP -> Known.IN_APP
                        IN_APP_FEED -> Known.IN_APP_FEED
                        IN_APP_GUIDE -> Known.IN_APP_GUIDE
                        SMS -> Known.SMS
                        PUSH -> Known.PUSH
                        CHAT -> Known.CHAT
                        HTTP -> Known.HTTP
                        LOG -> Known.LOG
                        DEFERRED_LOG -> Known.DEFERRED_LOG
                        else -> throw KnockInvalidDataException("Unknown ChannelType: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws KnockInvalidDataException if this class instance's value does not have
                 *   the expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        KnockInvalidDataException("Value is not a String")
                    }

                private var validated: Boolean = false

                fun validate(): ChannelType = apply {
                    if (validated) {
                        return@apply
                    }

                    known()
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
                @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is ChannelType && value == other.value /* spotless:on */
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Row && name == other.name && type == other.type && channelTypes == other.channelTypes && description == other.description && identifier == other.identifier && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(name, type, channelTypes, description, identifier, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Row{name=$name, type=$type, channelTypes=$channelTypes, description=$description, identifier=$identifier, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Config && body == other.body && rows == other.rows && title == other.title && showAccountName == other.showAccountName && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(body, rows, title, showAccountName, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Config{body=$body, rows=$rows, title=$title, showAccountName=$showAccountName, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is PreferenceCenterGetConfigResponse && accountName == other.accountName && branding == other.branding && config == other.config && enabled == other.enabled && userEmail == other.userEmail && knockBrandingRequired == other.knockBrandingRequired && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(accountName, branding, config, enabled, userEmail, knockBrandingRequired, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "PreferenceCenterGetConfigResponse{accountName=$accountName, branding=$branding, config=$config, enabled=$enabled, userEmail=$userEmail, knockBrandingRequired=$knockBrandingRequired, additionalProperties=$additionalProperties}"
}
