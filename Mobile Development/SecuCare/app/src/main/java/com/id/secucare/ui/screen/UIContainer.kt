package com.id.secucare.ui.screen;

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import com.id.secucare.ui.screen.auth.AuthContainer
import com.id.secucare.ui.screen.onboarding.OnboardingContainer
import com.id.secucare.ui.screen.splash.SplashContainer
import com.id.secucare.ui.theme.SecuCareTheme
import kotlinx.coroutines.delay

enum class UIContainer {
    SPLASH, ON_BOARD, MAIN
}

@Composable
fun UIContainer(
    modifier: Modifier = Modifier
) {
    val currentNav = remember { mutableStateOf(UIContainer.SPLASH) }

    LaunchedEffect(Unit) {
        delay(1500)
        currentNav.value = UIContainer.ON_BOARD
    }

    when (currentNav.value) {
        UIContainer.SPLASH -> SplashContainer()
        UIContainer.ON_BOARD -> OnboardingContainer(navigateToAuthContainer = {
            currentNav.value = UIContainer.MAIN
        })
        UIContainer.MAIN -> AuthContainer()
    }
}

@Composable
@Preview
fun ShowUIContainerPreview() {
    SecuCareTheme {
        UIContainer()
    }
}
