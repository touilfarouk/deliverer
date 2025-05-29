package com.plcoding.dictionary.feature_deliverer.domain.use_case

import com.plcoding.dictionary.core.util.Resource
import com.plcoding.dictionary.feature_deliverer.domain.model.Deliverer
import com.plcoding.dictionary.feature_deliverer.domain.repository.DelivererInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetDelivererInfo(
    private val repository: DelivererInfoRepository
) {
    operator fun invoke(name:  String): Flow<Resource<List<Deliverer>>>  {
        if(name.isBlank()) {
            return flow {  }
        }
        return repository.getDelivererInfo(name)
    }
}