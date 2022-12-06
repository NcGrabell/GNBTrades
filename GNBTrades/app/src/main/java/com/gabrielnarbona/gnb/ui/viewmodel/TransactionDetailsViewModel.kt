package com.gabrielnarbona.gnb.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gabrielnarbona.gnb.core.Util
import com.gabrielnarbona.gnb.data.model.Product
import com.gabrielnarbona.gnb.data.model.Rate
import com.gabrielnarbona.gnb.domain.GetRatesUseCase
import kotlinx.coroutines.launch

class TransactionDetailsViewModel : ViewModel() {
    private val isLoading = MutableLiveData<Boolean>()

    private val rate = MutableLiveData<Rate>()
    private var rateList: List<Rate> = listOf()

    var getRatesUseCase = GetRatesUseCase()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getRatesUseCase()
            rateList = result

            if (result.isNotEmpty()) {
                rate.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    fun getTotalSum(productList: List<Product>): Double {
        var sum = 0.0
        productList.forEach {
            sum += Util.converter(it)
        }
        return Util.round(sum)
    }
}