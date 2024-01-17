package hu.szg.improveyourself.ui.compose.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import hu.szg.improveyourself.models.ui.PageItem
import hu.szg.improveyourself.ui.compose.screen.page.NewCardScreen

fun NavGraphBuilder.cardItemNavGraph() {
    navigation(
        route = Graph.CARD,
        startDestination = PageItem.NewCardScreen.id
    ) {
        composable(route = PageItem.NewCardScreen.id) {
            NewCardScreen()
        }
        composable(route = PageItem.NewCardScreen.id) {
            NewCardScreen()
        }
        composable(route = PageItem.NewCardScreen.id) {
            NewCardScreen()
        }
        composable(route = PageItem.NewCardScreen.id) {
            NewCardScreen()
        }
    }
}