package app.knock.api.resources;

import app.knock.api.exception.KnockClientResourceException;
import app.knock.api.http.KnockHttp;
import app.knock.api.model.*;
import app.knock.api.serialize.Json;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Value
@EqualsAndHashCode(callSuper = false)
public class UsersResource {

    private static final String BASE_RESOURCE_PATH = "v1/users";

    String baseUrl;
    KnockHttp knockHttp;

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
        byte[] bodyBytes = Json.writeBytes(identity);
        return this.knockHttp.put(BASE_RESOURCE_PATH, userId, bodyBytes, new TypeReference<>() {});
    }

    /**
     * Retrieve a user from knock
     *
     * @param userId
     * @return userIdentity
     * @throws KnockClientResourceException
     */
    public UserIdentity get(String userId) {
        return this.knockHttp.get(BASE_RESOURCE_PATH, userId, new TypeReference<>(){});
    }

    public Optional<UserIdentity> oGet(String userId) {
        try {
            return Optional.of(get(userId));
        } catch (KnockClientResourceException e) {
            return Optional.empty();
        }
    }

    public void delete(String userId) {
        this.knockHttp.delete(BASE_RESOURCE_PATH, List.of(userId));
    }

    public ChannelData getUserChannelData(String userId, String channelId) {
        return this.knockHttp.get(BASE_RESOURCE_PATH, List.of(userId, "channel_id", channelId), new TypeReference<>() {});
    }

    public void unsetUserChannelData(String userId, String channelId) {
        this.knockHttp.delete(BASE_RESOURCE_PATH, List.of(userId, "channel_id", channelId));
    }

    public ChannelData setChannelData(String userId, String channelId, Map<String, Object> data) {
        byte[] body = Json.writeBytes(data);
        return this.knockHttp.put(BASE_RESOURCE_PATH, List.of(userId, "channel_id", channelId), body, new TypeReference<>() {});

    }

    public PreferenceSet getPreferences(String userId) {
        return this.knockHttp.get(BASE_RESOURCE_PATH, List.of(userId, "preferences"), new TypeReference<>(){});
    }

    public PreferenceSet getPreferencesById(String userId, String preferenceId) {
        return this.knockHttp.get(BASE_RESOURCE_PATH, List.of(userId, "preferences", preferenceId), new TypeReference<>(){});
    }

    public PreferenceSet setPreferences(String userId, String preferenceId, SetPreferenceRequest request) {
        byte[] body = Json.writeBytes(request);
        return this.knockHttp.put(BASE_RESOURCE_PATH, List.of(userId, "preferences", preferenceId), body, new TypeReference<>(){});
    }

}
