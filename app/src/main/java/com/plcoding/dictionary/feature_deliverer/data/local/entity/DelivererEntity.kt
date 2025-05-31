package com.plcoding.dictionary.feature_deliverer.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.plcoding.dictionary.feature_deliverer.domain.model.Deliverer
import com.plcoding.dictionary.feature_deliverer.domain.model.Product

@Entity
data class DelivererEntity(
    val name: String,
    val products: List<Product>?, // MUST be domain Product if you're serializing it
    @PrimaryKey val id: Int? = null
){
    fun toDeliverer(): Deliverer {
        return Deliverer(
            name = name,
            products = products
        )
    }
}