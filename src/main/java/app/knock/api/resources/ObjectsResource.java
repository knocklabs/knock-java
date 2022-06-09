package app.knock.api.resources;

import app.knock.api.http.KnockHttp;
import app.knock.api.model.ChannelData;
import app.knock.api.model.KnockObject;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.EqualsAndHashCode;
import lombok.Value;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.util.Map;

@Value
@EqualsAndHashCode(callSuper = false)
public class ObjectsResource {

    private static final String BASE_RESOURCE_PATH = "v1/objects";

    KnockHttp knockHttp;

    private HttpUrl.Builder baseUrlBuilder(String ... pathSegments) {
        return knockHttp.baseUrlBuilder(BASE_RESOURCE_PATH, pathSegments);
    }

    public KnockObject get(String collection, String objectId) {
        HttpUrl url = baseUrlBuilder(collection, objectId).build();
        Request request = knockHttp.baseJsonRequest(url)
                        .get()
                        .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<>() {});
    }

    public KnockObject set(String collection, String objectId, Map<String, Object> properties) {
        HttpUrl url = baseUrlBuilder(collection, objectId).build();
        RequestBody body = knockHttp.objectToJsonRequestBody(properties);
        Request request = knockHttp.baseJsonRequest(url)
                .put(body)
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<>() {});
    }

    public void delete(String collection, String objectId) {
        HttpUrl url = baseUrlBuilder(collection, objectId).build();
        Request request = knockHttp.baseJsonRequest(url)
                .delete()
                .build();
        knockHttp.execute(request);
    }

    public ChannelData getChannelData(String collection, String objectId, String channelId) {
        HttpUrl url = baseUrlBuilder(collection, objectId, "channel_data", channelId).build();
        Request request = knockHttp.baseJsonRequest(url)
                .get()
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<>() {});
    }

    public ChannelData setChannelData(String collection, String objectId, String channelId, Map<String, Object> data) {
        HttpUrl url = baseUrlBuilder(collection, objectId, "channel_data", channelId).build();
        RequestBody body = knockHttp.objectToJsonRequestBody(data);
        Request request = knockHttp.baseJsonRequest(url)
                .put(body)
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<>() {});
    }

    public void unsetChannelData(String collection, String objectId, String channelId) {
        HttpUrl url = baseUrlBuilder(collection, objectId, "channel_data", channelId).build();
        Request request = knockHttp.baseJsonRequest(url)
                .delete()
                .build();
        knockHttp.execute(request);
    }

}
