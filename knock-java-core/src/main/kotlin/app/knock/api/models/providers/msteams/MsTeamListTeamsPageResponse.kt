// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.providers.msteams

import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.checkKnown
import app.knock.api.core.checkRequired
import app.knock.api.core.toImmutable
import app.knock.api.errors.KnockInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** The response from a Microsoft Teams provider request, containing a list of teams. */
class MsTeamListTeamsPageResponse
private constructor(
    private val msTeamsTeams: JsonField<List<MsTeamListTeamsResponse>>,
    private val skipToken: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("ms_teams_teams")
        @ExcludeMissing
        msTeamsTeams: JsonField<List<MsTeamListTeamsResponse>> = JsonMissing.of(),
        @JsonProperty("skip_token") @ExcludeMissing skipToken: JsonField<String> = JsonMissing.of(),
    ) : this(msTeamsTeams, skipToken, mutableMapOf())

    /**
     * List of Microsoft Teams teams.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun msTeamsTeams(): List<MsTeamListTeamsResponse> = msTeamsTeams.getRequired("ms_teams_teams")

    /**
     * [OData param](https://learn.microsoft.com/en-us/graph/query-parameters) passed to the
     * Microsoft Graph API to retrieve the next page of results.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun skipToken(): Optional<String> = skipToken.getOptional("skip_token")

    /**
     * Returns the raw JSON value of [msTeamsTeams].
     *
     * Unlike [msTeamsTeams], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("ms_teams_teams")
    @ExcludeMissing
    fun _msTeamsTeams(): JsonField<List<MsTeamListTeamsResponse>> = msTeamsTeams

    /**
     * Returns the raw JSON value of [skipToken].
     *
     * Unlike [skipToken], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("skip_token") @ExcludeMissing fun _skipToken(): JsonField<String> = skipToken

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
         * Returns a mutable builder for constructing an instance of [MsTeamListTeamsPageResponse].
         *
         * The following fields are required:
         * ```java
         * .msTeamsTeams()
         * .skipToken()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MsTeamListTeamsPageResponse]. */
    class Builder internal constructor() {

        private var msTeamsTeams: JsonField<MutableList<MsTeamListTeamsResponse>>? = null
        private var skipToken: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(msTeamListTeamsPageResponse: MsTeamListTeamsPageResponse) = apply {
            msTeamsTeams = msTeamListTeamsPageResponse.msTeamsTeams.map { it.toMutableList() }
            skipToken = msTeamListTeamsPageResponse.skipToken
            additionalProperties = msTeamListTeamsPageResponse.additionalProperties.toMutableMap()
        }

        /** List of Microsoft Teams teams. */
        fun msTeamsTeams(msTeamsTeams: List<MsTeamListTeamsResponse>) =
            msTeamsTeams(JsonField.of(msTeamsTeams))

        /**
         * Sets [Builder.msTeamsTeams] to an arbitrary JSON value.
         *
         * You should usually call [Builder.msTeamsTeams] with a well-typed
         * `List<MsTeamListTeamsResponse>` value instead. This method is primarily for setting the
         * field to an undocumented or not yet supported value.
         */
        fun msTeamsTeams(msTeamsTeams: JsonField<List<MsTeamListTeamsResponse>>) = apply {
            this.msTeamsTeams = msTeamsTeams.map { it.toMutableList() }
        }

        /**
         * Adds a single [MsTeamListTeamsResponse] to [msTeamsTeams].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addMsTeamsTeam(msTeamsTeam: MsTeamListTeamsResponse) = apply {
            msTeamsTeams =
                (msTeamsTeams ?: JsonField.of(mutableListOf())).also {
                    checkKnown("msTeamsTeams", it).add(msTeamsTeam)
                }
        }

        /**
         * [OData param](https://learn.microsoft.com/en-us/graph/query-parameters) passed to the
         * Microsoft Graph API to retrieve the next page of results.
         */
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
         * Returns an immutable instance of [MsTeamListTeamsPageResponse].
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
        fun build(): MsTeamListTeamsPageResponse =
            MsTeamListTeamsPageResponse(
                checkRequired("msTeamsTeams", msTeamsTeams).map { it.toImmutable() },
                checkRequired("skipToken", skipToken),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): MsTeamListTeamsPageResponse = apply {
        if (validated) {
            return@apply
        }

        msTeamsTeams().forEach { it.validate() }
        skipToken()
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
        (msTeamsTeams.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (skipToken.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is MsTeamListTeamsPageResponse && msTeamsTeams == other.msTeamsTeams && skipToken == other.skipToken && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(msTeamsTeams, skipToken, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MsTeamListTeamsPageResponse{msTeamsTeams=$msTeamsTeams, skipToken=$skipToken, additionalProperties=$additionalProperties}"
}
