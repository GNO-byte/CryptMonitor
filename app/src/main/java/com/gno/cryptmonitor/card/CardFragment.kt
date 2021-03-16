package com.gno.cryptmonitor.card

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.gno.cryptmonitor.MyApp
import com.gno.cryptmonitor.R
import kotlinx.android.synthetic.main.fragment_card.*
import javax.inject.Inject

class CardFragment : Fragment(R.layout.fragment_card) {

    lateinit var cardViewModel: CardViewModel
        @Inject set

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        MyApp.appComponent.inject(this)

        val index = arguments?.getInt("index")

        cardViewModel.popularMoviesLiveData.observe(viewLifecycleOwner, Observer {

            val data = it[index!!]

            fragment_card_symbol?.text = data.symbol
            fragment_card_name?.text = data.name
            room_card_phone_cmcrank_value?.text = data.cmc_rank.toString()
            room_card_phone_price_value?.text = data.quote.USD.price.toString()

        })
    }
}


