// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models.objects

import com.knock.api.core.JsonValue
import com.knock.api.models.recipients.RecipientRequest
import kotlin.test.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ObjectAddSubscriptionsParamsTest {

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

        assertNotNull(body)
        assertThat(body.recipients())
            .isEqualTo(
                listOf(RecipientRequest.ofString("user_1"), RecipientRequest.ofString("user_2"))
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

        assertNotNull(body)
        assertThat(body.recipients())
            .isEqualTo(
                listOf(RecipientRequest.ofString("user_1"), RecipientRequest.ofString("user_2"))
            )
    }

    @Test
    fun getPathParam() {
        val params =
            ObjectAddSubscriptionsParams.builder()
                .collection("collection")
                .objectId("object_id")
                .addRecipient("user_1")
                .addRecipient("user_2")
                .build()
        assertThat(params).isNotNull
        // path param "collection"
        assertThat(params.getPathParam(0)).isEqualTo("collection")
        // path param "objectId"
        assertThat(params.getPathParam(1)).isEqualTo("object_id")
        // out-of-bound path param
        assertThat(params.getPathParam(2)).isEqualTo("")
    }
}
