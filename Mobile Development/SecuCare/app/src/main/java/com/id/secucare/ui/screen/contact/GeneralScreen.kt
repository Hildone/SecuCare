package com.id.secucare.ui.screen.contact;

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.id.secucare.R
import com.id.secucare.ui.component.card.GeneralCard
import com.id.secucare.ui.theme.SecuCareTheme

@Composable
fun GeneralScreen(
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        GeneralCard(text = "Police", imageDrawable = R.drawable.police_car_image)
        GeneralCard(text = "Medical Service", imageDrawable = R.drawable.hospital_image)
    }
}

@Composable
@Preview
fun ShowGeneralScreenPreview() {
    SecuCareTheme {
        GeneralScreen()
    }
}