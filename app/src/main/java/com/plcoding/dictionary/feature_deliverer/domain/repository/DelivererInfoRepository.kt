package com.plcoding.dictionary.feature_deliverer.domain.repository

import com.plcoding.dictionary.core.util.Resource
import com.plcoding.dictionary.feature_deliverer.domain.model.Deliverer

import kotlinx.coroutines.flow.Flow

interface DelivererInfoRepository {

    fun getDelivererInfo(name: String): Flow<Resource<List<Deliverer>>>
    fun getAllSavedDeliverers(): Flow<List<Deliverer>>
}