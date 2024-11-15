package com.poc.androidapp_architecture

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.presentation.core.Route
import com.presentation.feature_a.FeatureANavigationEvent
import com.presentation.feature_a.FeatureARoot
import com.presentation.feature_b.FeatureBNavigationEvent
import com.presentation.feature_b.FeatureBRoot
import com.presentation.feature_c.FeatureCNavigationEvent
import com.presentation.feature_c.FeatureCRoot

@Composable
fun NavigationRoot(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Route.FeatureA
    ) {
        composable<Route.FeatureA> {
            FeatureARoot(
                onNavigationEvent = { navigationEvent ->
                    when (navigationEvent) {
                        FeatureANavigationEvent.NavigateToPreviousScreen -> navController.popBackStack()
                        is FeatureANavigationEvent.NavigateToNextScreen -> {
                            navController.navigate(
                                Route.FeatureB(colorInt = navigationEvent.colorInt)
                            )
                        }
                    }
                }
            )
        }

        composable<Route.FeatureB> {
            FeatureBRoot(
                onNavigationEvent = { navigationEvent ->
                    when (navigationEvent) {
                        FeatureBNavigationEvent.NavigateToPreviousScreen -> navController.popBackStack()
                        is FeatureBNavigationEvent.NavigateToNextScreen -> navController.navigate(
                            Route.FeatureC
                        )
                    }
                }
            )
        }

        composable<Route.FeatureC> {
            FeatureCRoot(
                onNavigationEvent = { navigationEvent ->
                    when (navigationEvent) {
                        FeatureCNavigationEvent.NavigateToPreviousScreen -> navController.popBackStack()
                        FeatureCNavigationEvent.onClickFirstButton -> navController.navigate(Route.FeatureA)
                        FeatureCNavigationEvent.onClickSecondButton -> navController.navigate(
                            Route.FeatureB(colorInt = null)
                        )
                    }
                }
            )
        }
    }
}
