package app.knock.api.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.Map;

@Value
@Jacksonized
@Builder
public class UserIdentity {

    @JsonProperty("__typename")
    String typeName;

    String id;
    String name;
    String email;

    String createdAt;
    String updatedAt;

    String avatar;
    String phoneNumber;

    @Singular("property")
    @JsonAnySetter
    Map<String, Object> properties;

    public <T> T property(String key, Class<T> clazz) {
        if (this.properties != null && this.properties.containsKey(key)) {
            Object o = this.properties.get(key);
            return clazz.isInstance(o) ? clazz.cast(o) : null;
        }
        return null;
    }
}
