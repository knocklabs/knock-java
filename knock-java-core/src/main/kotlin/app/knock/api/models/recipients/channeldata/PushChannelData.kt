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
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** The content of a push notification. */
class PushChannelData
private constructor(
    private val tokens: JsonField<List<String>>,
    private val type: JsonField<Type>,
    private val _typename: JsonField<_Typename>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("tokens") @ExcludeMissing tokens: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
        @JsonProperty("__typename")
        @ExcludeMissing
        _typename: JsonField<_Typename> = JsonMissing.of(),
    ) : this(tokens, type, _typename, mutableMapOf())

    /**
     * A list of push channel tokens.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun tokens(): List<String> = tokens.getRequired("tokens")

    /**
     * The type of provider.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun type(): Type = type.getRequired("type")

    /**
     * The typename of the schema.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun _typename(): Optional<_Typename> = _typename.getOptional("__typename")

    /**
     * Returns the raw JSON value of [tokens].
     *
     * Unlike [tokens], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tokens") @ExcludeMissing fun _tokens(): JsonField<List<String>> = tokens

    /**
     * Returns the raw JSON value of [type].
     *
     * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

    /**
     * Returns the raw JSON value of [_typename].
     *
     * Unlike [_typename], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("__typename") @ExcludeMissing fun __typename(): JsonField<_Typename> = _typename

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
         * .type()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [PushChannelData]. */
    class Builder internal constructor() {

        private var tokens: JsonField<MutableList<String>>? = null
        private var type: JsonField<Type>? = null
        private var _typename: JsonField<_Typename> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(pushChannelData: PushChannelData) = apply {
            tokens = pushChannelData.tokens.map { it.toMutableList() }
            type = pushChannelData.type
            _typename = pushChannelData._typename
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

        /** The type of provider. */
        fun type(type: Type) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [Type] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<Type>) = apply { this.type = type }

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
         * .type()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): PushChannelData =
            PushChannelData(
                checkRequired("tokens", tokens).map { it.toImmutable() },
                checkRequired("type", type),
                _typename,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): PushChannelData = apply {
        if (validated) {
            return@apply
        }

        tokens()
        type().validate()
        _typename().ifPresent { it.validate() }
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
        (tokens.asKnown().getOrNull()?.size ?: 0) +
            (type.asKnown().getOrNull()?.validity() ?: 0) +
            (_typename.asKnown().getOrNull()?.validity() ?: 0)

    /** The type of provider. */
    class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val PUSH_FCM = of("push_fcm")

            @JvmField val PUSH_APNS = of("push_apns")

            @JvmField val PUSH_EXPO = of("push_expo")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        /** An enum containing [Type]'s known values. */
        enum class Known {
            PUSH_FCM,
            PUSH_APNS,
            PUSH_EXPO,
        }

        /**
         * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Type] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            PUSH_FCM,
            PUSH_APNS,
            PUSH_EXPO,
            /** An enum member indicating that [Type] was instantiated with an unknown value. */
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
                PUSH_FCM -> Value.PUSH_FCM
                PUSH_APNS -> Value.PUSH_APNS
                PUSH_EXPO -> Value.PUSH_EXPO
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
                PUSH_FCM -> Known.PUSH_FCM
                PUSH_APNS -> Known.PUSH_APNS
                PUSH_EXPO -> Known.PUSH_EXPO
                else -> throw KnockInvalidDataException("Unknown Type: $value")
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

        fun validate(): Type = apply {
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

            return /* spotless:off */ other is Type && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

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

            @JvmField val PUSH_CHANNEL_DATA = of("PushChannelData")

            @JvmStatic fun of(value: String) = _Typename(JsonField.of(value))
        }

        /** An enum containing [_Typename]'s known values. */
        enum class Known {
            PUSH_CHANNEL_DATA
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
            PUSH_CHANNEL_DATA,
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
                PUSH_CHANNEL_DATA -> Value.PUSH_CHANNEL_DATA
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
                PUSH_CHANNEL_DATA -> Known.PUSH_CHANNEL_DATA
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

        return /* spotless:off */ other is PushChannelData && tokens == other.tokens && type == other.type && _typename == other._typename && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(tokens, type, _typename, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "PushChannelData{tokens=$tokens, type=$type, _typename=$_typename, additionalProperties=$additionalProperties}"
}
