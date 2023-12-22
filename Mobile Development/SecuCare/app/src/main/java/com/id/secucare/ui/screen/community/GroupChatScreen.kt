package com.id.secucare.ui.screen.community;

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.id.secucare.ui.theme.SecuCareTheme
import com.id.secucare.ui.theme.Typography

@Composable
fun GroupChatScreen(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth().padding(20.dp)) {
        OutlinedCard {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "PS - 531", style = Typography.titleLarge, textAlign = TextAlign.Center)
                Text(text = "Pskiater - Naufal", style = Typography.titleLarge, textAlign = TextAlign.Center)
            }
        }
        Row(modifier = Modifier.padding(top = 30.dp), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
            OutlinedCard {
                Text(text = "Good morning everyone.\n" +
                        "How are you today?", modifier = Modifier.padding(10.dp))
            }
        }
    }
}

@Composable
@Preview
fun ShowGroupChatScreenPreview() {
    SecuCareTheme {
        GroupChatScreen()
    }
}