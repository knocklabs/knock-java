package app.knock.api.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.time.ZonedDateTime;
import java.util.Map;

import static app.knock.api.model.util.PropertyBuilderHelper.setProperty;

@Value
@Jacksonized
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserIdentity {

    @JsonProperty("__typename")
    String typeName;

    String id;
    String name;
    String email;

    ZonedDateTime createdAt;
    ZonedDateTime updatedAt;

    String avatar;
    String phoneNumber;

    @Singular("property")
    @JsonAnySetter
    Map<String, Object> properties;

    public <T> T property(String key, Class<T> clazz) {
        return setProperty(this.properties, key, clazz);
    }
}
