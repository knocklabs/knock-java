// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.recipients.preferences

import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
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

/** A request to set a preference set for a recipient. */
class PreferenceSetRequest
private constructor(
    private val categories: JsonField<Categories>,
    private val channelTypes: JsonField<PreferenceSetChannelTypes>,
    private val workflows: JsonField<Workflows>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("categories")
        @ExcludeMissing
        categories: JsonField<Categories> = JsonMissing.of(),
        @JsonProperty("channel_types")
        @ExcludeMissing
        channelTypes: JsonField<PreferenceSetChannelTypes> = JsonMissing.of(),
        @JsonProperty("workflows")
        @ExcludeMissing
        workflows: JsonField<Workflows> = JsonMissing.of(),
    ) : this(categories, channelTypes, workflows, mutableMapOf())

    /**
     * A setting for a preference set, where the key in the object is the category, and the values
     * are the preference settings for that category.
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
     * A setting for a preference set, where the key in the object is the workflow key, and the
     * values are the preference settings for that workflow.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun workflows(): Optional<Workflows> = workflows.getOptional("workflows")

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
     * Unlike [channelTypes], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("channel_types")
    @ExcludeMissing
    fun _channelTypes(): JsonField<PreferenceSetChannelTypes> = channelTypes

    /**
     * Returns the raw JSON value of [workflows].
     *
     * Unlike [workflows], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("workflows") @ExcludeMissing fun _workflows(): JsonField<Workflows> = workflows

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

        /** Returns a mutable builder for constructing an instance of [PreferenceSetRequest]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [PreferenceSetRequest]. */
    class Builder internal constructor() {

        private var categories: JsonField<Categories> = JsonMissing.of()
        private var channelTypes: JsonField<PreferenceSetChannelTypes> = JsonMissing.of()
        private var workflows: JsonField<Workflows> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(preferenceSetRequest: PreferenceSetRequest) = apply {
            categories = preferenceSetRequest.categories
            channelTypes = preferenceSetRequest.channelTypes
            workflows = preferenceSetRequest.workflows
            additionalProperties = preferenceSetRequest.additionalProperties.toMutableMap()
        }

        /**
         * A setting for a preference set, where the key in the object is the category, and the
         * values are the preference settings for that category.
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
        fun categories(categories: JsonField<Categories>) = apply { this.categories = categories }

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
         * [PreferenceSetChannelTypes] value instead. This method is primarily for setting the field
         * to an undocumented or not yet supported value.
         */
        fun channelTypes(channelTypes: JsonField<PreferenceSetChannelTypes>) = apply {
            this.channelTypes = channelTypes
        }

        /**
         * A setting for a preference set, where the key in the object is the workflow key, and the
         * values are the preference settings for that workflow.
         */
        fun workflows(workflows: Workflows?) = workflows(JsonField.ofNullable(workflows))

        /** Alias for calling [Builder.workflows] with `workflows.orElse(null)`. */
        fun workflows(workflows: Optional<Workflows>) = workflows(workflows.getOrNull())

        /**
         * Sets [Builder.workflows] to an arbitrary JSON value.
         *
         * You should usually call [Builder.workflows] with a well-typed [Workflows] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
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
         * Returns an immutable instance of [PreferenceSetRequest].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): PreferenceSetRequest =
            PreferenceSetRequest(
                categories,
                channelTypes,
                workflows,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): PreferenceSetRequest = apply {
        if (validated) {
            return@apply
        }

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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (categories.asKnown().getOrNull()?.validity() ?: 0) +
            (channelTypes.asKnown().getOrNull()?.validity() ?: 0) +
            (workflows.asKnown().getOrNull()?.validity() ?: 0)

    /**
     * A setting for a preference set, where the key in the object is the category, and the values
     * are the preference settings for that category.
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

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

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
     * A setting for a preference set, where the key in the object is the workflow key, and the
     * values are the preference settings for that workflow.
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

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

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

        return /* spotless:off */ other is PreferenceSetRequest && categories == other.categories && channelTypes == other.channelTypes && workflows == other.workflows && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(categories, channelTypes, workflows, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "PreferenceSetRequest{categories=$categories, channelTypes=$channelTypes, workflows=$workflows, additionalProperties=$additionalProperties}"
}
