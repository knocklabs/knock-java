// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.providers.msteams

import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.checkRequired
import app.knock.api.errors.KnockInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** The response from a Microsoft Teams auth check request. */
class MsTeamCheckAuthResponse
private constructor(
    private val connection: JsonField<Connection>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("connection")
        @ExcludeMissing
        connection: JsonField<Connection> = JsonMissing.of()
    ) : this(connection, mutableMapOf())

    /**
     * A Microsoft Teams connection object.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun connection(): Connection = connection.getRequired("connection")

    /**
     * Returns the raw JSON value of [connection].
     *
     * Unlike [connection], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("connection")
    @ExcludeMissing
    fun _connection(): JsonField<Connection> = connection

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [MsTeamCheckAuthResponse].
         *
         * The following fields are required:
         * ```java
         * .connection()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MsTeamCheckAuthResponse]. */
    class Builder internal constructor() {

        private var connection: JsonField<Connection>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(msTeamCheckAuthResponse: MsTeamCheckAuthResponse) = apply {
            connection = msTeamCheckAuthResponse.connection
            additionalProperties = msTeamCheckAuthResponse.additionalProperties.toMutableMap()
        }

        /** A Microsoft Teams connection object. */
        fun connection(connection: Connection) = connection(JsonField.of(connection))

        /**
         * Sets [Builder.connection] to an arbitrary JSON value.
         *
         * You should usually call [Builder.connection] with a well-typed [Connection] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
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

        /**
         * Returns an immutable instance of [MsTeamCheckAuthResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .connection()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): MsTeamCheckAuthResponse =
            MsTeamCheckAuthResponse(
                checkRequired("connection", connection),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): MsTeamCheckAuthResponse = apply {
        if (validated) {
            return@apply
        }

        connection().validate()
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: KnockInvalidDataException) {
            false
        }

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic internal fun validity(): Int = (connection.asKnown().getOrNull()?.validity() ?: 0)

    /** A Microsoft Teams connection object. */
    class Connection
    private constructor(
        private val ok: JsonField<Boolean>,
        private val reason: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("ok") @ExcludeMissing ok: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("reason") @ExcludeMissing reason: JsonField<String> = JsonMissing.of(),
        ) : this(ok, reason, mutableMapOf())

        /**
         * Whether the Microsoft Teams connection is valid.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun ok(): Boolean = ok.getRequired("ok")

        /**
         * The reason for the Microsoft Teams connection if it is not valid.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun reason(): Optional<String> = reason.getOptional("reason")

        /**
         * Returns the raw JSON value of [ok].
         *
         * Unlike [ok], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("ok") @ExcludeMissing fun _ok(): JsonField<Boolean> = ok

        /**
         * Returns the raw JSON value of [reason].
         *
         * Unlike [reason], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<String> = reason

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

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

            /** Whether the Microsoft Teams connection is valid. */
            fun ok(ok: Boolean) = ok(JsonField.of(ok))

            /**
             * Sets [Builder.ok] to an arbitrary JSON value.
             *
             * You should usually call [Builder.ok] with a well-typed [Boolean] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun ok(ok: JsonField<Boolean>) = apply { this.ok = ok }

            /** The reason for the Microsoft Teams connection if it is not valid. */
            fun reason(reason: String?) = reason(JsonField.ofNullable(reason))

            /** Alias for calling [Builder.reason] with `reason.orElse(null)`. */
            fun reason(reason: Optional<String>) = reason(reason.getOrNull())

            /**
             * Sets [Builder.reason] to an arbitrary JSON value.
             *
             * You should usually call [Builder.reason] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
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

            /**
             * Returns an immutable instance of [Connection].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .ok()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Connection =
                Connection(checkRequired("ok", ok), reason, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): Connection = apply {
            if (validated) {
                return@apply
            }

            ok()
            reason()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: KnockInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (ok.asKnown().isPresent) 1 else 0) + (if (reason.asKnown().isPresent) 1 else 0)

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

        return /* spotless:off */ other is MsTeamCheckAuthResponse && connection == other.connection && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(connection, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MsTeamCheckAuthResponse{connection=$connection, additionalProperties=$additionalProperties}"
}
