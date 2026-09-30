// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async.users

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.users.preferencecenter.PreferenceCenterGenerateSignedUrlParams
import app.knock.api.models.users.preferencecenter.PreferenceCenterGenerateSignedUrlResponse
import app.knock.api.models.users.preferencecenter.PreferenceCenterGetConfigParams
import app.knock.api.models.users.preferencecenter.PreferenceCenterGetConfigResponse
import com.google.errorprone.annotations.MustBeClosed
import java.util.concurrent.CompletableFuture

interface PreferenceCenterServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Returns the preference center config with environment metadata for the given user. */
    fun getConfig(userId: String): CompletableFuture<PreferenceCenterGetConfigResponse> =
        getConfig(userId, PreferenceCenterGetConfigParams.none())

    /** @see [getConfig] */
    fun getConfig(
        userId: String,
        params: PreferenceCenterGetConfigParams = PreferenceCenterGetConfigParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PreferenceCenterGetConfigResponse> =
        getConfig(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see [getConfig] */
    fun getConfig(
        userId: String,
        params: PreferenceCenterGetConfigParams = PreferenceCenterGetConfigParams.none(),
    ): CompletableFuture<PreferenceCenterGetConfigResponse> =
        getConfig(userId, params, RequestOptions.none())

    /** @see [getConfig] */
    fun getConfig(
        params: PreferenceCenterGetConfigParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PreferenceCenterGetConfigResponse>

    /** @see [getConfig] */
    fun getConfig(
        params: PreferenceCenterGetConfigParams
    ): CompletableFuture<PreferenceCenterGetConfigResponse> =
        getConfig(params, RequestOptions.none())

    /** @see [getConfig] */
    fun getConfig(
        userId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<PreferenceCenterGetConfigResponse> =
        getConfig(userId, PreferenceCenterGetConfigParams.none(), requestOptions)

    /**
     * Generates a signed preference center URL and token for the given user in the current
     * environment.
     */
    fun generateSignedUrl(
        userId: String
    ): CompletableFuture<PreferenceCenterGenerateSignedUrlResponse> =
        generateSignedUrl(userId, PreferenceCenterGenerateSignedUrlParams.none())

    /** @see [generateSignedUrl] */
    fun generateSignedUrl(
        userId: String,
        params: PreferenceCenterGenerateSignedUrlParams =
            PreferenceCenterGenerateSignedUrlParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PreferenceCenterGenerateSignedUrlResponse> =
        generateSignedUrl(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see [generateSignedUrl] */
    fun generateSignedUrl(
        userId: String,
        params: PreferenceCenterGenerateSignedUrlParams =
            PreferenceCenterGenerateSignedUrlParams.none(),
    ): CompletableFuture<PreferenceCenterGenerateSignedUrlResponse> =
        generateSignedUrl(userId, params, RequestOptions.none())

    /** @see [generateSignedUrl] */
    fun generateSignedUrl(
        params: PreferenceCenterGenerateSignedUrlParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PreferenceCenterGenerateSignedUrlResponse>

    /** @see [generateSignedUrl] */
    fun generateSignedUrl(
        params: PreferenceCenterGenerateSignedUrlParams
    ): CompletableFuture<PreferenceCenterGenerateSignedUrlResponse> =
        generateSignedUrl(params, RequestOptions.none())

    /** @see [generateSignedUrl] */
    fun generateSignedUrl(
        userId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<PreferenceCenterGenerateSignedUrlResponse> =
        generateSignedUrl(userId, PreferenceCenterGenerateSignedUrlParams.none(), requestOptions)

    /**
     * A view of [PreferenceCenterServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /v1/users/{user_id}/preference_center/config`, but
         * is otherwise the same as [PreferenceCenterServiceAsync.getConfig].
         */
        @MustBeClosed
        fun getConfig(
            userId: String
        ): CompletableFuture<HttpResponseFor<PreferenceCenterGetConfigResponse>> =
            getConfig(userId, PreferenceCenterGetConfigParams.none())

        /** @see [getConfig] */
        @MustBeClosed
        fun getConfig(
            userId: String,
            params: PreferenceCenterGetConfigParams = PreferenceCenterGetConfigParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PreferenceCenterGetConfigResponse>> =
            getConfig(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see [getConfig] */
        @MustBeClosed
        fun getConfig(
            userId: String,
            params: PreferenceCenterGetConfigParams = PreferenceCenterGetConfigParams.none(),
        ): CompletableFuture<HttpResponseFor<PreferenceCenterGetConfigResponse>> =
            getConfig(userId, params, RequestOptions.none())

        /** @see [getConfig] */
        @MustBeClosed
        fun getConfig(
            params: PreferenceCenterGetConfigParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PreferenceCenterGetConfigResponse>>

        /** @see [getConfig] */
        @MustBeClosed
        fun getConfig(
            params: PreferenceCenterGetConfigParams
        ): CompletableFuture<HttpResponseFor<PreferenceCenterGetConfigResponse>> =
            getConfig(params, RequestOptions.none())

        /** @see [getConfig] */
        @MustBeClosed
        fun getConfig(
            userId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PreferenceCenterGetConfigResponse>> =
            getConfig(userId, PreferenceCenterGetConfigParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/users/{user_id}/preference_center/signed_url`,
         * but is otherwise the same as [PreferenceCenterServiceAsync.generateSignedUrl].
         */
        @MustBeClosed
        fun generateSignedUrl(
            userId: String
        ): CompletableFuture<HttpResponseFor<PreferenceCenterGenerateSignedUrlResponse>> =
            generateSignedUrl(userId, PreferenceCenterGenerateSignedUrlParams.none())

        /** @see [generateSignedUrl] */
        @MustBeClosed
        fun generateSignedUrl(
            userId: String,
            params: PreferenceCenterGenerateSignedUrlParams =
                PreferenceCenterGenerateSignedUrlParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PreferenceCenterGenerateSignedUrlResponse>> =
            generateSignedUrl(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see [generateSignedUrl] */
        @MustBeClosed
        fun generateSignedUrl(
            userId: String,
            params: PreferenceCenterGenerateSignedUrlParams =
                PreferenceCenterGenerateSignedUrlParams.none(),
        ): CompletableFuture<HttpResponseFor<PreferenceCenterGenerateSignedUrlResponse>> =
            generateSignedUrl(userId, params, RequestOptions.none())

        /** @see [generateSignedUrl] */
        @MustBeClosed
        fun generateSignedUrl(
            params: PreferenceCenterGenerateSignedUrlParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PreferenceCenterGenerateSignedUrlResponse>>

        /** @see [generateSignedUrl] */
        @MustBeClosed
        fun generateSignedUrl(
            params: PreferenceCenterGenerateSignedUrlParams
        ): CompletableFuture<HttpResponseFor<PreferenceCenterGenerateSignedUrlResponse>> =
            generateSignedUrl(params, RequestOptions.none())

        /** @see [generateSignedUrl] */
        @MustBeClosed
        fun generateSignedUrl(
            userId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PreferenceCenterGenerateSignedUrlResponse>> =
            generateSignedUrl(
                userId,
                PreferenceCenterGenerateSignedUrlParams.none(),
                requestOptions,
            )
    }
}
