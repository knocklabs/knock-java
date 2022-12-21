package app.knock.api.resources;

import app.knock.api.exception.KnockClientResourceException;
import app.knock.api.http.KnockHttp;
import app.knock.api.model.*;
import app.knock.api.serialize.Json;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.EqualsAndHashCode;
import lombok.Value;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.util.*;

@Value
@EqualsAndHashCode(callSuper = false)
public class UsersResource {

    private static final String BASE_RESOURCE_PATH = "v1/users";

    KnockHttp knockHttp;

    HttpUrl userUrl(String userId) {
        return knockHttp.baseUrlBuilder(BASE_RESOURCE_PATH, userId).build();
    }

    HttpUrl userChannelUrl(String userId, String channelId) {
        return knockHttp.baseUrlBuilder(BASE_RESOURCE_PATH, userId, "channel_data", channelId).build();
    }

    HttpUrl userMergeUrl(String userId) {
        return knockHttp.baseUrlBuilder(BASE_RESOURCE_PATH, userId, "merge").build();
    }


    HttpUrl userPreferencesUrl(String userId) {
        return knockHttp.baseUrlBuilder(BASE_RESOURCE_PATH, userId, "preferences").build();
    }

    HttpUrl userPreferencesUrl(String userId, String preferenceId) {
        return knockHttp.baseUrlBuilder(BASE_RESOURCE_PATH, userId, "preferences", preferenceId).build();
    }

    HttpUrl userMessagesUrl(String userId, MessagesResource.QueryParams queryParams) {
        HttpUrl.Builder urlBuilder = userUrl(userId)
                .newBuilder()
                .addEncodedPathSegment("messages");
        queryParams.addQueryParams(urlBuilder);
        return urlBuilder.build();
    }

    HttpUrl userFeedUrl(String userId, String feedId, FeedQueryParams feedQueryParams) {
        HttpUrl.Builder urlBuilder = knockHttp.baseUrlBuilder(BASE_RESOURCE_PATH, userId, "feeds", feedId);
        feedQueryParams.addQueryParams(urlBuilder);
        return urlBuilder.build();
    }

    HttpUrl userBulkActionUrl(String action) {
        return knockHttp.baseUrlBuilder(BASE_RESOURCE_PATH, "bulk", action).build();
    }

    /**
     * Identify a user to Knock, using the identity provided by the UserIdentity object.
     *
     * @param identity
     * @return user identity
     * @throws KnockClientResourceException
     */
    public UserIdentity identify(UserIdentity identity) {
        if (identity.getId() == null) {
            throw new IllegalArgumentException("identity.id must not be null");
        }

        return identify(identity.getId(), identity);
    }

    /**
     * Identify a user to Knock
     *
     * @param userId
     * @param identity
     * @return user identity
     * @throws KnockClientResourceException
     */
    public UserIdentity identify(String userId, UserIdentity identity) {
        HttpUrl url = userUrl(userId);
        RequestBody body = knockHttp.objectToJsonRequestBody(identity);
        Request request = knockHttp.baseJsonRequest(url)
                .put(body)
                .build();
        return knockHttp.<UserIdentity>executeWithResponseType(request, new TypeReference<UserIdentity>() {
        });
    }

