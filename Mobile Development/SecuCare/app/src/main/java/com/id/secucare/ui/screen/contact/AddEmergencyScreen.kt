package com.id.secucare.ui.screen.contact;

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.id.secucare.ui.component.button.PrimaryButton
import com.id.secucare.ui.component.textfield.InputWithLeading
import com.id.secucare.ui.theme.SecuCareTheme
import com.id.secucare.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEmergencyScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier.padding(20.dp),
        topBar = {
            TopAppBar(title = { Text(text = "Add Emergency Contact", style = Typography.titleMedium)}, navigationIcon = {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null, modifier = Modifier.clickable {
                    onBackClick()
                })
            })
        }
    ) {innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)) {
            InputWithLeading(label = "Full Name", leadingIcon = Icons.Default.Person)
            InputWithLeading(label = "Phone Number", leadingIcon = Icons.Default.Phone)
            InputWithLeading(label = "Email", leadingIcon = Icons.Default.Email)
            Spacer(modifier = Modifier.weight(1f))
            PrimaryButton(text = "SAVE CONTACT")
        }
    }
}

@Composable
@Preview
fun ShowAddEmergencyScreenPreview() {
    SecuCareTheme {
        AddEmergencyScreen()
    }
}