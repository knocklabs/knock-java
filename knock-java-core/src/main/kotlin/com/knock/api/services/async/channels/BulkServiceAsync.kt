// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.knock.api.services.async.channels

import com.fasterxml.jackson.annotation.JsonCreator
import com.google.errorprone.annotations.MustBeClosed
import com.knock.api.core.Enum
import com.knock.api.core.JsonField
import com.knock.api.core.RequestOptions
import com.knock.api.core.http.HttpResponseFor
import com.knock.api.errors.KnockInvalidDataException
import com.knock.api.models.BulkOperation
import com.knock.api.models.ChannelBulkUpdateMessageStatusParams
import java.util.concurrent.CompletableFuture

interface BulkServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Bulk update messages for a specific channel. The channel is specified by the `channel_id`
     * parameter. The action to perform is specified by the `action` parameter, where the action is
     * a status change action (e.g. `archive`, `unarchive`).
     */
    @JvmOverloads
    fun updateMessageStatus(
        params: ChannelBulkUpdateMessageStatusParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BulkOperation>

    class Action @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val SEEN = of("seen")

            @JvmField val UNSEEN = of("unseen")

            @JvmField val READ = of("read")

            @JvmField val UNREAD = of("unread")

            @JvmField val ARCHIVED = of("archived")

            @JvmField val UNARCHIVED = of("unarchived")

            @JvmField val INTERACTED = of("interacted")

            @JvmField val ARCHIVE = of("archive")

            @JvmField val UNARCHIVE = of("unarchive")

            @JvmField val DELETE = of("delete")

            @JvmStatic fun of(value: String) = Action(JsonField.of(value))
        }

        /** An enum containing [Action]'s known values. */
        enum class Known {
            SEEN,
            UNSEEN,
            READ,
            UNREAD,
            ARCHIVED,
            UNARCHIVED,
            INTERACTED,
            ARCHIVE,
            UNARCHIVE,
            DELETE,
        }

        /**
         * An enum containing [Action]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Action] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            SEEN,
            UNSEEN,
            READ,
            UNREAD,
            ARCHIVED,
            UNARCHIVED,
            INTERACTED,
            ARCHIVE,
            UNARCHIVE,
            DELETE,
            /** An enum member indicating that [Action] was instantiated with an unknown value. */
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
                SEEN -> Value.SEEN
                UNSEEN -> Value.UNSEEN
                READ -> Value.READ
                UNREAD -> Value.UNREAD
                ARCHIVED -> Value.ARCHIVED
                UNARCHIVED -> Value.UNARCHIVED
                INTERACTED -> Value.INTERACTED
                ARCHIVE -> Value.ARCHIVE
                UNARCHIVE -> Value.UNARCHIVE
                DELETE -> Value.DELETE
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
                SEEN -> Known.SEEN
                UNSEEN -> Known.UNSEEN
                READ -> Known.READ
                UNREAD -> Known.UNREAD
                ARCHIVED -> Known.ARCHIVED
                UNARCHIVED -> Known.UNARCHIVED
                INTERACTED -> Known.INTERACTED
                ARCHIVE -> Known.ARCHIVE
                UNARCHIVE -> Known.UNARCHIVE
                DELETE -> Known.DELETE
                else -> throw KnockInvalidDataException("Unknown Action: $value")
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

            return /* spotless:off */ other is Action && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** A view of [BulkServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/channels/{channel_id}/messages/bulk/{action}`,
         * but is otherwise the same as [BulkServiceAsync.updateMessageStatus].
         */
        @JvmOverloads
        @MustBeClosed
        fun updateMessageStatus(
            params: ChannelBulkUpdateMessageStatusParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BulkOperation>>
    }
}
