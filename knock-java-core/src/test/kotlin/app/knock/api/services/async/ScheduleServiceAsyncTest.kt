// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async

import app.knock.api.TestServerExtension
import app.knock.api.client.okhttp.KnockOkHttpClientAsync
import app.knock.api.models.schedules.ScheduleListParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ScheduleServiceAsyncTest {

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun create() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val scheduleServiceAsync = client.schedules()

        val schedulesFuture = scheduleServiceAsync.create()

        val schedules = schedulesFuture.get()
        schedules.forEach { it.validate() }
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun update() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val scheduleServiceAsync = client.schedules()

        val schedulesFuture = scheduleServiceAsync.update()

        val schedules = schedulesFuture.get()
        schedules.forEach { it.validate() }
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun list() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val scheduleServiceAsync = client.schedules()

        val pageFuture =
            scheduleServiceAsync.list(ScheduleListParams.builder().workflow("workflow").build())

        val page = pageFuture.get()
        page.response().validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun delete() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val scheduleServiceAsync = client.schedules()

        val schedulesFuture = scheduleServiceAsync.delete()

        val schedules = schedulesFuture.get()
        schedules.forEach { it.validate() }
    }
}
