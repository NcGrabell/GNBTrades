package com.gabrielnarbona.gnb.data.model

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("sku") val sku: String,
    @SerializedName("amount") val amount: Double,
    @SerializedName("currency") val currency: String
)