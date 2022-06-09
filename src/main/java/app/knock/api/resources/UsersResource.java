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

        public void addQueryParams(HttpUrl.Builder uriBuilder) {
            params.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(entry -> uriBuilder.addQueryParameter(entry.getKey(), entry.getValue().toString()));
        }
    }

    HttpUrl userUrl(String userId) {
        return knockHttp.baseUrlBuilder(BASE_RESOURCE_PATH, userId).build();
    }

    HttpUrl userChannelUrl(String userId, String channelId) {
        return knockHttp.baseUrlBuilder(BASE_RESOURCE_PATH, userId, "channel_data", channelId).build();
    }

    HttpUrl userPreferencesUrl(String userId) {
        return knockHttp.baseUrlBuilder(BASE_RESOURCE_PATH, userId, "preferences").build();
    }

    HttpUrl userPreferencesUrl(String userId, String preferenceId) {
        return knockHttp.baseUrlBuilder(BASE_RESOURCE_PATH, userId, "preferences", preferenceId).build();
    }

    HttpUrl userFeedUrl(String userId, String feedId, FeedQueryParams feedQueryParams) {
        HttpUrl.Builder urlBuilder = knockHttp.baseUrlBuilder(BASE_RESOURCE_PATH, userId, "feeds", feedId);
        feedQueryParams.addQueryParams(urlBuilder);
        return urlBuilder.build();
    }


    public UserIdentity identify(UserIdentity identity) {
        return identify(identity.getId(), identity);
    }

    /**
     * Identify a user to Knock
     *
     * @param userId
     * @param identity
     * @return userIdentity
     * @throws KnockClientResourceException
     */
    public UserIdentity identify(String userId, UserIdentity identity) {
        HttpUrl url = userUrl(userId);
        RequestBody body = knockHttp.objectToJsonRequestBody(identity);
        Request request = knockHttp.baseJsonRequest(url)
                .put(body)
                .build();
        return knockHttp.<UserIdentity>executeWithResponseType(request, new TypeReference<>() {});
    }

    /**
     * Retrieve a user from knock
     *
     * @param userId
     * @return userIdentity
     * @throws KnockClientResourceException
     */
    public UserIdentity get(String userId) {
        HttpUrl url = userUrl(userId);
        Request request = knockHttp.baseJsonRequest(url)
                .get()
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<>() {});
    }

    public Optional<UserIdentity> oGet(String userId) {
        try {
            return Optional.of(get(userId));
        } catch (KnockClientResourceException e) {
            return Optional.empty();
        }
    }

    public void delete(String userId) {
        HttpUrl url = userUrl(userId);
        Request request = knockHttp.baseJsonRequest(url)
                .delete()
                .build();
        knockHttp.execute(request);
    }

    public ChannelData getUserChannelData(String userId, String channelId) {
        HttpUrl url = userChannelUrl(userId, channelId);
        Request request = knockHttp.baseJsonRequest(url)
                .get()
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<>() {});
    }

    public void unsetUserChannelData(String userId, String channelId) {
        HttpUrl url = userChannelUrl(userId, channelId);
        Request request = knockHttp.baseJsonRequest(url)
                .delete()
                .build();
        knockHttp.execute(request);
    }

    public ChannelData setChannelData(String userId, String channelId, Map<String, Object> data) {
        HttpUrl url = userChannelUrl(userId, channelId);
        RequestBody body = knockHttp.objectToJsonRequestBody(Map.of("data", data));
        Request request = knockHttp.baseJsonRequest(url)
                .put(body)
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<>() {});
    }

    public List<PreferenceSet> getPreferences(String userId) {
        HttpUrl url = userPreferencesUrl(userId);
        Request request = knockHttp.baseJsonRequest(url)
                .get()
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<>() {});
    }

    public PreferenceSet getPreferencesById(String userId, String preferenceId) {
        HttpUrl url = userPreferencesUrl(userId, preferenceId);
        Request request = knockHttp.baseJsonRequest(url)
                .get()
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<>() {});
    }

    public PreferenceSet setPreferences(String userId, String preferenceId, SetPreferenceRequest setPreferenceRequest) {
        HttpUrl url = userChannelUrl(userId, preferenceId);
        RequestBody body = knockHttp.objectToJsonRequestBody(setPreferenceRequest);
        Request request = knockHttp.baseJsonRequest(url)
                .put(body)
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<>() {});
    }

    public FeedCursorResult feedItems(String userId, String feedId, FeedQueryParams feedQueryParams) {
        HttpUrl url = userFeedUrl(userId, feedId, feedQueryParams);
        Request request = knockHttp.baseJsonRequest(url)
                .get()
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<>() {});
    }

}
