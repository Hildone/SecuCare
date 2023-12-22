package com.id.secucare.ui.screen.community;

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.id.secucare.ui.screen.contact.GeneralScreen
import com.id.secucare.ui.screen.contact.PersonalScreen
import com.id.secucare.ui.theme.SecuCareTheme
import com.id.secucare.ui.theme.Typography

@Composable
fun CommunityContainer(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {}
) {
    var state by remember { mutableStateOf(0) }
    val titles = listOf("Discussion", "Group Chat")

    Column(modifier = modifier.padding(20.dp)) {
        Row(horizontalArrangement = Arrangement.Center) {
            Text(text = "Forum", style = Typography.titleLarge)
        }
        TabRow(selectedTabIndex = state) {
            titles.forEachIndexed { index, title ->
                Tab(
                    selected = state == index,
                    onClick = { state = index },
                    text = { Text(text = title, maxLines = 2, overflow = TextOverflow.Ellipsis) }
                )
            }
        }
        when (state) {
            0 -> DiscussionScreen()
            1 -> GroupChatScreen()
        }
    }
}

@Composable
@Preview
fun ShowCommunityContainerPreview() {
    SecuCareTheme {
        CommunityContainer()
    }
}
