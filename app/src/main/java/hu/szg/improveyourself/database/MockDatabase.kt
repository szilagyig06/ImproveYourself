package hu.szg.improveyourself.database

import android.content.Context
import androidx.room.Room
import hu.szg.improveyourself.models.CardModel
import hu.szg.improveyourself.models.enums.CardType

class MockDatabase {
    var mockCards = mutableListOf<CardModel>(
        CardModel(CardType.WORD, "lorem ipsum", "1", ""),
        CardModel(CardType.WORD, "lorem ipsum 2", "2", ""),
        CardModel(CardType.WORD, "lorem ipsum 3", "3", ""),
        CardModel(CardType.WORD, "lorem ipsum 4", "4", "")
    )

    companion object {

        @Volatile
        private var INSTANCE: MockDatabase? = null

        fun getDatabase(context: Context): MockDatabase {
            return INSTANCE ?: MockDatabase()
        }

        fun getCards() : List<CardModel> {
            var mockCards: List<CardModel> = mutableListOf()


            return mockCards
        }

    }
}