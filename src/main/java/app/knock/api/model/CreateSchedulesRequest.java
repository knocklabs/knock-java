package app.knock.api.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Value
@Jacksonized
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateSchedulesRequest {

    @JsonProperty("__typename")
    String typeName;

    String workflow;
    List<Object> recipients;
    List<ScheduleRepeat> repeats;
    Object actor;
    Object tenant;
    ZonedDateTime scheduledAt;

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

    public static class CreateSchedulesRequestBuilder {

        List<Object> recipients;

        public CreateSchedulesRequestBuilder addActor(ObjectRecipientIdentifier identifier) {
            this.actor = identifier;
            return this;
        }

        public CreateSchedulesRequestBuilder addActor(String actor) {
            this.actor = actor;
            return this;
        }

        public CreateSchedulesRequestBuilder addActor(Map<String, Object> actor) {
            this.actor = actor;
            return this;
        }

        public CreateSchedulesRequestBuilder addTenant(TenantRecipientIdentifier identifier) {
            this.tenant = identifier;
            return this;
        }

        public CreateSchedulesRequestBuilder addTenant(String tenant) {
            this.tenant = tenant;
            return this;
        }

        public CreateSchedulesRequestBuilder addTenant(Map<String, Object> tenant) {
            this.tenant = tenant;
            return this;
        }

        public CreateSchedulesRequestBuilder addRecipient(String... userIds) {
            if (this.recipients == null) { this.recipients = new ArrayList<>(); }
            Collections.addAll(this.recipients, userIds);
            return this;
        }

        public CreateSchedulesRequestBuilder addRecipient(Map<String, Object> recipient) {
            if (this.recipients == null) { this.recipients = new ArrayList<>(); }
            Collections.addAll(this.recipients, recipient);
            return this;
        }

        public CreateSchedulesRequestBuilder addRecipient(ObjectRecipientIdentifier identifier) {
            if (this.recipients == null) { this.recipients = new ArrayList<>(); }
            Collections.addAll(this.recipients, identifier);
            return this;
        }

        public CreateSchedulesRequestBuilder addRepeat(ScheduleRepeat repeat) {
            if (this.repeats == null) { this.repeats = new ArrayList<>(); }
            Collections.addAll(this.repeats, repeat);
            return this;
        }
    }
}
