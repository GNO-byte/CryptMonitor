package com.gno.cryptmonitor.di

import androidx.lifecycle.ViewModelProvider
import com.gno.cryptmonitor.MainActivity
import com.gno.cryptmonitor.card.CardViewModel
import com.gno.cryptmonitor.list.ListViewModel
import com.gno.cryptmonitor.retrofit.Api
import com.gno.cryptmonitor.retrofit.RetrofitServices
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule(private val activity: MainActivity) {

    //ViewModel
    @Provides
    fun cardViewModel(): CardViewModel {
        return ViewModelProvider(activity).get(CardViewModel::class.java)
    }

    @Provides
    fun listViewModel(): ListViewModel {
        return ViewModelProvider(activity).get(ListViewModel::class.java)
    }

    //Retrofit
    @Provides
    @Singleton
    fun retrofitService(retrofitClient: Retrofit): RetrofitServices {
        return retrofitClient.create(RetrofitServices::class.java)
    }

    @Provides
    @Singleton
    fun retrofitClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Api.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


}