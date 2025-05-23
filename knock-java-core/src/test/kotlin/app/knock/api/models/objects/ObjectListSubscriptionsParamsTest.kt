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
            .addInclude(ObjectListSubscriptionsParams.Include.PREFERENCES)
            .mode(ObjectListSubscriptionsParams.Mode.RECIPIENT)
            .addObject(
                ObjectListSubscriptionsParams.Object.builder()
                    .id("project_123")
                    .collection("projects")
                    .build()
            )
            .pageSize(0L)
            .addRecipient("user_123")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            ObjectListSubscriptionsParams.builder()
                .collection("collection")
                .objectId("object_id")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("collection")
        assertThat(params._pathParam(1)).isEqualTo("object_id")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            ObjectListSubscriptionsParams.builder()
                .collection("collection")
                .objectId("object_id")
                .after("after")
                .before("before")
                .addInclude(ObjectListSubscriptionsParams.Include.PREFERENCES)
                .mode(ObjectListSubscriptionsParams.Mode.RECIPIENT)
                .addObject(
                    ObjectListSubscriptionsParams.Object.builder()
                        .id("project_123")
                        .collection("projects")
                        .build()
                )
                .pageSize(0L)
                .addRecipient("user_123")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "after")
                    .put("before", "before")
                    .put("include[]", "preferences")
                    .put("mode", "recipient")
                    .put("objects[][id]", "project_123")
                    .put("objects[][collection]", "projects")
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
}
