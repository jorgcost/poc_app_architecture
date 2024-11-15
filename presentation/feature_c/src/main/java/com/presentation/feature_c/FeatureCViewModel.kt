package com.presentation.feature_c

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class FeatureCViewModel @Inject constructor() : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.Default) {
            delay(1000)
            state = FeatureCUiState.Success
        }
    }

    var state by mutableStateOf<FeatureCUiState>(FeatureCUiState.Loading)
        private set
}