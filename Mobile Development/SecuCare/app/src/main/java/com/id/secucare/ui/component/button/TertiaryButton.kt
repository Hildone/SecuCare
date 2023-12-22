package com.id.secucare.ui.component.button;

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.id.secucare.ui.theme.SecuCareTheme
import com.id.secucare.ui.theme.redColor
import com.id.secucare.ui.theme.secondaryColor

@Composable
fun TertiaryButton(
    modifier: Modifier = Modifier,
    text: String = "",
    enable: Boolean = true,
    onClick: () -> Unit = {}
) {
    Button(onClick = onClick, shape = RoundedCornerShape(20.dp),
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(containerColor = redColor)
    ) {
        Text(text = text)
    }
}

@Composable
@Preview
fun ShowTertiaryButtonPreview() {
    SecuCareTheme {
        TertiaryButton()
    }
}