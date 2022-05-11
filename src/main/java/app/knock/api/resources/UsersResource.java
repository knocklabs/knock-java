package app.knock.api.resources;

import app.knock.api.model.User;
import lombok.Value;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Value
public class UsersResource {

    private static final String BASE_RESOURCE_PATH = "v1/users";

    String baseUrl;
    OkHttpClient httpClient;

    public User identify(String userId) {
        new Request.Builder()
                .url(buildBaseResource(userId))
                .put(RequestBody.create("".getBytes(StandardCharsets.UTF_8)));
        return null;
    }

    HttpUrl buildBaseResource(String userId) {
        return Objects.requireNonNull(HttpUrl.parse(baseUrl))
                .newBuilder()
                .addPathSegments(BASE_RESOURCE_PATH)
                .addEncodedPathSegment(userId)
                .build();
    }

}
