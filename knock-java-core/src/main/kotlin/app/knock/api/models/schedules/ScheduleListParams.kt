// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.schedules

import app.knock.api.core.BaseDeserializer
import app.knock.api.core.BaseSerializer
import app.knock.api.core.JsonValue
import app.knock.api.core.NoAutoDetect
import app.knock.api.core.Params
import app.knock.api.core.checkRequired
import app.knock.api.core.getOrThrow
import app.knock.api.core.http.Headers
import app.knock.api.core.http.QueryParams
import app.knock.api.core.toImmutable
import app.knock.api.errors.KnockInvalidDataException
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

/** List schedules */
class ScheduleListParams
private constructor(
    private val workflow: String,
    private val after: String?,
    private val before: String?,
    private val pageSize: Long?,
    private val recipients: List<Recipient>?,
    private val tenant: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /** Filter by workflow */
    fun workflow(): String = workflow

    /** The cursor to fetch entries after */
    fun after(): Optional<String> = Optional.ofNullable(after)

    /** The cursor to fetch entries before */
    fun before(): Optional<String> = Optional.ofNullable(before)

    /** The page size to fetch */
    fun pageSize(): Optional<Long> = Optional.ofNullable(pageSize)

    /** Filter by recipient */
    fun recipients(): Optional<List<Recipient>> = Optional.ofNullable(recipients)

    /** Filter by tenant */
    fun tenant(): Optional<String> = Optional.ofNullable(tenant)

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams {
        val queryParams = QueryParams.builder()
        this.workflow.let { queryParams.put("workflow", listOf(it.toString())) }
        this.after?.let { queryParams.put("after", listOf(it.toString())) }
        this.before?.let { queryParams.put("before", listOf(it.toString())) }
        this.pageSize?.let { queryParams.put("page_size", listOf(it.toString())) }
        this.recipients?.let { queryParams.put("recipients[]", it.map(Any::toString)) }
        this.tenant?.let { queryParams.put("tenant", listOf(it.toString())) }
        queryParams.putAll(additionalQueryParams)
        return queryParams.build()
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ScheduleListParams].
         *
         * The following fields are required:
         * ```java
         * .workflow()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ScheduleListParams]. */
    @NoAutoDetect
    class Builder internal constructor() {

        private var workflow: String? = null
        private var after: String? = null
        private var before: String? = null
        private var pageSize: Long? = null
        private var recipients: MutableList<Recipient>? = null
        private var tenant: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(scheduleListParams: ScheduleListParams) = apply {
            workflow = scheduleListParams.workflow
            after = scheduleListParams.after
            before = scheduleListParams.before
            pageSize = scheduleListParams.pageSize
            recipients = scheduleListParams.recipients?.toMutableList()
            tenant = scheduleListParams.tenant
            additionalHeaders = scheduleListParams.additionalHeaders.toBuilder()
            additionalQueryParams = scheduleListParams.additionalQueryParams.toBuilder()
        }

        /** Filter by workflow */
        fun workflow(workflow: String) = apply { this.workflow = workflow }

        /** The cursor to fetch entries after */
        fun after(after: String?) = apply { this.after = after }

        /** Alias for calling [Builder.after] with `after.orElse(null)`. */
        fun after(after: Optional<String>) = after(after.getOrNull())

        /** The cursor to fetch entries before */
        fun before(before: String?) = apply { this.before = before }

        /** Alias for calling [Builder.before] with `before.orElse(null)`. */
        fun before(before: Optional<String>) = before(before.getOrNull())

        /** The page size to fetch */
        fun pageSize(pageSize: Long?) = apply { this.pageSize = pageSize }

        /**
         * Alias for [Builder.pageSize].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun pageSize(pageSize: Long) = pageSize(pageSize as Long?)

        /** Alias for calling [Builder.pageSize] with `pageSize.orElse(null)`. */
        fun pageSize(pageSize: Optional<Long>) = pageSize(pageSize.getOrNull())

        /** Filter by recipient */
        fun recipients(recipients: List<Recipient>?) = apply {
            this.recipients = recipients?.toMutableList()
        }

        /** Alias for calling [Builder.recipients] with `recipients.orElse(null)`. */
        fun recipients(recipients: Optional<List<Recipient>>) = recipients(recipients.getOrNull())

        /**
         * Adds a single [Recipient] to [recipients].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addRecipient(recipient: Recipient) = apply {
            recipients = (recipients ?: mutableListOf()).apply { add(recipient) }
        }

        /** Alias for calling [addRecipient] with `Recipient.ofString(string)`. */
        fun addRecipient(string: String) = addRecipient(Recipient.ofString(string))

        /** Alias for calling [addRecipient] with `Recipient.ofObjectReference(objectReference)`. */
        fun addRecipient(objectReference: Recipient.ObjectReference) =
            addRecipient(Recipient.ofObjectReference(objectReference))

        /** Filter by tenant */
        fun tenant(tenant: String?) = apply { this.tenant = tenant }

        /** Alias for calling [Builder.tenant] with `tenant.orElse(null)`. */
        fun tenant(tenant: Optional<String>) = tenant(tenant.getOrNull())

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

        fun build(): ScheduleListParams =
            ScheduleListParams(
                checkRequired("workflow", workflow),
                after,
                before,
                pageSize,
                recipients?.toImmutable(),
                tenant,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
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

        return /* spotless:off */ other is ScheduleListParams && workflow == other.workflow && after == other.after && before == other.before && pageSize == other.pageSize && recipients == other.recipients && tenant == other.tenant && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(workflow, after, before, pageSize, recipients, tenant, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "ScheduleListParams{workflow=$workflow, after=$after, before=$before, pageSize=$pageSize, recipients=$recipients, tenant=$tenant, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
