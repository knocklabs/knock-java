// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.schedules

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

/** The repeat rule for the schedule. */
class ScheduleRepeatRule
private constructor(
    private val _typename: JsonField<String>,
    private val frequency: JsonField<Frequency>,
    private val dayOfMonth: JsonField<Long>,
    private val days: JsonField<List<Day>>,
    private val hours: JsonField<Long>,
    private val interval: JsonField<Long>,
    private val minutes: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("__typename") @ExcludeMissing _typename: JsonField<String> = JsonMissing.of(),
        @JsonProperty("frequency")
        @ExcludeMissing
        frequency: JsonField<Frequency> = JsonMissing.of(),
        @JsonProperty("day_of_month")
        @ExcludeMissing
        dayOfMonth: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("days") @ExcludeMissing days: JsonField<List<Day>> = JsonMissing.of(),
        @JsonProperty("hours") @ExcludeMissing hours: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("interval") @ExcludeMissing interval: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("minutes") @ExcludeMissing minutes: JsonField<Long> = JsonMissing.of(),
    ) : this(_typename, frequency, dayOfMonth, days, hours, interval, minutes, mutableMapOf())

    /**
     * The type name of the schema.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun _typename(): String = _typename.getRequired("__typename")

    /**
     * The frequency of the schedule.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun frequency(): Frequency = frequency.getRequired("frequency")

    /**
     * The day of the month to repeat the schedule.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun dayOfMonth(): Optional<Long> = dayOfMonth.getOptional("day_of_month")

    /**
     * The days of the week to repeat the schedule.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun days(): Optional<List<Day>> = days.getOptional("days")

    /**
     * The hour of the day to repeat the schedule.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun hours(): Optional<Long> = hours.getOptional("hours")

    /**
     * The interval of the schedule.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun interval(): Optional<Long> = interval.getOptional("interval")

    /**
     * The minute of the hour to repeat the schedule.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun minutes(): Optional<Long> = minutes.getOptional("minutes")

    /**
     * Returns the raw JSON value of [_typename].
     *
     * Unlike [_typename], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("__typename") @ExcludeMissing fun __typename(): JsonField<String> = _typename

    /**
     * Returns the raw JSON value of [frequency].
     *
     * Unlike [frequency], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("frequency") @ExcludeMissing fun _frequency(): JsonField<Frequency> = frequency

    /**
     * Returns the raw JSON value of [dayOfMonth].
     *
     * Unlike [dayOfMonth], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("day_of_month") @ExcludeMissing fun _dayOfMonth(): JsonField<Long> = dayOfMonth

    /**
     * Returns the raw JSON value of [days].
     *
     * Unlike [days], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("days") @ExcludeMissing fun _days(): JsonField<List<Day>> = days

    /**
     * Returns the raw JSON value of [hours].
     *
     * Unlike [hours], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("hours") @ExcludeMissing fun _hours(): JsonField<Long> = hours

    /**
     * Returns the raw JSON value of [interval].
     *
     * Unlike [interval], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("interval") @ExcludeMissing fun _interval(): JsonField<Long> = interval

    /**
     * Returns the raw JSON value of [minutes].
     *
     * Unlike [minutes], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("minutes") @ExcludeMissing fun _minutes(): JsonField<Long> = minutes

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
         * Returns a mutable builder for constructing an instance of [ScheduleRepeatRule].
         *
         * The following fields are required:
         * ```java
         * ._typename()
         * .frequency()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ScheduleRepeatRule]. */
    class Builder internal constructor() {

        private var _typename: JsonField<String>? = null
        private var frequency: JsonField<Frequency>? = null
        private var dayOfMonth: JsonField<Long> = JsonMissing.of()
        private var days: JsonField<MutableList<Day>>? = null
        private var hours: JsonField<Long> = JsonMissing.of()
        private var interval: JsonField<Long> = JsonMissing.of()
        private var minutes: JsonField<Long> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(scheduleRepeatRule: ScheduleRepeatRule) = apply {
            _typename = scheduleRepeatRule._typename
            frequency = scheduleRepeatRule.frequency
            dayOfMonth = scheduleRepeatRule.dayOfMonth
            days = scheduleRepeatRule.days.map { it.toMutableList() }
            hours = scheduleRepeatRule.hours
            interval = scheduleRepeatRule.interval
            minutes = scheduleRepeatRule.minutes
            additionalProperties = scheduleRepeatRule.additionalProperties.toMutableMap()
        }

        /** The type name of the schema. */
        fun _typename(_typename: String) = _typename(JsonField.of(_typename))

        /**
         * Sets [Builder._typename] to an arbitrary JSON value.
         *
         * You should usually call [Builder._typename] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun _typename(_typename: JsonField<String>) = apply { this._typename = _typename }

        /** The frequency of the schedule. */
        fun frequency(frequency: Frequency) = frequency(JsonField.of(frequency))

        /**
         * Sets [Builder.frequency] to an arbitrary JSON value.
         *
         * You should usually call [Builder.frequency] with a well-typed [Frequency] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun frequency(frequency: JsonField<Frequency>) = apply { this.frequency = frequency }

        /** The day of the month to repeat the schedule. */
        fun dayOfMonth(dayOfMonth: Long?) = dayOfMonth(JsonField.ofNullable(dayOfMonth))

        /**
         * Alias for [Builder.dayOfMonth].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun dayOfMonth(dayOfMonth: Long) = dayOfMonth(dayOfMonth as Long?)

        /** Alias for calling [Builder.dayOfMonth] with `dayOfMonth.orElse(null)`. */
        fun dayOfMonth(dayOfMonth: Optional<Long>) = dayOfMonth(dayOfMonth.getOrNull())

        /**
         * Sets [Builder.dayOfMonth] to an arbitrary JSON value.
         *
         * You should usually call [Builder.dayOfMonth] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun dayOfMonth(dayOfMonth: JsonField<Long>) = apply { this.dayOfMonth = dayOfMonth }

        /** The days of the week to repeat the schedule. */
        fun days(days: List<Day>?) = days(JsonField.ofNullable(days))

        /** Alias for calling [Builder.days] with `days.orElse(null)`. */
        fun days(days: Optional<List<Day>>) = days(days.getOrNull())

        /**
         * Sets [Builder.days] to an arbitrary JSON value.
         *
         * You should usually call [Builder.days] with a well-typed `List<Day>` value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun days(days: JsonField<List<Day>>) = apply { this.days = days.map { it.toMutableList() } }

        /**
         * Adds a single [Day] to [days].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addDay(day: Day) = apply {
            days = (days ?: JsonField.of(mutableListOf())).also { checkKnown("days", it).add(day) }
        }

        /** The hour of the day to repeat the schedule. */
        fun hours(hours: Long?) = hours(JsonField.ofNullable(hours))

        /**
         * Alias for [Builder.hours].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun hours(hours: Long) = hours(hours as Long?)

        /** Alias for calling [Builder.hours] with `hours.orElse(null)`. */
        fun hours(hours: Optional<Long>) = hours(hours.getOrNull())

        /**
         * Sets [Builder.hours] to an arbitrary JSON value.
         *
         * You should usually call [Builder.hours] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun hours(hours: JsonField<Long>) = apply { this.hours = hours }

        /** The interval of the schedule. */
        fun interval(interval: Long) = interval(JsonField.of(interval))

        /**
         * Sets [Builder.interval] to an arbitrary JSON value.
         *
         * You should usually call [Builder.interval] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun interval(interval: JsonField<Long>) = apply { this.interval = interval }

        /** The minute of the hour to repeat the schedule. */
        fun minutes(minutes: Long?) = minutes(JsonField.ofNullable(minutes))

        /**
         * Alias for [Builder.minutes].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun minutes(minutes: Long) = minutes(minutes as Long?)

        /** Alias for calling [Builder.minutes] with `minutes.orElse(null)`. */
        fun minutes(minutes: Optional<Long>) = minutes(minutes.getOrNull())

        /**
         * Sets [Builder.minutes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.minutes] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun minutes(minutes: JsonField<Long>) = apply { this.minutes = minutes }

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
         * Returns an immutable instance of [ScheduleRepeatRule].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * ._typename()
         * .frequency()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ScheduleRepeatRule =
            ScheduleRepeatRule(
                checkRequired("_typename", _typename),
                checkRequired("frequency", frequency),
                dayOfMonth,
                (days ?: JsonMissing.of()).map { it.toImmutable() },
                hours,
                interval,
                minutes,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ScheduleRepeatRule = apply {
        if (validated) {
            return@apply
        }

        _typename()
        frequency().validate()
        dayOfMonth()
        days().ifPresent { it.forEach { it.validate() } }
        hours()
        interval()
        minutes()
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
        (if (_typename.asKnown().isPresent) 1 else 0) +
            (frequency.asKnown().getOrNull()?.validity() ?: 0) +
            (if (dayOfMonth.asKnown().isPresent) 1 else 0) +
            (days.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (hours.asKnown().isPresent) 1 else 0) +
            (if (interval.asKnown().isPresent) 1 else 0) +
            (if (minutes.asKnown().isPresent) 1 else 0)

    /** The frequency of the schedule. */
    class Frequency @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val DAILY = of("daily")

            @JvmField val WEEKLY = of("weekly")

            @JvmField val MONTHLY = of("monthly")

            @JvmField val HOURLY = of("hourly")

            @JvmStatic fun of(value: String) = Frequency(JsonField.of(value))
        }

        /** An enum containing [Frequency]'s known values. */
        enum class Known {
            DAILY,
            WEEKLY,
            MONTHLY,
            HOURLY,
        }

        /**
         * An enum containing [Frequency]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Frequency] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            DAILY,
            WEEKLY,
            MONTHLY,
            HOURLY,
            /**
             * An enum member indicating that [Frequency] was instantiated with an unknown value.
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
                DAILY -> Value.DAILY
                WEEKLY -> Value.WEEKLY
                MONTHLY -> Value.MONTHLY
                HOURLY -> Value.HOURLY
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
                DAILY -> Known.DAILY
                WEEKLY -> Known.WEEKLY
                MONTHLY -> Known.MONTHLY
                HOURLY -> Known.HOURLY
                else -> throw KnockInvalidDataException("Unknown Frequency: $value")
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

        fun validate(): Frequency = apply {
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

            return /* spotless:off */ other is Frequency && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** An identifier for a day of the week. */
    class Day @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val MON = of("mon")

            @JvmField val TUE = of("tue")

            @JvmField val WED = of("wed")

            @JvmField val THU = of("thu")

            @JvmField val FRI = of("fri")

            @JvmField val SAT = of("sat")

            @JvmField val SUN = of("sun")

            @JvmStatic fun of(value: String) = Day(JsonField.of(value))
        }

        /** An enum containing [Day]'s known values. */
        enum class Known {
            MON,
            TUE,
            WED,
            THU,
            FRI,
            SAT,
            SUN,
        }

        /**
         * An enum containing [Day]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Day] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            MON,
            TUE,
            WED,
            THU,
            FRI,
            SAT,
            SUN,
            /** An enum member indicating that [Day] was instantiated with an unknown value. */
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
                MON -> Value.MON
                TUE -> Value.TUE
                WED -> Value.WED
                THU -> Value.THU
                FRI -> Value.FRI
                SAT -> Value.SAT
                SUN -> Value.SUN
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
                MON -> Known.MON
                TUE -> Known.TUE
                WED -> Known.WED
                THU -> Known.THU
                FRI -> Known.FRI
                SAT -> Known.SAT
                SUN -> Known.SUN
                else -> throw KnockInvalidDataException("Unknown Day: $value")
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

        fun validate(): Day = apply {
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

            return /* spotless:off */ other is Day && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ScheduleRepeatRule && _typename == other._typename && frequency == other.frequency && dayOfMonth == other.dayOfMonth && days == other.days && hours == other.hours && interval == other.interval && minutes == other.minutes && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(_typename, frequency, dayOfMonth, days, hours, interval, minutes, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ScheduleRepeatRule{_typename=$_typename, frequency=$frequency, dayOfMonth=$dayOfMonth, days=$days, hours=$hours, interval=$interval, minutes=$minutes, additionalProperties=$additionalProperties}"
}
