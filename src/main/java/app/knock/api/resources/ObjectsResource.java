package app.knock.api.resources;

import app.knock.api.exception.KnockClientResourceException;
import app.knock.api.http.KnockHttp;
import app.knock.api.model.*;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.EqualsAndHashCode;
import lombok.Value;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.util.*;

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

    HttpUrl objectMessagesUrl(String collection, String objectId, MessagesResource.QueryParams queryParams) {
        HttpUrl.Builder urlBuilder = objectUrl(collection, objectId)
                .newBuilder()
                .addEncodedPathSegment("messages");
        queryParams.addQueryParams(urlBuilder);
        return urlBuilder.build();
    }

    HttpUrl objectPreferencesUrl(String collection, String objectId) {
        return objectUrl(collection, objectId)
                .newBuilder()
                .addEncodedPathSegment("preferences")
                .build();
    }

    HttpUrl objectPreferenceUrl(String collection, String objectId, String preferenceId) {
        return objectUrl(collection, objectId)
                .newBuilder()
                .addEncodedPathSegment("preferences")
                .addEncodedPathSegment(preferenceId)
                .build();
    }

    HttpUrl objectBulkSetUrl(String collection, String action) {
        return knockHttp.baseUrlBuilder(BASE_RESOURCE_PATH, collection, "bulk", action).build();
    }

    /**
     * Retrieve a KnockObject
     *
     * @param collection
     * @param objectId
     * @throws KnockClientResourceException Unable able to retrieve KnockObject from the resource
     * @return KnockObject
     */
    public KnockObject get(String collection, String objectId) {
        HttpUrl url = objectUrl(collection, objectId);
        Request request = knockHttp.baseJsonRequest(url)
                .get()
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<KnockObject>() {
        });
    }

    /**
     * Set a map of properties for a specific Collection of a KnockObject.
     *
     * @param collection
     * @param objectId
     * @param properties
     * @return
     */
    public KnockObject set(String collection, String objectId, Map<String, Object> properties) {
        HttpUrl url = objectUrl(collection, objectId);
        RequestBody body = knockHttp.objectToJsonRequestBody(properties);
        Request request = knockHttp.baseJsonRequest(url)
                .put(body)
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<KnockObject>() {
        });
    }

    /**
     * Delete properties for a specific collection of a KnockObject
     *
     * @param collection
     * @param objectId
     */
    public void delete(String collection, String objectId) {
        HttpUrl url = objectUrl(collection, objectId);
        Request request = knockHttp.baseJsonRequest(url)
                .delete()
                .build();
        knockHttp.execute(request);
    }

    /**
     * Retrieve the ChannelData for a specific KnockObject Collection, and Channel.
     *
     * @param collection
     * @param objectId
     * @param channelId
     * @return
     */
    public ChannelData getChannelData(String collection, String objectId, String channelId) {
        HttpUrl url = objectChannelDataUrl(collection, objectId, channelId);
        Request request = knockHttp.baseJsonRequest(url)
                .get()
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<ChannelData>() {
        });
    }

    /**
     * Set a map of data for a specific KnockObject Collection, and Channel.
     *
     * @param collection
     * @param objectId
     * @param channelId
     * @param data
     * @return
     */
    public ChannelData setChannelData(String collection, String objectId, String channelId, Map<String, Object> data) {
        HttpUrl url = objectChannelDataUrl(collection, objectId, channelId);
        RequestBody body = knockHttp.objectToJsonRequestBody(data);
        Request request = knockHttp.baseJsonRequest(url)
                .put(body)
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<ChannelData>() {
        });
    }

    /**
     * Delete any data for a specific KnockObject Collection, and Channel.
     *
     * @param collection
     * @param objectId
     * @param channelId
     */
    public void unsetChannelData(String collection, String objectId, String channelId) {
        HttpUrl url = objectChannelDataUrl(collection, objectId, channelId);
        Request request = knockHttp.baseJsonRequest(url)
                .delete()
                .build();
        knockHttp.execute(request);
    }

    /**
     * Retrieve a CursorResult of KnockMessages for a specific KnockObject Collection.
     *
     * @param collection
     * @param objectId
     * @return
     */
    public CursorResult<KnockMessage> getMessages(String collection, String objectId, MessagesResource.QueryParams queryParams) {
        HttpUrl url = objectMessagesUrl(collection, objectId, queryParams);
        Request request = knockHttp.baseJsonRequest(url)
                .get()
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<CursorResult<KnockMessage>>() {
        });
    }

    /**
     * Retrieve a list of PreferenceSets for a specific KnockObject Collection.
     *
     * @param collection
     * @param objectId
     * @return
     */
    public List<PreferenceSet> getPreferences(String collection, String objectId) {
        HttpUrl url = objectPreferencesUrl(collection, objectId);
        Request request = knockHttp.baseJsonRequest(url)
                .get()
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<List<PreferenceSet>>() {
        });
    }

    /**
     * Retrieve a specific PreferenceSet for a KnockObject Collection
     *
     * @param collection
     * @param objectId
     * @param preferenceId
     * @return
     */
    public PreferenceSet getPreferencesById(String collection, String objectId, String preferenceId) {
        HttpUrl url = objectPreferenceUrl(collection, objectId, preferenceId);
        Request request = knockHttp.baseJsonRequest(url)
                .get()
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<PreferenceSet>() {
        });
    }

    /**
     * Set preferences for a specific PreferenceSet on a KnockObject Collection.
     *
     * @param collection
     * @param objectId
     * @param preferenceId
     * @param preferenceSetRequest
     * @return
     */
    public PreferenceSet setPreferences(String collection, String objectId, String preferenceId, PreferenceSetRequest preferenceSetRequest) {
        HttpUrl url = objectPreferenceUrl(collection, objectId, preferenceId);
        Request request = knockHttp.baseJsonRequest(url)
                .put(knockHttp.objectToJsonRequestBody(preferenceSetRequest))
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<PreferenceSet>() {
        });
    }

    /**
     * Bulk sets up to 100 objects at a time within a collection, returning an asynchronous BulkOperation that can
     * be used to monitor the progress of the operation.
     * <p>
     * Each object map in the objects list must have a key of 'id' that has a non-null string value.
     *
     * @param collection
     * @param objects
     * @return a bulk operation
     */
    public BulkOperation bulkSetInCollection(String collection, List<Map<String, Object>> objects) {
        objects.stream()
                .filter(object -> object.get("id") != null)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("All object maps in the objects list must have a key of 'id' with a non-null string value."));

        HttpUrl url = objectBulkSetUrl(collection, "set");
        Request request = knockHttp.baseJsonRequest(url)
                .post(knockHttp.objectToJsonRequestBody(Collections.singletonMap("objects", objects)))
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<BulkOperation>() {
        });
    }

    /**
     * Bulk deletes up to 100 objects at a time within a collection, returning an asynchronous BulkOperation
     * that can be used to monitor the progress of the operation.
     *
     * @param collection
     * @param object_ids
     * @return a bulk operation
     */
    public BulkOperation bulkDeleteInCollection(String collection, List<String> object_ids) {
        HttpUrl url = objectBulkSetUrl(collection, "delete");
        Request request = knockHttp.baseJsonRequest(url)
                .post(knockHttp.objectToJsonRequestBody(Collections.singletonMap("object_ids", object_ids)))
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<BulkOperation>() {
        });
    }

}
