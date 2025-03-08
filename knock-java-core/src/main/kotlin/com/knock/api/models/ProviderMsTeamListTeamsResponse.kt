// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.knock.api.core.ExcludeMissing
import com.knock.api.core.JsonField
import com.knock.api.core.JsonMissing
import com.knock.api.core.JsonValue
import com.knock.api.core.NoAutoDetect
import com.knock.api.core.checkKnown
import com.knock.api.core.checkRequired
import com.knock.api.core.immutableEmptyMap
import com.knock.api.core.toImmutable
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** The response from a teams for Microsoft Teams provider request */
@NoAutoDetect
class ProviderMsTeamListTeamsResponse
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

    fun msTeamsTeams(): List<MsTeamsTeam> = msTeamsTeams.getRequired("ms_teams_teams")

    fun skipToken(): Optional<String> = Optional.ofNullable(skipToken.getNullable("skip_token"))

    @JsonProperty("ms_teams_teams")
    @ExcludeMissing
    fun _msTeamsTeams(): JsonField<List<MsTeamsTeam>> = msTeamsTeams

    @JsonProperty("skip_token") @ExcludeMissing fun _skipToken(): JsonField<String> = skipToken

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ProviderMsTeamListTeamsResponse = apply {
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
         * Returns a mutable builder for constructing an instance of
         * [ProviderMsTeamListTeamsResponse].
         *
         * The following fields are required:
         * ```java
         * .msTeamsTeams()
         * .skipToken()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ProviderMsTeamListTeamsResponse]. */
    class Builder internal constructor() {

        private var msTeamsTeams: JsonField<MutableList<MsTeamsTeam>>? = null
        private var skipToken: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(providerMsTeamListTeamsResponse: ProviderMsTeamListTeamsResponse) =
            apply {
                msTeamsTeams =
                    providerMsTeamListTeamsResponse.msTeamsTeams.map { it.toMutableList() }
                skipToken = providerMsTeamListTeamsResponse.skipToken
                additionalProperties =
                    providerMsTeamListTeamsResponse.additionalProperties.toMutableMap()
            }

        fun msTeamsTeams(msTeamsTeams: List<MsTeamsTeam>) = msTeamsTeams(JsonField.of(msTeamsTeams))

        fun msTeamsTeams(msTeamsTeams: JsonField<List<MsTeamsTeam>>) = apply {
            this.msTeamsTeams = msTeamsTeams.map { it.toMutableList() }
        }

        fun addMsTeamsTeam(msTeamsTeam: MsTeamsTeam) = apply {
            msTeamsTeams =
                (msTeamsTeams ?: JsonField.of(mutableListOf())).also {
                    checkKnown("msTeamsTeams", it).add(msTeamsTeam)
                }
        }

        fun skipToken(skipToken: String?) = skipToken(JsonField.ofNullable(skipToken))

        fun skipToken(skipToken: Optional<String>) = skipToken(skipToken.getOrNull())

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

        fun build(): ProviderMsTeamListTeamsResponse =
            ProviderMsTeamListTeamsResponse(
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

        fun id(): String = id.getRequired("id")

        fun displayName(): String = displayName.getRequired("displayName")

        fun description(): Optional<String> =
            Optional.ofNullable(description.getNullable("description"))

        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        @JsonProperty("displayName")
        @ExcludeMissing
        fun _displayName(): JsonField<String> = displayName

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

            fun id(id: JsonField<String>) = apply { this.id = id }

            fun displayName(displayName: String) = displayName(JsonField.of(displayName))

            fun displayName(displayName: JsonField<String>) = apply {
                this.displayName = displayName
            }

            fun description(description: String?) = description(JsonField.ofNullable(description))

            fun description(description: Optional<String>) = description(description.getOrNull())

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

        return /* spotless:off */ other is ProviderMsTeamListTeamsResponse && msTeamsTeams == other.msTeamsTeams && skipToken == other.skipToken && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(msTeamsTeams, skipToken, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ProviderMsTeamListTeamsResponse{msTeamsTeams=$msTeamsTeams, skipToken=$skipToken, additionalProperties=$additionalProperties}"
}
