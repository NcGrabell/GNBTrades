package com.gabrielnarbona.gnb.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gabrielnarbona.gnb.data.model.Product
import com.gabrielnarbona.gnb.domain.GetProductsUseCase
import kotlinx.coroutines.launch

class ProductListViewModel : ViewModel() {

    companion object {
        lateinit var list: List<Product>
    }

    val product = MutableLiveData<Product>()

    val isLoading = MutableLiveData<Boolean>()

    var getProductUseCase = GetProductsUseCase()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getProductUseCase()
            list = result

            if (result.isNotEmpty()) {
                product.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

}