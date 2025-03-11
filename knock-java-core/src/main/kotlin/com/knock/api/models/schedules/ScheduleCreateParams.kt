// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models.schedules

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
import com.knock.api.core.ExcludeMissing
import com.knock.api.core.JsonField
import com.knock.api.core.JsonMissing
import com.knock.api.core.JsonValue
import com.knock.api.core.NoAutoDetect
import com.knock.api.core.Params
import com.knock.api.core.checkKnown
import com.knock.api.core.checkRequired
import com.knock.api.core.getOrThrow
import com.knock.api.core.http.Headers
import com.knock.api.core.http.QueryParams
import com.knock.api.core.immutableEmptyMap
import com.knock.api.core.toImmutable
import com.knock.api.errors.KnockInvalidDataException
import com.knock.api.models.tenants.InlineTenantRequest
import com.knock.api.models.tenants.TenantRequest
import java.time.OffsetDateTime
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Create schedules */
class ScheduleCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun recipients(): List<Recipient> = body.recipients()

    fun repeats(): List<ScheduleRepeatRule> = body.repeats()

    fun workflow(): String = body.workflow()

    fun data(): Optional<Data> = body.data()

    fun endingAt(): Optional<OffsetDateTime> = body.endingAt()

    fun scheduledAt(): Optional<OffsetDateTime> = body.scheduledAt()

    /** An inline tenant request */
    fun tenant(): Optional<InlineTenantRequest> = body.tenant()

    fun _recipients(): JsonField<List<Recipient>> = body._recipients()

    fun _repeats(): JsonField<List<ScheduleRepeatRule>> = body._repeats()

    fun _workflow(): JsonField<String> = body._workflow()

    fun _data(): JsonField<Data> = body._data()

    fun _endingAt(): JsonField<OffsetDateTime> = body._endingAt()

    fun _scheduledAt(): JsonField<OffsetDateTime> = body._scheduledAt()

    /** An inline tenant request */
    fun _tenant(): JsonField<InlineTenantRequest> = body._tenant()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    @JvmSynthetic internal fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /** A request to create schedules */
    @NoAutoDetect
    class Body
    @JsonCreator
    private constructor(
        @JsonProperty("recipients")
        @ExcludeMissing
        private val recipients: JsonField<List<Recipient>> = JsonMissing.of(),
        @JsonProperty("repeats")
        @ExcludeMissing
        private val repeats: JsonField<List<ScheduleRepeatRule>> = JsonMissing.of(),
        @JsonProperty("workflow")
        @ExcludeMissing
        private val workflow: JsonField<String> = JsonMissing.of(),
        @JsonProperty("data") @ExcludeMissing private val data: JsonField<Data> = JsonMissing.of(),
        @JsonProperty("ending_at")
        @ExcludeMissing
        private val endingAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("scheduled_at")
        @ExcludeMissing
        private val scheduledAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("tenant")
        @ExcludeMissing
        private val tenant: JsonField<InlineTenantRequest> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun recipients(): List<Recipient> = recipients.getRequired("recipients")

        fun repeats(): List<ScheduleRepeatRule> = repeats.getRequired("repeats")

        fun workflow(): String = workflow.getRequired("workflow")

        fun data(): Optional<Data> = Optional.ofNullable(data.getNullable("data"))

        fun endingAt(): Optional<OffsetDateTime> =
            Optional.ofNullable(endingAt.getNullable("ending_at"))

        fun scheduledAt(): Optional<OffsetDateTime> =
            Optional.ofNullable(scheduledAt.getNullable("scheduled_at"))

        /** An inline tenant request */
        fun tenant(): Optional<InlineTenantRequest> =
            Optional.ofNullable(tenant.getNullable("tenant"))

        @JsonProperty("recipients")
        @ExcludeMissing
        fun _recipients(): JsonField<List<Recipient>> = recipients

        @JsonProperty("repeats")
        @ExcludeMissing
        fun _repeats(): JsonField<List<ScheduleRepeatRule>> = repeats

        @JsonProperty("workflow") @ExcludeMissing fun _workflow(): JsonField<String> = workflow

        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Data> = data

        @JsonProperty("ending_at")
        @ExcludeMissing
        fun _endingAt(): JsonField<OffsetDateTime> = endingAt

        @JsonProperty("scheduled_at")
        @ExcludeMissing
        fun _scheduledAt(): JsonField<OffsetDateTime> = scheduledAt

        /** An inline tenant request */
        @JsonProperty("tenant")
        @ExcludeMissing
        fun _tenant(): JsonField<InlineTenantRequest> = tenant

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            recipients().forEach { it.validate() }
            repeats().forEach { it.validate() }
            workflow()
            data().ifPresent { it.validate() }
            endingAt()
            scheduledAt()
            tenant().ifPresent { it.validate() }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .recipients()
             * .repeats()
             * .workflow()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var recipients: JsonField<MutableList<Recipient>>? = null
            private var repeats: JsonField<MutableList<ScheduleRepeatRule>>? = null
            private var workflow: JsonField<String>? = null
            private var data: JsonField<Data> = JsonMissing.of()
            private var endingAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var scheduledAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var tenant: JsonField<InlineTenantRequest> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                recipients = body.recipients.map { it.toMutableList() }
                repeats = body.repeats.map { it.toMutableList() }
                workflow = body.workflow
                data = body.data
                endingAt = body.endingAt
                scheduledAt = body.scheduledAt
                tenant = body.tenant
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            fun recipients(recipients: List<Recipient>) = recipients(JsonField.of(recipients))

            fun recipients(recipients: JsonField<List<Recipient>>) = apply {
                this.recipients = recipients.map { it.toMutableList() }
            }

            fun addRecipient(recipient: Recipient) = apply {
                recipients =
                    (recipients ?: JsonField.of(mutableListOf())).also {
                        checkKnown("recipients", it).add(recipient)
                    }
            }

            /** A user identifier */
            fun addRecipient(string: String) = addRecipient(Recipient.ofString(string))

            /** An object reference to a recipient */
            fun addRecipient(objectReference: Recipient.ObjectReference) =
                addRecipient(Recipient.ofObjectReference(objectReference))

            fun repeats(repeats: List<ScheduleRepeatRule>) = repeats(JsonField.of(repeats))

            fun repeats(repeats: JsonField<List<ScheduleRepeatRule>>) = apply {
                this.repeats = repeats.map { it.toMutableList() }
            }

            fun addRepeat(repeat: ScheduleRepeatRule) = apply {
                repeats =
                    (repeats ?: JsonField.of(mutableListOf())).also {
                        checkKnown("repeats", it).add(repeat)
                    }
            }

            fun workflow(workflow: String) = workflow(JsonField.of(workflow))

            fun workflow(workflow: JsonField<String>) = apply { this.workflow = workflow }

            fun data(data: Data?) = data(JsonField.ofNullable(data))

            fun data(data: Optional<Data>) = data(data.getOrNull())

            fun data(data: JsonField<Data>) = apply { this.data = data }

            fun endingAt(endingAt: OffsetDateTime?) = endingAt(JsonField.ofNullable(endingAt))

            fun endingAt(endingAt: Optional<OffsetDateTime>) = endingAt(endingAt.getOrNull())

            fun endingAt(endingAt: JsonField<OffsetDateTime>) = apply { this.endingAt = endingAt }

            fun scheduledAt(scheduledAt: OffsetDateTime?) =
                scheduledAt(JsonField.ofNullable(scheduledAt))

            fun scheduledAt(scheduledAt: Optional<OffsetDateTime>) =
                scheduledAt(scheduledAt.getOrNull())

            fun scheduledAt(scheduledAt: JsonField<OffsetDateTime>) = apply {
                this.scheduledAt = scheduledAt
            }

            /** An inline tenant request */
            fun tenant(tenant: InlineTenantRequest?) = tenant(JsonField.ofNullable(tenant))

            /** An inline tenant request */
            fun tenant(tenant: Optional<InlineTenantRequest>) = tenant(tenant.getOrNull())

            /** An inline tenant request */
            fun tenant(tenant: JsonField<InlineTenantRequest>) = apply { this.tenant = tenant }

            /** A tenant identifier */
            fun tenant(string: String) = tenant(InlineTenantRequest.ofString(string))

            /** A tenant to be set in the system */
            fun tenant(tenantRequest: TenantRequest) =
                tenant(InlineTenantRequest.ofTenantRequest(tenantRequest))

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

            fun build(): Body =
                Body(
                    checkRequired("recipients", recipients).map { it.toImmutable() },
                    checkRequired("repeats", repeats).map { it.toImmutable() },
                    checkRequired("workflow", workflow),
                    data,
                    endingAt,
                    scheduledAt,
                    tenant,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && recipients == other.recipients && repeats == other.repeats && workflow == other.workflow && data == other.data && endingAt == other.endingAt && scheduledAt == other.scheduledAt && tenant == other.tenant && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(recipients, repeats, workflow, data, endingAt, scheduledAt, tenant, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{recipients=$recipients, repeats=$repeats, workflow=$workflow, data=$data, endingAt=$endingAt, scheduledAt=$scheduledAt, tenant=$tenant, additionalProperties=$additionalProperties}"
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ScheduleCreateParams].
         *
         * The following fields are required:
         * ```java
         * .recipients()
         * .repeats()
         * .workflow()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ScheduleCreateParams]. */
    @NoAutoDetect
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(scheduleCreateParams: ScheduleCreateParams) = apply {
            body = scheduleCreateParams.body.toBuilder()
            additionalHeaders = scheduleCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = scheduleCreateParams.additionalQueryParams.toBuilder()
        }

        fun recipients(recipients: List<Recipient>) = apply { body.recipients(recipients) }

        fun recipients(recipients: JsonField<List<Recipient>>) = apply {
            body.recipients(recipients)
        }

        fun addRecipient(recipient: Recipient) = apply { body.addRecipient(recipient) }

        /** A user identifier */
        fun addRecipient(string: String) = apply { body.addRecipient(string) }

        /** An object reference to a recipient */
        fun addRecipient(objectReference: Recipient.ObjectReference) = apply {
            body.addRecipient(objectReference)
        }

        fun repeats(repeats: List<ScheduleRepeatRule>) = apply { body.repeats(repeats) }

        fun repeats(repeats: JsonField<List<ScheduleRepeatRule>>) = apply { body.repeats(repeats) }

        fun addRepeat(repeat: ScheduleRepeatRule) = apply { body.addRepeat(repeat) }

        fun workflow(workflow: String) = apply { body.workflow(workflow) }

        fun workflow(workflow: JsonField<String>) = apply { body.workflow(workflow) }

        fun data(data: Data?) = apply { body.data(data) }

        fun data(data: Optional<Data>) = data(data.getOrNull())

        fun data(data: JsonField<Data>) = apply { body.data(data) }

        fun endingAt(endingAt: OffsetDateTime?) = apply { body.endingAt(endingAt) }

        fun endingAt(endingAt: Optional<OffsetDateTime>) = endingAt(endingAt.getOrNull())

        fun endingAt(endingAt: JsonField<OffsetDateTime>) = apply { body.endingAt(endingAt) }

        fun scheduledAt(scheduledAt: OffsetDateTime?) = apply { body.scheduledAt(scheduledAt) }

        fun scheduledAt(scheduledAt: Optional<OffsetDateTime>) =
            scheduledAt(scheduledAt.getOrNull())

        fun scheduledAt(scheduledAt: JsonField<OffsetDateTime>) = apply {
            body.scheduledAt(scheduledAt)
        }

        /** An inline tenant request */
        fun tenant(tenant: InlineTenantRequest?) = apply { body.tenant(tenant) }

        /** An inline tenant request */
        fun tenant(tenant: Optional<InlineTenantRequest>) = tenant(tenant.getOrNull())

        /** An inline tenant request */
        fun tenant(tenant: JsonField<InlineTenantRequest>) = apply { body.tenant(tenant) }

        /** A tenant identifier */
        fun tenant(string: String) = apply { body.tenant(string) }

        /** A tenant to be set in the system */
        fun tenant(tenantRequest: TenantRequest) = apply { body.tenant(tenantRequest) }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

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

        fun build(): ScheduleCreateParams =
            ScheduleCreateParams(
                body.build(),
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

        private var validated: Boolean = false

        fun validate(): Recipient = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitString(string: String) {}

                    override fun visitObjectReference(objectReference: ObjectReference) {
                        objectReference.validate()
                    }
                }
            )
            validated = true
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
                tryDeserialize(node, jacksonTypeRef<ObjectReference>()) { it.validate() }
                    ?.let {
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
        @NoAutoDetect
        class ObjectReference
        @JsonCreator
        private constructor(
            @JsonProperty("id")
            @ExcludeMissing
            private val id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("collection")
            @ExcludeMissing
            private val collection: JsonField<String> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /** An object identifier */
            fun id(): String = id.getRequired("id")

            /** The collection the object belongs to */
            fun collection(): String = collection.getRequired("collection")

            /** An object identifier */
            @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

            /** The collection the object belongs to */
            @JsonProperty("collection")
            @ExcludeMissing
            fun _collection(): JsonField<String> = collection

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): ObjectReference = apply {
                if (validated) {
                    return@apply
                }

                id()
                collection()
                validated = true
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

                private var id: JsonField<String>? = null
                private var collection: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(objectReference: ObjectReference) = apply {
                    id = objectReference.id
                    collection = objectReference.collection
                    additionalProperties = objectReference.additionalProperties.toMutableMap()
                }

                /** An object identifier */
                fun id(id: String) = id(JsonField.of(id))

                /** An object identifier */
                fun id(id: JsonField<String>) = apply { this.id = id }

                /** The collection the object belongs to */
                fun collection(collection: String) = collection(JsonField.of(collection))

                /** The collection the object belongs to */
                fun collection(collection: JsonField<String>) = apply {
                    this.collection = collection
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

                fun build(): ObjectReference =
                    ObjectReference(
                        checkRequired("id", id),
                        checkRequired("collection", collection),
                        additionalProperties.toImmutable(),
                    )
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is ObjectReference && id == other.id && collection == other.collection && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(id, collection, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ObjectReference{id=$id, collection=$collection, additionalProperties=$additionalProperties}"
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ScheduleCreateParams && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "ScheduleCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
