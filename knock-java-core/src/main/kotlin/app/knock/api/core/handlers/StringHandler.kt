@file:JvmName("StringHandler")

package app.knock.api.core.handlers

import app.knock.api.core.http.HttpResponse
import app.knock.api.core.http.HttpResponse.Handler

@JvmSynthetic internal fun stringHandler(): Handler<String> = StringHandlerInternal

private object StringHandlerInternal : Handler<String> {
    override fun handle(response: HttpResponse): String =
        response.body().readBytes().toString(Charsets.UTF_8)
}
