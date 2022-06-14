package app.knock.api.model;

import lombok.Value;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class UserPreferenceBuilder {


    private Map<String, Object> channelTypes = new HashMap<>();
    private List<Map<String, String>> conditions = new LinkedList<>();

    public UserPreferenceBuilder email(boolean enabled) {
        return custom("email", enabled);
    }

    public UserPreferenceBuilder sms(boolean enabled) {
        return custom("sms", enabled);
    }

    public UserPreferenceBuilder inAppFeed(boolean enabled) {
        return custom("in_app_feed", enabled);
    }

    public UserPreferenceBuilder chat(boolean enabled) {
        return custom("chat", enabled);
    }

    public UserPreferenceBuilder push(boolean enabled) {
        return custom("push", enabled);
    }

    public UserPreferenceBuilder custom(String key, boolean enabled) {
        channelTypes.put(key, enabled);
        return this;
    }

    public UserPreferenceBuilder condition(String variable, String operator, String argument) {
        conditions.add(Map.of("variable", variable, "operator", operator, "argument", argument));
        return this;
    }

    public Map<String, Object> build() {
        Map<String, Object> built = new HashMap<>();

        if (conditions.size() > 0) {
            built.put("conditions", List.copyOf(conditions));
        }

        if (channelTypes.size() > 0) {
            built.put("channel_types", Map.copyOf(channelTypes));
        }

        return built;
    }

    public Map<String, Object> buildChannelTypes() {
        return Map.copyOf(channelTypes);
    }

    public List<Map<String, String>> buildConditions() {
        return List.copyOf(conditions);
    }

}
