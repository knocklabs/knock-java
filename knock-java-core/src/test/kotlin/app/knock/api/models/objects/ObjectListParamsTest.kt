// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ObjectListParamsTest {

    @Test
    fun create() {
      ObjectListParams.builder()
          .collection("collection")
          .after("after")
          .before("before")
          .pageSize(0L)
          .build()
    }

    @Test
    fun queryParams() {
      val params = ObjectListParams.builder()
          .collection("collection")
          .after("after")
          .before("before")
          .pageSize(0L)
          .build()
      val expected = QueryParams.builder()
      expected.put("after", "after")
      expected.put("before", "before")
      expected.put("page_size", "0")
      assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
      val params = ObjectListParams.builder()
          .collection("collection")
          .build()
      val expected = QueryParams.builder()
      assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun getPathParam() {
      val params = ObjectListParams.builder()
          .collection("collection")
          .build()
      assertThat(params).isNotNull
      // path param "collection"
      assertThat(params.getPathParam(0)).isEqualTo("collection")
      // out-of-bound path param
      assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
