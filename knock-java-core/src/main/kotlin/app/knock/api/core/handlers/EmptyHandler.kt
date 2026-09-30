@file:JvmName("EmptyHandler")

package app.knock.api.core.handlers

import app.knock.api.core.http.HttpResponse
import app.knock.api.core.http.HttpResponse.Handler

@JvmSynthetic internal fun emptyHandler(): Handler<Void?> = EmptyHandlerInternal

private object EmptyHandlerInternal : Handler<Void?> {
    override fun handle(response: HttpResponse): Void? = null
}
