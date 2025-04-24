// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.recipients.preferences

import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InlinePreferenceSetRequestTest {

    @Test
    fun create() {
        val inlinePreferenceSetRequest = InlinePreferenceSetRequest.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inlinePreferenceSetRequest = InlinePreferenceSetRequest.builder().build()

        val roundtrippedInlinePreferenceSetRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inlinePreferenceSetRequest),
                jacksonTypeRef<InlinePreferenceSetRequest>(),
            )

        assertThat(roundtrippedInlinePreferenceSetRequest).isEqualTo(inlinePreferenceSetRequest)
    }
}
