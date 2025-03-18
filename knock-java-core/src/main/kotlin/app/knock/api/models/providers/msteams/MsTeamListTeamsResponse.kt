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

/** The response from a teams for Microsoft Teams provider request */
@NoAutoDetect
class MsTeamListTeamsResponse
@JsonCreator
private constructor(
    @JsonProperty("ms_teams_teams")
    @ExcludeMissing
    private val msTeamsTeams: JsonField<List<MsTeamsTeam>> = JsonMissing.of(),
    @JsonProperty("skip_token")
    @ExcludeMissing
    private val skipToken: JsonField<String> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun msTeamsTeams(): List<MsTeamsTeam> = msTeamsTeams.getRequired("ms_teams_teams")

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun skipToken(): Optional<String> = Optional.ofNullable(skipToken.getNullable("skip_token"))

    /**
     * Returns the raw JSON value of [msTeamsTeams].
     *
     * Unlike [msTeamsTeams], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("ms_teams_teams")
    @ExcludeMissing
    fun _msTeamsTeams(): JsonField<List<MsTeamsTeam>> = msTeamsTeams

    /**
     * Returns the raw JSON value of [skipToken].
     *
     * Unlike [skipToken], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("skip_token") @ExcludeMissing fun _skipToken(): JsonField<String> = skipToken

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): MsTeamListTeamsResponse = apply {
        if (validated) {
            return@apply
        }

        msTeamsTeams().forEach { it.validate() }
        skipToken()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [MsTeamListTeamsResponse].
         *
         * The following fields are required:
         * ```java
         * .msTeamsTeams()
         * .skipToken()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MsTeamListTeamsResponse]. */
    class Builder internal constructor() {

        private var msTeamsTeams: JsonField<MutableList<MsTeamsTeam>>? = null
        private var skipToken: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(msTeamListTeamsResponse: MsTeamListTeamsResponse) = apply {
            msTeamsTeams = msTeamListTeamsResponse.msTeamsTeams.map { it.toMutableList() }
            skipToken = msTeamListTeamsResponse.skipToken
            additionalProperties = msTeamListTeamsResponse.additionalProperties.toMutableMap()
        }

        fun msTeamsTeams(msTeamsTeams: List<MsTeamsTeam>) = msTeamsTeams(JsonField.of(msTeamsTeams))

        /**
         * Sets [Builder.msTeamsTeams] to an arbitrary JSON value.
         *
         * You should usually call [Builder.msTeamsTeams] with a well-typed `List<MsTeamsTeam>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun msTeamsTeams(msTeamsTeams: JsonField<List<MsTeamsTeam>>) = apply {
            this.msTeamsTeams = msTeamsTeams.map { it.toMutableList() }
        }

        /**
         * Adds a single [MsTeamsTeam] to [msTeamsTeams].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addMsTeamsTeam(msTeamsTeam: MsTeamsTeam) = apply {
            msTeamsTeams =
                (msTeamsTeams ?: JsonField.of(mutableListOf())).also {
                    checkKnown("msTeamsTeams", it).add(msTeamsTeam)
                }
        }

        fun skipToken(skipToken: String?) = skipToken(JsonField.ofNullable(skipToken))

        /** Alias for calling [Builder.skipToken] with `skipToken.orElse(null)`. */
        fun skipToken(skipToken: Optional<String>) = skipToken(skipToken.getOrNull())

        /**
         * Sets [Builder.skipToken] to an arbitrary JSON value.
         *
         * You should usually call [Builder.skipToken] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun skipToken(skipToken: JsonField<String>) = apply { this.skipToken = skipToken }

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
         * Returns an immutable instance of [MsTeamListTeamsResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .msTeamsTeams()
         * .skipToken()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): MsTeamListTeamsResponse =
            MsTeamListTeamsResponse(
                checkRequired("msTeamsTeams", msTeamsTeams).map { it.toImmutable() },
                checkRequired("skipToken", skipToken),
                additionalProperties.toImmutable(),
            )
    }

    @NoAutoDetect
    class MsTeamsTeam
    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("displayName")
        @ExcludeMissing
        private val displayName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("description")
        @ExcludeMissing
        private val description: JsonField<String> = JsonMissing.of(),
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
        fun description(): Optional<String> =
            Optional.ofNullable(description.getNullable("description"))

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
         * Returns the raw JSON value of [description].
         *
         * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("description")
        @ExcludeMissing
        fun _description(): JsonField<String> = description

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): MsTeamsTeam = apply {
            if (validated) {
                return@apply
            }

            id()
            displayName()
            description()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [MsTeamsTeam].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .displayName()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [MsTeamsTeam]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var displayName: JsonField<String>? = null
            private var description: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(msTeamsTeam: MsTeamsTeam) = apply {
                id = msTeamsTeam.id
                displayName = msTeamsTeam.displayName
                description = msTeamsTeam.description
                additionalProperties = msTeamsTeam.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [MsTeamsTeam].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .displayName()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): MsTeamsTeam =
                MsTeamsTeam(
                    checkRequired("id", id),
                    checkRequired("displayName", displayName),
                    description,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is MsTeamsTeam && id == other.id && displayName == other.displayName && description == other.description && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(id, displayName, description, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "MsTeamsTeam{id=$id, displayName=$displayName, description=$description, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is MsTeamListTeamsResponse && msTeamsTeams == other.msTeamsTeams && skipToken == other.skipToken && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(msTeamsTeams, skipToken, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MsTeamListTeamsResponse{msTeamsTeams=$msTeamsTeams, skipToken=$skipToken, additionalProperties=$additionalProperties}"
}
