// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async.users

import app.knock.api.TestServerExtension
import app.knock.api.client.okhttp.KnockOkHttpClientAsync
import app.knock.api.core.JsonValue
import app.knock.api.models.users.guides.GuideGetChannelParams
import app.knock.api.models.users.guides.GuideMarkMessageAsArchivedParams
import app.knock.api.models.users.guides.GuideMarkMessageAsInteractedParams
import app.knock.api.models.users.guides.GuideMarkMessageAsSeenParams
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
                .bearerToken("My Bearer Token")
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
                .bearerToken("My Bearer Token")
                .build()
        val guideServiceAsync = client.users().guides()

        val responseFuture =
            guideServiceAsync.markMessageAsArchived(
                GuideMarkMessageAsArchivedParams.builder()
                    .userId("user_id")
                    .messageId("message_id")
                    .channelId("123e4567-e89b-12d3-a456-426614174000")
                    .guideId("323e4567-e89b-12d3-a456-426614174000")
                    .guideKey("guide_12345")
                    .guideStepRef("step_12345")
                    .content(
                        JsonValue.from(
                            mapOf("body" to "Guide content body", "title" to "Guide Title")
                        )
                    )
                    .data(JsonValue.from(mapOf("product_id" to "product_123")))
                    .isFinal(true)
                    .metadata(
                        GuideMarkMessageAsArchivedParams.Metadata.builder()
                            .putAdditionalProperty("source", JsonValue.from("bar"))
                            .build()
                    )
                    .tenant("tenant_12345")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun markMessageAsInteracted() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val guideServiceAsync = client.users().guides()

        val responseFuture =
            guideServiceAsync.markMessageAsInteracted(
                GuideMarkMessageAsInteractedParams.builder()
                    .userId("user_id")
                    .messageId("message_id")
                    .channelId("123e4567-e89b-12d3-a456-426614174000")
                    .guideId("323e4567-e89b-12d3-a456-426614174000")
                    .guideKey("guide_12345")
                    .guideStepRef("step_12345")
                    .content(
                        JsonValue.from(
                            mapOf("body" to "Guide content body", "title" to "Guide Title")
                        )
                    )
                    .data(JsonValue.from(mapOf("product_id" to "product_123")))
                    .isFinal(true)
                    .metadata(
                        GuideMarkMessageAsInteractedParams.Metadata.builder()
                            .putAdditionalProperty("source", JsonValue.from("bar"))
                            .build()
                    )
                    .tenant("tenant_12345")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun markMessageAsSeen() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val guideServiceAsync = client.users().guides()

        val responseFuture =
            guideServiceAsync.markMessageAsSeen(
                GuideMarkMessageAsSeenParams.builder()
                    .userId("user_id")
                    .messageId("message_id")
                    .channelId("123e4567-e89b-12d3-a456-426614174000")
                    .guideId("323e4567-e89b-12d3-a456-426614174000")
                    .guideKey("guide_12345")
                    .guideStepRef("step_12345")
                    .content(
                        JsonValue.from(
                            mapOf("body" to "Guide content body", "title" to "Guide Title")
                        )
                    )
                    .data(JsonValue.from(mapOf("product_id" to "product_123")))
                    .isFinal(true)
                    .metadata(
                        GuideMarkMessageAsSeenParams.Metadata.builder()
                            .putAdditionalProperty("source", JsonValue.from("bar"))
                            .build()
                    )
                    .tenant("tenant_12345")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
