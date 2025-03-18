// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.tenants

import app.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TenantListParamsTest {

    @Test
    fun create() {
        TenantListParams.builder().after("after").before("before").pageSize(0L).build()
    }

    @Test
    fun queryParams() {
        val params = TenantListParams.builder().after("after").before("before").pageSize(0L).build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "after")
                    .put("before", "before")
                    .put("page_size", "0")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = TenantListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
