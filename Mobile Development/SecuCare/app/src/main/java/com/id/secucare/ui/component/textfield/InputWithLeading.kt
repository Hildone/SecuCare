package com.id.secucare.ui.component.textfield;

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.id.secucare.ui.theme.SecuCareTheme
import com.id.secucare.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputWithLeading(
    modifier: Modifier = Modifier,
    label: String = "",
    leadingIcon: ImageVector = Icons.Default.Person,
    value: String = "",
    onValueChange: (String) -> Unit = {}
) {
    Column(
        modifier = modifier
    ) {
        Text(text = label, style = Typography.titleMedium)
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = label) },
            leadingIcon = { Icon(imageVector = leadingIcon, contentDescription = null)},
            value = value,
            onValueChange = onValueChange
        )
    }
}

@Composable
@Preview
fun ShowInputWithLeadingPreview() {
    SecuCareTheme {
        InputWithLeading()
    }
}