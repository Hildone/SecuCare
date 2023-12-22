package com.id.secucare.ui.screen.auth;

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.id.secucare.ui.theme.SecuCareTheme

enum class AuthContainer {
    MAIN, LOGIN, REGISTER
}

@Composable
fun AuthContainer(
    modifier: Modifier = Modifier
) {
    val currentNav = remember { mutableStateOf(AuthContainer.MAIN) }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        when (currentNav.value) {
            AuthContainer.MAIN -> AuthScreen(modifier = Modifier.padding(40.dp))
            else -> {}
        }
    }
}

@Composable
@Preview
fun ShowAuthContainerPreview() {
    SecuCareTheme {
        AuthContainer()
    }
}