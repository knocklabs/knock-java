// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users.feeds

import app.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FeedListItemsParamsTest {

    @Test
    fun create() {
        FeedListItemsParams.builder()
            .userId("user_id")
            .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .after("after")
            .archived(FeedListItemsParams.Archived.EXCLUDE)
            .before("before")
            .exclude("exclude")
            .hasTenant(true)
            .insertedAt(
                FeedListItemsParams.InsertedAt.builder()
                    .gt("gt")
                    .gte("gte")
                    .lt("lt")
                    .lte("lte")
                    .build()
            )
            .locale("locale")
            .mode(FeedListItemsParams.Mode.COMPACT)
            .pageSize(0L)
            .source("source")
            .status(FeedListItemsParams.Status.UNREAD)
            .tenant("tenant")
            .triggerData("trigger_data")
            .addWorkflowCategory("string")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            FeedListItemsParams.builder()
                .userId("user_id")
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("user_id")
        assertThat(params._pathParam(1)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            FeedListItemsParams.builder()
                .userId("user_id")
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .after("after")
                .archived(FeedListItemsParams.Archived.EXCLUDE)
                .before("before")
                .exclude("exclude")
                .hasTenant(true)
                .insertedAt(
                    FeedListItemsParams.InsertedAt.builder()
                        .gt("gt")
                        .gte("gte")
                        .lt("lt")
                        .lte("lte")
                        .build()
                )
                .locale("locale")
                .mode(FeedListItemsParams.Mode.COMPACT)
                .pageSize(0L)
                .source("source")
                .status(FeedListItemsParams.Status.UNREAD)
                .tenant("tenant")
                .triggerData("trigger_data")
                .addWorkflowCategory("string")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "after")
                    .put("archived", "exclude")
                    .put("before", "before")
                    .put("exclude", "exclude")
                    .put("has_tenant", "true")
                    .put("inserted_at.gt", "gt")
                    .put("inserted_at.gte", "gte")
                    .put("inserted_at.lt", "lt")
                    .put("inserted_at.lte", "lte")
                    .put("locale", "locale")
                    .put("mode", "compact")
                    .put("page_size", "0")
                    .put("source", "source")
                    .put("status", "unread")
                    .put("tenant", "tenant")
                    .put("trigger_data", "trigger_data")
                    .put("workflow_categories[]", "string")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            FeedListItemsParams.builder()
                .userId("user_id")
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
