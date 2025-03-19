// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.recipients

import app.knock.api.models.objects.InlineObjectRequest
import app.knock.api.models.users.InlineIdentifyUserRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RecipientRequestTest {

    @Test
    fun ofString() {
        val string = "string"

        val recipientRequest = RecipientRequest.ofString(string)

        assertThat(recipientRequest.string()).contains(string)
        assertThat(recipientRequest.inlineIdentifyUser()).isEmpty
        assertThat(recipientRequest.inlineObject()).isEmpty
    }

    @Test
    fun ofInlineIdentifyUser() {
        val inlineIdentifyUser = InlineIdentifyUserRequest.builder().id("user_1").build()

        val recipientRequest = RecipientRequest.ofInlineIdentifyUser(inlineIdentifyUser)

        assertThat(recipientRequest.string()).isEmpty
        assertThat(recipientRequest.inlineIdentifyUser()).contains(inlineIdentifyUser)
        assertThat(recipientRequest.inlineObject()).isEmpty
    }

    @Test
    fun ofInlineObject() {
        val inlineObject =
            InlineObjectRequest.builder().id("project_1").collection("projects").build()

        val recipientRequest = RecipientRequest.ofInlineObject(inlineObject)

        assertThat(recipientRequest.string()).isEmpty
        assertThat(recipientRequest.inlineIdentifyUser()).isEmpty
        assertThat(recipientRequest.inlineObject()).contains(inlineObject)
    }
}
