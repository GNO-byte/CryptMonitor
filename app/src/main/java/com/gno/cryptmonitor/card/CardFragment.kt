package com.gno.cryptmonitor.card

import android.app.Application
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.gno.cryptmonitor.R
import com.gno.cryptmonitor.common.MyApp
import com.gno.cryptmonitor.common.Utils
import kotlinx.android.synthetic.main.fragment_card.*
import javax.inject.Inject

class CardFragment : Fragment(R.layout.fragment_card) {

    @Inject
    lateinit var cardViewModel: CardViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        MyApp.appComponent.inject(this)

        val index = arguments?.getInt("index")
        cardViewModel.getData(Utils.getKey(context?.applicationContext as Application), index!!)

        cardViewModel.popularMoviesLiveData.observe(viewLifecycleOwner, Observer {

            fragment_card_symbol?.text = it[0].symbol
            fragment_card_name?.text = it[0].name
            room_card_phone_cmcrank_value?.text = it[0].cmc_rank.toString()
            room_card_phone_price_value?.text = it[0].quote.USD.price.toString()

        })
    }
}


