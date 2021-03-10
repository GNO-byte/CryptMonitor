package com.gno.cryptmonitor

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gno.cryptmonitor.retrofit.Answer
import com.gno.cryptmonitor.retrofit.Common
import com.gno.cryptmonitor.retrofit.Data
import com.gno.cryptmonitor.retrofit.Run
import kotlinx.coroutines.*
import okhttp3.Call
import ru.gildor.coroutines.retrofit.Result
import ru.gildor.coroutines.retrofit.awaitResult
import kotlin.coroutines.CoroutineContext

class TmdbViewModel : ViewModel() {

    private val parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)


    //private val repository : MovieRepository = MovieRepository(ApiFactory.tmdbApi)

    val popularMoviesLiveData = MutableLiveData<List<Data>>()

    fun getDate(){
        scope.launch {

            val call = Common.retrofitService.getDataList(Run.key).awaitResult();
            popularMoviesLiveData.postValue((call as Result.Ok).value.data)

        }
    }


    fun cancelAllRequests() = coroutineContext.cancel()

}


