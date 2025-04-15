// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users.bulk

import app.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BulkDeleteParamsTest {

    @Test
    fun create() {
        BulkDeleteParams.builder().addUserId("string").build()
    }

    @Test
    fun queryParams() {
        val params = BulkDeleteParams.builder().addUserId("string").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("user_ids[]", "string").build())
    }
}
