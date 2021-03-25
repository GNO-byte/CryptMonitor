package com.gno.cryptmonitor.retrofit

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RetrofitServices {

    @GET("listings/latest")
    suspend fun getDataList(
        @Header("X-CMC_PRO_API_KEY") key: String,
        @Query("limit") limit: Int,
        @Query("start") start: Int
    ): Answer

}