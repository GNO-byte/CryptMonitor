package com.gno.cryptmonitor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragment_list_recyclerview.layoutManager = LinearLayoutManager(activity)

        val tmdbViewModel = ViewModelProvider(requireActivity()).get(TmdbViewModel::class.java)

        tmdbViewModel.popularMoviesLiveData.observe(viewLifecycleOwner, Observer { it ->

            fragment_list_recyclerview.adapter = CustomRecyclerAdapter(it) { index ->
                onCellClickListener(index)
            }
        })
    }

    private fun onCellClickListener(index: Int) {
        var bundle = bundleOf("index" to index)
        findNavController().navigate(R.id.action_listFragment_to_cardFragment, bundle)
    }
}
