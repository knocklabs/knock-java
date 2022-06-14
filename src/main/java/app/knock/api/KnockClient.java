package app.knock.api;

import app.knock.api.exception.KnockClientApiKeyException;
import app.knock.api.http.BaseUrlInterceptor;
import app.knock.api.http.KnockHttp;
import app.knock.api.http.TokenInterceptor;
import app.knock.api.resources.*;
import app.knock.api.util.Environment;
import okhttp3.OkHttpClient;

public class KnockClient {

    final static String DEFAULT_BASE_URL = "https://api.knock.app";
    final static String API_KEY_ENV_VAR = "KNOCK_API_KEY";

    final String baseUrl;
    final String apiKey;
    final OkHttpClient client;

    final KnockHttp knockHttp;

    final UsersResource usersResource;
    final WorkflowsResource workflowsResource;
    final MessagesResource messagesResource;
    final ObjectsResource objectsResource;
    final BulkOperationsResource bulkOperationsResource;

    KnockClient(String baseUrl, String apiKey) {
        this.apiKey = apiKey;
        this.baseUrl = baseUrl;
        this.client = new OkHttpClient.Builder()
                .addInterceptor(new BaseUrlInterceptor(this.baseUrl))
                .addInterceptor(new TokenInterceptor(this.apiKey))
                .build();

        this.knockHttp = new KnockHttp(this.client, this.baseUrl);

        this.usersResource = new UsersResource(this.knockHttp);
        this.workflowsResource = new WorkflowsResource(this.knockHttp);
        this.messagesResource = new MessagesResource(this.knockHttp);
        this.objectsResource = new ObjectsResource(this.knockHttp);
        this.bulkOperationsResource = new BulkOperationsResource(this.knockHttp);
    }

    public static KnockClientBuilder builder() {
        return new KnockClientBuilder();
    }

    public UsersResource users() {
        return this.usersResource;
    }

    public ObjectsResource objects() {
        return this.objectsResource;
    }

    public WorkflowsResource workflows() {
        return this.workflowsResource;
    }

    public MessagesResource messages() {
        return this.messagesResource;
    }

    public BulkOperationsResource bulkOperations() {
        return this.bulkOperationsResource;
    }

    public static class KnockClientBuilder {

        private String baseUrl = DEFAULT_BASE_URL;
        private String apiKey;

        KnockClientBuilder(Environment environment) {
            this.apiKey = environment.getEnvVar(API_KEY_ENV_VAR);
        }

        public KnockClientBuilder() {
            this(new Environment());
        }

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
