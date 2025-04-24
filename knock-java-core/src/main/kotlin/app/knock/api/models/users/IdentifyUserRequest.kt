// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.core.BaseDeserializer
import app.knock.api.core.BaseSerializer
import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.checkKnown
import app.knock.api.core.checkRequired
import app.knock.api.core.getOrThrow
import app.knock.api.core.toImmutable
import app.knock.api.errors.KnockInvalidDataException
import app.knock.api.models.UnnamedSchemaWithArrayParent0
import app.knock.api.models.recipients.channeldata.DiscordChannelData
import app.knock.api.models.recipients.channeldata.MsTeamsChannelData
import app.knock.api.models.recipients.channeldata.OneSignalChannelData
import app.knock.api.models.recipients.channeldata.PushChannelData
import app.knock.api.models.recipients.channeldata.SlackChannelData
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
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * A set of parameters to identify a user with. Does not include the user ID, as that's specified
 * elsewhere in the request. You can supply any additional properties you'd like to upsert for the
 * user.
 */
class IdentifyUserRequest
private constructor(
    private val avatar: JsonField<String>,
    private val channelData: JsonField<List<UnnamedSchemaWithArrayParent0>>,
    private val createdAt: JsonField<OffsetDateTime>,
    private val email: JsonField<String>,
    private val locale: JsonField<String>,
    private val name: JsonField<String>,
    private val phoneNumber: JsonField<String>,
    private val preferences: JsonValue,
    private val timezone: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("avatar") @ExcludeMissing avatar: JsonField<String> = JsonMissing.of(),
        @JsonProperty("channel_data")
        @ExcludeMissing
        channelData: JsonField<List<UnnamedSchemaWithArrayParent0>> = JsonMissing.of(),
        @JsonProperty("created_at")
        @ExcludeMissing
        createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("email") @ExcludeMissing email: JsonField<String> = JsonMissing.of(),
        @JsonProperty("locale") @ExcludeMissing locale: JsonField<String> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("phone_number")
        @ExcludeMissing
        phoneNumber: JsonField<String> = JsonMissing.of(),
        @JsonProperty("preferences") @ExcludeMissing preferences: JsonValue = JsonMissing.of(),
        @JsonProperty("timezone") @ExcludeMissing timezone: JsonField<String> = JsonMissing.of(),
    ) : this(
        avatar,
        channelData,
        createdAt,
        email,
        locale,
        name,
        phoneNumber,
        preferences,
        timezone,
        mutableMapOf(),
    )

    /**
     * URL to the user's avatar image.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun avatar(): Optional<String> = avatar.getOptional("avatar")

    /**
     * A request to set channel data for a type of channel inline.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun channelData(): Optional<List<UnnamedSchemaWithArrayParent0>> =
        channelData.getOptional("channel_data")

    /**
     * The creation date of the user from your system.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun createdAt(): Optional<OffsetDateTime> = createdAt.getOptional("created_at")

    /**
     * The primary email address for the user.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun email(): Optional<String> = email.getOptional("email")

    /**
     * The locale of the user. Used for [message localization](/concepts/translations).
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun locale(): Optional<String> = locale.getOptional("locale")

    /**
     * Display name of the user.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun name(): Optional<String> = name.getOptional("name")

    /**
     * The [E.164](https://www.twilio.com/docs/glossary/what-e164) phone number of the user
     * (required for SMS channels).
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun phoneNumber(): Optional<String> = phoneNumber.getOptional("phone_number")

    /** A list of objects that specify the preferences for the user. */
    @JsonProperty("preferences") @ExcludeMissing fun _preferences(): JsonValue = preferences

    /**
     * The timezone of the user. Must be a valid
     * [tz database time zone string](https://en.wikipedia.org/wiki/List_of_tz_database_time_zones).
     * Used for
     * [recurring schedules](/concepts/schedules#scheduling-workflows-with-recurring-schedules-for-recipients).
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun timezone(): Optional<String> = timezone.getOptional("timezone")

    /**
     * Returns the raw JSON value of [avatar].
     *
     * Unlike [avatar], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("avatar") @ExcludeMissing fun _avatar(): JsonField<String> = avatar

    /**
     * Returns the raw JSON value of [channelData].
     *
     * Unlike [channelData], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("channel_data")
    @ExcludeMissing
    fun _channelData(): JsonField<List<UnnamedSchemaWithArrayParent0>> = channelData

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created_at")
    @ExcludeMissing
    fun _createdAt(): JsonField<OffsetDateTime> = createdAt

    /**
     * Returns the raw JSON value of [email].
     *
     * Unlike [email], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("email") @ExcludeMissing fun _email(): JsonField<String> = email

    /**
     * Returns the raw JSON value of [locale].
     *
     * Unlike [locale], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("locale") @ExcludeMissing fun _locale(): JsonField<String> = locale

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /**
     * Returns the raw JSON value of [phoneNumber].
     *
     * Unlike [phoneNumber], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("phone_number")
    @ExcludeMissing
    fun _phoneNumber(): JsonField<String> = phoneNumber

    /**
     * Returns the raw JSON value of [timezone].
     *
     * Unlike [timezone], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("timezone") @ExcludeMissing fun _timezone(): JsonField<String> = timezone

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

        /** Returns a mutable builder for constructing an instance of [IdentifyUserRequest]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [IdentifyUserRequest]. */
    class Builder internal constructor() {

        private var avatar: JsonField<String> = JsonMissing.of()
        private var channelData: JsonField<MutableList<UnnamedSchemaWithArrayParent0>>? = null
        private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var email: JsonField<String> = JsonMissing.of()
        private var locale: JsonField<String> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var phoneNumber: JsonField<String> = JsonMissing.of()
        private var preferences: JsonValue = JsonMissing.of()
        private var timezone: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(identifyUserRequest: IdentifyUserRequest) = apply {
            avatar = identifyUserRequest.avatar
            channelData = identifyUserRequest.channelData.map { it.toMutableList() }
            createdAt = identifyUserRequest.createdAt
            email = identifyUserRequest.email
            locale = identifyUserRequest.locale
            name = identifyUserRequest.name
            phoneNumber = identifyUserRequest.phoneNumber
            preferences = identifyUserRequest.preferences
            timezone = identifyUserRequest.timezone
            additionalProperties = identifyUserRequest.additionalProperties.toMutableMap()
        }

        /** URL to the user's avatar image. */
        fun avatar(avatar: String?) = avatar(JsonField.ofNullable(avatar))

        /** Alias for calling [Builder.avatar] with `avatar.orElse(null)`. */
        fun avatar(avatar: Optional<String>) = avatar(avatar.getOrNull())

        /**
         * Sets [Builder.avatar] to an arbitrary JSON value.
         *
         * You should usually call [Builder.avatar] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun avatar(avatar: JsonField<String>) = apply { this.avatar = avatar }

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

        /** The creation date of the user from your system. */
        fun createdAt(createdAt: OffsetDateTime?) = createdAt(JsonField.ofNullable(createdAt))

        /** Alias for calling [Builder.createdAt] with `createdAt.orElse(null)`. */
        fun createdAt(createdAt: Optional<OffsetDateTime>) = createdAt(createdAt.getOrNull())

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply { this.createdAt = createdAt }

        /** The primary email address for the user. */
        fun email(email: String?) = email(JsonField.ofNullable(email))

        /** Alias for calling [Builder.email] with `email.orElse(null)`. */
        fun email(email: Optional<String>) = email(email.getOrNull())

        /**
         * Sets [Builder.email] to an arbitrary JSON value.
         *
         * You should usually call [Builder.email] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun email(email: JsonField<String>) = apply { this.email = email }

        /** The locale of the user. Used for [message localization](/concepts/translations). */
        fun locale(locale: String?) = locale(JsonField.ofNullable(locale))

        /** Alias for calling [Builder.locale] with `locale.orElse(null)`. */
        fun locale(locale: Optional<String>) = locale(locale.getOrNull())

        /**
         * Sets [Builder.locale] to an arbitrary JSON value.
         *
         * You should usually call [Builder.locale] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun locale(locale: JsonField<String>) = apply { this.locale = locale }

        /** Display name of the user. */
        fun name(name: String?) = name(JsonField.ofNullable(name))

        /** Alias for calling [Builder.name] with `name.orElse(null)`. */
        fun name(name: Optional<String>) = name(name.getOrNull())

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /**
         * The [E.164](https://www.twilio.com/docs/glossary/what-e164) phone number of the user
         * (required for SMS channels).
         */
        fun phoneNumber(phoneNumber: String?) = phoneNumber(JsonField.ofNullable(phoneNumber))

        /** Alias for calling [Builder.phoneNumber] with `phoneNumber.orElse(null)`. */
        fun phoneNumber(phoneNumber: Optional<String>) = phoneNumber(phoneNumber.getOrNull())

        /**
         * Sets [Builder.phoneNumber] to an arbitrary JSON value.
         *
         * You should usually call [Builder.phoneNumber] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun phoneNumber(phoneNumber: JsonField<String>) = apply { this.phoneNumber = phoneNumber }

        /** A list of objects that specify the preferences for the user. */
        fun preferences(preferences: JsonValue) = apply { this.preferences = preferences }

        /**
         * The timezone of the user. Must be a valid
         * [tz database time zone string](https://en.wikipedia.org/wiki/List_of_tz_database_time_zones).
         * Used for
         * [recurring schedules](/concepts/schedules#scheduling-workflows-with-recurring-schedules-for-recipients).
         */
        fun timezone(timezone: String?) = timezone(JsonField.ofNullable(timezone))

        /** Alias for calling [Builder.timezone] with `timezone.orElse(null)`. */
        fun timezone(timezone: Optional<String>) = timezone(timezone.getOrNull())

        /**
         * Sets [Builder.timezone] to an arbitrary JSON value.
         *
         * You should usually call [Builder.timezone] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun timezone(timezone: JsonField<String>) = apply { this.timezone = timezone }

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
         * Returns an immutable instance of [IdentifyUserRequest].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): IdentifyUserRequest =
            IdentifyUserRequest(
                avatar,
                (channelData ?: JsonMissing.of()).map { it.toImmutable() },
                createdAt,
                email,
                locale,
                name,
                phoneNumber,
                preferences,
                timezone,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): IdentifyUserRequest = apply {
        if (validated) {
            return@apply
        }

        avatar()
        channelData().ifPresent { it.forEach { it.validate() } }
        createdAt()
        email()
        locale()
        name()
        phoneNumber()
        timezone()
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
        (if (avatar.asKnown().isPresent) 1 else 0) +
            (channelData.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (if (email.asKnown().isPresent) 1 else 0) +
            (if (locale.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (if (phoneNumber.asKnown().isPresent) 1 else 0) +
            (if (timezone.asKnown().isPresent) 1 else 0)

    /** A request to set channel data for a type of channel inline. */
    class UnnamedSchemaWithArrayParent0
    private constructor(
        private val channelId: JsonField<String>,
        private val data: JsonField<Data>,
        private val provider: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("channel_id")
            @ExcludeMissing
            channelId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("data") @ExcludeMissing data: JsonField<Data> = JsonMissing.of(),
            @JsonProperty("provider") @ExcludeMissing provider: JsonField<String> = JsonMissing.of(),
        ) : this(channelId, data, provider, mutableMapOf())

        /**
         * The ID of the channel to associate data with.
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
         * The provider identifier (must match the data.type value)
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun provider(): String = provider.getRequired("provider")

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

        /**
         * Returns the raw JSON value of [provider].
         *
         * Unlike [provider], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("provider") @ExcludeMissing fun _provider(): JsonField<String> = provider

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
             * .provider()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [UnnamedSchemaWithArrayParent0]. */
        class Builder internal constructor() {

            private var channelId: JsonField<String>? = null
            private var data: JsonField<Data>? = null
            private var provider: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(unnamedSchemaWithArrayParent0: UnnamedSchemaWithArrayParent0) =
                apply {
                    channelId = unnamedSchemaWithArrayParent0.channelId
                    data = unnamedSchemaWithArrayParent0.data
                    provider = unnamedSchemaWithArrayParent0.provider
                    additionalProperties =
                        unnamedSchemaWithArrayParent0.additionalProperties.toMutableMap()
                }

            /** The ID of the channel to associate data with. */
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

            /**
             * Alias for calling [data] with the following:
             * ```java
             * OneSignalChannelData.builder()
             *     .type(OneSignalChannelData.Type.PUSH_ONE_SIGNAL)
             *     .playerIds(playerIds)
             *     .build()
             * ```
             */
            fun oneSignalChannelData(playerIds: List<String>) =
                data(
                    OneSignalChannelData.builder()
                        .type(OneSignalChannelData.Type.PUSH_ONE_SIGNAL)
                        .playerIds(playerIds)
                        .build()
                )

            /** Alias for calling [data] with `Data.ofSlackChannel(slackChannel)`. */
            fun data(slackChannel: SlackChannelData) = data(Data.ofSlackChannel(slackChannel))

            /**
             * Alias for calling [data] with the following:
             * ```java
             * SlackChannelData.builder()
             *     .type(SlackChannelData.Type.CHAT_SLACK)
             *     .connections(connections)
             *     .build()
             * ```
             */
            fun slackChannelData(connections: List<SlackChannelData.Connection>) =
                data(
                    SlackChannelData.builder()
                        .type(SlackChannelData.Type.CHAT_SLACK)
                        .connections(connections)
                        .build()
                )

            /** Alias for calling [data] with `Data.ofMsTeamsChannel(msTeamsChannel)`. */
            fun data(msTeamsChannel: MsTeamsChannelData) =
                data(Data.ofMsTeamsChannel(msTeamsChannel))

            /**
             * Alias for calling [data] with the following:
             * ```java
             * MsTeamsChannelData.builder()
             *     .type(MsTeamsChannelData.Type.CHAT_MS_TEAMS)
             *     .connections(connections)
             *     .build()
             * ```
             */
            fun msTeamsChannelData(connections: List<MsTeamsChannelData.Connection>) =
                data(
                    MsTeamsChannelData.builder()
                        .type(MsTeamsChannelData.Type.CHAT_MS_TEAMS)
                        .connections(connections)
                        .build()
                )

            /** Alias for calling [data] with `Data.ofDiscordChannel(discordChannel)`. */
            fun data(discordChannel: DiscordChannelData) =
                data(Data.ofDiscordChannel(discordChannel))

            /**
             * Alias for calling [data] with the following:
             * ```java
             * DiscordChannelData.builder()
             *     .type(DiscordChannelData.Type.CHAT_DISCORD)
             *     .connections(connections)
             *     .build()
             * ```
             */
            fun discordChannelData(connections: List<DiscordChannelData.Connection>) =
                data(
                    DiscordChannelData.builder()
                        .type(DiscordChannelData.Type.CHAT_DISCORD)
                        .connections(connections)
                        .build()
                )

            /** The provider identifier (must match the data.type value) */
            fun provider(provider: String) = provider(JsonField.of(provider))

            /**
             * Sets [Builder.provider] to an arbitrary JSON value.
             *
             * You should usually call [Builder.provider] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun provider(provider: JsonField<String>) = apply { this.provider = provider }

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
             * .provider()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): UnnamedSchemaWithArrayParent0 =
                UnnamedSchemaWithArrayParent0(
                    checkRequired("channelId", channelId),
                    checkRequired("data", data),
                    checkRequired("provider", provider),
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
            provider()
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
                (data.asKnown().getOrNull()?.validity() ?: 0) +
                (if (provider.asKnown().isPresent) 1 else 0)

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
                    val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                    when (type) {
                        "push_one_signal" -> {
                            return tryDeserialize(node, jacksonTypeRef<OneSignalChannelData>())
                                ?.let { Data(oneSignalChannel = it, _json = json) }
                                ?: Data(_json = json)
                        }
                        "chat_slack" -> {
                            return tryDeserialize(node, jacksonTypeRef<SlackChannelData>())?.let {
                                Data(slackChannel = it, _json = json)
                            } ?: Data(_json = json)
                        }
                        "chat_ms_teams" -> {
                            return tryDeserialize(node, jacksonTypeRef<MsTeamsChannelData>())?.let {
                                Data(msTeamsChannel = it, _json = json)
                            } ?: Data(_json = json)
                        }
                        "chat_discord" -> {
                            return tryDeserialize(node, jacksonTypeRef<DiscordChannelData>())?.let {
                                Data(discordChannel = it, _json = json)
                            } ?: Data(_json = json)
                        }
                    }

                    return tryDeserialize(node, jacksonTypeRef<PushChannelData>())?.let {
                        Data(pushChannel = it, _json = json)
                    } ?: Data(_json = json)
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

            return /* spotless:off */ other is UnnamedSchemaWithArrayParent0 && channelId == other.channelId && data == other.data && provider == other.provider && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(channelId, data, provider, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "UnnamedSchemaWithArrayParent0{channelId=$channelId, data=$data, provider=$provider, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is IdentifyUserRequest && avatar == other.avatar && channelData == other.channelData && createdAt == other.createdAt && email == other.email && locale == other.locale && name == other.name && phoneNumber == other.phoneNumber && preferences == other.preferences && timezone == other.timezone && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(avatar, channelData, createdAt, email, locale, name, phoneNumber, preferences, timezone, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "IdentifyUserRequest{avatar=$avatar, channelData=$channelData, createdAt=$createdAt, email=$email, locale=$locale, name=$name, phoneNumber=$phoneNumber, preferences=$preferences, timezone=$timezone, additionalProperties=$additionalProperties}"
}
