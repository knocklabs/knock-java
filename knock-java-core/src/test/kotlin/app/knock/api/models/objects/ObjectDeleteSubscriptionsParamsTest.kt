// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.models.recipients.RecipientReference
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ObjectDeleteSubscriptionsParamsTest {

    @Test
    fun create() {
        ObjectDeleteSubscriptionsParams.builder()
            .collection("collection")
            .objectId("object_id")
            .addRecipient("user_123")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            ObjectDeleteSubscriptionsParams.builder()
                .collection("collection")
                .objectId("object_id")
                .addRecipient("user_123")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("collection")
        assertThat(params._pathParam(1)).isEqualTo("object_id")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            ObjectDeleteSubscriptionsParams.builder()
                .collection("collection")
                .objectId("object_id")
                .addRecipient("user_123")
                .build()

        val body = params._body()

        assertThat(body.recipients()).containsExactly(RecipientReference.ofUser("user_123"))
    }
}
