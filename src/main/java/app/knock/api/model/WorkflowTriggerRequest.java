package app.knock.api.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Value
@Jacksonized
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkflowTriggerRequest {

    @JsonProperty("__typename")
    String typeName;

    String key;

    Object actor;
    List<Object> recipients;
    String cancellationKey;

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

    public static class WorkflowTriggerRequestBuilder {

        List<Object> recipients;

        public WorkflowTriggerRequestBuilder addActor(TriggerIdentifier identifier) {
            this.actor = identifier;
            return this;
        }

        public WorkflowTriggerRequestBuilder addActor(String actor) {
            this.actor = actor;
            return this;
        }

        public WorkflowTriggerRequestBuilder addRecipient(String... userIds) {
            if (this.recipients == null) { this.recipients = new ArrayList<>(); }
            Collections.addAll(this.recipients, userIds);
            return this;
        }

        public WorkflowTriggerRequestBuilder addRecipient(Map<String, Object> recipient) {
            if (this.recipients == null) { this.recipients = new ArrayList<>(); }
            Collections.addAll(this.recipients, recipient);
            return this;
        }

        public WorkflowTriggerRequestBuilder addRecipient(TriggerIdentifier identifier) {
            if (this.recipients == null) { this.recipients = new ArrayList<>(); }
            Collections.addAll(this.recipients, identifier);
            return this;
        }

    }

    @Getter
    @Builder
    public static class TriggerIdentifier {

        String id;
        String collection;

    }

}
