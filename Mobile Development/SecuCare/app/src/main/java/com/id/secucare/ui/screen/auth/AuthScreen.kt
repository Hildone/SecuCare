package com.id.secucare.ui.screen.auth;

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.id.secucare.R
import com.id.secucare.ui.component.button.PrimaryButton
import com.id.secucare.ui.theme.SecuCareTheme

@Composable
fun AuthScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.secucare_logo), contentDescription = null,
            modifier = Modifier.aspectRatio(196f/208f)
        )
        PrimaryButton(text = "Sign Up", modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp, bottom = 25.dp)
        ){}
        PrimaryButton(text = "Login", modifier = Modifier
            .fillMaxWidth()){}
    }
}

@Composable
@Preview
fun ShowAuthScreenPreview() {
    SecuCareTheme {
        AuthScreen()
    }
}