package app.knock.api.resources;

import app.knock.api.exception.KnockClientResourceException;
import app.knock.api.http.KnockHttp;
import app.knock.api.model.UserIdentity;
import app.knock.api.serialize.Json;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.EqualsAndHashCode;
import lombok.Value;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

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

    HttpUrl buildBaseResource(String userId) {
        return Objects.requireNonNull(HttpUrl.parse(baseUrl))
                .newBuilder()
                .addPathSegments(BASE_RESOURCE_PATH)
                .addEncodedPathSegment(userId)
                .build();
    }

}
