// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.recipients

import app.knock.api.models.objects.Object
import app.knock.api.models.users.User
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RecipientTest {

    @Test
    fun ofUser() {
        val user =
            User.builder()
                .id("jane")
                ._typename("User")
                .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                .build()

        val recipient = Recipient.ofUser(user)

        assertThat(recipient.user()).contains(user)
        assertThat(recipient.object_()).isEmpty
    }

    @Test
    fun ofObject() {
        val object_ =
            Object.builder()
                .id("project_1")
                ._typename("Object")
                .collection("projects")
                .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                .build()

        val recipient = Recipient.ofObject(object_)

        assertThat(recipient.user()).isEmpty
        assertThat(recipient.object_()).contains(object_)
    }
}
