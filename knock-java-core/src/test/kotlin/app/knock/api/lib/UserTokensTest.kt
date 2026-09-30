package app.knock.api.lib

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import java.nio.charset.StandardCharsets
import java.security.KeyPair
import java.security.KeyPairGenerator
import java.security.Signature
import java.time.Clock
import java.time.Instant
import java.time.ZoneOffset
import java.util.Base64
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class UserTokensTest {

    companion object {
        private val KEY_PAIR: KeyPair =
            KeyPairGenerator.getInstance("RSA").apply { initialize(2048) }.generateKeyPair()

        private val PEM: String = pem("PRIVATE KEY", KEY_PAIR.private.encoded)

        private val CLOCK: Clock =
            Clock.fixed(Instant.parse("2025-01-01T00:00:00Z"), ZoneOffset.UTC)

        private const val NOW = 1735689600L

        private val UUID_V4 =
            Regex("^[0-9a-f]{8}-[0-9a-f]{4}-4[0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$")

        private fun pem(type: String, der: ByteArray): String =
            "-----BEGIN $type-----\n" +
                Base64.getMimeEncoder(64, "\n".toByteArray()).encodeToString(der) +
                "\n-----END $type-----\n"

        private fun sign(
            userId: String,
            options: SignUserTokenOptions,
            getenv: (String) -> String? = { null },
        ): String = UserTokens.signUserToken(userId, options, CLOCK, getenv)

        private fun decode(part: String): JsonNode =
            ObjectMapper().readTree(Base64.getUrlDecoder().decode(part))

        private fun payload(token: String): JsonNode = decode(token.split(".")[1])

        private fun verifies(token: String): Boolean {
            val (header, payload, signature) = token.split(".")
            return Signature.getInstance("SHA256withRSA").run {
                initVerify(KEY_PAIR.public)
                update("$header.$payload".toByteArray(StandardCharsets.UTF_8))
                verify(Base64.getUrlDecoder().decode(signature))
            }
        }
    }

    @Test
    fun signUserToken() {
        val token = sign("user-1", SignUserTokenOptions.builder().signingKey(PEM).build())

        assertThat(verifies(token)).isTrue()
        assertThat(decode(token.split(".")[0]).toString())
            .isEqualTo("""{"alg":"RS256","typ":"JWT"}""")
        assertThat(payload(token).toString())
            .isEqualTo("""{"sub":"user-1","iat":$NOW,"exp":${NOW + 3600}}""")
    }

    @Test
    fun signUserTokenWithExpiresInSeconds() {
        val token =
            sign(
                "user-1",
                SignUserTokenOptions.builder().signingKey(PEM).expiresInSeconds(60).build(),
            )

        assertThat(payload(token)["exp"].asLong()).isEqualTo(NOW + 60)
    }

    @Test
    fun signUserTokenWithBase64EncodedKey() {
        val base64Key = Base64.getEncoder().encodeToString(PEM.toByteArray())
        assertThat(base64Key).startsWith("LS0tLS1CRUdJTi")

        val token = sign("user-1", SignUserTokenOptions.builder().signingKey(base64Key).build())

        assertThat(verifies(token)).isTrue()
    }

    @Test
    fun signUserTokenWithPkcs1Key() {
        // A PKCS#8 RSA key is a fixed 26-byte prefix followed by the PKCS#1 key.
        val pkcs8 = KEY_PAIR.private.encoded
        assertThat(pkcs8[22]).isEqualTo(0x04.toByte())
        val pkcs1Pem = pem("RSA PRIVATE KEY", pkcs8.copyOfRange(26, pkcs8.size))

        val token = sign("user-1", SignUserTokenOptions.builder().signingKey(pkcs1Pem).build())

        assertThat(verifies(token)).isTrue()
        assertThat(token)
            .isEqualTo(sign("user-1", SignUserTokenOptions.builder().signingKey(PEM).build()))
    }

    @Test
    fun signUserTokenFallsBackToEnvironment() {
        val token =
            sign("user-1", SignUserTokenOptions.none()) {
                if (it == "KNOCK_SIGNING_KEY") PEM else null
            }

        assertThat(verifies(token)).isTrue()
    }

    @Test
    fun signUserTokenWithoutKey() {
        assertThatThrownBy { sign("user-1", SignUserTokenOptions.none()) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("No signing key provided")
    }

    @Test
    fun signUserTokenWithInvalidKey() {
        assertThatThrownBy {
                sign("user-1", SignUserTokenOptions.builder().signingKey("not-a-key").build())
            }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Invalid signing key format. Must be PEM or base64 encoded PEM.")
    }

    @Test
    fun signUserTokenWithJti() {
        val options = SignUserTokenOptions.builder().signingKey(PEM).shouldGenerateJti(true).build()

        val jti1 = payload(sign("user-1", options))["jti"].asText()
        val jti2 = payload(sign("user-1", options))["jti"].asText()

        assertThat(jti1).matches(UUID_V4.pattern)
        assertThat(jti2).matches(UUID_V4.pattern)
        assertThat(jti1).isNotEqualTo(jti2)
    }

    @Test
    fun signUserTokenWithoutJtiIsDeterministic() {
        val options = SignUserTokenOptions.builder().signingKey(PEM).build()

        val token = sign("user-1", options)

        assertThat(payload(token).has("jti")).isFalse()
        assertThat(sign("user-1", options)).isEqualTo(token)
    }

    @Test
    fun buildUserTokenGrant() {
        assertThat(
                UserTokens.buildUserTokenGrant(
                        TokenEntity.ofUser("user-1"),
                        listOf(Grant.USER_FEED_READ),
                    )
                    .entity()
            )
            .isEqualTo("https://api.knock.app/v1/users/user-1")
        assertThat(UserTokens.buildUserTokenGrant(TokenEntity.ofTenant("acme"), listOf()).entity())
            .isEqualTo("https://api.knock.app/v1/objects/\$tenants/acme")
        assertThat(
                UserTokens.buildUserTokenGrant(TokenEntity.ofObject("projects", "p1"), listOf())
                    .entity()
            )
            .isEqualTo("https://api.knock.app/v1/objects/projects/p1")
    }

    @Test
    fun signUserTokenWithGrants() {
        val token =
            sign(
                "user-1",
                SignUserTokenOptions.builder()
                    .signingKey(PEM)
                    .addGrant(
                        UserTokens.buildUserTokenGrant(
                            TokenEntity.ofTenant("acme"),
                            listOf(Grant.SLACK_CHANNELS_READ),
                        )
                    )
                    .addGrant(
                        UserTokens.buildUserTokenGrant(
                            TokenEntity.ofTenant("acme"),
                            listOf(Grant.CHANNEL_DATA_READ, Grant.CHANNEL_DATA_WRITE),
                        )
                    )
                    .addGrant(
                        UserTokens.buildUserTokenGrant(
                            TokenEntity.ofObject("projects", "p1"),
                            listOf(Grant.MS_TEAMS_CHANNELS_READ),
                        )
                    )
                    .build(),
            )

        assertThat(verifies(token)).isTrue()
        assertThat(payload(token)["grants"].toString())
            .isEqualTo(
                """{"https://api.knock.app/v1/objects/${'$'}tenants/acme":{"slack/channels_read":[],"channel_data/read":[],"channel_data/write":[]},"https://api.knock.app/v1/objects/projects/p1":{"ms_teams/channels_read":[]}}"""
            )
    }

    @Test
    fun optionsToStringRedactsSigningKey() {
        assertThat(SignUserTokenOptions.builder().signingKey(PEM).build().toString())
            .doesNotContain("BEGIN")
            .contains("signingKey=***")
    }
}
