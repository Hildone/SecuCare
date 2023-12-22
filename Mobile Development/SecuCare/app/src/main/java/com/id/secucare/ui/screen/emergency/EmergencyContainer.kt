package com.id.secucare.ui.screen.emergency;

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.id.secucare.ui.theme.SecuCareTheme

@Composable
fun EmergencyContainer(
    modifier: Modifier = Modifier,
    navigateBack: () -> Unit = {}
) {
    Column(modifier = modifier.padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        EmergencyScreen(navigateBack = navigateBack)
    }
}

@Composable
@Preview(showSystemUi = true)
fun ShowEmergencyContainerPreview() {
    SecuCareTheme {
        EmergencyContainer()
    }
}