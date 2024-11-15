package com.presentation.feature_b

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.presentation.core.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
internal class FeatureBViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    init {
        val route = savedStateHandle.toRoute<Route.FeatureB>()
        viewModelScope.launch(Dispatchers.Main) {
            state = route.colorInt?.let { colorInt ->
                FeatureBUiState.Success(lastScreenColor = Color(colorInt))
            } ?: FeatureBUiState.Success()
        }
    }

    var state by mutableStateOf<FeatureBUiState>(FeatureBUiState.Loading())
        private set

    fun onUiEvent(event: FeatureBUiAction) {
        when (event) {
            FeatureBUiAction.OnClickChangeColor -> changeBackgroundColor()
        }
    }

    private fun changeBackgroundColor() {
        state.asSuccess()?.let { oldState ->
            state = oldState.copy(color = Color(Random.nextInt()))
        }
    }

    private fun FeatureBUiState.asSuccess() = this as? FeatureBUiState.Success
}
