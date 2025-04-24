// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.schedules.bulk

import app.knock.api.core.JsonValue
import app.knock.api.models.recipients.channeldata.InlineChannelDataRequest
import app.knock.api.models.recipients.preferences.InlinePreferenceSetRequest
import app.knock.api.models.schedules.ScheduleRepeatRule
import app.knock.api.models.users.InlineIdentifyUserRequest
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BulkCreateParamsTest {

    @Test
    fun create() {
        BulkCreateParams.builder()
            .addSchedule(
                BulkCreateParams.Schedule.builder()
                    .workflow("comment-created")
                    .actor(
                        InlineIdentifyUserRequest.builder()
                            .id("user_1")
                            .channelData(
                                InlineChannelDataRequest.builder()
                                    .putAdditionalProperty(
                                        "97c5837d-c65c-4d54-aa39-080eeb81c69d",
                                        JsonValue.from(
                                            mapOf(
                                                "data" to
                                                    mapOf(
                                                        "tokens" to listOf("push_token_xxx"),
                                                        "type" to "push_fcm",
                                                        "__typename" to "PushChannelData",
                                                    )
                                            )
                                        ),
                                    )
                                    .build()
                            )
                            .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
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
                            .channelData(
                                InlineChannelDataRequest.builder()
                                    .putAdditionalProperty(
                                        "97c5837d-c65c-4d54-aa39-080eeb81c69d",
                                        JsonValue.from(
                                            mapOf(
                                                "data" to
                                                    mapOf(
                                                        "tokens" to listOf("push_token_xxx"),
                                                        "type" to "push_fcm",
                                                        "__typename" to "PushChannelData",
                                                    )
                                            )
                                        ),
                                    )
                                    .build()
                            )
                            .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
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
    }

    @Test
    fun body() {
        val params =
            BulkCreateParams.builder()
                .addSchedule(
                    BulkCreateParams.Schedule.builder()
                        .workflow("comment-created")
                        .actor(
                            InlineIdentifyUserRequest.builder()
                                .id("user_1")
                                .channelData(
                                    InlineChannelDataRequest.builder()
                                        .putAdditionalProperty(
                                            "97c5837d-c65c-4d54-aa39-080eeb81c69d",
                                            JsonValue.from(
                                                mapOf(
                                                    "data" to
                                                        mapOf(
                                                            "tokens" to listOf("push_token_xxx"),
                                                            "type" to "push_fcm",
                                                            "__typename" to "PushChannelData",
                                                        )
                                                )
                                            ),
                                        )
                                        .build()
                                )
                                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
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
                                .channelData(
                                    InlineChannelDataRequest.builder()
                                        .putAdditionalProperty(
                                            "97c5837d-c65c-4d54-aa39-080eeb81c69d",
                                            JsonValue.from(
                                                mapOf(
                                                    "data" to
                                                        mapOf(
                                                            "tokens" to listOf("push_token_xxx"),
                                                            "type" to "push_fcm",
                                                            "__typename" to "PushChannelData",
                                                        )
                                                )
                                            ),
                                        )
                                        .build()
                                )
                                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
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

        val body = params._body()

        assertThat(body.schedules())
            .containsExactly(
                BulkCreateParams.Schedule.builder()
                    .workflow("comment-created")
                    .actor(
                        InlineIdentifyUserRequest.builder()
                            .id("user_1")
                            .channelData(
                                InlineChannelDataRequest.builder()
                                    .putAdditionalProperty(
                                        "97c5837d-c65c-4d54-aa39-080eeb81c69d",
                                        JsonValue.from(
                                            mapOf(
                                                "data" to
                                                    mapOf(
                                                        "tokens" to listOf("push_token_xxx"),
                                                        "type" to "push_fcm",
                                                        "__typename" to "PushChannelData",
                                                    )
                                            )
                                        ),
                                    )
                                    .build()
                            )
                            .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
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
                    .build(),
                BulkCreateParams.Schedule.builder()
                    .workflow("comment-created")
                    .actor(
                        InlineIdentifyUserRequest.builder()
                            .id("user_1")
                            .channelData(
                                InlineChannelDataRequest.builder()
                                    .putAdditionalProperty(
                                        "97c5837d-c65c-4d54-aa39-080eeb81c69d",
                                        JsonValue.from(
                                            mapOf(
                                                "data" to
                                                    mapOf(
                                                        "tokens" to listOf("push_token_xxx"),
                                                        "type" to "push_fcm",
                                                        "__typename" to "PushChannelData",
                                                    )
                                            )
                                        ),
                                    )
                                    .build()
                            )
                            .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
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
                    .build(),
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            BulkCreateParams.builder()
                .addSchedule(
                    BulkCreateParams.Schedule.builder().workflow("comment-created").build()
                )
                .addSchedule(
                    BulkCreateParams.Schedule.builder().workflow("comment-created").build()
                )
                .build()

        val body = params._body()

        assertThat(body.schedules())
            .containsExactly(
                BulkCreateParams.Schedule.builder().workflow("comment-created").build(),
                BulkCreateParams.Schedule.builder().workflow("comment-created").build(),
            )
    }
}
