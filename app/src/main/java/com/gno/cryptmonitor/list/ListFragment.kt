package com.gno.cryptmonitor.list

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gno.cryptmonitor.MyApp
import com.gno.cryptmonitor.R
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject

class ListFragment : Fragment(R.layout.fragment_list) {

    lateinit var listViewModel: ListViewModel
        @Inject set

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        MyApp.appComponent.inject(this)

        fragment_list_recyclerview.layoutManager = LinearLayoutManager(activity)

        listViewModel.popularMoviesLiveData.observe(viewLifecycleOwner, Observer { it ->

            fragment_list_recyclerview.adapter =
                CustomRecyclerAdapter(it) { index ->
                    onCellClickListener(index)
                }
        })
    }

    private fun onCellClickListener(index: Int) {
        val bundle = bundleOf("index" to index)
        findNavController().navigate(R.id.action_listFragment_to_cardFragment, bundle)
    }
}
