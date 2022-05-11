package app.knock.api.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;

import java.util.Map;

@Value
@Builder
public class UserIdentity {

    String id;
    String name;
    String email;
    String avatar;
    String phoneNumber;

    @JsonAnySetter
    public void add(String key, String value) {
        customProperties.put(key, value);
    }

    @JsonAnyGetter
    @Getter(value = AccessLevel.NONE)
    Map<String, String> customProperties;

}
