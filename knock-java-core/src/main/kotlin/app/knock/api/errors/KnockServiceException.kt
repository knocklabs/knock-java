package app.knock.api.errors

import app.knock.api.core.http.Headers

abstract class KnockServiceException
@JvmOverloads
constructor(
    private val statusCode: Int,
    private val headers: Headers,
    private val body: String,
    private val error: KnockError,
    message: String = "$statusCode: $error",
    cause: Throwable? = null,
) : KnockException(message, cause) {

    fun statusCode(): Int = statusCode

    fun headers(): Headers = headers

    fun body(): String = body

    fun error(): KnockError = error
}
