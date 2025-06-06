// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.schedules

import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ScheduleRepeatRuleTest {

    @Test
    fun create() {
        val scheduleRepeatRule =
            ScheduleRepeatRule.builder()
                .frequency(ScheduleRepeatRule.Frequency.DAILY)
                ._typename("ScheduleRepeat")
                .dayOfMonth(null)
                .days(
                    listOf(
                        ScheduleRepeatRule.Day.MON,
                        ScheduleRepeatRule.Day.TUE,
                        ScheduleRepeatRule.Day.WED,
                        ScheduleRepeatRule.Day.THU,
                        ScheduleRepeatRule.Day.FRI,
                        ScheduleRepeatRule.Day.SAT,
                        ScheduleRepeatRule.Day.SUN,
                    )
                )
                .hours(null)
                .interval(1L)
                .minutes(null)
                .build()

        assertThat(scheduleRepeatRule.frequency()).isEqualTo(ScheduleRepeatRule.Frequency.DAILY)
        assertThat(scheduleRepeatRule._typename()).contains("ScheduleRepeat")
        assertThat(scheduleRepeatRule.dayOfMonth()).isEmpty
        assertThat(scheduleRepeatRule.days().getOrNull())
            .containsExactly(
                ScheduleRepeatRule.Day.MON,
                ScheduleRepeatRule.Day.TUE,
                ScheduleRepeatRule.Day.WED,
                ScheduleRepeatRule.Day.THU,
                ScheduleRepeatRule.Day.FRI,
                ScheduleRepeatRule.Day.SAT,
                ScheduleRepeatRule.Day.SUN,
            )
        assertThat(scheduleRepeatRule.hours()).isEmpty
        assertThat(scheduleRepeatRule.interval()).contains(1L)
        assertThat(scheduleRepeatRule.minutes()).isEmpty
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val scheduleRepeatRule =
            ScheduleRepeatRule.builder()
                .frequency(ScheduleRepeatRule.Frequency.DAILY)
                ._typename("ScheduleRepeat")
                .dayOfMonth(null)
                .days(
                    listOf(
                        ScheduleRepeatRule.Day.MON,
                        ScheduleRepeatRule.Day.TUE,
                        ScheduleRepeatRule.Day.WED,
                        ScheduleRepeatRule.Day.THU,
                        ScheduleRepeatRule.Day.FRI,
                        ScheduleRepeatRule.Day.SAT,
                        ScheduleRepeatRule.Day.SUN,
                    )
                )
                .hours(null)
                .interval(1L)
                .minutes(null)
                .build()

        val roundtrippedScheduleRepeatRule =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(scheduleRepeatRule),
                jacksonTypeRef<ScheduleRepeatRule>(),
            )

        assertThat(roundtrippedScheduleRepeatRule).isEqualTo(scheduleRepeatRule)
    }
}
