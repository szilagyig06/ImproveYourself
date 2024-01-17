package hu.szg.improveyourself.models.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import hu.szg.improveyourself.R

sealed class PageItem(
    val id: String,
    val title: Int,
    val contentDescription: String,
    val icon: ImageVector,
    val screen: Any
) {
    object NewCardScreen: PageItem("new_card_screen", 0, "", Icons.Outlined.Home, NewCardScreen)

    object Items {
        val list = listOf(
            NewCardScreen
        )
    }
}