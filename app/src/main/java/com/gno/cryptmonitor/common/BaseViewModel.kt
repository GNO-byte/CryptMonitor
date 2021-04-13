package com.gno.cryptmonitor.common

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gno.cryptmonitor.retrofit.Data
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel : ViewModel() {

    //Coroutines
    private val parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default
    val scope = CoroutineScope(coroutineContext)

    //LiveData
    val popularMoviesLiveData = MutableLiveData<List<Data>>()

    override fun onCleared() {
        scope.cancel()
    }
}