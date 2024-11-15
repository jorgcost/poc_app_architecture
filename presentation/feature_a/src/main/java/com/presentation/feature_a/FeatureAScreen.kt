package com.presentation.feature_a

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun FeatureARoot(
    onNavigationEvent: (FeatureANavigationEvent) -> Unit
) {
    val viewModel = hiltViewModel<FeatureAViewModel>()

    FeatureAScreen(
        state = viewModel.state,
        onUiEvent = viewModel::onUiEvent,
        onNavigationEvent = onNavigationEvent
    )
}

@Composable
internal fun FeatureAScreen(
    state: FeatureAUiState,
    onUiEvent: (FeatureAUiAction) -> Unit,
    onNavigationEvent: (FeatureANavigationEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onNavigationEvent(FeatureANavigationEvent.NavigateToPreviousScreen)
                }
        ) {
            Text(
                text = "Navigate Back",
                modifier = Modifier.padding(16.dp)
            )
        }

        HorizontalDivider()

        when (state) {
            FeatureAUiState.Loading -> CircularProgressIndicator(
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally)
            )

            is FeatureAUiState.Success -> Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(state.color ?: MaterialTheme.colorScheme.surface),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
            ) {
                Text(text = state.data)
                Button(onClick = { onUiEvent(FeatureAUiAction.OnClickChangeColor) }) {
                    Text(text = "Click to change Color")
                }
                Button(
                    onClick = {
                        onNavigationEvent(
                            FeatureANavigationEvent.NavigateToNextScreen(
                                colorInt = state.color?.toArgb()
                            )
                        )
                    }
                ) {
                    Text(text = "Click me to go to next screen")
                }

            }
        }
    }
}

@Preview
@Composable
private fun FeatureAScreenPreview_Loading() {
    FeatureAScreen(
        state = FeatureAUiState.Loading,
        onUiEvent = {},
        onNavigationEvent = {}
    )
}

@Preview
@Composable
private fun FeatureAScreenPreview_Success() {
    FeatureAScreen(
        state = FeatureAUiState.Success(),
        onUiEvent = {},
        onNavigationEvent = {}
    )
}
