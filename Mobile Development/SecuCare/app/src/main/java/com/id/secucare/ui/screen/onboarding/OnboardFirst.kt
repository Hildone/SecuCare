package com.id.secucare.ui.screen.onboarding;

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.id.secucare.R
import com.id.secucare.ui.theme.SecuCareTheme

@Composable
fun OnboardFirst(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Image(painter = painterResource(id = R.drawable.sos_image), contentDescription = null,
            modifier = Modifier.aspectRatio(200f/184f))
    }
}

@Composable
@Preview
fun ShowOnboardFirstPreview() {
    SecuCareTheme {
        OnboardFirst()
    }
}
