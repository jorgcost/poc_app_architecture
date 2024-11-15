package com.presentation.feature_a

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
internal class FeatureAViewModel @Inject constructor() : ViewModel() {

    init {
        viewModelScope.launch {
            // Loading simulation
            delay(1000)

            // Update State
            state = FeatureAUiState.Success()
        }
    }

    var state by mutableStateOf<FeatureAUiState>(FeatureAUiState.Loading)
        private set

    fun onUiEvent(event: FeatureAUiAction) {
        when (event) {
            FeatureAUiAction.OnClickChangeColor -> changeBackgroundColor()
        }
    }

    private fun changeBackgroundColor() {
        state.asSuccess()?.let { oldState ->
            state = oldState.copy(color = Color(Random.nextInt()))
        }
    }

    private fun FeatureAUiState.asSuccess() = this as? FeatureAUiState.Success
}
