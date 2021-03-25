package com.gno.cryptmonitor.retrofit

import com.gno.cryptmonitor.common.MyApp
import javax.inject.Inject

object Api {
    const val BASE_URL = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/"
    const val DEFAULT_LIMIT = 30

    lateinit var retrofitService: RetrofitServices
        @Inject set

    init {
        MyApp.appComponent.inject(this)
    }

}