package com.gno.cryptmonitor.retrofit

import com.gno.cryptmonitor.MyApp
import javax.inject.Inject

object Api {
    const val BASE_URL = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/"

    lateinit var retrofitService: RetrofitServices
        @Inject set

    init {
        MyApp.appComponent.inject(this)
    }

}