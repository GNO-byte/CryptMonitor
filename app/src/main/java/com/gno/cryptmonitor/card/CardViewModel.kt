package com.gno.cryptmonitor.card

import android.app.Application
import com.gno.cryptmonitor.common.BaseViewModel
import com.gno.cryptmonitor.retrofit.Api
import kotlinx.coroutines.launch

class CardViewModel() : BaseViewModel() {

    fun getData(key: String, index: Int) {
        scope.launch {
            val answer = Api.retrofitService.getDataList(key, 1, index + 1)
            popularMoviesLiveData.postValue(answer.data)
        }
    }

}


