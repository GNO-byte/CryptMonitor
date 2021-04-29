package com.gno.cryptmonitor.list

import android.app.Application
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
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

        context?.let{
            listViewModel.loadData(Utils.getKey(it.applicationContext as Application), true)
        }
        
        initRecyclerVIew()

        listViewModel.listDataLiveData.observe(viewLifecycleOwner) {
            customRecyclerAdapter.submitList(it)
        }
    }

    private fun initRecyclerVIew() {

        val scrollListener = object :
            RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val visibleItemCount =
                    recyclerView.layoutManager?.childCount ?: 0
                val totalItemCount = recyclerView.layoutManager?.itemCount ?: 0
                val firstVisibleItems =
                    (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()

                if (totalItemCount != 0 && (visibleItemCount + firstVisibleItems) >= totalItemCount - visibleItemCount) {
                    context?.let {
                        listViewModel.loadData(
                            Utils.getKey(it.applicationContext as Application),
                            false
                        )
                    }

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
