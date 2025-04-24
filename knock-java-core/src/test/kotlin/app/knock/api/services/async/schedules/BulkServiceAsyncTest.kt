// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async.schedules

import app.knock.api.TestServerExtension
import app.knock.api.client.okhttp.KnockOkHttpClientAsync
import app.knock.api.core.JsonValue
import app.knock.api.models.UnnamedSchemaWithArrayParent0
import app.knock.api.models.recipients.channeldata.PushChannelData
import app.knock.api.models.recipients.preferences.InlinePreferenceSetRequest
import app.knock.api.models.schedules.ScheduleRepeatRule
import app.knock.api.models.schedules.bulk.BulkCreateParams
import app.knock.api.models.users.InlineIdentifyUserRequest
import java.time.OffsetDateTime
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class BulkServiceAsyncTest {

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
        val bulkServiceAsync = client.schedules().bulk()

        val bulkOperationFuture =
            bulkServiceAsync.create(
                BulkCreateParams.builder()
                    .addSchedule(
                        BulkCreateParams.Schedule.builder()
                            .workflow("comment-created")
                            .actor(
                                InlineIdentifyUserRequest.builder()
                                    .id("user_1")
                                    .addChannelData(
                                        UnnamedSchemaWithArrayParent0.builder()
                                            .channelId("97c5837d-c65c-4d54-aa39-080eeb81c69d")
                                            .data(
                                                PushChannelData.builder()
                                                    .addToken("push_token_xxx")
                                                    .type(PushChannelData.Type.PUSH_FCM)
                                                    ._typename(
                                                        PushChannelData._Typename.PUSH_CHANNEL_DATA
                                                    )
                                                    .build()
                                            )
                                            .provider("push_fcm")
                                            .build()
                                    )
                                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                    .preferences(InlinePreferenceSetRequest.builder().build())
                                    .build()
                            )
                            .data(
                                BulkCreateParams.Schedule.Data.builder()
                                    .putAdditionalProperty("key", JsonValue.from("bar"))
                                    .build()
                            )
                            .endingAt(null)
                            .recipient("dnedry")
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
                    .addSchedule(
                        BulkCreateParams.Schedule.builder()
                            .workflow("comment-created")
                            .actor(
                                InlineIdentifyUserRequest.builder()
                                    .id("user_1")
                                    .addChannelData(
                                        UnnamedSchemaWithArrayParent0.builder()
                                            .channelId("97c5837d-c65c-4d54-aa39-080eeb81c69d")
                                            .data(
                                                PushChannelData.builder()
                                                    .addToken("push_token_xxx")
                                                    .type(PushChannelData.Type.PUSH_FCM)
                                                    ._typename(
                                                        PushChannelData._Typename.PUSH_CHANNEL_DATA
                                                    )
                                                    .build()
                                            )
                                            .provider("push_fcm")
                                            .build()
                                    )
                                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                    .preferences(InlinePreferenceSetRequest.builder().build())
                                    .build()
                            )
                            .data(
                                BulkCreateParams.Schedule.Data.builder()
                                    .putAdditionalProperty("key", JsonValue.from("bar"))
                                    .build()
                            )
                            .endingAt(null)
                            .recipient("esattler")
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
                    .build()
            )

        val bulkOperation = bulkOperationFuture.get()
        bulkOperation.validate()
    }
}
