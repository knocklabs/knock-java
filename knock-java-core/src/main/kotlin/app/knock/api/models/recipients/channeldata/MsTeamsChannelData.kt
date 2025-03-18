// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.recipients.channeldata

import app.knock.api.core.BaseDeserializer
import app.knock.api.core.BaseSerializer
import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.NoAutoDetect
import app.knock.api.core.checkKnown
import app.knock.api.core.checkRequired
import app.knock.api.core.getOrThrow
import app.knock.api.core.immutableEmptyMap
import app.knock.api.core.toImmutable
import app.knock.api.errors.KnockInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Microsoft Teams channel data */
@NoAutoDetect
class MsTeamsChannelData
@JsonCreator
private constructor(
    @JsonProperty("connections")
    @ExcludeMissing
    private val connections: JsonField<List<Connection>> = JsonMissing.of(),
    @JsonProperty("ms_teams_tenant_id")
    @ExcludeMissing
    private val msTeamsTenantId: JsonField<String> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun connections(): List<Connection> = connections.getRequired("connections")

    /**
     * The Microsoft Teams tenant ID
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun msTeamsTenantId(): Optional<String> =
        Optional.ofNullable(msTeamsTenantId.getNullable("ms_teams_tenant_id"))

    /**
     * Returns the raw JSON value of [connections].
     *
     * Unlike [connections], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("connections")
    @ExcludeMissing
    fun _connections(): JsonField<List<Connection>> = connections

    /**
     * Returns the raw JSON value of [msTeamsTenantId].
     *
     * Unlike [msTeamsTenantId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("ms_teams_tenant_id")
    @ExcludeMissing
    fun _msTeamsTenantId(): JsonField<String> = msTeamsTenantId

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): MsTeamsChannelData = apply {
        if (validated) {
            return@apply
        }

        connections().forEach { it.validate() }
        msTeamsTenantId()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [MsTeamsChannelData].
         *
         * The following fields are required:
         * ```java
         * .connections()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MsTeamsChannelData]. */
    class Builder internal constructor() {

        private var connections: JsonField<MutableList<Connection>>? = null
        private var msTeamsTenantId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(msTeamsChannelData: MsTeamsChannelData) = apply {
            connections = msTeamsChannelData.connections.map { it.toMutableList() }
            msTeamsTenantId = msTeamsChannelData.msTeamsTenantId
            additionalProperties = msTeamsChannelData.additionalProperties.toMutableMap()
        }

        fun connections(connections: List<Connection>) = connections(JsonField.of(connections))

        /**
         * Sets [Builder.connections] to an arbitrary JSON value.
         *
         * You should usually call [Builder.connections] with a well-typed `List<Connection>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun connections(connections: JsonField<List<Connection>>) = apply {
            this.connections = connections.map { it.toMutableList() }
        }

        /**
         * Adds a single [Connection] to [connections].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addConnection(connection: Connection) = apply {
            connections =
                (connections ?: JsonField.of(mutableListOf())).also {
                    checkKnown("connections", it).add(connection)
                }
        }

        /** Alias for calling [addConnection] with `Connection.ofMsTeamsToken(msTeamsToken)`. */
        fun addConnection(msTeamsToken: Connection.MsTeamsTokenConnection) =
            addConnection(Connection.ofMsTeamsToken(msTeamsToken))

        /**
         * Alias for calling [addConnection] with
         * `Connection.ofMsTeamsIncomingWebhook(msTeamsIncomingWebhook)`.
         */
        fun addConnection(msTeamsIncomingWebhook: Connection.MsTeamsIncomingWebhookConnection) =
            addConnection(Connection.ofMsTeamsIncomingWebhook(msTeamsIncomingWebhook))

        /** The Microsoft Teams tenant ID */
        fun msTeamsTenantId(msTeamsTenantId: String?) =
            msTeamsTenantId(JsonField.ofNullable(msTeamsTenantId))

        /** Alias for calling [Builder.msTeamsTenantId] with `msTeamsTenantId.orElse(null)`. */
        fun msTeamsTenantId(msTeamsTenantId: Optional<String>) =
            msTeamsTenantId(msTeamsTenantId.getOrNull())

        /**
         * Sets [Builder.msTeamsTenantId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.msTeamsTenantId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun msTeamsTenantId(msTeamsTenantId: JsonField<String>) = apply {
            this.msTeamsTenantId = msTeamsTenantId
        }

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
         * Returns an immutable instance of [MsTeamsChannelData].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .connections()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): MsTeamsChannelData =
            MsTeamsChannelData(
                checkRequired("connections", connections).map { it.toImmutable() },
                msTeamsTenantId,
                additionalProperties.toImmutable(),
            )
    }

    /** Microsoft Teams token connection */
    @JsonDeserialize(using = Connection.Deserializer::class)
    @JsonSerialize(using = Connection.Serializer::class)
    class Connection
    private constructor(
        private val msTeamsToken: MsTeamsTokenConnection? = null,
        private val msTeamsIncomingWebhook: MsTeamsIncomingWebhookConnection? = null,
        private val _json: JsonValue? = null,
    ) {

        /** Microsoft Teams token connection */
        fun msTeamsToken(): Optional<MsTeamsTokenConnection> = Optional.ofNullable(msTeamsToken)

        /** Microsoft Teams incoming webhook connection */
        fun msTeamsIncomingWebhook(): Optional<MsTeamsIncomingWebhookConnection> =
            Optional.ofNullable(msTeamsIncomingWebhook)

        fun isMsTeamsToken(): Boolean = msTeamsToken != null

        fun isMsTeamsIncomingWebhook(): Boolean = msTeamsIncomingWebhook != null

        /** Microsoft Teams token connection */
        fun asMsTeamsToken(): MsTeamsTokenConnection = msTeamsToken.getOrThrow("msTeamsToken")

        /** Microsoft Teams incoming webhook connection */
        fun asMsTeamsIncomingWebhook(): MsTeamsIncomingWebhookConnection =
            msTeamsIncomingWebhook.getOrThrow("msTeamsIncomingWebhook")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                msTeamsToken != null -> visitor.visitMsTeamsToken(msTeamsToken)
                msTeamsIncomingWebhook != null ->
                    visitor.visitMsTeamsIncomingWebhook(msTeamsIncomingWebhook)
                else -> visitor.unknown(_json)
            }
        }

        private var validated: Boolean = false

        fun validate(): Connection = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitMsTeamsToken(msTeamsToken: MsTeamsTokenConnection) {
                        msTeamsToken.validate()
                    }

                    override fun visitMsTeamsIncomingWebhook(
                        msTeamsIncomingWebhook: MsTeamsIncomingWebhookConnection
                    ) {
                        msTeamsIncomingWebhook.validate()
                    }
                }
            )
            validated = true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Connection && msTeamsToken == other.msTeamsToken && msTeamsIncomingWebhook == other.msTeamsIncomingWebhook /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(msTeamsToken, msTeamsIncomingWebhook) /* spotless:on */

        override fun toString(): String =
            when {
                msTeamsToken != null -> "Connection{msTeamsToken=$msTeamsToken}"
                msTeamsIncomingWebhook != null ->
                    "Connection{msTeamsIncomingWebhook=$msTeamsIncomingWebhook}"
                _json != null -> "Connection{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Connection")
            }

        companion object {

            /** Microsoft Teams token connection */
            @JvmStatic
            fun ofMsTeamsToken(msTeamsToken: MsTeamsTokenConnection) =
                Connection(msTeamsToken = msTeamsToken)

            /** Microsoft Teams incoming webhook connection */
            @JvmStatic
            fun ofMsTeamsIncomingWebhook(msTeamsIncomingWebhook: MsTeamsIncomingWebhookConnection) =
                Connection(msTeamsIncomingWebhook = msTeamsIncomingWebhook)
        }

        /**
         * An interface that defines how to map each variant of [Connection] to a value of type [T].
         */
        interface Visitor<out T> {

            /** Microsoft Teams token connection */
            fun visitMsTeamsToken(msTeamsToken: MsTeamsTokenConnection): T

            /** Microsoft Teams incoming webhook connection */
            fun visitMsTeamsIncomingWebhook(
                msTeamsIncomingWebhook: MsTeamsIncomingWebhookConnection
            ): T

            /**
             * Maps an unknown variant of [Connection] to a value of type [T].
             *
             * An instance of [Connection] can contain an unknown variant if it was deserialized
             * from data that doesn't match any known variant. For example, if the SDK is on an
             * older version than the API, then the API may respond with new variants that the SDK
             * is unaware of.
             *
             * @throws KnockInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw KnockInvalidDataException("Unknown Connection: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Connection>(Connection::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Connection {
                val json = JsonValue.fromJsonNode(node)

                tryDeserialize(node, jacksonTypeRef<MsTeamsTokenConnection>()) { it.validate() }
                    ?.let {
                        return Connection(msTeamsToken = it, _json = json)
                    }
                tryDeserialize(node, jacksonTypeRef<MsTeamsIncomingWebhookConnection>()) {
                        it.validate()
                    }
                    ?.let {
                        return Connection(msTeamsIncomingWebhook = it, _json = json)
                    }

                return Connection(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Connection>(Connection::class) {

            override fun serialize(
                value: Connection,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.msTeamsToken != null -> generator.writeObject(value.msTeamsToken)
                    value.msTeamsIncomingWebhook != null ->
                        generator.writeObject(value.msTeamsIncomingWebhook)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Connection")
                }
            }
        }

        /** Microsoft Teams token connection */
        @NoAutoDetect
        class MsTeamsTokenConnection
        @JsonCreator
        private constructor(
            @JsonProperty("ms_teams_channel_id")
            @ExcludeMissing
            private val msTeamsChannelId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("ms_teams_team_id")
            @ExcludeMissing
            private val msTeamsTeamId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("ms_teams_tenant_id")
            @ExcludeMissing
            private val msTeamsTenantId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("ms_teams_user_id")
            @ExcludeMissing
            private val msTeamsUserId: JsonField<String> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /**
             * The Microsoft Teams channel ID
             *
             * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun msTeamsChannelId(): Optional<String> =
                Optional.ofNullable(msTeamsChannelId.getNullable("ms_teams_channel_id"))

            /**
             * The Microsoft Teams team ID
             *
             * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun msTeamsTeamId(): Optional<String> =
                Optional.ofNullable(msTeamsTeamId.getNullable("ms_teams_team_id"))

            /**
             * The Microsoft Teams tenant ID
             *
             * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun msTeamsTenantId(): Optional<String> =
                Optional.ofNullable(msTeamsTenantId.getNullable("ms_teams_tenant_id"))

            /**
             * The Microsoft Teams user ID
             *
             * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun msTeamsUserId(): Optional<String> =
                Optional.ofNullable(msTeamsUserId.getNullable("ms_teams_user_id"))

            /**
             * Returns the raw JSON value of [msTeamsChannelId].
             *
             * Unlike [msTeamsChannelId], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("ms_teams_channel_id")
            @ExcludeMissing
            fun _msTeamsChannelId(): JsonField<String> = msTeamsChannelId

            /**
             * Returns the raw JSON value of [msTeamsTeamId].
             *
             * Unlike [msTeamsTeamId], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("ms_teams_team_id")
            @ExcludeMissing
            fun _msTeamsTeamId(): JsonField<String> = msTeamsTeamId

            /**
             * Returns the raw JSON value of [msTeamsTenantId].
             *
             * Unlike [msTeamsTenantId], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("ms_teams_tenant_id")
            @ExcludeMissing
            fun _msTeamsTenantId(): JsonField<String> = msTeamsTenantId

            /**
             * Returns the raw JSON value of [msTeamsUserId].
             *
             * Unlike [msTeamsUserId], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("ms_teams_user_id")
            @ExcludeMissing
            fun _msTeamsUserId(): JsonField<String> = msTeamsUserId

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): MsTeamsTokenConnection = apply {
                if (validated) {
                    return@apply
                }

                msTeamsChannelId()
                msTeamsTeamId()
                msTeamsTenantId()
                msTeamsUserId()
                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of
                 * [MsTeamsTokenConnection].
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [MsTeamsTokenConnection]. */
            class Builder internal constructor() {

                private var msTeamsChannelId: JsonField<String> = JsonMissing.of()
                private var msTeamsTeamId: JsonField<String> = JsonMissing.of()
                private var msTeamsTenantId: JsonField<String> = JsonMissing.of()
                private var msTeamsUserId: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(msTeamsTokenConnection: MsTeamsTokenConnection) = apply {
                    msTeamsChannelId = msTeamsTokenConnection.msTeamsChannelId
                    msTeamsTeamId = msTeamsTokenConnection.msTeamsTeamId
                    msTeamsTenantId = msTeamsTokenConnection.msTeamsTenantId
                    msTeamsUserId = msTeamsTokenConnection.msTeamsUserId
                    additionalProperties =
                        msTeamsTokenConnection.additionalProperties.toMutableMap()
                }

                /** The Microsoft Teams channel ID */
                fun msTeamsChannelId(msTeamsChannelId: String?) =
                    msTeamsChannelId(JsonField.ofNullable(msTeamsChannelId))

                /**
                 * Alias for calling [Builder.msTeamsChannelId] with
                 * `msTeamsChannelId.orElse(null)`.
                 */
                fun msTeamsChannelId(msTeamsChannelId: Optional<String>) =
                    msTeamsChannelId(msTeamsChannelId.getOrNull())

                /**
                 * Sets [Builder.msTeamsChannelId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.msTeamsChannelId] with a well-typed [String]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun msTeamsChannelId(msTeamsChannelId: JsonField<String>) = apply {
                    this.msTeamsChannelId = msTeamsChannelId
                }

                /** The Microsoft Teams team ID */
                fun msTeamsTeamId(msTeamsTeamId: String?) =
                    msTeamsTeamId(JsonField.ofNullable(msTeamsTeamId))

                /** Alias for calling [Builder.msTeamsTeamId] with `msTeamsTeamId.orElse(null)`. */
                fun msTeamsTeamId(msTeamsTeamId: Optional<String>) =
                    msTeamsTeamId(msTeamsTeamId.getOrNull())

                /**
                 * Sets [Builder.msTeamsTeamId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.msTeamsTeamId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun msTeamsTeamId(msTeamsTeamId: JsonField<String>) = apply {
                    this.msTeamsTeamId = msTeamsTeamId
                }

                /** The Microsoft Teams tenant ID */
                fun msTeamsTenantId(msTeamsTenantId: String?) =
                    msTeamsTenantId(JsonField.ofNullable(msTeamsTenantId))

                /**
                 * Alias for calling [Builder.msTeamsTenantId] with `msTeamsTenantId.orElse(null)`.
                 */
                fun msTeamsTenantId(msTeamsTenantId: Optional<String>) =
                    msTeamsTenantId(msTeamsTenantId.getOrNull())

                /**
                 * Sets [Builder.msTeamsTenantId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.msTeamsTenantId] with a well-typed [String]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun msTeamsTenantId(msTeamsTenantId: JsonField<String>) = apply {
                    this.msTeamsTenantId = msTeamsTenantId
                }

                /** The Microsoft Teams user ID */
                fun msTeamsUserId(msTeamsUserId: String?) =
                    msTeamsUserId(JsonField.ofNullable(msTeamsUserId))

                /** Alias for calling [Builder.msTeamsUserId] with `msTeamsUserId.orElse(null)`. */
                fun msTeamsUserId(msTeamsUserId: Optional<String>) =
                    msTeamsUserId(msTeamsUserId.getOrNull())

                /**
                 * Sets [Builder.msTeamsUserId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.msTeamsUserId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun msTeamsUserId(msTeamsUserId: JsonField<String>) = apply {
                    this.msTeamsUserId = msTeamsUserId
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [MsTeamsTokenConnection].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): MsTeamsTokenConnection =
                    MsTeamsTokenConnection(
                        msTeamsChannelId,
                        msTeamsTeamId,
                        msTeamsTenantId,
                        msTeamsUserId,
                        additionalProperties.toImmutable(),
                    )
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is MsTeamsTokenConnection && msTeamsChannelId == other.msTeamsChannelId && msTeamsTeamId == other.msTeamsTeamId && msTeamsTenantId == other.msTeamsTenantId && msTeamsUserId == other.msTeamsUserId && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(msTeamsChannelId, msTeamsTeamId, msTeamsTenantId, msTeamsUserId, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "MsTeamsTokenConnection{msTeamsChannelId=$msTeamsChannelId, msTeamsTeamId=$msTeamsTeamId, msTeamsTenantId=$msTeamsTenantId, msTeamsUserId=$msTeamsUserId, additionalProperties=$additionalProperties}"
        }

        /** Microsoft Teams incoming webhook connection */
        @NoAutoDetect
        class MsTeamsIncomingWebhookConnection
        @JsonCreator
        private constructor(
            @JsonProperty("incoming_webhook")
            @ExcludeMissing
            private val incomingWebhook: JsonField<IncomingWebhook> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /**
             * The incoming webhook
             *
             * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun incomingWebhook(): IncomingWebhook = incomingWebhook.getRequired("incoming_webhook")

            /**
             * Returns the raw JSON value of [incomingWebhook].
             *
             * Unlike [incomingWebhook], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("incoming_webhook")
            @ExcludeMissing
            fun _incomingWebhook(): JsonField<IncomingWebhook> = incomingWebhook

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): MsTeamsIncomingWebhookConnection = apply {
                if (validated) {
                    return@apply
                }

                incomingWebhook().validate()
                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of
                 * [MsTeamsIncomingWebhookConnection].
                 *
                 * The following fields are required:
                 * ```java
                 * .incomingWebhook()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [MsTeamsIncomingWebhookConnection]. */
            class Builder internal constructor() {

                private var incomingWebhook: JsonField<IncomingWebhook>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(
                    msTeamsIncomingWebhookConnection: MsTeamsIncomingWebhookConnection
                ) = apply {
                    incomingWebhook = msTeamsIncomingWebhookConnection.incomingWebhook
                    additionalProperties =
                        msTeamsIncomingWebhookConnection.additionalProperties.toMutableMap()
                }

                /** The incoming webhook */
                fun incomingWebhook(incomingWebhook: IncomingWebhook) =
                    incomingWebhook(JsonField.of(incomingWebhook))

                /**
                 * Sets [Builder.incomingWebhook] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.incomingWebhook] with a well-typed
                 * [IncomingWebhook] value instead. This method is primarily for setting the field
                 * to an undocumented or not yet supported value.
                 */
                fun incomingWebhook(incomingWebhook: JsonField<IncomingWebhook>) = apply {
                    this.incomingWebhook = incomingWebhook
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [MsTeamsIncomingWebhookConnection].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .incomingWebhook()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): MsTeamsIncomingWebhookConnection =
                    MsTeamsIncomingWebhookConnection(
                        checkRequired("incomingWebhook", incomingWebhook),
                        additionalProperties.toImmutable(),
                    )
            }

            /** The incoming webhook */
            @NoAutoDetect
            class IncomingWebhook
            @JsonCreator
            private constructor(
                @JsonProperty("url")
                @ExcludeMissing
                private val url: JsonField<String> = JsonMissing.of(),
                @JsonAnySetter
                private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
            ) {

                /**
                 * The URL of the incoming webhook
                 *
                 * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun url(): String = url.getRequired("url")

                /**
                 * Returns the raw JSON value of [url].
                 *
                 * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
                 */
                @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                private var validated: Boolean = false

                fun validate(): IncomingWebhook = apply {
                    if (validated) {
                        return@apply
                    }

                    url()
                    validated = true
                }

                fun toBuilder() = Builder().from(this)

                companion object {

                    /**
                     * Returns a mutable builder for constructing an instance of [IncomingWebhook].
                     *
                     * The following fields are required:
                     * ```java
                     * .url()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [IncomingWebhook]. */
                class Builder internal constructor() {

                    private var url: JsonField<String>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(incomingWebhook: IncomingWebhook) = apply {
                        url = incomingWebhook.url
                        additionalProperties = incomingWebhook.additionalProperties.toMutableMap()
                    }

                    /** The URL of the incoming webhook */
                    fun url(url: String) = url(JsonField.of(url))

                    /**
                     * Sets [Builder.url] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.url] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun url(url: JsonField<String>) = apply { this.url = url }

                    fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                        this.additionalProperties.clear()
                        putAllAdditionalProperties(additionalProperties)
                    }

                    fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                        additionalProperties.put(key, value)
                    }

                    fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                        apply {
                            this.additionalProperties.putAll(additionalProperties)
                        }

                    fun removeAdditionalProperty(key: String) = apply {
                        additionalProperties.remove(key)
                    }

                    fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                        keys.forEach(::removeAdditionalProperty)
                    }

                    /**
                     * Returns an immutable instance of [IncomingWebhook].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .url()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): IncomingWebhook =
                        IncomingWebhook(
                            checkRequired("url", url),
                            additionalProperties.toImmutable(),
                        )
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is IncomingWebhook && url == other.url && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(url, additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "IncomingWebhook{url=$url, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is MsTeamsIncomingWebhookConnection && incomingWebhook == other.incomingWebhook && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(incomingWebhook, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "MsTeamsIncomingWebhookConnection{incomingWebhook=$incomingWebhook, additionalProperties=$additionalProperties}"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is MsTeamsChannelData && connections == other.connections && msTeamsTenantId == other.msTeamsTenantId && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(connections, msTeamsTenantId, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MsTeamsChannelData{connections=$connections, msTeamsTenantId=$msTeamsTenantId, additionalProperties=$additionalProperties}"
}
