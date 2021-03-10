package com.gno.cryptmonitor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

// В сингл-активити viewModel должен быть в фрагменте

/**
 * TODO:
 *  1) Создать App: Application (прописать в манифесте)
 *  2) Dependency Injection: Dagger2
 *  3) Структура пакетов - название по фичам
 *  4) Разные ViewModel для разных вьюх
 *  5) buildFlavor
 */
class MainActivity : AppCompatActivity() {

    private lateinit var tmdbViewModel: TmdbViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // FIXME: убрать
        tmdbViewModel = ViewModelProviders.of(this).get(TmdbViewModel::class.java)

        tmdbViewModel.getDate()

        tmdbViewModel.popularMoviesLiveData.observe(this, Observer {

           var n=1;

        })
    }

}
