// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.schedules

import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ScheduleRepeatRuleTest {

    @Test
    fun createScheduleRepeatRule() {
        val scheduleRepeatRule =
            ScheduleRepeatRule.builder()
                ._typename("ScheduleRepeat")
                .frequency(ScheduleRepeatRule.Frequency.DAILY)
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
        assertThat(scheduleRepeatRule).isNotNull
        assertThat(scheduleRepeatRule._typename()).isEqualTo("ScheduleRepeat")
        assertThat(scheduleRepeatRule.frequency()).isEqualTo(ScheduleRepeatRule.Frequency.DAILY)
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
}
