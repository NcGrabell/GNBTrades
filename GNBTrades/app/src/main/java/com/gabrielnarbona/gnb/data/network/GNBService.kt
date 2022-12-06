package com.gabrielnarbona.gnb.data.network

import com.gabrielnarbona.gnb.core.RetrofitHelper
import com.gabrielnarbona.gnb.data.model.Product
import com.gabrielnarbona.gnb.data.model.Rate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GNBService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getProducts(): List<Product> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(GNBApiClient::class.java).getAllProducts()
            response.body() ?: emptyList()
        }
    }

    suspend fun getRates(): List<Rate> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(GNBApiClient::class.java).getAllRates()
            response.body() ?: emptyList()
        }
    }
}
