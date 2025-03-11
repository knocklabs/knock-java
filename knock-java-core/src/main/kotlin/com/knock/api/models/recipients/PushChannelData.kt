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
import java.util.Objects

/** Channel data for push providers */
@NoAutoDetect
class PushChannelData
@JsonCreator
private constructor(
    @JsonProperty("tokens")
    @ExcludeMissing
    private val tokens: JsonField<List<String>> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    fun tokens(): List<String> = tokens.getRequired("tokens")

    @JsonProperty("tokens") @ExcludeMissing fun _tokens(): JsonField<List<String>> = tokens

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): PushChannelData = apply {
        if (validated) {
            return@apply
        }

        tokens()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [PushChannelData].
         *
         * The following fields are required:
         * ```java
         * .tokens()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [PushChannelData]. */
    class Builder internal constructor() {

        private var tokens: JsonField<MutableList<String>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(pushChannelData: PushChannelData) = apply {
            tokens = pushChannelData.tokens.map { it.toMutableList() }
            additionalProperties = pushChannelData.additionalProperties.toMutableMap()
        }

        fun tokens(tokens: List<String>) = tokens(JsonField.of(tokens))

        fun tokens(tokens: JsonField<List<String>>) = apply {
            this.tokens = tokens.map { it.toMutableList() }
        }

        fun addToken(token: String) = apply {
            tokens =
                (tokens ?: JsonField.of(mutableListOf())).also {
                    checkKnown("tokens", it).add(token)
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

        fun build(): PushChannelData =
            PushChannelData(
                checkRequired("tokens", tokens).map { it.toImmutable() },
                additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is PushChannelData && tokens == other.tokens && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(tokens, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "PushChannelData{tokens=$tokens, additionalProperties=$additionalProperties}"
}
