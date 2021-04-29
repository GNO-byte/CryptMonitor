package com.gno.cryptmonitor.list

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.gno.cryptmonitor.common.BaseViewModel
import com.gno.cryptmonitor.retrofit.Api
import com.gno.cryptmonitor.retrofit.Data
import kotlinx.coroutines.launch


class ListViewModel : BaseViewModel() {

    val listDataLiveData = MutableLiveData<List<Data>>()
    private var isLoading = false

    fun loadData(key: String, firstLoad: Boolean) {
        scope.launch {

            val commonListData =  ArrayList<Data>()
            commonListData.addAll(listDataLiveData.value ?: ArrayList())

            if (!isLoading && (commonListData.isEmpty() || !firstLoad)) {
                isLoading = true
                try {
                    val answer =
                        Api.retrofitService.getDataList(
                            key,
                            Api.DEFAULT_LIMIT,
                            commonListData.size + 1
                        )
                    commonListData.addAll(answer.data)
                    listDataLiveData.postValue(commonListData.toList())
                } catch (e: Exception) {
                    Log.e(ListViewModel::class.qualifiedName, e.message, e)
                }
                isLoading = false

            }
        }

    }
}

