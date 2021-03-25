package com.gno.cryptmonitor.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gno.cryptmonitor.R
import com.gno.cryptmonitor.di.AppModule
import com.gno.cryptmonitor.di.DaggerAppComponent

/**
 * TODO:
 *  1) Создать App: Application (прописать в манифесте)
 *  2) Dependency Injection: Dagger2
 *  3) Структура пакетов - название по фичам
 *  4) Разные ViewModel для разных вьюх
 *  5) buildFlavor
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MyApp.appComponent =
            DaggerAppComponent.builder().appModule(AppModule(this@MainActivity)).build()
    }

}
