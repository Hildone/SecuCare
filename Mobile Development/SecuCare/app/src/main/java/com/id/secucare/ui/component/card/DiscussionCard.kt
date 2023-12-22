package com.id.secucare.ui.component.card;

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.id.secucare.domain.model.forum.DiscussionModel
import com.id.secucare.ui.theme.SecuCareTheme
import com.id.secucare.ui.theme.Typography

@Composable
fun DiscussionCard(
    modifier: Modifier = Modifier,
    discussionModel: DiscussionModel = DiscussionModel.fakes()[0]
) {
    OutlinedCard(modifier = modifier) {
        Row(modifier = Modifier.padding(20.dp), horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
            Column {
                Text(text = discussionModel.discName, style = Typography.titleMedium)
                Divider(modifier = Modifier.width(120.dp))
                Text(text = "${discussionModel.name} - ${discussionModel.date}", style = Typography.bodySmall)
            }
            Spacer(modifier = Modifier.weight(1f))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(imageVector = Icons.Default.Star, contentDescription = null)
                Text(text = discussionModel.like)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(imageVector = Icons.Default.Email, contentDescription = null)
                Text(text = discussionModel.like)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(imageVector = Icons.Default.Send, contentDescription = null)
                Text(text = discussionModel.save)
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun ShowDiscussionCardPreview() {
    SecuCareTheme {
        DiscussionCard()
    }
}