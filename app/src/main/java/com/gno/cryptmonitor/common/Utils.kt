package com.gno.cryptmonitor.common

import android.app.Application

object Utils {

    fun getKey(context: Application): String {
        return context.getString(
            context.resources.getIdentifier(
                "API_KEY",
                "string",
                context.packageName
            )
        )
    }
}