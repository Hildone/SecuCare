package com.id.secucare.ui.component.button;

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.id.secucare.ui.theme.SecuCareTheme

@Composable
fun SettingButton(
    modifier: Modifier = Modifier,
    icon: ImageVector = Icons.Default.Settings,
    name: String = ""
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(Color.Gray)
            .padding(horizontal = 15.dp)
    ) {
        Row(
            modifier = Modifier.padding(vertical = 20.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Icon(imageVector = icon, contentDescription = null)
            Text(text = name)
        }
    }
}

@Composable
@Preview
fun ShowSettingButtonPreview() {
    SecuCareTheme {
        SettingButton()
    }
}