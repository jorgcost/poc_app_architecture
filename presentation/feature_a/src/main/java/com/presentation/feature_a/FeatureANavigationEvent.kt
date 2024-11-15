package com.presentation.feature_a

sealed interface FeatureANavigationEvent {
    data object NavigateToPreviousScreen : FeatureANavigationEvent

    data class NavigateToNextScreen(
        val colorInt: Int?
    ) : FeatureANavigationEvent
}