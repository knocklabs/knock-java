// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking.users

import app.knock.api.TestServerExtension
import app.knock.api.client.okhttp.KnockOkHttpClient
import app.knock.api.core.JsonValue
import app.knock.api.models.users.guides.GuideGetChannelParams
import app.knock.api.models.users.guides.GuideMarkMessageAsArchivedParams
import app.knock.api.models.users.guides.GuideMarkMessageAsInteractedParams
import app.knock.api.models.users.guides.GuideMarkMessageAsSeenParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class GuideServiceTest {

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun getChannel() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val guideService = client.users().guides()

        val response =
            guideService.getChannel(
                GuideGetChannelParams.builder()
                    .userId("user_id")
                    .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .data("data")
                    .tenant("tenant")
                    .type("type")
                    .build()
            )

        response.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun markMessageAsArchived() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val guideService = client.users().guides()

        val response =
            guideService.markMessageAsArchived(
                GuideMarkMessageAsArchivedParams.builder()
                    .userId("user_id")
                    .messageId("message_id")
                    .channelId("123e4567-e89b-12d3-a456-426614174000")
                    .guideId("7e9dc78c-b3b1-4127-a54e-71f1899b831a")
                    .guideKey("tour_notification")
                    .guideStepRef("lab_tours")
                    .content(
                        GuideMarkMessageAsArchivedParams.Content.builder()
                            .putAdditionalProperty("body", JsonValue.from("bar"))
                            .putAdditionalProperty("title", JsonValue.from("bar"))
                            .build()
                    )
                    .data(
                        GuideMarkMessageAsArchivedParams.Data.builder()
                            .putAdditionalProperty("next_time", JsonValue.from("bar"))
                            .putAdditionalProperty("spots_left", JsonValue.from("bar"))
                            .putAdditionalProperty("tour_id", JsonValue.from("bar"))
                            .build()
                    )
                    .isFinal(false)
                    .metadata(
                        GuideMarkMessageAsArchivedParams.Metadata.builder()
                            .putAdditionalProperty("cta", JsonValue.from("bar"))
                            .putAdditionalProperty("theme", JsonValue.from("bar"))
                            .putAdditionalProperty("type", JsonValue.from("bar"))
                            .build()
                    )
                    .tenant("ingen_isla_nublar")
                    .build()
            )

        response.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun markMessageAsInteracted() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val guideService = client.users().guides()

        val response =
            guideService.markMessageAsInteracted(
                GuideMarkMessageAsInteractedParams.builder()
                    .userId("user_id")
                    .messageId("message_id")
                    .channelId("123e4567-e89b-12d3-a456-426614174000")
                    .guideId("7e9dc78c-b3b1-4127-a54e-71f1899b831a")
                    .guideKey("tour_notification")
                    .guideStepRef("lab_tours")
                    .content(
                        GuideMarkMessageAsInteractedParams.Content.builder()
                            .putAdditionalProperty("body", JsonValue.from("bar"))
                            .putAdditionalProperty("title", JsonValue.from("bar"))
                            .build()
                    )
                    .data(
                        GuideMarkMessageAsInteractedParams.Data.builder()
                            .putAdditionalProperty("next_time", JsonValue.from("bar"))
                            .putAdditionalProperty("spots_left", JsonValue.from("bar"))
                            .putAdditionalProperty("tour_id", JsonValue.from("bar"))
                            .build()
                    )
                    .isFinal(false)
                    .metadata(
                        GuideMarkMessageAsInteractedParams.Metadata.builder()
                            .putAdditionalProperty("cta", JsonValue.from("bar"))
                            .putAdditionalProperty("theme", JsonValue.from("bar"))
                            .putAdditionalProperty("type", JsonValue.from("bar"))
                            .build()
                    )
                    .tenant("ingen_isla_nublar")
                    .build()
            )

        response.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun markMessageAsSeen() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val guideService = client.users().guides()

        val response =
            guideService.markMessageAsSeen(
                GuideMarkMessageAsSeenParams.builder()
                    .userId("user_id")
                    .messageId("message_id")
                    .channelId("123e4567-e89b-12d3-a456-426614174000")
                    .guideId("7e9dc78c-b3b1-4127-a54e-71f1899b831a")
                    .guideKey("tour_notification")
                    .guideStepRef("lab_tours")
                    .content(
                        GuideMarkMessageAsSeenParams.Content.builder()
                            .putAdditionalProperty("body", JsonValue.from("bar"))
                            .putAdditionalProperty("title", JsonValue.from("bar"))
                            .build()
                    )
                    .data(
                        GuideMarkMessageAsSeenParams.Data.builder()
                            .putAdditionalProperty("next_time", JsonValue.from("bar"))
                            .putAdditionalProperty("spots_left", JsonValue.from("bar"))
                            .putAdditionalProperty("tour_id", JsonValue.from("bar"))
                            .build()
                    )
                    .isFinal(false)
                    .metadata(
                        GuideMarkMessageAsSeenParams.Metadata.builder()
                            .putAdditionalProperty("cta", JsonValue.from("bar"))
                            .putAdditionalProperty("theme", JsonValue.from("bar"))
                            .putAdditionalProperty("type", JsonValue.from("bar"))
                            .build()
                    )
                    .tenant("ingen_isla_nublar")
                    .build()
            )

        response.validate()
    }
}
