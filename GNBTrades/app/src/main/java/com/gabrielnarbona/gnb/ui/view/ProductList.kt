package com.gabrielnarbona.gnb.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.gabrielnarbona.gnb.data.model.Product
import com.gabrielnarbona.gnb.databinding.FragmentProductListBinding
import com.gabrielnarbona.gnb.ui.productlist.ProductListAdapter
import com.gabrielnarbona.gnb.ui.viewmodel.ProductListViewModel

class ProductList : Fragment() {

    private lateinit var binding: FragmentProductListBinding
    private val productListViewModel: ProductListViewModel by viewModels()

    private lateinit var adapter: ProductListAdapter
    private var pList = mutableListOf<Product>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        requireActivity().onBackPressedDispatcher.addCallback(this) {}
        binding = FragmentProductListBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        productListViewModel.onCreate()
        productObserver()
        progressObserver()
    }

    private fun initRecyclerView() {
        adapter = ProductListAdapter(pList)
        binding.rvProducts.layoutManager = LinearLayoutManager(requireContext())
        binding.rvProducts.adapter = adapter
    }

    private fun productObserver() {
        productListViewModel.product.observe(requireActivity()) {
            adapter = ProductListAdapter(ProductListViewModel.list)
            binding.rvProducts.adapter = adapter
        }
    }

    private fun progressObserver() {
        productListViewModel.isLoading.observe(requireActivity()) {
            binding.progress.isVisible = it
        }
    }
}