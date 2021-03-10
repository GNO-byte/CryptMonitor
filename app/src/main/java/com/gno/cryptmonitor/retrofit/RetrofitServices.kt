package com.gno.cryptmonitor.retrofit

import kotlinx.coroutines.Deferred // FIXME
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

// Ctrl+Alt+O
// Ctrl+Alt+L - формат кода
interface RetrofitServices {

    @GET("listings/latest")
    fun getDataList(@Header("X-CMC_PRO_API_KEY") key: String): Call<Answer>

}