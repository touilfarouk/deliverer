package com.plcoding.dictionary.feature_deliverer.data.remote.dto

import com.plcoding.dictionary.feature_deliverer.data.local.entity.DelivererEntity

data class DelivererDto(
    val name: String
){
    fun toDelivererEntity(): DelivererEntity {
        return DelivererEntity(
            name = name
        )
    }
}
