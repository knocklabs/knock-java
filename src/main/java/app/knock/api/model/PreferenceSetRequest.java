package app.knock.api.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;

import java.util.Map;

import static app.knock.api.model.util.PropertyBuilderHelper.setProperty;

@Value
@Builder
public class PreferenceSetRequest {

    String id;

    @Singular("channelType")
    @JsonAnySetter
    Map<String, Object> channelTypes;

    @Singular("workflow")
    @JsonAnySetter
    Map<String, Object> workflows;
    @Singular("category")
    @JsonAnySetter
    Map<String, Object> categories;

    public <T> T channelType(String key, Class<T> clazz) {
        return setProperty(this.channelTypes, key, clazz);
    }

    public <T> T workflow(String key, Class<T> clazz) {
        return setProperty(this.workflows, key, clazz);
    }

    public <T> T category(String key, Class<T> clazz) {
        return setProperty(this.categories, key, clazz);
    }


}
