package com.gabrielnarbona.gnb.ui.transactiondetails

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.gabrielnarbona.gnb.core.Util
import com.gabrielnarbona.gnb.data.model.Product
import com.gabrielnarbona.gnb.databinding.ItemTransactionDetailsBinding

class TransactionDetailsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemTransactionDetailsBinding.bind(view)

    fun fillViewHolder(element: Product) {
        binding.tvProductName.text = element.sku
        binding.tvProductAmount.text = Util.round(element.amount).toString()
        binding.tvProductCurrency.text = element.currency
    }
}