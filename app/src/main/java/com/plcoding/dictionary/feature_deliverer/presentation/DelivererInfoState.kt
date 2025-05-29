package com.plcoding.dictionary.feature_deliverer.presentation

import com.plcoding.dictionary.feature_deliverer.domain.model.Deliverer

data class DelivererInfoState(
    val delivererInfoItems: List<Deliverer> = emptyList(),
    val isLoading: Boolean = false
)
