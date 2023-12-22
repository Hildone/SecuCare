package com.id.secucare.ui.screen.onboarding;

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.id.secucare.ui.component.button.PrimaryButton
import com.id.secucare.ui.theme.SecuCareTheme

enum class OnboardingContainer(val index: Int) {
    FIRST_SCREEN(0),
    SECOND_SCREEN(1),
    THIRD_SCREEN(2)
}

@Composable
fun OnboardingContainer(
    modifier: Modifier = Modifier,
    navigateToAuthContainer: () -> Unit = {}
) {
    val currentScreen = remember { mutableStateOf(OnboardingContainer.FIRST_SCREEN) }

    Column(modifier = modifier
        .fillMaxSize()
        .padding(35.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        when(currentScreen.value) {
            OnboardingContainer.FIRST_SCREEN -> OnboardFirst()
            OnboardingContainer.SECOND_SCREEN -> OnboardSecond()
            OnboardingContainer.THIRD_SCREEN -> OnboardThird()
        }
        Spacer(modifier = Modifier.weight(1f))
        PrimaryButton(text = "Continue",
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                when (currentScreen.value) {
                    OnboardingContainer.FIRST_SCREEN -> {
                        currentScreen.value = OnboardingContainer.SECOND_SCREEN
                    }
                    OnboardingContainer.SECOND_SCREEN -> {
                        currentScreen.value = OnboardingContainer.THIRD_SCREEN
                    }
                    OnboardingContainer.THIRD_SCREEN -> {
                        navigateToAuthContainer()
                    }
                }
            }
        )
    }
}

@Composable
@Preview(showSystemUi = true)
fun ShowOnboardingContainerPreview() {
    SecuCareTheme {
        OnboardingContainer()
    }
}
