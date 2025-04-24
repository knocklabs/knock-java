// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.tenants

import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.checkRequired
import app.knock.api.errors.KnockInvalidDataException
import app.knock.api.models.recipients.preferences.PreferenceSet
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A tenant entity. */
class Tenant
private constructor(
    private val id: JsonField<String>,
    private val _typename: JsonField<String>,
    private val name: JsonField<String>,
    private val settings: JsonField<Settings>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("__typename") @ExcludeMissing _typename: JsonField<String> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("settings") @ExcludeMissing settings: JsonField<Settings> = JsonMissing.of(),
    ) : this(id, _typename, name, settings, mutableMapOf())

    /**
     * The unique identifier for the tenant.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The typename of the schema.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun _typename(): String = _typename.getRequired("__typename")

    /**
     * An optional name for the tenant.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun name(): Optional<String> = name.getOptional("name")

    /**
     * The settings for the tenant. Includes branding and preference set.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun settings(): Optional<Settings> = settings.getOptional("settings")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [_typename].
     *
     * Unlike [_typename], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("__typename") @ExcludeMissing fun __typename(): JsonField<String> = _typename

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

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

        /**
         * Returns a mutable builder for constructing an instance of [Tenant].
         *
         * The following fields are required:
         * ```java
         * .id()
         * ._typename()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Tenant]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var _typename: JsonField<String>? = null
        private var name: JsonField<String> = JsonMissing.of()
        private var settings: JsonField<Settings> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(tenant: Tenant) = apply {
            id = tenant.id
            _typename = tenant._typename
            name = tenant.name
            settings = tenant.settings
            additionalProperties = tenant.additionalProperties.toMutableMap()
        }

        /** The unique identifier for the tenant. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The typename of the schema. */
        fun _typename(_typename: String) = _typename(JsonField.of(_typename))

        /**
         * Sets [Builder._typename] to an arbitrary JSON value.
         *
         * You should usually call [Builder._typename] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun _typename(_typename: JsonField<String>) = apply { this._typename = _typename }

        /** An optional name for the tenant. */
        fun name(name: String?) = name(JsonField.ofNullable(name))

        /** Alias for calling [Builder.name] with `name.orElse(null)`. */
        fun name(name: Optional<String>) = name(name.getOrNull())

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** The settings for the tenant. Includes branding and preference set. */
        fun settings(settings: Settings?) = settings(JsonField.ofNullable(settings))

        /** Alias for calling [Builder.settings] with `settings.orElse(null)`. */
        fun settings(settings: Optional<Settings>) = settings(settings.getOrNull())

        /**
         * Sets [Builder.settings] to an arbitrary JSON value.
         *
         * You should usually call [Builder.settings] with a well-typed [Settings] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
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
         * Returns an immutable instance of [Tenant].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * ._typename()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Tenant =
            Tenant(
                checkRequired("id", id),
                checkRequired("_typename", _typename),
                name,
                settings,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): Tenant = apply {
        if (validated) {
            return@apply
        }

        id()
        _typename()
        name()
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (_typename.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (settings.asKnown().getOrNull()?.validity() ?: 0)

    /** The settings for the tenant. Includes branding and preference set. */
    class Settings
    private constructor(
        private val branding: JsonField<Branding>,
        private val preferenceSet: JsonField<PreferenceSet>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("branding")
            @ExcludeMissing
            branding: JsonField<Branding> = JsonMissing.of(),
            @JsonProperty("preference_set")
            @ExcludeMissing
            preferenceSet: JsonField<PreferenceSet> = JsonMissing.of(),
        ) : this(branding, preferenceSet, mutableMapOf())

        /**
         * The branding for the tenant.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun branding(): Optional<Branding> = branding.getOptional("branding")

        /**
         * A preference set represents a specific set of notification preferences for a recipient. A
         * recipient can have multiple preference sets.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun preferenceSet(): Optional<PreferenceSet> = preferenceSet.getOptional("preference_set")

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
        fun _preferenceSet(): JsonField<PreferenceSet> = preferenceSet

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
            private var preferenceSet: JsonField<PreferenceSet> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(settings: Settings) = apply {
                branding = settings.branding
                preferenceSet = settings.preferenceSet
                additionalProperties = settings.additionalProperties.toMutableMap()
            }

            /** The branding for the tenant. */
            fun branding(branding: Branding?) = branding(JsonField.ofNullable(branding))

            /** Alias for calling [Builder.branding] with `branding.orElse(null)`. */
            fun branding(branding: Optional<Branding>) = branding(branding.getOrNull())

            /**
             * Sets [Builder.branding] to an arbitrary JSON value.
             *
             * You should usually call [Builder.branding] with a well-typed [Branding] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun branding(branding: JsonField<Branding>) = apply { this.branding = branding }

            /**
             * A preference set represents a specific set of notification preferences for a
             * recipient. A recipient can have multiple preference sets.
             */
            fun preferenceSet(preferenceSet: PreferenceSet?) =
                preferenceSet(JsonField.ofNullable(preferenceSet))

            /** Alias for calling [Builder.preferenceSet] with `preferenceSet.orElse(null)`. */
            fun preferenceSet(preferenceSet: Optional<PreferenceSet>) =
                preferenceSet(preferenceSet.getOrNull())

            /**
             * Sets [Builder.preferenceSet] to an arbitrary JSON value.
             *
             * You should usually call [Builder.preferenceSet] with a well-typed [PreferenceSet]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun preferenceSet(preferenceSet: JsonField<PreferenceSet>) = apply {
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

        /** The branding for the tenant. */
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
             * The icon URL for the tenant. Must point to a valid image with an image MIME type.
             *
             * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun iconUrl(): Optional<String> = iconUrl.getOptional("icon_url")

            /**
             * The logo URL for the tenant. Must point to a valid image with an image MIME type.
             *
             * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun logoUrl(): Optional<String> = logoUrl.getOptional("logo_url")

            /**
             * The primary color for the tenant, provided as a hex value.
             *
             * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun primaryColor(): Optional<String> = primaryColor.getOptional("primary_color")

            /**
             * The primary color contrast for the tenant, provided as a hex value.
             *
             * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
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

                /**
                 * The icon URL for the tenant. Must point to a valid image with an image MIME type.
                 */
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

                /**
                 * The logo URL for the tenant. Must point to a valid image with an image MIME type.
                 */
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

                /** The primary color for the tenant, provided as a hex value. */
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

                /** The primary color contrast for the tenant, provided as a hex value. */
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

        return /* spotless:off */ other is Tenant && id == other.id && _typename == other._typename && name == other.name && settings == other.settings && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, _typename, name, settings, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Tenant{id=$id, _typename=$_typename, name=$name, settings=$settings, additionalProperties=$additionalProperties}"
}
