package com.gno.cryptmonitor.retrofit

object Common {
    private val BASE_URL = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/"
    val retrofitService: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}