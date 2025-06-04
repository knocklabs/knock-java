// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.schedules

import app.knock.api.core.JsonValue
import app.knock.api.models.recipients.RecipientRequest
import app.knock.api.models.recipients.channeldata.InlineChannelDataRequest
import app.knock.api.models.recipients.preferences.InlinePreferenceSetRequest
import app.knock.api.models.tenants.InlineTenantRequest
import app.knock.api.models.users.InlineIdentifyUserRequest
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ScheduleCreateParamsTest {

    @Test
    fun create() {
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
                                                                    "argument" to "frog_genome",
                                                                    "operator" to "contains",
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
                                                                    "argument" to "frog_genome",
                                                                    "operator" to "contains",
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
    }

    @Test
    fun body() {
        val params =
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
                                                                        "argument" to "frog_genome",
                                                                        "operator" to "contains",
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
                                                                        "argument" to "frog_genome",
                                                                        "operator" to "contains",
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

        val body = params._body()

        assertThat(body.recipients()).containsExactly(RecipientRequest.ofUserRecipient("user_123"))
        assertThat(body.workflow()).isEqualTo("comment-created")
        assertThat(body.actor())
            .contains(
                RecipientRequest.ofInlineIdentifyUser(
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
                                                                        "argument" to "frog_genome",
                                                                        "operator" to "contains",
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
                                                                        "argument" to "frog_genome",
                                                                        "operator" to "contains",
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
            )
        assertThat(body.data())
            .contains(
                ScheduleCreateParams.Data.builder()
                    .putAdditionalProperty("key", JsonValue.from("bar"))
                    .build()
            )
        assertThat(body.endingAt()).isEmpty
        assertThat(body.repeats().getOrNull())
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
        assertThat(body.scheduledAt()).isEmpty
        assertThat(body.tenant()).contains(InlineTenantRequest.ofString("acme_corp"))
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            ScheduleCreateParams.builder()
                .addRecipient("user_123")
                .workflow("comment-created")
                .build()

        val body = params._body()

        assertThat(body.recipients()).containsExactly(RecipientRequest.ofUserRecipient("user_123"))
        assertThat(body.workflow()).isEqualTo("comment-created")
    }
}
