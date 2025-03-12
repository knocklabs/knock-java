// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.recipients.channeldata

import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.NoAutoDetect
import app.knock.api.core.immutableEmptyMap
import app.knock.api.core.toImmutable
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import java.util.Objects

/** Allows inline setting channel data for a recipient */
@NoAutoDetect
class InlineChannelDataRequest @JsonCreator private constructor(
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),

) {

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): InlineChannelDataRequest =
        apply {
            if (validated) {
              return@apply
            }

            validated = true
        }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [InlineChannelDataRequest].
         */
        @JvmStatic
        fun builder() = Builder()
    }

    /** A builder for [InlineChannelDataRequest]. */
    class Builder internal constructor() {

        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(inlineChannelDataRequest: InlineChannelDataRequest) =
            apply {
                additionalProperties = inlineChannelDataRequest.additionalProperties.toMutableMap()
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

        fun build(): InlineChannelDataRequest = InlineChannelDataRequest(additionalProperties.toImmutable())
    }

    override fun equals(other: Any?): Boolean {
      if (this === other) {
          return true
      }

      return /* spotless:off */ other is InlineChannelDataRequest && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() = "InlineChannelDataRequest{additionalProperties=$additionalProperties}"
}
