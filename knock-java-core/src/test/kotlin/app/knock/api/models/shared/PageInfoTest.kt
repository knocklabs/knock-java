// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.shared

import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PageInfoTest {

    @Test
    fun create() {
        val pageInfo =
            PageInfo.builder()._typename("PageInfo").pageSize(25L).after(null).before(null).build()

        assertThat(pageInfo._typename()).isEqualTo("PageInfo")
        assertThat(pageInfo.pageSize()).isEqualTo(25L)
        assertThat(pageInfo.after()).isEmpty
        assertThat(pageInfo.before()).isEmpty
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val pageInfo =
            PageInfo.builder()._typename("PageInfo").pageSize(25L).after(null).before(null).build()

        val roundtrippedPageInfo =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(pageInfo),
                jacksonTypeRef<PageInfo>(),
            )

        assertThat(roundtrippedPageInfo).isEqualTo(pageInfo)
    }
}
