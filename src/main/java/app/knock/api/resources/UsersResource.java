package app.knock.api.resources;

import app.knock.api.http.RequestExecutorService;
import app.knock.api.model.UserIdentity;
import app.knock.api.serialize.Json;
import lombok.EqualsAndHashCode;
import lombok.Value;
import okhttp3.*;

import java.util.Objects;

@Value
@EqualsAndHashCode(callSuper = false)
public class UsersResource {

    private static final String BASE_RESOURCE_PATH = "v1/users";

    String baseUrl;
    OkHttpClient httpClient;

    public UserIdentity identify(String userId, UserIdentity identity) {
        byte[] bodyBytes = Json.writeBytes(identity);
        Request request = new Request.Builder()
                .url(buildBaseResource(userId))
                .put(RequestBody.create(bodyBytes, MediaType.get("application/json; charset=utf-8")))
                .build();
        return RequestExecutorService.executeRequestForResponse(httpClient, request, UserIdentity.class);
    }

    public UserIdentity get(String userId) {
        Request request = new Request.Builder()
                .url(buildBaseResource(userId))
                .get()
                .build();

        return RequestExecutorService.executeRequestForResponse(httpClient, request, UserIdentity.class);
    }

    public void delete(String userId) {
        Request request = new Request.Builder()
                .url(buildBaseResource(userId))
                .delete()
                .build();

        RequestExecutorService.executeRequest(httpClient, request, UserIdentity.class, false);
    }

    HttpUrl buildBaseResource(String userId) {
        return Objects.requireNonNull(HttpUrl.parse(baseUrl))
                .newBuilder()
                .addPathSegments(BASE_RESOURCE_PATH)
                .addEncodedPathSegment(userId)
                .build();
    }

}
