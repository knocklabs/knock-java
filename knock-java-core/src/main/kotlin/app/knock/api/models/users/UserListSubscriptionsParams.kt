// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.core.Enum
import app.knock.api.core.JsonField
import app.knock.api.core.Params
import app.knock.api.core.checkRequired
import app.knock.api.core.getOrThrow
import app.knock.api.core.http.Headers
import app.knock.api.core.http.QueryParams
import app.knock.api.core.toImmutable
import app.knock.api.errors.KnockInvalidDataException
import com.fasterxml.jackson.annotation.JsonCreator
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Retrieves a paginated list of subscriptions for a specific user. Allows filtering by objects and
 * includes optional preference data.
 */
class UserListSubscriptionsParams
private constructor(
    private val userId: String,
    private val after: String?,
    private val before: String?,
    private val include: List<Include>?,
    private val objects: List<Object>?,
    private val pageSize: Long?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun userId(): String = userId

    /** The cursor to fetch entries after. */
    fun after(): Optional<String> = Optional.ofNullable(after)

    /** The cursor to fetch entries before. */
    fun before(): Optional<String> = Optional.ofNullable(before)

    /** Associated resources to include in the response. */
    fun include(): Optional<List<Include>> = Optional.ofNullable(include)

    /** Only return subscriptions for the given recipients. */
    fun objects(): Optional<List<Object>> = Optional.ofNullable(objects)

    /** The number of items per page. */
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
        private var include: MutableList<Include>? = null
        private var objects: MutableList<Object>? = null
        private var pageSize: Long? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(userListSubscriptionsParams: UserListSubscriptionsParams) = apply {
            userId = userListSubscriptionsParams.userId
            after = userListSubscriptionsParams.after
            before = userListSubscriptionsParams.before
            include = userListSubscriptionsParams.include?.toMutableList()
            objects = userListSubscriptionsParams.objects?.toMutableList()
            pageSize = userListSubscriptionsParams.pageSize
            additionalHeaders = userListSubscriptionsParams.additionalHeaders.toBuilder()
            additionalQueryParams = userListSubscriptionsParams.additionalQueryParams.toBuilder()
        }

        fun userId(userId: String) = apply { this.userId = userId }

        /** The cursor to fetch entries after. */
        fun after(after: String?) = apply { this.after = after }

        /** Alias for calling [Builder.after] with `after.orElse(null)`. */
        fun after(after: Optional<String>) = after(after.getOrNull())

        /** The cursor to fetch entries before. */
        fun before(before: String?) = apply { this.before = before }

        /** Alias for calling [Builder.before] with `before.orElse(null)`. */
        fun before(before: Optional<String>) = before(before.getOrNull())

        /** Associated resources to include in the response. */
        fun include(include: List<Include>?) = apply { this.include = include?.toMutableList() }

        /** Alias for calling [Builder.include] with `include.orElse(null)`. */
        fun include(include: Optional<List<Include>>) = include(include.getOrNull())

        /**
         * Adds a single [Include] to [Builder.include].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addInclude(include: Include) = apply {
            this.include = (this.include ?: mutableListOf()).apply { add(include) }
        }

        /** Only return subscriptions for the given recipients. */
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

        /** Alias for calling [addObject] with `Object.ofUserReference(userReference)`. */
        fun addObject(userReference: String) = addObject(Object.ofUserReference(userReference))

        /** Alias for calling [addObject] with `Object.ofReference(reference)`. */
        fun addObject(reference: Object.ObjectReference) = addObject(Object.ofReference(reference))

        /** The number of items per page. */
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
                include?.toImmutable(),
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
                include?.forEach { put("include[]", it.toString()) }
                objects?.forEach {
                    it.accept(
                        object : Object.Visitor<Unit> {
                            override fun visitUserReference(userReference: String) {
                                put("objects[]", userReference)
                            }

                            override fun visitReference(reference: Object.ObjectReference) {
                                reference.id().ifPresent { put("objects[][id]", it) }
                                reference.collection().ifPresent {
                                    put("objects[][collection]", it)
                                }
                                reference._additionalProperties().keys().forEach { key ->
                                    reference._additionalProperties().values(key).forEach { value ->
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

    class Include @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val PREFERENCES = of("preferences")

            @JvmStatic fun of(value: String) = Include(JsonField.of(value))
        }

        /** An enum containing [Include]'s known values. */
        enum class Known {
            PREFERENCES
        }

        /**
         * An enum containing [Include]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Include] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            PREFERENCES,
            /** An enum member indicating that [Include] was instantiated with an unknown value. */
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
                PREFERENCES -> Value.PREFERENCES
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
                PREFERENCES -> Known.PREFERENCES
                else -> throw KnockInvalidDataException("Unknown Include: $value")
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

        fun validate(): Include = apply {
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

            return /* spotless:off */ other is Include && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * A reference to a recipient, either a user identifier (string) or an object reference (ID,
     * collection).
     */
    class Object
    private constructor(
        private val userReference: String? = null,
        private val reference: ObjectReference? = null,
    ) {

        /** The ID of the user. */
        fun userReference(): Optional<String> = Optional.ofNullable(userReference)

        /** A reference to a recipient object. */
        fun reference(): Optional<ObjectReference> = Optional.ofNullable(reference)

        fun isUserReference(): Boolean = userReference != null

        fun isReference(): Boolean = reference != null

        /** The ID of the user. */
        fun asUserReference(): String = userReference.getOrThrow("userReference")

        /** A reference to a recipient object. */
        fun asReference(): ObjectReference = reference.getOrThrow("reference")

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                userReference != null -> visitor.visitUserReference(userReference)
                reference != null -> visitor.visitReference(reference)
                else -> throw IllegalStateException("Invalid Object")
            }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Object && userReference == other.userReference && reference == other.reference /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(userReference, reference) /* spotless:on */

        override fun toString(): String =
            when {
                userReference != null -> "Object{userReference=$userReference}"
                reference != null -> "Object{reference=$reference}"
                else -> throw IllegalStateException("Invalid Object")
            }

        companion object {

            /** The ID of the user. */
            @JvmStatic
            fun ofUserReference(userReference: String) = Object(userReference = userReference)

            /** A reference to a recipient object. */
            @JvmStatic fun ofReference(reference: ObjectReference) = Object(reference = reference)
        }

        /** An interface that defines how to map each variant of [Object] to a value of type [T]. */
        interface Visitor<out T> {

            /** The ID of the user. */
            fun visitUserReference(userReference: String): T

            /** A reference to a recipient object. */
            fun visitReference(reference: ObjectReference): T
        }

        /** A reference to a recipient object. */
        class ObjectReference
        private constructor(private val id: String?, private val collection: String?) {

            /** An identifier for the recipient object. */
            fun id(): Optional<String> = Optional.ofNullable(id)

            /** The collection the recipient object belongs to. */
            fun collection(): Optional<String> = Optional.ofNullable(collection)

            fun toBuilder() = Builder().from(this)

            companion object {

                /** Returns a mutable builder for constructing an instance of [ObjectReference]. */
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

                /** An identifier for the recipient object. */
                fun id(id: String?) = apply { this.id = id }

                /** Alias for calling [Builder.id] with `id.orElse(null)`. */
                fun id(id: Optional<String>) = id(id.getOrNull())

                /** The collection the recipient object belongs to. */
                fun collection(collection: String?) = apply { this.collection = collection }

                /** Alias for calling [Builder.collection] with `collection.orElse(null)`. */
                fun collection(collection: Optional<String>) = collection(collection.getOrNull())

                /**
                 * Returns an immutable instance of [ObjectReference].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): ObjectReference = ObjectReference(id, collection)
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

        return /* spotless:off */ other is UserListSubscriptionsParams && userId == other.userId && after == other.after && before == other.before && include == other.include && objects == other.objects && pageSize == other.pageSize && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(userId, after, before, include, objects, pageSize, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "UserListSubscriptionsParams{userId=$userId, after=$after, before=$before, include=$include, objects=$objects, pageSize=$pageSize, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
