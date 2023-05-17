package app.knock.api.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.time.ZonedDateTime;
import java.util.Map;
import java.util.List;

@Value
@Jacksonized
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Schedule {

    @JsonProperty("__typename")
    String typeName;

    @JsonProperty("__cursor")
    String cursor;

    String id;
    String workflow;
    Object recipient;
    List<ScheduleRepeat> repeats;
    Object actor;
    String tenant;
    ZonedDateTime lastOccurrenceAt;
    ZonedDateTime nextOccurrenceAt;
    ZonedDateTime insertedAt;
    ZonedDateTime updatedAt;

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
