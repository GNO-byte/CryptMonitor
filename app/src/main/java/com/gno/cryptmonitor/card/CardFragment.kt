package com.gno.cryptmonitor.card

import android.app.Application
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
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

        arguments?.let { bundle ->
            val index = bundle.getInt("index")
            context?.let {
                cardViewModel.getData(Utils.getKey(it.applicationContext as Application), index)
            }
        }

        cardViewModel.currentDataLiveData.observe(viewLifecycleOwner) {

            fragment_card_symbol.text = it.symbol
            fragment_card_name.text = it.name
            room_card_phone_cmcrank_value.text = it.cmc_rank.toString()
            room_card_phone_price_value.text = it.quote.USD.price.toString()

        }
    }
}


