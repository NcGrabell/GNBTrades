package com.gabrielnarbona.gnb.ui.transactiondetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gabrielnarbona.gnb.R
import com.gabrielnarbona.gnb.data.model.Product

class TransactionDetailsAdapter(private val productList: List<Product>) :
    RecyclerView.Adapter<TransactionDetailsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionDetailsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TransactionDetailsViewHolder(
            layoutInflater.inflate(
                R.layout.item_transaction_details,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TransactionDetailsViewHolder, position: Int) {
        holder.fillViewHolder(productList[position])
    }

    override fun getItemCount(): Int = productList.size


}