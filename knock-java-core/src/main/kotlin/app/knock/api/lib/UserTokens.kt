package app.knock.api.lib

import app.knock.api.core.toImmutable
import com.fasterxml.jackson.databind.ObjectMapper
import java.nio.charset.StandardCharsets
import java.security.KeyFactory
import java.security.PrivateKey
import java.security.Signature
import java.security.spec.PKCS8EncodedKeySpec
import java.time.Clock
import java.util.Base64
import java.util.Objects
import java.util.Optional
import java.util.UUID
import kotlin.jvm.optionals.getOrNull

/** Options for [UserTokens.signUserToken]. */
class SignUserTokenOptions
private constructor(
    private val signingKey: String?,
    private val expiresInSeconds: Long,
    private val grants: List<TokenGrant>?,
    private val shouldGenerateJti: Boolean,
) {

    /**
     * The signing key, as a PEM or a base64-encoded PEM. When empty, the `KNOCK_SIGNING_KEY`
     * environment variable is used.
     */
    fun signingKey(): Optional<String> = Optional.ofNullable(signingKey)

    /** How long the token is valid for. Defaults to one hour. */
    fun expiresInSeconds(): Long = expiresInSeconds

    fun grants(): Optional<List<TokenGrant>> = Optional.ofNullable(grants)

    /** Whether to include a random JWT ID (`jti`) claim. Defaults to false. */
    fun shouldGenerateJti(): Boolean = shouldGenerateJti

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): SignUserTokenOptions = builder().build()

        /** Returns a mutable builder for constructing an instance of [SignUserTokenOptions]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SignUserTokenOptions]. */
    class Builder internal constructor() {

        private var signingKey: String? = null
        private var expiresInSeconds: Long = 60 * 60
        private var grants: MutableList<TokenGrant>? = null
        private var shouldGenerateJti: Boolean = false

        @JvmSynthetic
        internal fun from(signUserTokenOptions: SignUserTokenOptions) = apply {
            signingKey = signUserTokenOptions.signingKey
            expiresInSeconds = signUserTokenOptions.expiresInSeconds
            grants = signUserTokenOptions.grants?.toMutableList()
            shouldGenerateJti = signUserTokenOptions.shouldGenerateJti
        }

        /**
         * The signing key, as a PEM or a base64-encoded PEM. When unset, the `KNOCK_SIGNING_KEY`
         * environment variable is used.
         */
        fun signingKey(signingKey: String?) = apply { this.signingKey = signingKey }

        /** Alias for calling [Builder.signingKey] with `signingKey.orElse(null)`. */
        fun signingKey(signingKey: Optional<String>) = signingKey(signingKey.getOrNull())

        /** How long the token is valid for. Defaults to one hour. */
        fun expiresInSeconds(expiresInSeconds: Long) = apply {
            this.expiresInSeconds = expiresInSeconds
        }

        fun grants(grants: List<TokenGrant>?) = apply { this.grants = grants?.toMutableList() }

        /** Adds a single [TokenGrant] to [grants]. */
        fun addGrant(grant: TokenGrant) = apply {
            grants = (grants ?: mutableListOf()).apply { add(grant) }
        }

        /** Whether to include a random JWT ID (`jti`) claim. Defaults to false. */
        fun shouldGenerateJti(shouldGenerateJti: Boolean) = apply {
            this.shouldGenerateJti = shouldGenerateJti
        }

        /**
         * Returns an immutable instance of [SignUserTokenOptions].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): SignUserTokenOptions =
            SignUserTokenOptions(
                signingKey,
                expiresInSeconds,
                grants?.toImmutable(),
                shouldGenerateJti,
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is SignUserTokenOptions && signingKey == other.signingKey && expiresInSeconds == other.expiresInSeconds && grants == other.grants && shouldGenerateJti == other.shouldGenerateJti /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(signingKey, expiresInSeconds, grants, shouldGenerateJti) /* spotless:on */

    override fun toString() =
        "SignUserTokenOptions{signingKey=${if (signingKey == null) "null" else "***"}, expiresInSeconds=$expiresInSeconds, grants=$grants, shouldGenerateJti=$shouldGenerateJti}"
}

/**
 * Signs user tokens for authenticating client-side requests, e.g. in-app feeds or Slack and
 * Microsoft Teams channel pickers, when enhanced security mode is enabled.
 *
 * Tokens are RS256 JWTs with the same claims as the Node SDK's `signUserToken`.
 *
 * See https://docs.knock.app/in-app-ui/security-and-authentication.
 */
object UserTokens {

    private val MAPPER = ObjectMapper()

    private val RSA_ALGORITHM_IDENTIFIER =
        byteArrayOf(
            0x30,
            0x0d,
            0x06,
            0x09,
            0x2a,
            0x86.toByte(),
            0x48,
            0x86.toByte(),
            0xf7.toByte(),
            0x0d,
            0x01,
            0x01,
            0x01,
            0x05,
            0x00,
        )

