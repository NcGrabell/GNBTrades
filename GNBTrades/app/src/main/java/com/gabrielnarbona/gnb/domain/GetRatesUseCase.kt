package com.gabrielnarbona.gnb.domain

import com.gabrielnarbona.gnb.data.GNBRepository
import com.gabrielnarbona.gnb.data.model.Rate

class GetRatesUseCase {

    private val repository = GNBRepository()

    suspend operator fun invoke(): List<Rate> = repository.getAllRates()

}