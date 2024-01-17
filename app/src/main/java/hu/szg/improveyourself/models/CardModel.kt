package hu.szg.improveyourself.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import hu.szg.improveyourself.models.enums.CardType

@Entity
data class CardModel(
    var type: CardType? = null,
    var content: String? = null,
    var meaning: String? = null,
    var explanation: String? = null,
    var example: String? = null,
    var image: ByteArray? = null
    ) : BaseModel() {

}