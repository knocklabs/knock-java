package app.knock.api.resources;

import app.knock.api.http.KnockHttp;
import app.knock.api.model.ChannelData;
import app.knock.api.model.KnockObject;
import app.knock.api.serialize.Json;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.List;
import java.util.Map;

@Value
@EqualsAndHashCode(callSuper = false)
public class ObjectsResource {

    private static final String BASE_RESOURCE_PATH = "v1/objects";

    String baseUrl;
    KnockHttp knockHttp;

    public KnockObject get(String collection, String objectId) {
        return this.knockHttp.get(BASE_RESOURCE_PATH, List.of(collection, objectId), new TypeReference<>() {});
    }

    public KnockObject set(String collection, String objectId, Map<String, Object> properties) {
        byte[] body = Json.writeBytes(properties);
        return this.knockHttp.put(BASE_RESOURCE_PATH, List.of(collection, objectId), body, new TypeReference<>() {});
    }

    public void delete(String collection, String objectId) {
        this.knockHttp.delete(BASE_RESOURCE_PATH, List.of(collection, objectId));
    }

    public ChannelData getChannelData(String collection, String objectId, String channelId) {
        return this.knockHttp.get(BASE_RESOURCE_PATH, List.of(collection, objectId, "channel_data", channelId), new TypeReference<>() {});
    }

    public ChannelData setChannelData(String collection, String objectId, String channelId, Map<String, Object> data) {
        byte[] body = Json.writeBytes(data);

        return this.knockHttp.put(BASE_RESOURCE_PATH, List.of(collection, objectId, "channel_data", channelId), body, new TypeReference<>() {});
    }

    public void unsetChannelData(String collection, String objectId, String channelId) {
        this.knockHttp.delete(BASE_RESOURCE_PATH, List.of(collection, objectId, "channel_data", channelId));
    }

}
