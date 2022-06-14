package app.knock.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.Map;
import java.util.Optional;

@Value
@Jacksonized
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class PreferenceSet {

    @JsonProperty("__typename")
    String typeName;

    String id;
    Map<String, Object> workflows;
    Map<String, Object> channelTypes;
    Map<String, Object> categories;

}
