package hu.szg.improveyourself.ui.compose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import hu.szg.improveyourself.models.ui.MenuItem
import hu.szg.improveyourself.models.extension.show
import hu.szg.improveyourself.ui.compose.screen.tab.CardScreen
import hu.szg.improveyourself.ui.compose.screen.tab.GrammarScreen
import hu.szg.improveyourself.ui.compose.screen.tab.PracticeScreen
import hu.szg.improveyourself.ui.compose.screen.tab.StatisticsScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    val context = LocalContext.current

    NavHost(
        navController = navController,
        startDestination = MenuItem.Card.id
    ) {
        cardItemNavGraph()
        composable(route = MenuItem.Card.id) {
            CardScreen(navController = navController)
        }
        composable(route = MenuItem.Grammar.id) {
            GrammarScreen(navController = navController)
        }
        composable(route = MenuItem.Practice.id) {
            PracticeScreen()
        }
        composable(route = MenuItem.Statistic.id) {
            StatisticsScreen()
        }
    }
}

object Graph {
    const val ROOT = "bottom_graph"
    const val CARD = "card_graph"
}