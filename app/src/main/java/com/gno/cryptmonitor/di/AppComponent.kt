package com.gno.cryptmonitor.di

import com.gno.cryptmonitor.card.CardFragment
import com.gno.cryptmonitor.list.ListFragment
import com.gno.cryptmonitor.retrofit.Api
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    //ViewModel
    fun inject(cardFragment: CardFragment)
    fun inject(listFragment: ListFragment)

    //Retrofit
    fun inject(api: Api)
}
