package com.knock.api.errors

import com.knock.api.core.http.Headers

class UnauthorizedException(
        headers: Headers,
        body: String,
        error: KnockError,
) : KnockServiceException(401, headers, body, error)
