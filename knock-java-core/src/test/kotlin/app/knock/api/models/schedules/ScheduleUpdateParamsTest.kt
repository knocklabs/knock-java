// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.schedules

import app.knock.api.core.JsonValue
import app.knock.api.models.recipients.RecipientRequest
import app.knock.api.models.tenants.InlineTenantRequest
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ScheduleUpdateParamsTest {

    @Test
    fun create() {
        ScheduleUpdateParams.builder()
            .addScheduleId("123e4567-e89b-12d3-a456-426614174000")
            .actor("string")
            .data(
                ScheduleUpdateParams.Data.builder()
                    .putAdditionalProperty("key", JsonValue.from("bar"))
                    .build()
            )
            .endingAt(null)
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
            .scheduledAt(null)
            .tenant("acme_corp")
            .build()
    }

    @Test
    fun body() {
        val params =
            ScheduleUpdateParams.builder()
                .addScheduleId("123e4567-e89b-12d3-a456-426614174000")
                .actor("string")
                .data(
                    ScheduleUpdateParams.Data.builder()
                        .putAdditionalProperty("key", JsonValue.from("bar"))
                        .build()
                )
                .endingAt(null)
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
                .scheduledAt(null)
                .tenant("acme_corp")
                .build()

        val body = params._body()

        assertThat(body.scheduleIds()).containsExactly("123e4567-e89b-12d3-a456-426614174000")
        assertThat(body.actor()).contains(RecipientRequest.ofUserRecipient("string"))
        assertThat(body.data())
            .contains(
                ScheduleUpdateParams.Data.builder()
                    .putAdditionalProperty("key", JsonValue.from("bar"))
                    .build()
            )
        assertThat(body.endingAt()).isEmpty
        assertThat(body.repeats().getOrNull())
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
        assertThat(body.scheduledAt()).isEmpty
        assertThat(body.tenant()).contains(InlineTenantRequest.ofString("acme_corp"))
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            ScheduleUpdateParams.builder()
                .addScheduleId("123e4567-e89b-12d3-a456-426614174000")
                .build()

        val body = params._body()

        assertThat(body.scheduleIds()).containsExactly("123e4567-e89b-12d3-a456-426614174000")
    }
}
