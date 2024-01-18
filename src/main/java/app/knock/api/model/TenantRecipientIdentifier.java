package app.knock.api.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
class TenantRecipientIdentifier {
    String id;
}