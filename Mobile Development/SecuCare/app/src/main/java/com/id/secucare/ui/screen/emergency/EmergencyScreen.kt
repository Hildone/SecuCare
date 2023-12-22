package com.id.secucare.ui.screen.emergency;

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.id.secucare.R
import com.id.secucare.ui.component.button.TertiaryButton
import com.id.secucare.ui.theme.SecuCareTheme
import com.id.secucare.ui.theme.Typography
import com.id.secucare.ui.theme.redColor

@Composable
fun EmergencyScreen(
    modifier: Modifier = Modifier,
    navigateBack: () -> Unit = {}
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(redColor)
        ) {
            Text(text = "EMERGENCY", fontSize = 32.sp,
                textAlign = TextAlign.Center,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 44.dp, vertical = 10.dp)
            )
        }
        Image(painter = painterResource(id = R.drawable.sos_image), contentDescription = null,
            modifier = Modifier
                .aspectRatio(200f / 184f)
                .padding(vertical = 20.dp)
        )
        Text(text = "After pressing the emergency button, we will share your live location to others, and contact the nearest police station.",
            style = Typography.bodyLarge, textAlign = TextAlign.Center, modifier = Modifier.padding(bottom = 20.dp)
        )
        TertiaryButton(text = "I am Safe Now, Cancel Alert") {
            navigateBack()
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun ShowEmergencyScreenPreview() {
    SecuCareTheme {
        EmergencyScreen()
    }
}