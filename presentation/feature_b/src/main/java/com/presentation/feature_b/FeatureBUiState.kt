package com.presentation.feature_b

import androidx.compose.ui.graphics.Color

internal sealed class FeatureBUiState {
    abstract val lastScreenColor: Color?

    data class Loading(
        override val lastScreenColor: Color? = null
    ) : FeatureBUiState()

    data class Success(
        override val lastScreenColor: Color? = null,
        val data: String = "Feature B",
        val color: Color? = null
    ) : FeatureBUiState()
}
