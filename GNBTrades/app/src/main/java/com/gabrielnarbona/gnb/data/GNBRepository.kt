package com.gabrielnarbona.gnb.data

import com.gabrielnarbona.gnb.data.model.Product
import com.gabrielnarbona.gnb.data.model.GNBProvider
import com.gabrielnarbona.gnb.data.model.Rate
import com.gabrielnarbona.gnb.data.network.GNBService

class GNBRepository {

    private val api = GNBService()

    suspend fun getAllProducts(): List<Product> {
        val response = api.getProducts()
        GNBProvider.products = response
        return response
    }

    suspend fun getAllRates(): List<Rate> {
        val response = api.getRates()
        GNBProvider.rates = response
        return response
    }

}