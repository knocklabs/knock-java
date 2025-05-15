// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async.schedules

import app.knock.api.TestServerExtension
import app.knock.api.client.okhttp.KnockOkHttpClientAsync
import app.knock.api.core.JsonValue
import app.knock.api.models.recipients.channeldata.InlineChannelDataRequest
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
                .apiKey("My API Key")
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
                                    .avatar("avatar")
                                    .channelData(
                                        InlineChannelDataRequest.builder()
                                            .putAdditionalProperty(
                                                "97c5837d-c65c-4d54-aa39-080eeb81c69d",
                                                JsonValue.from(
                                                    mapOf("tokens" to listOf("push_token_xxx"))
                                                ),
                                            )
                                            .build()
                                    )
                                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                    .email("email")
                                    .locale("locale")
                                    .name("name")
                                    .phoneNumber("phone_number")
                                    .preferences(
                                        InlinePreferenceSetRequest.builder()
                                            .putAdditionalProperty(
                                                "default",
                                                JsonValue.from(
                                                    mapOf(
                                                        "categories" to
                                                            mapOf(
                                                                "transactional" to
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
                                                                                        "frog_genome",
                                                                                    "operator" to
                                                                                        "contains",
                                                                                    "variable" to
                                                                                        "specimen.dna_sequence",
                                                                                )
                                                                            ),
                                                                    )
                                                            ),
                                                        "channel_types" to
                                                            mapOf(
                                                                "chat" to true,
                                                                "email" to true,
                                                                "http" to true,
                                                                "in_app_feed" to true,
                                                                "push" to true,
                                                                "sms" to true,
                                                            ),
                                                        "workflows" to
                                                            mapOf(
                                                                "dinosaurs-loose" to
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
                                                                                        "frog_genome",
                                                                                    "operator" to
                                                                                        "contains",
                                                                                    "variable" to
                                                                                        "specimen.dna_sequence",
                                                                                )
                                                                            ),
                                                                    ),
                                                                "welcome-sequence" to true,
                                                            ),
                                                    )
                                                ),
                                            )
                                            .build()
                                    )
                                    .timezone("timezone")
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
                                    .avatar("avatar")
                                    .channelData(
                                        InlineChannelDataRequest.builder()
                                            .putAdditionalProperty(
                                                "97c5837d-c65c-4d54-aa39-080eeb81c69d",
                                                JsonValue.from(
                                                    mapOf("tokens" to listOf("push_token_xxx"))
                                                ),
                                            )
                                            .build()
                                    )
                                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                    .email("email")
                                    .locale("locale")
                                    .name("name")
                                    .phoneNumber("phone_number")
                                    .preferences(
                                        InlinePreferenceSetRequest.builder()
                                            .putAdditionalProperty(
                                                "default",
                                                JsonValue.from(
                                                    mapOf(
                                                        "categories" to
                                                            mapOf(
                                                                "transactional" to
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
                                                                                        "frog_genome",
                                                                                    "operator" to
                                                                                        "contains",
                                                                                    "variable" to
                                                                                        "specimen.dna_sequence",
                                                                                )
                                                                            ),
                                                                    )
                                                            ),
                                                        "channel_types" to
                                                            mapOf(
                                                                "chat" to true,
                                                                "email" to true,
                                                                "http" to true,
                                                                "in_app_feed" to true,
                                                                "push" to true,
                                                                "sms" to true,
                                                            ),
                                                        "workflows" to
                                                            mapOf(
                                                                "dinosaurs-loose" to
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
                                                                                        "frog_genome",
                                                                                    "operator" to
                                                                                        "contains",
                                                                                    "variable" to
                                                                                        "specimen.dna_sequence",
                                                                                )
                                                                            ),
                                                                    ),
                                                                "welcome-sequence" to true,
                                                            ),
                                                    )
                                                ),
                                            )
                                            .build()
                                    )
                                    .timezone("timezone")
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
