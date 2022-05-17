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
                .addHeader("Content-Type", "application/json")
                .put(RequestBody.create(bodyBytes))
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new KnockClientResourceException("bad API response");
            } else {
                if (response.body() != null) {
                    return Json.readBytes(response.body().bytes(), UserIdentity.class);
                }
                throw new KnockClientResourceException("empty response");
            }
        } catch (IOException e) {
            throw new KnockClientResourceException("an error occurred while calling the user.identify endpoint", e);
        }
    }

    public void delete(String userId) {
        Request request = new Request.Builder()
                .url(buildBaseResource(userId))
                .delete()
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new KnockClientResourceException("bad API response");
            }
        } catch (IOException e) {
            throw new KnockClientResourceException("an error occurred while calling the user.identify endpoint", e);
        }
    }

    HttpUrl buildBaseResource(String userId) {
        return Objects.requireNonNull(HttpUrl.parse(baseUrl))
                .newBuilder()
                .addPathSegments(BASE_RESOURCE_PATH)
                .addEncodedPathSegment(userId)
                .build();
    }

}
