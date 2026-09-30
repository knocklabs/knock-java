// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async.users

import app.knock.api.TestServerExtension
import app.knock.api.client.okhttp.KnockOkHttpClientAsync
import app.knock.api.core.JsonValue
import app.knock.api.models.users.guides.GuideGetChannelParams
import app.knock.api.models.users.guides.GuideMarkMessageAsArchivedParams
import app.knock.api.models.users.guides.GuideMarkMessageAsInteractedParams
import app.knock.api.models.users.guides.GuideMarkMessageAsSeenParams
import app.knock.api.models.users.guides.GuideResetGuideEngagementsParams
import app.knock.api.models.users.guides.GuideUnarchiveGuideMessageParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class GuideServiceAsyncTest {

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun getChannel() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val guideServiceAsync = client.users().guides()

        val responseFuture =
            guideServiceAsync.getChannel(
                GuideGetChannelParams.builder()
                    .userId("user_id")
                    .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .data("data")
                    .tenant("tenant")
                    .type("type")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun markMessageAsArchived() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val guideServiceAsync = client.users().guides()

        val guideActionResponseFuture =
            guideServiceAsync.markMessageAsArchived(
                GuideMarkMessageAsArchivedParams.builder()
                    .userId("user_id")
                    .channelId("123e4567-e89b-12d3-a456-426614174000")
                    .guideId("7e9dc78c-b3b1-4127-a54e-71f1899b831a")
                    .guideKey("tour_notification")
                    .guideStepRef("lab_tours")
                    .isFinal(false)
                    .tenant("ingen_isla_nublar")
                    .unthrottled(false)
                    .build()
            )

        val guideActionResponse = guideActionResponseFuture.get()
        guideActionResponse.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun markMessageAsInteracted() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val guideServiceAsync = client.users().guides()

        val guideActionResponseFuture =
            guideServiceAsync.markMessageAsInteracted(
                GuideMarkMessageAsInteractedParams.builder()
                    .userId("user_id")
                    .channelId("123e4567-e89b-12d3-a456-426614174000")
                    .guideId("7e9dc78c-b3b1-4127-a54e-71f1899b831a")
                    .guideKey("tour_notification")
                    .guideStepRef("lab_tours")
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

        val guideActionResponse = guideActionResponseFuture.get()
        guideActionResponse.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun markMessageAsSeen() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val guideServiceAsync = client.users().guides()

        val guideActionResponseFuture =
            guideServiceAsync.markMessageAsSeen(
                GuideMarkMessageAsSeenParams.builder()
                    .userId("user_id")
                    .channelId("123e4567-e89b-12d3-a456-426614174000")
                    .content(
                        GuideMarkMessageAsSeenParams.Content.builder()
                            .putAdditionalProperty("body", JsonValue.from("bar"))
                            .putAdditionalProperty("title", JsonValue.from("bar"))
                            .build()
                    )
                    .guideId("7e9dc78c-b3b1-4127-a54e-71f1899b831a")
                    .guideKey("tour_notification")
                    .guideStepRef("lab_tours")
                    .data(
                        GuideMarkMessageAsSeenParams.Data.builder()
                            .putAdditionalProperty("next_time", JsonValue.from("bar"))
                            .putAdditionalProperty("spots_left", JsonValue.from("bar"))
                            .putAdditionalProperty("tour_id", JsonValue.from("bar"))
                            .build()
                    )
                    .tenant("ingen_isla_nublar")
                    .build()
            )

        val guideActionResponse = guideActionResponseFuture.get()
        guideActionResponse.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun resetGuideEngagements() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val guideServiceAsync = client.users().guides()

        val guideActionResponseFuture =
            guideServiceAsync.resetGuideEngagements(
                GuideResetGuideEngagementsParams.builder()
                    .userId("user_id")
                    .guideKey("tour_notification")
                    .tenant("ingen_isla_nublar")
                    .build()
            )

        val guideActionResponse = guideActionResponseFuture.get()
        guideActionResponse.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun unarchiveGuideMessage() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val guideServiceAsync = client.users().guides()

        val guideActionResponseFuture =
            guideServiceAsync.unarchiveGuideMessage(
                GuideUnarchiveGuideMessageParams.builder()
                    .userId("user_id")
                    .guideKey("tour_notification")
                    .tenant("ingen_isla_nublar")
                    .build()
            )

        val guideActionResponse = guideActionResponseFuture.get()
        guideActionResponse.validate()
    }
}
