package app.knock.api.resources;

import app.knock.api.exception.KnockClientResourceException;
import app.knock.api.model.UserIdentity;
import app.knock.api.serialize.Json;
import lombok.EqualsAndHashCode;
import lombok.Value;
import okhttp3.*;

import java.io.IOException;
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
        return this.executeRequestForResponse(request);
    }

    public UserIdentity get(String userId) {
        Request request = new Request.Builder()
                .url(buildBaseResource(userId))
                .get()
                .build();

        return this.executeRequestForResponse(request);
    }

    public void delete(String userId) {
        Request request = new Request.Builder()
                .url(buildBaseResource(userId))
                .delete()
                .build();

        this.executeRequest(request, false);
    }

    HttpUrl buildBaseResource(String userId) {
        return Objects.requireNonNull(HttpUrl.parse(baseUrl))
                .newBuilder()
                .addPathSegments(BASE_RESOURCE_PATH)
                .addEncodedPathSegment(userId)
                .build();
    }

    private UserIdentity executeRequest(Request request, boolean hasResponseBody) {
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new KnockClientResourceException("bad API response");
            } else {
                if (hasResponseBody) {
                    if (response.body() != null) {
                        return Json.readBytes(response.body().bytes(), UserIdentity.class);
                    }
                    throw new KnockClientResourceException("empty response");
                } else {
                    return null;
                }
            }
        } catch (IOException e) {
            throw new KnockClientResourceException("an error occurred while calling the user.identify endpoint", e);
        }
    }

    private UserIdentity executeRequestForResponse(Request request) {
        return this.executeRequest(request, true);
    }

}
