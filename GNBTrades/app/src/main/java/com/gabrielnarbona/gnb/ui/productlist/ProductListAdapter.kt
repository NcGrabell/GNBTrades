package com.gabrielnarbona.gnb.ui.productlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gabrielnarbona.gnb.R
import com.gabrielnarbona.gnb.data.model.Product

class ProductListAdapter(private val productList: List<Product>) :
    RecyclerView.Adapter<ProductListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ProductListViewHolder(
            layoutInflater.inflate(
                R.layout.item_list_product,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int) {
        holder.fillViewHolder(productList[position])
    }

    override fun getItemCount(): Int = productList.size


}