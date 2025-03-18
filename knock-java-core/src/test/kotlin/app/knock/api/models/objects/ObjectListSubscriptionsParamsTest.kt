// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ObjectListSubscriptionsParamsTest {

    @Test
    fun create() {
        ObjectListSubscriptionsParams.builder()
            .collection("collection")
            .objectId("object_id")
            .after("after")
            .before("before")
            .mode(ObjectListSubscriptionsParams.Mode.RECIPIENT)
            .addObject("user_123")
            .pageSize(0L)
            .addRecipient("user_123")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            ObjectListSubscriptionsParams.builder()
                .collection("collection")
                .objectId("object_id")
                .after("after")
                .before("before")
                .mode(ObjectListSubscriptionsParams.Mode.RECIPIENT)
                .addObject("user_123")
                .pageSize(0L)
                .addRecipient("user_123")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "after")
                    .put("before", "before")
                    .put("mode", "recipient")
                    .put("objects[]", "user_123")
                    .put("page_size", "0")
                    .put("recipients[]", "user_123")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            ObjectListSubscriptionsParams.builder()
                .collection("collection")
                .objectId("object_id")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }

    @Test
    fun getPathParam() {
        val params =
            ObjectListSubscriptionsParams.builder()
                .collection("collection")
                .objectId("object_id")
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
