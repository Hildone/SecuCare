package com.id.secucare.ui.screen.splash;

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.id.secucare.R
import com.id.secucare.ui.theme.SecuCareTheme

@Composable
fun SplashContainer(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = R.drawable.secucare_logo),
            modifier = Modifier.aspectRatio(328f/404f),
            contentDescription = null)
    }
}

@Composable
@Preview(showSystemUi = true)
fun ShowSplashContainerPreview() {
    SecuCareTheme {
        SplashContainer()
    }
}
