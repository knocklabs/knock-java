// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users.feeds

import app.knock.api.core.BaseDeserializer
import app.knock.api.core.BaseSerializer
import app.knock.api.core.Enum
import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.checkKnown
import app.knock.api.core.checkRequired
import app.knock.api.core.getOrThrow
import app.knock.api.core.toImmutable
import app.knock.api.errors.KnockInvalidDataException
import app.knock.api.models.messages.Activity
import app.knock.api.models.objects.Object
import app.knock.api.models.recipients.Recipient
import app.knock.api.models.users.User
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

/** An in-app feed message in a user's feed */
class FeedListItemsResponse
private constructor(
    private val id: JsonField<String>,
    private val _typename: JsonField<String>,
    private val activities: JsonField<List<Activity>>,
    private val actors: JsonField<List<Recipient>>,
    private val blocks: JsonField<List<Block>>,
    private val data: JsonField<Data>,
    private val insertedAt: JsonField<String>,
    private val source: JsonField<Source>,
    private val tenant: JsonField<String>,
    private val totalActivities: JsonField<Long>,
    private val totalActors: JsonField<Long>,
    private val updatedAt: JsonField<String>,
    private val archivedAt: JsonField<String>,
    private val clickedAt: JsonField<String>,
    private val interactedAt: JsonField<String>,
    private val linkClickedAt: JsonField<String>,
    private val readAt: JsonField<String>,
    private val seenAt: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("__typename") @ExcludeMissing _typename: JsonField<String> = JsonMissing.of(),
        @JsonProperty("activities")
        @ExcludeMissing
        activities: JsonField<List<Activity>> = JsonMissing.of(),
        @JsonProperty("actors")
        @ExcludeMissing
        actors: JsonField<List<Recipient>> = JsonMissing.of(),
        @JsonProperty("blocks") @ExcludeMissing blocks: JsonField<List<Block>> = JsonMissing.of(),
        @JsonProperty("data") @ExcludeMissing data: JsonField<Data> = JsonMissing.of(),
        @JsonProperty("inserted_at")
        @ExcludeMissing
        insertedAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("source") @ExcludeMissing source: JsonField<Source> = JsonMissing.of(),
        @JsonProperty("tenant") @ExcludeMissing tenant: JsonField<String> = JsonMissing.of(),
        @JsonProperty("total_activities")
        @ExcludeMissing
        totalActivities: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("total_actors")
        @ExcludeMissing
        totalActors: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("updated_at") @ExcludeMissing updatedAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("archived_at")
        @ExcludeMissing
        archivedAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("clicked_at") @ExcludeMissing clickedAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("interacted_at")
        @ExcludeMissing
        interactedAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("link_clicked_at")
        @ExcludeMissing
        linkClickedAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("read_at") @ExcludeMissing readAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("seen_at") @ExcludeMissing seenAt: JsonField<String> = JsonMissing.of(),
    ) : this(
        id,
        _typename,
        activities,
        actors,
        blocks,
        data,
        insertedAt,
        source,
        tenant,
        totalActivities,
        totalActors,
        updatedAt,
        archivedAt,
        clickedAt,
        interactedAt,
        linkClickedAt,
        readAt,
        seenAt,
        mutableMapOf(),
    )

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun _typename(): String = _typename.getRequired("__typename")

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun activities(): List<Activity> = activities.getRequired("activities")

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun actors(): List<Recipient> = actors.getRequired("actors")

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun blocks(): List<Block> = blocks.getRequired("blocks")

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun data(): Optional<Data> = Optional.ofNullable(data.getNullable("data"))

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun insertedAt(): String = insertedAt.getRequired("inserted_at")

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun source(): Source = source.getRequired("source")

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun tenant(): Optional<String> = Optional.ofNullable(tenant.getNullable("tenant"))

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun totalActivities(): Long = totalActivities.getRequired("total_activities")

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun totalActors(): Long = totalActors.getRequired("total_actors")

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun updatedAt(): String = updatedAt.getRequired("updated_at")

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun archivedAt(): Optional<String> = Optional.ofNullable(archivedAt.getNullable("archived_at"))

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun clickedAt(): Optional<String> = Optional.ofNullable(clickedAt.getNullable("clicked_at"))

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun interactedAt(): Optional<String> =
        Optional.ofNullable(interactedAt.getNullable("interacted_at"))

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun linkClickedAt(): Optional<String> =
        Optional.ofNullable(linkClickedAt.getNullable("link_clicked_at"))

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun readAt(): Optional<String> = Optional.ofNullable(readAt.getNullable("read_at"))

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun seenAt(): Optional<String> = Optional.ofNullable(seenAt.getNullable("seen_at"))

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
     * Returns the raw JSON value of [activities].
     *
     * Unlike [activities], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("activities")
    @ExcludeMissing
    fun _activities(): JsonField<List<Activity>> = activities

    /**
     * Returns the raw JSON value of [actors].
     *
     * Unlike [actors], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("actors") @ExcludeMissing fun _actors(): JsonField<List<Recipient>> = actors

    /**
     * Returns the raw JSON value of [blocks].
     *
     * Unlike [blocks], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("blocks") @ExcludeMissing fun _blocks(): JsonField<List<Block>> = blocks

    /**
     * Returns the raw JSON value of [data].
     *
     * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Data> = data

    /**
     * Returns the raw JSON value of [insertedAt].
     *
     * Unlike [insertedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("inserted_at") @ExcludeMissing fun _insertedAt(): JsonField<String> = insertedAt

    /**
     * Returns the raw JSON value of [source].
     *
     * Unlike [source], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("source") @ExcludeMissing fun _source(): JsonField<Source> = source

    /**
     * Returns the raw JSON value of [tenant].
     *
     * Unlike [tenant], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tenant") @ExcludeMissing fun _tenant(): JsonField<String> = tenant

    /**
     * Returns the raw JSON value of [totalActivities].
     *
     * Unlike [totalActivities], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("total_activities")
    @ExcludeMissing
    fun _totalActivities(): JsonField<Long> = totalActivities

    /**
     * Returns the raw JSON value of [totalActors].
     *
     * Unlike [totalActors], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("total_actors") @ExcludeMissing fun _totalActors(): JsonField<Long> = totalActors

    /**
     * Returns the raw JSON value of [updatedAt].
     *
     * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("updated_at") @ExcludeMissing fun _updatedAt(): JsonField<String> = updatedAt

    /**
     * Returns the raw JSON value of [archivedAt].
     *
     * Unlike [archivedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("archived_at") @ExcludeMissing fun _archivedAt(): JsonField<String> = archivedAt

    /**
     * Returns the raw JSON value of [clickedAt].
     *
     * Unlike [clickedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("clicked_at") @ExcludeMissing fun _clickedAt(): JsonField<String> = clickedAt

    /**
     * Returns the raw JSON value of [interactedAt].
     *
     * Unlike [interactedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("interacted_at")
    @ExcludeMissing
    fun _interactedAt(): JsonField<String> = interactedAt

    /**
     * Returns the raw JSON value of [linkClickedAt].
     *
     * Unlike [linkClickedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("link_clicked_at")
    @ExcludeMissing
    fun _linkClickedAt(): JsonField<String> = linkClickedAt

    /**
     * Returns the raw JSON value of [readAt].
     *
     * Unlike [readAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("read_at") @ExcludeMissing fun _readAt(): JsonField<String> = readAt

    /**
     * Returns the raw JSON value of [seenAt].
     *
     * Unlike [seenAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("seen_at") @ExcludeMissing fun _seenAt(): JsonField<String> = seenAt

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
         * Returns a mutable builder for constructing an instance of [FeedListItemsResponse].
         *
         * The following fields are required:
         * ```java
         * .id()
         * ._typename()
         * .activities()
         * .actors()
         * .blocks()
         * .data()
         * .insertedAt()
         * .source()
         * .tenant()
         * .totalActivities()
         * .totalActors()
         * .updatedAt()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FeedListItemsResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var _typename: JsonField<String>? = null
        private var activities: JsonField<MutableList<Activity>>? = null
        private var actors: JsonField<MutableList<Recipient>>? = null
        private var blocks: JsonField<MutableList<Block>>? = null
        private var data: JsonField<Data>? = null
        private var insertedAt: JsonField<String>? = null
        private var source: JsonField<Source>? = null
        private var tenant: JsonField<String>? = null
        private var totalActivities: JsonField<Long>? = null
        private var totalActors: JsonField<Long>? = null
        private var updatedAt: JsonField<String>? = null
        private var archivedAt: JsonField<String> = JsonMissing.of()
        private var clickedAt: JsonField<String> = JsonMissing.of()
        private var interactedAt: JsonField<String> = JsonMissing.of()
        private var linkClickedAt: JsonField<String> = JsonMissing.of()
        private var readAt: JsonField<String> = JsonMissing.of()
        private var seenAt: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(feedListItemsResponse: FeedListItemsResponse) = apply {
            id = feedListItemsResponse.id
            _typename = feedListItemsResponse._typename
            activities = feedListItemsResponse.activities.map { it.toMutableList() }
            actors = feedListItemsResponse.actors.map { it.toMutableList() }
            blocks = feedListItemsResponse.blocks.map { it.toMutableList() }
            data = feedListItemsResponse.data
            insertedAt = feedListItemsResponse.insertedAt
            source = feedListItemsResponse.source
            tenant = feedListItemsResponse.tenant
            totalActivities = feedListItemsResponse.totalActivities
            totalActors = feedListItemsResponse.totalActors
            updatedAt = feedListItemsResponse.updatedAt
            archivedAt = feedListItemsResponse.archivedAt
            clickedAt = feedListItemsResponse.clickedAt
            interactedAt = feedListItemsResponse.interactedAt
            linkClickedAt = feedListItemsResponse.linkClickedAt
            readAt = feedListItemsResponse.readAt
            seenAt = feedListItemsResponse.seenAt
            additionalProperties = feedListItemsResponse.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        fun _typename(_typename: String) = _typename(JsonField.of(_typename))

        /**
         * Sets [Builder._typename] to an arbitrary JSON value.
         *
         * You should usually call [Builder._typename] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun _typename(_typename: JsonField<String>) = apply { this._typename = _typename }

        fun activities(activities: List<Activity>) = activities(JsonField.of(activities))

        /**
         * Sets [Builder.activities] to an arbitrary JSON value.
         *
         * You should usually call [Builder.activities] with a well-typed `List<Activity>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun activities(activities: JsonField<List<Activity>>) = apply {
            this.activities = activities.map { it.toMutableList() }
        }

        /**
         * Adds a single [Activity] to [activities].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addActivity(activity: Activity) = apply {
            activities =
                (activities ?: JsonField.of(mutableListOf())).also {
                    checkKnown("activities", it).add(activity)
                }
        }

        fun actors(actors: List<Recipient>) = actors(JsonField.of(actors))

        /**
         * Sets [Builder.actors] to an arbitrary JSON value.
         *
         * You should usually call [Builder.actors] with a well-typed `List<Recipient>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun actors(actors: JsonField<List<Recipient>>) = apply {
            this.actors = actors.map { it.toMutableList() }
        }

        /**
         * Adds a single [Recipient] to [actors].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addActor(actor: Recipient) = apply {
            actors =
                (actors ?: JsonField.of(mutableListOf())).also {
                    checkKnown("actors", it).add(actor)
                }
        }

        /** Alias for calling [addActor] with `Recipient.ofUser(user)`. */
        fun addActor(user: User) = addActor(Recipient.ofUser(user))

        /** Alias for calling [addActor] with `Recipient.ofObject(object_)`. */
        fun addActor(object_: Object) = addActor(Recipient.ofObject(object_))

        fun blocks(blocks: List<Block>) = blocks(JsonField.of(blocks))

        /**
         * Sets [Builder.blocks] to an arbitrary JSON value.
         *
         * You should usually call [Builder.blocks] with a well-typed `List<Block>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun blocks(blocks: JsonField<List<Block>>) = apply {
            this.blocks = blocks.map { it.toMutableList() }
        }

        /**
         * Adds a single [Block] to [blocks].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addBlock(block: Block) = apply {
            blocks =
                (blocks ?: JsonField.of(mutableListOf())).also {
                    checkKnown("blocks", it).add(block)
                }
        }

        /**
         * Alias for calling [addBlock] with
         * `Block.ofMessageInAppFeedContent(messageInAppFeedContent)`.
         */
        fun addBlock(messageInAppFeedContent: Block.MessageInAppFeedContentBlock) =
            addBlock(Block.ofMessageInAppFeedContent(messageInAppFeedContent))

        /**
         * Alias for calling [addBlock] with
         * `Block.ofMessageInAppFeedButtonSet(messageInAppFeedButtonSet)`.
         */
        fun addBlock(messageInAppFeedButtonSet: Block.MessageInAppFeedButtonSetBlock) =
            addBlock(Block.ofMessageInAppFeedButtonSet(messageInAppFeedButtonSet))

        fun data(data: Data?) = data(JsonField.ofNullable(data))

        /** Alias for calling [Builder.data] with `data.orElse(null)`. */
        fun data(data: Optional<Data>) = data(data.getOrNull())

        /**
         * Sets [Builder.data] to an arbitrary JSON value.
         *
         * You should usually call [Builder.data] with a well-typed [Data] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun data(data: JsonField<Data>) = apply { this.data = data }

        fun insertedAt(insertedAt: String) = insertedAt(JsonField.of(insertedAt))

        /**
         * Sets [Builder.insertedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.insertedAt] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun insertedAt(insertedAt: JsonField<String>) = apply { this.insertedAt = insertedAt }

        fun source(source: Source) = source(JsonField.of(source))

        /**
         * Sets [Builder.source] to an arbitrary JSON value.
         *
         * You should usually call [Builder.source] with a well-typed [Source] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun source(source: JsonField<Source>) = apply { this.source = source }

        fun tenant(tenant: String?) = tenant(JsonField.ofNullable(tenant))

        /** Alias for calling [Builder.tenant] with `tenant.orElse(null)`. */
        fun tenant(tenant: Optional<String>) = tenant(tenant.getOrNull())

        /**
         * Sets [Builder.tenant] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tenant] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun tenant(tenant: JsonField<String>) = apply { this.tenant = tenant }

        fun totalActivities(totalActivities: Long) = totalActivities(JsonField.of(totalActivities))

        /**
         * Sets [Builder.totalActivities] to an arbitrary JSON value.
         *
         * You should usually call [Builder.totalActivities] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun totalActivities(totalActivities: JsonField<Long>) = apply {
            this.totalActivities = totalActivities
        }

        fun totalActors(totalActors: Long) = totalActors(JsonField.of(totalActors))

        /**
         * Sets [Builder.totalActors] to an arbitrary JSON value.
         *
         * You should usually call [Builder.totalActors] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun totalActors(totalActors: JsonField<Long>) = apply { this.totalActors = totalActors }

        fun updatedAt(updatedAt: String) = updatedAt(JsonField.of(updatedAt))

        /**
         * Sets [Builder.updatedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.updatedAt] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun updatedAt(updatedAt: JsonField<String>) = apply { this.updatedAt = updatedAt }

        fun archivedAt(archivedAt: String?) = archivedAt(JsonField.ofNullable(archivedAt))

        /** Alias for calling [Builder.archivedAt] with `archivedAt.orElse(null)`. */
        fun archivedAt(archivedAt: Optional<String>) = archivedAt(archivedAt.getOrNull())

        /**
         * Sets [Builder.archivedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.archivedAt] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun archivedAt(archivedAt: JsonField<String>) = apply { this.archivedAt = archivedAt }

        fun clickedAt(clickedAt: String?) = clickedAt(JsonField.ofNullable(clickedAt))

        /** Alias for calling [Builder.clickedAt] with `clickedAt.orElse(null)`. */
        fun clickedAt(clickedAt: Optional<String>) = clickedAt(clickedAt.getOrNull())

        /**
         * Sets [Builder.clickedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.clickedAt] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun clickedAt(clickedAt: JsonField<String>) = apply { this.clickedAt = clickedAt }

        fun interactedAt(interactedAt: String?) = interactedAt(JsonField.ofNullable(interactedAt))

        /** Alias for calling [Builder.interactedAt] with `interactedAt.orElse(null)`. */
        fun interactedAt(interactedAt: Optional<String>) = interactedAt(interactedAt.getOrNull())

        /**
         * Sets [Builder.interactedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.interactedAt] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun interactedAt(interactedAt: JsonField<String>) = apply {
            this.interactedAt = interactedAt
        }

        fun linkClickedAt(linkClickedAt: String?) =
            linkClickedAt(JsonField.ofNullable(linkClickedAt))

        /** Alias for calling [Builder.linkClickedAt] with `linkClickedAt.orElse(null)`. */
        fun linkClickedAt(linkClickedAt: Optional<String>) =
            linkClickedAt(linkClickedAt.getOrNull())

        /**
         * Sets [Builder.linkClickedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.linkClickedAt] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun linkClickedAt(linkClickedAt: JsonField<String>) = apply {
            this.linkClickedAt = linkClickedAt
        }

        fun readAt(readAt: String?) = readAt(JsonField.ofNullable(readAt))

        /** Alias for calling [Builder.readAt] with `readAt.orElse(null)`. */
        fun readAt(readAt: Optional<String>) = readAt(readAt.getOrNull())

        /**
         * Sets [Builder.readAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.readAt] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun readAt(readAt: JsonField<String>) = apply { this.readAt = readAt }

        fun seenAt(seenAt: String?) = seenAt(JsonField.ofNullable(seenAt))

        /** Alias for calling [Builder.seenAt] with `seenAt.orElse(null)`. */
        fun seenAt(seenAt: Optional<String>) = seenAt(seenAt.getOrNull())

        /**
         * Sets [Builder.seenAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.seenAt] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun seenAt(seenAt: JsonField<String>) = apply { this.seenAt = seenAt }

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
         * Returns an immutable instance of [FeedListItemsResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * ._typename()
         * .activities()
         * .actors()
         * .blocks()
         * .data()
         * .insertedAt()
         * .source()
         * .tenant()
         * .totalActivities()
         * .totalActors()
         * .updatedAt()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FeedListItemsResponse =
            FeedListItemsResponse(
                checkRequired("id", id),
                checkRequired("_typename", _typename),
                checkRequired("activities", activities).map { it.toImmutable() },
                checkRequired("actors", actors).map { it.toImmutable() },
                checkRequired("blocks", blocks).map { it.toImmutable() },
                checkRequired("data", data),
                checkRequired("insertedAt", insertedAt),
                checkRequired("source", source),
                checkRequired("tenant", tenant),
                checkRequired("totalActivities", totalActivities),
                checkRequired("totalActors", totalActors),
                checkRequired("updatedAt", updatedAt),
                archivedAt,
                clickedAt,
                interactedAt,
                linkClickedAt,
                readAt,
                seenAt,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): FeedListItemsResponse = apply {
        if (validated) {
            return@apply
        }

        id()
        _typename()
        activities().forEach { it.validate() }
        actors().forEach { it.validate() }
        blocks().forEach { it.validate() }
        data().ifPresent { it.validate() }
        insertedAt()
        source().validate()
        tenant()
        totalActivities()
        totalActors()
        updatedAt()
        archivedAt()
        clickedAt()
        interactedAt()
        linkClickedAt()
        readAt()
        seenAt()
        validated = true
    }

    /** A content (text or markdown) block in a message in an app feed */
    @JsonDeserialize(using = Block.Deserializer::class)
    @JsonSerialize(using = Block.Serializer::class)
    class Block
    private constructor(
        private val messageInAppFeedContent: MessageInAppFeedContentBlock? = null,
        private val messageInAppFeedButtonSet: MessageInAppFeedButtonSetBlock? = null,
        private val _json: JsonValue? = null,
    ) {

        /** A content (text or markdown) block in a message in an app feed */
        fun messageInAppFeedContent(): Optional<MessageInAppFeedContentBlock> =
            Optional.ofNullable(messageInAppFeedContent)

        /** A set of buttons in a message in an app feed */
        fun messageInAppFeedButtonSet(): Optional<MessageInAppFeedButtonSetBlock> =
            Optional.ofNullable(messageInAppFeedButtonSet)

        fun isMessageInAppFeedContent(): Boolean = messageInAppFeedContent != null

        fun isMessageInAppFeedButtonSet(): Boolean = messageInAppFeedButtonSet != null

        /** A content (text or markdown) block in a message in an app feed */
        fun asMessageInAppFeedContent(): MessageInAppFeedContentBlock =
            messageInAppFeedContent.getOrThrow("messageInAppFeedContent")

        /** A set of buttons in a message in an app feed */
        fun asMessageInAppFeedButtonSet(): MessageInAppFeedButtonSetBlock =
            messageInAppFeedButtonSet.getOrThrow("messageInAppFeedButtonSet")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                messageInAppFeedContent != null ->
                    visitor.visitMessageInAppFeedContent(messageInAppFeedContent)
                messageInAppFeedButtonSet != null ->
                    visitor.visitMessageInAppFeedButtonSet(messageInAppFeedButtonSet)
                else -> visitor.unknown(_json)
            }
        }

        private var validated: Boolean = false

        fun validate(): Block = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitMessageInAppFeedContent(
                        messageInAppFeedContent: MessageInAppFeedContentBlock
                    ) {
                        messageInAppFeedContent.validate()
                    }

                    override fun visitMessageInAppFeedButtonSet(
                        messageInAppFeedButtonSet: MessageInAppFeedButtonSetBlock
                    ) {
                        messageInAppFeedButtonSet.validate()
                    }
                }
            )
            validated = true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Block && messageInAppFeedContent == other.messageInAppFeedContent && messageInAppFeedButtonSet == other.messageInAppFeedButtonSet /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(messageInAppFeedContent, messageInAppFeedButtonSet) /* spotless:on */

        override fun toString(): String =
            when {
                messageInAppFeedContent != null ->
                    "Block{messageInAppFeedContent=$messageInAppFeedContent}"
                messageInAppFeedButtonSet != null ->
                    "Block{messageInAppFeedButtonSet=$messageInAppFeedButtonSet}"
                _json != null -> "Block{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Block")
            }

        companion object {

            /** A content (text or markdown) block in a message in an app feed */
            @JvmStatic
            fun ofMessageInAppFeedContent(messageInAppFeedContent: MessageInAppFeedContentBlock) =
                Block(messageInAppFeedContent = messageInAppFeedContent)

            /** A set of buttons in a message in an app feed */
            @JvmStatic
            fun ofMessageInAppFeedButtonSet(
                messageInAppFeedButtonSet: MessageInAppFeedButtonSetBlock
            ) = Block(messageInAppFeedButtonSet = messageInAppFeedButtonSet)
        }

        /** An interface that defines how to map each variant of [Block] to a value of type [T]. */
        interface Visitor<out T> {

            /** A content (text or markdown) block in a message in an app feed */
            fun visitMessageInAppFeedContent(
                messageInAppFeedContent: MessageInAppFeedContentBlock
            ): T

            /** A set of buttons in a message in an app feed */
            fun visitMessageInAppFeedButtonSet(
                messageInAppFeedButtonSet: MessageInAppFeedButtonSetBlock
            ): T

            /**
             * Maps an unknown variant of [Block] to a value of type [T].
             *
             * An instance of [Block] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws KnockInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw KnockInvalidDataException("Unknown Block: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Block>(Block::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Block {
                val json = JsonValue.fromJsonNode(node)

                tryDeserialize(node, jacksonTypeRef<MessageInAppFeedContentBlock>()) {
                        it.validate()
                    }
                    ?.let {
                        return Block(messageInAppFeedContent = it, _json = json)
                    }
                tryDeserialize(node, jacksonTypeRef<MessageInAppFeedButtonSetBlock>()) {
                        it.validate()
                    }
                    ?.let {
                        return Block(messageInAppFeedButtonSet = it, _json = json)
                    }

                return Block(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Block>(Block::class) {

            override fun serialize(
                value: Block,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.messageInAppFeedContent != null ->
                        generator.writeObject(value.messageInAppFeedContent)
                    value.messageInAppFeedButtonSet != null ->
                        generator.writeObject(value.messageInAppFeedButtonSet)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Block")
                }
            }
        }

        /** A content (text or markdown) block in a message in an app feed */
        class MessageInAppFeedContentBlock
        private constructor(
            private val content: JsonField<String>,
            private val name: JsonField<String>,
            private val rendered: JsonField<String>,
            private val type: JsonField<Type>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("content")
                @ExcludeMissing
                content: JsonField<String> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("rendered")
                @ExcludeMissing
                rendered: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
            ) : this(content, name, rendered, type, mutableMapOf())

            /**
             * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun content(): String = content.getRequired("content")

            /**
             * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun rendered(): String = rendered.getRequired("rendered")

            /**
             * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun type(): Type = type.getRequired("type")

            /**
             * Returns the raw JSON value of [content].
             *
             * Unlike [content], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("content") @ExcludeMissing fun _content(): JsonField<String> = content

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [rendered].
             *
             * Unlike [rendered], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("rendered") @ExcludeMissing fun _rendered(): JsonField<String> = rendered

            /**
             * Returns the raw JSON value of [type].
             *
             * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

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
                 * [MessageInAppFeedContentBlock].
                 *
                 * The following fields are required:
                 * ```java
                 * .content()
                 * .name()
                 * .rendered()
                 * .type()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [MessageInAppFeedContentBlock]. */
            class Builder internal constructor() {

                private var content: JsonField<String>? = null
                private var name: JsonField<String>? = null
                private var rendered: JsonField<String>? = null
                private var type: JsonField<Type>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(messageInAppFeedContentBlock: MessageInAppFeedContentBlock) =
                    apply {
                        content = messageInAppFeedContentBlock.content
                        name = messageInAppFeedContentBlock.name
                        rendered = messageInAppFeedContentBlock.rendered
                        type = messageInAppFeedContentBlock.type
                        additionalProperties =
                            messageInAppFeedContentBlock.additionalProperties.toMutableMap()
                    }

                fun content(content: String) = content(JsonField.of(content))

                /**
                 * Sets [Builder.content] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.content] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun content(content: JsonField<String>) = apply { this.content = content }

                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun rendered(rendered: String) = rendered(JsonField.of(rendered))

                /**
                 * Sets [Builder.rendered] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.rendered] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun rendered(rendered: JsonField<String>) = apply { this.rendered = rendered }

                fun type(type: Type) = type(JsonField.of(type))

                /**
                 * Sets [Builder.type] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.type] with a well-typed [Type] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonField<Type>) = apply { this.type = type }

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
                 * Returns an immutable instance of [MessageInAppFeedContentBlock].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .content()
                 * .name()
                 * .rendered()
                 * .type()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): MessageInAppFeedContentBlock =
                    MessageInAppFeedContentBlock(
                        checkRequired("content", content),
                        checkRequired("name", name),
                        checkRequired("rendered", rendered),
                        checkRequired("type", type),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): MessageInAppFeedContentBlock = apply {
                if (validated) {
                    return@apply
                }

                content()
                name()
                rendered()
                type()
                validated = true
            }

            class Type @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val MARKDOWN = of("markdown")

                    @JvmField val TEXT = of("text")

                    @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                }

                /** An enum containing [Type]'s known values. */
                enum class Known {
                    MARKDOWN,
                    TEXT,
                }

                /**
                 * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Type] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    MARKDOWN,
                    TEXT,
                    /**
                     * An enum member indicating that [Type] was instantiated with an unknown value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                fun value(): Value =
                    when (this) {
                        MARKDOWN -> Value.MARKDOWN
                        TEXT -> Value.TEXT
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
                        MARKDOWN -> Known.MARKDOWN
                        TEXT -> Known.TEXT
                        else -> throw KnockInvalidDataException("Unknown Type: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws KnockInvalidDataException if this class instance's value does not have
                 *   the expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        KnockInvalidDataException("Value is not a String")
                    }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is Type && value == other.value /* spotless:on */
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is MessageInAppFeedContentBlock && content == other.content && name == other.name && rendered == other.rendered && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(content, name, rendered, type, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "MessageInAppFeedContentBlock{content=$content, name=$name, rendered=$rendered, type=$type, additionalProperties=$additionalProperties}"
        }

        /** A set of buttons in a message in an app feed */
        class MessageInAppFeedButtonSetBlock
        private constructor(
            private val buttons: JsonField<List<Button>>,
            private val name: JsonField<String>,
            private val type: JsonField<Type>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("buttons")
                @ExcludeMissing
                buttons: JsonField<List<Button>> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
            ) : this(buttons, name, type, mutableMapOf())

            /**
             * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun buttons(): List<Button> = buttons.getRequired("buttons")

            /**
             * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun type(): Type = type.getRequired("type")

            /**
             * Returns the raw JSON value of [buttons].
             *
             * Unlike [buttons], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("buttons")
            @ExcludeMissing
            fun _buttons(): JsonField<List<Button>> = buttons

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [type].
             *
             * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

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
                 * [MessageInAppFeedButtonSetBlock].
                 *
                 * The following fields are required:
                 * ```java
                 * .buttons()
                 * .name()
                 * .type()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [MessageInAppFeedButtonSetBlock]. */
            class Builder internal constructor() {

                private var buttons: JsonField<MutableList<Button>>? = null
                private var name: JsonField<String>? = null
                private var type: JsonField<Type>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(messageInAppFeedButtonSetBlock: MessageInAppFeedButtonSetBlock) =
                    apply {
                        buttons = messageInAppFeedButtonSetBlock.buttons.map { it.toMutableList() }
                        name = messageInAppFeedButtonSetBlock.name
                        type = messageInAppFeedButtonSetBlock.type
                        additionalProperties =
                            messageInAppFeedButtonSetBlock.additionalProperties.toMutableMap()
                    }

                fun buttons(buttons: List<Button>) = buttons(JsonField.of(buttons))

                /**
                 * Sets [Builder.buttons] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.buttons] with a well-typed `List<Button>` value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun buttons(buttons: JsonField<List<Button>>) = apply {
                    this.buttons = buttons.map { it.toMutableList() }
                }

                /**
                 * Adds a single [Button] to [buttons].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addButton(button: Button) = apply {
                    buttons =
                        (buttons ?: JsonField.of(mutableListOf())).also {
                            checkKnown("buttons", it).add(button)
                        }
                }

                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun type(type: Type) = type(JsonField.of(type))

                /**
                 * Sets [Builder.type] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.type] with a well-typed [Type] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonField<Type>) = apply { this.type = type }

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
                 * Returns an immutable instance of [MessageInAppFeedButtonSetBlock].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .buttons()
                 * .name()
                 * .type()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): MessageInAppFeedButtonSetBlock =
                    MessageInAppFeedButtonSetBlock(
                        checkRequired("buttons", buttons).map { it.toImmutable() },
                        checkRequired("name", name),
                        checkRequired("type", type),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): MessageInAppFeedButtonSetBlock = apply {
                if (validated) {
                    return@apply
                }

                buttons().forEach { it.validate() }
                name()
                type()
                validated = true
            }

            /** A button in a set of buttons */
            class Button
            private constructor(
                private val action: JsonField<String>,
                private val label: JsonField<String>,
                private val name: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("action")
                    @ExcludeMissing
                    action: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("label")
                    @ExcludeMissing
                    label: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                ) : this(action, label, name, mutableMapOf())

                /**
                 * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun action(): String = action.getRequired("action")

                /**
                 * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun label(): String = label.getRequired("label")

                /**
                 * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun name(): String = name.getRequired("name")

                /**
                 * Returns the raw JSON value of [action].
                 *
                 * Unlike [action], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("action") @ExcludeMissing fun _action(): JsonField<String> = action

                /**
                 * Returns the raw JSON value of [label].
                 *
                 * Unlike [label], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("label") @ExcludeMissing fun _label(): JsonField<String> = label

                /**
                 * Returns the raw JSON value of [name].
                 *
                 * Unlike [name], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

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
                     * Returns a mutable builder for constructing an instance of [Button].
                     *
                     * The following fields are required:
                     * ```java
                     * .action()
                     * .label()
                     * .name()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Button]. */
                class Builder internal constructor() {

                    private var action: JsonField<String>? = null
                    private var label: JsonField<String>? = null
                    private var name: JsonField<String>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(button: Button) = apply {
                        action = button.action
                        label = button.label
                        name = button.name
                        additionalProperties = button.additionalProperties.toMutableMap()
                    }

                    fun action(action: String) = action(JsonField.of(action))

                    /**
                     * Sets [Builder.action] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.action] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun action(action: JsonField<String>) = apply { this.action = action }

                    fun label(label: String) = label(JsonField.of(label))

                    /**
                     * Sets [Builder.label] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.label] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun label(label: JsonField<String>) = apply { this.label = label }

                    fun name(name: String) = name(JsonField.of(name))

                    /**
                     * Sets [Builder.name] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.name] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun name(name: JsonField<String>) = apply { this.name = name }

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
                     * Returns an immutable instance of [Button].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .action()
                     * .label()
                     * .name()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Button =
                        Button(
                            checkRequired("action", action),
                            checkRequired("label", label),
                            checkRequired("name", name),
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): Button = apply {
                    if (validated) {
                        return@apply
                    }

                    action()
                    label()
                    name()
                    validated = true
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is Button && action == other.action && label == other.label && name == other.name && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(action, label, name, additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Button{action=$action, label=$label, name=$name, additionalProperties=$additionalProperties}"
            }

            class Type @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val BUTTON_SET = of("button_set")

                    @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                }

                /** An enum containing [Type]'s known values. */
                enum class Known {
                    BUTTON_SET
                }

                /**
                 * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Type] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    BUTTON_SET,
                    /**
                     * An enum member indicating that [Type] was instantiated with an unknown value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                fun value(): Value =
                    when (this) {
                        BUTTON_SET -> Value.BUTTON_SET
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
                        BUTTON_SET -> Known.BUTTON_SET
                        else -> throw KnockInvalidDataException("Unknown Type: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws KnockInvalidDataException if this class instance's value does not have
                 *   the expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        KnockInvalidDataException("Value is not a String")
                    }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is Type && value == other.value /* spotless:on */
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is MessageInAppFeedButtonSetBlock && buttons == other.buttons && name == other.name && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(buttons, name, type, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "MessageInAppFeedButtonSetBlock{buttons=$buttons, name=$name, type=$type, additionalProperties=$additionalProperties}"
        }
    }

    class Data
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

            /** Returns a mutable builder for constructing an instance of [Data]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Data]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(data: Data) = apply {
                additionalProperties = data.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [Data].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Data = Data(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        fun validate(): Data = apply {
            if (validated) {
                return@apply
            }

            validated = true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Data && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() = "Data{additionalProperties=$additionalProperties}"
    }

    class Source
    private constructor(
        private val _typename: JsonField<String>,
        private val categories: JsonField<List<String>>,
        private val key: JsonField<String>,
        private val versionId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("__typename")
            @ExcludeMissing
            _typename: JsonField<String> = JsonMissing.of(),
            @JsonProperty("categories")
            @ExcludeMissing
            categories: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("key") @ExcludeMissing key: JsonField<String> = JsonMissing.of(),
            @JsonProperty("version_id")
            @ExcludeMissing
            versionId: JsonField<String> = JsonMissing.of(),
        ) : this(_typename, categories, key, versionId, mutableMapOf())

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun _typename(): String = _typename.getRequired("__typename")

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun categories(): List<String> = categories.getRequired("categories")

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun key(): String = key.getRequired("key")

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun versionId(): String = versionId.getRequired("version_id")

        /**
         * Returns the raw JSON value of [_typename].
         *
         * Unlike [_typename], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("__typename") @ExcludeMissing fun __typename(): JsonField<String> = _typename

        /**
         * Returns the raw JSON value of [categories].
         *
         * Unlike [categories], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("categories")
        @ExcludeMissing
        fun _categories(): JsonField<List<String>> = categories

        /**
         * Returns the raw JSON value of [key].
         *
         * Unlike [key], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("key") @ExcludeMissing fun _key(): JsonField<String> = key

        /**
         * Returns the raw JSON value of [versionId].
         *
         * Unlike [versionId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("version_id") @ExcludeMissing fun _versionId(): JsonField<String> = versionId

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
             * Returns a mutable builder for constructing an instance of [Source].
             *
             * The following fields are required:
             * ```java
             * ._typename()
             * .categories()
             * .key()
             * .versionId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Source]. */
        class Builder internal constructor() {

            private var _typename: JsonField<String>? = null
            private var categories: JsonField<MutableList<String>>? = null
            private var key: JsonField<String>? = null
            private var versionId: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(source: Source) = apply {
                _typename = source._typename
                categories = source.categories.map { it.toMutableList() }
                key = source.key
                versionId = source.versionId
                additionalProperties = source.additionalProperties.toMutableMap()
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

            fun categories(categories: List<String>) = categories(JsonField.of(categories))

            /**
             * Sets [Builder.categories] to an arbitrary JSON value.
             *
             * You should usually call [Builder.categories] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun categories(categories: JsonField<List<String>>) = apply {
                this.categories = categories.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [categories].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addCategory(category: String) = apply {
                categories =
                    (categories ?: JsonField.of(mutableListOf())).also {
                        checkKnown("categories", it).add(category)
                    }
            }

            fun key(key: String) = key(JsonField.of(key))

            /**
             * Sets [Builder.key] to an arbitrary JSON value.
             *
             * You should usually call [Builder.key] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun key(key: JsonField<String>) = apply { this.key = key }

            fun versionId(versionId: String) = versionId(JsonField.of(versionId))

            /**
             * Sets [Builder.versionId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.versionId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun versionId(versionId: JsonField<String>) = apply { this.versionId = versionId }

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
             * Returns an immutable instance of [Source].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * ._typename()
             * .categories()
             * .key()
             * .versionId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Source =
                Source(
                    checkRequired("_typename", _typename),
                    checkRequired("categories", categories).map { it.toImmutable() },
                    checkRequired("key", key),
                    checkRequired("versionId", versionId),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Source = apply {
            if (validated) {
                return@apply
            }

            _typename()
            categories()
            key()
            versionId()
            validated = true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Source && _typename == other._typename && categories == other.categories && key == other.key && versionId == other.versionId && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(_typename, categories, key, versionId, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Source{_typename=$_typename, categories=$categories, key=$key, versionId=$versionId, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FeedListItemsResponse && id == other.id && _typename == other._typename && activities == other.activities && actors == other.actors && blocks == other.blocks && data == other.data && insertedAt == other.insertedAt && source == other.source && tenant == other.tenant && totalActivities == other.totalActivities && totalActors == other.totalActors && updatedAt == other.updatedAt && archivedAt == other.archivedAt && clickedAt == other.clickedAt && interactedAt == other.interactedAt && linkClickedAt == other.linkClickedAt && readAt == other.readAt && seenAt == other.seenAt && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, _typename, activities, actors, blocks, data, insertedAt, source, tenant, totalActivities, totalActors, updatedAt, archivedAt, clickedAt, interactedAt, linkClickedAt, readAt, seenAt, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FeedListItemsResponse{id=$id, _typename=$_typename, activities=$activities, actors=$actors, blocks=$blocks, data=$data, insertedAt=$insertedAt, source=$source, tenant=$tenant, totalActivities=$totalActivities, totalActors=$totalActors, updatedAt=$updatedAt, archivedAt=$archivedAt, clickedAt=$clickedAt, interactedAt=$interactedAt, linkClickedAt=$linkClickedAt, readAt=$readAt, seenAt=$seenAt, additionalProperties=$additionalProperties}"
}
