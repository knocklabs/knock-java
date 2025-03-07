package com.knock.api.errors

import com.knock.api.core.http.Headers

class PermissionDeniedException(headers: Headers, body: String, error: KnockError) :
    KnockServiceException(403, headers, body, error)
