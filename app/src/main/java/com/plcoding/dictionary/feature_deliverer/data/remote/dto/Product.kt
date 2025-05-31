package com.plcoding.dictionary.feature_deliverer.data.remote.dto

data class Product(
    val name: String,
    val pricePerAmount: String
) {
    fun toProduct(): Product {
        return Product(name = name, pricePerAmount = pricePerAmount)
    }
}