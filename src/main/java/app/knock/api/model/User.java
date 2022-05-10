package app.knock.api.model;

import lombok.Value;

import java.util.Map;

@Value
public class User {

    String id;
    String name;
    String email;
    String avatar;
    String phoneNumber;
    Map<String, Object> customProperties;

}
