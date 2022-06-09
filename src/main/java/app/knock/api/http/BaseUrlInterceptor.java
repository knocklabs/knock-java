package app.knock.api.http;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class BaseUrlInterceptor implements Interceptor {
    private final HttpUrl baseUrl;
    public BaseUrlInterceptor(String baseUrl) {
        this.baseUrl = HttpUrl.parse(baseUrl);
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();

        HttpUrl newUrl = request.url().newBuilder()
                .scheme(this.baseUrl.scheme())
                .host(this.baseUrl.host())
                .port(this.baseUrl.port())
                .build();

        request = request.newBuilder()
                .url(newUrl)
                .build();

        return chain.proceed(request);
    }
}
