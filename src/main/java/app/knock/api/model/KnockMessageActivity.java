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
public class KnockMessageActivity {

    @JsonProperty("__typename")
    String typeName;

    @JsonProperty("__cursor")
    String cursor;

    String id;
    UserIdentity actor;
    Object recipient;
    ZonedDateTime insertedAt;
    ZonedDateTime updatedAt;

    @Singular("data")
    @JsonAnySetter
    Map<String, Object> data;

    public <T> T data(String key, Class<T> clazz) {
        if (this.data != null && this.data.containsKey(key)) {
            Object o = this.data.get(key);
            return clazz.isInstance(o) ? clazz.cast(o) : null;
        }
        return null;
    }
}
