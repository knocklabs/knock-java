// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects.bulk

import app.knock.api.core.jsonMapper
import app.knock.api.models.recipients.RecipientReference
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BulkDeleteSubscriptionsParamsTest {

    @Test
    fun create() {
        BulkDeleteSubscriptionsParams.builder()
            .collection("projects")
            .addSubscription(
                BulkDeleteSubscriptionsParams.Subscription.builder()
                    .id("project-1")
                    .addRecipient("user_1")
                    .build()
            )
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            BulkDeleteSubscriptionsParams.builder()
                .collection("projects")
                .addSubscription(
                    BulkDeleteSubscriptionsParams.Subscription.builder()
                        .id("project-1")
                        .addRecipient("user_1")
                        .build()
                )
                .build()

        assertThat(params._pathParam(0)).isEqualTo("projects")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            BulkDeleteSubscriptionsParams.builder()
                .collection("projects")
                .addSubscription(
                    BulkDeleteSubscriptionsParams.Subscription.builder()
                        .id("project-1")
                        .addRecipient("user_1")
                        .addRecipient(
                            RecipientReference.ObjectReference.builder()
                                .id("team-1")
                                .collection("teams")
                                .build()
                        )
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.subscriptions())
            .containsExactly(
                BulkDeleteSubscriptionsParams.Subscription.builder()
                    .id("project-1")
                    .addRecipient("user_1")
                    .addRecipient(
                        RecipientReference.ObjectReference.builder()
                            .id("team-1")
                            .collection("teams")
                            .build()
                    )
                    .build()
            )
        assertThat(jsonMapper().writeValueAsString(body))
            .isEqualTo(
                """{"subscriptions":[{"id":"project-1","recipients":["user_1",{"id":"team-1","collection":"teams"}]}]}"""
            )
    }
}
