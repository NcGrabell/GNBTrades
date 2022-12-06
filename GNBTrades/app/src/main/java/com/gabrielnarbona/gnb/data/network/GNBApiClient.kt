package com.gabrielnarbona.gnb.data.network

import com.gabrielnarbona.gnb.data.model.Product
import com.gabrielnarbona.gnb.data.model.Rate
import retrofit2.Response
import retrofit2.http.GET

interface GNBApiClient {

    @GET("transactions")
    suspend fun getAllProducts(): Response<List<Product>>

    @GET("rates")
    suspend fun getAllRates(): Response<List<Rate>>
}