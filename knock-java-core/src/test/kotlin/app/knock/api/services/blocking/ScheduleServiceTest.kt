// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking

import app.knock.api.TestServerExtension
import app.knock.api.client.okhttp.KnockOkHttpClient
import app.knock.api.core.JsonValue
import app.knock.api.models.recipients.channeldata.InlineChannelDataRequest
import app.knock.api.models.recipients.preferences.InlinePreferenceSetRequest
import app.knock.api.models.schedules.ScheduleCreateParams
import app.knock.api.models.schedules.ScheduleDeleteParams
import app.knock.api.models.schedules.ScheduleListParams
import app.knock.api.models.schedules.ScheduleRepeatRule
import app.knock.api.models.schedules.ScheduleUpdateParams
import app.knock.api.models.users.InlineIdentifyUserRequest
import java.time.OffsetDateTime
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ScheduleServiceTest {

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun create() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val scheduleService = client.schedules()

        val schedules =
            scheduleService.create(
                ScheduleCreateParams.builder()
                    .addRecipient("user_123")
                    .workflow("comment-created")
                    .actor(
                        InlineIdentifyUserRequest.builder()
                            .id("user_1")
                            .avatar("avatar")
                            .channelData(
                                InlineChannelDataRequest.builder()
                                    .putAdditionalProperty(
                                        "97c5837d-c65c-4d54-aa39-080eeb81c69d",
                                        JsonValue.from(mapOf("tokens" to listOf("push_token_xxx"))),
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
                                                                        "in_app_feed" to true,
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
                                                                        "in_app_feed" to true,
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
                        ScheduleCreateParams.Data.builder()
                            .putAdditionalProperty("key", JsonValue.from("bar"))
                            .build()
                    )
                    .endingAt(null)
                    .addRepeat(
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
    fun update() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
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
                .apiKey("My API Key")
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
                .apiKey("My API Key")
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
