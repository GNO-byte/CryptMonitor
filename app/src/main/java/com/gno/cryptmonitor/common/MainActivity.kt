package com.gno.cryptmonitor.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gno.cryptmonitor.R
import com.gno.cryptmonitor.di.AppModule
import com.gno.cryptmonitor.di.DaggerAppComponent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MyApp.appComponent =
            DaggerAppComponent.builder().appModule(AppModule(this@MainActivity)).build()
    }

}
