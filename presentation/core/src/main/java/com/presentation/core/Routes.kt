package com.presentation.core

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object FeatureA : Route

    @Serializable
    data class FeatureB(val colorInt: Int?) : Route

    @Serializable
    data object FeatureC : Route
}
