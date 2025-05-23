// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users.feeds

import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.checkRequired
import app.knock.api.errors.KnockInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** The response for the user's feed settings. */
class FeedGetSettingsResponse
private constructor(
    private val features: JsonField<Features>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("features") @ExcludeMissing features: JsonField<Features> = JsonMissing.of()
    ) : this(features, mutableMapOf())

    /**
     * Features configuration for the user's feed.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun features(): Features = features.getRequired("features")

    /**
     * Returns the raw JSON value of [features].
     *
     * Unlike [features], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("features") @ExcludeMissing fun _features(): JsonField<Features> = features

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
         * Returns a mutable builder for constructing an instance of [FeedGetSettingsResponse].
         *
         * The following fields are required:
         * ```java
         * .features()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FeedGetSettingsResponse]. */
    class Builder internal constructor() {

        private var features: JsonField<Features>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(feedGetSettingsResponse: FeedGetSettingsResponse) = apply {
            features = feedGetSettingsResponse.features
            additionalProperties = feedGetSettingsResponse.additionalProperties.toMutableMap()
        }

        /** Features configuration for the user's feed. */
        fun features(features: Features) = features(JsonField.of(features))

        /**
         * Sets [Builder.features] to an arbitrary JSON value.
         *
         * You should usually call [Builder.features] with a well-typed [Features] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun features(features: JsonField<Features>) = apply { this.features = features }

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
         * Returns an immutable instance of [FeedGetSettingsResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .features()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FeedGetSettingsResponse =
            FeedGetSettingsResponse(
                checkRequired("features", features),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): FeedGetSettingsResponse = apply {
        if (validated) {
            return@apply
        }

        features().validate()
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
    @JvmSynthetic internal fun validity(): Int = (features.asKnown().getOrNull()?.validity() ?: 0)

    /** Features configuration for the user's feed. */
    class Features
    private constructor(
        private val brandingRequired: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("branding_required")
            @ExcludeMissing
            brandingRequired: JsonField<Boolean> = JsonMissing.of()
        ) : this(brandingRequired, mutableMapOf())

        /**
         * Whether branding is required for the user's feed.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun brandingRequired(): Boolean = brandingRequired.getRequired("branding_required")

        /**
         * Returns the raw JSON value of [brandingRequired].
         *
         * Unlike [brandingRequired], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("branding_required")
        @ExcludeMissing
        fun _brandingRequired(): JsonField<Boolean> = brandingRequired

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
             * Returns a mutable builder for constructing an instance of [Features].
             *
             * The following fields are required:
             * ```java
             * .brandingRequired()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Features]. */
        class Builder internal constructor() {

            private var brandingRequired: JsonField<Boolean>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(features: Features) = apply {
                brandingRequired = features.brandingRequired
                additionalProperties = features.additionalProperties.toMutableMap()
            }

            /** Whether branding is required for the user's feed. */
            fun brandingRequired(brandingRequired: Boolean) =
                brandingRequired(JsonField.of(brandingRequired))

            /**
             * Sets [Builder.brandingRequired] to an arbitrary JSON value.
             *
             * You should usually call [Builder.brandingRequired] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun brandingRequired(brandingRequired: JsonField<Boolean>) = apply {
                this.brandingRequired = brandingRequired
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
             * Returns an immutable instance of [Features].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .brandingRequired()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Features =
                Features(
                    checkRequired("brandingRequired", brandingRequired),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Features = apply {
            if (validated) {
                return@apply
            }

            brandingRequired()
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
        internal fun validity(): Int = (if (brandingRequired.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Features && brandingRequired == other.brandingRequired && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(brandingRequired, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Features{brandingRequired=$brandingRequired, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FeedGetSettingsResponse && features == other.features && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(features, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FeedGetSettingsResponse{features=$features, additionalProperties=$additionalProperties}"
}
