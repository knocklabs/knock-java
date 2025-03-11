// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.schedules

import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.NoAutoDetect
import app.knock.api.core.Params
import app.knock.api.core.checkKnown
import app.knock.api.core.checkRequired
import app.knock.api.core.http.Headers
import app.knock.api.core.http.QueryParams
import app.knock.api.core.immutableEmptyMap
import app.knock.api.core.toImmutable
import app.knock.api.models.objects.InlineObjectRequest
import app.knock.api.models.recipients.RecipientRequest
import app.knock.api.models.tenants.InlineTenantRequest
import app.knock.api.models.tenants.TenantRequest
import app.knock.api.models.users.InlineIdentifyUserRequest
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.OffsetDateTime
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Update schedules */
class ScheduleUpdateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun scheduleIds(): List<String> = body.scheduleIds()

    /**
     * Specifies a recipient in a request. This can either be a user identifier (string), an inline
     * user request (object), or an inline object request, which is determined by the presence of a
     * `collection` property.
     */
    fun actor(): Optional<RecipientRequest> = body.actor()

    fun data(): Optional<Data> = body.data()

    fun endingAt(): Optional<OffsetDateTime> = body.endingAt()

    fun repeats(): Optional<List<ScheduleRepeatRule>> = body.repeats()

    fun scheduledAt(): Optional<OffsetDateTime> = body.scheduledAt()

    /** An inline tenant request */
    fun tenant(): Optional<InlineTenantRequest> = body.tenant()

    fun _scheduleIds(): JsonField<List<String>> = body._scheduleIds()

    /**
     * Specifies a recipient in a request. This can either be a user identifier (string), an inline
     * user request (object), or an inline object request, which is determined by the presence of a
     * `collection` property.
     */
    fun _actor(): JsonField<RecipientRequest> = body._actor()

    fun _data(): JsonField<Data> = body._data()

    fun _endingAt(): JsonField<OffsetDateTime> = body._endingAt()

    fun _repeats(): JsonField<List<ScheduleRepeatRule>> = body._repeats()

    fun _scheduledAt(): JsonField<OffsetDateTime> = body._scheduledAt()

    /** An inline tenant request */
    fun _tenant(): JsonField<InlineTenantRequest> = body._tenant()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    @JvmSynthetic internal fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /** A request to update schedules */
    @NoAutoDetect
    class Body
    @JsonCreator
    private constructor(
        @JsonProperty("schedule_ids")
        @ExcludeMissing
        private val scheduleIds: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("actor")
        @ExcludeMissing
        private val actor: JsonField<RecipientRequest> = JsonMissing.of(),
        @JsonProperty("data") @ExcludeMissing private val data: JsonField<Data> = JsonMissing.of(),
        @JsonProperty("ending_at")
        @ExcludeMissing
        private val endingAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("repeats")
        @ExcludeMissing
        private val repeats: JsonField<List<ScheduleRepeatRule>> = JsonMissing.of(),
        @JsonProperty("scheduled_at")
        @ExcludeMissing
        private val scheduledAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("tenant")
        @ExcludeMissing
        private val tenant: JsonField<InlineTenantRequest> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun scheduleIds(): List<String> = scheduleIds.getRequired("schedule_ids")

        /**
         * Specifies a recipient in a request. This can either be a user identifier (string), an
         * inline user request (object), or an inline object request, which is determined by the
         * presence of a `collection` property.
         */
        fun actor(): Optional<RecipientRequest> = Optional.ofNullable(actor.getNullable("actor"))

        fun data(): Optional<Data> = Optional.ofNullable(data.getNullable("data"))

        fun endingAt(): Optional<OffsetDateTime> =
            Optional.ofNullable(endingAt.getNullable("ending_at"))

        fun repeats(): Optional<List<ScheduleRepeatRule>> =
            Optional.ofNullable(repeats.getNullable("repeats"))

        fun scheduledAt(): Optional<OffsetDateTime> =
            Optional.ofNullable(scheduledAt.getNullable("scheduled_at"))

        /** An inline tenant request */
        fun tenant(): Optional<InlineTenantRequest> =
            Optional.ofNullable(tenant.getNullable("tenant"))

        @JsonProperty("schedule_ids")
        @ExcludeMissing
        fun _scheduleIds(): JsonField<List<String>> = scheduleIds

        /**
         * Specifies a recipient in a request. This can either be a user identifier (string), an
         * inline user request (object), or an inline object request, which is determined by the
         * presence of a `collection` property.
         */
        @JsonProperty("actor") @ExcludeMissing fun _actor(): JsonField<RecipientRequest> = actor

        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Data> = data

        @JsonProperty("ending_at")
        @ExcludeMissing
        fun _endingAt(): JsonField<OffsetDateTime> = endingAt

        @JsonProperty("repeats")
        @ExcludeMissing
        fun _repeats(): JsonField<List<ScheduleRepeatRule>> = repeats

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

            scheduleIds()
            actor().ifPresent { it.validate() }
            data().ifPresent { it.validate() }
            endingAt()
            repeats().ifPresent { it.forEach { it.validate() } }
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
             * .scheduleIds()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var scheduleIds: JsonField<MutableList<String>>? = null
            private var actor: JsonField<RecipientRequest> = JsonMissing.of()
            private var data: JsonField<Data> = JsonMissing.of()
            private var endingAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var repeats: JsonField<MutableList<ScheduleRepeatRule>>? = null
            private var scheduledAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var tenant: JsonField<InlineTenantRequest> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                scheduleIds = body.scheduleIds.map { it.toMutableList() }
                actor = body.actor
                data = body.data
                endingAt = body.endingAt
                repeats = body.repeats.map { it.toMutableList() }
                scheduledAt = body.scheduledAt
                tenant = body.tenant
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            fun scheduleIds(scheduleIds: List<String>) = scheduleIds(JsonField.of(scheduleIds))

            fun scheduleIds(scheduleIds: JsonField<List<String>>) = apply {
                this.scheduleIds = scheduleIds.map { it.toMutableList() }
            }

            fun addScheduleId(scheduleId: String) = apply {
                scheduleIds =
                    (scheduleIds ?: JsonField.of(mutableListOf())).also {
                        checkKnown("scheduleIds", it).add(scheduleId)
                    }
            }

            /**
             * Specifies a recipient in a request. This can either be a user identifier (string), an
             * inline user request (object), or an inline object request, which is determined by the
             * presence of a `collection` property.
             */
            fun actor(actor: RecipientRequest?) = actor(JsonField.ofNullable(actor))

            /**
             * Specifies a recipient in a request. This can either be a user identifier (string), an
             * inline user request (object), or an inline object request, which is determined by the
             * presence of a `collection` property.
             */
            fun actor(actor: Optional<RecipientRequest>) = actor(actor.getOrNull())

            /**
             * Specifies a recipient in a request. This can either be a user identifier (string), an
             * inline user request (object), or an inline object request, which is determined by the
             * presence of a `collection` property.
             */
            fun actor(actor: JsonField<RecipientRequest>) = apply { this.actor = actor }

            /** A user identifier */
            fun actor(string: String) = actor(RecipientRequest.ofString(string))

            /**
             * A set of parameters to inline-identify a user with. Inline identifying the user will
             * ensure that the user is available before the request is executed in Knock. It will
             * perform an upsert against the user you're supplying, replacing any properties
             * specified.
             */
            fun actor(inlineIdentifyUser: InlineIdentifyUserRequest) =
                actor(RecipientRequest.ofInlineIdentifyUser(inlineIdentifyUser))

            /** Inline identifies a custom object belonging to a collection */
            fun actor(inlineObject: InlineObjectRequest) =
                actor(RecipientRequest.ofInlineObject(inlineObject))

            fun data(data: Data?) = data(JsonField.ofNullable(data))

            fun data(data: Optional<Data>) = data(data.getOrNull())

            fun data(data: JsonField<Data>) = apply { this.data = data }

            fun endingAt(endingAt: OffsetDateTime?) = endingAt(JsonField.ofNullable(endingAt))

            fun endingAt(endingAt: Optional<OffsetDateTime>) = endingAt(endingAt.getOrNull())

            fun endingAt(endingAt: JsonField<OffsetDateTime>) = apply { this.endingAt = endingAt }

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
                    checkRequired("scheduleIds", scheduleIds).map { it.toImmutable() },
                    actor,
                    data,
                    endingAt,
                    (repeats ?: JsonMissing.of()).map { it.toImmutable() },
                    scheduledAt,
                    tenant,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && scheduleIds == other.scheduleIds && actor == other.actor && data == other.data && endingAt == other.endingAt && repeats == other.repeats && scheduledAt == other.scheduledAt && tenant == other.tenant && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(scheduleIds, actor, data, endingAt, repeats, scheduledAt, tenant, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{scheduleIds=$scheduleIds, actor=$actor, data=$data, endingAt=$endingAt, repeats=$repeats, scheduledAt=$scheduledAt, tenant=$tenant, additionalProperties=$additionalProperties}"
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ScheduleUpdateParams].
         *
         * The following fields are required:
         * ```java
         * .scheduleIds()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ScheduleUpdateParams]. */
    @NoAutoDetect
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(scheduleUpdateParams: ScheduleUpdateParams) = apply {
            body = scheduleUpdateParams.body.toBuilder()
            additionalHeaders = scheduleUpdateParams.additionalHeaders.toBuilder()
            additionalQueryParams = scheduleUpdateParams.additionalQueryParams.toBuilder()
        }

        fun scheduleIds(scheduleIds: List<String>) = apply { body.scheduleIds(scheduleIds) }

        fun scheduleIds(scheduleIds: JsonField<List<String>>) = apply {
            body.scheduleIds(scheduleIds)
        }

        fun addScheduleId(scheduleId: String) = apply { body.addScheduleId(scheduleId) }

        /**
         * Specifies a recipient in a request. This can either be a user identifier (string), an
         * inline user request (object), or an inline object request, which is determined by the
         * presence of a `collection` property.
         */
        fun actor(actor: RecipientRequest?) = apply { body.actor(actor) }

        /**
         * Specifies a recipient in a request. This can either be a user identifier (string), an
         * inline user request (object), or an inline object request, which is determined by the
         * presence of a `collection` property.
         */
        fun actor(actor: Optional<RecipientRequest>) = actor(actor.getOrNull())

        /**
         * Specifies a recipient in a request. This can either be a user identifier (string), an
         * inline user request (object), or an inline object request, which is determined by the
         * presence of a `collection` property.
         */
        fun actor(actor: JsonField<RecipientRequest>) = apply { body.actor(actor) }

        /** A user identifier */
        fun actor(string: String) = apply { body.actor(string) }

        /**
         * A set of parameters to inline-identify a user with. Inline identifying the user will
         * ensure that the user is available before the request is executed in Knock. It will
         * perform an upsert against the user you're supplying, replacing any properties specified.
         */
        fun actor(inlineIdentifyUser: InlineIdentifyUserRequest) = apply {
            body.actor(inlineIdentifyUser)
        }

        /** Inline identifies a custom object belonging to a collection */
        fun actor(inlineObject: InlineObjectRequest) = apply { body.actor(inlineObject) }

        fun data(data: Data?) = apply { body.data(data) }

        fun data(data: Optional<Data>) = data(data.getOrNull())

        fun data(data: JsonField<Data>) = apply { body.data(data) }

        fun endingAt(endingAt: OffsetDateTime?) = apply { body.endingAt(endingAt) }

        fun endingAt(endingAt: Optional<OffsetDateTime>) = endingAt(endingAt.getOrNull())

        fun endingAt(endingAt: JsonField<OffsetDateTime>) = apply { body.endingAt(endingAt) }

        fun repeats(repeats: List<ScheduleRepeatRule>) = apply { body.repeats(repeats) }

        fun repeats(repeats: JsonField<List<ScheduleRepeatRule>>) = apply { body.repeats(repeats) }

        fun addRepeat(repeat: ScheduleRepeatRule) = apply { body.addRepeat(repeat) }

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

        fun build(): ScheduleUpdateParams =
            ScheduleUpdateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
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

        return /* spotless:off */ other is ScheduleUpdateParams && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "ScheduleUpdateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
