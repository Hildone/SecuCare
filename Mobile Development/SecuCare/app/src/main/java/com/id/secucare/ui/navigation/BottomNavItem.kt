package com.id.secucare.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(
    val icon: ImageVector,
    val title: String,
    val screen: String,
)
val navigationItem = listOf(
    NavigationItem(
        icon =  Icons.Default.Home,
        screen = NavigationRoute.HomeRoute.routeName,
        title = "Home"
    ),
    NavigationItem(
        icon =  Icons.Default.Call,
        screen = NavigationRoute.ContactRoute.routeName,
        title = "Contact"
    ),
    NavigationItem(
        icon =  Icons.Default.AccountBox,
        screen = NavigationRoute.CommunityRoute.routeName,
        title = "Community"
    ),
//    NavigationItem(
//        icon =  Icons.Default.PlayArrow,
//        screen = NavigationRoute.TutorialRoute.routeName,
//        title = "Tutorial"
//    ),
)