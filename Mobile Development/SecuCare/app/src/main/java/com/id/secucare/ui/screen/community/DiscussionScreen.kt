package com.id.secucare.ui.screen.community;

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.id.secucare.domain.model.forum.DiscussionModel
import com.id.secucare.ui.component.card.DiscussionCard
import com.id.secucare.ui.theme.SecuCareTheme

@Composable
fun DiscussionScreen(
    modifier: Modifier = Modifier
) {
    val dummyDisc = DiscussionModel.fakes()

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(vertical = 20.dp)
    ) {
        items(dummyDisc) {
            DiscussionCard(discussionModel = it)
        }
    }
}

@Composable
@Preview
fun ShowDiscussionScreenPreview() {
    SecuCareTheme {
        DiscussionScreen()
    }
}