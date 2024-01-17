package hu.szg.improveyourself.ui.compose.screen

import android.annotation.SuppressLint
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import hu.szg.improveyourself.models.ui.MenuItem
import hu.szg.improveyourself.ui.compose.navigation.BottomNavGraph
import hu.szg.improveyourself.ui.compose.navigation.CustomBottomNavigationItem

@SuppressLint("UnrememberedMutableState", "UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val currentScreen = mutableStateOf<MenuItem>(MenuItem.Card)

    Scaffold(
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) {
        BottomNavGraph(navController = navController)
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation {
        MenuItem.Items.list.forEach { screen ->
            AddItem(
                screen = screen,
                currenDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun AddItem(
    screen: MenuItem,
    currenDestination: NavDestination?,
    navController: NavHostController
) {
    CustomBottomNavigationItem(
        item = screen,
        isSelected = currenDestination?.hierarchy?.any {
            it.route == screen.id
        } == true,
        onClick = {
            navController.navigate(screen.id)
        }
    )
}