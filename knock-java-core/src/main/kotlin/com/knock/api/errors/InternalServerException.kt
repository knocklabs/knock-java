package com.knock.api.errors

import com.knock.api.core.http.Headers

class InternalServerException(statusCode: Int, headers: Headers, body: String, error: KnockError) :
    KnockServiceException(statusCode, headers, body, error)
