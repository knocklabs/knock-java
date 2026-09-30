// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users.guides

import app.knock.api.core.Enum
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
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A response for a list of guides. */
class GuideGetChannelResponse
private constructor(
    private val entries: JsonField<List<Entry>>,
    private val guideGroupDisplayLogs: JsonField<GuideGroupDisplayLogs>,
    private val guideGroups: JsonField<List<GuideGroup>>,
    private val ineligibleGuides: JsonField<List<IneligibleGuide>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("entries") @ExcludeMissing entries: JsonField<List<Entry>> = JsonMissing.of(),
        @JsonProperty("guide_group_display_logs")
        @ExcludeMissing
        guideGroupDisplayLogs: JsonField<GuideGroupDisplayLogs> = JsonMissing.of(),
        @JsonProperty("guide_groups")
        @ExcludeMissing
        guideGroups: JsonField<List<GuideGroup>> = JsonMissing.of(),
        @JsonProperty("ineligible_guides")
        @ExcludeMissing
        ineligibleGuides: JsonField<List<IneligibleGuide>> = JsonMissing.of(),
    ) : this(entries, guideGroupDisplayLogs, guideGroups, ineligibleGuides, mutableMapOf())

    /**
     * A list of guides.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun entries(): List<Entry> = entries.getRequired("entries")

    /**
     * A map of guide group keys to their last display timestamps.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun guideGroupDisplayLogs(): GuideGroupDisplayLogs =
        guideGroupDisplayLogs.getRequired("guide_group_display_logs")

    /**
     * A list of guide groups with their display sequences and intervals.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun guideGroups(): List<GuideGroup> = guideGroups.getRequired("guide_groups")

    /**
     * Markers for guides the user is not eligible to see.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun ineligibleGuides(): List<IneligibleGuide> =
        ineligibleGuides.getRequired("ineligible_guides")

    /**
     * Returns the raw JSON value of [entries].
     *
     * Unlike [entries], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("entries") @ExcludeMissing fun _entries(): JsonField<List<Entry>> = entries

    /**
     * Returns the raw JSON value of [guideGroupDisplayLogs].
     *
     * Unlike [guideGroupDisplayLogs], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("guide_group_display_logs")
    @ExcludeMissing
    fun _guideGroupDisplayLogs(): JsonField<GuideGroupDisplayLogs> = guideGroupDisplayLogs

    /**
     * Returns the raw JSON value of [guideGroups].
     *
     * Unlike [guideGroups], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("guide_groups")
    @ExcludeMissing
    fun _guideGroups(): JsonField<List<GuideGroup>> = guideGroups

    /**
     * Returns the raw JSON value of [ineligibleGuides].
     *
     * Unlike [ineligibleGuides], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("ineligible_guides")
    @ExcludeMissing
    fun _ineligibleGuides(): JsonField<List<IneligibleGuide>> = ineligibleGuides

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
         * Returns a mutable builder for constructing an instance of [GuideGetChannelResponse].
         *
         * The following fields are required:
         * ```java
         * .entries()
         * .guideGroupDisplayLogs()
         * .guideGroups()
         * .ineligibleGuides()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [GuideGetChannelResponse]. */
    class Builder internal constructor() {

        private var entries: JsonField<MutableList<Entry>>? = null
        private var guideGroupDisplayLogs: JsonField<GuideGroupDisplayLogs>? = null
        private var guideGroups: JsonField<MutableList<GuideGroup>>? = null
        private var ineligibleGuides: JsonField<MutableList<IneligibleGuide>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(guideGetChannelResponse: GuideGetChannelResponse) = apply {
            entries = guideGetChannelResponse.entries.map { it.toMutableList() }
            guideGroupDisplayLogs = guideGetChannelResponse.guideGroupDisplayLogs
            guideGroups = guideGetChannelResponse.guideGroups.map { it.toMutableList() }
            ineligibleGuides = guideGetChannelResponse.ineligibleGuides.map { it.toMutableList() }
            additionalProperties = guideGetChannelResponse.additionalProperties.toMutableMap()
        }

        /** A list of guides. */
        fun entries(entries: List<Entry>) = entries(JsonField.of(entries))

        /**
         * Sets [Builder.entries] to an arbitrary JSON value.
         *
         * You should usually call [Builder.entries] with a well-typed `List<Entry>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun entries(entries: JsonField<List<Entry>>) = apply {
            this.entries = entries.map { it.toMutableList() }
        }

        /**
         * Adds a single [Entry] to [entries].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addEntry(entry: Entry) = apply {
            entries =
                (entries ?: JsonField.of(mutableListOf())).also {
                    checkKnown("entries", it).add(entry)
                }
        }

        /** A map of guide group keys to their last display timestamps. */
        fun guideGroupDisplayLogs(guideGroupDisplayLogs: GuideGroupDisplayLogs) =
            guideGroupDisplayLogs(JsonField.of(guideGroupDisplayLogs))

        /**
         * Sets [Builder.guideGroupDisplayLogs] to an arbitrary JSON value.
         *
         * You should usually call [Builder.guideGroupDisplayLogs] with a well-typed
         * [GuideGroupDisplayLogs] value instead. This method is primarily for setting the field to
         * an undocumented or not yet supported value.
         */
        fun guideGroupDisplayLogs(guideGroupDisplayLogs: JsonField<GuideGroupDisplayLogs>) = apply {
            this.guideGroupDisplayLogs = guideGroupDisplayLogs
        }

        /** A list of guide groups with their display sequences and intervals. */
        fun guideGroups(guideGroups: List<GuideGroup>) = guideGroups(JsonField.of(guideGroups))

        /**
         * Sets [Builder.guideGroups] to an arbitrary JSON value.
         *
         * You should usually call [Builder.guideGroups] with a well-typed `List<GuideGroup>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun guideGroups(guideGroups: JsonField<List<GuideGroup>>) = apply {
            this.guideGroups = guideGroups.map { it.toMutableList() }
        }

        /**
         * Adds a single [GuideGroup] to [guideGroups].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addGuideGroup(guideGroup: GuideGroup) = apply {
            guideGroups =
                (guideGroups ?: JsonField.of(mutableListOf())).also {
                    checkKnown("guide_groups", it).add(guideGroup)
                }
        }

        /** Markers for guides the user is not eligible to see. */
        fun ineligibleGuides(ineligibleGuides: List<IneligibleGuide>) =
            ineligibleGuides(JsonField.of(ineligibleGuides))

        /**
         * Sets [Builder.ineligibleGuides] to an arbitrary JSON value.
         *
         * You should usually call [Builder.ineligibleGuides] with a well-typed
         * `List<IneligibleGuide>` value instead. This method is primarily for setting the field to
         * an undocumented or not yet supported value.
         */
        fun ineligibleGuides(ineligibleGuides: JsonField<List<IneligibleGuide>>) = apply {
            this.ineligibleGuides = ineligibleGuides.map { it.toMutableList() }
        }

        /**
         * Adds a single [IneligibleGuide] to [ineligibleGuides].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addIneligibleGuide(ineligibleGuide: IneligibleGuide) = apply {
            ineligibleGuides =
                (ineligibleGuides ?: JsonField.of(mutableListOf())).also {
                    checkKnown("ineligible_guides", it).add(ineligibleGuide)
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

        /**
         * Returns an immutable instance of [GuideGetChannelResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .entries()
         * .guideGroupDisplayLogs()
         * .guideGroups()
         * .ineligibleGuides()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): GuideGetChannelResponse =
            GuideGetChannelResponse(
                checkRequired("entries", entries).map { it.toImmutable() },
                checkRequired("guide_group_display_logs", guideGroupDisplayLogs),
                checkRequired("guide_groups", guideGroups).map { it.toImmutable() },
                checkRequired("ineligible_guides", ineligibleGuides).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): GuideGetChannelResponse = apply {
        if (validated) {
            return@apply
        }

        entries().forEach { it.validate() }
        guideGroupDisplayLogs().validate()
        guideGroups().forEach { it.validate() }
        ineligibleGuides().forEach { it.validate() }
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
        (entries.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (guideGroupDisplayLogs.asKnown().getOrNull()?.validity() ?: 0) +
            (guideGroups.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (ineligibleGuides.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    class Entry
    private constructor(
        private val id: JsonField<String>,
        private val _typename: JsonField<String>,
        private val activationUrlPatterns: JsonField<List<ActivationUrlPattern>>,
        private val activationUrlRules: JsonField<List<ActivationUrlRule>>,
        private val active: JsonField<Boolean>,
        private val bypassGlobalGroupLimit: JsonField<Boolean>,
        private val channelId: JsonField<String>,
        private val dashboardUrl: JsonField<String>,
        private val insertedAt: JsonField<String>,
        private val key: JsonField<String>,
        private val semver: JsonField<String>,
        private val steps: JsonField<List<Step>>,
        private val type: JsonField<String>,
        private val updatedAt: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("__typename")
            @ExcludeMissing
            _typename: JsonField<String> = JsonMissing.of(),
            @JsonProperty("activation_url_patterns")
            @ExcludeMissing
            activationUrlPatterns: JsonField<List<ActivationUrlPattern>> = JsonMissing.of(),
            @JsonProperty("activation_url_rules")
            @ExcludeMissing
            activationUrlRules: JsonField<List<ActivationUrlRule>> = JsonMissing.of(),
            @JsonProperty("active") @ExcludeMissing active: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("bypass_global_group_limit")
            @ExcludeMissing
            bypassGlobalGroupLimit: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("channel_id")
            @ExcludeMissing
            channelId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("dashboard_url")
            @ExcludeMissing
            dashboardUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("inserted_at")
            @ExcludeMissing
            insertedAt: JsonField<String> = JsonMissing.of(),
            @JsonProperty("key") @ExcludeMissing key: JsonField<String> = JsonMissing.of(),
            @JsonProperty("semver") @ExcludeMissing semver: JsonField<String> = JsonMissing.of(),
            @JsonProperty("steps") @ExcludeMissing steps: JsonField<List<Step>> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
            @JsonProperty("updated_at")
            @ExcludeMissing
            updatedAt: JsonField<String> = JsonMissing.of(),
        ) : this(
            id,
            _typename,
            activationUrlPatterns,
            activationUrlRules,
            active,
            bypassGlobalGroupLimit,
            channelId,
            dashboardUrl,
            insertedAt,
            key,
            semver,
            steps,
            type,
            updatedAt,
            mutableMapOf(),
        )

        /**
         * The unique identifier for the guide.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * The typename of the schema.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun _typename(): Optional<String> = _typename.getOptional("__typename")

        /**
         * A list of URL Patterns to evaluate user's current location to activate the guide, if
         * matched
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun activationUrlPatterns(): Optional<List<ActivationUrlPattern>> =
            activationUrlPatterns.getOptional("activation_url_patterns")

        /**
         * A list of URL rules to evaluate user's current location to activate the guide, if matched
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun activationUrlRules(): Optional<List<ActivationUrlRule>> =
            activationUrlRules.getOptional("activation_url_rules")

        /**
         * Whether the guide is active.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun active(): Optional<Boolean> = active.getOptional("active")

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun bypassGlobalGroupLimit(): Optional<Boolean> =
            bypassGlobalGroupLimit.getOptional("bypass_global_group_limit")

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun channelId(): Optional<String> = channelId.getOptional("channel_id")

        /**
         * URL to this guide in the Knock dashboard
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun dashboardUrl(): Optional<String> = dashboardUrl.getOptional("dashboard_url")

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun insertedAt(): Optional<String> = insertedAt.getOptional("inserted_at")

        /**
         * The key of the guide.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun key(): Optional<String> = key.getOptional("key")

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun semver(): Optional<String> = semver.getOptional("semver")

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun steps(): Optional<List<Step>> = steps.getOptional("steps")

        /**
         * The type of the guide.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun type(): Optional<String> = type.getOptional("type")

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun updatedAt(): Optional<String> = updatedAt.getOptional("updated_at")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [_typename].
         *
         * Unlike [_typename], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("__typename") @ExcludeMissing fun __typename(): JsonField<String> = _typename

        /**
         * Returns the raw JSON value of [activationUrlPatterns].
         *
         * Unlike [activationUrlPatterns], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("activation_url_patterns")
        @ExcludeMissing
        fun _activationUrlPatterns(): JsonField<List<ActivationUrlPattern>> = activationUrlPatterns

        /**
         * Returns the raw JSON value of [activationUrlRules].
         *
         * Unlike [activationUrlRules], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("activation_url_rules")
        @ExcludeMissing
        fun _activationUrlRules(): JsonField<List<ActivationUrlRule>> = activationUrlRules

        /**
         * Returns the raw JSON value of [active].
         *
         * Unlike [active], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("active") @ExcludeMissing fun _active(): JsonField<Boolean> = active

        /**
         * Returns the raw JSON value of [bypassGlobalGroupLimit].
         *
         * Unlike [bypassGlobalGroupLimit], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("bypass_global_group_limit")
        @ExcludeMissing
        fun _bypassGlobalGroupLimit(): JsonField<Boolean> = bypassGlobalGroupLimit

        /**
         * Returns the raw JSON value of [channelId].
         *
         * Unlike [channelId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("channel_id") @ExcludeMissing fun _channelId(): JsonField<String> = channelId

        /**
         * Returns the raw JSON value of [dashboardUrl].
         *
         * Unlike [dashboardUrl], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("dashboard_url")
        @ExcludeMissing
        fun _dashboardUrl(): JsonField<String> = dashboardUrl

        /**
         * Returns the raw JSON value of [insertedAt].
         *
         * Unlike [insertedAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("inserted_at")
        @ExcludeMissing
        fun _insertedAt(): JsonField<String> = insertedAt

        /**
         * Returns the raw JSON value of [key].
         *
         * Unlike [key], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("key") @ExcludeMissing fun _key(): JsonField<String> = key

        /**
         * Returns the raw JSON value of [semver].
         *
         * Unlike [semver], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("semver") @ExcludeMissing fun _semver(): JsonField<String> = semver

        /**
         * Returns the raw JSON value of [steps].
         *
         * Unlike [steps], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("steps") @ExcludeMissing fun _steps(): JsonField<List<Step>> = steps

        /**
         * Returns the raw JSON value of [type].
         *
         * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

        /**
         * Returns the raw JSON value of [updatedAt].
         *
         * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("updated_at") @ExcludeMissing fun _updatedAt(): JsonField<String> = updatedAt

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

            /** Returns a mutable builder for constructing an instance of [Entry]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Entry]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var _typename: JsonField<String> = JsonMissing.of()
            private var activationUrlPatterns: JsonField<MutableList<ActivationUrlPattern>>? = null
            private var activationUrlRules: JsonField<MutableList<ActivationUrlRule>>? = null
            private var active: JsonField<Boolean> = JsonMissing.of()
            private var bypassGlobalGroupLimit: JsonField<Boolean> = JsonMissing.of()
            private var channelId: JsonField<String> = JsonMissing.of()
            private var dashboardUrl: JsonField<String> = JsonMissing.of()
            private var insertedAt: JsonField<String> = JsonMissing.of()
            private var key: JsonField<String> = JsonMissing.of()
            private var semver: JsonField<String> = JsonMissing.of()
            private var steps: JsonField<MutableList<Step>>? = null
            private var type: JsonField<String> = JsonMissing.of()
            private var updatedAt: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(entry: Entry) = apply {
                id = entry.id
                _typename = entry._typename
                activationUrlPatterns = entry.activationUrlPatterns.map { it.toMutableList() }
                activationUrlRules = entry.activationUrlRules.map { it.toMutableList() }
                active = entry.active
                bypassGlobalGroupLimit = entry.bypassGlobalGroupLimit
                channelId = entry.channelId
                dashboardUrl = entry.dashboardUrl
                insertedAt = entry.insertedAt
                key = entry.key
                semver = entry.semver
                steps = entry.steps.map { it.toMutableList() }
                type = entry.type
                updatedAt = entry.updatedAt
                additionalProperties = entry.additionalProperties.toMutableMap()
            }

            /** The unique identifier for the guide. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The typename of the schema. */
            fun _typename(_typename: String) = _typename(JsonField.of(_typename))

            /**
             * Sets [Builder._typename] to an arbitrary JSON value.
             *
             * You should usually call [Builder._typename] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun _typename(_typename: JsonField<String>) = apply { this._typename = _typename }

            /**
             * A list of URL Patterns to evaluate user's current location to activate the guide, if
             * matched
             */
            fun activationUrlPatterns(activationUrlPatterns: List<ActivationUrlPattern>) =
                activationUrlPatterns(JsonField.of(activationUrlPatterns))

            /**
             * Sets [Builder.activationUrlPatterns] to an arbitrary JSON value.
             *
             * You should usually call [Builder.activationUrlPatterns] with a well-typed
             * `List<ActivationUrlPattern>` value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
             */
            fun activationUrlPatterns(
                activationUrlPatterns: JsonField<List<ActivationUrlPattern>>
            ) = apply {
                this.activationUrlPatterns = activationUrlPatterns.map { it.toMutableList() }
            }

            /**
             * Adds a single [ActivationUrlPattern] to [activationUrlPatterns].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addActivationUrlPattern(activationUrlPattern: ActivationUrlPattern) = apply {
                activationUrlPatterns =
                    (activationUrlPatterns ?: JsonField.of(mutableListOf())).also {
                        checkKnown("activation_url_patterns", it).add(activationUrlPattern)
                    }
            }

            /**
             * A list of URL rules to evaluate user's current location to activate the guide, if
             * matched
             */
            fun activationUrlRules(activationUrlRules: List<ActivationUrlRule>) =
                activationUrlRules(JsonField.of(activationUrlRules))

            /**
             * Sets [Builder.activationUrlRules] to an arbitrary JSON value.
             *
             * You should usually call [Builder.activationUrlRules] with a well-typed
             * `List<ActivationUrlRule>` value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
             */
            fun activationUrlRules(activationUrlRules: JsonField<List<ActivationUrlRule>>) = apply {
                this.activationUrlRules = activationUrlRules.map { it.toMutableList() }
            }

            /**
             * Adds a single [ActivationUrlRule] to [activationUrlRules].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addActivationUrlRule(activationUrlRule: ActivationUrlRule) = apply {
                activationUrlRules =
                    (activationUrlRules ?: JsonField.of(mutableListOf())).also {
                        checkKnown("activation_url_rules", it).add(activationUrlRule)
                    }
            }

            /** Whether the guide is active. */
            fun active(active: Boolean) = active(JsonField.of(active))

            /**
             * Sets [Builder.active] to an arbitrary JSON value.
             *
             * You should usually call [Builder.active] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun active(active: JsonField<Boolean>) = apply { this.active = active }

            fun bypassGlobalGroupLimit(bypassGlobalGroupLimit: Boolean) =
                bypassGlobalGroupLimit(JsonField.of(bypassGlobalGroupLimit))

            /**
             * Sets [Builder.bypassGlobalGroupLimit] to an arbitrary JSON value.
             *
             * You should usually call [Builder.bypassGlobalGroupLimit] with a well-typed [Boolean]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun bypassGlobalGroupLimit(bypassGlobalGroupLimit: JsonField<Boolean>) = apply {
                this.bypassGlobalGroupLimit = bypassGlobalGroupLimit
            }

            fun channelId(channelId: String) = channelId(JsonField.of(channelId))

            /**
             * Sets [Builder.channelId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.channelId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun channelId(channelId: JsonField<String>) = apply { this.channelId = channelId }

            /** URL to this guide in the Knock dashboard */
            fun dashboardUrl(dashboardUrl: String) = dashboardUrl(JsonField.of(dashboardUrl))

            /**
             * Sets [Builder.dashboardUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.dashboardUrl] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun dashboardUrl(dashboardUrl: JsonField<String>) = apply {
                this.dashboardUrl = dashboardUrl
            }

            fun insertedAt(insertedAt: String) = insertedAt(JsonField.of(insertedAt))

            /**
             * Sets [Builder.insertedAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.insertedAt] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun insertedAt(insertedAt: JsonField<String>) = apply { this.insertedAt = insertedAt }

            /** The key of the guide. */
            fun key(key: String) = key(JsonField.of(key))

            /**
             * Sets [Builder.key] to an arbitrary JSON value.
             *
             * You should usually call [Builder.key] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun key(key: JsonField<String>) = apply { this.key = key }

            fun semver(semver: String) = semver(JsonField.of(semver))

            /**
             * Sets [Builder.semver] to an arbitrary JSON value.
             *
             * You should usually call [Builder.semver] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun semver(semver: JsonField<String>) = apply { this.semver = semver }

            fun steps(steps: List<Step>) = steps(JsonField.of(steps))

            /**
             * Sets [Builder.steps] to an arbitrary JSON value.
             *
             * You should usually call [Builder.steps] with a well-typed `List<Step>` value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun steps(steps: JsonField<List<Step>>) = apply {
                this.steps = steps.map { it.toMutableList() }
            }

            /**
             * Adds a single [Step] to [steps].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addStep(step: Step) = apply {
                steps =
                    (steps ?: JsonField.of(mutableListOf())).also {
                        checkKnown("steps", it).add(step)
                    }
            }

            /** The type of the guide. */
            fun type(type: String) = type(JsonField.of(type))

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun type(type: JsonField<String>) = apply { this.type = type }

            fun updatedAt(updatedAt: String) = updatedAt(JsonField.of(updatedAt))

            /**
             * Sets [Builder.updatedAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.updatedAt] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun updatedAt(updatedAt: JsonField<String>) = apply { this.updatedAt = updatedAt }

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
             * Returns an immutable instance of [Entry].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Entry =
                Entry(
                    id,
                    _typename,
                    (activationUrlPatterns ?: JsonMissing.of()).map { it.toImmutable() },
                    (activationUrlRules ?: JsonMissing.of()).map { it.toImmutable() },
                    active,
                    bypassGlobalGroupLimit,
                    channelId,
                    dashboardUrl,
                    insertedAt,
                    key,
                    semver,
                    (steps ?: JsonMissing.of()).map { it.toImmutable() },
                    type,
                    updatedAt,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Entry = apply {
            if (validated) {
                return@apply
            }

            id()
            _typename()
            activationUrlPatterns().ifPresent { it.forEach { it.validate() } }
            activationUrlRules().ifPresent { it.forEach { it.validate() } }
            active()
            bypassGlobalGroupLimit()
            channelId()
            dashboardUrl()
            insertedAt()
            key()
            semver()
            steps().ifPresent { it.forEach { it.validate() } }
            type()
            updatedAt()
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
                (if (_typename.asKnown().isPresent) 1 else 0) +
                (activationUrlPatterns.asKnown().getOrNull()?.sumOf { it.validity().toInt() }
                    ?: 0) +
                (activationUrlRules.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (active.asKnown().isPresent) 1 else 0) +
                (if (bypassGlobalGroupLimit.asKnown().isPresent) 1 else 0) +
                (if (channelId.asKnown().isPresent) 1 else 0) +
                (if (dashboardUrl.asKnown().isPresent) 1 else 0) +
                (if (insertedAt.asKnown().isPresent) 1 else 0) +
                (if (key.asKnown().isPresent) 1 else 0) +
                (if (semver.asKnown().isPresent) 1 else 0) +
                (steps.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (type.asKnown().isPresent) 1 else 0) +
                (if (updatedAt.asKnown().isPresent) 1 else 0)

        class ActivationUrlPattern
        private constructor(
            private val directive: JsonField<String>,
            private val pathname: JsonField<String>,
            private val search: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("directive")
                @ExcludeMissing
                directive: JsonField<String> = JsonMissing.of(),
                @JsonProperty("pathname")
                @ExcludeMissing
                pathname: JsonField<String> = JsonMissing.of(),
                @JsonProperty("search") @ExcludeMissing search: JsonField<String> = JsonMissing.of(),
            ) : this(directive, pathname, search, mutableMapOf())

            /**
             * The directive for the URL pattern ('allow' or 'block')
             *
             * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun directive(): Optional<String> = directive.getOptional("directive")

            /**
             * The pathname pattern to match (supports wildcards like /\*)
             *
             * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun pathname(): Optional<String> = pathname.getOptional("pathname")

            /**
             * The search query params to match
             *
             * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun search(): Optional<String> = search.getOptional("search")

            /**
             * Returns the raw JSON value of [directive].
             *
             * Unlike [directive], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("directive")
            @ExcludeMissing
            fun _directive(): JsonField<String> = directive

            /**
             * Returns the raw JSON value of [pathname].
             *
             * Unlike [pathname], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("pathname") @ExcludeMissing fun _pathname(): JsonField<String> = pathname

            /**
             * Returns the raw JSON value of [search].
             *
             * Unlike [search], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("search") @ExcludeMissing fun _search(): JsonField<String> = search

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
                 * Returns a mutable builder for constructing an instance of [ActivationUrlPattern].
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ActivationUrlPattern]. */
            class Builder internal constructor() {

                private var directive: JsonField<String> = JsonMissing.of()
                private var pathname: JsonField<String> = JsonMissing.of()
                private var search: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(activationUrlPattern: ActivationUrlPattern) = apply {
                    directive = activationUrlPattern.directive
                    pathname = activationUrlPattern.pathname
                    search = activationUrlPattern.search
                    additionalProperties = activationUrlPattern.additionalProperties.toMutableMap()
                }

                /** The directive for the URL pattern ('allow' or 'block') */
                fun directive(directive: String) = directive(JsonField.of(directive))

                /**
                 * Sets [Builder.directive] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.directive] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun directive(directive: JsonField<String>) = apply { this.directive = directive }

                /** The pathname pattern to match (supports wildcards like /\*) */
                fun pathname(pathname: String) = pathname(JsonField.of(pathname))

                /**
                 * Sets [Builder.pathname] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.pathname] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun pathname(pathname: JsonField<String>) = apply { this.pathname = pathname }

                /** The search query params to match */
                fun search(search: String) = search(JsonField.of(search))

                /**
                 * Sets [Builder.search] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.search] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun search(search: JsonField<String>) = apply { this.search = search }

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
                 * Returns an immutable instance of [ActivationUrlPattern].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): ActivationUrlPattern =
                    ActivationUrlPattern(
                        directive,
                        pathname,
                        search,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): ActivationUrlPattern = apply {
                if (validated) {
                    return@apply
                }

                directive()
                pathname()
                search()
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
                (if (directive.asKnown().isPresent) 1 else 0) +
                    (if (pathname.asKnown().isPresent) 1 else 0) +
                    (if (search.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is ActivationUrlPattern && directive == other.directive && pathname == other.pathname && search == other.search && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(directive, pathname, search, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ActivationUrlPattern{directive=$directive, pathname=$pathname, search=$search, additionalProperties=$additionalProperties}"
        }

        class ActivationUrlRule
        private constructor(
            private val argument: JsonField<String>,
            private val directive: JsonField<String>,
            private val operator: JsonField<String>,
            private val variable: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("argument")
                @ExcludeMissing
                argument: JsonField<String> = JsonMissing.of(),
                @JsonProperty("directive")
                @ExcludeMissing
                directive: JsonField<String> = JsonMissing.of(),
                @JsonProperty("operator")
                @ExcludeMissing
                operator: JsonField<String> = JsonMissing.of(),
                @JsonProperty("variable")
                @ExcludeMissing
                variable: JsonField<String> = JsonMissing.of(),
            ) : this(argument, directive, operator, variable, mutableMapOf())

            /**
             * The value to compare against
             *
             * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun argument(): Optional<String> = argument.getOptional("argument")

            /**
             * The directive for the URL rule ('allow' or 'block')
             *
             * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun directive(): Optional<String> = directive.getOptional("directive")

            /**
             * The comparison operator ('contains' or 'equal_to')
             *
             * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun operator(): Optional<String> = operator.getOptional("operator")

            /**
             * The variable to evaluate ('pathname')
             *
             * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun variable(): Optional<String> = variable.getOptional("variable")

            /**
             * Returns the raw JSON value of [argument].
             *
             * Unlike [argument], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("argument") @ExcludeMissing fun _argument(): JsonField<String> = argument

            /**
             * Returns the raw JSON value of [directive].
             *
             * Unlike [directive], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("directive")
            @ExcludeMissing
            fun _directive(): JsonField<String> = directive

            /**
             * Returns the raw JSON value of [operator].
             *
             * Unlike [operator], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("operator") @ExcludeMissing fun _operator(): JsonField<String> = operator

            /**
             * Returns the raw JSON value of [variable].
             *
             * Unlike [variable], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("variable") @ExcludeMissing fun _variable(): JsonField<String> = variable

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
                 * Returns a mutable builder for constructing an instance of [ActivationUrlRule].
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ActivationUrlRule]. */
            class Builder internal constructor() {

                private var argument: JsonField<String> = JsonMissing.of()
                private var directive: JsonField<String> = JsonMissing.of()
                private var operator: JsonField<String> = JsonMissing.of()
                private var variable: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(activationUrlRule: ActivationUrlRule) = apply {
                    argument = activationUrlRule.argument
                    directive = activationUrlRule.directive
                    operator = activationUrlRule.operator
                    variable = activationUrlRule.variable
                    additionalProperties = activationUrlRule.additionalProperties.toMutableMap()
                }

                /** The value to compare against */
                fun argument(argument: String) = argument(JsonField.of(argument))

                /**
                 * Sets [Builder.argument] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.argument] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun argument(argument: JsonField<String>) = apply { this.argument = argument }

                /** The directive for the URL rule ('allow' or 'block') */
                fun directive(directive: String) = directive(JsonField.of(directive))

                /**
                 * Sets [Builder.directive] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.directive] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun directive(directive: JsonField<String>) = apply { this.directive = directive }

                /** The comparison operator ('contains' or 'equal_to') */
                fun operator(operator: String) = operator(JsonField.of(operator))

                /**
                 * Sets [Builder.operator] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.operator] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun operator(operator: JsonField<String>) = apply { this.operator = operator }

                /** The variable to evaluate ('pathname') */
                fun variable(variable: String) = variable(JsonField.of(variable))

                /**
                 * Sets [Builder.variable] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.variable] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun variable(variable: JsonField<String>) = apply { this.variable = variable }

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
                 * Returns an immutable instance of [ActivationUrlRule].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): ActivationUrlRule =
                    ActivationUrlRule(
                        argument,
                        directive,
                        operator,
                        variable,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): ActivationUrlRule = apply {
                if (validated) {
                    return@apply
                }

                argument()
                directive()
                operator()
                variable()
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
                (if (argument.asKnown().isPresent) 1 else 0) +
                    (if (directive.asKnown().isPresent) 1 else 0) +
                    (if (operator.asKnown().isPresent) 1 else 0) +
                    (if (variable.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is ActivationUrlRule && argument == other.argument && directive == other.directive && operator == other.operator && variable == other.variable && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(argument, directive, operator, variable, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ActivationUrlRule{argument=$argument, directive=$directive, operator=$operator, variable=$variable, additionalProperties=$additionalProperties}"
        }

        class Step
        private constructor(
            private val content: JsonField<Content>,
            private val message: JsonField<Message>,
            private val ref: JsonField<String>,
            private val schemaKey: JsonField<String>,
            private val schemaSemver: JsonField<String>,
            private val schemaVariantKey: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("content")
                @ExcludeMissing
                content: JsonField<Content> = JsonMissing.of(),
                @JsonProperty("message")
                @ExcludeMissing
                message: JsonField<Message> = JsonMissing.of(),
                @JsonProperty("ref") @ExcludeMissing ref: JsonField<String> = JsonMissing.of(),
                @JsonProperty("schema_key")
                @ExcludeMissing
                schemaKey: JsonField<String> = JsonMissing.of(),
                @JsonProperty("schema_semver")
                @ExcludeMissing
                schemaSemver: JsonField<String> = JsonMissing.of(),
                @JsonProperty("schema_variant_key")
                @ExcludeMissing
                schemaVariantKey: JsonField<String> = JsonMissing.of(),
            ) : this(
                content,
                message,
                ref,
                schemaKey,
                schemaSemver,
                schemaVariantKey,
                mutableMapOf(),
            )

            /**
             * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun content(): Optional<Content> = content.getOptional("content")

            /**
             * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun message(): Optional<Message> = message.getOptional("message")

            /**
             * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun ref(): Optional<String> = ref.getOptional("ref")

            /**
             * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun schemaKey(): Optional<String> = schemaKey.getOptional("schema_key")

            /**
             * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun schemaSemver(): Optional<String> = schemaSemver.getOptional("schema_semver")

            /**
             * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun schemaVariantKey(): Optional<String> =
                schemaVariantKey.getOptional("schema_variant_key")

            /**
             * Returns the raw JSON value of [content].
             *
             * Unlike [content], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("content") @ExcludeMissing fun _content(): JsonField<Content> = content

            /**
             * Returns the raw JSON value of [message].
             *
             * Unlike [message], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<Message> = message

            /**
             * Returns the raw JSON value of [ref].
             *
             * Unlike [ref], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("ref") @ExcludeMissing fun _ref(): JsonField<String> = ref

            /**
             * Returns the raw JSON value of [schemaKey].
             *
             * Unlike [schemaKey], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("schema_key")
            @ExcludeMissing
            fun _schemaKey(): JsonField<String> = schemaKey

            /**
             * Returns the raw JSON value of [schemaSemver].
             *
             * Unlike [schemaSemver], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("schema_semver")
            @ExcludeMissing
            fun _schemaSemver(): JsonField<String> = schemaSemver

            /**
             * Returns the raw JSON value of [schemaVariantKey].
             *
             * Unlike [schemaVariantKey], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("schema_variant_key")
            @ExcludeMissing
            fun _schemaVariantKey(): JsonField<String> = schemaVariantKey

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

                /** Returns a mutable builder for constructing an instance of [Step]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Step]. */
            class Builder internal constructor() {

                private var content: JsonField<Content> = JsonMissing.of()
                private var message: JsonField<Message> = JsonMissing.of()
                private var ref: JsonField<String> = JsonMissing.of()
                private var schemaKey: JsonField<String> = JsonMissing.of()
                private var schemaSemver: JsonField<String> = JsonMissing.of()
                private var schemaVariantKey: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(step: Step) = apply {
                    content = step.content
                    message = step.message
                    ref = step.ref
                    schemaKey = step.schemaKey
                    schemaSemver = step.schemaSemver
                    schemaVariantKey = step.schemaVariantKey
                    additionalProperties = step.additionalProperties.toMutableMap()
                }

                fun content(content: Content) = content(JsonField.of(content))

                /**
                 * Sets [Builder.content] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.content] with a well-typed [Content] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun content(content: JsonField<Content>) = apply { this.content = content }

                fun message(message: Message) = message(JsonField.of(message))

                /**
                 * Sets [Builder.message] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.message] with a well-typed [Message] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun message(message: JsonField<Message>) = apply { this.message = message }

                fun ref(ref: String) = ref(JsonField.of(ref))

                /**
                 * Sets [Builder.ref] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.ref] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun ref(ref: JsonField<String>) = apply { this.ref = ref }

                fun schemaKey(schemaKey: String) = schemaKey(JsonField.of(schemaKey))

                /**
                 * Sets [Builder.schemaKey] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.schemaKey] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun schemaKey(schemaKey: JsonField<String>) = apply { this.schemaKey = schemaKey }

                fun schemaSemver(schemaSemver: String) = schemaSemver(JsonField.of(schemaSemver))

                /**
                 * Sets [Builder.schemaSemver] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.schemaSemver] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun schemaSemver(schemaSemver: JsonField<String>) = apply {
                    this.schemaSemver = schemaSemver
                }

                fun schemaVariantKey(schemaVariantKey: String) =
                    schemaVariantKey(JsonField.of(schemaVariantKey))

                /**
                 * Sets [Builder.schemaVariantKey] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.schemaVariantKey] with a well-typed [String]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun schemaVariantKey(schemaVariantKey: JsonField<String>) = apply {
                    this.schemaVariantKey = schemaVariantKey
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
                 * Returns an immutable instance of [Step].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Step =
                    Step(
                        content,
                        message,
                        ref,
                        schemaKey,
                        schemaSemver,
                        schemaVariantKey,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Step = apply {
                if (validated) {
                    return@apply
                }

                content().ifPresent { it.validate() }
                message().ifPresent { it.validate() }
                ref()
                schemaKey()
                schemaSemver()
                schemaVariantKey()
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
                (content.asKnown().getOrNull()?.validity() ?: 0) +
                    (message.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (ref.asKnown().isPresent) 1 else 0) +
                    (if (schemaKey.asKnown().isPresent) 1 else 0) +
                    (if (schemaSemver.asKnown().isPresent) 1 else 0) +
                    (if (schemaVariantKey.asKnown().isPresent) 1 else 0)

            class Content
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

                    /** Returns a mutable builder for constructing an instance of [Content]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Content]. */
                class Builder internal constructor() {

                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(content: Content) = apply {
                        additionalProperties = content.additionalProperties.toMutableMap()
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
                     * Returns an immutable instance of [Content].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Content = Content(additionalProperties.toImmutable())
                }

                private var validated: Boolean = false

                fun validate(): Content = apply {
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
                    additionalProperties.count { (_, value) ->
                        !value.isNull() && !value.isMissing()
                    }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is Content && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() = "Content{additionalProperties=$additionalProperties}"
            }

            class Message
            private constructor(
                private val id: JsonField<String>,
                private val archivedAt: JsonField<OffsetDateTime>,
                private val interactedAt: JsonField<OffsetDateTime>,
                private val linkClickedAt: JsonField<OffsetDateTime>,
                private val readAt: JsonField<OffsetDateTime>,
                private val seenAt: JsonField<OffsetDateTime>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("archived_at")
                    @ExcludeMissing
                    archivedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
                    @JsonProperty("interacted_at")
                    @ExcludeMissing
                    interactedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
                    @JsonProperty("link_clicked_at")
                    @ExcludeMissing
                    linkClickedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
                    @JsonProperty("read_at")
                    @ExcludeMissing
                    readAt: JsonField<OffsetDateTime> = JsonMissing.of(),
                    @JsonProperty("seen_at")
                    @ExcludeMissing
                    seenAt: JsonField<OffsetDateTime> = JsonMissing.of(),
                ) : this(
                    id,
                    archivedAt,
                    interactedAt,
                    linkClickedAt,
                    readAt,
                    seenAt,
                    mutableMapOf(),
                )

                /**
                 * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun id(): Optional<String> = id.getOptional("id")

                /**
                 * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun archivedAt(): Optional<OffsetDateTime> = archivedAt.getOptional("archived_at")

                /**
                 * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun interactedAt(): Optional<OffsetDateTime> =
                    interactedAt.getOptional("interacted_at")

                /**
                 * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun linkClickedAt(): Optional<OffsetDateTime> =
                    linkClickedAt.getOptional("link_clicked_at")

                /**
                 * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun readAt(): Optional<OffsetDateTime> = readAt.getOptional("read_at")

                /**
                 * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun seenAt(): Optional<OffsetDateTime> = seenAt.getOptional("seen_at")

                /**
                 * Returns the raw JSON value of [id].
                 *
                 * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
                 */
                @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

                /**
                 * Returns the raw JSON value of [archivedAt].
                 *
                 * Unlike [archivedAt], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("archived_at")
                @ExcludeMissing
                fun _archivedAt(): JsonField<OffsetDateTime> = archivedAt

                /**
                 * Returns the raw JSON value of [interactedAt].
                 *
                 * Unlike [interactedAt], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("interacted_at")
                @ExcludeMissing
                fun _interactedAt(): JsonField<OffsetDateTime> = interactedAt

                /**
                 * Returns the raw JSON value of [linkClickedAt].
                 *
                 * Unlike [linkClickedAt], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("link_clicked_at")
                @ExcludeMissing
                fun _linkClickedAt(): JsonField<OffsetDateTime> = linkClickedAt

                /**
                 * Returns the raw JSON value of [readAt].
                 *
                 * Unlike [readAt], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("read_at")
                @ExcludeMissing
                fun _readAt(): JsonField<OffsetDateTime> = readAt

                /**
                 * Returns the raw JSON value of [seenAt].
                 *
                 * Unlike [seenAt], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("seen_at")
                @ExcludeMissing
                fun _seenAt(): JsonField<OffsetDateTime> = seenAt

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

                    /** Returns a mutable builder for constructing an instance of [Message]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Message]. */
                class Builder internal constructor() {

                    private var id: JsonField<String> = JsonMissing.of()
                    private var archivedAt: JsonField<OffsetDateTime> = JsonMissing.of()
                    private var interactedAt: JsonField<OffsetDateTime> = JsonMissing.of()
                    private var linkClickedAt: JsonField<OffsetDateTime> = JsonMissing.of()
                    private var readAt: JsonField<OffsetDateTime> = JsonMissing.of()
                    private var seenAt: JsonField<OffsetDateTime> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(message: Message) = apply {
                        id = message.id
                        archivedAt = message.archivedAt
                        interactedAt = message.interactedAt
                        linkClickedAt = message.linkClickedAt
                        readAt = message.readAt
                        seenAt = message.seenAt
                        additionalProperties = message.additionalProperties.toMutableMap()
                    }

                    fun id(id: String?) = id(JsonField.ofNullable(id))

                    /** Alias for calling [Builder.id] with `id.orElse(null)`. */
                    fun id(id: Optional<String>) = id(id.getOrNull())

                    /**
                     * Sets [Builder.id] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.id] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun id(id: JsonField<String>) = apply { this.id = id }

                    fun archivedAt(archivedAt: OffsetDateTime?) =
                        archivedAt(JsonField.ofNullable(archivedAt))

                    /** Alias for calling [Builder.archivedAt] with `archivedAt.orElse(null)`. */
                    fun archivedAt(archivedAt: Optional<OffsetDateTime>) =
                        archivedAt(archivedAt.getOrNull())

                    /**
                     * Sets [Builder.archivedAt] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.archivedAt] with a well-typed
                     * [OffsetDateTime] value instead. This method is primarily for setting the
                     * field to an undocumented or not yet supported value.
                     */
                    fun archivedAt(archivedAt: JsonField<OffsetDateTime>) = apply {
                        this.archivedAt = archivedAt
                    }

                    fun interactedAt(interactedAt: OffsetDateTime?) =
                        interactedAt(JsonField.ofNullable(interactedAt))

                    /**
                     * Alias for calling [Builder.interactedAt] with `interactedAt.orElse(null)`.
                     */
                    fun interactedAt(interactedAt: Optional<OffsetDateTime>) =
                        interactedAt(interactedAt.getOrNull())

                    /**
                     * Sets [Builder.interactedAt] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.interactedAt] with a well-typed
                     * [OffsetDateTime] value instead. This method is primarily for setting the
                     * field to an undocumented or not yet supported value.
                     */
                    fun interactedAt(interactedAt: JsonField<OffsetDateTime>) = apply {
                        this.interactedAt = interactedAt
                    }

                    fun linkClickedAt(linkClickedAt: OffsetDateTime?) =
                        linkClickedAt(JsonField.ofNullable(linkClickedAt))

                    /**
                     * Alias for calling [Builder.linkClickedAt] with `linkClickedAt.orElse(null)`.
                     */
                    fun linkClickedAt(linkClickedAt: Optional<OffsetDateTime>) =
                        linkClickedAt(linkClickedAt.getOrNull())

                    /**
                     * Sets [Builder.linkClickedAt] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.linkClickedAt] with a well-typed
                     * [OffsetDateTime] value instead. This method is primarily for setting the
                     * field to an undocumented or not yet supported value.
                     */
                    fun linkClickedAt(linkClickedAt: JsonField<OffsetDateTime>) = apply {
                        this.linkClickedAt = linkClickedAt
                    }

                    fun readAt(readAt: OffsetDateTime?) = readAt(JsonField.ofNullable(readAt))

                    /** Alias for calling [Builder.readAt] with `readAt.orElse(null)`. */
                    fun readAt(readAt: Optional<OffsetDateTime>) = readAt(readAt.getOrNull())

                    /**
                     * Sets [Builder.readAt] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.readAt] with a well-typed [OffsetDateTime]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun readAt(readAt: JsonField<OffsetDateTime>) = apply { this.readAt = readAt }

                    fun seenAt(seenAt: OffsetDateTime?) = seenAt(JsonField.ofNullable(seenAt))

                    /** Alias for calling [Builder.seenAt] with `seenAt.orElse(null)`. */
                    fun seenAt(seenAt: Optional<OffsetDateTime>) = seenAt(seenAt.getOrNull())

                    /**
                     * Sets [Builder.seenAt] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.seenAt] with a well-typed [OffsetDateTime]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun seenAt(seenAt: JsonField<OffsetDateTime>) = apply { this.seenAt = seenAt }

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
                     * Returns an immutable instance of [Message].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Message =
                        Message(
                            id,
                            archivedAt,
                            interactedAt,
                            linkClickedAt,
                            readAt,
                            seenAt,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): Message = apply {
                    if (validated) {
                        return@apply
                    }

                    id()
                    archivedAt()
                    interactedAt()
                    linkClickedAt()
                    readAt()
                    seenAt()
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
                        (if (archivedAt.asKnown().isPresent) 1 else 0) +
                        (if (interactedAt.asKnown().isPresent) 1 else 0) +
                        (if (linkClickedAt.asKnown().isPresent) 1 else 0) +
                        (if (readAt.asKnown().isPresent) 1 else 0) +
                        (if (seenAt.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is Message && id == other.id && archivedAt == other.archivedAt && interactedAt == other.interactedAt && linkClickedAt == other.linkClickedAt && readAt == other.readAt && seenAt == other.seenAt && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(id, archivedAt, interactedAt, linkClickedAt, readAt, seenAt, additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Message{id=$id, archivedAt=$archivedAt, interactedAt=$interactedAt, linkClickedAt=$linkClickedAt, readAt=$readAt, seenAt=$seenAt, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Step && content == other.content && message == other.message && ref == other.ref && schemaKey == other.schemaKey && schemaSemver == other.schemaSemver && schemaVariantKey == other.schemaVariantKey && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(content, message, ref, schemaKey, schemaSemver, schemaVariantKey, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Step{content=$content, message=$message, ref=$ref, schemaKey=$schemaKey, schemaSemver=$schemaSemver, schemaVariantKey=$schemaVariantKey, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Entry && id == other.id && _typename == other._typename && activationUrlPatterns == other.activationUrlPatterns && activationUrlRules == other.activationUrlRules && active == other.active && bypassGlobalGroupLimit == other.bypassGlobalGroupLimit && channelId == other.channelId && dashboardUrl == other.dashboardUrl && insertedAt == other.insertedAt && key == other.key && semver == other.semver && steps == other.steps && type == other.type && updatedAt == other.updatedAt && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(id, _typename, activationUrlPatterns, activationUrlRules, active, bypassGlobalGroupLimit, channelId, dashboardUrl, insertedAt, key, semver, steps, type, updatedAt, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Entry{id=$id, _typename=$_typename, activationUrlPatterns=$activationUrlPatterns, activationUrlRules=$activationUrlRules, active=$active, bypassGlobalGroupLimit=$bypassGlobalGroupLimit, channelId=$channelId, dashboardUrl=$dashboardUrl, insertedAt=$insertedAt, key=$key, semver=$semver, steps=$steps, type=$type, updatedAt=$updatedAt, additionalProperties=$additionalProperties}"
    }

    /** A map of guide group keys to their last display timestamps. */
    class GuideGroupDisplayLogs
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

            /**
             * Returns a mutable builder for constructing an instance of [GuideGroupDisplayLogs].
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [GuideGroupDisplayLogs]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(guideGroupDisplayLogs: GuideGroupDisplayLogs) = apply {
                additionalProperties = guideGroupDisplayLogs.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [GuideGroupDisplayLogs].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): GuideGroupDisplayLogs =
                GuideGroupDisplayLogs(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        fun validate(): GuideGroupDisplayLogs = apply {
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

            return /* spotless:off */ other is GuideGroupDisplayLogs && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "GuideGroupDisplayLogs{additionalProperties=$additionalProperties}"
    }

    class GuideGroup
    private constructor(
        private val _typename: JsonField<String>,
        private val displayInterval: JsonField<Long>,
        private val displaySequence: JsonField<List<String>>,
        private val insertedAt: JsonField<String>,
        private val key: JsonField<String>,
        private val updatedAt: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("__typename")
            @ExcludeMissing
            _typename: JsonField<String> = JsonMissing.of(),
            @JsonProperty("display_interval")
            @ExcludeMissing
            displayInterval: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("display_sequence")
            @ExcludeMissing
            displaySequence: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("inserted_at")
            @ExcludeMissing
            insertedAt: JsonField<String> = JsonMissing.of(),
            @JsonProperty("key") @ExcludeMissing key: JsonField<String> = JsonMissing.of(),
            @JsonProperty("updated_at")
            @ExcludeMissing
            updatedAt: JsonField<String> = JsonMissing.of(),
        ) : this(
            _typename,
            displayInterval,
            displaySequence,
            insertedAt,
            key,
            updatedAt,
            mutableMapOf(),
        )

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun _typename(): Optional<String> = _typename.getOptional("__typename")

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun displayInterval(): Optional<Long> = displayInterval.getOptional("display_interval")

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun displaySequence(): Optional<List<String>> =
            displaySequence.getOptional("display_sequence")

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun insertedAt(): Optional<String> = insertedAt.getOptional("inserted_at")

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun key(): Optional<String> = key.getOptional("key")

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun updatedAt(): Optional<String> = updatedAt.getOptional("updated_at")

        /**
         * Returns the raw JSON value of [_typename].
         *
         * Unlike [_typename], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("__typename") @ExcludeMissing fun __typename(): JsonField<String> = _typename

        /**
         * Returns the raw JSON value of [displayInterval].
         *
         * Unlike [displayInterval], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("display_interval")
        @ExcludeMissing
        fun _displayInterval(): JsonField<Long> = displayInterval

        /**
         * Returns the raw JSON value of [displaySequence].
         *
         * Unlike [displaySequence], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("display_sequence")
        @ExcludeMissing
        fun _displaySequence(): JsonField<List<String>> = displaySequence

        /**
         * Returns the raw JSON value of [insertedAt].
         *
         * Unlike [insertedAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("inserted_at")
        @ExcludeMissing
        fun _insertedAt(): JsonField<String> = insertedAt

        /**
         * Returns the raw JSON value of [key].
         *
         * Unlike [key], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("key") @ExcludeMissing fun _key(): JsonField<String> = key

        /**
         * Returns the raw JSON value of [updatedAt].
         *
         * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("updated_at") @ExcludeMissing fun _updatedAt(): JsonField<String> = updatedAt

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

            /** Returns a mutable builder for constructing an instance of [GuideGroup]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [GuideGroup]. */
        class Builder internal constructor() {

            private var _typename: JsonField<String> = JsonMissing.of()
            private var displayInterval: JsonField<Long> = JsonMissing.of()
            private var displaySequence: JsonField<MutableList<String>>? = null
            private var insertedAt: JsonField<String> = JsonMissing.of()
            private var key: JsonField<String> = JsonMissing.of()
            private var updatedAt: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(guideGroup: GuideGroup) = apply {
                _typename = guideGroup._typename
                displayInterval = guideGroup.displayInterval
                displaySequence = guideGroup.displaySequence.map { it.toMutableList() }
                insertedAt = guideGroup.insertedAt
                key = guideGroup.key
                updatedAt = guideGroup.updatedAt
                additionalProperties = guideGroup.additionalProperties.toMutableMap()
            }

            fun _typename(_typename: String) = _typename(JsonField.of(_typename))

            /**
             * Sets [Builder._typename] to an arbitrary JSON value.
             *
             * You should usually call [Builder._typename] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun _typename(_typename: JsonField<String>) = apply { this._typename = _typename }

            fun displayInterval(displayInterval: Long?) =
                displayInterval(JsonField.ofNullable(displayInterval))

            /**
             * Alias for [Builder.displayInterval].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun displayInterval(displayInterval: Long) = displayInterval(displayInterval as Long?)

            /** Alias for calling [Builder.displayInterval] with `displayInterval.orElse(null)`. */
            fun displayInterval(displayInterval: Optional<Long>) =
                displayInterval(displayInterval.getOrNull())

            /**
             * Sets [Builder.displayInterval] to an arbitrary JSON value.
             *
             * You should usually call [Builder.displayInterval] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun displayInterval(displayInterval: JsonField<Long>) = apply {
                this.displayInterval = displayInterval
            }

            fun displaySequence(displaySequence: List<String>) =
                displaySequence(JsonField.of(displaySequence))

            /**
             * Sets [Builder.displaySequence] to an arbitrary JSON value.
             *
             * You should usually call [Builder.displaySequence] with a well-typed `List<String>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun displaySequence(displaySequence: JsonField<List<String>>) = apply {
                this.displaySequence = displaySequence.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [displaySequence].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addDisplaySequence(displaySequence: String) = apply {
                this.displaySequence =
                    (this.displaySequence ?: JsonField.of(mutableListOf())).also {
                        checkKnown("display_sequence", it).add(displaySequence)
                    }
            }

            fun insertedAt(insertedAt: String) = insertedAt(JsonField.of(insertedAt))

            /**
             * Sets [Builder.insertedAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.insertedAt] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun insertedAt(insertedAt: JsonField<String>) = apply { this.insertedAt = insertedAt }

            fun key(key: String) = key(JsonField.of(key))

            /**
             * Sets [Builder.key] to an arbitrary JSON value.
             *
             * You should usually call [Builder.key] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun key(key: JsonField<String>) = apply { this.key = key }

            fun updatedAt(updatedAt: String) = updatedAt(JsonField.of(updatedAt))

            /**
             * Sets [Builder.updatedAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.updatedAt] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun updatedAt(updatedAt: JsonField<String>) = apply { this.updatedAt = updatedAt }

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
             * Returns an immutable instance of [GuideGroup].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): GuideGroup =
                GuideGroup(
                    _typename,
                    displayInterval,
                    (displaySequence ?: JsonMissing.of()).map { it.toImmutable() },
                    insertedAt,
                    key,
                    updatedAt,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): GuideGroup = apply {
            if (validated) {
                return@apply
            }

            _typename()
            displayInterval()
            displaySequence()
            insertedAt()
            key()
            updatedAt()
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
            (if (_typename.asKnown().isPresent) 1 else 0) +
                (if (displayInterval.asKnown().isPresent) 1 else 0) +
                (displaySequence.asKnown().getOrNull()?.size ?: 0) +
                (if (insertedAt.asKnown().isPresent) 1 else 0) +
                (if (key.asKnown().isPresent) 1 else 0) +
                (if (updatedAt.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is GuideGroup && _typename == other._typename && displayInterval == other.displayInterval && displaySequence == other.displaySequence && insertedAt == other.insertedAt && key == other.key && updatedAt == other.updatedAt && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(_typename, displayInterval, displaySequence, insertedAt, key, updatedAt, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "GuideGroup{_typename=$_typename, displayInterval=$displayInterval, displaySequence=$displaySequence, insertedAt=$insertedAt, key=$key, updatedAt=$updatedAt, additionalProperties=$additionalProperties}"
    }

    class IneligibleGuide
    private constructor(
        private val key: JsonField<String>,
        private val message: JsonField<String>,
        private val reason: JsonField<Reason>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("key") @ExcludeMissing key: JsonField<String> = JsonMissing.of(),
            @JsonProperty("message") @ExcludeMissing message: JsonField<String> = JsonMissing.of(),
            @JsonProperty("reason") @ExcludeMissing reason: JsonField<Reason> = JsonMissing.of(),
        ) : this(key, message, reason, mutableMapOf())

        /**
         * The guide's key identifier
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun key(): String = key.getRequired("key")

        /**
         * Human-readable explanation of ineligibility
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun message(): String = message.getRequired("message")

        /**
         * Reason code for ineligibility
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun reason(): Reason = reason.getRequired("reason")

        /**
         * Returns the raw JSON value of [key].
         *
         * Unlike [key], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("key") @ExcludeMissing fun _key(): JsonField<String> = key

        /**
         * Returns the raw JSON value of [message].
         *
         * Unlike [message], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<String> = message

        /**
         * Returns the raw JSON value of [reason].
         *
         * Unlike [reason], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<Reason> = reason

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
             * Returns a mutable builder for constructing an instance of [IneligibleGuide].
             *
             * The following fields are required:
             * ```java
             * .key()
             * .message()
             * .reason()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [IneligibleGuide]. */
        class Builder internal constructor() {

            private var key: JsonField<String>? = null
            private var message: JsonField<String>? = null
            private var reason: JsonField<Reason>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(ineligibleGuide: IneligibleGuide) = apply {
                key = ineligibleGuide.key
                message = ineligibleGuide.message
                reason = ineligibleGuide.reason
                additionalProperties = ineligibleGuide.additionalProperties.toMutableMap()
            }

            /** The guide's key identifier */
            fun key(key: String) = key(JsonField.of(key))

            /**
             * Sets [Builder.key] to an arbitrary JSON value.
             *
             * You should usually call [Builder.key] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun key(key: JsonField<String>) = apply { this.key = key }

            /** Human-readable explanation of ineligibility */
            fun message(message: String) = message(JsonField.of(message))

            /**
             * Sets [Builder.message] to an arbitrary JSON value.
             *
             * You should usually call [Builder.message] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun message(message: JsonField<String>) = apply { this.message = message }

            /** Reason code for ineligibility */
            fun reason(reason: Reason) = reason(JsonField.of(reason))

            /**
             * Sets [Builder.reason] to an arbitrary JSON value.
             *
             * You should usually call [Builder.reason] with a well-typed [Reason] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun reason(reason: JsonField<Reason>) = apply { this.reason = reason }

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
             * Returns an immutable instance of [IneligibleGuide].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .key()
             * .message()
             * .reason()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): IneligibleGuide =
                IneligibleGuide(
                    checkRequired("key", key),
                    checkRequired("message", message),
                    checkRequired("reason", reason),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): IneligibleGuide = apply {
            if (validated) {
                return@apply
            }

            key()
            message()
            reason().validate()
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
            (if (key.asKnown().isPresent) 1 else 0) +
                (if (message.asKnown().isPresent) 1 else 0) +
                (reason.asKnown().getOrNull()?.validity() ?: 0)

        /** Reason code for ineligibility */
        class Reason @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val GUIDE_NOT_ACTIVE = of("guide_not_active")

                @JvmField val MARKED_AS_ARCHIVED = of("marked_as_archived")

                @JvmField val TARGET_CONDITIONS_NOT_MET = of("target_conditions_not_met")

                @JvmField val NOT_IN_TARGET_AUDIENCE = of("not_in_target_audience")

                @JvmStatic fun of(value: String) = Reason(JsonField.of(value))
            }

            /** An enum containing [Reason]'s known values. */
            enum class Known {
                GUIDE_NOT_ACTIVE,
                MARKED_AS_ARCHIVED,
                TARGET_CONDITIONS_NOT_MET,
                NOT_IN_TARGET_AUDIENCE,
            }

            /**
             * An enum containing [Reason]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Reason] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                GUIDE_NOT_ACTIVE,
                MARKED_AS_ARCHIVED,
                TARGET_CONDITIONS_NOT_MET,
                NOT_IN_TARGET_AUDIENCE,
                /**
                 * An enum member indicating that [Reason] was instantiated with an unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    GUIDE_NOT_ACTIVE -> Value.GUIDE_NOT_ACTIVE
                    MARKED_AS_ARCHIVED -> Value.MARKED_AS_ARCHIVED
                    TARGET_CONDITIONS_NOT_MET -> Value.TARGET_CONDITIONS_NOT_MET
                    NOT_IN_TARGET_AUDIENCE -> Value.NOT_IN_TARGET_AUDIENCE
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws KnockInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    GUIDE_NOT_ACTIVE -> Known.GUIDE_NOT_ACTIVE
                    MARKED_AS_ARCHIVED -> Known.MARKED_AS_ARCHIVED
                    TARGET_CONDITIONS_NOT_MET -> Known.TARGET_CONDITIONS_NOT_MET
                    NOT_IN_TARGET_AUDIENCE -> Known.NOT_IN_TARGET_AUDIENCE
                    else -> throw KnockInvalidDataException("Unknown Reason: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws KnockInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    KnockInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            fun validate(): Reason = apply {
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

                return /* spotless:off */ other is Reason && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is IneligibleGuide && key == other.key && message == other.message && reason == other.reason && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(key, message, reason, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "IneligibleGuide{key=$key, message=$message, reason=$reason, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is GuideGetChannelResponse && entries == other.entries && guideGroupDisplayLogs == other.guideGroupDisplayLogs && guideGroups == other.guideGroups && ineligibleGuides == other.ineligibleGuides && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(entries, guideGroupDisplayLogs, guideGroups, ineligibleGuides, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "GuideGetChannelResponse{entries=$entries, guideGroupDisplayLogs=$guideGroupDisplayLogs, guideGroups=$guideGroups, ineligibleGuides=$ineligibleGuides, additionalProperties=$additionalProperties}"
}
