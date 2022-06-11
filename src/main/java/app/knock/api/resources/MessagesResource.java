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
public class MessagesResource {

    private static final String BASE_RESOURCE_PATH = "v1/messages";
    private static final String BASE_CHANNELS_RESOURCE_PATH = "v1/channels";

    KnockHttp knockHttp;

    HttpUrl buildListResource(QueryParams queryParams) {
        HttpUrl.Builder urlBuilder = knockHttp.baseUrlBuilder(BASE_RESOURCE_PATH);
        queryParams.addQueryParams(urlBuilder);
        return urlBuilder.build();
    }

    HttpUrl buildChildResource(String id, String resource, QueryParams queryParams) {
        HttpUrl.Builder urlBuilder = knockHttp.baseUrlBuilder(BASE_RESOURCE_PATH, id, resource);
        queryParams.addQueryParams(urlBuilder);
        return urlBuilder.build();
    }

    HttpUrl buildBatchResource(String status) {
        HttpUrl.Builder urlBuilder = knockHttp.baseUrlBuilder(BASE_RESOURCE_PATH, "batch", status);
        return urlBuilder.build();
    }

    HttpUrl buildChannelBatchResource(String channelId, String status) {
        HttpUrl.Builder urlBuilder = knockHttp.baseUrlBuilder(BASE_CHANNELS_RESOURCE_PATH, channelId, "messages", "bulk", status);
        return urlBuilder.build();
    }

    /**
     * Retrieve Messages
     *
     * @param queryParams
     * @return a cursor result of messages
     * @throws KnockClientResourceException
     */
    public CursorResult<KnockMessage> list(QueryParams queryParams) {
        HttpUrl url = buildListResource(queryParams);
        Request request = knockHttp.baseJsonRequest(url)
                .get()
                .build();

        return knockHttp.executeWithResponseType(request, new TypeReference<>() {
        });
    }

    /**
     * Retrieve a single message
     *
     * @param messageId
     * @return a single message
     * @throws KnockClientResourceException
     */
    public KnockMessage get(String messageId) {
        HttpUrl url = buildChildResource(messageId, "", new QueryParams());
        Request request = knockHttp.baseJsonRequest(url)
                .get()
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<>() {
        });
    }

    /**
     * Retrieve an optional single message
     *
     * @param messageId
     * @return an optional single message
     */
    public Optional<KnockMessage> oGet(String messageId) {
        try {
            return Optional.of(get(messageId));
        } catch (KnockClientResourceException e) {
            return Optional.empty();
        }
    }

    /**
     * Retrieve MessageEvents
     *
     * @param messageId
     * @param queryParams
     * @return a cursor result of message events
     * @throws KnockClientResourceException
     */
    public CursorResult<KnockMessageEvent> events(String messageId, QueryParams queryParams) {
        HttpUrl url = buildChildResource(messageId, "events", queryParams);
        Request request = knockHttp.baseJsonRequest(url)
                .get()
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<>() {
        });
    }

    /**
     * Retrieve MessageActivities
     *
     * @param messageId
     * @param queryParams
     * @return a cursor result of message events
     * @throws KnockClientResourceException
     */
    public CursorResult<KnockMessageActivity> activities(String messageId, QueryParams queryParams) {
        HttpUrl url = buildChildResource(messageId, "activities", queryParams);
        Request request = knockHttp.baseJsonRequest(url)
                .get()
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<>() {
        });
    }

    /**
     * Retrieve MessageContent
     *
     * @param messageId
     * @return a cursor result of message events
     * @throws KnockClientResourceException
     */
    public KnockMessageContent content(String messageId) {
        HttpUrl url = buildChildResource(messageId, "content", new QueryParams());
        Request request = knockHttp.baseJsonRequest(url)
                .get()
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<>() {
        });
    }

    /**
     * Set Message status
     * Supports "seen", "read", and "archived"
     *
     * @param messageId
     * @return the updated message
     * @throws KnockClientResourceException
     */
    public KnockMessage setStatus(String messageId, String status) {
        HttpUrl url = buildChildResource(messageId, status, new QueryParams());
        RequestBody body = knockHttp.objectToJsonRequestBody(true);
        Request request = knockHttp.baseJsonRequest(url)
                .get()
                .put(body)
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<>() {
        });
    }

    /**
     * Delete a Message status
     * Supports "seen", "read", and "archived"
     *
     * @param messageId
     * @return the updated message
     * @throws KnockClientResourceException
     */
    public KnockMessage deleteStatus(String messageId, String status) {
        HttpUrl url = buildChildResource(messageId, status, new QueryParams());
        Request request = knockHttp.baseJsonRequest(url)
                .delete()
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<>() {
        });
    }

    /**
     * Set the status of multiple messages as a batch.
     *
     * @param status
     * @param bulkSetMessageStatusRequest
     * @return A list of messages that were mutated during the call.
     * @throws KnockClientResourceException
     */
    public List<KnockMessage> batchSetStatus(String status, BatchSetMessageStatusRequest bulkSetMessageStatusRequest) {
        HttpUrl url = buildBatchResource(status);
        RequestBody body = knockHttp.objectToJsonRequestBody(bulkSetMessageStatusRequest);
        Request request = knockHttp.baseJsonRequest(url)
                .post(body)
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<>() {
        });
    }

    /**
     * Set message status in a particular channel in bulk.
     *
     * @param channelId
     * @param status
     * @param bulkChannelMessageStatusRequest
     * @return a BulkOperation
     * @throws KnockClientResourceException
     */
    public BulkOperation bulk(String channelId, String status, BulkChannelMessageStatusRequest bulkChannelMessageStatusRequest) {
        HttpUrl url = buildChannelBatchResource(channelId, status);
        RequestBody body = knockHttp.objectToJsonRequestBody(bulkChannelMessageStatusRequest);
        Request request = knockHttp.baseJsonRequest(url)
                .post(body)
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<>() {
        });
    }

    @Value
    @EqualsAndHashCode(callSuper = false)
    public static class QueryParams {
        private final Map<String, Object> params = new HashMap<>();


        public void pageSize(Integer pageSize) {
            params.put("page_size", pageSize);
        }

        public void after(String after) {
            params.put("after", after);
        }

        public void before(String before) {
            params.put("before", before);
        }

        public void tenant(String tenant) {
            params.put("tenant", tenant);
        }

        public void source(String source) {
            params.put("source", source);
        }

        public void status(String... status) {
            params.put("status", Arrays.toString(status));
        }

        public void channel_id(String channel_id) {
            params.put("channel_id", channel_id);
        }

        public void addQueryParams(HttpUrl.Builder uriBuilder) {
            params.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(entry -> uriBuilder.addQueryParameter(entry.getKey(), entry.getValue().toString()));
        }
    }
}