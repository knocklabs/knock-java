package app.knock.api;

import app.knock.api.http.TokenInterceptor;
import okhttp3.OkHttpClient;

public class KnockClient {

    private final static String DEFAULT_API_BASE_URL = "https://api.knock.app/v1";

    private String baseUrl = DEFAULT_API_BASE_URL;
    private String token;
    private OkHttpClient client;

    UsersApi usersApi;

    public KnockClient(String token) {
        this.token = token;
        this.client = new OkHttpClient.Builder()
                .addInterceptor(new TokenInterceptor(this.token))
                .build();

        this.usersApi = new UsersApi(baseUrl, this.client);
    }

    public UsersApi users() {
        return this.usersApi;
    }

}
