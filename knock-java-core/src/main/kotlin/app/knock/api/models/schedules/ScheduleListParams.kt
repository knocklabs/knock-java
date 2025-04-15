// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.schedules

import app.knock.api.core.Params
import app.knock.api.core.checkRequired
import app.knock.api.core.getOrThrow
import app.knock.api.core.http.Headers
import app.knock.api.core.http.QueryParams
import app.knock.api.core.toImmutable
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

        /** Alias for calling [addRecipient] with `Recipient.ofUnionMember1(unionMember1)`. */
        fun addRecipient(unionMember1: Recipient.UnionMember1) =
            addRecipient(Recipient.ofUnionMember1(unionMember1))

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

        /**
         * Returns an immutable instance of [ScheduleListParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .workflow()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
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

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                put("workflow", workflow)
                after?.let { put("after", it) }
                before?.let { put("before", it) }
                pageSize?.let { put("page_size", it.toString()) }
                recipients?.forEach {
                    it.accept(
                        object : Recipient.Visitor<Unit> {
                            override fun visitString(string: String) {
                                put("recipients[]", string)
                            }

                            override fun visitUnionMember1(unionMember1: Recipient.UnionMember1) {
                                put("recipients[][id]", unionMember1.id())
                                put("recipients[][collection]", unionMember1.collection())
                                unionMember1._additionalProperties().keys().forEach { key ->
                                    unionMember1._additionalProperties().values(key).forEach { value
                                        ->
                                        put("recipients[][$key]", value)
                                    }
                                }
                            }
                        }
                    )
                }
                tenant?.let { put("tenant", it) }
                putAll(additionalQueryParams)
            }
            .build()

    /**
     * A reference to a recipient, either a user identifier (string) or an object reference (id,
     * collection).
     */
    class Recipient
    private constructor(
        private val string: String? = null,
        private val unionMember1: UnionMember1? = null,
    ) {

        /** A user identifier */
        fun string(): Optional<String> = Optional.ofNullable(string)

        /** An object reference to a recipient */
        fun unionMember1(): Optional<UnionMember1> = Optional.ofNullable(unionMember1)

        fun isString(): Boolean = string != null

        fun isUnionMember1(): Boolean = unionMember1 != null

        /** A user identifier */
        fun asString(): String = string.getOrThrow("string")

        /** An object reference to a recipient */
        fun asUnionMember1(): UnionMember1 = unionMember1.getOrThrow("unionMember1")

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                string != null -> visitor.visitString(string)
                unionMember1 != null -> visitor.visitUnionMember1(unionMember1)
                else -> throw IllegalStateException("Invalid Recipient")
            }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Recipient && string == other.string && unionMember1 == other.unionMember1 /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(string, unionMember1) /* spotless:on */

        override fun toString(): String =
            when {
                string != null -> "Recipient{string=$string}"
                unionMember1 != null -> "Recipient{unionMember1=$unionMember1}"
                else -> throw IllegalStateException("Invalid Recipient")
            }

        companion object {

            /** A user identifier */
            @JvmStatic fun ofString(string: String) = Recipient(string = string)

            /** An object reference to a recipient */
            @JvmStatic
            fun ofUnionMember1(unionMember1: UnionMember1) = Recipient(unionMember1 = unionMember1)
        }

        /**
         * An interface that defines how to map each variant of [Recipient] to a value of type [T].
         */
        interface Visitor<out T> {

            /** A user identifier */
            fun visitString(string: String): T

            /** An object reference to a recipient */
            fun visitUnionMember1(unionMember1: UnionMember1): T
        }

        /** An object reference to a recipient */
        class UnionMember1
        private constructor(private val id: String, private val collection: String) {

            /** An object identifier */
            fun id(): String = id

            /** The collection the object belongs to */
            fun collection(): String = collection

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [UnionMember1].
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * .collection()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [UnionMember1]. */
            class Builder internal constructor() {

                private var id: String? = null
                private var collection: String? = null

                @JvmSynthetic
                internal fun from(unionMember1: UnionMember1) = apply {
                    id = unionMember1.id
                    collection = unionMember1.collection
                }

                /** An object identifier */
                fun id(id: String) = apply { this.id = id }

                /** The collection the object belongs to */
                fun collection(collection: String) = apply { this.collection = collection }

                /**
                 * Returns an immutable instance of [UnionMember1].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * .collection()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): UnionMember1 =
                    UnionMember1(checkRequired("id", id), checkRequired("collection", collection))
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is UnionMember1 && id == other.id && collection == other.collection /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(id, collection) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() = "UnionMember1{id=$id, collection=$collection}"
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
