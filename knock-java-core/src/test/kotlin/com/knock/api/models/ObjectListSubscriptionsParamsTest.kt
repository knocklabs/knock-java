// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import com.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ObjectListSubscriptionsParamsTest {

    @Test
    fun create() {
        ObjectListSubscriptionsParams.builder()
            .collection("collection")
            .objectId("object_id")
            .after("after")
            .before("before")
            .mode(ObjectListSubscriptionsParams.Mode.RECIPIENT)
            .addObject("user_123")
            .pageSize(0L)
            .addRecipient("user_123")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            ObjectListSubscriptionsParams.builder()
                .collection("collection")
                .objectId("object_id")
                .after("after")
                .before("before")
                .mode(ObjectListSubscriptionsParams.Mode.RECIPIENT)
                .addObject("user_123")
                .pageSize(0L)
                .addRecipient("user_123")
                .build()
        val expected = QueryParams.builder()
        expected.put("after", "after")
        expected.put("before", "before")
        expected.put("mode", ObjectListSubscriptionsParams.Mode.RECIPIENT.toString())
        expected.put(
            "objects[]",
            ObjectListSubscriptionsParams.Object.ofString("user_123").toString(),
        )
        expected.put("page_size", "0")
        expected.put(
            "recipients[]",
            ObjectListSubscriptionsParams.Recipient.ofString("user_123").toString(),
        )
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            ObjectListSubscriptionsParams.builder()
                .collection("collection")
                .objectId("object_id")
                .build()
        val expected = QueryParams.builder()
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun getPathParam() {
        val params =
            ObjectListSubscriptionsParams.builder()
                .collection("collection")
                .objectId("object_id")
                .build()
        assertThat(params).isNotNull
        // path param "collection"
        assertThat(params.getPathParam(0)).isEqualTo("collection")
        // path param "objectId"
        assertThat(params.getPathParam(1)).isEqualTo("object_id")
        // out-of-bound path param
        assertThat(params.getPathParam(2)).isEqualTo("")
    }
}
