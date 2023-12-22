package com.id.secucare.ui.screen.contact;

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.id.secucare.domain.model.ContactModel
import com.id.secucare.ui.component.card.PersonalCard
import com.id.secucare.ui.theme.SecuCareTheme

@Composable
fun PersonalScreen(
    modifier: Modifier = Modifier
) {
    val dummyPersonal = ContactModel.fakes()
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(15.dp),
        contentPadding = PaddingValues(top = 20.dp)
    ) {
        items(dummyPersonal) {
            PersonalCard(personalData = it)
        }
    }
}

@Composable
@Preview
fun ShowPersonalScreenPreview() {
    SecuCareTheme {
        PersonalScreen()
    }
}