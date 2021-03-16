package com.gno.cryptmonitor.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.gno.cryptmonitor.Utils
import com.gno.cryptmonitor.retrofit.Api
import com.gno.cryptmonitor.retrofit.Data
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import ru.gildor.coroutines.retrofit.Result
import ru.gildor.coroutines.retrofit.awaitResult
import kotlin.coroutines.CoroutineContext

class ListViewModel(application: Application) : AndroidViewModel(application) {

    //AndroidViewModel
    private val context = getApplication<Application>().applicationContext

    //LiveData
    private val parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default
    private val scope = CoroutineScope(coroutineContext)
    val popularMoviesLiveData = MutableLiveData<List<Data>>()

    private val key = Utils.getKey(context as Application);

    init {
        scope.launch {
            val call = Api.retrofitService.getDataList(key).awaitResult()
            popularMoviesLiveData.postValue((call as Result.Ok).value.data)
        }
    }

}


