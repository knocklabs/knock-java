// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services

import app.knock.api.client.KnockClient
import app.knock.api.client.okhttp.KnockOkHttpClient
import app.knock.api.core.JsonValue
import app.knock.api.core.http.Headers
import app.knock.api.core.jsonMapper
import app.knock.api.errors.BadRequestException
import app.knock.api.errors.InternalServerException
import app.knock.api.errors.KnockError
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

@WireMockTest
class ErrorHandlingTest {

    companion object {

        private val ERROR: KnockError =
            KnockError.builder()
                .putAdditionalProperty("errorProperty", JsonValue.from("42"))
                .build()

        private val ERROR_JSON: ByteArray = jsonMapper().writeValueAsBytes(ERROR)

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
                .bearerToken("My Bearer Token")
                .build()
    }

    @Test
    fun usersGet400() {
        val userService = client.users()
        stubFor(
            get(anyUrl())
                .willReturn(status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
        )

        val e =
            assertThrows<BadRequestException> {
                userService.get(UserGetParams.builder().userId("user_id").build())
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Test
    fun usersGet401() {
        val userService = client.users()
        stubFor(
            get(anyUrl())
                .willReturn(status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
        )

        val e =
            assertThrows<UnauthorizedException> {
                userService.get(UserGetParams.builder().userId("user_id").build())
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Test
    fun usersGet403() {
        val userService = client.users()
        stubFor(
            get(anyUrl())
                .willReturn(status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
        )

        val e =
            assertThrows<PermissionDeniedException> {
                userService.get(UserGetParams.builder().userId("user_id").build())
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Test
    fun usersGet404() {
        val userService = client.users()
        stubFor(
            get(anyUrl())
                .willReturn(status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
        )

        val e =
            assertThrows<NotFoundException> {
                userService.get(UserGetParams.builder().userId("user_id").build())
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Test
    fun usersGet422() {
        val userService = client.users()
        stubFor(
            get(anyUrl())
                .willReturn(status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
        )

        val e =
            assertThrows<UnprocessableEntityException> {
                userService.get(UserGetParams.builder().userId("user_id").build())
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Test
    fun usersGet429() {
        val userService = client.users()
        stubFor(
            get(anyUrl())
                .willReturn(status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
        )

        val e =
            assertThrows<RateLimitException> {
                userService.get(UserGetParams.builder().userId("user_id").build())
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Test
    fun usersGet500() {
        val userService = client.users()
        stubFor(
            get(anyUrl())
                .willReturn(status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
        )

        val e =
            assertThrows<InternalServerException> {
                userService.get(UserGetParams.builder().userId("user_id").build())
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Test
    fun usersGet999() {
        val userService = client.users()
        stubFor(
            get(anyUrl())
                .willReturn(status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
        )

        val e =
            assertThrows<UnexpectedStatusCodeException> {
                userService.get(UserGetParams.builder().userId("user_id").build())
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
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
