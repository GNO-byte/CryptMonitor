package com.gno.cryptmonitor.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    // FIXME: убрать, если не используется
    private var retrofit: Retrofit? = null

    fun getClient(baseUrl: String): Retrofit {
        // TODO: просто return
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }
}