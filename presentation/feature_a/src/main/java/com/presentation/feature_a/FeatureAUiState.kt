package com.presentation.feature_a

import androidx.compose.ui.graphics.Color

internal sealed class FeatureAUiState {
    data object Loading : FeatureAUiState()

    data class Success(
        val data: String = "Feature A",
        val color: Color? = null,
        val lastScreenColor: Color? = null
    ) : FeatureAUiState()
}
