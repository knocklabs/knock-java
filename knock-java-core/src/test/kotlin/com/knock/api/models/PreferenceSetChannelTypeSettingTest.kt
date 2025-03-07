// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PreferenceSetChannelTypeSettingTest {

    @Test
    fun createPreferenceSetChannelTypeSetting() {
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
        assertThat(preferenceSetChannelTypeSetting).isNotNull
        assertThat(preferenceSetChannelTypeSetting.conditions())
            .containsExactly(
                Condition.builder()
                    .argument("US")
                    .operator(Condition.Operator.EQUAL_TO)
                    .variable("recipient.country_code")
                    .build()
            )
    }
}
