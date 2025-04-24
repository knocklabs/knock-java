// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.recipients.channeldata

import app.knock.api.core.BaseDeserializer
import app.knock.api.core.BaseSerializer
import app.knock.api.core.Enum
import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.allMaxBy
import app.knock.api.core.checkKnown
import app.knock.api.core.checkRequired
import app.knock.api.core.getOrThrow
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
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Microsoft Teams channel connection. */
class MsTeamsChannelData
private constructor(
    private val connections: JsonField<List<Connection>>,
    private val type: JsonField<Type>,
    private val _typename: JsonField<_Typename>,
    private val msTeamsTenantId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("connections")
        @ExcludeMissing
        connections: JsonField<List<Connection>> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
        @JsonProperty("__typename")
        @ExcludeMissing
        _typename: JsonField<_Typename> = JsonMissing.of(),
        @JsonProperty("ms_teams_tenant_id")
        @ExcludeMissing
        msTeamsTenantId: JsonField<String> = JsonMissing.of(),
    ) : this(connections, type, _typename, msTeamsTenantId, mutableMapOf())

    /**
     * List of Microsoft Teams connections.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun connections(): List<Connection> = connections.getRequired("connections")

    /**
     * The type of provider.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun type(): Type = type.getRequired("type")

    /**
     * The typename of the schema.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun _typename(): Optional<_Typename> = _typename.getOptional("__typename")

    /**
     * Microsoft Teams tenant ID.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun msTeamsTenantId(): Optional<String> = msTeamsTenantId.getOptional("ms_teams_tenant_id")

    /**
     * Returns the raw JSON value of [connections].
     *
     * Unlike [connections], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("connections")
    @ExcludeMissing
    fun _connections(): JsonField<List<Connection>> = connections

    /**
     * Returns the raw JSON value of [type].
     *
     * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

    /**
     * Returns the raw JSON value of [_typename].
     *
     * Unlike [_typename], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("__typename") @ExcludeMissing fun __typename(): JsonField<_Typename> = _typename

    /**
     * Returns the raw JSON value of [msTeamsTenantId].
     *
     * Unlike [msTeamsTenantId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("ms_teams_tenant_id")
    @ExcludeMissing
    fun _msTeamsTenantId(): JsonField<String> = msTeamsTenantId

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
         * Returns a mutable builder for constructing an instance of [MsTeamsChannelData].
         *
         * The following fields are required:
         * ```java
         * .connections()
         * .type()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MsTeamsChannelData]. */
    class Builder internal constructor() {

        private var connections: JsonField<MutableList<Connection>>? = null
        private var type: JsonField<Type>? = null
        private var _typename: JsonField<_Typename> = JsonMissing.of()
        private var msTeamsTenantId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(msTeamsChannelData: MsTeamsChannelData) = apply {
            connections = msTeamsChannelData.connections.map { it.toMutableList() }
            type = msTeamsChannelData.type
            _typename = msTeamsChannelData._typename
            msTeamsTenantId = msTeamsChannelData.msTeamsTenantId
            additionalProperties = msTeamsChannelData.additionalProperties.toMutableMap()
        }

        /** List of Microsoft Teams connections. */
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

        /** The type of provider. */
        fun type(type: Type) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [Type] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<Type>) = apply { this.type = type }

        /** The typename of the schema. */
        fun _typename(_typename: _Typename) = _typename(JsonField.of(_typename))

        /**
         * Sets [Builder._typename] to an arbitrary JSON value.
         *
         * You should usually call [Builder._typename] with a well-typed [_Typename] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun _typename(_typename: JsonField<_Typename>) = apply { this._typename = _typename }

        /** Microsoft Teams tenant ID. */
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
         * .type()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): MsTeamsChannelData =
            MsTeamsChannelData(
                checkRequired("connections", connections).map { it.toImmutable() },
                checkRequired("type", type),
                _typename,
                msTeamsTenantId,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): MsTeamsChannelData = apply {
        if (validated) {
            return@apply
        }

        connections().forEach { it.validate() }
        type().validate()
        _typename().ifPresent { it.validate() }
        msTeamsTenantId()
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
    @JvmSynthetic
    internal fun validity(): Int =
        (connections.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (type.asKnown().getOrNull()?.validity() ?: 0) +
            (_typename.asKnown().getOrNull()?.validity() ?: 0) +
            (if (msTeamsTenantId.asKnown().isPresent) 1 else 0)

    /** Microsoft Teams token connection. */
    @JsonDeserialize(using = Connection.Deserializer::class)
    @JsonSerialize(using = Connection.Serializer::class)
    class Connection
    private constructor(
        private val msTeamsToken: MsTeamsTokenConnection? = null,
        private val msTeamsIncomingWebhook: MsTeamsIncomingWebhookConnection? = null,
        private val _json: JsonValue? = null,
    ) {

        /** Microsoft Teams token connection. */
        fun msTeamsToken(): Optional<MsTeamsTokenConnection> = Optional.ofNullable(msTeamsToken)

        /** Microsoft Teams incoming webhook connection. */
        fun msTeamsIncomingWebhook(): Optional<MsTeamsIncomingWebhookConnection> =
            Optional.ofNullable(msTeamsIncomingWebhook)

        fun isMsTeamsToken(): Boolean = msTeamsToken != null

        fun isMsTeamsIncomingWebhook(): Boolean = msTeamsIncomingWebhook != null

        /** Microsoft Teams token connection. */
        fun asMsTeamsToken(): MsTeamsTokenConnection = msTeamsToken.getOrThrow("msTeamsToken")

        /** Microsoft Teams incoming webhook connection. */
        fun asMsTeamsIncomingWebhook(): MsTeamsIncomingWebhookConnection =
            msTeamsIncomingWebhook.getOrThrow("msTeamsIncomingWebhook")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                msTeamsToken != null -> visitor.visitMsTeamsToken(msTeamsToken)
                msTeamsIncomingWebhook != null ->
                    visitor.visitMsTeamsIncomingWebhook(msTeamsIncomingWebhook)
                else -> visitor.unknown(_json)
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
            accept(
                object : Visitor<Int> {
                    override fun visitMsTeamsToken(msTeamsToken: MsTeamsTokenConnection) =
                        msTeamsToken.validity()

                    override fun visitMsTeamsIncomingWebhook(
                        msTeamsIncomingWebhook: MsTeamsIncomingWebhookConnection
                    ) = msTeamsIncomingWebhook.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

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

            /** Microsoft Teams token connection. */
            @JvmStatic
            fun ofMsTeamsToken(msTeamsToken: MsTeamsTokenConnection) =
                Connection(msTeamsToken = msTeamsToken)

            /** Microsoft Teams incoming webhook connection. */
            @JvmStatic
            fun ofMsTeamsIncomingWebhook(msTeamsIncomingWebhook: MsTeamsIncomingWebhookConnection) =
                Connection(msTeamsIncomingWebhook = msTeamsIncomingWebhook)
        }

        /**
         * An interface that defines how to map each variant of [Connection] to a value of type [T].
         */
        interface Visitor<out T> {

            /** Microsoft Teams token connection. */
            fun visitMsTeamsToken(msTeamsToken: MsTeamsTokenConnection): T

            /** Microsoft Teams incoming webhook connection. */
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

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<MsTeamsTokenConnection>())?.let {
                                Connection(msTeamsToken = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<MsTeamsIncomingWebhookConnection>())
                                ?.let { Connection(msTeamsIncomingWebhook = it, _json = json) },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Connection(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
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

        /** Microsoft Teams token connection. */
        class MsTeamsTokenConnection
        private constructor(
            private val msTeamsChannelId: JsonField<String>,
            private val msTeamsTeamId: JsonField<String>,
            private val msTeamsTenantId: JsonField<String>,
            private val msTeamsUserId: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("ms_teams_channel_id")
                @ExcludeMissing
                msTeamsChannelId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("ms_teams_team_id")
                @ExcludeMissing
                msTeamsTeamId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("ms_teams_tenant_id")
                @ExcludeMissing
                msTeamsTenantId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("ms_teams_user_id")
                @ExcludeMissing
                msTeamsUserId: JsonField<String> = JsonMissing.of(),
            ) : this(
                msTeamsChannelId,
                msTeamsTeamId,
                msTeamsTenantId,
                msTeamsUserId,
                mutableMapOf(),
            )

            /**
             * Microsoft Teams channel ID.
             *
             * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun msTeamsChannelId(): Optional<String> =
                msTeamsChannelId.getOptional("ms_teams_channel_id")

            /**
             * Microsoft Teams team ID.
             *
             * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun msTeamsTeamId(): Optional<String> = msTeamsTeamId.getOptional("ms_teams_team_id")

            /**
             * Microsoft Teams tenant ID.
             *
             * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun msTeamsTenantId(): Optional<String> =
                msTeamsTenantId.getOptional("ms_teams_tenant_id")

            /**
             * Microsoft Teams user ID.
             *
             * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun msTeamsUserId(): Optional<String> = msTeamsUserId.getOptional("ms_teams_user_id")

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

                /** Microsoft Teams channel ID. */
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

                /** Microsoft Teams team ID. */
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

                /** Microsoft Teams tenant ID. */
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

                /** Microsoft Teams user ID. */
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
                        additionalProperties.toMutableMap(),
                    )
            }

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
                (if (msTeamsChannelId.asKnown().isPresent) 1 else 0) +
                    (if (msTeamsTeamId.asKnown().isPresent) 1 else 0) +
                    (if (msTeamsTenantId.asKnown().isPresent) 1 else 0) +
                    (if (msTeamsUserId.asKnown().isPresent) 1 else 0)

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

        /** Microsoft Teams incoming webhook connection. */
        class MsTeamsIncomingWebhookConnection
        private constructor(
            private val incomingWebhook: JsonField<IncomingWebhook>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("incoming_webhook")
                @ExcludeMissing
                incomingWebhook: JsonField<IncomingWebhook> = JsonMissing.of()
            ) : this(incomingWebhook, mutableMapOf())

            /**
             * Microsoft Teams incoming webhook.
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

                /** Microsoft Teams incoming webhook. */
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
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): MsTeamsIncomingWebhookConnection = apply {
                if (validated) {
                    return@apply
                }

                incomingWebhook().validate()
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
            internal fun validity(): Int = (incomingWebhook.asKnown().getOrNull()?.validity() ?: 0)

            /** Microsoft Teams incoming webhook. */
            class IncomingWebhook
            private constructor(
                private val url: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of()
                ) : this(url, mutableMapOf())

                /**
                 * Microsoft Teams incoming webhook URL.
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

                    /** Microsoft Teams incoming webhook URL. */
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
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): IncomingWebhook = apply {
                    if (validated) {
                        return@apply
                    }

                    url()
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
                @JvmSynthetic internal fun validity(): Int = (if (url.asKnown().isPresent) 1 else 0)

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

    /** The type of provider. */
    class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val CHAT_MS_TEAMS = of("chat_ms_teams")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        /** An enum containing [Type]'s known values. */
        enum class Known {
            CHAT_MS_TEAMS
        }

        /**
         * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Type] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            CHAT_MS_TEAMS,
            /** An enum member indicating that [Type] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                CHAT_MS_TEAMS -> Value.CHAT_MS_TEAMS
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws KnockInvalidDataException if this class instance's value is a not a known member.
         */
        fun known(): Known =
            when (this) {
                CHAT_MS_TEAMS -> Known.CHAT_MS_TEAMS
                else -> throw KnockInvalidDataException("Unknown Type: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws KnockInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { KnockInvalidDataException("Value is not a String") }

        private var validated: Boolean = false

        fun validate(): Type = apply {
            if (validated) {
                return@apply
            }

            known()
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
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Type && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** The typename of the schema. */
    class _Typename @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val MS_TEAMS_CHANNEL_DATA = of("MsTeamsChannelData")

            @JvmStatic fun of(value: String) = _Typename(JsonField.of(value))
        }

        /** An enum containing [_Typename]'s known values. */
        enum class Known {
            MS_TEAMS_CHANNEL_DATA
        }

        /**
         * An enum containing [_Typename]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [_Typename] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            MS_TEAMS_CHANNEL_DATA,
            /**
             * An enum member indicating that [_Typename] was instantiated with an unknown value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                MS_TEAMS_CHANNEL_DATA -> Value.MS_TEAMS_CHANNEL_DATA
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws KnockInvalidDataException if this class instance's value is a not a known member.
         */
        fun known(): Known =
            when (this) {
                MS_TEAMS_CHANNEL_DATA -> Known.MS_TEAMS_CHANNEL_DATA
                else -> throw KnockInvalidDataException("Unknown _Typename: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws KnockInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { KnockInvalidDataException("Value is not a String") }

        private var validated: Boolean = false

        fun validate(): _Typename = apply {
            if (validated) {
                return@apply
            }

            known()
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
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is _Typename && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is MsTeamsChannelData && connections == other.connections && type == other.type && _typename == other._typename && msTeamsTenantId == other.msTeamsTenantId && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(connections, type, _typename, msTeamsTenantId, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MsTeamsChannelData{connections=$connections, type=$type, _typename=$_typename, msTeamsTenantId=$msTeamsTenantId, additionalProperties=$additionalProperties}"
}
