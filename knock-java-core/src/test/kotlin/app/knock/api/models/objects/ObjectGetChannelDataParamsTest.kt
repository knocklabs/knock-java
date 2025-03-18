// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ObjectGetChannelDataParamsTest {

    @Test
    fun create() {
        ObjectGetChannelDataParams.builder()
            .collection("collection")
            .objectId("object_id")
            .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            ObjectGetChannelDataParams.builder()
                .collection("collection")
                .objectId("object_id")
                .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("collection")
        assertThat(params._pathParam(1)).isEqualTo("object_id")
        assertThat(params._pathParam(2)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params._pathParam(3)).isEqualTo("")
    }
}
