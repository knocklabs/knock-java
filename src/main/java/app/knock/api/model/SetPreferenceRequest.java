package app.knock.api.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Singular;
import lombok.Value;

import java.util.Map;

import static app.knock.api.model.util.PropertyBuilderHelper.setProperty;

@Value
public class SetPreferenceRequest {

    String id;

    @Singular("channel_type")
    @JsonAnySetter
    Map<String, Object> channelTypes;

    public <T> T channelType(String key, Class<T> clazz) {
        return setProperty(this.channelTypes, key, clazz);
    }

    @Singular("workflow")
    @JsonAnySetter
    Map<String, Object> workflows;

    public <T> T workflow(String key, Class<T> clazz) {
        return setProperty(this.workflows, key, clazz);
    }

    @Singular("category")
    @JsonAnySetter
    Map<String, Object> categories;

    public <T> T category(String key, Class<T> clazz) {
        return setProperty(this.categories, key, clazz);
    }

}
