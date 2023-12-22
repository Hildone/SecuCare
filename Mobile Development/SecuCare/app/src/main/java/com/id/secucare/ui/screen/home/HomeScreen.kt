package com.id.secucare.ui.screen.home;

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.id.secucare.R
import com.id.secucare.ui.theme.SecuCareTheme
import com.id.secucare.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigateToProfile: () -> Unit = {},
    navigateToNotification: () -> Unit = {},
    navigateToEmergency: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier.padding(20.dp),
        topBar = { TopAppBar(
            title = { Text(text = stringResource(id = R.string.app_name), textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())  },
            navigationIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = null, modifier =
            Modifier.clickable { navigateToProfile() })},
            actions = { Icon(imageVector = Icons.Default.Notifications, contentDescription = null, modifier =
            Modifier.clickable { navigateToNotification() })}
        ) },
    ) {innerPadding ->
        Column(modifier = Modifier.padding(innerPadding), horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Text(text = "Are you in an emergency?", style = Typography.titleMedium, modifier = Modifier.padding(vertical = 10.dp))
            Text(text = "Press the SOS button, your live location will be shared with the nearest help centre and your emergency contact",
                style = Typography.bodyLarge, textAlign = TextAlign.Center
            )
            Image(painter = painterResource(id = R.drawable.sos_image), contentDescription = null,
                modifier = Modifier.aspectRatio(200f/184f).padding(top = 20.dp)
                    .clickable {
                        navigateToEmergency()
                    }
            )
        }
    }
}

@Composable
@Preview
fun ShowHomeScreenPreview() {
    SecuCareTheme {
        HomeScreen()
    }
}
