// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.audiences

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AudienceRemoveMembersParamsTest {

    @Test
    fun create() {
        AudienceRemoveMembersParams.builder().key("key").build()
    }

    @Test
    fun pathParams() {
        val params = AudienceRemoveMembersParams.builder().key("key").build()

        assertThat(params._pathParam(0)).isEqualTo("key")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
