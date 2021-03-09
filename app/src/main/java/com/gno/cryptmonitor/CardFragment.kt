package com.gno.cryptmonitor

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment

import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import kotlinx.android.synthetic.main.fragment_card.*

class CardFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_card, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tmdbViewModel = ViewModelProvider(requireActivity()).get(TmdbViewModel::class.java)
        var index = arguments?.getInt("index")


        tmdbViewModel.popularMoviesLiveData.observe(viewLifecycleOwner, Observer {

            var data  = it[index!!]

            fragment_card_symbol?.text = data.symbol
            fragment_card_name?.text = data.name
            room_card_phone_cmcrank_value?.text = data.cmc_rank.toString()
            room_card_phone_price_value?.text = data.quote.USD.price.toString()

        })



    }


}


