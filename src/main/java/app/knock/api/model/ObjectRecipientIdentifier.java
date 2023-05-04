package app.knock.api.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
class ObjectRecipientIdentifier {

    String id;
    String collection;

}