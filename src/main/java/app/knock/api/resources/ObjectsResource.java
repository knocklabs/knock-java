package app.knock.api.resources;

import app.knock.api.http.KnockHttp;
import app.knock.api.model.ChannelData;
import app.knock.api.model.KnockObject;
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

@Value
@EqualsAndHashCode(callSuper = false)
public class ObjectsResource {

    private static final String BASE_RESOURCE_PATH = "v1/objects";

    String baseUrl;
    OkHttpClient httpClient;

    public KnockObject get(String collection, String objectId) {
        Request request = new Request.Builder()
                .url(buildBaseResource(collection, objectId))
                .addHeader("Content-Type", "application/json")
                .get()
                .build();

        return KnockHttp.execute(httpClient, request, new TypeReference<>() {});
    }

    public ChannelData getChannelData(String collection, String objectId, String channelId) {
        Request request = new Request.Builder()
                .url(buildChannelBaseResource(collection, objectId, channelId))
                .addHeader("Content-Type", "application/json")
                .get()
                .build();

        return KnockHttp.execute(httpClient, request, new TypeReference<>() {});
    }

    public ChannelData setChannelData(String collection, String objectId, String channelId, Map<String, Object> data) {
        Request request = new Request.Builder()
                .url(buildChannelBaseResource(collection, objectId, channelId))
                .addHeader("Content-Type", "application/json")
                .put(RequestBody.create(Json.writeBytes(data)))
                .build();

        return KnockHttp.execute(httpClient, request, new TypeReference<>() {});
    }

    public void unsetChannelData(String collection, String objectId, String channelId) {
        Request request = new Request.Builder()
                .url(buildChannelBaseResource(collection, objectId, channelId))
                .addHeader("Content-Type", "application/json")
                .delete()
                .build();
    }

    HttpUrl buildBaseResource(String collection, String objectId) {
        return Objects.requireNonNull(HttpUrl.parse(baseUrl))
                .newBuilder()
                .addPathSegments(BASE_RESOURCE_PATH)
                .addEncodedPathSegment(collection)
                .addEncodedPathSegments(objectId)
                .build();
    }

    HttpUrl buildChannelBaseResource(String collection, String objectId, String channelId) {
        return buildBaseResource(collection, objectId)
                .newBuilder()
                .addEncodedPathSegment("channel_data")
                .addEncodedPathSegment(channelId)
                .build();
    }

}
