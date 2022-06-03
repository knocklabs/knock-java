package app.knock.api.resources;

import app.knock.api.exception.KnockClientResourceException;
import app.knock.api.http.KnockHttp;
import app.knock.api.model.ChannelData;
import app.knock.api.model.UserIdentity;
import app.knock.api.serialize.Json;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.EqualsAndHashCode;
import lombok.Value;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Value
@EqualsAndHashCode(callSuper = false)
public class UsersResource {

    private static final String BASE_RESOURCE_PATH = "v1/users";

    String baseUrl;
    OkHttpClient httpClient;

    public UserIdentity identify(UserIdentity identity) {
        return identify(identity.getId(), identity);
    }

    /**
     * Identify a user to Knock
     *
     * @param userId
     * @param identity
     * @return userIdentity
     * @throws KnockClientResourceException
     */
    public UserIdentity identify(String userId, UserIdentity identity) {
        byte[] bodyBytes = Json.writeBytes(identity);
        Request request = new Request.Builder()
                .url(buildBaseResource(userId))
                .addHeader("Content-Type", "application/json")
                .put(RequestBody.create(bodyBytes))
                .build();

        return KnockHttp.execute(httpClient, request, new TypeReference<>() {});
    }

    /**
     * Retrieve a user from knock
     *
     * @param userId
     * @return userIdentity
     * @throws KnockClientResourceException
     */
    public UserIdentity get(String userId) {
        Request request = new Request.Builder()
                .url(buildBaseResource(userId))
                .addHeader("Content-Type", "application/json")
                .get()
                .build();

        return KnockHttp.execute(httpClient, request, new TypeReference<>() {});
    }

    public Optional<UserIdentity> oGet(String userId) {
        try {
            return Optional.of(get(userId));
        } catch (KnockClientResourceException e) {
            return Optional.empty();
        }
    }

    public void delete(String userId) {
        Request request = new Request.Builder()
                .url(buildBaseResource(userId))
                .delete()
                .build();

        KnockHttp.execute(httpClient, request);
    }

    public ChannelData getUserChannelData(String userId, String channelId) {
        Request request = new Request.Builder()
                .url(buildChannelBaseResource(userId, channelId))
                .addHeader("Content-Type", "application/json")
                .get()
                .build();

        return KnockHttp.execute(httpClient, request, new TypeReference<>() {});
    }

    public void unsetUserChannelData(String userId, String channelId) {
        Request request = new Request.Builder()
                .url(buildChannelBaseResource(userId, channelId))
                .delete()
                .build();

        KnockHttp.execute(httpClient, request);
    }

    public ChannelData putUserChannelData(String userId, String channelId, Map<String, Object> data) {
        Request request = new Request.Builder()
                .url(buildChannelBaseResource(userId, channelId))
                .addHeader("Content-Type", "application/json")
                .put(RequestBody.create(Json.writeBytes(data)))
                .build();

        return KnockHttp.execute(httpClient, request, new TypeReference<>() {});
    }

    HttpUrl buildBaseResource(String userId) {
        return Objects.requireNonNull(HttpUrl.parse(baseUrl))
                .newBuilder()
                .addPathSegments(BASE_RESOURCE_PATH)
                .addEncodedPathSegment(userId)
                .build();
    }

    HttpUrl buildChannelBaseResource(String userId, String channelId) {
        return buildBaseResource(userId)
                .newBuilder()
                .addEncodedPathSegment("channel_data")
                .addEncodedPathSegment(channelId)
                .build();
    }

}
