package com.gno.cryptmonitor.common

import android.app.Application
import com.gno.cryptmonitor.di.AppComponent


class MyApp : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

}