package com.id.secucare.ui.screen.notification;

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.id.secucare.R
import com.id.secucare.ui.component.button.TertiaryButton
import com.id.secucare.ui.theme.SecuCareTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationContainer(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier.padding(20.dp),
        topBar = {
            TopAppBar(title = { Text(text = "Notification")},
                navigationIcon = {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null,
                        modifier = Modifier.clickable {
                            onBackClick()
                        })
                })
        }
    ) {innerPadding ->
        Column(
            modifier = Modifier.fillMaxWidth().padding(innerPadding), verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.live_image), contentDescription = null,
                modifier = Modifier.aspectRatio(286f/241f)
            )
            TertiaryButton(text = "I Am On My Way!!", modifier = Modifier.fillMaxWidth())
            TertiaryButton(text = "Sorry, I cant help you", modifier = Modifier.fillMaxWidth())
        }
    }
}

@Composable
@Preview
fun ShowNotificationContainerPreview() {
    SecuCareTheme {
        NotificationContainer()
    }
}
