package com.gno.cryptmonitor.retrofit

import ru.gildor.coroutines.retrofit.awaitResult

object Run {

    lateinit var mService: RetrofitServices
    val key = "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"

     suspend fun getData() {

         var call = Common.retrofitService.getDataList(key).awaitResult();

       //  var call = mService.getDataList(key).awaitResult();
         var n = 1
    }

}