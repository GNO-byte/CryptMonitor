package com.gno.cryptmonitor.card

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.gno.cryptmonitor.common.BaseViewModel
import com.gno.cryptmonitor.retrofit.Api
import com.gno.cryptmonitor.retrofit.Data
import com.gno.cryptmonitor.retrofit.createEmptyData
import kotlinx.coroutines.launch

class CardViewModel : BaseViewModel() {

    private var latestIndex = -1
    private var isLoading = false
    private val emptyData: Data by lazy { createEmptyData() }

    val currentDataLiveData = MutableLiveData<Data>()

    fun getData(key: String, index: Int) {
        scope.launch {
            if (!isLoading && latestIndex != index) {
                isLoading = true
                try {
                    val answer = Api.retrofitService.getDataList(key, 1, index + 1)
                    currentDataLiveData.postValue(answer.data[0])
                    latestIndex = index

                } catch (e: Exception) {
                    Log.e(CardViewModel::class.qualifiedName, e.message, e)
                    latestIndex = -1
                    currentDataLiveData.postValue(emptyData)
                }
                isLoading = false
            }
        }

    }

}