    /** Signs a token for [userId] with the key in the `KNOCK_SIGNING_KEY` environment variable. */
    @JvmStatic
    fun signUserToken(userId: String): String = signUserToken(userId, SignUserTokenOptions.none())

    /** Signs a token for [userId]. */
    @JvmStatic
    fun signUserToken(userId: String, options: SignUserTokenOptions): String =
        signUserToken(userId, options, Clock.systemUTC(), System::getenv)

    /** Builds a [TokenGrant] giving the token's user [grants] on [entity]. */
    @JvmStatic
    fun buildUserTokenGrant(entity: TokenEntity, grants: List<Grant>): TokenGrant =
        TokenGrant(entity.uri(), grants.toImmutable())

    @JvmSynthetic
    internal fun signUserToken(
        userId: String,
        options: SignUserTokenOptions,
        clock: Clock,
        getenv: (String) -> String?,
    ): String {
        val privateKey =
            parsePrivateKey(
                prepareSigningKey(options.signingKey().getOrNull() ?: getenv("KNOCK_SIGNING_KEY"))
            )
        val now = clock.millis() / 1000

        val header = linkedMapOf("alg" to "RS256", "typ" to "JWT")
        val payload = linkedMapOf<String, Any>("sub" to userId)
        options.grants().ifPresent { payload["grants"] = prepareGrants(it) }
        payload["iat"] = now
        payload["exp"] = now + options.expiresInSeconds()
        if (options.shouldGenerateJti()) {
            payload["jti"] = UUID.randomUUID().toString()
        }

        val signingInput =
            base64Url(MAPPER.writeValueAsBytes(header)) +
                "." +
                base64Url(MAPPER.writeValueAsBytes(payload))
        val signature =
            Signature.getInstance("SHA256withRSA").run {
                initSign(privateKey)
                update(signingInput.toByteArray(StandardCharsets.UTF_8))
                sign()
            }
        return signingInput + "." + base64Url(signature)
    }

    /** Merges grants on the same entity into `{ entity: { grant: [] } }`. */
    private fun prepareGrants(grants: List<TokenGrant>): Map<String, Map<String, List<Nothing>>> {
        val merged = linkedMapOf<String, LinkedHashMap<String, List<Nothing>>>()
        grants.forEach { grant ->
            val entityGrants = merged.getOrPut(grant.entity()) { linkedMapOf() }
            grant.grants().forEach { entityGrants[it.value] = emptyList() }
        }
        return merged
    }

    private fun prepareSigningKey(signingKey: String?): String {
        requireNotNull(signingKey) {
            "No signing key provided. Set KNOCK_SIGNING_KEY environment variable or pass signingKey option."
        }
        if (signingKey.startsWith("-----BEGIN")) {
            return signingKey
        }
        // "LS0tLS1CRUdJTi" is "-----BEGIN" base64-encoded.
        if (signingKey.startsWith("LS0tLS1CRUdJTi")) {
            return String(Base64.getMimeDecoder().decode(signingKey), StandardCharsets.UTF_8)
        }
        throw IllegalArgumentException(
            "Invalid signing key format. Must be PEM or base64 encoded PEM."
        )
    }

    private fun parsePrivateKey(pem: String): PrivateKey {
        val der =
            Base64.getMimeDecoder()
                .decode(pem.lines().filterNot { it.startsWith("-----") }.joinToString(""))
        // PKCS#1 keys ("BEGIN RSA PRIVATE KEY") are wrapped into PKCS#8 for the JDK key factory.
        val pkcs8 = if (pem.contains("BEGIN RSA PRIVATE KEY")) wrapPkcs1(der) else der
        return KeyFactory.getInstance("RSA").generatePrivate(PKCS8EncodedKeySpec(pkcs8))
    }

    private fun wrapPkcs1(pkcs1: ByteArray): ByteArray =
        derTag(0x30, byteArrayOf(0x02, 0x01, 0x00) + RSA_ALGORITHM_IDENTIFIER + derTag(0x04, pkcs1))

    private fun derTag(tag: Int, content: ByteArray): ByteArray {
        val size = content.size
        val length =
            when {
                size < 0x80 -> byteArrayOf(size.toByte())
                size < 0x100 -> byteArrayOf(0x81.toByte(), size.toByte())
                size < 0x10000 -> byteArrayOf(0x82.toByte(), (size shr 8).toByte(), size.toByte())
                else ->
                    byteArrayOf(
                        0x83.toByte(),
                        (size shr 16).toByte(),
                        (size shr 8).toByte(),
                        size.toByte(),
                    )
            }
        return byteArrayOf(tag.toByte()) + length + content
    }

    private fun base64Url(bytes: ByteArray): String =
        Base64.getUrlEncoder().withoutPadding().encodeToString(bytes)
}
