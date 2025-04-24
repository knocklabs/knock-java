// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking

import app.knock.api.TestServerExtension
import app.knock.api.client.okhttp.KnockOkHttpClient
import app.knock.api.models.UnnamedSchemaWithArrayParent0
import app.knock.api.models.audiences.AudienceAddMembersParams
import app.knock.api.models.audiences.AudienceListMembersParams
import app.knock.api.models.audiences.AudienceRemoveMembersParams
import app.knock.api.models.recipients.channeldata.PushChannelData
import app.knock.api.models.recipients.preferences.InlinePreferenceSetRequest
import app.knock.api.models.users.InlineIdentifyUserRequest
import java.time.OffsetDateTime
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class AudienceServiceTest {

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
                                .id("dr_sattler")
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
                        .tenant("ingen_isla_nublar")
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
                                .id("dr_sattler")
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
                        .tenant("ingen_isla_nublar")
                        .build()
                )
                .build()
        )
    }
}
