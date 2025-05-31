// ProductDto.kt
package com.plcoding.dictionary.feature_deliverer.data.remote.dto

import com.plcoding.dictionary.feature_deliverer.domain.model.Product

data class ProductDto(
    val name: String,
    val pricePerAmount: String
) {
    fun toProduct(): Product {
        return Product(name = name, pricePerAmount = pricePerAmount)
    }
}
