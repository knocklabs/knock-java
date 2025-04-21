// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking.schedules

import app.knock.api.TestServerExtension
import app.knock.api.client.okhttp.KnockOkHttpClient
import app.knock.api.core.JsonValue
import app.knock.api.models.UnnamedSchemaWithArrayParent0
import app.knock.api.models.UnnamedSchemaWithArrayParent1
import app.knock.api.models.recipients.channeldata.PushChannelData
import app.knock.api.models.recipients.preferences.PreferenceSetChannelTypes
import app.knock.api.models.schedules.ScheduleRepeatRule
import app.knock.api.models.schedules.bulk.BulkCreateParams
import app.knock.api.models.schedules.bulk.BulkCreateSchedulesRequest
import app.knock.api.models.users.InlineIdentifyUserRequest
import java.time.OffsetDateTime
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class BulkServiceTest {

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
        val bulkService = client.schedules().bulk()

        val bulkOperation =
            bulkService.create(
                BulkCreateParams.builder()
                    .bulkCreateSchedulesRequest(
                        BulkCreateSchedulesRequest.builder()
                            .addSchedule(
                                BulkCreateSchedulesRequest.Schedule.builder()
                                    .workflow("comment-created")
                                    .actor(
                                        InlineIdentifyUserRequest.builder()
                                            .id("user_1")
                                            .addChannelData(
                                                UnnamedSchemaWithArrayParent0.builder()
                                                    .channelId(
                                                        "97c5837d-c65c-4d54-aa39-080eeb81c69d"
                                                    )
                                                    .data(
                                                        PushChannelData.builder()
                                                            ._typename(
                                                                PushChannelData._Typename
                                                                    .PUSH_CHANNEL_DATA
                                                            )
                                                            .addToken("push_token_xxx")
                                                            .build()
                                                    )
                                                    .build()
                                            )
                                            .createdAt(
                                                OffsetDateTime.parse("2019-12-27T18:11:19.117Z")
                                            )
                                            .addPreference(
                                                UnnamedSchemaWithArrayParent1.builder()
                                                    .id("default")
                                                    .categories(
                                                        UnnamedSchemaWithArrayParent1.Categories
                                                            .builder()
                                                            .putAdditionalProperty(
                                                                "transactional",
                                                                JsonValue.from(
                                                                    mapOf(
                                                                        "channel_types" to
                                                                            mapOf(
                                                                                "chat" to true,
                                                                                "email" to false,
                                                                                "http" to true,
                                                                                "in_app_feed" to
                                                                                    true,
                                                                                "push" to true,
                                                                                "sms" to true,
                                                                            ),
                                                                        "conditions" to
                                                                            listOf(
                                                                                mapOf(
                                                                                    "argument" to
                                                                                        "some_property",
                                                                                    "operator" to
                                                                                        "equal_to",
                                                                                    "variable" to
                                                                                        "recipient.property",
                                                                                )
                                                                            ),
                                                                    )
                                                                ),
                                                            )
                                                            .build()
                                                    )
                                                    .channelTypes(
                                                        PreferenceSetChannelTypes.builder()
                                                            .chat(true)
                                                            .email(true)
                                                            .http(true)
                                                            .inAppFeed(true)
                                                            .push(true)
                                                            .sms(true)
                                                            .build()
                                                    )
                                                    .workflows(
                                                        UnnamedSchemaWithArrayParent1.Workflows
                                                            .builder()
                                                            .putAdditionalProperty(
                                                                "dinosaurs-loose",
                                                                JsonValue.from(
                                                                    mapOf(
                                                                        "channel_types" to
                                                                            mapOf(
                                                                                "chat" to true,
                                                                                "email" to true,
                                                                                "http" to true,
                                                                                "in_app_feed" to
                                                                                    true,
                                                                                "push" to true,
                                                                                "sms" to true,
                                                                            ),
                                                                        "conditions" to
                                                                            listOf(
                                                                                mapOf(
                                                                                    "argument" to
                                                                                        "some_property",
                                                                                    "operator" to
                                                                                        "equal_to",
                                                                                    "variable" to
                                                                                        "recipient.property",
                                                                                )
                                                                            ),
                                                                    )
                                                                ),
                                                            )
                                                            .build()
                                                    )
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .data(
                                        BulkCreateSchedulesRequest.Schedule.Data.builder()
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
                                BulkCreateSchedulesRequest.Schedule.builder()
                                    .workflow("comment-created")
                                    .actor(
                                        InlineIdentifyUserRequest.builder()
                                            .id("user_1")
                                            .addChannelData(
                                                UnnamedSchemaWithArrayParent0.builder()
                                                    .channelId(
                                                        "97c5837d-c65c-4d54-aa39-080eeb81c69d"
                                                    )
                                                    .data(
                                                        PushChannelData.builder()
                                                            ._typename(
                                                                PushChannelData._Typename
                                                                    .PUSH_CHANNEL_DATA
                                                            )
                                                            .addToken("push_token_xxx")
                                                            .build()
                                                    )
                                                    .build()
                                            )
                                            .createdAt(
                                                OffsetDateTime.parse("2019-12-27T18:11:19.117Z")
                                            )
                                            .addPreference(
                                                UnnamedSchemaWithArrayParent1.builder()
                                                    .id("default")
                                                    .categories(
                                                        UnnamedSchemaWithArrayParent1.Categories
                                                            .builder()
                                                            .putAdditionalProperty(
                                                                "transactional",
                                                                JsonValue.from(
                                                                    mapOf(
                                                                        "channel_types" to
                                                                            mapOf(
                                                                                "chat" to true,
                                                                                "email" to false,
                                                                                "http" to true,
                                                                                "in_app_feed" to
                                                                                    true,
                                                                                "push" to true,
                                                                                "sms" to true,
                                                                            ),
                                                                        "conditions" to
                                                                            listOf(
                                                                                mapOf(
                                                                                    "argument" to
                                                                                        "some_property",
                                                                                    "operator" to
                                                                                        "equal_to",
                                                                                    "variable" to
                                                                                        "recipient.property",
                                                                                )
                                                                            ),
                                                                    )
                                                                ),
                                                            )
                                                            .build()
                                                    )
                                                    .channelTypes(
                                                        PreferenceSetChannelTypes.builder()
                                                            .chat(true)
                                                            .email(true)
                                                            .http(true)
                                                            .inAppFeed(true)
                                                            .push(true)
                                                            .sms(true)
                                                            .build()
                                                    )
                                                    .workflows(
                                                        UnnamedSchemaWithArrayParent1.Workflows
                                                            .builder()
                                                            .putAdditionalProperty(
                                                                "dinosaurs-loose",
                                                                JsonValue.from(
                                                                    mapOf(
                                                                        "channel_types" to
                                                                            mapOf(
                                                                                "chat" to true,
                                                                                "email" to true,
                                                                                "http" to true,
                                                                                "in_app_feed" to
                                                                                    true,
                                                                                "push" to true,
                                                                                "sms" to true,
                                                                            ),
                                                                        "conditions" to
                                                                            listOf(
                                                                                mapOf(
                                                                                    "argument" to
                                                                                        "some_property",
                                                                                    "operator" to
                                                                                        "equal_to",
                                                                                    "variable" to
                                                                                        "recipient.property",
                                                                                )
                                                                            ),
                                                                    )
                                                                ),
                                                            )
                                                            .build()
                                                    )
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .data(
                                        BulkCreateSchedulesRequest.Schedule.Data.builder()
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
                    .build()
            )

        bulkOperation.validate()
    }
}
