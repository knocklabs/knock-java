package app.knock.api.errors

import app.knock.api.core.http.Headers

class UnauthorizedException(
        headers: Headers,
        body: String,
        error: KnockError,
) : KnockServiceException(401, headers, body, error)
