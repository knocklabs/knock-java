// File generated from our OpenAPI spec by Stainless.

package app.knock.api.errors

import app.knock.api.core.JsonValue
import app.knock.api.core.http.Headers

abstract class KnockServiceException
protected constructor(message: String, cause: Throwable? = null) : KnockException(message, cause) {

    abstract fun statusCode(): Int

    abstract fun headers(): Headers

    abstract fun body(): JsonValue
}
