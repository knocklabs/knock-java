// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.tenants

import app.knock.api.core.BaseDeserializer
import app.knock.api.core.BaseSerializer
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
import app.knock.api.models.Condition
import app.knock.api.models.UnnamedSchemaWithArrayParent0
import app.knock.api.models.UnnamedSchemaWithArrayParent1
import app.knock.api.models.recipients.channeldata.DiscordChannelData
import app.knock.api.models.recipients.channeldata.MsTeamsChannelData
import app.knock.api.models.recipients.channeldata.OneSignalChannelData
import app.knock.api.models.recipients.channeldata.PushChannelData
import app.knock.api.models.recipients.channeldata.SlackChannelData
import app.knock.api.models.recipients.preferences.PreferenceSetChannelTypes
import app.knock.api.models.recipients.preferences.PreferenceSetRequest
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

/**
 * A tenant to be set in the system. You can supply any additional properties on the tenant object.
 */
class TenantRequest
private constructor(
    private val id: JsonField<String>,
    private val channelData: JsonField<List<UnnamedSchemaWithArrayParent0>>,
    private val preferences: JsonField<List<UnnamedSchemaWithArrayParent1>>,
    private val settings: JsonField<Settings>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("channel_data")
        @ExcludeMissing
        channelData: JsonField<List<UnnamedSchemaWithArrayParent0>> = JsonMissing.of(),
        @JsonProperty("preferences")
        @ExcludeMissing
        preferences: JsonField<List<UnnamedSchemaWithArrayParent1>> = JsonMissing.of(),
        @JsonProperty("settings") @ExcludeMissing settings: JsonField<Settings> = JsonMissing.of(),
    ) : this(id, channelData, preferences, settings, mutableMapOf())

    /**
     * The unique identifier for the tenant.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * A request to set channel data for a type of channel inline.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun channelData(): Optional<List<UnnamedSchemaWithArrayParent0>> =
        channelData.getOptional("channel_data")

    /**
     * Inline set preferences for a recipient, where the key is the preference set name
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun preferences(): Optional<List<UnnamedSchemaWithArrayParent1>> =
        preferences.getOptional("preferences")

    /**
     * The settings for the tenant. Includes branding and preference set.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun settings(): Optional<Settings> = settings.getOptional("settings")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [channelData].
     *
     * Unlike [channelData], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("channel_data")
    @ExcludeMissing
    fun _channelData(): JsonField<List<UnnamedSchemaWithArrayParent0>> = channelData

    /**
     * Returns the raw JSON value of [preferences].
     *
     * Unlike [preferences], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("preferences")
    @ExcludeMissing
    fun _preferences(): JsonField<List<UnnamedSchemaWithArrayParent1>> = preferences

    /**
     * Returns the raw JSON value of [settings].
     *
     * Unlike [settings], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("settings") @ExcludeMissing fun _settings(): JsonField<Settings> = settings

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
         * Returns a mutable builder for constructing an instance of [TenantRequest].
         *
         * The following fields are required:
         * ```java
         * .id()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TenantRequest]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var channelData: JsonField<MutableList<UnnamedSchemaWithArrayParent0>>? = null
        private var preferences: JsonField<MutableList<UnnamedSchemaWithArrayParent1>>? = null
        private var settings: JsonField<Settings> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(tenantRequest: TenantRequest) = apply {
            id = tenantRequest.id
            channelData = tenantRequest.channelData.map { it.toMutableList() }
            preferences = tenantRequest.preferences.map { it.toMutableList() }
            settings = tenantRequest.settings
            additionalProperties = tenantRequest.additionalProperties.toMutableMap()
        }

        /** The unique identifier for the tenant. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** A request to set channel data for a type of channel inline. */
        fun channelData(channelData: List<UnnamedSchemaWithArrayParent0>?) =
            channelData(JsonField.ofNullable(channelData))

        /** Alias for calling [Builder.channelData] with `channelData.orElse(null)`. */
        fun channelData(channelData: Optional<List<UnnamedSchemaWithArrayParent0>>) =
            channelData(channelData.getOrNull())

        /**
         * Sets [Builder.channelData] to an arbitrary JSON value.
         *
         * You should usually call [Builder.channelData] with a well-typed
         * `List<UnnamedSchemaWithArrayParent0>` value instead. This method is primarily for setting
         * the field to an undocumented or not yet supported value.
         */
        fun channelData(channelData: JsonField<List<UnnamedSchemaWithArrayParent0>>) = apply {
            this.channelData = channelData.map { it.toMutableList() }
        }

        /**
         * Adds a single [UnnamedSchemaWithArrayParent0] to [Builder.channelData].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addChannelData(channelData: UnnamedSchemaWithArrayParent0) = apply {
            this.channelData =
                (this.channelData ?: JsonField.of(mutableListOf())).also {
                    checkKnown("channelData", it).add(channelData)
                }
        }

        /** Inline set preferences for a recipient, where the key is the preference set name */
        fun preferences(preferences: List<UnnamedSchemaWithArrayParent1>?) =
            preferences(JsonField.ofNullable(preferences))

        /** Alias for calling [Builder.preferences] with `preferences.orElse(null)`. */
        fun preferences(preferences: Optional<List<UnnamedSchemaWithArrayParent1>>) =
            preferences(preferences.getOrNull())

        /**
         * Sets [Builder.preferences] to an arbitrary JSON value.
         *
         * You should usually call [Builder.preferences] with a well-typed
         * `List<UnnamedSchemaWithArrayParent1>` value instead. This method is primarily for setting
         * the field to an undocumented or not yet supported value.
         */
        fun preferences(preferences: JsonField<List<UnnamedSchemaWithArrayParent1>>) = apply {
            this.preferences = preferences.map { it.toMutableList() }
        }

        /**
         * Adds a single [UnnamedSchemaWithArrayParent1] to [preferences].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addPreference(preference: UnnamedSchemaWithArrayParent1) = apply {
            preferences =
                (preferences ?: JsonField.of(mutableListOf())).also {
                    checkKnown("preferences", it).add(preference)
                }
        }

        /** The settings for the tenant. Includes branding and preference set. */
        fun settings(settings: Settings) = settings(JsonField.of(settings))

        /**
         * Sets [Builder.settings] to an arbitrary JSON value.
         *
         * You should usually call [Builder.settings] with a well-typed [Settings] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun settings(settings: JsonField<Settings>) = apply { this.settings = settings }

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
         * Returns an immutable instance of [TenantRequest].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TenantRequest =
            TenantRequest(
                checkRequired("id", id),
                (channelData ?: JsonMissing.of()).map { it.toImmutable() },
                (preferences ?: JsonMissing.of()).map { it.toImmutable() },
                settings,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): TenantRequest = apply {
        if (validated) {
            return@apply
        }

        id()
        channelData().ifPresent { it.forEach { it.validate() } }
        preferences().ifPresent { it.forEach { it.validate() } }
        settings().ifPresent { it.validate() }
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
        (if (id.asKnown().isPresent) 1 else 0) +
            (channelData.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (preferences.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (settings.asKnown().getOrNull()?.validity() ?: 0)

    /** A request to set channel data for a type of channel inline. */
    class UnnamedSchemaWithArrayParent0
    private constructor(
        private val channelId: JsonField<String>,
        private val data: JsonField<Data>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("channel_id")
            @ExcludeMissing
            channelId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("data") @ExcludeMissing data: JsonField<Data> = JsonMissing.of(),
        ) : this(channelId, data, mutableMapOf())

        /**
         * The ID of the channel to associate data with
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun channelId(): String = channelId.getRequired("channel_id")

        /**
         * Channel data for a given channel type.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun data(): Data = data.getRequired("data")

        /**
         * Returns the raw JSON value of [channelId].
         *
         * Unlike [channelId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("channel_id") @ExcludeMissing fun _channelId(): JsonField<String> = channelId

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Data> = data

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
             * [UnnamedSchemaWithArrayParent0].
             *
             * The following fields are required:
             * ```java
             * .channelId()
             * .data()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [UnnamedSchemaWithArrayParent0]. */
        class Builder internal constructor() {

            private var channelId: JsonField<String>? = null
            private var data: JsonField<Data>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(unnamedSchemaWithArrayParent0: UnnamedSchemaWithArrayParent0) =
                apply {
                    channelId = unnamedSchemaWithArrayParent0.channelId
                    data = unnamedSchemaWithArrayParent0.data
                    additionalProperties =
                        unnamedSchemaWithArrayParent0.additionalProperties.toMutableMap()
                }

            /** The ID of the channel to associate data with */
            fun channelId(channelId: String) = channelId(JsonField.of(channelId))

            /**
             * Sets [Builder.channelId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.channelId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun channelId(channelId: JsonField<String>) = apply { this.channelId = channelId }

            /** Channel data for a given channel type. */
            fun data(data: Data) = data(JsonField.of(data))

            /**
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed [Data] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun data(data: JsonField<Data>) = apply { this.data = data }

            /** Alias for calling [data] with `Data.ofPushChannel(pushChannel)`. */
            fun data(pushChannel: PushChannelData) = data(Data.ofPushChannel(pushChannel))

            /** Alias for calling [data] with `Data.ofOneSignalChannel(oneSignalChannel)`. */
            fun data(oneSignalChannel: OneSignalChannelData) =
                data(Data.ofOneSignalChannel(oneSignalChannel))

            /** Alias for calling [data] with `Data.ofSlackChannel(slackChannel)`. */
            fun data(slackChannel: SlackChannelData) = data(Data.ofSlackChannel(slackChannel))

            /** Alias for calling [data] with `Data.ofMsTeamsChannel(msTeamsChannel)`. */
            fun data(msTeamsChannel: MsTeamsChannelData) =
                data(Data.ofMsTeamsChannel(msTeamsChannel))

            /** Alias for calling [data] with `Data.ofDiscordChannel(discordChannel)`. */
            fun data(discordChannel: DiscordChannelData) =
                data(Data.ofDiscordChannel(discordChannel))

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
             * Returns an immutable instance of [UnnamedSchemaWithArrayParent0].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .channelId()
             * .data()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): UnnamedSchemaWithArrayParent0 =
                UnnamedSchemaWithArrayParent0(
                    checkRequired("channelId", channelId),
                    checkRequired("data", data),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): UnnamedSchemaWithArrayParent0 = apply {
            if (validated) {
                return@apply
            }

            channelId()
            data().validate()
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
            (if (channelId.asKnown().isPresent) 1 else 0) +
                (data.asKnown().getOrNull()?.validity() ?: 0)

        /** Channel data for a given channel type. */
        @JsonDeserialize(using = Data.Deserializer::class)
        @JsonSerialize(using = Data.Serializer::class)
        class Data
        private constructor(
            private val pushChannel: PushChannelData? = null,
            private val oneSignalChannel: OneSignalChannelData? = null,
            private val slackChannel: SlackChannelData? = null,
            private val msTeamsChannel: MsTeamsChannelData? = null,
            private val discordChannel: DiscordChannelData? = null,
            private val _json: JsonValue? = null,
        ) {

            /** The content of a push notification. */
            fun pushChannel(): Optional<PushChannelData> = Optional.ofNullable(pushChannel)

            /** OneSignal channel data. */
            fun oneSignalChannel(): Optional<OneSignalChannelData> =
                Optional.ofNullable(oneSignalChannel)

            /** Slack channel data */
            fun slackChannel(): Optional<SlackChannelData> = Optional.ofNullable(slackChannel)

            /** Microsoft Teams channel connection. */
            fun msTeamsChannel(): Optional<MsTeamsChannelData> = Optional.ofNullable(msTeamsChannel)

            /** Discord channel data. */
            fun discordChannel(): Optional<DiscordChannelData> = Optional.ofNullable(discordChannel)

            fun isPushChannel(): Boolean = pushChannel != null

            fun isOneSignalChannel(): Boolean = oneSignalChannel != null

            fun isSlackChannel(): Boolean = slackChannel != null

            fun isMsTeamsChannel(): Boolean = msTeamsChannel != null

            fun isDiscordChannel(): Boolean = discordChannel != null

            /** The content of a push notification. */
            fun asPushChannel(): PushChannelData = pushChannel.getOrThrow("pushChannel")

            /** OneSignal channel data. */
            fun asOneSignalChannel(): OneSignalChannelData =
                oneSignalChannel.getOrThrow("oneSignalChannel")

            /** Slack channel data */
            fun asSlackChannel(): SlackChannelData = slackChannel.getOrThrow("slackChannel")

            /** Microsoft Teams channel connection. */
            fun asMsTeamsChannel(): MsTeamsChannelData = msTeamsChannel.getOrThrow("msTeamsChannel")

            /** Discord channel data. */
            fun asDiscordChannel(): DiscordChannelData = discordChannel.getOrThrow("discordChannel")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    pushChannel != null -> visitor.visitPushChannel(pushChannel)
                    oneSignalChannel != null -> visitor.visitOneSignalChannel(oneSignalChannel)
                    slackChannel != null -> visitor.visitSlackChannel(slackChannel)
                    msTeamsChannel != null -> visitor.visitMsTeamsChannel(msTeamsChannel)
                    discordChannel != null -> visitor.visitDiscordChannel(discordChannel)
                    else -> visitor.unknown(_json)
                }

            private var validated: Boolean = false

            fun validate(): Data = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitPushChannel(pushChannel: PushChannelData) {
                            pushChannel.validate()
                        }

                        override fun visitOneSignalChannel(oneSignalChannel: OneSignalChannelData) {
                            oneSignalChannel.validate()
                        }

                        override fun visitSlackChannel(slackChannel: SlackChannelData) {
                            slackChannel.validate()
                        }

                        override fun visitMsTeamsChannel(msTeamsChannel: MsTeamsChannelData) {
                            msTeamsChannel.validate()
                        }

                        override fun visitDiscordChannel(discordChannel: DiscordChannelData) {
                            discordChannel.validate()
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
                        override fun visitPushChannel(pushChannel: PushChannelData) =
                            pushChannel.validity()

                        override fun visitOneSignalChannel(oneSignalChannel: OneSignalChannelData) =
                            oneSignalChannel.validity()

                        override fun visitSlackChannel(slackChannel: SlackChannelData) =
                            slackChannel.validity()

                        override fun visitMsTeamsChannel(msTeamsChannel: MsTeamsChannelData) =
                            msTeamsChannel.validity()

                        override fun visitDiscordChannel(discordChannel: DiscordChannelData) =
                            discordChannel.validity()

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Data && pushChannel == other.pushChannel && oneSignalChannel == other.oneSignalChannel && slackChannel == other.slackChannel && msTeamsChannel == other.msTeamsChannel && discordChannel == other.discordChannel /* spotless:on */
            }

            override fun hashCode(): Int = /* spotless:off */ Objects.hash(pushChannel, oneSignalChannel, slackChannel, msTeamsChannel, discordChannel) /* spotless:on */

            override fun toString(): String =
                when {
                    pushChannel != null -> "Data{pushChannel=$pushChannel}"
                    oneSignalChannel != null -> "Data{oneSignalChannel=$oneSignalChannel}"
                    slackChannel != null -> "Data{slackChannel=$slackChannel}"
                    msTeamsChannel != null -> "Data{msTeamsChannel=$msTeamsChannel}"
                    discordChannel != null -> "Data{discordChannel=$discordChannel}"
                    _json != null -> "Data{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid Data")
                }

            companion object {

                /** The content of a push notification. */
                @JvmStatic
                fun ofPushChannel(pushChannel: PushChannelData) = Data(pushChannel = pushChannel)

                /** OneSignal channel data. */
                @JvmStatic
                fun ofOneSignalChannel(oneSignalChannel: OneSignalChannelData) =
                    Data(oneSignalChannel = oneSignalChannel)

                /** Slack channel data */
                @JvmStatic
                fun ofSlackChannel(slackChannel: SlackChannelData) =
                    Data(slackChannel = slackChannel)

                /** Microsoft Teams channel connection. */
                @JvmStatic
                fun ofMsTeamsChannel(msTeamsChannel: MsTeamsChannelData) =
                    Data(msTeamsChannel = msTeamsChannel)

                /** Discord channel data. */
                @JvmStatic
                fun ofDiscordChannel(discordChannel: DiscordChannelData) =
                    Data(discordChannel = discordChannel)
            }

            /**
             * An interface that defines how to map each variant of [Data] to a value of type [T].
             */
            interface Visitor<out T> {

                /** The content of a push notification. */
                fun visitPushChannel(pushChannel: PushChannelData): T

                /** OneSignal channel data. */
                fun visitOneSignalChannel(oneSignalChannel: OneSignalChannelData): T

                /** Slack channel data */
                fun visitSlackChannel(slackChannel: SlackChannelData): T

                /** Microsoft Teams channel connection. */
                fun visitMsTeamsChannel(msTeamsChannel: MsTeamsChannelData): T

                /** Discord channel data. */
                fun visitDiscordChannel(discordChannel: DiscordChannelData): T

                /**
                 * Maps an unknown variant of [Data] to a value of type [T].
                 *
                 * An instance of [Data] can contain an unknown variant if it was deserialized from
                 * data that doesn't match any known variant. For example, if the SDK is on an older
                 * version than the API, then the API may respond with new variants that the SDK is
                 * unaware of.
                 *
                 * @throws KnockInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw KnockInvalidDataException("Unknown Data: $json")
                }
            }

            internal class Deserializer : BaseDeserializer<Data>(Data::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): Data {
                    val json = JsonValue.fromJsonNode(node)

                    val bestMatches =
                        sequenceOf(
                                tryDeserialize(node, jacksonTypeRef<PushChannelData>())?.let {
                                    Data(pushChannel = it, _json = json)
                                },
                                tryDeserialize(node, jacksonTypeRef<OneSignalChannelData>())?.let {
                                    Data(oneSignalChannel = it, _json = json)
                                },
                                tryDeserialize(node, jacksonTypeRef<SlackChannelData>())?.let {
                                    Data(slackChannel = it, _json = json)
                                },
                                tryDeserialize(node, jacksonTypeRef<MsTeamsChannelData>())?.let {
                                    Data(msTeamsChannel = it, _json = json)
                                },
                                tryDeserialize(node, jacksonTypeRef<DiscordChannelData>())?.let {
                                    Data(discordChannel = it, _json = json)
                                },
                            )
                            .filterNotNull()
                            .allMaxBy { it.validity() }
                            .toList()
                    return when (bestMatches.size) {
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from boolean).
                        0 -> Data(_json = json)
                        1 -> bestMatches.single()
                        // If there's more than one match with the highest validity, then use the
                        // first completely valid match, or simply the first match if none are
                        // completely valid.
                        else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                    }
                }
            }

            internal class Serializer : BaseSerializer<Data>(Data::class) {

                override fun serialize(
                    value: Data,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.pushChannel != null -> generator.writeObject(value.pushChannel)
                        value.oneSignalChannel != null ->
                            generator.writeObject(value.oneSignalChannel)
                        value.slackChannel != null -> generator.writeObject(value.slackChannel)
                        value.msTeamsChannel != null -> generator.writeObject(value.msTeamsChannel)
                        value.discordChannel != null -> generator.writeObject(value.discordChannel)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid Data")
                    }
                }
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is UnnamedSchemaWithArrayParent0 && channelId == other.channelId && data == other.data && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(channelId, data, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "UnnamedSchemaWithArrayParent0{channelId=$channelId, data=$data, additionalProperties=$additionalProperties}"
    }

    /** Inline set preferences for a recipient, where the key is the preference set name */
    class UnnamedSchemaWithArrayParent1
    private constructor(
        private val id: JsonField<String>,
        private val categories: JsonField<Categories>,
        private val channelTypes: JsonField<PreferenceSetChannelTypes>,
        private val workflows: JsonField<Workflows>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("categories")
            @ExcludeMissing
            categories: JsonField<Categories> = JsonMissing.of(),
            @JsonProperty("channel_types")
            @ExcludeMissing
            channelTypes: JsonField<PreferenceSetChannelTypes> = JsonMissing.of(),
            @JsonProperty("workflows")
            @ExcludeMissing
            workflows: JsonField<Workflows> = JsonMissing.of(),
        ) : this(id, categories, channelTypes, workflows, mutableMapOf())

        /**
         * The ID of the preference set
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * Workflow or category preferences within a preference set
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun categories(): Optional<Categories> = categories.getOptional("categories")

        /**
         * Channel type preferences.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun channelTypes(): Optional<PreferenceSetChannelTypes> =
            channelTypes.getOptional("channel_types")

        /**
         * An object where the key is the workflow key and the values are the preference settings
         * for that workflow.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun workflows(): Optional<Workflows> = workflows.getOptional("workflows")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [categories].
         *
         * Unlike [categories], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("categories")
        @ExcludeMissing
        fun _categories(): JsonField<Categories> = categories

        /**
         * Returns the raw JSON value of [channelTypes].
         *
         * Unlike [channelTypes], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("channel_types")
        @ExcludeMissing
        fun _channelTypes(): JsonField<PreferenceSetChannelTypes> = channelTypes

        /**
         * Returns the raw JSON value of [workflows].
         *
         * Unlike [workflows], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("workflows")
        @ExcludeMissing
        fun _workflows(): JsonField<Workflows> = workflows

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
             * [UnnamedSchemaWithArrayParent1].
             *
             * The following fields are required:
             * ```java
             * .id()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [UnnamedSchemaWithArrayParent1]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var categories: JsonField<Categories> = JsonMissing.of()
            private var channelTypes: JsonField<PreferenceSetChannelTypes> = JsonMissing.of()
            private var workflows: JsonField<Workflows> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(unnamedSchemaWithArrayParent1: UnnamedSchemaWithArrayParent1) =
                apply {
                    id = unnamedSchemaWithArrayParent1.id
                    categories = unnamedSchemaWithArrayParent1.categories
                    channelTypes = unnamedSchemaWithArrayParent1.channelTypes
                    workflows = unnamedSchemaWithArrayParent1.workflows
                    additionalProperties =
                        unnamedSchemaWithArrayParent1.additionalProperties.toMutableMap()
                }

            /** The ID of the preference set */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** Workflow or category preferences within a preference set */
            fun categories(categories: Categories) = categories(JsonField.of(categories))

            /**
             * Sets [Builder.categories] to an arbitrary JSON value.
             *
             * You should usually call [Builder.categories] with a well-typed [Categories] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun categories(categories: JsonField<Categories>) = apply {
                this.categories = categories
            }

            /** Alias for calling [categories] with `Categories.ofBool(bool)`. */
            fun categories(bool: Boolean) = categories(Categories.ofBool(bool))

            /**
             * Alias for calling [categories] with
             * `Categories.ofPreferenceSetWorkflowCategorySettingObject(preferenceSetWorkflowCategorySettingObject)`.
             */
            fun categories(
                preferenceSetWorkflowCategorySettingObject:
                    Categories.PreferenceSetWorkflowCategorySettingObject
            ) =
                categories(
                    Categories.ofPreferenceSetWorkflowCategorySettingObject(
                        preferenceSetWorkflowCategorySettingObject
                    )
                )

            /** Channel type preferences. */
            fun channelTypes(channelTypes: PreferenceSetChannelTypes?) =
                channelTypes(JsonField.ofNullable(channelTypes))

            /** Alias for calling [Builder.channelTypes] with `channelTypes.orElse(null)`. */
            fun channelTypes(channelTypes: Optional<PreferenceSetChannelTypes>) =
                channelTypes(channelTypes.getOrNull())

            /**
             * Sets [Builder.channelTypes] to an arbitrary JSON value.
             *
             * You should usually call [Builder.channelTypes] with a well-typed
             * [PreferenceSetChannelTypes] value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
             */
            fun channelTypes(channelTypes: JsonField<PreferenceSetChannelTypes>) = apply {
                this.channelTypes = channelTypes
            }

            /**
             * An object where the key is the workflow key and the values are the preference
             * settings for that workflow.
             */
            fun workflows(workflows: Workflows?) = workflows(JsonField.ofNullable(workflows))

            /** Alias for calling [Builder.workflows] with `workflows.orElse(null)`. */
            fun workflows(workflows: Optional<Workflows>) = workflows(workflows.getOrNull())

            /**
             * Sets [Builder.workflows] to an arbitrary JSON value.
             *
             * You should usually call [Builder.workflows] with a well-typed [Workflows] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun workflows(workflows: JsonField<Workflows>) = apply { this.workflows = workflows }

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
             * Returns an immutable instance of [UnnamedSchemaWithArrayParent1].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): UnnamedSchemaWithArrayParent1 =
                UnnamedSchemaWithArrayParent1(
                    checkRequired("id", id),
                    categories,
                    channelTypes,
                    workflows,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): UnnamedSchemaWithArrayParent1 = apply {
            if (validated) {
                return@apply
            }

            id()
            categories().ifPresent { it.validate() }
            channelTypes().ifPresent { it.validate() }
            workflows().ifPresent { it.validate() }
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (categories.asKnown().getOrNull()?.validity() ?: 0) +
                (channelTypes.asKnown().getOrNull()?.validity() ?: 0) +
                (workflows.asKnown().getOrNull()?.validity() ?: 0)

        /** Workflow or category preferences within a preference set */
        @JsonDeserialize(using = Categories.Deserializer::class)
        @JsonSerialize(using = Categories.Serializer::class)
        class Categories
        private constructor(
            private val bool: Boolean? = null,
            private val preferenceSetWorkflowCategorySettingObject:
                PreferenceSetWorkflowCategorySettingObject? =
                null,
            private val _json: JsonValue? = null,
        ) {

            fun bool(): Optional<Boolean> = Optional.ofNullable(bool)

            /**
             * The settings object for a workflow or category, where you can specify channel types
             * or conditions.
             */
            fun preferenceSetWorkflowCategorySettingObject():
                Optional<PreferenceSetWorkflowCategorySettingObject> =
                Optional.ofNullable(preferenceSetWorkflowCategorySettingObject)

            fun isBool(): Boolean = bool != null

            fun isPreferenceSetWorkflowCategorySettingObject(): Boolean =
                preferenceSetWorkflowCategorySettingObject != null

            fun asBool(): Boolean = bool.getOrThrow("bool")

            /**
             * The settings object for a workflow or category, where you can specify channel types
             * or conditions.
             */
            fun asPreferenceSetWorkflowCategorySettingObject():
                PreferenceSetWorkflowCategorySettingObject =
                preferenceSetWorkflowCategorySettingObject.getOrThrow(
                    "preferenceSetWorkflowCategorySettingObject"
                )

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    bool != null -> visitor.visitBool(bool)
                    preferenceSetWorkflowCategorySettingObject != null ->
                        visitor.visitPreferenceSetWorkflowCategorySettingObject(
                            preferenceSetWorkflowCategorySettingObject
                        )
                    else -> visitor.unknown(_json)
                }

            private var validated: Boolean = false

            fun validate(): Categories = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitBool(bool: Boolean) {}

                        override fun visitPreferenceSetWorkflowCategorySettingObject(
                            preferenceSetWorkflowCategorySettingObject:
                                PreferenceSetWorkflowCategorySettingObject
                        ) {
                            preferenceSetWorkflowCategorySettingObject.validate()
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
                        override fun visitBool(bool: Boolean) = 1

                        override fun visitPreferenceSetWorkflowCategorySettingObject(
                            preferenceSetWorkflowCategorySettingObject:
                                PreferenceSetWorkflowCategorySettingObject
                        ) = preferenceSetWorkflowCategorySettingObject.validity()

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Categories && bool == other.bool && preferenceSetWorkflowCategorySettingObject == other.preferenceSetWorkflowCategorySettingObject /* spotless:on */
            }

            override fun hashCode(): Int = /* spotless:off */ Objects.hash(bool, preferenceSetWorkflowCategorySettingObject) /* spotless:on */

            override fun toString(): String =
                when {
                    bool != null -> "Categories{bool=$bool}"
                    preferenceSetWorkflowCategorySettingObject != null ->
                        "Categories{preferenceSetWorkflowCategorySettingObject=$preferenceSetWorkflowCategorySettingObject}"
                    _json != null -> "Categories{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid Categories")
                }

            companion object {

                @JvmStatic fun ofBool(bool: Boolean) = Categories(bool = bool)

                /**
                 * The settings object for a workflow or category, where you can specify channel
                 * types or conditions.
                 */
                @JvmStatic
                fun ofPreferenceSetWorkflowCategorySettingObject(
                    preferenceSetWorkflowCategorySettingObject:
                        PreferenceSetWorkflowCategorySettingObject
                ) =
                    Categories(
                        preferenceSetWorkflowCategorySettingObject =
                            preferenceSetWorkflowCategorySettingObject
                    )
            }

            /**
             * An interface that defines how to map each variant of [Categories] to a value of type
             * [T].
             */
            interface Visitor<out T> {

                fun visitBool(bool: Boolean): T

                /**
                 * The settings object for a workflow or category, where you can specify channel
                 * types or conditions.
                 */
                fun visitPreferenceSetWorkflowCategorySettingObject(
                    preferenceSetWorkflowCategorySettingObject:
                        PreferenceSetWorkflowCategorySettingObject
                ): T

                /**
                 * Maps an unknown variant of [Categories] to a value of type [T].
                 *
                 * An instance of [Categories] can contain an unknown variant if it was deserialized
                 * from data that doesn't match any known variant. For example, if the SDK is on an
                 * older version than the API, then the API may respond with new variants that the
                 * SDK is unaware of.
                 *
                 * @throws KnockInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw KnockInvalidDataException("Unknown Categories: $json")
                }
            }

            internal class Deserializer : BaseDeserializer<Categories>(Categories::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): Categories {
                    val json = JsonValue.fromJsonNode(node)

                    val bestMatches =
                        sequenceOf(
                                tryDeserialize(
                                        node,
                                        jacksonTypeRef<PreferenceSetWorkflowCategorySettingObject>(),
                                    )
                                    ?.let {
                                        Categories(
                                            preferenceSetWorkflowCategorySettingObject = it,
                                            _json = json,
                                        )
                                    },
                                tryDeserialize(node, jacksonTypeRef<Boolean>())?.let {
                                    Categories(bool = it, _json = json)
                                },
                            )
                            .filterNotNull()
                            .allMaxBy { it.validity() }
                            .toList()
                    return when (bestMatches.size) {
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from string).
                        0 -> Categories(_json = json)
                        1 -> bestMatches.single()
                        // If there's more than one match with the highest validity, then use the
                        // first completely valid match, or simply the first match if none are
                        // completely valid.
                        else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                    }
                }
            }

            internal class Serializer : BaseSerializer<Categories>(Categories::class) {

                override fun serialize(
                    value: Categories,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.bool != null -> generator.writeObject(value.bool)
                        value.preferenceSetWorkflowCategorySettingObject != null ->
                            generator.writeObject(value.preferenceSetWorkflowCategorySettingObject)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid Categories")
                    }
                }
            }

            /**
             * The settings object for a workflow or category, where you can specify channel types
             * or conditions.
             */
            class PreferenceSetWorkflowCategorySettingObject
            private constructor(
                private val channelTypes: JsonField<PreferenceSetChannelTypes>,
                private val conditions: JsonField<List<Condition>>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("channel_types")
                    @ExcludeMissing
                    channelTypes: JsonField<PreferenceSetChannelTypes> = JsonMissing.of(),
                    @JsonProperty("conditions")
                    @ExcludeMissing
                    conditions: JsonField<List<Condition>> = JsonMissing.of(),
                ) : this(channelTypes, conditions, mutableMapOf())

                /**
                 * Channel type preferences.
                 *
                 * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun channelTypes(): Optional<PreferenceSetChannelTypes> =
                    channelTypes.getOptional("channel_types")

                /**
                 * A list of conditions to apply to a channel type.
                 *
                 * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun conditions(): Optional<List<Condition>> = conditions.getOptional("conditions")

                /**
                 * Returns the raw JSON value of [channelTypes].
                 *
                 * Unlike [channelTypes], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("channel_types")
                @ExcludeMissing
                fun _channelTypes(): JsonField<PreferenceSetChannelTypes> = channelTypes

                /**
                 * Returns the raw JSON value of [conditions].
                 *
                 * Unlike [conditions], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("conditions")
                @ExcludeMissing
                fun _conditions(): JsonField<List<Condition>> = conditions

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
                     * [PreferenceSetWorkflowCategorySettingObject].
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [PreferenceSetWorkflowCategorySettingObject]. */
                class Builder internal constructor() {

                    private var channelTypes: JsonField<PreferenceSetChannelTypes> =
                        JsonMissing.of()
                    private var conditions: JsonField<MutableList<Condition>>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(
                        preferenceSetWorkflowCategorySettingObject:
                            PreferenceSetWorkflowCategorySettingObject
                    ) = apply {
                        channelTypes = preferenceSetWorkflowCategorySettingObject.channelTypes
                        conditions =
                            preferenceSetWorkflowCategorySettingObject.conditions.map {
                                it.toMutableList()
                            }
                        additionalProperties =
                            preferenceSetWorkflowCategorySettingObject.additionalProperties
                                .toMutableMap()
                    }

                    /** Channel type preferences. */
                    fun channelTypes(channelTypes: PreferenceSetChannelTypes?) =
                        channelTypes(JsonField.ofNullable(channelTypes))

                    /**
                     * Alias for calling [Builder.channelTypes] with `channelTypes.orElse(null)`.
                     */
                    fun channelTypes(channelTypes: Optional<PreferenceSetChannelTypes>) =
                        channelTypes(channelTypes.getOrNull())

                    /**
                     * Sets [Builder.channelTypes] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.channelTypes] with a well-typed
                     * [PreferenceSetChannelTypes] value instead. This method is primarily for
                     * setting the field to an undocumented or not yet supported value.
                     */
                    fun channelTypes(channelTypes: JsonField<PreferenceSetChannelTypes>) = apply {
                        this.channelTypes = channelTypes
                    }

                    /** A list of conditions to apply to a channel type. */
                    fun conditions(conditions: List<Condition>?) =
                        conditions(JsonField.ofNullable(conditions))

                    /** Alias for calling [Builder.conditions] with `conditions.orElse(null)`. */
                    fun conditions(conditions: Optional<List<Condition>>) =
                        conditions(conditions.getOrNull())

                    /**
                     * Sets [Builder.conditions] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.conditions] with a well-typed
                     * `List<Condition>` value instead. This method is primarily for setting the
                     * field to an undocumented or not yet supported value.
                     */
                    fun conditions(conditions: JsonField<List<Condition>>) = apply {
                        this.conditions = conditions.map { it.toMutableList() }
                    }

                    /**
                     * Adds a single [Condition] to [conditions].
                     *
                     * @throws IllegalStateException if the field was previously set to a non-list.
                     */
                    fun addCondition(condition: Condition) = apply {
                        conditions =
                            (conditions ?: JsonField.of(mutableListOf())).also {
                                checkKnown("conditions", it).add(condition)
                            }
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
                     * Returns an immutable instance of
                     * [PreferenceSetWorkflowCategorySettingObject].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): PreferenceSetWorkflowCategorySettingObject =
                        PreferenceSetWorkflowCategorySettingObject(
                            channelTypes,
                            (conditions ?: JsonMissing.of()).map { it.toImmutable() },
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): PreferenceSetWorkflowCategorySettingObject = apply {
                    if (validated) {
                        return@apply
                    }

                    channelTypes().ifPresent { it.validate() }
                    conditions().ifPresent { it.forEach { it.validate() } }
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
                    (channelTypes.asKnown().getOrNull()?.validity() ?: 0) +
                        (conditions.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is PreferenceSetWorkflowCategorySettingObject && channelTypes == other.channelTypes && conditions == other.conditions && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(channelTypes, conditions, additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "PreferenceSetWorkflowCategorySettingObject{channelTypes=$channelTypes, conditions=$conditions, additionalProperties=$additionalProperties}"
            }
        }

        /**
         * An object where the key is the workflow key and the values are the preference settings
         * for that workflow.
         */
        class Workflows
        @JsonCreator
        private constructor(
            @com.fasterxml.jackson.annotation.JsonValue
            private val additionalProperties: Map<String, JsonValue>
        ) {

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                /** Returns a mutable builder for constructing an instance of [Workflows]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Workflows]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(workflows: Workflows) = apply {
                    additionalProperties = workflows.additionalProperties.toMutableMap()
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
                 * Returns an immutable instance of [Workflows].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Workflows = Workflows(additionalProperties.toImmutable())
            }

            private var validated: Boolean = false

            fun validate(): Workflows = apply {
                if (validated) {
                    return@apply
                }

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
                additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Workflows && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() = "Workflows{additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is UnnamedSchemaWithArrayParent1 && id == other.id && categories == other.categories && channelTypes == other.channelTypes && workflows == other.workflows && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(id, categories, channelTypes, workflows, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "UnnamedSchemaWithArrayParent1{id=$id, categories=$categories, channelTypes=$channelTypes, workflows=$workflows, additionalProperties=$additionalProperties}"
    }

    /** The settings for the tenant. Includes branding and preference set. */
    class Settings
    private constructor(
        private val branding: JsonField<Branding>,
        private val preferenceSet: JsonField<PreferenceSetRequest>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("branding")
            @ExcludeMissing
            branding: JsonField<Branding> = JsonMissing.of(),
            @JsonProperty("preference_set")
            @ExcludeMissing
            preferenceSet: JsonField<PreferenceSetRequest> = JsonMissing.of(),
        ) : this(branding, preferenceSet, mutableMapOf())

        /**
         * The branding for the tenant.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun branding(): Optional<Branding> = branding.getOptional("branding")

        /**
         * A request to set a preference set for a recipient.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun preferenceSet(): Optional<PreferenceSetRequest> =
            preferenceSet.getOptional("preference_set")

        /**
         * Returns the raw JSON value of [branding].
         *
         * Unlike [branding], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("branding") @ExcludeMissing fun _branding(): JsonField<Branding> = branding

        /**
         * Returns the raw JSON value of [preferenceSet].
         *
         * Unlike [preferenceSet], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("preference_set")
        @ExcludeMissing
        fun _preferenceSet(): JsonField<PreferenceSetRequest> = preferenceSet

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

            /** Returns a mutable builder for constructing an instance of [Settings]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Settings]. */
        class Builder internal constructor() {

            private var branding: JsonField<Branding> = JsonMissing.of()
            private var preferenceSet: JsonField<PreferenceSetRequest> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(settings: Settings) = apply {
                branding = settings.branding
                preferenceSet = settings.preferenceSet
                additionalProperties = settings.additionalProperties.toMutableMap()
            }

            /** The branding for the tenant. */
            fun branding(branding: Branding) = branding(JsonField.of(branding))

            /**
             * Sets [Builder.branding] to an arbitrary JSON value.
             *
             * You should usually call [Builder.branding] with a well-typed [Branding] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun branding(branding: JsonField<Branding>) = apply { this.branding = branding }

            /** A request to set a preference set for a recipient. */
            fun preferenceSet(preferenceSet: PreferenceSetRequest?) =
                preferenceSet(JsonField.ofNullable(preferenceSet))

            /** Alias for calling [Builder.preferenceSet] with `preferenceSet.orElse(null)`. */
            fun preferenceSet(preferenceSet: Optional<PreferenceSetRequest>) =
                preferenceSet(preferenceSet.getOrNull())

            /**
             * Sets [Builder.preferenceSet] to an arbitrary JSON value.
             *
             * You should usually call [Builder.preferenceSet] with a well-typed
             * [PreferenceSetRequest] value instead. This method is primarily for setting the field
             * to an undocumented or not yet supported value.
             */
            fun preferenceSet(preferenceSet: JsonField<PreferenceSetRequest>) = apply {
                this.preferenceSet = preferenceSet
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
             * Returns an immutable instance of [Settings].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Settings =
                Settings(branding, preferenceSet, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): Settings = apply {
            if (validated) {
                return@apply
            }

            branding().ifPresent { it.validate() }
            preferenceSet().ifPresent { it.validate() }
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
            (branding.asKnown().getOrNull()?.validity() ?: 0) +
                (preferenceSet.asKnown().getOrNull()?.validity() ?: 0)

        /** The branding for the tenant. */
        class Branding
        private constructor(
            private val iconUrl: JsonField<String>,
            private val logoUrl: JsonField<String>,
            private val primaryColor: JsonField<String>,
            private val primaryColorContrast: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("icon_url")
                @ExcludeMissing
                iconUrl: JsonField<String> = JsonMissing.of(),
                @JsonProperty("logo_url")
                @ExcludeMissing
                logoUrl: JsonField<String> = JsonMissing.of(),
                @JsonProperty("primary_color")
                @ExcludeMissing
                primaryColor: JsonField<String> = JsonMissing.of(),
                @JsonProperty("primary_color_contrast")
                @ExcludeMissing
                primaryColorContrast: JsonField<String> = JsonMissing.of(),
            ) : this(iconUrl, logoUrl, primaryColor, primaryColorContrast, mutableMapOf())

            /**
             * The icon URL for the tenant.
             *
             * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun iconUrl(): Optional<String> = iconUrl.getOptional("icon_url")

            /**
             * The logo URL for the tenant.
             *
             * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun logoUrl(): Optional<String> = logoUrl.getOptional("logo_url")

            /**
             * The primary color for the tenant.
             *
             * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun primaryColor(): Optional<String> = primaryColor.getOptional("primary_color")

            /**
             * The primary color contrast for the tenant.
             *
             * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun primaryColorContrast(): Optional<String> =
                primaryColorContrast.getOptional("primary_color_contrast")

            /**
             * Returns the raw JSON value of [iconUrl].
             *
             * Unlike [iconUrl], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("icon_url") @ExcludeMissing fun _iconUrl(): JsonField<String> = iconUrl

            /**
             * Returns the raw JSON value of [logoUrl].
             *
             * Unlike [logoUrl], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("logo_url") @ExcludeMissing fun _logoUrl(): JsonField<String> = logoUrl

            /**
             * Returns the raw JSON value of [primaryColor].
             *
             * Unlike [primaryColor], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("primary_color")
            @ExcludeMissing
            fun _primaryColor(): JsonField<String> = primaryColor

            /**
             * Returns the raw JSON value of [primaryColorContrast].
             *
             * Unlike [primaryColorContrast], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("primary_color_contrast")
            @ExcludeMissing
            fun _primaryColorContrast(): JsonField<String> = primaryColorContrast

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

                /** Returns a mutable builder for constructing an instance of [Branding]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Branding]. */
            class Builder internal constructor() {

                private var iconUrl: JsonField<String> = JsonMissing.of()
                private var logoUrl: JsonField<String> = JsonMissing.of()
                private var primaryColor: JsonField<String> = JsonMissing.of()
                private var primaryColorContrast: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(branding: Branding) = apply {
                    iconUrl = branding.iconUrl
                    logoUrl = branding.logoUrl
                    primaryColor = branding.primaryColor
                    primaryColorContrast = branding.primaryColorContrast
                    additionalProperties = branding.additionalProperties.toMutableMap()
                }

                /** The icon URL for the tenant. */
                fun iconUrl(iconUrl: String?) = iconUrl(JsonField.ofNullable(iconUrl))

                /** Alias for calling [Builder.iconUrl] with `iconUrl.orElse(null)`. */
                fun iconUrl(iconUrl: Optional<String>) = iconUrl(iconUrl.getOrNull())

                /**
                 * Sets [Builder.iconUrl] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.iconUrl] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun iconUrl(iconUrl: JsonField<String>) = apply { this.iconUrl = iconUrl }

                /** The logo URL for the tenant. */
                fun logoUrl(logoUrl: String?) = logoUrl(JsonField.ofNullable(logoUrl))

                /** Alias for calling [Builder.logoUrl] with `logoUrl.orElse(null)`. */
                fun logoUrl(logoUrl: Optional<String>) = logoUrl(logoUrl.getOrNull())

                /**
                 * Sets [Builder.logoUrl] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.logoUrl] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun logoUrl(logoUrl: JsonField<String>) = apply { this.logoUrl = logoUrl }

                /** The primary color for the tenant. */
                fun primaryColor(primaryColor: String?) =
                    primaryColor(JsonField.ofNullable(primaryColor))

                /** Alias for calling [Builder.primaryColor] with `primaryColor.orElse(null)`. */
                fun primaryColor(primaryColor: Optional<String>) =
                    primaryColor(primaryColor.getOrNull())

                /**
                 * Sets [Builder.primaryColor] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.primaryColor] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun primaryColor(primaryColor: JsonField<String>) = apply {
                    this.primaryColor = primaryColor
                }

                /** The primary color contrast for the tenant. */
                fun primaryColorContrast(primaryColorContrast: String?) =
                    primaryColorContrast(JsonField.ofNullable(primaryColorContrast))

                /**
                 * Alias for calling [Builder.primaryColorContrast] with
                 * `primaryColorContrast.orElse(null)`.
                 */
                fun primaryColorContrast(primaryColorContrast: Optional<String>) =
                    primaryColorContrast(primaryColorContrast.getOrNull())

                /**
                 * Sets [Builder.primaryColorContrast] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.primaryColorContrast] with a well-typed [String]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun primaryColorContrast(primaryColorContrast: JsonField<String>) = apply {
                    this.primaryColorContrast = primaryColorContrast
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
                 * Returns an immutable instance of [Branding].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Branding =
                    Branding(
                        iconUrl,
                        logoUrl,
                        primaryColor,
                        primaryColorContrast,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Branding = apply {
                if (validated) {
                    return@apply
                }

                iconUrl()
                logoUrl()
                primaryColor()
                primaryColorContrast()
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
                (if (iconUrl.asKnown().isPresent) 1 else 0) +
                    (if (logoUrl.asKnown().isPresent) 1 else 0) +
                    (if (primaryColor.asKnown().isPresent) 1 else 0) +
                    (if (primaryColorContrast.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Branding && iconUrl == other.iconUrl && logoUrl == other.logoUrl && primaryColor == other.primaryColor && primaryColorContrast == other.primaryColorContrast && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(iconUrl, logoUrl, primaryColor, primaryColorContrast, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Branding{iconUrl=$iconUrl, logoUrl=$logoUrl, primaryColor=$primaryColor, primaryColorContrast=$primaryColorContrast, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Settings && branding == other.branding && preferenceSet == other.preferenceSet && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(branding, preferenceSet, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Settings{branding=$branding, preferenceSet=$preferenceSet, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is TenantRequest && id == other.id && channelData == other.channelData && preferences == other.preferences && settings == other.settings && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, channelData, preferences, settings, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TenantRequest{id=$id, channelData=$channelData, preferences=$preferences, settings=$settings, additionalProperties=$additionalProperties}"
}
