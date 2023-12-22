package com.id.secucare.ui.component.card;

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.id.secucare.domain.model.ContactModel
import com.id.secucare.ui.theme.SecuCareTheme
import com.id.secucare.ui.theme.Typography

@Composable
fun PersonalCard(
    modifier: Modifier = Modifier,
    personalData: ContactModel = ContactModel.fakes()[0]
) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
        Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
        Column {
            Text(text = personalData.name, style = Typography.titleSmall)
            Text(text = personalData.phoneNumber, style = Typography.bodySmall)
        }
        Spacer(modifier = Modifier.weight(1f))
        Icon(imageVector = Icons.Default.Call, contentDescription = null)
        Icon(imageVector = Icons.Default.Edit, contentDescription = null)
    }
}

@Composable
@Preview(showSystemUi = true)
fun ShowPersonalCardPreview() {
    SecuCareTheme {
        PersonalCard()
    }
}