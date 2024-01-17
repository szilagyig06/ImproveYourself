package hu.szg.improveyourself.models.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector
import hu.szg.improveyourself.R

sealed class MenuItem(
    val id: String,
    val title: Int,
    val contentDescription: String,
    val icon: ImageVector
) {
    object Card: MenuItem("card", R.string.menu_item_card, "", Icons.Outlined.Home)
    object Grammar: MenuItem("grammar", R.string.menu_item_grammar, "", Icons.Outlined.Home)
    object Practice: MenuItem("practice", R.string.menu_item_pracitce, "", Icons.Outlined.Home)
    object Statistic: MenuItem("statistic", R.string.menu_item_statistics, "", Icons.Outlined.Home)

    object Items {
        val list = listOf(
            Card, Grammar, Practice, Statistic
        )
    }
}
