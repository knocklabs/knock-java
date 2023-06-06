package app.knock.api.model;

import com.fasterxml.jackson.annotation.*;
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
public class ObjectSubscription {
    @JsonProperty("__typename")
    String typeName;

    @JsonProperty("__cursor")
    String cursor;

    Object recipient;
    Object object;
    ZonedDateTime insertedAt;
    ZonedDateTime updatedAt;

    @Singular("properties")
    @JsonAnySetter
    @JsonSetter(nulls = Nulls.SKIP)
    Map<String, Object> properties;

    public <T> T properties(String key, Class<T> clazz) {
        if (this.properties != null && this.properties.containsKey(key)) {
            Object o = this.properties.get(key);
            return clazz.isInstance(o) ? clazz.cast(o) : null;
        }
        return null;
    }
}
