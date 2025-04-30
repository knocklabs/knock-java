// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services

import app.knock.api.client.KnockClient
import app.knock.api.client.okhttp.KnockOkHttpClient
import app.knock.api.core.JsonValue
import app.knock.api.models.recipients.RecipientRequest
import app.knock.api.models.users.UserGetParams
import app.knock.api.models.workflows.WorkflowTriggerParams
import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.matchingJsonPath
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ServiceParamsTest {

    private lateinit var client: KnockClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            KnockOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .bearerToken("My Bearer Token")
                .build()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun get() {
        val userService = client.users()
        stubFor(get(anyUrl()).willReturn(ok("{}")))

        userService.get(
            UserGetParams.builder()
                .userId("user_id")
                .putAdditionalHeader("Secret-Header", "42")
                .putAdditionalQueryParam("secret_query_param", "42")
                .build()
        )

        verify(
            getRequestedFor(anyUrl())
                .withHeader("Secret-Header", equalTo("42"))
                .withQueryParam("secret_query_param", equalTo("42"))
        )
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun trigger() {
        val workflowService = client.workflows()
        stubFor(post(anyUrl()).willReturn(ok("{}")))

        workflowService.trigger(
            WorkflowTriggerParams.builder()
                .key("key")
                .recipients(
                    listOf(
                        RecipientRequest.ofUserRecipient("dr_grant"),
                        RecipientRequest.ofUserRecipient("dr_sattler"),
                        RecipientRequest.ofUserRecipient("dr_malcolm"),
                    )
                )
                .actor("mr_dna")
                .cancellationKey("isla_nublar_incident_1993")
                .data(
                    WorkflowTriggerParams.Data.builder()
                        .putAdditionalProperty("affected_areas", JsonValue.from("bar"))
                        .putAdditionalProperty("attraction_id", JsonValue.from("bar"))
                        .putAdditionalProperty("evacuation_protocol", JsonValue.from("bar"))
                        .putAdditionalProperty("message", JsonValue.from("bar"))
                        .putAdditionalProperty("severity", JsonValue.from("bar"))
                        .putAdditionalProperty("system_status", JsonValue.from("bar"))
                        .build()
                )
                .tenant("ingen_isla_nublar")
                .putAdditionalHeader("Secret-Header", "42")
                .putAdditionalQueryParam("secret_query_param", "42")
                .putAdditionalBodyProperty("secretProperty", JsonValue.from("42"))
                .build()
        )

        verify(
            postRequestedFor(anyUrl())
                .withHeader("Secret-Header", equalTo("42"))
                .withQueryParam("secret_query_param", equalTo("42"))
                .withRequestBody(matchingJsonPath("$.secretProperty", equalTo("42")))
        )
    }
}
