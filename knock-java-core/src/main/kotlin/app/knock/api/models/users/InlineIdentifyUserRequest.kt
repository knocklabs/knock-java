// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.checkRequired
import app.knock.api.errors.KnockInvalidDataException
import app.knock.api.models.recipients.channeldata.InlineChannelDataRequest
import app.knock.api.models.recipients.preferences.InlinePreferenceSetRequest
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * A set of parameters to inline-identify a user with. Inline identifying the user will ensure that
 * the user is available before the request is executed in Knock. It will perform an upsert for the
 * user you're supplying, replacing any properties specified.
 */
class InlineIdentifyUserRequest
private constructor(
    private val id: JsonField<String>,
    private val channelData: JsonField<InlineChannelDataRequest>,
    private val createdAt: JsonField<OffsetDateTime>,
    private val email: JsonField<String>,
    private val name: JsonField<String>,
    private val preferences: JsonField<InlinePreferenceSetRequest>,
    private val timezone: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("channel_data")
        @ExcludeMissing
        channelData: JsonField<InlineChannelDataRequest> = JsonMissing.of(),
        @JsonProperty("created_at")
        @ExcludeMissing
        createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("email") @ExcludeMissing email: JsonField<String> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("preferences")
        @ExcludeMissing
        preferences: JsonField<InlinePreferenceSetRequest> = JsonMissing.of(),
        @JsonProperty("timezone") @ExcludeMissing timezone: JsonField<String> = JsonMissing.of(),
    ) : this(id, channelData, createdAt, email, name, preferences, timezone, mutableMapOf())

    /**
     * The ID for the user that you set when identifying them in Knock.
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
    fun channelData(): Optional<InlineChannelDataRequest> = channelData.getOptional("channel_data")

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
     * Display name of the user.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun name(): Optional<String> = name.getOptional("name")

    /**
     * Inline set preferences for a recipient, where the key is the preference set id.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun preferences(): Optional<InlinePreferenceSetRequest> = preferences.getOptional("preferences")

    /**
     * The timezone of the user. Must be a valid [tz database time zone
     * string](https://en.wikipedia.org/wiki/List_of_tz_database_time_zones). Used for [recurring
     * schedules](/concepts/schedules#scheduling-workflows-with-recurring-schedules-for-recipients).
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun timezone(): Optional<String> = timezone.getOptional("timezone")

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
    fun _channelData(): JsonField<InlineChannelDataRequest> = channelData

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
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /**
     * Returns the raw JSON value of [preferences].
     *
     * Unlike [preferences], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("preferences")
    @ExcludeMissing
    fun _preferences(): JsonField<InlinePreferenceSetRequest> = preferences

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

        /**
         * Returns a mutable builder for constructing an instance of [InlineIdentifyUserRequest].
         *
         * The following fields are required:
         * ```java
         * .id()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [InlineIdentifyUserRequest]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var channelData: JsonField<InlineChannelDataRequest> = JsonMissing.of()
        private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var email: JsonField<String> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var preferences: JsonField<InlinePreferenceSetRequest> = JsonMissing.of()
        private var timezone: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(inlineIdentifyUserRequest: InlineIdentifyUserRequest) = apply {
            id = inlineIdentifyUserRequest.id
            channelData = inlineIdentifyUserRequest.channelData
            createdAt = inlineIdentifyUserRequest.createdAt
            email = inlineIdentifyUserRequest.email
            name = inlineIdentifyUserRequest.name
            preferences = inlineIdentifyUserRequest.preferences
            timezone = inlineIdentifyUserRequest.timezone
            additionalProperties = inlineIdentifyUserRequest.additionalProperties.toMutableMap()
        }

        /** The ID for the user that you set when identifying them in Knock. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** A request to set channel data for a type of channel inline. */
        fun channelData(channelData: InlineChannelDataRequest?) =
            channelData(JsonField.ofNullable(channelData))

        /** Alias for calling [Builder.channelData] with `channelData.orElse(null)`. */
        fun channelData(channelData: Optional<InlineChannelDataRequest>) =
            channelData(channelData.getOrNull())

        /**
         * Sets [Builder.channelData] to an arbitrary JSON value.
         *
         * You should usually call [Builder.channelData] with a well-typed
         * [InlineChannelDataRequest] value instead. This method is primarily for setting the field
         * to an undocumented or not yet supported value.
         */
        fun channelData(channelData: JsonField<InlineChannelDataRequest>) = apply {
            this.channelData = channelData
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

        /** Inline set preferences for a recipient, where the key is the preference set id. */
        fun preferences(preferences: InlinePreferenceSetRequest?) =
            preferences(JsonField.ofNullable(preferences))

        /** Alias for calling [Builder.preferences] with `preferences.orElse(null)`. */
        fun preferences(preferences: Optional<InlinePreferenceSetRequest>) =
            preferences(preferences.getOrNull())

        /**
         * Sets [Builder.preferences] to an arbitrary JSON value.
         *
         * You should usually call [Builder.preferences] with a well-typed
         * [InlinePreferenceSetRequest] value instead. This method is primarily for setting the
         * field to an undocumented or not yet supported value.
         */
        fun preferences(preferences: JsonField<InlinePreferenceSetRequest>) = apply {
            this.preferences = preferences
        }

        /**
         * The timezone of the user. Must be a valid [tz database time zone
         * string](https://en.wikipedia.org/wiki/List_of_tz_database_time_zones). Used
         * for [recurring
         * schedules](/concepts/schedules#scheduling-workflows-with-recurring-schedules-for-recipients).
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
         * Returns an immutable instance of [InlineIdentifyUserRequest].
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
        fun build(): InlineIdentifyUserRequest =
            InlineIdentifyUserRequest(
                checkRequired("id", id),
                channelData,
                createdAt,
                email,
                name,
                preferences,
                timezone,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): InlineIdentifyUserRequest = apply {
        if (validated) {
            return@apply
        }

        id()
        channelData().ifPresent { it.validate() }
        createdAt()
        email()
        name()
        preferences().ifPresent { it.validate() }
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
        (if (id.asKnown().isPresent) 1 else 0) +
            (channelData.asKnown().getOrNull()?.validity() ?: 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (if (email.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (preferences.asKnown().getOrNull()?.validity() ?: 0) +
            (if (timezone.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is InlineIdentifyUserRequest && id == other.id && channelData == other.channelData && createdAt == other.createdAt && email == other.email && name == other.name && preferences == other.preferences && timezone == other.timezone && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, channelData, createdAt, email, name, preferences, timezone, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "InlineIdentifyUserRequest{id=$id, channelData=$channelData, createdAt=$createdAt, email=$email, name=$name, preferences=$preferences, timezone=$timezone, additionalProperties=$additionalProperties}"
}
