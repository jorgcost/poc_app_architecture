package com.poc.secondapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.presentation.core.Route
import com.presentation.feature_c.FeatureCRoot

@Composable
fun NavigationRoot(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Route.FeatureC
    ) {
        composable<Route.FeatureC> {
            FeatureCRoot(
                onNavigationEvent = { }
            )
        }
    }
}
