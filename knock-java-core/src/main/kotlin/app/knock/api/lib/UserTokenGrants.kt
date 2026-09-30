package app.knock.api.lib

import java.util.Objects

/** A permission that a user token can be granted on a [TokenEntity]. */
enum class Grant(val value: String) {
    SLACK_CHANNELS_READ("slack/channels_read"),
    MS_TEAMS_CHANNELS_READ("ms_teams/channels_read"),
    CHANNEL_DATA_READ("channel_data/read"),
    CHANNEL_DATA_WRITE("channel_data/write"),
    USER_FEED_READ("user/feed_read");

    override fun toString() = value
}

/** The user, tenant, or object that a [TokenGrant] applies to. */
sealed class TokenEntity {

    internal abstract fun uri(): String

    class User(val id: String) : TokenEntity() {

        override fun uri() = "$HOSTNAME/v1/users/$id"

        override fun equals(other: Any?): Boolean = other is User && id == other.id

        override fun hashCode(): Int = Objects.hash(id)

        override fun toString() = "TokenEntity.User{id=$id}"
    }

    class Tenant(val id: String) : TokenEntity() {

        override fun uri() = "$HOSTNAME/v1/objects/\$tenants/$id"

        override fun equals(other: Any?): Boolean = other is Tenant && id == other.id

        override fun hashCode(): Int = Objects.hash(id)

        override fun toString() = "TokenEntity.Tenant{id=$id}"
    }

    class Object(val collection: String, val id: String) : TokenEntity() {

        override fun uri() = "$HOSTNAME/v1/objects/$collection/$id"

        override fun equals(other: Any?): Boolean =
            other is Object && collection == other.collection && id == other.id

        override fun hashCode(): Int = Objects.hash(collection, id)

        override fun toString() = "TokenEntity.Object{collection=$collection, id=$id}"
    }

    companion object {

        private const val HOSTNAME = "https://api.knock.app"

        @JvmStatic fun ofUser(id: String): TokenEntity = User(id)

        @JvmStatic fun ofTenant(id: String): TokenEntity = Tenant(id)

        @JvmStatic
        fun ofObject(collection: String, id: String): TokenEntity = Object(collection, id)
    }
}

/**
 * A set of [Grant]s on a single entity, built with [UserTokens.buildUserTokenGrant] and passed to
 * [SignUserTokenOptions.Builder.addGrant].
 */
class TokenGrant internal constructor(private val entity: String, private val grants: List<Grant>) {

    /** The URI of the entity the grants apply to, e.g. `https://api.knock.app/v1/users/user_1`. */
    fun entity(): String = entity

    fun grants(): List<Grant> = grants

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TokenGrant && entity == other.entity && grants == other.grants
    }

    override fun hashCode(): Int = Objects.hash(entity, grants)

    override fun toString() = "TokenGrant{entity=$entity, grants=$grants}"
}
