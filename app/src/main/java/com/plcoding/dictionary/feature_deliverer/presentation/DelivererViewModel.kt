package com.plcoding.dictionary.feature_deliverer.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.dictionary.core.util.Resource
import com.plcoding.dictionary.feature_deliverer.domain.use_case.GetDelivererInfo
import com.plcoding.dictionary.feature_deliverer.domain.use_case.GetSavedDelivererInfos
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DelivererViewModel @Inject constructor(
    private val getDelivererInfo: GetDelivererInfo,
    private val getSavedDelivererInfos: GetSavedDelivererInfos
) : ViewModel() {
    private val _searchQuery = mutableStateOf("")
    val searchQuery: State<String> = _searchQuery

    private val _state = mutableStateOf(DelivererInfoState())
    val state: State<DelivererInfoState> = _state

    private val _eventFlow = MutableSharedFlow<UIEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var searchJob: Job? = null

    init {
       loadSavedDeliverer()
    }

    private fun loadSavedDeliverer() {
        viewModelScope.launch {
            getSavedDelivererInfos()
                .onEach { savedDeliverer ->
                    _state.value = state.value.copy(
                        delivererInfoItems = savedDeliverer,
                        isLoading = false
                    )
                }
                .launchIn(this)
        }
    }

    fun onSearch(query: String) {
        _searchQuery.value = query
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(500L)
            getDelivererInfo(query)
                .onEach { result ->
                    when (result) {
                        is Resource.Success -> {
                            _state.value = state.value.copy(
                                delivererInfoItems = result.data ?: emptyList(),
                                isLoading = false
                            )
                        }
                        is Resource.Error -> {
                            _state.value = state.value.copy(
                                delivererInfoItems = result.data ?: emptyList(),
                                isLoading = false
                            )
                            _eventFlow.emit(
                                UIEvent.ShowSnackbar(result.message ?: "Unknown error")
                            )
                        }
                        is Resource.Loading -> {
                            _state.value = state.value.copy(
                                delivererInfoItems = result.data ?: emptyList(),
                                isLoading = true
                            )
                        }
                    }
                }
                .launchIn(this)
        }
    }

    sealed class UIEvent {
        data class ShowSnackbar(val message: String) : UIEvent()
    }
}
