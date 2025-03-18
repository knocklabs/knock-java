// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.schedules

import app.knock.api.core.JsonValue
import app.knock.api.models.tenants.InlineTenantRequest
import kotlin.test.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ScheduleCreateParamsTest {

    @Test
    fun create() {
        ScheduleCreateParams.builder()
            .addRecipient("user_123")
            .addRepeat(
                ScheduleRepeatRule.builder()
                    ._typename("ScheduleRepeat")
                    .frequency(ScheduleRepeatRule.Frequency.DAILY)
                    .dayOfMonth(null)
                    .days(
                        listOf(
                            ScheduleRepeatRule.Day.MON,
                            ScheduleRepeatRule.Day.TUE,
                            ScheduleRepeatRule.Day.WED,
                            ScheduleRepeatRule.Day.THU,
                            ScheduleRepeatRule.Day.FRI,
                            ScheduleRepeatRule.Day.SAT,
                            ScheduleRepeatRule.Day.SUN,
                        )
                    )
                    .hours(null)
                    .interval(1L)
                    .minutes(null)
                    .build()
            )
            .workflow("comment-created")
            .data(
                ScheduleCreateParams.Data.builder()
                    .putAdditionalProperty("key", JsonValue.from("bar"))
                    .build()
            )
            .endingAt(null)
            .scheduledAt(null)
            .tenant("acme_corp")
            .build()
    }

    @Test
    fun body() {
        val params =
            ScheduleCreateParams.builder()
                .addRecipient("user_123")
                .addRepeat(
                    ScheduleRepeatRule.builder()
                        ._typename("ScheduleRepeat")
                        .frequency(ScheduleRepeatRule.Frequency.DAILY)
                        .dayOfMonth(null)
                        .days(
                            listOf(
                                ScheduleRepeatRule.Day.MON,
                                ScheduleRepeatRule.Day.TUE,
                                ScheduleRepeatRule.Day.WED,
                                ScheduleRepeatRule.Day.THU,
                                ScheduleRepeatRule.Day.FRI,
                                ScheduleRepeatRule.Day.SAT,
                                ScheduleRepeatRule.Day.SUN,
                            )
                        )
                        .hours(null)
                        .interval(1L)
                        .minutes(null)
                        .build()
                )
                .workflow("comment-created")
                .data(
                    ScheduleCreateParams.Data.builder()
                        .putAdditionalProperty("key", JsonValue.from("bar"))
                        .build()
                )
                .endingAt(null)
                .scheduledAt(null)
                .tenant("acme_corp")
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.recipients())
            .containsExactly(ScheduleCreateParams.Recipient.ofString("user_123"))
        assertThat(body.repeats())
            .containsExactly(
                ScheduleRepeatRule.builder()
                    ._typename("ScheduleRepeat")
                    .frequency(ScheduleRepeatRule.Frequency.DAILY)
                    .dayOfMonth(null)
                    .days(
                        listOf(
                            ScheduleRepeatRule.Day.MON,
                            ScheduleRepeatRule.Day.TUE,
                            ScheduleRepeatRule.Day.WED,
                            ScheduleRepeatRule.Day.THU,
                            ScheduleRepeatRule.Day.FRI,
                            ScheduleRepeatRule.Day.SAT,
                            ScheduleRepeatRule.Day.SUN,
                        )
                    )
                    .hours(null)
                    .interval(1L)
                    .minutes(null)
                    .build()
            )
        assertThat(body.workflow()).isEqualTo("comment-created")
        assertThat(body.data())
            .contains(
                ScheduleCreateParams.Data.builder()
                    .putAdditionalProperty("key", JsonValue.from("bar"))
                    .build()
            )
        assertThat(body.endingAt()).isEmpty
        assertThat(body.scheduledAt()).isEmpty
        assertThat(body.tenant()).contains(InlineTenantRequest.ofString("acme_corp"))
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            ScheduleCreateParams.builder()
                .addRecipient("user_123")
                .addRepeat(
                    ScheduleRepeatRule.builder()
                        ._typename("ScheduleRepeat")
                        .frequency(ScheduleRepeatRule.Frequency.DAILY)
                        .build()
                )
                .workflow("comment-created")
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.recipients())
            .containsExactly(ScheduleCreateParams.Recipient.ofString("user_123"))
        assertThat(body.repeats())
            .containsExactly(
                ScheduleRepeatRule.builder()
                    ._typename("ScheduleRepeat")
                    .frequency(ScheduleRepeatRule.Frequency.DAILY)
                    .build()
            )
        assertThat(body.workflow()).isEqualTo("comment-created")
    }
}