    /**
     * Identifies up to 100 users at a time. Returns a BulkOperation that executes the job asynchronously.
     * Progress can be tracked via the BulkOperation API.
     *
     * @param userIdentities
     * @return a bulk operation
     */
    public BulkOperation bulkIdentify(List<UserIdentity> userIdentities) {
        HttpUrl url = userBulkActionUrl("identify");
        RequestBody body = knockHttp.objectToJsonRequestBody(userIdentities);
        Request request = knockHttp.baseJsonRequest(url)
                .post(body)
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<BulkOperation>() {
        });
    }

    /**
     * Retrieve a user from knock
     *
     * @param userId
     * @return user identity
     * @throws KnockClientResourceException
     */
    public UserIdentity get(String userId) {
        HttpUrl url = userUrl(userId);
        Request request = knockHttp.baseJsonRequest(url)
                .get()
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<UserIdentity>() {
        });
    }

    /**
     * Retrieve an optional UserIdentity from Knock. Catches
     * KnockClientResourceExceptions and will return an empty Optional.
     *
     * @param userId
     * @return an Optional of user identity
     * @throws KnockClientResourceException
     */
    public Optional<UserIdentity> oGet(String userId) {
        try {
            return Optional.of(get(userId));
        } catch (KnockClientResourceException e) {
            return Optional.empty();
        }
    }

    /**
     * Merges the two users together, merging the user specified in the from_user_id into the userId
     *
     * @param userId
     * @throws KnockClientResourceException
     */
    public UserIdentity merge(String userId, String fromUserId) {
        HttpUrl url = userUrl(userId);
        Request request = knockHttp.baseJsonRequest(url)
                .post(knockHttp.objectToJsonRequestBody(Collections.singletonMap("from_user_id", fromUserId)))
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<UserIdentity>() {
        });
    }

    /**
     * Delete a UserIdentity from Knock
     *
     * @param userId
     * @throws KnockClientResourceException
     */
    public void delete(String userId) {
        HttpUrl url = userUrl(userId);
        Request request = knockHttp.baseJsonRequest(url)
                .delete()
                .build();
        knockHttp.execute(request);
    }

    /**
     * Identifies up to 100 users at a time. Returns a BulkOperation that executes the job asynchronously.
     * Progress can be tracked via the BulkOperation API.
     *
     * @param userIds
     * @return a bulk operation
     * @throws KnockClientResourceException
     */
    public BulkOperation bulkDelete(List<String> userIds) {
        HttpUrl url = userBulkActionUrl("delete");
        RequestBody body = knockHttp.objectToJsonRequestBody(Collections.singletonMap("user_ids", userIds));
        Request request = knockHttp.baseJsonRequest(url)
                .post(body)
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<BulkOperation>() {
        });
    }

    /**
     * Retrieve a CursorResult of messages for a specific User.
     *
     * @param userId
     * @param queryParams
     * @return
     */
    public CursorResult<KnockMessage> getMessages(String userId, MessagesResource.QueryParams queryParams) {
        HttpUrl url = userMessagesUrl(userId, queryParams);
        Request request = knockHttp.baseJsonRequest(url)
                .get()
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<CursorResult<KnockMessage>>() {
        });
    }


    /**
     * Retrieve a user's ChannelData for a particular channelId.
     *
     * @param userId
     * @param channelId
     * @return channel data
     * @throws KnockClientResourceException
     */
    public ChannelData getChannelData(String userId, String channelId) {
        HttpUrl url = userChannelUrl(userId, channelId);
        Request request = knockHttp.baseJsonRequest(url)
                .get()
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<ChannelData>() {
        });
    }

    /**
     * Remove all channel data for the specified userId, and channelId
     *
     * @param userId
     * @param channelId
     * @throws KnockClientResourceException
     */
    public void unsetChannelData(String userId, String channelId) {
        HttpUrl url = userChannelUrl(userId, channelId);
        Request request = knockHttp.baseJsonRequest(url)
                .delete()
                .build();
        knockHttp.execute(request);
    }

    /**
     * Set ChannelData for a specific userId, and channelId.
     *
     * @param userId
     * @param channelId
     * @param data
     * @return channel data
     * @throws KnockClientResourceException
     */
    public ChannelData setChannelData(String userId, String channelId, Map<String, Object> data) {
        HttpUrl url = userChannelUrl(userId, channelId);
        RequestBody body = knockHttp.objectToJsonRequestBody(Collections.singletonMap("data", data));
        Request request = knockHttp.baseJsonRequest(url)
                .put(body)
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<ChannelData>() {
        });
    }

    /**
     * Retrieve a user's PreferenceSet
     *
     * @param userId
     * @return a list of preference sets.
     * @throws KnockClientResourceException
     */
    public List<PreferenceSet> getPreferences(String userId) {
        HttpUrl url = userPreferencesUrl(userId);
        Request request = knockHttp.baseJsonRequest(url)
                .get()
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<List<PreferenceSet>>() {
        });
    }

    /**
     * Retrieve a user's default preferences.
     *
     * @param userId
     * @return a preference set
     * @throws KnockClientResourceException
     */
    public PreferenceSet getDefaultPreferences(String userId) {
        return getPreferencesById(userId, "default");
    }

    /**
     * Retrieve a user's specific preference set by ID.
     *
     * @param userId
     * @param preferenceId
     * @return a preference set
     * @throws KnockClientResourceException
     */
    public PreferenceSet getPreferencesById(String userId, String preferenceId) {
        HttpUrl url = userPreferencesUrl(userId, preferenceId);
        Request request = knockHttp.baseJsonRequest(url)
                .get()
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<PreferenceSet>() {
        });
    }


    /**
     * Set a user's specific preference set. If preferenceSetRequest.id is not specified, it will
     * be set to "default
     *
     * @param userId
     * @param preferenceSetRequest
     * @return the updated preference set
     * @throws KnockClientResourceException
     */
    public PreferenceSet setPreferences(String userId, PreferenceSetRequest preferenceSetRequest) {
        String preferenceSetId = "default";
        if (preferenceSetRequest.getId() != null) {
            preferenceSetId = preferenceSetRequest.getId();
        }
        HttpUrl url = userPreferencesUrl(userId, preferenceSetId);
        RequestBody body = knockHttp.objectToJsonRequestBody(preferenceSetRequest);
        Request request = knockHttp.baseJsonRequest(url)
                .put(body)
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<PreferenceSet>() {
        });
    }

    /**
     * Returns a cursor result of the users feed items for a specific feed.
     *
     * @param userId
     * @param feedId
     * @param feedQueryParams
     * @return a feed item cursor
     * @throws KnockClientResourceException
     */
    public FeedCursorResult getFeed(String userId, String feedId, FeedQueryParams feedQueryParams) {
        HttpUrl url = userFeedUrl(userId, feedId, feedQueryParams);
        Request request = knockHttp.baseJsonRequest(url)
                .get()
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<FeedCursorResult>() {
        });
    }

    @Value
    @EqualsAndHashCode(callSuper = false)
    public static class FeedQueryParams {
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

        public void has_tenant(boolean tenant) {
            params.put("has_tenant", tenant);
        }

        public void source(String source) {
            params.put("source", source);
        }

        public void status(String... status) {
            params.put("status[]", Arrays.toString(status));
        }

        public void trigger_data(Map<String, Object> triggerData) {
            params.put("trigger_data", Json.writeString(triggerData));
        }

        public void addQueryParams(HttpUrl.Builder uriBuilder) {
            params.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(entry -> uriBuilder.addQueryParameter(entry.getKey(), entry.getValue().toString()));
        }
    }

}
