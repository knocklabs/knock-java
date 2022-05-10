package app.knock.api.http;

import lombok.Value;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

@Value
public class TokenInterceptor implements Interceptor {

    private final String AUTHORIZATION_HEADER = "Authorization";
    String token;

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();
        Request newRequest = request.newBuilder()
                .addHeader(AUTHORIZATION_HEADER, String.format("Bearer %s", this.token))
                .build();

        return chain.proceed(newRequest);
    }
}
