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

@Value
@Jacksonized
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tenant {

    @JsonProperty("__typename")
    String typeName;

    String id;

    ZonedDateTime createdAt;
    ZonedDateTime updatedAt;

    @Singular("properties")
    @JsonAnySetter
    Map<String, Object> properties;

    public <T> T properties(String key, Class<T> clazz) {
        if (this.properties != null && this.properties.containsKey(key)) {
            Object o = this.properties.get(key);
            return clazz.isInstance(o) ? clazz.cast(o) : null;
        }
        return null;
    }

}
