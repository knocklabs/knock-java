// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.recipients.channeldata

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
import kotlin.jvm.optionals.getOrNull

/** The content of a push notification. */
class PushChannelData
private constructor(
    private val tokens: JsonField<List<String>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("tokens") @ExcludeMissing tokens: JsonField<List<String>> = JsonMissing.of()
    ) : this(tokens, mutableMapOf())

    /**
     * A list of push channel tokens.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun tokens(): List<String> = tokens.getRequired("tokens")

    /**
     * Returns the raw JSON value of [tokens].
     *
     * Unlike [tokens], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tokens") @ExcludeMissing fun _tokens(): JsonField<List<String>> = tokens

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

        /** A list of push channel tokens. */
        fun tokens(tokens: List<String>) = tokens(JsonField.of(tokens))

        /**
         * Sets [Builder.tokens] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tokens] with a well-typed `List<String>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun tokens(tokens: JsonField<List<String>>) = apply {
            this.tokens = tokens.map { it.toMutableList() }
        }

        /**
         * Adds a single [String] to [tokens].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
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

        /**
         * Returns an immutable instance of [PushChannelData].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .tokens()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): PushChannelData =
            PushChannelData(
                checkRequired("tokens", tokens).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): PushChannelData = apply {
        if (validated) {
            return@apply
        }

        tokens()
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
    @JvmSynthetic internal fun validity(): Int = (tokens.asKnown().getOrNull()?.size ?: 0)

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
