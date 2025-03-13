// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users.feeds

import app.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FeedListItemsParamsTest {

    @Test
    fun create() {
        FeedListItemsParams.builder()
            .userId("user_id")
            .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .after("after")
            .archived(FeedListItemsParams.Archived.EXCLUDE)
            .before("before")
            .hasTenant(true)
            .pageSize(0L)
            .source("source")
            .status(FeedListItemsParams.Status.UNREAD)
            .tenant("tenant")
            .triggerData("trigger_data")
            .addWorkflowCategory("string")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            FeedListItemsParams.builder()
                .userId("user_id")
                .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .after("after")
                .archived(FeedListItemsParams.Archived.EXCLUDE)
                .before("before")
                .hasTenant(true)
                .pageSize(0L)
                .source("source")
                .status(FeedListItemsParams.Status.UNREAD)
                .tenant("tenant")
                .triggerData("trigger_data")
                .addWorkflowCategory("string")
                .build()
        val expected = QueryParams.builder()
        expected.put("after", "after")
        expected.put("archived", FeedListItemsParams.Archived.EXCLUDE.toString())
        expected.put("before", "before")
        expected.put("has_tenant", "true")
        expected.put("page_size", "0")
        expected.put("source", "source")
        expected.put("status", FeedListItemsParams.Status.UNREAD.toString())
        expected.put("tenant", "tenant")
        expected.put("trigger_data", "trigger_data")
        expected.put("workflow_categories[]", "string")
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            FeedListItemsParams.builder()
                .userId("user_id")
                .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()
        val expected = QueryParams.builder()
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun getPathParam() {
        val params =
            FeedListItemsParams.builder()
                .userId("user_id")
                .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()
        assertThat(params).isNotNull
        // path param "userId"
        assertThat(params.getPathParam(0)).isEqualTo("user_id")
        // path param "channelId"
        assertThat(params.getPathParam(1)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params.getPathParam(2)).isEqualTo("")
    }
}
