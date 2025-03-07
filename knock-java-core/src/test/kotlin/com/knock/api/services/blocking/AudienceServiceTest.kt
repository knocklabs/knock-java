// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.blocking

import com.knock.api.TestServerExtension
import com.knock.api.client.okhttp.KnockOkHttpClient
import com.knock.api.core.JsonValue
import com.knock.api.models.AudienceAddMembersParams
import com.knock.api.models.AudienceListMembersParams
import com.knock.api.models.AudienceRemoveMembersParams
import com.knock.api.models.InlineChannelDataRequest
import com.knock.api.models.InlineIdentifyUserRequest
import com.knock.api.models.InlinePreferenceSetRequest
import java.time.OffsetDateTime
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class AudienceServiceTest {

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun addMembers() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val audienceService = client.audiences()

        audienceService.addMembers(
            AudienceAddMembersParams.builder()
                .key("key")
                .addMember(
                    AudienceAddMembersParams.Member.builder()
                        .user(
                            InlineIdentifyUserRequest.builder()
                                .id("user_1")
                                .channelData(
                                    InlineChannelDataRequest.builder()
                                        .putAdditionalProperty(
                                            "97c5837d-c65c-4d54-aa39-080eeb81c69d",
                                            JsonValue.from(
                                                mapOf(
                                                    "data" to
                                                        mapOf("tokens" to listOf("push_token_xxx"))
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
                                                                                    "some_property",
                                                                                "operator" to
                                                                                    "equal_to",
                                                                                "variable" to
                                                                                    "recipient.property",
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
                                                                            "email" to true,
                                                                            "http" to true,
                                                                            "in_app_feed" to true,
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
                                            ),
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .tenant(null)
                        .build()
                )
                .build()
        )
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun listMembers() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val audienceService = client.audiences()

        val response =
            audienceService.listMembers(AudienceListMembersParams.builder().key("key").build())

        response.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun removeMembers() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val audienceService = client.audiences()

        audienceService.removeMembers(
            AudienceRemoveMembersParams.builder()
                .key("key")
                .addMember(
                    AudienceRemoveMembersParams.Member.builder()
                        .user(
                            InlineIdentifyUserRequest.builder()
                                .id("user_1")
                                .channelData(
                                    InlineChannelDataRequest.builder()
                                        .putAdditionalProperty(
                                            "97c5837d-c65c-4d54-aa39-080eeb81c69d",
                                            JsonValue.from(
                                                mapOf(
                                                    "data" to
                                                        mapOf("tokens" to listOf("push_token_xxx"))
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
                                                                                    "some_property",
                                                                                "operator" to
                                                                                    "equal_to",
                                                                                "variable" to
                                                                                    "recipient.property",
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
                                                                            "email" to true,
                                                                            "http" to true,
                                                                            "in_app_feed" to true,
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
                                            ),
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .tenant(null)
                        .build()
                )
                .build()
        )
    }
}
