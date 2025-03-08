// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

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
import com.knock.api.core.BaseDeserializer
import com.knock.api.core.BaseSerializer
import com.knock.api.core.Enum
import com.knock.api.core.ExcludeMissing
import com.knock.api.core.JsonField
import com.knock.api.core.JsonMissing
import com.knock.api.core.JsonValue
import com.knock.api.core.NoAutoDetect
import com.knock.api.core.checkKnown
import com.knock.api.core.checkRequired
import com.knock.api.core.getOrThrow
import com.knock.api.core.immutableEmptyMap
import com.knock.api.core.toImmutable
import com.knock.api.errors.KnockInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** An in-app feed message in a user's feed */
@NoAutoDetect
class UserFeedListItemsResponse
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("__typename")
    @ExcludeMissing
    private val _typename: JsonField<String> = JsonMissing.of(),
    @JsonProperty("activities")
    @ExcludeMissing
    private val activities: JsonField<List<Activity>> = JsonMissing.of(),
    @JsonProperty("actors")
    @ExcludeMissing
    private val actors: JsonField<List<Recipient>> = JsonMissing.of(),
    @JsonProperty("blocks")
    @ExcludeMissing
    private val blocks: JsonField<List<Block>> = JsonMissing.of(),
    @JsonProperty("data") @ExcludeMissing private val data: JsonField<Data> = JsonMissing.of(),
    @JsonProperty("inserted_at")
    @ExcludeMissing
    private val insertedAt: JsonField<String> = JsonMissing.of(),
    @JsonProperty("source")
    @ExcludeMissing
    private val source: JsonField<Source> = JsonMissing.of(),
    @JsonProperty("tenant")
    @ExcludeMissing
    private val tenant: JsonField<String> = JsonMissing.of(),
    @JsonProperty("total_activities")
    @ExcludeMissing
    private val totalActivities: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("total_actors")
    @ExcludeMissing
    private val totalActors: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("updated_at")
    @ExcludeMissing
    private val updatedAt: JsonField<String> = JsonMissing.of(),
    @JsonProperty("archived_at")
    @ExcludeMissing
    private val archivedAt: JsonField<String> = JsonMissing.of(),
    @JsonProperty("clicked_at")
    @ExcludeMissing
    private val clickedAt: JsonField<String> = JsonMissing.of(),
    @JsonProperty("interacted_at")
    @ExcludeMissing
    private val interactedAt: JsonField<String> = JsonMissing.of(),
    @JsonProperty("link_clicked_at")
    @ExcludeMissing
    private val linkClickedAt: JsonField<String> = JsonMissing.of(),
    @JsonProperty("read_at")
    @ExcludeMissing
    private val readAt: JsonField<String> = JsonMissing.of(),
    @JsonProperty("seen_at")
    @ExcludeMissing
    private val seenAt: JsonField<String> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    fun id(): String = id.getRequired("id")

    fun _typename(): String = _typename.getRequired("__typename")

    fun activities(): List<Activity> = activities.getRequired("activities")

    fun actors(): List<Recipient> = actors.getRequired("actors")

    fun blocks(): List<Block> = blocks.getRequired("blocks")

    fun data(): Optional<Data> = Optional.ofNullable(data.getNullable("data"))

    fun insertedAt(): String = insertedAt.getRequired("inserted_at")

    fun source(): Source = source.getRequired("source")

    fun tenant(): Optional<String> = Optional.ofNullable(tenant.getNullable("tenant"))

    fun totalActivities(): Long = totalActivities.getRequired("total_activities")

    fun totalActors(): Long = totalActors.getRequired("total_actors")

    fun updatedAt(): String = updatedAt.getRequired("updated_at")

    fun archivedAt(): Optional<String> = Optional.ofNullable(archivedAt.getNullable("archived_at"))

    fun clickedAt(): Optional<String> = Optional.ofNullable(clickedAt.getNullable("clicked_at"))

    fun interactedAt(): Optional<String> =
        Optional.ofNullable(interactedAt.getNullable("interacted_at"))

    fun linkClickedAt(): Optional<String> =
        Optional.ofNullable(linkClickedAt.getNullable("link_clicked_at"))

    fun readAt(): Optional<String> = Optional.ofNullable(readAt.getNullable("read_at"))

    fun seenAt(): Optional<String> = Optional.ofNullable(seenAt.getNullable("seen_at"))

    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    @JsonProperty("__typename") @ExcludeMissing fun __typename(): JsonField<String> = _typename

    @JsonProperty("activities")
    @ExcludeMissing
    fun _activities(): JsonField<List<Activity>> = activities

    @JsonProperty("actors") @ExcludeMissing fun _actors(): JsonField<List<Recipient>> = actors

    @JsonProperty("blocks") @ExcludeMissing fun _blocks(): JsonField<List<Block>> = blocks

    @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Data> = data

    @JsonProperty("inserted_at") @ExcludeMissing fun _insertedAt(): JsonField<String> = insertedAt

    @JsonProperty("source") @ExcludeMissing fun _source(): JsonField<Source> = source

    @JsonProperty("tenant") @ExcludeMissing fun _tenant(): JsonField<String> = tenant

    @JsonProperty("total_activities")
    @ExcludeMissing
    fun _totalActivities(): JsonField<Long> = totalActivities

    @JsonProperty("total_actors") @ExcludeMissing fun _totalActors(): JsonField<Long> = totalActors

    @JsonProperty("updated_at") @ExcludeMissing fun _updatedAt(): JsonField<String> = updatedAt

    @JsonProperty("archived_at") @ExcludeMissing fun _archivedAt(): JsonField<String> = archivedAt

    @JsonProperty("clicked_at") @ExcludeMissing fun _clickedAt(): JsonField<String> = clickedAt

    @JsonProperty("interacted_at")
    @ExcludeMissing
    fun _interactedAt(): JsonField<String> = interactedAt

    @JsonProperty("link_clicked_at")
    @ExcludeMissing
    fun _linkClickedAt(): JsonField<String> = linkClickedAt

    @JsonProperty("read_at") @ExcludeMissing fun _readAt(): JsonField<String> = readAt

    @JsonProperty("seen_at") @ExcludeMissing fun _seenAt(): JsonField<String> = seenAt

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): UserFeedListItemsResponse = apply {
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

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [UserFeedListItemsResponse].
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

    /** A builder for [UserFeedListItemsResponse]. */
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
        internal fun from(userFeedListItemsResponse: UserFeedListItemsResponse) = apply {
            id = userFeedListItemsResponse.id
            _typename = userFeedListItemsResponse._typename
            activities = userFeedListItemsResponse.activities.map { it.toMutableList() }
            actors = userFeedListItemsResponse.actors.map { it.toMutableList() }
            blocks = userFeedListItemsResponse.blocks.map { it.toMutableList() }
            data = userFeedListItemsResponse.data
            insertedAt = userFeedListItemsResponse.insertedAt
            source = userFeedListItemsResponse.source
            tenant = userFeedListItemsResponse.tenant
            totalActivities = userFeedListItemsResponse.totalActivities
            totalActors = userFeedListItemsResponse.totalActors
            updatedAt = userFeedListItemsResponse.updatedAt
            archivedAt = userFeedListItemsResponse.archivedAt
            clickedAt = userFeedListItemsResponse.clickedAt
            interactedAt = userFeedListItemsResponse.interactedAt
            linkClickedAt = userFeedListItemsResponse.linkClickedAt
            readAt = userFeedListItemsResponse.readAt
            seenAt = userFeedListItemsResponse.seenAt
            additionalProperties = userFeedListItemsResponse.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        fun id(id: JsonField<String>) = apply { this.id = id }

        fun _typename(_typename: String) = _typename(JsonField.of(_typename))

        fun _typename(_typename: JsonField<String>) = apply { this._typename = _typename }

        fun activities(activities: List<Activity>) = activities(JsonField.of(activities))

        fun activities(activities: JsonField<List<Activity>>) = apply {
            this.activities = activities.map { it.toMutableList() }
        }

        fun addActivity(activity: Activity) = apply {
            activities =
                (activities ?: JsonField.of(mutableListOf())).also {
                    checkKnown("activities", it).add(activity)
                }
        }

        fun actors(actors: List<Recipient>) = actors(JsonField.of(actors))

        fun actors(actors: JsonField<List<Recipient>>) = apply {
            this.actors = actors.map { it.toMutableList() }
        }

        fun addActor(actor: Recipient) = apply {
            actors =
                (actors ?: JsonField.of(mutableListOf())).also {
                    checkKnown("actors", it).add(actor)
                }
        }

        /** A user object */
        fun addActor(user: User) = addActor(Recipient.ofUser(user))

        /** A custom-object entity which belongs to a collection. */
        fun addActor(object_: Object) = addActor(Recipient.ofObject(object_))

        fun blocks(blocks: List<Block>) = blocks(JsonField.of(blocks))

        fun blocks(blocks: JsonField<List<Block>>) = apply {
            this.blocks = blocks.map { it.toMutableList() }
        }

        fun addBlock(block: Block) = apply {
            blocks =
                (blocks ?: JsonField.of(mutableListOf())).also {
                    checkKnown("blocks", it).add(block)
                }
        }

        /** A content (text or markdown) block in a message in an app feed */
        fun addBlock(messageInAppFeedContent: Block.MessageInAppFeedContentBlock) =
            addBlock(Block.ofMessageInAppFeedContent(messageInAppFeedContent))

        /** A set of buttons in a message in an app feed */
        fun addBlock(messageInAppFeedButtonSet: Block.MessageInAppFeedButtonSetBlock) =
            addBlock(Block.ofMessageInAppFeedButtonSet(messageInAppFeedButtonSet))

        fun data(data: Data?) = data(JsonField.ofNullable(data))

        fun data(data: Optional<Data>) = data(data.getOrNull())

        fun data(data: JsonField<Data>) = apply { this.data = data }

        fun insertedAt(insertedAt: String) = insertedAt(JsonField.of(insertedAt))

        fun insertedAt(insertedAt: JsonField<String>) = apply { this.insertedAt = insertedAt }

        fun source(source: Source) = source(JsonField.of(source))

        fun source(source: JsonField<Source>) = apply { this.source = source }

        fun tenant(tenant: String?) = tenant(JsonField.ofNullable(tenant))

        fun tenant(tenant: Optional<String>) = tenant(tenant.getOrNull())

        fun tenant(tenant: JsonField<String>) = apply { this.tenant = tenant }

        fun totalActivities(totalActivities: Long) = totalActivities(JsonField.of(totalActivities))

        fun totalActivities(totalActivities: JsonField<Long>) = apply {
            this.totalActivities = totalActivities
        }

        fun totalActors(totalActors: Long) = totalActors(JsonField.of(totalActors))

        fun totalActors(totalActors: JsonField<Long>) = apply { this.totalActors = totalActors }

        fun updatedAt(updatedAt: String) = updatedAt(JsonField.of(updatedAt))

        fun updatedAt(updatedAt: JsonField<String>) = apply { this.updatedAt = updatedAt }

        fun archivedAt(archivedAt: String?) = archivedAt(JsonField.ofNullable(archivedAt))

        fun archivedAt(archivedAt: Optional<String>) = archivedAt(archivedAt.getOrNull())

        fun archivedAt(archivedAt: JsonField<String>) = apply { this.archivedAt = archivedAt }

        fun clickedAt(clickedAt: String?) = clickedAt(JsonField.ofNullable(clickedAt))

        fun clickedAt(clickedAt: Optional<String>) = clickedAt(clickedAt.getOrNull())

        fun clickedAt(clickedAt: JsonField<String>) = apply { this.clickedAt = clickedAt }

        fun interactedAt(interactedAt: String?) = interactedAt(JsonField.ofNullable(interactedAt))

        fun interactedAt(interactedAt: Optional<String>) = interactedAt(interactedAt.getOrNull())

        fun interactedAt(interactedAt: JsonField<String>) = apply {
            this.interactedAt = interactedAt
        }

        fun linkClickedAt(linkClickedAt: String?) =
            linkClickedAt(JsonField.ofNullable(linkClickedAt))

        fun linkClickedAt(linkClickedAt: Optional<String>) =
            linkClickedAt(linkClickedAt.getOrNull())

        fun linkClickedAt(linkClickedAt: JsonField<String>) = apply {
            this.linkClickedAt = linkClickedAt
        }

        fun readAt(readAt: String?) = readAt(JsonField.ofNullable(readAt))

        fun readAt(readAt: Optional<String>) = readAt(readAt.getOrNull())

        fun readAt(readAt: JsonField<String>) = apply { this.readAt = readAt }

        fun seenAt(seenAt: String?) = seenAt(JsonField.ofNullable(seenAt))

        fun seenAt(seenAt: Optional<String>) = seenAt(seenAt.getOrNull())

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

        fun build(): UserFeedListItemsResponse =
            UserFeedListItemsResponse(
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
                additionalProperties.toImmutable(),
            )
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
        @NoAutoDetect
        class MessageInAppFeedContentBlock
        @JsonCreator
        private constructor(
            @JsonProperty("content")
            @ExcludeMissing
            private val content: JsonField<String> = JsonMissing.of(),
            @JsonProperty("name")
            @ExcludeMissing
            private val name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("rendered")
            @ExcludeMissing
            private val rendered: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type")
            @ExcludeMissing
            private val type: JsonField<Type> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            fun content(): String = content.getRequired("content")

            fun name(): String = name.getRequired("name")

            fun rendered(): String = rendered.getRequired("rendered")

            fun type(): Type = type.getRequired("type")

            @JsonProperty("content") @ExcludeMissing fun _content(): JsonField<String> = content

            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            @JsonProperty("rendered") @ExcludeMissing fun _rendered(): JsonField<String> = rendered

            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

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

                fun content(content: JsonField<String>) = apply { this.content = content }

                fun name(name: String) = name(JsonField.of(name))

                fun name(name: JsonField<String>) = apply { this.name = name }

                fun rendered(rendered: String) = rendered(JsonField.of(rendered))

                fun rendered(rendered: JsonField<String>) = apply { this.rendered = rendered }

                fun type(type: Type) = type(JsonField.of(type))

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

                fun build(): MessageInAppFeedContentBlock =
                    MessageInAppFeedContentBlock(
                        checkRequired("content", content),
                        checkRequired("name", name),
                        checkRequired("rendered", rendered),
                        checkRequired("type", type),
                        additionalProperties.toImmutable(),
                    )
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
        @NoAutoDetect
        class MessageInAppFeedButtonSetBlock
        @JsonCreator
        private constructor(
            @JsonProperty("buttons")
            @ExcludeMissing
            private val buttons: JsonField<List<Button>> = JsonMissing.of(),
            @JsonProperty("name")
            @ExcludeMissing
            private val name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type")
            @ExcludeMissing
            private val type: JsonField<Type> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            fun buttons(): List<Button> = buttons.getRequired("buttons")

            fun name(): String = name.getRequired("name")

            fun type(): Type = type.getRequired("type")

            @JsonProperty("buttons")
            @ExcludeMissing
            fun _buttons(): JsonField<List<Button>> = buttons

            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

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

                fun buttons(buttons: JsonField<List<Button>>) = apply {
                    this.buttons = buttons.map { it.toMutableList() }
                }

                fun addButton(button: Button) = apply {
                    buttons =
                        (buttons ?: JsonField.of(mutableListOf())).also {
                            checkKnown("buttons", it).add(button)
                        }
                }

                fun name(name: String) = name(JsonField.of(name))

                fun name(name: JsonField<String>) = apply { this.name = name }

                fun type(type: Type) = type(JsonField.of(type))

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

                fun build(): MessageInAppFeedButtonSetBlock =
                    MessageInAppFeedButtonSetBlock(
                        checkRequired("buttons", buttons).map { it.toImmutable() },
                        checkRequired("name", name),
                        checkRequired("type", type),
                        additionalProperties.toImmutable(),
                    )
            }

            /** A button in a set of buttons */
            @NoAutoDetect
            class Button
            @JsonCreator
            private constructor(
                @JsonProperty("action")
                @ExcludeMissing
                private val action: JsonField<String> = JsonMissing.of(),
                @JsonProperty("label")
                @ExcludeMissing
                private val label: JsonField<String> = JsonMissing.of(),
                @JsonProperty("name")
                @ExcludeMissing
                private val name: JsonField<String> = JsonMissing.of(),
                @JsonAnySetter
                private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
            ) {

                fun action(): String = action.getRequired("action")

                fun label(): String = label.getRequired("label")

                fun name(): String = name.getRequired("name")

                @JsonProperty("action") @ExcludeMissing fun _action(): JsonField<String> = action

                @JsonProperty("label") @ExcludeMissing fun _label(): JsonField<String> = label

                @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

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

                    fun action(action: JsonField<String>) = apply { this.action = action }

                    fun label(label: String) = label(JsonField.of(label))

                    fun label(label: JsonField<String>) = apply { this.label = label }

                    fun name(name: String) = name(JsonField.of(name))

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

                    fun build(): Button =
                        Button(
                            checkRequired("action", action),
                            checkRequired("label", label),
                            checkRequired("name", name),
                            additionalProperties.toImmutable(),
                        )
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

    @NoAutoDetect
    class Data
    @JsonCreator
    private constructor(
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap()
    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Data = apply {
            if (validated) {
                return@apply
            }

            validated = true
        }

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

            fun build(): Data = Data(additionalProperties.toImmutable())
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

    @NoAutoDetect
    class Source
    @JsonCreator
    private constructor(
        @JsonProperty("__typename")
        @ExcludeMissing
        private val _typename: JsonField<String> = JsonMissing.of(),
        @JsonProperty("categories")
        @ExcludeMissing
        private val categories: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("key") @ExcludeMissing private val key: JsonField<String> = JsonMissing.of(),
        @JsonProperty("version_id")
        @ExcludeMissing
        private val versionId: JsonField<String> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun _typename(): String = _typename.getRequired("__typename")

        fun categories(): List<String> = categories.getRequired("categories")

        fun key(): String = key.getRequired("key")

        fun versionId(): String = versionId.getRequired("version_id")

        @JsonProperty("__typename") @ExcludeMissing fun __typename(): JsonField<String> = _typename

        @JsonProperty("categories")
        @ExcludeMissing
        fun _categories(): JsonField<List<String>> = categories

        @JsonProperty("key") @ExcludeMissing fun _key(): JsonField<String> = key

        @JsonProperty("version_id") @ExcludeMissing fun _versionId(): JsonField<String> = versionId

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

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

            fun _typename(_typename: JsonField<String>) = apply { this._typename = _typename }

            fun categories(categories: List<String>) = categories(JsonField.of(categories))

            fun categories(categories: JsonField<List<String>>) = apply {
                this.categories = categories.map { it.toMutableList() }
            }

            fun addCategory(category: String) = apply {
                categories =
                    (categories ?: JsonField.of(mutableListOf())).also {
                        checkKnown("categories", it).add(category)
                    }
            }

            fun key(key: String) = key(JsonField.of(key))

            fun key(key: JsonField<String>) = apply { this.key = key }

            fun versionId(versionId: String) = versionId(JsonField.of(versionId))

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

            fun build(): Source =
                Source(
                    checkRequired("_typename", _typename),
                    checkRequired("categories", categories).map { it.toImmutable() },
                    checkRequired("key", key),
                    checkRequired("versionId", versionId),
                    additionalProperties.toImmutable(),
                )
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

        return /* spotless:off */ other is UserFeedListItemsResponse && id == other.id && _typename == other._typename && activities == other.activities && actors == other.actors && blocks == other.blocks && data == other.data && insertedAt == other.insertedAt && source == other.source && tenant == other.tenant && totalActivities == other.totalActivities && totalActors == other.totalActors && updatedAt == other.updatedAt && archivedAt == other.archivedAt && clickedAt == other.clickedAt && interactedAt == other.interactedAt && linkClickedAt == other.linkClickedAt && readAt == other.readAt && seenAt == other.seenAt && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, _typename, activities, actors, blocks, data, insertedAt, source, tenant, totalActivities, totalActors, updatedAt, archivedAt, clickedAt, interactedAt, linkClickedAt, readAt, seenAt, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "UserFeedListItemsResponse{id=$id, _typename=$_typename, activities=$activities, actors=$actors, blocks=$blocks, data=$data, insertedAt=$insertedAt, source=$source, tenant=$tenant, totalActivities=$totalActivities, totalActors=$totalActors, updatedAt=$updatedAt, archivedAt=$archivedAt, clickedAt=$clickedAt, interactedAt=$interactedAt, linkClickedAt=$linkClickedAt, readAt=$readAt, seenAt=$seenAt, additionalProperties=$additionalProperties}"
}
