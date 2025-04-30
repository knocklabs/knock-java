// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services

import app.knock.api.client.KnockClient
import app.knock.api.client.okhttp.KnockOkHttpClient
import app.knock.api.core.JsonValue
import app.knock.api.core.http.Headers
import app.knock.api.core.jsonMapper
import app.knock.api.errors.BadRequestException
import app.knock.api.errors.InternalServerException
import app.knock.api.errors.KnockException
import app.knock.api.errors.NotFoundException
import app.knock.api.errors.PermissionDeniedException
import app.knock.api.errors.RateLimitException
import app.knock.api.errors.UnauthorizedException
import app.knock.api.errors.UnexpectedStatusCodeException
import app.knock.api.errors.UnprocessableEntityException
import app.knock.api.models.users.UserGetParams
import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.status
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.entry
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ErrorHandlingTest {

    companion object {

        private val ERROR_JSON: JsonValue = JsonValue.from(mapOf("errorProperty" to "42"))

        private val ERROR_JSON_BYTES: ByteArray = jsonMapper().writeValueAsBytes(ERROR_JSON)

        private const val HEADER_NAME: String = "Error-Header"

        private const val HEADER_VALUE: String = "42"

        private const val NOT_JSON: String = "Not JSON"
    }

    private lateinit var client: KnockClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            KnockOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .build()
    }

    @Test
    fun usersGet400() {
        val userService = client.users()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<BadRequestException> {
                userService.get(UserGetParams.builder().userId("user_id").build())
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun usersGet401() {
        val userService = client.users()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnauthorizedException> {
                userService.get(UserGetParams.builder().userId("user_id").build())
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun usersGet403() {
        val userService = client.users()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<PermissionDeniedException> {
                userService.get(UserGetParams.builder().userId("user_id").build())
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun usersGet404() {
        val userService = client.users()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<NotFoundException> {
                userService.get(UserGetParams.builder().userId("user_id").build())
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun usersGet422() {
        val userService = client.users()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnprocessableEntityException> {
                userService.get(UserGetParams.builder().userId("user_id").build())
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun usersGet429() {
        val userService = client.users()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<RateLimitException> {
                userService.get(UserGetParams.builder().userId("user_id").build())
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun usersGet500() {
        val userService = client.users()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<InternalServerException> {
                userService.get(UserGetParams.builder().userId("user_id").build())
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun usersGet999() {
        val userService = client.users()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnexpectedStatusCodeException> {
                userService.get(UserGetParams.builder().userId("user_id").build())
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun usersGetInvalidJsonBody() {
        val userService = client.users()
        stubFor(
            get(anyUrl())
                .willReturn(status(200).withHeader(HEADER_NAME, HEADER_VALUE).withBody(NOT_JSON))
        )

        val e =
            assertThrows<KnockException> {
                userService.get(UserGetParams.builder().userId("user_id").build())
            }

        assertThat(e).hasMessage("Error reading response")
    }

    private fun Headers.toMap(): Map<String, List<String>> =
        mutableMapOf<String, List<String>>().also { map ->
            names().forEach { map[it] = values(it) }
        }
}
