package com.plcoding.dictionary.feature_deliverer.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.plcoding.dictionary.feature_deliverer.domain.model.Deliverer

@Entity
data class DelivererEntity(
val name: String,
@PrimaryKey val id: Int? = null
){
    fun toDeliverer(): Deliverer {
        return Deliverer(
            name = name
        )
    }
}
