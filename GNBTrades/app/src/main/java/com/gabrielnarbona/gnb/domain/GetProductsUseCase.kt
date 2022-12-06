package com.gabrielnarbona.gnb.domain

import com.gabrielnarbona.gnb.data.GNBRepository
import com.gabrielnarbona.gnb.data.model.Product

class GetProductsUseCase {

    private val repository = GNBRepository()

    suspend operator fun invoke(): List<Product> = repository.getAllProducts()

}