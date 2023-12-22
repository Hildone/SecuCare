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
fun OnboardSecond(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = R.drawable.live_image), contentDescription = null,
            modifier = Modifier.aspectRatio(286f/241f)
        )
        Text(text = "Live Location Sharing", style = Typography.titleLarge, modifier = Modifier.padding(top = 15.dp))
        Text(text = "When you press the emergency button, your live location will be automatically shared with other users, contacts in your app, and the app will  contact the nearest police station.",
            style = Typography.bodyLarge, textAlign = TextAlign.Center, modifier = Modifier.padding(top = 10.dp)
        )
    }
}

@Composable
@Preview(showSystemUi = true)
fun ShowOnboardSecondPreview() {
    SecuCareTheme {
        OnboardSecond()
    }
}
