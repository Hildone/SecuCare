package com.id.secucare.ui.navigation

sealed class NavigationRoute(val routeName: String) {
    object HomeRoute: NavigationRoute("homeScreen")
    object ContactRoute: NavigationRoute("contactScreen")
    object CommunityRoute: NavigationRoute("communityScreen")
    object TutorialRoute: NavigationRoute("tutorialScreen")
}