package com.presentation.feature_c

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun FeatureCRoot(
    onNavigationEvent: (FeatureCNavigationEvent) -> Unit
) {
    val viewModel = hiltViewModel<FeatureCViewModel>()

    FeatureCScreen(
        state = viewModel.state,
        onNavigationEvent = onNavigationEvent
    )
}

@Composable
internal fun FeatureCScreen(
    state: FeatureCUiState,
    onNavigationEvent: (FeatureCNavigationEvent) -> Unit
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
                    onNavigationEvent(FeatureCNavigationEvent.NavigateToPreviousScreen)
                }
        ) {
            Text(
                text = "Navigate Back",
                modifier = Modifier.padding(16.dp)
            )
        }

        HorizontalDivider()

        when (state) {
            FeatureCUiState.Loading -> CircularProgressIndicator(
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally)
            )

            FeatureCUiState.Success -> Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.surface),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
            ) {
                Button(
                    onClick = { onNavigationEvent(FeatureCNavigationEvent.onClickFirstButton) }
                ) {
                    Text(text = "First Button")
                }

                Button(
                    onClick = { onNavigationEvent(FeatureCNavigationEvent.onClickSecondButton) }
                ) {
                    Text(text = "Second Button")
                }
            }
        }
    }
}

@Preview
@Composable
private fun FeatureAScreenPreview_Loading() {
    FeatureCScreen(
        state = FeatureCUiState.Loading,
        onNavigationEvent = {}
    )
}

@Preview
@Composable
private fun FeatureAScreenPreview_Success() {
    FeatureCScreen(
        state = FeatureCUiState.Success,
        onNavigationEvent = {}
    )
}