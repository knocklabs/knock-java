// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking.users

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.users.preferencecenter.PreferenceCenterGenerateSignedUrlParams
import app.knock.api.models.users.preferencecenter.PreferenceCenterGenerateSignedUrlResponse
import app.knock.api.models.users.preferencecenter.PreferenceCenterGetConfigParams
import app.knock.api.models.users.preferencecenter.PreferenceCenterGetConfigResponse
import com.google.errorprone.annotations.MustBeClosed

interface PreferenceCenterService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Returns the preference center config with environment metadata for the given user. */
    fun getConfig(userId: String): PreferenceCenterGetConfigResponse =
        getConfig(userId, PreferenceCenterGetConfigParams.none())

    /** @see [getConfig] */
    fun getConfig(
        userId: String,
        params: PreferenceCenterGetConfigParams = PreferenceCenterGetConfigParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PreferenceCenterGetConfigResponse =
        getConfig(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see [getConfig] */
    fun getConfig(
        userId: String,
        params: PreferenceCenterGetConfigParams = PreferenceCenterGetConfigParams.none(),
    ): PreferenceCenterGetConfigResponse = getConfig(userId, params, RequestOptions.none())

    /** @see [getConfig] */
    fun getConfig(
        params: PreferenceCenterGetConfigParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PreferenceCenterGetConfigResponse

    /** @see [getConfig] */
    fun getConfig(params: PreferenceCenterGetConfigParams): PreferenceCenterGetConfigResponse =
        getConfig(params, RequestOptions.none())

    /** @see [getConfig] */
    fun getConfig(
        userId: String,
        requestOptions: RequestOptions,
    ): PreferenceCenterGetConfigResponse =
        getConfig(userId, PreferenceCenterGetConfigParams.none(), requestOptions)

    /**
     * Generates a signed preference center URL and token for the given user in the current
     * environment.
     */
    fun generateSignedUrl(userId: String): PreferenceCenterGenerateSignedUrlResponse =
        generateSignedUrl(userId, PreferenceCenterGenerateSignedUrlParams.none())

    /** @see [generateSignedUrl] */
    fun generateSignedUrl(
        userId: String,
        params: PreferenceCenterGenerateSignedUrlParams =
            PreferenceCenterGenerateSignedUrlParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PreferenceCenterGenerateSignedUrlResponse =
        generateSignedUrl(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see [generateSignedUrl] */
    fun generateSignedUrl(
        userId: String,
        params: PreferenceCenterGenerateSignedUrlParams =
            PreferenceCenterGenerateSignedUrlParams.none(),
    ): PreferenceCenterGenerateSignedUrlResponse =
        generateSignedUrl(userId, params, RequestOptions.none())

    /** @see [generateSignedUrl] */
    fun generateSignedUrl(
        params: PreferenceCenterGenerateSignedUrlParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PreferenceCenterGenerateSignedUrlResponse

    /** @see [generateSignedUrl] */
    fun generateSignedUrl(
        params: PreferenceCenterGenerateSignedUrlParams
    ): PreferenceCenterGenerateSignedUrlResponse = generateSignedUrl(params, RequestOptions.none())

    /** @see [generateSignedUrl] */
    fun generateSignedUrl(
        userId: String,
        requestOptions: RequestOptions,
    ): PreferenceCenterGenerateSignedUrlResponse =
        generateSignedUrl(userId, PreferenceCenterGenerateSignedUrlParams.none(), requestOptions)

    /**
     * A view of [PreferenceCenterService] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /v1/users/{user_id}/preference_center/config`, but
         * is otherwise the same as [PreferenceCenterService.getConfig].
         */
        @MustBeClosed
        fun getConfig(userId: String): HttpResponseFor<PreferenceCenterGetConfigResponse> =
            getConfig(userId, PreferenceCenterGetConfigParams.none())

        /** @see [getConfig] */
        @MustBeClosed
        fun getConfig(
            userId: String,
            params: PreferenceCenterGetConfigParams = PreferenceCenterGetConfigParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PreferenceCenterGetConfigResponse> =
            getConfig(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see [getConfig] */
        @MustBeClosed
        fun getConfig(
            userId: String,
            params: PreferenceCenterGetConfigParams = PreferenceCenterGetConfigParams.none(),
        ): HttpResponseFor<PreferenceCenterGetConfigResponse> =
            getConfig(userId, params, RequestOptions.none())

        /** @see [getConfig] */
        @MustBeClosed
        fun getConfig(
            params: PreferenceCenterGetConfigParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PreferenceCenterGetConfigResponse>

        /** @see [getConfig] */
        @MustBeClosed
        fun getConfig(
            params: PreferenceCenterGetConfigParams
        ): HttpResponseFor<PreferenceCenterGetConfigResponse> =
            getConfig(params, RequestOptions.none())

        /** @see [getConfig] */
        @MustBeClosed
        fun getConfig(
            userId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PreferenceCenterGetConfigResponse> =
            getConfig(userId, PreferenceCenterGetConfigParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/users/{user_id}/preference_center/signed_url`,
         * but is otherwise the same as [PreferenceCenterService.generateSignedUrl].
         */
        @MustBeClosed
        fun generateSignedUrl(
            userId: String
        ): HttpResponseFor<PreferenceCenterGenerateSignedUrlResponse> =
            generateSignedUrl(userId, PreferenceCenterGenerateSignedUrlParams.none())

        /** @see [generateSignedUrl] */
        @MustBeClosed
        fun generateSignedUrl(
            userId: String,
            params: PreferenceCenterGenerateSignedUrlParams =
                PreferenceCenterGenerateSignedUrlParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PreferenceCenterGenerateSignedUrlResponse> =
            generateSignedUrl(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see [generateSignedUrl] */
        @MustBeClosed
        fun generateSignedUrl(
            userId: String,
            params: PreferenceCenterGenerateSignedUrlParams =
                PreferenceCenterGenerateSignedUrlParams.none(),
        ): HttpResponseFor<PreferenceCenterGenerateSignedUrlResponse> =
            generateSignedUrl(userId, params, RequestOptions.none())

        /** @see [generateSignedUrl] */
        @MustBeClosed
        fun generateSignedUrl(
            params: PreferenceCenterGenerateSignedUrlParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PreferenceCenterGenerateSignedUrlResponse>

        /** @see [generateSignedUrl] */
        @MustBeClosed
        fun generateSignedUrl(
            params: PreferenceCenterGenerateSignedUrlParams
        ): HttpResponseFor<PreferenceCenterGenerateSignedUrlResponse> =
            generateSignedUrl(params, RequestOptions.none())

        /** @see [generateSignedUrl] */
        @MustBeClosed
        fun generateSignedUrl(
            userId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PreferenceCenterGenerateSignedUrlResponse> =
            generateSignedUrl(
                userId,
                PreferenceCenterGenerateSignedUrlParams.none(),
                requestOptions,
            )
    }
}
