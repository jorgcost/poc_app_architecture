package com.presentation.feature_a

internal sealed interface FeatureAUiAction {
    data object OnClickChangeColor : FeatureAUiAction
}