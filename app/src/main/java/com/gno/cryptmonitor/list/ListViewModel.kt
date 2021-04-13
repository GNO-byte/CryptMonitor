package com.gno.cryptmonitor.list

import android.app.Application
import com.gno.cryptmonitor.common.BaseViewModel
import com.gno.cryptmonitor.retrofit.Api
import com.gno.cryptmonitor.retrofit.Data
import kotlinx.coroutines.launch


class ListViewModel : BaseViewModel() {

    private var commonListData = ArrayList<Data>()

    fun getData(key: String) {
        scope.launch {
            val answer =
                Api.retrofitService.getDataList(key, Api.DEFAULT_LIMIT, commonListData.size + 1)

            commonListData.addAll(answer.data)
            var newListData: ArrayList<Data> = ArrayList(commonListData)

            popularMoviesLiveData.postValue(newListData)
        }
    }

}


