// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.schedules

import app.knock.api.core.jsonMapper
import app.knock.api.models.recipients.Recipient
import app.knock.api.models.users.User
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ScheduleTest {

    @Test
    fun create() {
        val schedule =
            Schedule.builder()
                .id("123e4567-e89b-12d3-a456-426614174000")
                .insertedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                .recipient(
                    User.builder()
                        .id("jane")
                        ._typename("User")
                        .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                        .avatar(null)
                        .createdAt(null)
                        .email("jane@ingen.net")
                        .name("Jane Doe")
                        .phoneNumber(null)
                        .timezone(null)
                        .build()
                )
                .addRepeat(
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
                )
                .updatedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                .workflow("workflow_123")
                ._typename("Schedule")
                .actor(
                    User.builder()
                        .id("id")
                        ._typename("User")
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .avatar("avatar")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .email("dev@stainless.com")
                        .name("name")
                        .phoneNumber("phone_number")
                        .timezone("timezone")
                        .build()
                )
                .data(null)
                .lastOccurrenceAt(null)
                .nextOccurrenceAt(null)
                .tenant(null)
                .build()

        assertThat(schedule.id()).isEqualTo("123e4567-e89b-12d3-a456-426614174000")
        assertThat(schedule.insertedAt()).isEqualTo(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
        assertThat(schedule.recipient())
            .isEqualTo(
                Recipient.ofUser(
                    User.builder()
                        .id("jane")
                        ._typename("User")
                        .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                        .avatar(null)
                        .createdAt(null)
                        .email("jane@ingen.net")
                        .name("Jane Doe")
                        .phoneNumber(null)
                        .timezone(null)
                        .build()
                )
            )
        assertThat(schedule.repeats())
            .containsExactly(
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
            )
        assertThat(schedule.updatedAt()).isEqualTo(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
        assertThat(schedule.workflow()).isEqualTo("workflow_123")
        assertThat(schedule._typename()).contains("Schedule")
        assertThat(schedule.actor())
            .contains(
                Recipient.ofUser(
                    User.builder()
                        .id("id")
                        ._typename("User")
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .avatar("avatar")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .email("dev@stainless.com")
                        .name("name")
                        .phoneNumber("phone_number")
                        .timezone("timezone")
                        .build()
                )
            )
        assertThat(schedule._data()).isEqualTo(null)
        assertThat(schedule.lastOccurrenceAt()).isEmpty
        assertThat(schedule.nextOccurrenceAt()).isEmpty
        assertThat(schedule.tenant()).isEmpty
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val schedule =
            Schedule.builder()
                .id("123e4567-e89b-12d3-a456-426614174000")
                .insertedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                .recipient(
                    User.builder()
                        .id("jane")
                        ._typename("User")
                        .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                        .avatar(null)
                        .createdAt(null)
                        .email("jane@ingen.net")
                        .name("Jane Doe")
                        .phoneNumber(null)
                        .timezone(null)
                        .build()
                )
                .addRepeat(
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
                )
                .updatedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                .workflow("workflow_123")
                ._typename("Schedule")
                .actor(
                    User.builder()
                        .id("id")
                        ._typename("User")
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .avatar("avatar")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .email("dev@stainless.com")
                        .name("name")
                        .phoneNumber("phone_number")
                        .timezone("timezone")
                        .build()
                )
                .data(null)
                .lastOccurrenceAt(null)
                .nextOccurrenceAt(null)
                .tenant(null)
                .build()

        val roundtrippedSchedule =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(schedule),
                jacksonTypeRef<Schedule>(),
            )

        assertThat(roundtrippedSchedule).isEqualTo(schedule)
    }
}
