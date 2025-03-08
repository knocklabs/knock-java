// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.knock.api.core.Enum
import com.knock.api.core.ExcludeMissing
import com.knock.api.core.JsonField
import com.knock.api.core.JsonMissing
import com.knock.api.core.JsonValue
import com.knock.api.core.NoAutoDetect
import com.knock.api.core.checkKnown
import com.knock.api.core.checkRequired
import com.knock.api.core.immutableEmptyMap
import com.knock.api.core.toImmutable
import com.knock.api.errors.KnockInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A schedule repeat rule */
@NoAutoDetect
class ScheduleRepeatRule
@JsonCreator
private constructor(
    @JsonProperty("__typename")
    @ExcludeMissing
    private val _typename: JsonField<String> = JsonMissing.of(),
    @JsonProperty("frequency")
    @ExcludeMissing
    private val frequency: JsonField<Frequency> = JsonMissing.of(),
    @JsonProperty("day_of_month")
    @ExcludeMissing
    private val dayOfMonth: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("days") @ExcludeMissing private val days: JsonField<List<Day>> = JsonMissing.of(),
    @JsonProperty("hours") @ExcludeMissing private val hours: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("interval")
    @ExcludeMissing
    private val interval: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("minutes")
    @ExcludeMissing
    private val minutes: JsonField<Long> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    fun _typename(): String = _typename.getRequired("__typename")

    fun frequency(): Frequency = frequency.getRequired("frequency")

    fun dayOfMonth(): Optional<Long> = Optional.ofNullable(dayOfMonth.getNullable("day_of_month"))

    fun days(): Optional<List<Day>> = Optional.ofNullable(days.getNullable("days"))

    fun hours(): Optional<Long> = Optional.ofNullable(hours.getNullable("hours"))

    fun interval(): Optional<Long> = Optional.ofNullable(interval.getNullable("interval"))

    fun minutes(): Optional<Long> = Optional.ofNullable(minutes.getNullable("minutes"))

    @JsonProperty("__typename") @ExcludeMissing fun __typename(): JsonField<String> = _typename

    @JsonProperty("frequency") @ExcludeMissing fun _frequency(): JsonField<Frequency> = frequency

    @JsonProperty("day_of_month") @ExcludeMissing fun _dayOfMonth(): JsonField<Long> = dayOfMonth

    @JsonProperty("days") @ExcludeMissing fun _days(): JsonField<List<Day>> = days

    @JsonProperty("hours") @ExcludeMissing fun _hours(): JsonField<Long> = hours

    @JsonProperty("interval") @ExcludeMissing fun _interval(): JsonField<Long> = interval

    @JsonProperty("minutes") @ExcludeMissing fun _minutes(): JsonField<Long> = minutes

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ScheduleRepeatRule = apply {
        if (validated) {
            return@apply
        }

        _typename()
        frequency()
        dayOfMonth()
        days()
        hours()
        interval()
        minutes()
        validated = true
    }

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

        fun _typename(_typename: String) = _typename(JsonField.of(_typename))

        fun _typename(_typename: JsonField<String>) = apply { this._typename = _typename }

        fun frequency(frequency: Frequency) = frequency(JsonField.of(frequency))

        fun frequency(frequency: JsonField<Frequency>) = apply { this.frequency = frequency }

        fun dayOfMonth(dayOfMonth: Long?) = dayOfMonth(JsonField.ofNullable(dayOfMonth))

        fun dayOfMonth(dayOfMonth: Long) = dayOfMonth(dayOfMonth as Long?)

        fun dayOfMonth(dayOfMonth: Optional<Long>) = dayOfMonth(dayOfMonth.getOrNull())

        fun dayOfMonth(dayOfMonth: JsonField<Long>) = apply { this.dayOfMonth = dayOfMonth }

        fun days(days: List<Day>?) = days(JsonField.ofNullable(days))

        fun days(days: Optional<List<Day>>) = days(days.getOrNull())

        fun days(days: JsonField<List<Day>>) = apply { this.days = days.map { it.toMutableList() } }

        fun addDay(day: Day) = apply {
            days = (days ?: JsonField.of(mutableListOf())).also { checkKnown("days", it).add(day) }
        }

        fun hours(hours: Long?) = hours(JsonField.ofNullable(hours))

        fun hours(hours: Long) = hours(hours as Long?)

        fun hours(hours: Optional<Long>) = hours(hours.getOrNull())

        fun hours(hours: JsonField<Long>) = apply { this.hours = hours }

        fun interval(interval: Long) = interval(JsonField.of(interval))

        fun interval(interval: JsonField<Long>) = apply { this.interval = interval }

        fun minutes(minutes: Long?) = minutes(JsonField.ofNullable(minutes))

        fun minutes(minutes: Long) = minutes(minutes as Long?)

        fun minutes(minutes: Optional<Long>) = minutes(minutes.getOrNull())

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

        fun build(): ScheduleRepeatRule =
            ScheduleRepeatRule(
                checkRequired("_typename", _typename),
                checkRequired("frequency", frequency),
                dayOfMonth,
                (days ?: JsonMissing.of()).map { it.toImmutable() },
                hours,
                interval,
                minutes,
                additionalProperties.toImmutable(),
            )
    }

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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Frequency && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

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
