package com.gno.cryptmonitor

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_card.*

class CardFragment : Fragment(R.layout.fragment_card) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // FIXME: переопределять не надо
        super.onViewCreated(view, savedInstanceState)

        val tmdbViewModel = ViewModelProvider(requireActivity()).get(TmdbViewModel::class.java)
        val index = arguments?.getInt("index")

        tmdbViewModel.popularMoviesLiveData.observe(viewLifecycleOwner, Observer {

            val data = it[index!!]

            fragment_card_symbol?.text = data.symbol
            fragment_card_name?.text = data.name
            room_card_phone_cmcrank_value?.text = data.cmc_rank.toString()
            room_card_phone_price_value?.text = data.quote.USD.price.toString()

        })
    }
}


