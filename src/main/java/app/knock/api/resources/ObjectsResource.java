package app.knock.api.resources;

import app.knock.api.http.KnockHttp;
import app.knock.api.model.ChannelData;
import app.knock.api.model.KnockObject;
import app.knock.api.model.PreferenceSet;
import app.knock.api.model.PreferenceSetRequest;
import app.knock.api.serialize.Json;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.EqualsAndHashCode;
import lombok.Value;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.util.List;
import java.util.Map;

@Value
@EqualsAndHashCode(callSuper = false)
public class ObjectsResource {

    private static final String BASE_RESOURCE_PATH = "v1/objects";

    KnockHttp knockHttp;

    HttpUrl objectUrl(String collection, String objectId) {
        return knockHttp.baseUrlBuilder(BASE_RESOURCE_PATH, collection, objectId).build();
    }

    HttpUrl objectChannelDataUrl(String collection, String objectId, String channelId) {
        return knockHttp.baseUrlBuilder(BASE_RESOURCE_PATH, collection, objectId, "channel_data", channelId).build();
    }

    public KnockObject get(String collection, String objectId) {
        HttpUrl url = objectUrl(collection, objectId);
        Request request = knockHttp.baseJsonRequest(url)
                .get()
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<>() {
        });
    }

    public KnockObject set(String collection, String objectId, Map<String, Object> properties) {
        HttpUrl url = objectUrl(collection, objectId);
        RequestBody body = knockHttp.objectToJsonRequestBody(properties);
        Request request = knockHttp.baseJsonRequest(url)
                .put(body)
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<>() {
        });
    }

    public void delete(String collection, String objectId) {
        HttpUrl url = objectUrl(collection, objectId);
        Request request = knockHttp.baseJsonRequest(url)
                .delete()
                .build();
        knockHttp.execute(request);
    }

    public ChannelData getChannelData(String collection, String objectId, String channelId) {
        HttpUrl url = objectChannelDataUrl(collection, objectId, channelId);
        Request request = knockHttp.baseJsonRequest(url)
                .get()
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<>() {
        });
    }

    public ChannelData setChannelData(String collection, String objectId, String channelId, Map<String, Object> data) {
        HttpUrl url = objectChannelDataUrl(collection, objectId, channelId);
        RequestBody body = knockHttp.objectToJsonRequestBody(data);
        Request request = knockHttp.baseJsonRequest(url)
                .put(body)
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<>() {
        });
    }

    public void unsetChannelData(String collection, String objectId, String channelId) {
        HttpUrl url = objectChannelDataUrl(collection, objectId, channelId);
        Request request = knockHttp.baseJsonRequest(url)
                .delete()
                .build();
        knockHttp.execute(request);
    }

    public List<PreferenceSet> getPreferences(String collection, String objectId) {
        ObjectPreferencesResource resource = new ObjectPreferencesResource(collection, objectId);
        return resource.getPreferences();
    }

    public PreferenceSet getPreferencesById(String collection, String objectId, String preferenceId) {
        ObjectPreferencesResource resource = new ObjectPreferencesResource(collection, objectId);
        return resource.getPreferences(preferenceId);
    }

    public PreferenceSet setPreferences(String collection, String objectId, String preferenceId, PreferenceSetRequest request) {
        ObjectPreferencesResource resource = new ObjectPreferencesResource(collection, objectId);
        return resource.setPreferences(preferenceId, request);
    }

    private final class ObjectPreferencesResource {
        private final HttpUrl url;

        ObjectPreferencesResource(String collection, String objectId) {
            this.url = objectUrl(collection, objectId)
                    .newBuilder()
                    .addEncodedPathSegment("preferences")
                    .build();
        }

        private List<PreferenceSet> getPreferences() {
            Request request = knockHttp.baseJsonRequest(this.url)
                    .get()
                    .build();
            return knockHttp.executeWithResponseType(request, new TypeReference<>() {
            });
        }

        private PreferenceSet getPreferences(String preferenceId) {
            HttpUrl byIdUrl = this.url.newBuilder().addEncodedPathSegment(preferenceId)
                    .build();
            Request request = knockHttp.baseJsonRequest(byIdUrl)
                    .get()
                    .build();
            return knockHttp.executeWithResponseType(request, new TypeReference<>() {
            });
        }

        private PreferenceSet setPreferences(String preferenceId, PreferenceSetRequest preferences) {
            HttpUrl byIdUrl = this.url.newBuilder().addEncodedPathSegment(preferenceId)
                    .build();
            byte[] body = Json.writeBytes(preferences);
            Request request = knockHttp.baseJsonRequest(byIdUrl)
                    .put(RequestBody.create(body))
                    .build();

            return knockHttp.executeWithResponseType(request, new TypeReference<>() {
            });
        }
    }

}
