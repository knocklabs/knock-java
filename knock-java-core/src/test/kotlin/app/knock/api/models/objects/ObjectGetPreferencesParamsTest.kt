// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ObjectGetPreferencesParamsTest {

    @Test
    fun create() {
        ObjectGetPreferencesParams.builder()
            .collection("collection")
            .objectId("object_id")
            .preferenceSetId("default")
            .tenant("tenant")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            ObjectGetPreferencesParams.builder()
                .collection("collection")
                .objectId("object_id")
                .preferenceSetId("default")
                .tenant("tenant")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("tenant", "tenant").build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            ObjectGetPreferencesParams.builder()
                .collection("collection")
                .objectId("object_id")
                .preferenceSetId("default")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }

    @Test
    fun getPathParam() {
        val params =
            ObjectGetPreferencesParams.builder()
                .collection("collection")
                .objectId("object_id")
                .preferenceSetId("default")
                .build()
        assertThat(params).isNotNull
        // path param "collection"
        assertThat(params.getPathParam(0)).isEqualTo("collection")
        // path param "objectId"
        assertThat(params.getPathParam(1)).isEqualTo("object_id")
        // path param "preferenceSetId"
        assertThat(params.getPathParam(2)).isEqualTo("default")
        // out-of-bound path param
        assertThat(params.getPathParam(3)).isEqualTo("")
    }
}
