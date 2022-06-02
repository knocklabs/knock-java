package app.knock.api.resources;

import app.knock.api.KnockClient;
import app.knock.api.exception.KnockClientResourceException;
import app.knock.api.http.KnockHttp;
import app.knock.api.model.*;
import app.knock.api.serialize.Json;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.EqualsAndHashCode;
import lombok.Value;
import okhttp3.*;

import java.io.IOException;
import java.util.*;

@Value
@EqualsAndHashCode(callSuper = false)
public class MessagesResource {

    private static final String BASE_RESOURCE_PATH = "v1/messages";

    String baseUrl;
    OkHttpClient httpClient;

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

        public void status(String[] status) {
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

    /**
     * Retrieve Messages
     *
     * @param queryParams
     * @return a cursor result of messages
     * @throws KnockClientResourceException
     */
    public CursorResult<KnockMessage> list(QueryParams queryParams) {
        Request request = new Request.Builder()
                .url(buildListResource(queryParams))
                .addHeader("Content-Type", "application/json")
                .get()
                .build();

        return KnockHttp.execute(httpClient, request, new TypeReference<>() {});
    }

    /**
     * Retrieve a single message
     *
     * @param messageId
     * @return a cursor result of message events
     * @throws KnockClientResourceException
     */
    public KnockMessage getById(String messageId) {
        Request request = new Request.Builder()
                .url(buildChildResource(messageId, "", new QueryParams()))
                .addHeader("Content-Type", "application/json")
                .get()
                .build();

        return KnockHttp.execute(httpClient, request, new TypeReference<>() {});
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
        Request request = new Request.Builder()
                .url(buildChildResource(messageId, "events", queryParams))
                .addHeader("Content-Type", "application/json")
                .get()
                .build();

        return KnockHttp.execute(httpClient, request, new TypeReference<>() {});
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
        Request request = new Request.Builder()
                .url(buildChildResource(messageId, "activities", queryParams))
                .addHeader("Content-Type", "application/json")
                .get()
                .build();

        return KnockHttp.execute(httpClient, request, new TypeReference<>() {});
    }

    /**
     * Retrieve MessageContent
     *
     * @param messageId
     * @return a cursor result of message events
     * @throws KnockClientResourceException
     */
    public KnockMessageContent content(String messageId) {
        Request request = new Request.Builder()
                .url(buildChildResource(messageId, "content", new QueryParams()))
                .addHeader("Content-Type", "application/json")
                .get()
                .build();

        return KnockHttp.execute(httpClient, request, new TypeReference<>() {});
    }

    HttpUrl buildListResource(QueryParams queryParams) {
        HttpUrl.Builder urlBuilder = Objects.requireNonNull(HttpUrl.parse(baseUrl))
                .newBuilder()
                .addPathSegments(BASE_RESOURCE_PATH);

        queryParams.addQueryParams(urlBuilder);

        return urlBuilder.build();
    }

    HttpUrl buildChildResource(String id, String resource, QueryParams queryParams) {
        return Objects.requireNonNull(HttpUrl.parse(baseUrl))
                .newBuilder()
                .addPathSegments(BASE_RESOURCE_PATH)
                .addEncodedPathSegment(id)
                .addPathSegments(resource)
                .build();
    }
}