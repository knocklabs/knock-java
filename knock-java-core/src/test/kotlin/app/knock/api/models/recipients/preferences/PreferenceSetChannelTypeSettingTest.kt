// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.recipients.preferences

import app.knock.api.core.jsonMapper
import app.knock.api.models.Condition
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PreferenceSetChannelTypeSettingTest {

    @Test
    fun create() {
        val preferenceSetChannelTypeSetting =
            PreferenceSetChannelTypeSetting.builder()
                .addCondition(
                    Condition.builder()
                        .argument("US")
                        .operator(Condition.Operator.EQUAL_TO)
                        .variable("recipient.country_code")
                        .build()
                )
                .build()

        assertThat(preferenceSetChannelTypeSetting.conditions())
            .containsExactly(
                Condition.builder()
                    .argument("US")
                    .operator(Condition.Operator.EQUAL_TO)
                    .variable("recipient.country_code")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val preferenceSetChannelTypeSetting =
            PreferenceSetChannelTypeSetting.builder()
                .addCondition(
                    Condition.builder()
                        .argument("US")
                        .operator(Condition.Operator.EQUAL_TO)
                        .variable("recipient.country_code")
                        .build()
                )
                .build()

        val roundtrippedPreferenceSetChannelTypeSetting =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(preferenceSetChannelTypeSetting),
                jacksonTypeRef<PreferenceSetChannelTypeSetting>(),
            )

        assertThat(roundtrippedPreferenceSetChannelTypeSetting)
            .isEqualTo(preferenceSetChannelTypeSetting)
    }
}
