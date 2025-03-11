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
import com.knock.api.core.checkKnown
import com.knock.api.core.checkRequired
import com.knock.api.core.immutableEmptyMap
import com.knock.api.core.toImmutable
import com.knock.api.models.Condition
import java.util.Objects

/**
 * A set of settings for a channel type. Currently, this can only be a list of conditions to apply.
 */
@NoAutoDetect
class PreferenceSetChannelTypeSetting
@JsonCreator
private constructor(
    @JsonProperty("conditions")
    @ExcludeMissing
    private val conditions: JsonField<List<Condition>> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    fun conditions(): List<Condition> = conditions.getRequired("conditions")

    @JsonProperty("conditions")
    @ExcludeMissing
    fun _conditions(): JsonField<List<Condition>> = conditions

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): PreferenceSetChannelTypeSetting = apply {
        if (validated) {
            return@apply
        }

        conditions().forEach { it.validate() }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [PreferenceSetChannelTypeSetting].
         *
         * The following fields are required:
         * ```java
         * .conditions()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [PreferenceSetChannelTypeSetting]. */
    class Builder internal constructor() {

        private var conditions: JsonField<MutableList<Condition>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(preferenceSetChannelTypeSetting: PreferenceSetChannelTypeSetting) =
            apply {
                conditions = preferenceSetChannelTypeSetting.conditions.map { it.toMutableList() }
                additionalProperties =
                    preferenceSetChannelTypeSetting.additionalProperties.toMutableMap()
            }

        fun conditions(conditions: List<Condition>) = conditions(JsonField.of(conditions))

        fun conditions(conditions: JsonField<List<Condition>>) = apply {
            this.conditions = conditions.map { it.toMutableList() }
        }

        fun addCondition(condition: Condition) = apply {
            conditions =
                (conditions ?: JsonField.of(mutableListOf())).also {
                    checkKnown("conditions", it).add(condition)
                }
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

        fun build(): PreferenceSetChannelTypeSetting =
            PreferenceSetChannelTypeSetting(
                checkRequired("conditions", conditions).map { it.toImmutable() },
                additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is PreferenceSetChannelTypeSetting && conditions == other.conditions && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(conditions, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "PreferenceSetChannelTypeSetting{conditions=$conditions, additionalProperties=$additionalProperties}"
}
