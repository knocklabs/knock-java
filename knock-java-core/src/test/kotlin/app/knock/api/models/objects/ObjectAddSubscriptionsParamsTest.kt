// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.core.JsonValue
import app.knock.api.models.recipients.RecipientRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ObjectAddSubscriptionsParamsTest {

    @Test
    fun create() {
        ObjectAddSubscriptionsParams.builder()
            .collection("collection")
            .objectId("object_id")
            .addRecipient("user_1")
            .addRecipient("user_2")
            .properties(
                ObjectAddSubscriptionsParams.Properties.builder()
                    .putAdditionalProperty("key", JsonValue.from("bar"))
                    .build()
            )
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            ObjectAddSubscriptionsParams.builder()
                .collection("collection")
                .objectId("object_id")
                .addRecipient("user_1")
                .addRecipient("user_2")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("collection")
        assertThat(params._pathParam(1)).isEqualTo("object_id")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            ObjectAddSubscriptionsParams.builder()
                .collection("collection")
                .objectId("object_id")
                .addRecipient("user_1")
                .addRecipient("user_2")
                .properties(
                    ObjectAddSubscriptionsParams.Properties.builder()
                        .putAdditionalProperty("key", JsonValue.from("bar"))
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.recipients())
            .containsExactly(
                RecipientRequest.ofUserRecipient("user_1"),
                RecipientRequest.ofUserRecipient("user_2"),
            )
        assertThat(body.properties())
            .contains(
                ObjectAddSubscriptionsParams.Properties.builder()
                    .putAdditionalProperty("key", JsonValue.from("bar"))
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            ObjectAddSubscriptionsParams.builder()
                .collection("collection")
                .objectId("object_id")
                .addRecipient("user_1")
                .addRecipient("user_2")
                .build()

        val body = params._body()

        assertThat(body.recipients())
            .containsExactly(
                RecipientRequest.ofUserRecipient("user_1"),
                RecipientRequest.ofUserRecipient("user_2"),
            )
    }
}
