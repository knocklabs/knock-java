// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.recipients.preferences

import app.knock.api.core.jsonMapper
import app.knock.api.models.shared.Condition
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PreferenceSetChannelTypesTest {

    @Test
    fun create() {
        val preferenceSetChannelTypes =
            PreferenceSetChannelTypes.builder()
                .chat(true)
                .email(true)
                .http(true)
                .inAppFeed(true)
                .push(true)
                .sms(
                    PreferenceSetChannelTypeSetting.builder()
                        .addCondition(
                            Condition.builder()
                                .argument("US")
                                .operator(Condition.Operator.EQUAL_TO)
                                .variable("recipient.country_code")
                                .build()
                        )
                        .build()
                )
                .build()

        assertThat(preferenceSetChannelTypes.chat())
            .contains(PreferenceSetChannelTypes.Chat.ofBool(true))
        assertThat(preferenceSetChannelTypes.email())
            .contains(PreferenceSetChannelTypes.Email.ofBool(true))
        assertThat(preferenceSetChannelTypes.http())
            .contains(PreferenceSetChannelTypes.Http.ofBool(true))
        assertThat(preferenceSetChannelTypes.inAppFeed())
            .contains(PreferenceSetChannelTypes.InAppFeed.ofBool(true))
        assertThat(preferenceSetChannelTypes.push())
            .contains(PreferenceSetChannelTypes.Push.ofBool(true))
        assertThat(preferenceSetChannelTypes.sms())
            .contains(
                PreferenceSetChannelTypes.Sms.ofPreferenceSetChannelTypeSetting(
                    PreferenceSetChannelTypeSetting.builder()
                        .addCondition(
                            Condition.builder()
                                .argument("US")
                                .operator(Condition.Operator.EQUAL_TO)
                                .variable("recipient.country_code")
                                .build()
                        )
                        .build()
                )
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val preferenceSetChannelTypes =
            PreferenceSetChannelTypes.builder()
                .chat(true)
                .email(true)
                .http(true)
                .inAppFeed(true)
                .push(true)
                .sms(
                    PreferenceSetChannelTypeSetting.builder()
                        .addCondition(
                            Condition.builder()
                                .argument("US")
                                .operator(Condition.Operator.EQUAL_TO)
                                .variable("recipient.country_code")
                                .build()
                        )
                        .build()
                )
                .build()

        val roundtrippedPreferenceSetChannelTypes =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(preferenceSetChannelTypes),
                jacksonTypeRef<PreferenceSetChannelTypes>(),
            )

        assertThat(roundtrippedPreferenceSetChannelTypes).isEqualTo(preferenceSetChannelTypes)
    }
}
