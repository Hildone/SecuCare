package com.id.secucare.ui.screen.onboarding;

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.id.secucare.R
import com.id.secucare.ui.theme.SecuCareTheme
import com.id.secucare.ui.theme.Typography

@Composable
fun OnboardThird(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.secucare_logo), contentDescription = null,
            modifier = Modifier.aspectRatio(196f/208f)
        )
        Text(text = "An application that provides features emergency call, sharing live location to other users, and a community forum.",
            style = Typography.bodyLarge, textAlign = TextAlign.Center, modifier = Modifier.padding(top = 5.dp)
        )
    }
}

@Composable
@Preview(showSystemUi = true)
fun ShowOnboardThirdPreview() {
    SecuCareTheme {
        OnboardThird()
    }
}
