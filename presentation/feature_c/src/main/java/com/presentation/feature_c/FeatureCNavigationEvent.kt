package com.presentation.feature_c

sealed interface FeatureCNavigationEvent {
    data object onClickFirstButton : FeatureCNavigationEvent
    data object onClickSecondButton : FeatureCNavigationEvent
    data object NavigateToPreviousScreen : FeatureCNavigationEvent
}