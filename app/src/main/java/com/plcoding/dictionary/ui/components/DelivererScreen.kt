package com.plcoding.dictionary.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.plcoding.dictionary.feature_deliverer.presentation.DelivererIntoItem
import com.plcoding.dictionary.feature_deliverer.presentation.DelivererViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun DelivererScreen(viewModel: DelivererViewModel = hiltViewModel()) {
    val state = viewModel.state.value
    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is DelivererViewModel.UIEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message
                    )
                }
            }
        }
    }


    Scaffold(
        scaffoldState = scaffoldState
    ) { Box(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            TextField(
                value = viewModel.searchQuery.value,
                onValueChange = viewModel::onSearch,
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(text = "Search...")
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(state.delivererInfoItems.size) { i ->
                    val deliverer = state.delivererInfoItems[i]
                    if (i > 0) {
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                    DelivererIntoItem(deliverer = deliverer)
                    if (i < state.delivererInfoItems.size - 1) {
                        Divider()
                    }
                    }
            }
        }
    }

}

}