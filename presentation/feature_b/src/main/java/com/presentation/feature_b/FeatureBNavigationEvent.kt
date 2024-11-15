package com.presentation.feature_b

sealed interface FeatureBNavigationEvent {
    data object NavigateToPreviousScreen : FeatureBNavigationEvent

    data class NavigateToNextScreen(
        val text: String? = null
    ) : FeatureBNavigationEvent
}