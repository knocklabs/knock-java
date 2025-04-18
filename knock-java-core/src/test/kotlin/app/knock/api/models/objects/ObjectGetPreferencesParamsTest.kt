// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ObjectGetPreferencesParamsTest {

    @Test
    fun create() {
        ObjectGetPreferencesParams.builder()
            .collection("collection")
            .objectId("object_id")
            .preferenceSetId("default")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            ObjectGetPreferencesParams.builder()
                .collection("collection")
                .objectId("object_id")
                .preferenceSetId("default")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("collection")
        assertThat(params._pathParam(1)).isEqualTo("object_id")
        assertThat(params._pathParam(2)).isEqualTo("default")
        // out-of-bound path param
        assertThat(params._pathParam(3)).isEqualTo("")
    }
}
