// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.providers.slack

import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.NoAutoDetect
import app.knock.api.core.checkRequired
import app.knock.api.core.immutableEmptyMap
import app.knock.api.core.toImmutable
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Objects

@NoAutoDetect
class SlackListChannelsResponse @JsonCreator private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("context_team_id") @ExcludeMissing private val contextTeamId: JsonField<String> = JsonMissing.of(),
    @JsonProperty("is_im") @ExcludeMissing private val isIm: JsonField<Boolean> = JsonMissing.of(),
    @JsonProperty("is_private") @ExcludeMissing private val isPrivate: JsonField<Boolean> = JsonMissing.of(),
    @JsonProperty("name") @ExcludeMissing private val name: JsonField<String> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),

) {

    fun id(): String = id.getRequired("id")

    fun contextTeamId(): String = contextTeamId.getRequired("context_team_id")

    fun isIm(): Boolean = isIm.getRequired("is_im")

    fun isPrivate(): Boolean = isPrivate.getRequired("is_private")

    fun name(): String = name.getRequired("name")

    @JsonProperty("id")
    @ExcludeMissing
    fun _id(): JsonField<String> = id

    @JsonProperty("context_team_id")
    @ExcludeMissing
    fun _contextTeamId(): JsonField<String> = contextTeamId

    @JsonProperty("is_im")
    @ExcludeMissing
    fun _isIm(): JsonField<Boolean> = isIm

    @JsonProperty("is_private")
    @ExcludeMissing
    fun _isPrivate(): JsonField<Boolean> = isPrivate

    @JsonProperty("name")
    @ExcludeMissing
    fun _name(): JsonField<String> = name

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): SlackListChannelsResponse =
        apply {
            if (validated) {
              return@apply
            }

            id()
            contextTeamId()
            isIm()
            isPrivate()
            name()
            validated = true
        }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [SlackListChannelsResponse].
         *
         * The following fields are required:
         *
         * ```java
         * .id()
         * .contextTeamId()
         * .isIm()
         * .isPrivate()
         * .name()
         * ```
         */
        @JvmStatic
        fun builder() = Builder()
    }

    /** A builder for [SlackListChannelsResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var contextTeamId: JsonField<String>? = null
        private var isIm: JsonField<Boolean>? = null
        private var isPrivate: JsonField<Boolean>? = null
        private var name: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(slackListChannelsResponse: SlackListChannelsResponse) =
            apply {
                id = slackListChannelsResponse.id
                contextTeamId = slackListChannelsResponse.contextTeamId
                isIm = slackListChannelsResponse.isIm
                isPrivate = slackListChannelsResponse.isPrivate
                name = slackListChannelsResponse.name
                additionalProperties = slackListChannelsResponse.additionalProperties.toMutableMap()
            }

        fun id(id: String) = id(JsonField.of(id))

        fun id(id: JsonField<String>) =
            apply {
                this.id = id
            }

        fun contextTeamId(contextTeamId: String) = contextTeamId(JsonField.of(contextTeamId))

        fun contextTeamId(contextTeamId: JsonField<String>) =
            apply {
                this.contextTeamId = contextTeamId
            }

        fun isIm(isIm: Boolean) = isIm(JsonField.of(isIm))

        fun isIm(isIm: JsonField<Boolean>) =
            apply {
                this.isIm = isIm
            }

        fun isPrivate(isPrivate: Boolean) = isPrivate(JsonField.of(isPrivate))

        fun isPrivate(isPrivate: JsonField<Boolean>) =
            apply {
                this.isPrivate = isPrivate
            }

        fun name(name: String) = name(JsonField.of(name))

        fun name(name: JsonField<String>) =
            apply {
                this.name = name
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

        fun build(): SlackListChannelsResponse =
            SlackListChannelsResponse(
              checkRequired(
                "id", id
              ),
              checkRequired(
                "contextTeamId", contextTeamId
              ),
              checkRequired(
                "isIm", isIm
              ),
              checkRequired(
                "isPrivate", isPrivate
              ),
              checkRequired(
                "name", name
              ),
              additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
      if (this === other) {
          return true
      }

      return /* spotless:off */ other is SlackListChannelsResponse && id == other.id && contextTeamId == other.contextTeamId && isIm == other.isIm && isPrivate == other.isPrivate && name == other.name && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, contextTeamId, isIm, isPrivate, name, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() = "SlackListChannelsResponse{id=$id, contextTeamId=$contextTeamId, isIm=$isIm, isPrivate=$isPrivate, name=$name, additionalProperties=$additionalProperties}"
}
