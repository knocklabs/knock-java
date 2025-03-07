// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services

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
import com.knock.api.client.KnockClient
import com.knock.api.client.okhttp.KnockOkHttpClient
import com.knock.api.core.JsonValue
import com.knock.api.models.UserGetParams
import com.knock.api.models.WorkflowTriggerParams
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

@WireMockTest
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
                .actor("string")
                .cancellationKey(null)
                .data(
                    WorkflowTriggerParams.Data.builder()
                        .putAdditionalProperty("dinosaur_names", JsonValue.from("bar"))
                        .putAdditionalProperty("is_alert", JsonValue.from("bar"))
                        .putAdditionalProperty("park_id", JsonValue.from("bar"))
                        .putAdditionalProperty("severity", JsonValue.from("bar"))
                        .putAdditionalProperty("welcome_message", JsonValue.from("bar"))
                        .build()
                )
                .addRecipient("jhammond")
                .tenant("acme_corp")
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
