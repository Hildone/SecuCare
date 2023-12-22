package com.id.secucare.ui.screen.home;

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import com.id.secucare.ui.navigation.NavigationRoute
import com.id.secucare.ui.navigation.navigationItem
import com.id.secucare.ui.screen.community.CommunityContainer
import com.id.secucare.ui.screen.contact.AddEmergencyScreen
import com.id.secucare.ui.screen.contact.ContactContainer
import com.id.secucare.ui.screen.emergency.EmergencyContainer
import com.id.secucare.ui.screen.notification.NotificationContainer
import com.id.secucare.ui.screen.profile.ProfileContainer
import com.id.secucare.ui.theme.SecuCareTheme

enum class HomeContainer {
    MAIN_HOME, EMERGENCY, ADD_EMERGENCY, PROFILE, NOTIFICATION
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeContainer(
    modifier: Modifier = Modifier
) {
    val currentNav = remember { mutableStateOf(HomeContainer.MAIN_HOME) }
    val currentNavItem = remember { mutableStateOf(navigationItem[0]) }

    when (currentNav.value) {
        HomeContainer.MAIN_HOME -> {
            Scaffold(
                bottomBar = {
                    BottomAppBar {
                        navigationItem.forEachIndexed { _, item->
                            NavigationBarItem(selected = item == currentNavItem.value,
                                onClick = { currentNavItem.value = item },
                                icon = { Image(imageVector = item.icon, contentDescription = null) },
                                label = { Text(text = item.title)}
                            )
                        }
                    }}
            ) {innerPadding ->
                Column(modifier = Modifier.padding(innerPadding)) {
                    when (currentNavItem.value.screen) {
                        NavigationRoute.HomeRoute.routeName -> {
                            HomeScreen(navigateToEmergency = {
                                currentNav.value = HomeContainer.EMERGENCY },
                                navigateToProfile = { currentNav.value = HomeContainer.PROFILE },
                                navigateToNotification = {currentNav.value = HomeContainer.NOTIFICATION}
                            )
                        }
                        NavigationRoute.ContactRoute.routeName -> {
                            ContactContainer(moveToAddEmergency = {currentNav.value = HomeContainer.ADD_EMERGENCY})
                        }
                        NavigationRoute.CommunityRoute.routeName -> {
                            CommunityContainer(onBackClick = {currentNav.value = HomeContainer.MAIN_HOME})
                        }
                    }
                }
            }
        }
        HomeContainer.EMERGENCY -> {
            EmergencyContainer(navigateBack = {currentNav.value = HomeContainer.MAIN_HOME})
        }

        HomeContainer.ADD_EMERGENCY -> AddEmergencyScreen(onBackClick = {currentNav.value = HomeContainer.MAIN_HOME})
        HomeContainer.PROFILE -> ProfileContainer(onBackClick = {currentNav.value = HomeContainer.MAIN_HOME})
        HomeContainer.NOTIFICATION -> NotificationContainer(onBackClick = {currentNav.value = HomeContainer.MAIN_HOME})
    }

}

@Composable
@Preview
fun ShowHomeContainerPreview() {
    SecuCareTheme {
        HomeContainer()
    }
}