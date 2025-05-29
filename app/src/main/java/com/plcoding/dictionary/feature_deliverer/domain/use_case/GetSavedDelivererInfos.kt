package com.plcoding.dictionary.feature_deliverer.domain.use_case

import com.plcoding.dictionary.feature_deliverer.domain.model.Deliverer
import com.plcoding.dictionary.feature_deliverer.domain.repository.DelivererInfoRepository
import kotlinx.coroutines.flow.Flow

class GetSavedDelivererInfos(
    private val repository: DelivererInfoRepository
) {
    operator fun invoke(): Flow<List<Deliverer>> = repository.getAllSavedDeliverers()
}