package com.id.secucare.ui.screen.profile;

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.id.secucare.ui.component.button.SettingButton
import com.id.secucare.ui.theme.SecuCareTheme
import com.id.secucare.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileContainer(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier.padding(20.dp),
        topBar = {
            TopAppBar(title = { Text(text = "Profile")},
                navigationIcon = {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null, modifier = Modifier.clickable {
                        onBackClick()
                    })
                })
        }
    ) {innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null, modifier = Modifier.size(80.dp))
            Text(text = "Grace", style = Typography.titleLarge)
            Text(text = "Woman", style = Typography.titleMedium)
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color.Gray)
                ) {
                    Text(text = "Edit Profile", modifier = Modifier.padding(horizontal = 30.dp, vertical = 10.dp))

                }
                Icon(imageVector = Icons.Default.Person, contentDescription = null, modifier = Modifier.padding(start = 10.dp))
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(15.dp),
                modifier = Modifier.padding(vertical = 35.dp)
            ) {
                SettingButton(icon = Icons.Default.Settings, name = "Settings")
                SettingButton(icon = Icons.Default.Build, name = "Help")
                SettingButton(icon = Icons.Default.Close, name = "LogOut")
            }
        }
    }

}

@Composable
@Preview
fun ShowProfileContainerPreview() {
    SecuCareTheme {
        ProfileContainer()
    }
}
