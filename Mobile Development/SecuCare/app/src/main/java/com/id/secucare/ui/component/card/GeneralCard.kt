package com.id.secucare.ui.component.card;

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.id.secucare.R
import com.id.secucare.ui.theme.SecuCareTheme
import com.id.secucare.ui.theme.Typography

@Composable
fun GeneralCard(
    modifier: Modifier = Modifier,
    text: String = "",
    imageDrawable: Int = R.drawable.police_car_image
) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.spacedBy(6.dp), verticalAlignment = Alignment.CenterVertically) {
        Image(modifier = Modifier.size(50.dp),painter = painterResource(id = imageDrawable), contentDescription = null)
        Text(text = text, style = Typography.titleMedium)
        Spacer(modifier = Modifier.weight(1f))
        Icon(imageVector = Icons.Default.Call, contentDescription = null)
    }
}

@Composable
@Preview(showSystemUi = true)
fun ShowGeneralCardPreview() {
    SecuCareTheme {
        GeneralCard()
    }
}