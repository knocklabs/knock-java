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

/** OneSignal channel data */
class OneSignalChannelData
private constructor(
    private val playerIds: JsonField<List<String>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("player_ids")
        @ExcludeMissing
        playerIds: JsonField<List<String>> = JsonMissing.of()
    ) : this(playerIds, mutableMapOf())

    /**
     * The OneSignal player IDs
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun playerIds(): List<String> = playerIds.getRequired("player_ids")

    /**
     * Returns the raw JSON value of [playerIds].
     *
     * Unlike [playerIds], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("player_ids")
    @ExcludeMissing
    fun _playerIds(): JsonField<List<String>> = playerIds

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
         * Returns a mutable builder for constructing an instance of [OneSignalChannelData].
         *
         * The following fields are required:
         * ```java
         * .playerIds()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [OneSignalChannelData]. */
    class Builder internal constructor() {

        private var playerIds: JsonField<MutableList<String>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(oneSignalChannelData: OneSignalChannelData) = apply {
            playerIds = oneSignalChannelData.playerIds.map { it.toMutableList() }
            additionalProperties = oneSignalChannelData.additionalProperties.toMutableMap()
        }

        /** The OneSignal player IDs */
        fun playerIds(playerIds: List<String>) = playerIds(JsonField.of(playerIds))

        /**
         * Sets [Builder.playerIds] to an arbitrary JSON value.
         *
         * You should usually call [Builder.playerIds] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun playerIds(playerIds: JsonField<List<String>>) = apply {
            this.playerIds = playerIds.map { it.toMutableList() }
        }

        /**
         * Adds a single [String] to [playerIds].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addPlayerId(playerId: String) = apply {
            playerIds =
                (playerIds ?: JsonField.of(mutableListOf())).also {
                    checkKnown("playerIds", it).add(playerId)
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
         * Returns an immutable instance of [OneSignalChannelData].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .playerIds()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): OneSignalChannelData =
            OneSignalChannelData(
                checkRequired("playerIds", playerIds).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): OneSignalChannelData = apply {
        if (validated) {
            return@apply
        }

        playerIds()
        validated = true
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is OneSignalChannelData && playerIds == other.playerIds && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(playerIds, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "OneSignalChannelData{playerIds=$playerIds, additionalProperties=$additionalProperties}"
}
