// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models.recipients

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.knock.api.core.ExcludeMissing
import com.knock.api.core.JsonField
import com.knock.api.core.JsonMissing
import com.knock.api.core.JsonValue
import com.knock.api.core.NoAutoDetect
import com.knock.api.core.immutableEmptyMap
import com.knock.api.core.toImmutable
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Set preferences for a recipient */
@NoAutoDetect
class PreferenceSetRequest @JsonCreator private constructor(
    @JsonProperty("categories") @ExcludeMissing private val categories: JsonField<Categories> = JsonMissing.of(),
    @JsonProperty("channel_types") @ExcludeMissing private val channelTypes: JsonField<PreferenceSetChannelTypes> = JsonMissing.of(),
    @JsonProperty("workflows") @ExcludeMissing private val workflows: JsonField<Workflows> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),

) {

    /**
     * A setting for a preference set, where the key in the object is the category, and
     * the values are the preference settings for that category.
     */
    fun categories(): Optional<Categories> = Optional.ofNullable(categories.getNullable("categories"))

    /** Channel type preferences */
    fun channelTypes(): Optional<PreferenceSetChannelTypes> = Optional.ofNullable(channelTypes.getNullable("channel_types"))

    /**
     * A setting for a preference set, where the key in the object is the workflow key,
     * and the values are the preference settings for that workflow.
     */
    fun workflows(): Optional<Workflows> = Optional.ofNullable(workflows.getNullable("workflows"))

    /**
     * A setting for a preference set, where the key in the object is the category, and
     * the values are the preference settings for that category.
     */
    @JsonProperty("categories")
    @ExcludeMissing
    fun _categories(): JsonField<Categories> = categories

    /** Channel type preferences */
    @JsonProperty("channel_types")
    @ExcludeMissing
    fun _channelTypes(): JsonField<PreferenceSetChannelTypes> = channelTypes

    /**
     * A setting for a preference set, where the key in the object is the workflow key,
     * and the values are the preference settings for that workflow.
     */
    @JsonProperty("workflows")
    @ExcludeMissing
    fun _workflows(): JsonField<Workflows> = workflows

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): PreferenceSetRequest =
        apply {
            if (validated) {
              return@apply
            }

            categories().ifPresent { it.validate() }
            channelTypes().ifPresent { it.validate() }
            workflows().ifPresent { it.validate() }
            validated = true
        }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [PreferenceSetRequest].
         */
        @JvmStatic
        fun builder() = Builder()
    }

    /** A builder for [PreferenceSetRequest]. */
    class Builder internal constructor() {

        private var categories: JsonField<Categories> = JsonMissing.of()
        private var channelTypes: JsonField<PreferenceSetChannelTypes> = JsonMissing.of()
        private var workflows: JsonField<Workflows> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(preferenceSetRequest: PreferenceSetRequest) =
            apply {
                categories = preferenceSetRequest.categories
                channelTypes = preferenceSetRequest.channelTypes
                workflows = preferenceSetRequest.workflows
                additionalProperties = preferenceSetRequest.additionalProperties.toMutableMap()
            }

        /**
         * A setting for a preference set, where the key in the object is the category, and
         * the values are the preference settings for that category.
         */
        fun categories(categories: Categories?) = categories(JsonField.ofNullable(categories))

        /**
         * A setting for a preference set, where the key in the object is the category, and
         * the values are the preference settings for that category.
         */
        fun categories(categories: Optional<Categories>) = categories(categories.getOrNull())

        /**
         * A setting for a preference set, where the key in the object is the category, and
         * the values are the preference settings for that category.
         */
        fun categories(categories: JsonField<Categories>) =
            apply {
                this.categories = categories
            }

        /** Channel type preferences */
        fun channelTypes(channelTypes: PreferenceSetChannelTypes?) = channelTypes(JsonField.ofNullable(channelTypes))

        /** Channel type preferences */
        fun channelTypes(channelTypes: Optional<PreferenceSetChannelTypes>) = channelTypes(channelTypes.getOrNull())

        /** Channel type preferences */
        fun channelTypes(channelTypes: JsonField<PreferenceSetChannelTypes>) =
            apply {
                this.channelTypes = channelTypes
            }

        /**
         * A setting for a preference set, where the key in the object is the workflow key,
         * and the values are the preference settings for that workflow.
         */
        fun workflows(workflows: Workflows?) = workflows(JsonField.ofNullable(workflows))

        /**
         * A setting for a preference set, where the key in the object is the workflow key,
         * and the values are the preference settings for that workflow.
         */
        fun workflows(workflows: Optional<Workflows>) = workflows(workflows.getOrNull())

        /**
         * A setting for a preference set, where the key in the object is the workflow key,
         * and the values are the preference settings for that workflow.
         */
        fun workflows(workflows: JsonField<Workflows>) =
            apply {
                this.workflows = workflows
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

        fun build(): PreferenceSetRequest =
            PreferenceSetRequest(
              categories,
              channelTypes,
              workflows,
              additionalProperties.toImmutable(),
            )
    }

    /**
     * A setting for a preference set, where the key in the object is the category, and
     * the values are the preference settings for that category.
     */
    @NoAutoDetect
    class Categories @JsonCreator private constructor(
        @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),

    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Categories =
            apply {
                if (validated) {
                  return@apply
                }

                validated = true
            }

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Categories]. */
            @JvmStatic
            fun builder() = Builder()
        }

        /** A builder for [Categories]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(categories: Categories) =
                apply {
                    additionalProperties = categories.additionalProperties.toMutableMap()
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

    /**
     * A setting for a preference set, where the key in the object is the workflow key,
     * and the values are the preference settings for that workflow.
     */
    @NoAutoDetect
    class Workflows @JsonCreator private constructor(
        @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),

    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Workflows =
            apply {
                if (validated) {
                  return@apply
                }

                validated = true
            }

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Workflows]. */
            @JvmStatic
            fun builder() = Builder()
        }

        /** A builder for [Workflows]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(workflows: Workflows) =
                apply {
                    additionalProperties = workflows.additionalProperties.toMutableMap()
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

      return /* spotless:off */ other is PreferenceSetRequest && categories == other.categories && channelTypes == other.channelTypes && workflows == other.workflows && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(categories, channelTypes, workflows, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() = "PreferenceSetRequest{categories=$categories, channelTypes=$channelTypes, workflows=$workflows, additionalProperties=$additionalProperties}"
}
