package com.gabrielnarbona.gnb.ui.productlist

import android.view.View
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.gabrielnarbona.gnb.R
import com.gabrielnarbona.gnb.data.model.Product
import com.gabrielnarbona.gnb.databinding.ItemListProductBinding

class ProductListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    companion object {
        lateinit var selectedProduct: Product
    }

    private val binding = ItemListProductBinding.bind(view)

    fun fillViewHolder(element: Product) {
        binding.tvProductName.text = element.sku

        binding.cardView.setOnClickListener {
            selectedProduct = element
            Navigation.findNavController(itemView)
                .navigate(R.id.action_productList_to_transactionDetailsFragment)
        }
    }
}