// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models.providers.slack

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.knock.api.core.ExcludeMissing
import com.knock.api.core.JsonField
import com.knock.api.core.JsonMissing
import com.knock.api.core.JsonValue
import com.knock.api.core.NoAutoDetect
import com.knock.api.core.checkRequired
import com.knock.api.core.immutableEmptyMap
import com.knock.api.core.toImmutable
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** The response from a Slack auth check request */
@NoAutoDetect
class SlackCheckAuthResponse
@JsonCreator
private constructor(
    @JsonProperty("connection")
    @ExcludeMissing
    private val connection: JsonField<Connection> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    fun connection(): Connection = connection.getRequired("connection")

    @JsonProperty("connection")
    @ExcludeMissing
    fun _connection(): JsonField<Connection> = connection

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): SlackCheckAuthResponse = apply {
        if (validated) {
            return@apply
        }

        connection().validate()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [SlackCheckAuthResponse].
         *
         * The following fields are required:
         * ```java
         * .connection()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SlackCheckAuthResponse]. */
    class Builder internal constructor() {

        private var connection: JsonField<Connection>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(slackCheckAuthResponse: SlackCheckAuthResponse) = apply {
            connection = slackCheckAuthResponse.connection
            additionalProperties = slackCheckAuthResponse.additionalProperties.toMutableMap()
        }

        fun connection(connection: Connection) = connection(JsonField.of(connection))

        fun connection(connection: JsonField<Connection>) = apply { this.connection = connection }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        fun build(): SlackCheckAuthResponse =
            SlackCheckAuthResponse(
                checkRequired("connection", connection),
                additionalProperties.toImmutable(),
            )
    }

    @NoAutoDetect
    class Connection
    @JsonCreator
    private constructor(
        @JsonProperty("ok") @ExcludeMissing private val ok: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("reason")
        @ExcludeMissing
        private val reason: JsonField<String> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun ok(): Boolean = ok.getRequired("ok")

        fun reason(): Optional<String> = Optional.ofNullable(reason.getNullable("reason"))

        @JsonProperty("ok") @ExcludeMissing fun _ok(): JsonField<Boolean> = ok

        @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<String> = reason

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Connection = apply {
            if (validated) {
                return@apply
            }

            ok()
            reason()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Connection].
             *
             * The following fields are required:
             * ```java
             * .ok()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Connection]. */
        class Builder internal constructor() {

            private var ok: JsonField<Boolean>? = null
            private var reason: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(connection: Connection) = apply {
                ok = connection.ok
                reason = connection.reason
                additionalProperties = connection.additionalProperties.toMutableMap()
            }

            fun ok(ok: Boolean) = ok(JsonField.of(ok))

            fun ok(ok: JsonField<Boolean>) = apply { this.ok = ok }

            fun reason(reason: String?) = reason(JsonField.ofNullable(reason))

            fun reason(reason: Optional<String>) = reason(reason.getOrNull())

            fun reason(reason: JsonField<String>) = apply { this.reason = reason }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            fun build(): Connection =
                Connection(checkRequired("ok", ok), reason, additionalProperties.toImmutable())
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Connection && ok == other.ok && reason == other.reason && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(ok, reason, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Connection{ok=$ok, reason=$reason, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is SlackCheckAuthResponse && connection == other.connection && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(connection, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SlackCheckAuthResponse{connection=$connection, additionalProperties=$additionalProperties}"
}
