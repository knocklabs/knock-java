// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.providers.slack

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

class SlackListChannelsResponse
private constructor(
    private val id: JsonField<String>,
    private val contextTeamId: JsonField<String>,
    private val isIm: JsonField<Boolean>,
    private val isPrivate: JsonField<Boolean>,
    private val name: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("context_team_id")
        @ExcludeMissing
        contextTeamId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("is_im") @ExcludeMissing isIm: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("is_private")
        @ExcludeMissing
        isPrivate: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
    ) : this(id, contextTeamId, isIm, isPrivate, name, mutableMapOf())

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun contextTeamId(): String = contextTeamId.getRequired("context_team_id")

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun isIm(): Boolean = isIm.getRequired("is_im")

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun isPrivate(): Boolean = isPrivate.getRequired("is_private")

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun name(): String = name.getRequired("name")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [contextTeamId].
     *
     * Unlike [contextTeamId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("context_team_id")
    @ExcludeMissing
    fun _contextTeamId(): JsonField<String> = contextTeamId

    /**
     * Returns the raw JSON value of [isIm].
     *
     * Unlike [isIm], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("is_im") @ExcludeMissing fun _isIm(): JsonField<Boolean> = isIm

    /**
     * Returns the raw JSON value of [isPrivate].
     *
     * Unlike [isPrivate], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("is_private") @ExcludeMissing fun _isPrivate(): JsonField<Boolean> = isPrivate

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

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
         * Returns a mutable builder for constructing an instance of [SlackListChannelsResponse].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .contextTeamId()
         * .isIm()
         * .isPrivate()
         * .name()
         * ```
         */
        @JvmStatic fun builder() = Builder()
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
        internal fun from(slackListChannelsResponse: SlackListChannelsResponse) = apply {
            id = slackListChannelsResponse.id
            contextTeamId = slackListChannelsResponse.contextTeamId
            isIm = slackListChannelsResponse.isIm
            isPrivate = slackListChannelsResponse.isPrivate
            name = slackListChannelsResponse.name
            additionalProperties = slackListChannelsResponse.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        fun contextTeamId(contextTeamId: String) = contextTeamId(JsonField.of(contextTeamId))

        /**
         * Sets [Builder.contextTeamId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.contextTeamId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun contextTeamId(contextTeamId: JsonField<String>) = apply {
            this.contextTeamId = contextTeamId
        }

        fun isIm(isIm: Boolean) = isIm(JsonField.of(isIm))

        /**
         * Sets [Builder.isIm] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isIm] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun isIm(isIm: JsonField<Boolean>) = apply { this.isIm = isIm }

        fun isPrivate(isPrivate: Boolean) = isPrivate(JsonField.of(isPrivate))

        /**
         * Sets [Builder.isPrivate] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isPrivate] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun isPrivate(isPrivate: JsonField<Boolean>) = apply { this.isPrivate = isPrivate }

        fun name(name: String) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

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
         * Returns an immutable instance of [SlackListChannelsResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .contextTeamId()
         * .isIm()
         * .isPrivate()
         * .name()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): SlackListChannelsResponse =
            SlackListChannelsResponse(
                checkRequired("id", id),
                checkRequired("contextTeamId", contextTeamId),
                checkRequired("isIm", isIm),
                checkRequired("isPrivate", isPrivate),
                checkRequired("name", name),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): SlackListChannelsResponse = apply {
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

    override fun toString() =
        "SlackListChannelsResponse{id=$id, contextTeamId=$contextTeamId, isIm=$isIm, isPrivate=$isPrivate, name=$name, additionalProperties=$additionalProperties}"
}
