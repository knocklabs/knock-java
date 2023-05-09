package app.knock.api.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import java.util.List;

@Value
@Jacksonized
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ScheduleRepeat {
    @JsonProperty("__typename")
    String typeName;

    String frequency;
    int interval;
    List<String> days;
    int dayOfMonth;
    int hours;
    int minutes;
}
