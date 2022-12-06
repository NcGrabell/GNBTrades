package com.gabrielnarbona.gnb.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.gabrielnarbona.gnb.data.model.Product
import com.gabrielnarbona.gnb.databinding.FragmentTransactionDetailsBinding
import com.gabrielnarbona.gnb.ui.productlist.ProductListViewHolder
import com.gabrielnarbona.gnb.ui.transactiondetails.TransactionDetailsAdapter
import com.gabrielnarbona.gnb.ui.viewmodel.ProductListViewModel
import com.gabrielnarbona.gnb.ui.viewmodel.TransactionDetailsViewModel

class TransactionDetailsFragment : Fragment() {

    private val transactionDetailsViewModel: TransactionDetailsViewModel by viewModels()
    private lateinit var binding: FragmentTransactionDetailsBinding

    private lateinit var adapter: TransactionDetailsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTransactionDetailsBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        transactionDetailsViewModel.onCreate()
    }

    private fun initRecyclerView() {
        val tmpList = mutableListOf<Product>()
        ProductListViewModel.list.forEach {
            if (it.sku == ProductListViewHolder.selectedProduct.sku) {
                tmpList.add(it)
            }
        }

        adapter = TransactionDetailsAdapter(tmpList)
        binding.rvTransactionDetails.layoutManager = LinearLayoutManager(requireContext())
        binding.rvTransactionDetails.adapter = adapter
        binding.tvTotalSum.text =
            "Total sum: " + transactionDetailsViewModel.getTotalSum(tmpList) + " EUR"
    }
}