// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.recipients.channeldata

import app.knock.api.core.Enum
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

/** OneSignal channel data. */
class OneSignalChannelData
private constructor(
    private val _typename: JsonField<_Typename>,
    private val playerIds: JsonField<List<String>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("__typename")
        @ExcludeMissing
        _typename: JsonField<_Typename> = JsonMissing.of(),
        @JsonProperty("player_ids")
        @ExcludeMissing
        playerIds: JsonField<List<String>> = JsonMissing.of(),
    ) : this(_typename, playerIds, mutableMapOf())

    /**
     * The typename of the schema.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun _typename(): _Typename = _typename.getRequired("__typename")

    /**
     * A list of OneSignal player IDs.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun playerIds(): List<String> = playerIds.getRequired("player_ids")

    /**
     * Returns the raw JSON value of [_typename].
     *
     * Unlike [_typename], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("__typename") @ExcludeMissing fun __typename(): JsonField<_Typename> = _typename

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
         * ._typename()
         * .playerIds()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [OneSignalChannelData]. */
    class Builder internal constructor() {

        private var _typename: JsonField<_Typename>? = null
        private var playerIds: JsonField<MutableList<String>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(oneSignalChannelData: OneSignalChannelData) = apply {
            _typename = oneSignalChannelData._typename
            playerIds = oneSignalChannelData.playerIds.map { it.toMutableList() }
            additionalProperties = oneSignalChannelData.additionalProperties.toMutableMap()
        }

        /** The typename of the schema. */
        fun _typename(_typename: _Typename) = _typename(JsonField.of(_typename))

        /**
         * Sets [Builder._typename] to an arbitrary JSON value.
         *
         * You should usually call [Builder._typename] with a well-typed [_Typename] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun _typename(_typename: JsonField<_Typename>) = apply { this._typename = _typename }

        /** A list of OneSignal player IDs. */
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
         * ._typename()
         * .playerIds()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): OneSignalChannelData =
            OneSignalChannelData(
                checkRequired("_typename", _typename),
                checkRequired("playerIds", playerIds).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): OneSignalChannelData = apply {
        if (validated) {
            return@apply
        }

        _typename().validate()
        playerIds()
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
    @JvmSynthetic
    internal fun validity(): Int =
        (_typename.asKnown().getOrNull()?.validity() ?: 0) +
            (playerIds.asKnown().getOrNull()?.size ?: 0)

    /** The typename of the schema. */
    class _Typename @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val ONE_SIGNAL_CHANNEL_DATA = of("OneSignalChannelData")

            @JvmStatic fun of(value: String) = _Typename(JsonField.of(value))
        }

        /** An enum containing [_Typename]'s known values. */
        enum class Known {
            ONE_SIGNAL_CHANNEL_DATA
        }

        /**
         * An enum containing [_Typename]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [_Typename] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            ONE_SIGNAL_CHANNEL_DATA,
            /**
             * An enum member indicating that [_Typename] was instantiated with an unknown value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                ONE_SIGNAL_CHANNEL_DATA -> Value.ONE_SIGNAL_CHANNEL_DATA
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws KnockInvalidDataException if this class instance's value is a not a known member.
         */
        fun known(): Known =
            when (this) {
                ONE_SIGNAL_CHANNEL_DATA -> Known.ONE_SIGNAL_CHANNEL_DATA
                else -> throw KnockInvalidDataException("Unknown _Typename: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws KnockInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { KnockInvalidDataException("Value is not a String") }

        private var validated: Boolean = false

        fun validate(): _Typename = apply {
            if (validated) {
                return@apply
            }

            known()
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is _Typename && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is OneSignalChannelData && _typename == other._typename && playerIds == other.playerIds && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(_typename, playerIds, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "OneSignalChannelData{_typename=$_typename, playerIds=$playerIds, additionalProperties=$additionalProperties}"
}
