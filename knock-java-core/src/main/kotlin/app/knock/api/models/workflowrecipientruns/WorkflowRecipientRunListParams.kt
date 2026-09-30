// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.workflowrecipientruns

import app.knock.api.core.Enum
import app.knock.api.core.JsonField
import app.knock.api.core.JsonValue
import app.knock.api.core.Params
import app.knock.api.core.http.Headers
import app.knock.api.core.http.QueryParams
import app.knock.api.core.toImmutable
import app.knock.api.errors.KnockInvalidDataException
import app.knock.api.lib.putQueryObject
import app.knock.api.lib.toQueryArrayElement
import app.knock.api.models.recipients.RecipientReference
import com.fasterxml.jackson.annotation.JsonCreator
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Returns a paginated list of workflow recipient runs for the current environment. */
class WorkflowRecipientRunListParams
private constructor(
    private val after: String?,
    private val before: String?,
    private val endingAt: OffsetDateTime?,
    private val hasErrors: Boolean?,
    private val pageSize: Long?,
    private val recipient: RecipientReference?,
    private val startingAt: OffsetDateTime?,
    private val status: List<Status>?,
    private val tenant: String?,
    private val workflow: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /** The cursor to fetch entries after. */
    fun after(): Optional<String> = Optional.ofNullable(after)

    /** The cursor to fetch entries before. */
    fun before(): Optional<String> = Optional.ofNullable(before)

    /** Limits the results to workflow recipient runs started before the given date. */
    fun endingAt(): Optional<OffsetDateTime> = Optional.ofNullable(endingAt)

    /** Limits the results to workflow recipient runs that have errors. */
    fun hasErrors(): Optional<Boolean> = Optional.ofNullable(hasErrors)

    /** The number of items per page (defaults to 50). */
    fun pageSize(): Optional<Long> = Optional.ofNullable(pageSize)

    /**
     * Limits the results to workflow recipient runs for the given recipient. Accepts a user ID
     * string or an object reference with `id` and `collection`.
     */
    fun recipient(): Optional<RecipientReference> = Optional.ofNullable(recipient)

    /** Limits the results to workflow recipient runs started after the given date. */
    fun startingAt(): Optional<OffsetDateTime> = Optional.ofNullable(startingAt)

    /** Limits the results to workflow recipient runs with the given status. */
    fun status(): Optional<List<Status>> = Optional.ofNullable(status)

    /** Limits the results to workflow recipient runs for the given tenant. */
    fun tenant(): Optional<String> = Optional.ofNullable(tenant)

    /** Limits the results to workflow recipient runs for the given workflow key. */
    fun workflow(): Optional<String> = Optional.ofNullable(workflow)

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): WorkflowRecipientRunListParams = builder().build()

        /**
         * Returns a mutable builder for constructing an instance of
         * [WorkflowRecipientRunListParams].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [WorkflowRecipientRunListParams]. */
    class Builder internal constructor() {

        private var after: String? = null
        private var before: String? = null
        private var endingAt: OffsetDateTime? = null
        private var hasErrors: Boolean? = null
        private var pageSize: Long? = null
        private var recipient: RecipientReference? = null
        private var startingAt: OffsetDateTime? = null
        private var status: MutableList<Status>? = null
        private var tenant: String? = null
        private var workflow: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(workflowRecipientRunListParams: WorkflowRecipientRunListParams) = apply {
            after = workflowRecipientRunListParams.after
            before = workflowRecipientRunListParams.before
            endingAt = workflowRecipientRunListParams.endingAt
            hasErrors = workflowRecipientRunListParams.hasErrors
            pageSize = workflowRecipientRunListParams.pageSize
            recipient = workflowRecipientRunListParams.recipient
            startingAt = workflowRecipientRunListParams.startingAt
            status = workflowRecipientRunListParams.status?.toMutableList()
            tenant = workflowRecipientRunListParams.tenant
            workflow = workflowRecipientRunListParams.workflow
            additionalHeaders = workflowRecipientRunListParams.additionalHeaders.toBuilder()
            additionalQueryParams = workflowRecipientRunListParams.additionalQueryParams.toBuilder()
        }

        /** The cursor to fetch entries after. */
        fun after(after: String?) = apply { this.after = after }

        /** Alias for calling [Builder.after] with `after.orElse(null)`. */
        fun after(after: Optional<String>) = after(after.getOrNull())

        /** The cursor to fetch entries before. */
        fun before(before: String?) = apply { this.before = before }

        /** Alias for calling [Builder.before] with `before.orElse(null)`. */
        fun before(before: Optional<String>) = before(before.getOrNull())

        /** Limits the results to workflow recipient runs started before the given date. */
        fun endingAt(endingAt: OffsetDateTime?) = apply { this.endingAt = endingAt }

        /** Alias for calling [Builder.endingAt] with `endingAt.orElse(null)`. */
        fun endingAt(endingAt: Optional<OffsetDateTime>) = endingAt(endingAt.getOrNull())

        /** Limits the results to workflow recipient runs that have errors. */
        fun hasErrors(hasErrors: Boolean?) = apply { this.hasErrors = hasErrors }

        /**
         * Alias for [Builder.hasErrors].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun hasErrors(hasErrors: Boolean) = hasErrors(hasErrors as Boolean?)

        /** Alias for calling [Builder.hasErrors] with `hasErrors.orElse(null)`. */
        fun hasErrors(hasErrors: Optional<Boolean>) = hasErrors(hasErrors.getOrNull())

        /** The number of items per page (defaults to 50). */
        fun pageSize(pageSize: Long?) = apply { this.pageSize = pageSize }

        /**
         * Alias for [Builder.pageSize].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun pageSize(pageSize: Long) = pageSize(pageSize as Long?)

        /** Alias for calling [Builder.pageSize] with `pageSize.orElse(null)`. */
        fun pageSize(pageSize: Optional<Long>) = pageSize(pageSize.getOrNull())

        /**
         * Limits the results to workflow recipient runs for the given recipient. Accepts a user ID
         * string or an object reference with `id` and `collection`.
         */
        fun recipient(recipient: RecipientReference?) = apply { this.recipient = recipient }

        /** Alias for calling [Builder.recipient] with `recipient.orElse(null)`. */
        fun recipient(recipient: Optional<RecipientReference>) = recipient(recipient.getOrNull())

        /** Alias for calling [recipient] with `RecipientReference.ofUser(user)`. */
        fun recipient(user: String) = recipient(RecipientReference.ofUser(user))

        /**
         * Alias for calling [recipient] with
         * `RecipientReference.ofObjectReference(objectReference)`.
         */
        fun recipient(objectReference: RecipientReference.ObjectReference) =
            recipient(RecipientReference.ofObjectReference(objectReference))

        /** Limits the results to workflow recipient runs started after the given date. */
        fun startingAt(startingAt: OffsetDateTime?) = apply { this.startingAt = startingAt }

        /** Alias for calling [Builder.startingAt] with `startingAt.orElse(null)`. */
        fun startingAt(startingAt: Optional<OffsetDateTime>) = startingAt(startingAt.getOrNull())

        /** Limits the results to workflow recipient runs with the given status. */
        fun status(status: List<Status>?) = apply { this.status = status?.toMutableList() }

        /** Alias for calling [Builder.status] with `status.orElse(null)`. */
        fun status(status: Optional<List<Status>>) = status(status.getOrNull())

        /**
         * Adds a single [Status] to [Builder.status].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addStatus(status: Status) = apply {
            this.status = (this.status ?: mutableListOf()).apply { add(status) }
        }

        /** Limits the results to workflow recipient runs for the given tenant. */
        fun tenant(tenant: String?) = apply { this.tenant = tenant }

        /** Alias for calling [Builder.tenant] with `tenant.orElse(null)`. */
        fun tenant(tenant: Optional<String>) = tenant(tenant.getOrNull())

        /** Limits the results to workflow recipient runs for the given workflow key. */
        fun workflow(workflow: String?) = apply { this.workflow = workflow }

        /** Alias for calling [Builder.workflow] with `workflow.orElse(null)`. */
        fun workflow(workflow: Optional<String>) = workflow(workflow.getOrNull())

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

        /**
         * Returns an immutable instance of [WorkflowRecipientRunListParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): WorkflowRecipientRunListParams =
            WorkflowRecipientRunListParams(
                after,
                before,
                endingAt,
                hasErrors,
                pageSize,
                recipient,
                startingAt,
                status?.toImmutable(),
                tenant,
                workflow,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                after?.let { put("after", it) }
                before?.let { put("before", it) }
                endingAt?.let {
                    put("ending_at", DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(it))
                }
                hasErrors?.let { put("has_errors", it.toString()) }
                pageSize?.let { put("page_size", it.toString()) }
                recipient?.let { putQueryObject("recipient", it.toQueryArrayElement()) }
                startingAt?.let {
                    put("starting_at", DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(it))
                }
                status?.forEach { put("status[]", it.toString()) }
                tenant?.let { put("tenant", it) }
                workflow?.let { put("workflow", it) }
                putAll(additionalQueryParams)
            }
            .build()

    class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val QUEUED = of("queued")

            @JvmField val PROCESSING = of("processing")

            @JvmField val PAUSED = of("paused")

            @JvmField val COMPLETED = of("completed")

            @JvmField val CANCELLED = of("cancelled")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            QUEUED,
            PROCESSING,
            PAUSED,
            COMPLETED,
            CANCELLED,
        }

        /**
         * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Status] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            QUEUED,
            PROCESSING,
            PAUSED,
            COMPLETED,
            CANCELLED,
            /** An enum member indicating that [Status] was instantiated with an unknown value. */
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
                QUEUED -> Value.QUEUED
                PROCESSING -> Value.PROCESSING
                PAUSED -> Value.PAUSED
                COMPLETED -> Value.COMPLETED
                CANCELLED -> Value.CANCELLED
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
                QUEUED -> Known.QUEUED
                PROCESSING -> Known.PROCESSING
                PAUSED -> Known.PAUSED
                COMPLETED -> Known.COMPLETED
                CANCELLED -> Known.CANCELLED
                else -> throw KnockInvalidDataException("Unknown Status: $value")
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

        private var validated: Boolean = false

        fun validate(): Status = apply {
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

            return /* spotless:off */ other is Status && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is WorkflowRecipientRunListParams && after == other.after && before == other.before && endingAt == other.endingAt && hasErrors == other.hasErrors && pageSize == other.pageSize && recipient == other.recipient && startingAt == other.startingAt && status == other.status && tenant == other.tenant && workflow == other.workflow && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(after, before, endingAt, hasErrors, pageSize, recipient, startingAt, status, tenant, workflow, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "WorkflowRecipientRunListParams{after=$after, before=$before, endingAt=$endingAt, hasErrors=$hasErrors, pageSize=$pageSize, recipient=$recipient, startingAt=$startingAt, status=$status, tenant=$tenant, workflow=$workflow, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
