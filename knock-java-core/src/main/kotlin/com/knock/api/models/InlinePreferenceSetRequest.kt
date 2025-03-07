// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.knock.api.core.ExcludeMissing
import com.knock.api.core.JsonValue
import com.knock.api.core.NoAutoDetect
import com.knock.api.core.immutableEmptyMap
import com.knock.api.core.toImmutable
import java.util.Objects

/** Inline set preferences for a recipient, where the key is the preference set name */
@NoAutoDetect
class InlinePreferenceSetRequest
@JsonCreator
private constructor(
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap()
) {

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): InlinePreferenceSetRequest = apply {
        if (validated) {
            return@apply
        }

        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [InlinePreferenceSetRequest].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [InlinePreferenceSetRequest]. */
    class Builder internal constructor() {

        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(inlinePreferenceSetRequest: InlinePreferenceSetRequest) = apply {
            additionalProperties = inlinePreferenceSetRequest.additionalProperties.toMutableMap()
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

        fun build(): InlinePreferenceSetRequest =
            InlinePreferenceSetRequest(additionalProperties.toImmutable())
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is InlinePreferenceSetRequest && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "InlinePreferenceSetRequest{additionalProperties=$additionalProperties}"
}
