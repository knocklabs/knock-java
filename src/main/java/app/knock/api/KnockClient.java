package app.knock.api;

import app.knock.api.exception.KnockClientApiKeyException;
import app.knock.api.http.TokenInterceptor;
import app.knock.api.util.Environment;
import okhttp3.OkHttpClient;

public class KnockClient {

    private final static String DEFAULT_BASE_URL = "https://api.knock.app";
    final static String API_KEY_ENV_VAR = "KNOCK_API_KEY";

    final String baseUrl;
    final String apiKey;
    final OkHttpClient client;

    UsersApi usersApi;

    private KnockClient(String baseUrl, String apiKey) {
        this.apiKey = apiKey;
        this.baseUrl= baseUrl;
        this.client = new OkHttpClient.Builder()
                .addInterceptor(new TokenInterceptor(this.apiKey))
                .build();

        this.usersApi = new UsersApi(this.baseUrl, this.client);
    }

    public UsersApi users() {
        return this.usersApi;
    }

    public static KnockClientBuilder builder() {
        return new KnockClientBuilder();
    }

    public static class KnockClientBuilder {

        KnockClientBuilder(Environment environment) {
            this.apiKey = environment.getEnvVar(API_KEY_ENV_VAR);
        }

        public KnockClientBuilder() {
            this(new Environment());
        }

        private String baseUrl = DEFAULT_BASE_URL;
        private String apiKey;

        public KnockClientBuilder baseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        public KnockClientBuilder apiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        public KnockClient build() {
            if (this.apiKey == null) {
                throw new KnockClientApiKeyException("API Key was not provided");
            }
            return new KnockClient(this.baseUrl, this.apiKey);
        }
    }

}
