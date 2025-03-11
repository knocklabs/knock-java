// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models.audiences

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AudienceListMembersParamsTest {

    @Test
    fun create() {
        AudienceListMembersParams.builder().key("key").build()
    }

    @Test
    fun getPathParam() {
        val params = AudienceListMembersParams.builder().key("key").build()
        assertThat(params).isNotNull
        // path param "key"
        assertThat(params.getPathParam(0)).isEqualTo("key")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
