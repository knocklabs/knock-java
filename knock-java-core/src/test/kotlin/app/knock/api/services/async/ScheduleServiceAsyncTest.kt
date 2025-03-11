// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async

import app.knock.api.TestServerExtension
import app.knock.api.client.okhttp.KnockOkHttpClientAsync
import app.knock.api.core.JsonValue
import app.knock.api.models.schedules.ScheduleCreateParams
import app.knock.api.models.schedules.ScheduleDeleteParams
import app.knock.api.models.schedules.ScheduleListParams
import app.knock.api.models.schedules.ScheduleRepeatRule
import app.knock.api.models.schedules.ScheduleUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class ScheduleServiceAsyncTest {

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun create() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val scheduleServiceAsync = client.schedules()

        val schedulesFuture =
            scheduleServiceAsync.create(
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

        val schedules = schedulesFuture.get()
        schedules.forEach { it.validate() }
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun update() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val scheduleServiceAsync = client.schedules()

        val schedulesFuture =
            scheduleServiceAsync.update(
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

        val schedules = schedulesFuture.get()
        schedules.forEach { it.validate() }
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun list() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val scheduleServiceAsync = client.schedules()

        val pageFuture =
            scheduleServiceAsync.list(ScheduleListParams.builder().workflow("workflow").build())

        val page = pageFuture.get()
        page.response().validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun delete() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val scheduleServiceAsync = client.schedules()

        val schedulesFuture =
            scheduleServiceAsync.delete(
                ScheduleDeleteParams.builder()
                    .addScheduleId("123e4567-e89b-12d3-a456-426614174000")
                    .build()
            )

        val schedules = schedulesFuture.get()
        schedules.forEach { it.validate() }
    }
}
