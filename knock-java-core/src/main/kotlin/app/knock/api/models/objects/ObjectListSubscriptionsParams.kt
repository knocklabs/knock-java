// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.core.BaseDeserializer
import app.knock.api.core.BaseSerializer
import app.knock.api.core.Enum
import app.knock.api.core.JsonField
import app.knock.api.core.JsonValue
import app.knock.api.core.NoAutoDetect
import app.knock.api.core.Params
import app.knock.api.core.checkRequired
import app.knock.api.core.getOrThrow
import app.knock.api.core.http.Headers
import app.knock.api.core.http.QueryParams
import app.knock.api.core.toImmutable
import app.knock.api.errors.KnockInvalidDataException
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * List subscriptions for an object. Either list all subscriptions that belong to the object, or all
 * subscriptions that this object has. Determined by the `mode` query parameter.
 */
class ObjectListSubscriptionsParams
private constructor(
    private val collection: String,
    private val objectId: String,
    private val after: String?,
    private val before: String?,
    private val mode: Mode?,
    private val objects: List<Object>?,
    private val pageSize: Long?,
    private val recipients: List<Recipient>?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun collection(): String = collection

    fun objectId(): String = objectId

    /** The cursor to fetch entries after */
    fun after(): Optional<String> = Optional.ofNullable(after)

    /** The cursor to fetch entries before */
    fun before(): Optional<String> = Optional.ofNullable(before)

    /** Mode of the request */
    fun mode(): Optional<Mode> = Optional.ofNullable(mode)

    /** Objects to filter by (only used if mode is `recipient`) */
    fun objects(): Optional<List<Object>> = Optional.ofNullable(objects)

    /** The page size to fetch */
    fun pageSize(): Optional<Long> = Optional.ofNullable(pageSize)

    /** Recipients to filter by (only used if mode is `object`) */
    fun recipients(): Optional<List<Recipient>> = Optional.ofNullable(recipients)

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams {
        val queryParams = QueryParams.builder()
        this.after?.let { queryParams.put("after", listOf(it.toString())) }
        this.before?.let { queryParams.put("before", listOf(it.toString())) }
        this.mode?.let { queryParams.put("mode", listOf(it.toString())) }
        this.objects?.let { queryParams.put("objects[]", it.map(Any::toString)) }
        this.pageSize?.let { queryParams.put("page_size", listOf(it.toString())) }
        this.recipients?.let { queryParams.put("recipients[]", it.map(Any::toString)) }
        queryParams.putAll(additionalQueryParams)
        return queryParams.build()
    }

    fun getPathParam(index: Int): String {
        return when (index) {
            0 -> collection
            1 -> objectId
            else -> ""
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [ObjectListSubscriptionsParams].
         *
         * The following fields are required:
         * ```java
         * .collection()
         * .objectId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ObjectListSubscriptionsParams]. */
    @NoAutoDetect
    class Builder internal constructor() {

        private var collection: String? = null
        private var objectId: String? = null
        private var after: String? = null
        private var before: String? = null
        private var mode: Mode? = null
        private var objects: MutableList<Object>? = null
        private var pageSize: Long? = null
        private var recipients: MutableList<Recipient>? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(objectListSubscriptionsParams: ObjectListSubscriptionsParams) = apply {
            collection = objectListSubscriptionsParams.collection
            objectId = objectListSubscriptionsParams.objectId
            after = objectListSubscriptionsParams.after
            before = objectListSubscriptionsParams.before
            mode = objectListSubscriptionsParams.mode
            objects = objectListSubscriptionsParams.objects?.toMutableList()
            pageSize = objectListSubscriptionsParams.pageSize
            recipients = objectListSubscriptionsParams.recipients?.toMutableList()
            additionalHeaders = objectListSubscriptionsParams.additionalHeaders.toBuilder()
            additionalQueryParams = objectListSubscriptionsParams.additionalQueryParams.toBuilder()
        }

        fun collection(collection: String) = apply { this.collection = collection }

        fun objectId(objectId: String) = apply { this.objectId = objectId }

        /** The cursor to fetch entries after */
        fun after(after: String?) = apply { this.after = after }

        /** The cursor to fetch entries after */
        fun after(after: Optional<String>) = after(after.getOrNull())

        /** The cursor to fetch entries before */
        fun before(before: String?) = apply { this.before = before }

        /** The cursor to fetch entries before */
        fun before(before: Optional<String>) = before(before.getOrNull())

        /** Mode of the request */
        fun mode(mode: Mode?) = apply { this.mode = mode }

        /** Mode of the request */
        fun mode(mode: Optional<Mode>) = mode(mode.getOrNull())

        /** Objects to filter by (only used if mode is `recipient`) */
        fun objects(objects: List<Object>?) = apply { this.objects = objects?.toMutableList() }

        /** Objects to filter by (only used if mode is `recipient`) */
        fun objects(objects: Optional<List<Object>>) = objects(objects.getOrNull())

        /** Objects to filter by (only used if mode is `recipient`) */
        fun addObject(object_: Object) = apply {
            objects = (objects ?: mutableListOf()).apply { add(object_) }
        }

        /** A user identifier */
        fun addObject(string: String) = addObject(Object.ofString(string))

        /** An object reference to a recipient */
        fun addObject(reference: Object.ObjectReference) = addObject(Object.ofReference(reference))

        /** The page size to fetch */
        fun pageSize(pageSize: Long?) = apply { this.pageSize = pageSize }

        /** The page size to fetch */
        fun pageSize(pageSize: Long) = pageSize(pageSize as Long?)

        /** The page size to fetch */
        fun pageSize(pageSize: Optional<Long>) = pageSize(pageSize.getOrNull())

        /** Recipients to filter by (only used if mode is `object`) */
        fun recipients(recipients: List<Recipient>?) = apply {
            this.recipients = recipients?.toMutableList()
        }

        /** Recipients to filter by (only used if mode is `object`) */
        fun recipients(recipients: Optional<List<Recipient>>) = recipients(recipients.getOrNull())

        /** Recipients to filter by (only used if mode is `object`) */
        fun addRecipient(recipient: Recipient) = apply {
            recipients = (recipients ?: mutableListOf()).apply { add(recipient) }
        }

        /** A user identifier */
        fun addRecipient(string: String) = addRecipient(Recipient.ofString(string))

        /** An object reference to a recipient */
        fun addRecipient(objectReference: Recipient.ObjectReference) =
            addRecipient(Recipient.ofObjectReference(objectReference))

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        fun build(): ObjectListSubscriptionsParams =
            ObjectListSubscriptionsParams(
                checkRequired("collection", collection),
                checkRequired("objectId", objectId),
                after,
                before,
                mode,
                objects?.toImmutable(),
                pageSize,
                recipients?.toImmutable(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    /** Mode of the request */
    class Mode @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val RECIPIENT = of("recipient")

            @JvmField val OBJECT = of("object")

            @JvmStatic fun of(value: String) = Mode(JsonField.of(value))
        }

        /** An enum containing [Mode]'s known values. */
        enum class Known {
            RECIPIENT,
            OBJECT,
        }

        /**
         * An enum containing [Mode]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Mode] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            RECIPIENT,
            OBJECT,
            /** An enum member indicating that [Mode] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                RECIPIENT -> Value.RECIPIENT
                OBJECT -> Value.OBJECT
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws KnockInvalidDataException if this class instance's value is a not a known member.
         */
        fun known(): Known =
            when (this) {
                RECIPIENT -> Known.RECIPIENT
                OBJECT -> Known.OBJECT
                else -> throw KnockInvalidDataException("Unknown Mode: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws KnockInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { KnockInvalidDataException("Value is not a String") }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Mode && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * A reference to a recipient, either a user identifier (string) or an object reference (id,
     * collection).
     */
    @JsonDeserialize(using = Object.Deserializer::class)
    @JsonSerialize(using = Object.Serializer::class)
    class Object
    private constructor(
        private val string: String? = null,
        private val reference: ObjectReference? = null,
        private val _json: JsonValue? = null,
    ) {

        /** A user identifier */
        fun string(): Optional<String> = Optional.ofNullable(string)

        /** An object reference to a recipient */
        fun reference(): Optional<ObjectReference> = Optional.ofNullable(reference)

        fun isString(): Boolean = string != null

        fun isReference(): Boolean = reference != null

        /** A user identifier */
        fun asString(): String = string.getOrThrow("string")

        /** An object reference to a recipient */
        fun asReference(): ObjectReference = reference.getOrThrow("reference")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                string != null -> visitor.visitString(string)
                reference != null -> visitor.visitReference(reference)
                else -> visitor.unknown(_json)
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Object && string == other.string && reference == other.reference /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(string, reference) /* spotless:on */

        override fun toString(): String =
            when {
                string != null -> "Object{string=$string}"
                reference != null -> "Object{reference=$reference}"
                _json != null -> "Object{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Object")
            }

        companion object {

            /** A user identifier */
            @JvmStatic fun ofString(string: String) = Object(string = string)

            /** An object reference to a recipient */
            @JvmStatic fun ofReference(reference: ObjectReference) = Object(reference = reference)
        }

        /** An interface that defines how to map each variant of [Object] to a value of type [T]. */
        interface Visitor<out T> {

            /** A user identifier */
            fun visitString(string: String): T

            /** An object reference to a recipient */
            fun visitReference(reference: ObjectReference): T

            /**
             * Maps an unknown variant of [Object] to a value of type [T].
             *
             * An instance of [Object] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws KnockInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw KnockInvalidDataException("Unknown Object: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Object>(Object::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Object {
                val json = JsonValue.fromJsonNode(node)

                tryDeserialize(node, jacksonTypeRef<String>())?.let {
                    return Object(string = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<ObjectReference>())?.let {
                    return Object(reference = it, _json = json)
                }

                return Object(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Object>(Object::class) {

            override fun serialize(
                value: Object,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.string != null -> generator.writeObject(value.string)
                    value.reference != null -> generator.writeObject(value.reference)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Object")
                }
            }
        }

        /** An object reference to a recipient */
        class ObjectReference
        private constructor(private val id: String, private val collection: String) {

            /** An object identifier */
            fun id(): String = id

            /** The collection the object belongs to */
            fun collection(): String = collection

            @JvmSynthetic
            internal fun forEachQueryParam(putParam: (String, List<String>) -> Unit) {
                this.id.let { putParam("id", listOf(it.toString())) }
                this.collection.let { putParam("collection", listOf(it.toString())) }
                additionalProperties.keys().forEach {
                    putParam(it, additionalProperties.values(it))
                }
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [ObjectReference].
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * .collection()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ObjectReference]. */
            class Builder internal constructor() {

                private var id: String? = null
                private var collection: String? = null

                @JvmSynthetic
                internal fun from(objectReference: ObjectReference) = apply {
                    id = objectReference.id
                    collection = objectReference.collection
                }

                /** An object identifier */
                fun id(id: String) = apply { this.id = id }

                /** The collection the object belongs to */
                fun collection(collection: String) = apply { this.collection = collection }

                fun build(): ObjectReference =
                    ObjectReference(
                        checkRequired("id", id),
                        checkRequired("collection", collection),
                    )
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is ObjectReference && id == other.id && collection == other.collection /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(id, collection) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() = "ObjectReference{id=$id, collection=$collection}"
        }
    }

    /**
     * A reference to a recipient, either a user identifier (string) or an object reference (id,
     * collection).
     */
    @JsonDeserialize(using = Recipient.Deserializer::class)
    @JsonSerialize(using = Recipient.Serializer::class)
    class Recipient
    private constructor(
        private val string: String? = null,
        private val objectReference: ObjectReference? = null,
        private val _json: JsonValue? = null,
    ) {

        /** A user identifier */
        fun string(): Optional<String> = Optional.ofNullable(string)

        /** An object reference to a recipient */
        fun objectReference(): Optional<ObjectReference> = Optional.ofNullable(objectReference)

        fun isString(): Boolean = string != null

        fun isObjectReference(): Boolean = objectReference != null

        /** A user identifier */
        fun asString(): String = string.getOrThrow("string")

        /** An object reference to a recipient */
        fun asObjectReference(): ObjectReference = objectReference.getOrThrow("objectReference")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                string != null -> visitor.visitString(string)
                objectReference != null -> visitor.visitObjectReference(objectReference)
                else -> visitor.unknown(_json)
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Recipient && string == other.string && objectReference == other.objectReference /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(string, objectReference) /* spotless:on */

        override fun toString(): String =
            when {
                string != null -> "Recipient{string=$string}"
                objectReference != null -> "Recipient{objectReference=$objectReference}"
                _json != null -> "Recipient{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Recipient")
            }

        companion object {

            /** A user identifier */
            @JvmStatic fun ofString(string: String) = Recipient(string = string)

            /** An object reference to a recipient */
            @JvmStatic
            fun ofObjectReference(objectReference: ObjectReference) =
                Recipient(objectReference = objectReference)
        }

        /**
         * An interface that defines how to map each variant of [Recipient] to a value of type [T].
         */
        interface Visitor<out T> {

            /** A user identifier */
            fun visitString(string: String): T

            /** An object reference to a recipient */
            fun visitObjectReference(objectReference: ObjectReference): T

            /**
             * Maps an unknown variant of [Recipient] to a value of type [T].
             *
             * An instance of [Recipient] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws KnockInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw KnockInvalidDataException("Unknown Recipient: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Recipient>(Recipient::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Recipient {
                val json = JsonValue.fromJsonNode(node)

                tryDeserialize(node, jacksonTypeRef<String>())?.let {
                    return Recipient(string = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<ObjectReference>())?.let {
                    return Recipient(objectReference = it, _json = json)
                }

                return Recipient(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Recipient>(Recipient::class) {

            override fun serialize(
                value: Recipient,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.string != null -> generator.writeObject(value.string)
                    value.objectReference != null -> generator.writeObject(value.objectReference)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Recipient")
                }
            }
        }

        /** An object reference to a recipient */
        class ObjectReference
        private constructor(private val id: String, private val collection: String) {

            /** An object identifier */
            fun id(): String = id

            /** The collection the object belongs to */
            fun collection(): String = collection

            @JvmSynthetic
            internal fun forEachQueryParam(putParam: (String, List<String>) -> Unit) {
                this.id.let { putParam("id", listOf(it.toString())) }
                this.collection.let { putParam("collection", listOf(it.toString())) }
                additionalProperties.keys().forEach {
                    putParam(it, additionalProperties.values(it))
                }
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [ObjectReference].
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * .collection()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ObjectReference]. */
            class Builder internal constructor() {

                private var id: String? = null
                private var collection: String? = null

                @JvmSynthetic
                internal fun from(objectReference: ObjectReference) = apply {
                    id = objectReference.id
                    collection = objectReference.collection
                }

                /** An object identifier */
                fun id(id: String) = apply { this.id = id }

                /** The collection the object belongs to */
                fun collection(collection: String) = apply { this.collection = collection }

                fun build(): ObjectReference =
                    ObjectReference(
                        checkRequired("id", id),
                        checkRequired("collection", collection),
                    )
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is ObjectReference && id == other.id && collection == other.collection /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(id, collection) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() = "ObjectReference{id=$id, collection=$collection}"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ObjectListSubscriptionsParams && collection == other.collection && objectId == other.objectId && after == other.after && before == other.before && mode == other.mode && objects == other.objects && pageSize == other.pageSize && recipients == other.recipients && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(collection, objectId, after, before, mode, objects, pageSize, recipients, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "ObjectListSubscriptionsParams{collection=$collection, objectId=$objectId, after=$after, before=$before, mode=$mode, objects=$objects, pageSize=$pageSize, recipients=$recipients, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
