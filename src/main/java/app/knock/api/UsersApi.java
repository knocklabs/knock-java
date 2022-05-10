package app.knock.api;

import app.knock.api.model.User;
import lombok.Value;
import okhttp3.OkHttpClient;

@Value
public class UsersApi {

    private static final String BASE_API_PATH = "/users";

    String baseUrl;
    OkHttpClient httpClient;

    public User identifiy(String id) {
        return null;
    }

}
