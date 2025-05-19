// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.schedules

import app.knock.api.core.JsonValue
import app.knock.api.core.jsonMapper
import app.knock.api.models.shared.PageInfo
import app.knock.api.models.users.User
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ScheduleListPageResponseTest {

    @Test
    fun create() {
        val scheduleListPageResponse =
            ScheduleListPageResponse.builder()
                .addEntry(
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
                                .email("email")
                                .name("name")
                                .phoneNumber("phone_number")
                                .timezone("timezone")
                                .build()
                        )
                        .data(
                            Schedule.Data.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .lastOccurrenceAt(null)
                        .nextOccurrenceAt(null)
                        .tenant(null)
                        .build()
                )
                .pageInfo(
                    PageInfo.builder()
                        ._typename("PageInfo")
                        .pageSize(25L)
                        .after(null)
                        .before(null)
                        .build()
                )
                .build()

        assertThat(scheduleListPageResponse.entries())
            .containsExactly(
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
                            .email("email")
                            .name("name")
                            .phoneNumber("phone_number")
                            .timezone("timezone")
                            .build()
                    )
                    .data(
                        Schedule.Data.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .lastOccurrenceAt(null)
                    .nextOccurrenceAt(null)
                    .tenant(null)
                    .build()
            )
        assertThat(scheduleListPageResponse.pageInfo())
            .isEqualTo(
                PageInfo.builder()
                    ._typename("PageInfo")
                    .pageSize(25L)
                    .after(null)
                    .before(null)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val scheduleListPageResponse =
            ScheduleListPageResponse.builder()
                .addEntry(
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
                                .email("email")
                                .name("name")
                                .phoneNumber("phone_number")
                                .timezone("timezone")
                                .build()
                        )
                        .data(
                            Schedule.Data.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .lastOccurrenceAt(null)
                        .nextOccurrenceAt(null)
                        .tenant(null)
                        .build()
                )
                .pageInfo(
                    PageInfo.builder()
                        ._typename("PageInfo")
                        .pageSize(25L)
                        .after(null)
                        .before(null)
                        .build()
                )
                .build()

        val roundtrippedScheduleListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(scheduleListPageResponse),
                jacksonTypeRef<ScheduleListPageResponse>(),
            )

        assertThat(roundtrippedScheduleListPageResponse).isEqualTo(scheduleListPageResponse)
    }
}
