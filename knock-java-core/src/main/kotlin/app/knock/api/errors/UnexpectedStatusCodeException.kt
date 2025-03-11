package app.knock.api.errors

import app.knock.api.core.http.Headers

class UnexpectedStatusCodeException(
    statusCode: Int,
    headers: Headers,
    body: String,
    error: KnockError,
) : KnockServiceException(statusCode, headers, body, error)
