package hu.szg.improveyourself.models.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector
import hu.szg.improveyourself.R

sealed class CardItem(
    val id: String,
    val title: Int,
    val contentDescription: String,
    val icon: ImageVector
) {
    object Word: CardItem("word", R.string.card_type_word, "", Icons.Outlined.Home)
    object Expression: CardItem("expression", R.string.card_type_expression, "", Icons.Outlined.Home)
    object Idioma: CardItem("idioma", R.string.card_type_idioma, "", Icons.Outlined.Home)
    object Other: CardItem("other", R.string.card_type_other, "", Icons.Outlined.Home)

    object Items {
        val list = listOf(
            Word, Expression, Idioma, Other
        )
    }
}