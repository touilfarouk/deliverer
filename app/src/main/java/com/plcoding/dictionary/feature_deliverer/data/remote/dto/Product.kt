package com.plcoding.dictionary.feature_deliverer.data.remote.dto


data class Product(
    val name: String,
    val pricePerAmount: String
) {
    fun toProduct(): com.plcoding.dictionary.feature_deliverer.domain.model.Product {
        return com.plcoding.dictionary.feature_deliverer.domain.model.Product(
            name = name,
            pricePerAmount = pricePerAmount
        )
    }
}