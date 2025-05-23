// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.shared

import app.knock.api.core.Enum
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
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A condition to be evaluated. */
class Condition
private constructor(
    private val argument: JsonField<String>,
    private val operator: JsonField<Operator>,
    private val variable: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("argument") @ExcludeMissing argument: JsonField<String> = JsonMissing.of(),
        @JsonProperty("operator") @ExcludeMissing operator: JsonField<Operator> = JsonMissing.of(),
        @JsonProperty("variable") @ExcludeMissing variable: JsonField<String> = JsonMissing.of(),
    ) : this(argument, operator, variable, mutableMapOf())

    /**
     * The argument value to compare against in the condition.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun argument(): Optional<String> = argument.getOptional("argument")

    /**
     * The operator to use in the condition evaluation.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun operator(): Operator = operator.getRequired("operator")

    /**
     * The variable to be evaluated in the condition.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun variable(): String = variable.getRequired("variable")

    /**
     * Returns the raw JSON value of [argument].
     *
     * Unlike [argument], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("argument") @ExcludeMissing fun _argument(): JsonField<String> = argument

    /**
     * Returns the raw JSON value of [operator].
     *
     * Unlike [operator], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("operator") @ExcludeMissing fun _operator(): JsonField<Operator> = operator

    /**
     * Returns the raw JSON value of [variable].
     *
     * Unlike [variable], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("variable") @ExcludeMissing fun _variable(): JsonField<String> = variable

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
         * Returns a mutable builder for constructing an instance of [Condition].
         *
         * The following fields are required:
         * ```java
         * .argument()
         * .operator()
         * .variable()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Condition]. */
    class Builder internal constructor() {

        private var argument: JsonField<String>? = null
        private var operator: JsonField<Operator>? = null
        private var variable: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(condition: Condition) = apply {
            argument = condition.argument
            operator = condition.operator
            variable = condition.variable
            additionalProperties = condition.additionalProperties.toMutableMap()
        }

        /** The argument value to compare against in the condition. */
        fun argument(argument: String?) = argument(JsonField.ofNullable(argument))

        /** Alias for calling [Builder.argument] with `argument.orElse(null)`. */
        fun argument(argument: Optional<String>) = argument(argument.getOrNull())

        /**
         * Sets [Builder.argument] to an arbitrary JSON value.
         *
         * You should usually call [Builder.argument] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun argument(argument: JsonField<String>) = apply { this.argument = argument }

        /** The operator to use in the condition evaluation. */
        fun operator(operator: Operator) = operator(JsonField.of(operator))

        /**
         * Sets [Builder.operator] to an arbitrary JSON value.
         *
         * You should usually call [Builder.operator] with a well-typed [Operator] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun operator(operator: JsonField<Operator>) = apply { this.operator = operator }

        /** The variable to be evaluated in the condition. */
        fun variable(variable: String) = variable(JsonField.of(variable))

        /**
         * Sets [Builder.variable] to an arbitrary JSON value.
         *
         * You should usually call [Builder.variable] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun variable(variable: JsonField<String>) = apply { this.variable = variable }

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
         * Returns an immutable instance of [Condition].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .argument()
         * .operator()
         * .variable()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Condition =
            Condition(
                checkRequired("argument", argument),
                checkRequired("operator", operator),
                checkRequired("variable", variable),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): Condition = apply {
        if (validated) {
            return@apply
        }

        argument()
        operator().validate()
        variable()
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
        (if (argument.asKnown().isPresent) 1 else 0) +
            (operator.asKnown().getOrNull()?.validity() ?: 0) +
            (if (variable.asKnown().isPresent) 1 else 0)

    /** The operator to use in the condition evaluation. */
    class Operator @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val EQUAL_TO = of("equal_to")

            @JvmField val NOT_EQUAL_TO = of("not_equal_to")

            @JvmField val GREATER_THAN = of("greater_than")

            @JvmField val LESS_THAN = of("less_than")

            @JvmField val GREATER_THAN_OR_EQUAL_TO = of("greater_than_or_equal_to")

            @JvmField val LESS_THAN_OR_EQUAL_TO = of("less_than_or_equal_to")

            @JvmField val CONTAINS = of("contains")

            @JvmField val NOT_CONTAINS = of("not_contains")

            @JvmField val EMPTY = of("empty")

            @JvmField val NOT_EMPTY = of("not_empty")

            @JvmField val CONTAINS_ALL = of("contains_all")

            @JvmField val IS_TIMESTAMP = of("is_timestamp")

            @JvmField val IS_NOT_TIMESTAMP = of("is_not_timestamp")

            @JvmField val IS_TIMESTAMP_AFTER = of("is_timestamp_after")

            @JvmField val IS_TIMESTAMP_BEFORE = of("is_timestamp_before")

            @JvmField val IS_TIMESTAMP_BETWEEN = of("is_timestamp_between")

            @JvmField val IS_AUDIENCE_MEMBER = of("is_audience_member")

            @JvmField val IS_NOT_AUDIENCE_MEMBER = of("is_not_audience_member")

            @JvmStatic fun of(value: String) = Operator(JsonField.of(value))
        }

        /** An enum containing [Operator]'s known values. */
        enum class Known {
            EQUAL_TO,
            NOT_EQUAL_TO,
            GREATER_THAN,
            LESS_THAN,
            GREATER_THAN_OR_EQUAL_TO,
            LESS_THAN_OR_EQUAL_TO,
            CONTAINS,
            NOT_CONTAINS,
            EMPTY,
            NOT_EMPTY,
            CONTAINS_ALL,
            IS_TIMESTAMP,
            IS_NOT_TIMESTAMP,
            IS_TIMESTAMP_AFTER,
            IS_TIMESTAMP_BEFORE,
            IS_TIMESTAMP_BETWEEN,
            IS_AUDIENCE_MEMBER,
            IS_NOT_AUDIENCE_MEMBER,
        }

        /**
         * An enum containing [Operator]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Operator] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            EQUAL_TO,
            NOT_EQUAL_TO,
            GREATER_THAN,
            LESS_THAN,
            GREATER_THAN_OR_EQUAL_TO,
            LESS_THAN_OR_EQUAL_TO,
            CONTAINS,
            NOT_CONTAINS,
            EMPTY,
            NOT_EMPTY,
            CONTAINS_ALL,
            IS_TIMESTAMP,
            IS_NOT_TIMESTAMP,
            IS_TIMESTAMP_AFTER,
            IS_TIMESTAMP_BEFORE,
            IS_TIMESTAMP_BETWEEN,
            IS_AUDIENCE_MEMBER,
            IS_NOT_AUDIENCE_MEMBER,
            /** An enum member indicating that [Operator] was instantiated with an unknown value. */
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
                EQUAL_TO -> Value.EQUAL_TO
                NOT_EQUAL_TO -> Value.NOT_EQUAL_TO
                GREATER_THAN -> Value.GREATER_THAN
                LESS_THAN -> Value.LESS_THAN
                GREATER_THAN_OR_EQUAL_TO -> Value.GREATER_THAN_OR_EQUAL_TO
                LESS_THAN_OR_EQUAL_TO -> Value.LESS_THAN_OR_EQUAL_TO
                CONTAINS -> Value.CONTAINS
                NOT_CONTAINS -> Value.NOT_CONTAINS
                EMPTY -> Value.EMPTY
                NOT_EMPTY -> Value.NOT_EMPTY
                CONTAINS_ALL -> Value.CONTAINS_ALL
                IS_TIMESTAMP -> Value.IS_TIMESTAMP
                IS_NOT_TIMESTAMP -> Value.IS_NOT_TIMESTAMP
                IS_TIMESTAMP_AFTER -> Value.IS_TIMESTAMP_AFTER
                IS_TIMESTAMP_BEFORE -> Value.IS_TIMESTAMP_BEFORE
                IS_TIMESTAMP_BETWEEN -> Value.IS_TIMESTAMP_BETWEEN
                IS_AUDIENCE_MEMBER -> Value.IS_AUDIENCE_MEMBER
                IS_NOT_AUDIENCE_MEMBER -> Value.IS_NOT_AUDIENCE_MEMBER
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
                EQUAL_TO -> Known.EQUAL_TO
                NOT_EQUAL_TO -> Known.NOT_EQUAL_TO
                GREATER_THAN -> Known.GREATER_THAN
                LESS_THAN -> Known.LESS_THAN
                GREATER_THAN_OR_EQUAL_TO -> Known.GREATER_THAN_OR_EQUAL_TO
                LESS_THAN_OR_EQUAL_TO -> Known.LESS_THAN_OR_EQUAL_TO
                CONTAINS -> Known.CONTAINS
                NOT_CONTAINS -> Known.NOT_CONTAINS
                EMPTY -> Known.EMPTY
                NOT_EMPTY -> Known.NOT_EMPTY
                CONTAINS_ALL -> Known.CONTAINS_ALL
                IS_TIMESTAMP -> Known.IS_TIMESTAMP
                IS_NOT_TIMESTAMP -> Known.IS_NOT_TIMESTAMP
                IS_TIMESTAMP_AFTER -> Known.IS_TIMESTAMP_AFTER
                IS_TIMESTAMP_BEFORE -> Known.IS_TIMESTAMP_BEFORE
                IS_TIMESTAMP_BETWEEN -> Known.IS_TIMESTAMP_BETWEEN
                IS_AUDIENCE_MEMBER -> Known.IS_AUDIENCE_MEMBER
                IS_NOT_AUDIENCE_MEMBER -> Known.IS_NOT_AUDIENCE_MEMBER
                else -> throw KnockInvalidDataException("Unknown Operator: $value")
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

        fun validate(): Operator = apply {
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

            return /* spotless:off */ other is Operator && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is Condition && argument == other.argument && operator == other.operator && variable == other.variable && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(argument, operator, variable, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Condition{argument=$argument, operator=$operator, variable=$variable, additionalProperties=$additionalProperties}"
}
