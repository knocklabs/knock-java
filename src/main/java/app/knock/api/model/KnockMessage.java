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
public class KnockMessage {

    @JsonProperty("__typename")
    String typeName;

    @JsonProperty("__cursor")
    String cursor;

    String id;
    String channelId;
    Object recipient;
    String workflow;
    String tenant;
    String status;
    ZonedDateTime readAt;
    ZonedDateTime seenAt;
    ZonedDateTime archivedAt;
    ZonedDateTime insertedAt;
    ZonedDateTime updatedAt;
    WorkflowSource source;

    @Singular("data")
    @JsonAnySetter
    @JsonSetter(nulls = Nulls.SKIP)
    Map<String, Object> data;

    public <T> T data(String key, Class<T> clazz) {
        if (this.data != null && this.data.containsKey(key)) {
            Object o = this.data.get(key);
            return clazz.isInstance(o) ? clazz.cast(o) : null;
        }
        return null;
    }
}
