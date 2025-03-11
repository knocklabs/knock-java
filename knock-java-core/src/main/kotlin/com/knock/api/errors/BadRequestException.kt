package com.knock.api.errors

import com.knock.api.core.http.Headers

class BadRequestException(
        headers: Headers,
        body: String,
        error: KnockError,
) : KnockServiceException(400, headers, body, error)
