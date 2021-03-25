package com.gno.cryptmonitor.list

import android.app.Application
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gno.cryptmonitor.R
import com.gno.cryptmonitor.common.MyApp
import com.gno.cryptmonitor.common.Utils
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject

class ListFragment : Fragment(R.layout.fragment_list) {

    @Inject
    lateinit var listViewModel: ListViewModel
    private val customRecyclerAdapter = CustomRecyclerAdapter { index ->
        onCellClickListener(index)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        MyApp.appComponent.inject(this)

        listViewModel.getData(Utils.getKey(context?.applicationContext as Application))

        initRecyclerVIew()

        listViewModel.popularMoviesLiveData.observe(viewLifecycleOwner, Observer {
            customRecyclerAdapter.submitList(it)
        })
    }

    private fun initRecyclerVIew() {

        val scrollListener = object :
            RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val visibleItemCount =
                    recyclerView.layoutManager?.childCount
                val totalItemCount = recyclerView.layoutManager?.itemCount
                val firstVisibleItems =
                    (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()

                if ((visibleItemCount!! + firstVisibleItems) >= totalItemCount!!) {
                    listViewModel.getData(Utils.getKey(context?.applicationContext as Application))
                }
            }
        }

        fragment_list_recyclerview.adapter = customRecyclerAdapter
        fragment_list_recyclerview.addOnScrollListener(scrollListener)

    }

    private fun onCellClickListener(index: Int) {
        val bundle = bundleOf("index" to index)
        findNavController().navigate(R.id.action_listFragment_to_cardFragment, bundle)
    }

}
