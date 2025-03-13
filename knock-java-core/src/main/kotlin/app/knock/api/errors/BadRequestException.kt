package app.knock.api.errors

import app.knock.api.core.http.Headers

class BadRequestException(
        headers: Headers,
        body: String,
        error: KnockError,
) : KnockServiceException(400, headers, body, error)
