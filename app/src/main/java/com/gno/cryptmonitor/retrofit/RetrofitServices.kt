package com.gno.cryptmonitor.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface RetrofitServices {

    @GET("listings/latest")
    fun getDataList(@Header("X-CMC_PRO_API_KEY") key: String): Call<Answer>

}