package com.presentation.feature_b

internal sealed interface FeatureBUiAction {
    data object OnClickChangeColor : FeatureBUiAction
}