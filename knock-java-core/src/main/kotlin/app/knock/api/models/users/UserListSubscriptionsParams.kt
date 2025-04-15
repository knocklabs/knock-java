// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.core.Params
import app.knock.api.core.checkRequired
import app.knock.api.core.getOrThrow
import app.knock.api.core.http.Headers
import app.knock.api.core.http.QueryParams
import app.knock.api.core.toImmutable
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** List subscriptions for a user */
class UserListSubscriptionsParams
private constructor(
    private val userId: String,
    private val after: String?,
    private val before: String?,
    private val objects: List<Object>?,
    private val pageSize: Long?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun userId(): String = userId

    /** The cursor to fetch entries after */
    fun after(): Optional<String> = Optional.ofNullable(after)

    /** The cursor to fetch entries before */
    fun before(): Optional<String> = Optional.ofNullable(before)

    /** Objects to filter by */
    fun objects(): Optional<List<Object>> = Optional.ofNullable(objects)

    /** The page size to fetch */
    fun pageSize(): Optional<Long> = Optional.ofNullable(pageSize)

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [UserListSubscriptionsParams].
         *
         * The following fields are required:
         * ```java
         * .userId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [UserListSubscriptionsParams]. */
    class Builder internal constructor() {

        private var userId: String? = null
        private var after: String? = null
        private var before: String? = null
        private var objects: MutableList<Object>? = null
        private var pageSize: Long? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(userListSubscriptionsParams: UserListSubscriptionsParams) = apply {
            userId = userListSubscriptionsParams.userId
            after = userListSubscriptionsParams.after
            before = userListSubscriptionsParams.before
            objects = userListSubscriptionsParams.objects?.toMutableList()
            pageSize = userListSubscriptionsParams.pageSize
            additionalHeaders = userListSubscriptionsParams.additionalHeaders.toBuilder()
            additionalQueryParams = userListSubscriptionsParams.additionalQueryParams.toBuilder()
        }

        fun userId(userId: String) = apply { this.userId = userId }

        /** The cursor to fetch entries after */
        fun after(after: String?) = apply { this.after = after }

        /** Alias for calling [Builder.after] with `after.orElse(null)`. */
        fun after(after: Optional<String>) = after(after.getOrNull())

        /** The cursor to fetch entries before */
        fun before(before: String?) = apply { this.before = before }

        /** Alias for calling [Builder.before] with `before.orElse(null)`. */
        fun before(before: Optional<String>) = before(before.getOrNull())

        /** Objects to filter by */
        fun objects(objects: List<Object>?) = apply { this.objects = objects?.toMutableList() }

        /** Alias for calling [Builder.objects] with `objects.orElse(null)`. */
        fun objects(objects: Optional<List<Object>>) = objects(objects.getOrNull())

        /**
         * Adds a single [Object] to [objects].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addObject(object_: Object) = apply {
            objects = (objects ?: mutableListOf()).apply { add(object_) }
        }

        /** Alias for calling [addObject] with `Object.ofString(string)`. */
        fun addObject(string: String) = addObject(Object.ofString(string))

        /** Alias for calling [addObject] with `Object.ofUnionMember1(unionMember1)`. */
        fun addObject(unionMember1: Object.UnionMember1) =
            addObject(Object.ofUnionMember1(unionMember1))

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
         * Returns an immutable instance of [UserListSubscriptionsParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .userId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): UserListSubscriptionsParams =
            UserListSubscriptionsParams(
                checkRequired("userId", userId),
                after,
                before,
                objects?.toImmutable(),
                pageSize,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> userId
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                after?.let { put("after", it) }
                before?.let { put("before", it) }
                objects?.forEach {
                    it.accept(
                        object : Object.Visitor<Unit> {
                            override fun visitString(string: String) {
                                put("objects[]", string)
                            }

                            override fun visitUnionMember1(unionMember1: Object.UnionMember1) {
                                put("objects[][id]", unionMember1.id())
                                put("objects[][collection]", unionMember1.collection())
                                unionMember1._additionalProperties().keys().forEach { key ->
                                    unionMember1._additionalProperties().values(key).forEach { value
                                        ->
                                        put("objects[][$key]", value)
                                    }
                                }
                            }
                        }
                    )
                }
                pageSize?.let { put("page_size", it.toString()) }
                putAll(additionalQueryParams)
            }
            .build()

    /**
     * A reference to a recipient, either a user identifier (string) or an object reference (id,
     * collection).
     */
    class Object
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
                else -> throw IllegalStateException("Invalid Object")
            }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Object && string == other.string && unionMember1 == other.unionMember1 /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(string, unionMember1) /* spotless:on */

        override fun toString(): String =
            when {
                string != null -> "Object{string=$string}"
                unionMember1 != null -> "Object{unionMember1=$unionMember1}"
                else -> throw IllegalStateException("Invalid Object")
            }

        companion object {

            /** A user identifier */
            @JvmStatic fun ofString(string: String) = Object(string = string)

            /** An object reference to a recipient */
            @JvmStatic
            fun ofUnionMember1(unionMember1: UnionMember1) = Object(unionMember1 = unionMember1)
        }

        /** An interface that defines how to map each variant of [Object] to a value of type [T]. */
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

        return /* spotless:off */ other is UserListSubscriptionsParams && userId == other.userId && after == other.after && before == other.before && objects == other.objects && pageSize == other.pageSize && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(userId, after, before, objects, pageSize, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "UserListSubscriptionsParams{userId=$userId, after=$after, before=$before, objects=$objects, pageSize=$pageSize, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
