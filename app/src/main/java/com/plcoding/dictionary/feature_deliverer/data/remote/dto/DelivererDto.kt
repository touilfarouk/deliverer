package com.plcoding.dictionary.feature_deliverer.data.remote.dto

import com.plcoding.dictionary.feature_deliverer.domain.model.Product
import com.plcoding.dictionary.feature_deliverer.data.local.entity.DelivererEntity


data class DelivererDto(
    val name: String,
    val products: List<ProductDto>?
) {
    fun toDelivererEntity(): DelivererEntity {
        return DelivererEntity(
            name = name,
            products = products?.map { it.toProduct() } // Convert DTO → domain.Product
        )
    }
}

