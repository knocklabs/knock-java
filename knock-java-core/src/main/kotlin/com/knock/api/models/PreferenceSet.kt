// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.knock.api.core.ExcludeMissing
import com.knock.api.core.JsonField
import com.knock.api.core.JsonMissing
import com.knock.api.core.JsonValue
import com.knock.api.core.NoAutoDetect
import com.knock.api.core.checkRequired
import com.knock.api.core.immutableEmptyMap
import com.knock.api.core.toImmutable
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A preference set object. */
@NoAutoDetect
class PreferenceSet
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("__typename")
    @ExcludeMissing
    private val _typename: JsonField<String> = JsonMissing.of(),
    @JsonProperty("categories")
    @ExcludeMissing
    private val categories: JsonField<Categories> = JsonMissing.of(),
    @JsonProperty("channel_types")
    @ExcludeMissing
    private val channelTypes: JsonField<PreferenceSetChannelTypes> = JsonMissing.of(),
    @JsonProperty("workflows")
    @ExcludeMissing
    private val workflows: JsonField<Workflows> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    fun id(): String = id.getRequired("id")

    fun _typename(): String = _typename.getRequired("__typename")

    /** A map of categories and their settings */
    fun categories(): Optional<Categories> =
        Optional.ofNullable(categories.getNullable("categories"))

    /** Channel type preferences */
    fun channelTypes(): Optional<PreferenceSetChannelTypes> =
        Optional.ofNullable(channelTypes.getNullable("channel_types"))

    /** A map of workflows and their settings */
    fun workflows(): Optional<Workflows> = Optional.ofNullable(workflows.getNullable("workflows"))

    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    @JsonProperty("__typename") @ExcludeMissing fun __typename(): JsonField<String> = _typename

    /** A map of categories and their settings */
    @JsonProperty("categories")
    @ExcludeMissing
    fun _categories(): JsonField<Categories> = categories

    /** Channel type preferences */
    @JsonProperty("channel_types")
    @ExcludeMissing
    fun _channelTypes(): JsonField<PreferenceSetChannelTypes> = channelTypes

    /** A map of workflows and their settings */
    @JsonProperty("workflows") @ExcludeMissing fun _workflows(): JsonField<Workflows> = workflows

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): PreferenceSet = apply {
        if (validated) {
            return@apply
        }

        id()
        _typename()
        categories().ifPresent { it.validate() }
        channelTypes().ifPresent { it.validate() }
        workflows().ifPresent { it.validate() }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [PreferenceSet].
         *
         * The following fields are required:
         * ```java
         * .id()
         * ._typename()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [PreferenceSet]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var _typename: JsonField<String>? = null
        private var categories: JsonField<Categories> = JsonMissing.of()
        private var channelTypes: JsonField<PreferenceSetChannelTypes> = JsonMissing.of()
        private var workflows: JsonField<Workflows> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(preferenceSet: PreferenceSet) = apply {
            id = preferenceSet.id
            _typename = preferenceSet._typename
            categories = preferenceSet.categories
            channelTypes = preferenceSet.channelTypes
            workflows = preferenceSet.workflows
            additionalProperties = preferenceSet.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        fun id(id: JsonField<String>) = apply { this.id = id }

        fun _typename(_typename: String) = _typename(JsonField.of(_typename))

        fun _typename(_typename: JsonField<String>) = apply { this._typename = _typename }

        /** A map of categories and their settings */
        fun categories(categories: Categories?) = categories(JsonField.ofNullable(categories))

        /** A map of categories and their settings */
        fun categories(categories: Optional<Categories>) = categories(categories.getOrNull())

        /** A map of categories and their settings */
        fun categories(categories: JsonField<Categories>) = apply { this.categories = categories }

        /** Channel type preferences */
        fun channelTypes(channelTypes: PreferenceSetChannelTypes?) =
            channelTypes(JsonField.ofNullable(channelTypes))

        /** Channel type preferences */
        fun channelTypes(channelTypes: Optional<PreferenceSetChannelTypes>) =
            channelTypes(channelTypes.getOrNull())

        /** Channel type preferences */
        fun channelTypes(channelTypes: JsonField<PreferenceSetChannelTypes>) = apply {
            this.channelTypes = channelTypes
        }

        /** A map of workflows and their settings */
        fun workflows(workflows: Workflows?) = workflows(JsonField.ofNullable(workflows))

        /** A map of workflows and their settings */
        fun workflows(workflows: Optional<Workflows>) = workflows(workflows.getOrNull())

        /** A map of workflows and their settings */
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

        fun build(): PreferenceSet =
            PreferenceSet(
                checkRequired("id", id),
                checkRequired("_typename", _typename),
                categories,
                channelTypes,
                workflows,
                additionalProperties.toImmutable(),
            )
    }

    /** A map of categories and their settings */
    @NoAutoDetect
    class Categories
    @JsonCreator
    private constructor(
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap()
    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Categories = apply {
            if (validated) {
                return@apply
            }

            validated = true
        }

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

            fun build(): Categories = Categories(additionalProperties.toImmutable())
        }

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

    /** A map of workflows and their settings */
    @NoAutoDetect
    class Workflows
    @JsonCreator
    private constructor(
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap()
    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Workflows = apply {
            if (validated) {
                return@apply
            }

            validated = true
        }

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

            fun build(): Workflows = Workflows(additionalProperties.toImmutable())
        }

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

        return /* spotless:off */ other is PreferenceSet && id == other.id && _typename == other._typename && categories == other.categories && channelTypes == other.channelTypes && workflows == other.workflows && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, _typename, categories, channelTypes, workflows, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "PreferenceSet{id=$id, _typename=$_typename, categories=$categories, channelTypes=$channelTypes, workflows=$workflows, additionalProperties=$additionalProperties}"
}
