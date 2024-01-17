package hu.szg.improveyourself.models.enums

import hu.szg.improveyourself.R

enum class CardType(val content: String, val type: Int) {
    WORD("Szavak", R.string.card_type_word),
    EXPRESSION("Kifejezések", R.string.card_type_expression),
    IDIOM("Idiómák", R.string.card_type_idioma),
    OTHER("Egyéb", R.string.card_type_other)
}