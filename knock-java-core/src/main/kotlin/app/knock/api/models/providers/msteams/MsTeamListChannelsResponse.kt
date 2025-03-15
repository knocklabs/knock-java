// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.providers.msteams

import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.NoAutoDetect
import app.knock.api.core.checkKnown
import app.knock.api.core.checkRequired
import app.knock.api.core.immutableEmptyMap
import app.knock.api.core.toImmutable
import app.knock.api.errors.KnockInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** The response from a channels for Microsoft Teams provider request */
@NoAutoDetect
class MsTeamListChannelsResponse
@JsonCreator
private constructor(
    @JsonProperty("ms_teams_channels")
    @ExcludeMissing
    private val msTeamsChannels: JsonField<List<MsTeamsChannel>> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun msTeamsChannels(): List<MsTeamsChannel> = msTeamsChannels.getRequired("ms_teams_channels")

    /**
     * Returns the raw JSON value of [msTeamsChannels].
     *
     * Unlike [msTeamsChannels], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("ms_teams_channels")
    @ExcludeMissing
    fun _msTeamsChannels(): JsonField<List<MsTeamsChannel>> = msTeamsChannels

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): MsTeamListChannelsResponse = apply {
        if (validated) {
            return@apply
        }

        msTeamsChannels().forEach { it.validate() }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [MsTeamListChannelsResponse].
         *
         * The following fields are required:
         * ```java
         * .msTeamsChannels()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MsTeamListChannelsResponse]. */
    class Builder internal constructor() {

        private var msTeamsChannels: JsonField<MutableList<MsTeamsChannel>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(msTeamListChannelsResponse: MsTeamListChannelsResponse) = apply {
            msTeamsChannels = msTeamListChannelsResponse.msTeamsChannels.map { it.toMutableList() }
            additionalProperties = msTeamListChannelsResponse.additionalProperties.toMutableMap()
        }

        fun msTeamsChannels(msTeamsChannels: List<MsTeamsChannel>) =
            msTeamsChannels(JsonField.of(msTeamsChannels))

        /**
         * Sets [Builder.msTeamsChannels] to an arbitrary JSON value.
         *
         * You should usually call [Builder.msTeamsChannels] with a well-typed
         * `List<MsTeamsChannel>` value instead. This method is primarily for setting the field to
         * an undocumented or not yet supported value.
         */
        fun msTeamsChannels(msTeamsChannels: JsonField<List<MsTeamsChannel>>) = apply {
            this.msTeamsChannels = msTeamsChannels.map { it.toMutableList() }
        }

        /**
         * Adds a single [MsTeamsChannel] to [msTeamsChannels].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addMsTeamsChannel(msTeamsChannel: MsTeamsChannel) = apply {
            msTeamsChannels =
                (msTeamsChannels ?: JsonField.of(mutableListOf())).also {
                    checkKnown("msTeamsChannels", it).add(msTeamsChannel)
                }
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

        fun build(): MsTeamListChannelsResponse =
            MsTeamListChannelsResponse(
                checkRequired("msTeamsChannels", msTeamsChannels).map { it.toImmutable() },
                additionalProperties.toImmutable(),
            )
    }

    @NoAutoDetect
    class MsTeamsChannel
    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("displayName")
        @ExcludeMissing
        private val displayName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("createdDateTime")
        @ExcludeMissing
        private val createdDateTime: JsonField<String> = JsonMissing.of(),
        @JsonProperty("description")
        @ExcludeMissing
        private val description: JsonField<String> = JsonMissing.of(),
        @JsonProperty("isArchived")
        @ExcludeMissing
        private val isArchived: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("membershipType")
        @ExcludeMissing
        private val membershipType: JsonField<String> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun displayName(): String = displayName.getRequired("displayName")

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun createdDateTime(): Optional<String> =
            Optional.ofNullable(createdDateTime.getNullable("createdDateTime"))

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun description(): Optional<String> =
            Optional.ofNullable(description.getNullable("description"))

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun isArchived(): Optional<Boolean> =
            Optional.ofNullable(isArchived.getNullable("isArchived"))

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun membershipType(): Optional<String> =
            Optional.ofNullable(membershipType.getNullable("membershipType"))

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [displayName].
         *
         * Unlike [displayName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("displayName")
        @ExcludeMissing
        fun _displayName(): JsonField<String> = displayName

        /**
         * Returns the raw JSON value of [createdDateTime].
         *
         * Unlike [createdDateTime], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("createdDateTime")
        @ExcludeMissing
        fun _createdDateTime(): JsonField<String> = createdDateTime

        /**
         * Returns the raw JSON value of [description].
         *
         * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("description")
        @ExcludeMissing
        fun _description(): JsonField<String> = description

        /**
         * Returns the raw JSON value of [isArchived].
         *
         * Unlike [isArchived], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("isArchived")
        @ExcludeMissing
        fun _isArchived(): JsonField<Boolean> = isArchived

        /**
         * Returns the raw JSON value of [membershipType].
         *
         * Unlike [membershipType], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("membershipType")
        @ExcludeMissing
        fun _membershipType(): JsonField<String> = membershipType

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): MsTeamsChannel = apply {
            if (validated) {
                return@apply
            }

            id()
            displayName()
            createdDateTime()
            description()
            isArchived()
            membershipType()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [MsTeamsChannel].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .displayName()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [MsTeamsChannel]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var displayName: JsonField<String>? = null
            private var createdDateTime: JsonField<String> = JsonMissing.of()
            private var description: JsonField<String> = JsonMissing.of()
            private var isArchived: JsonField<Boolean> = JsonMissing.of()
            private var membershipType: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(msTeamsChannel: MsTeamsChannel) = apply {
                id = msTeamsChannel.id
                displayName = msTeamsChannel.displayName
                createdDateTime = msTeamsChannel.createdDateTime
                description = msTeamsChannel.description
                isArchived = msTeamsChannel.isArchived
                membershipType = msTeamsChannel.membershipType
                additionalProperties = msTeamsChannel.additionalProperties.toMutableMap()
            }

            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            fun displayName(displayName: String) = displayName(JsonField.of(displayName))

            /**
             * Sets [Builder.displayName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.displayName] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun displayName(displayName: JsonField<String>) = apply {
                this.displayName = displayName
            }

            fun createdDateTime(createdDateTime: String) =
                createdDateTime(JsonField.of(createdDateTime))

            /**
             * Sets [Builder.createdDateTime] to an arbitrary JSON value.
             *
             * You should usually call [Builder.createdDateTime] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun createdDateTime(createdDateTime: JsonField<String>) = apply {
                this.createdDateTime = createdDateTime
            }

            fun description(description: String?) = description(JsonField.ofNullable(description))

            /** Alias for calling [Builder.description] with `description.orElse(null)`. */
            fun description(description: Optional<String>) = description(description.getOrNull())

            /**
             * Sets [Builder.description] to an arbitrary JSON value.
             *
             * You should usually call [Builder.description] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun description(description: JsonField<String>) = apply {
                this.description = description
            }

            fun isArchived(isArchived: Boolean) = isArchived(JsonField.of(isArchived))

            /**
             * Sets [Builder.isArchived] to an arbitrary JSON value.
             *
             * You should usually call [Builder.isArchived] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun isArchived(isArchived: JsonField<Boolean>) = apply { this.isArchived = isArchived }

            fun membershipType(membershipType: String) =
                membershipType(JsonField.of(membershipType))

            /**
             * Sets [Builder.membershipType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.membershipType] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun membershipType(membershipType: JsonField<String>) = apply {
                this.membershipType = membershipType
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

            fun build(): MsTeamsChannel =
                MsTeamsChannel(
                    checkRequired("id", id),
                    checkRequired("displayName", displayName),
                    createdDateTime,
                    description,
                    isArchived,
                    membershipType,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is MsTeamsChannel && id == other.id && displayName == other.displayName && createdDateTime == other.createdDateTime && description == other.description && isArchived == other.isArchived && membershipType == other.membershipType && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(id, displayName, createdDateTime, description, isArchived, membershipType, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "MsTeamsChannel{id=$id, displayName=$displayName, createdDateTime=$createdDateTime, description=$description, isArchived=$isArchived, membershipType=$membershipType, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is MsTeamListChannelsResponse && msTeamsChannels == other.msTeamsChannels && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(msTeamsChannels, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MsTeamListChannelsResponse{msTeamsChannels=$msTeamsChannels, additionalProperties=$additionalProperties}"
}
