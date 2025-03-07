// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.blocking

import com.knock.api.TestServerExtension
import com.knock.api.client.okhttp.KnockOkHttpClient
import com.knock.api.core.JsonValue
import com.knock.api.models.ScheduleCreateParams
import com.knock.api.models.ScheduleDeleteParams
import com.knock.api.models.ScheduleListParams
import com.knock.api.models.ScheduleRepeatRule
import com.knock.api.models.ScheduleUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class ScheduleServiceTest {

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun create() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val scheduleService = client.schedules()

        val schedules =
            scheduleService.create(
                ScheduleCreateParams.builder()
                    .addRecipient("user_123")
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
                    .workflow("comment-created")
                    .data(
                        ScheduleCreateParams.Data.builder()
                            .putAdditionalProperty("key", JsonValue.from("bar"))
                            .build()
                    )
                    .endingAt(null)
                    .scheduledAt(null)
                    .tenant("acme_corp")
                    .build()
            )

        schedules.forEach { it.validate() }
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun update() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val scheduleService = client.schedules()

        val schedules =
            scheduleService.update(
                ScheduleUpdateParams.builder()
                    .addScheduleId("123e4567-e89b-12d3-a456-426614174000")
                    .actor("string")
                    .data(
                        ScheduleUpdateParams.Data.builder()
                            .putAdditionalProperty("key", JsonValue.from("bar"))
                            .build()
                    )
                    .endingAt(null)
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
                    .scheduledAt(null)
                    .tenant("acme_corp")
                    .build()
            )

        schedules.forEach { it.validate() }
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun list() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val scheduleService = client.schedules()

        val page = scheduleService.list(ScheduleListParams.builder().workflow("workflow").build())

        page.response().validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun delete() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val scheduleService = client.schedules()

        val schedules =
            scheduleService.delete(
                ScheduleDeleteParams.builder()
                    .addScheduleId("123e4567-e89b-12d3-a456-426614174000")
                    .build()
            )

        schedules.forEach { it.validate() }
    }
}
