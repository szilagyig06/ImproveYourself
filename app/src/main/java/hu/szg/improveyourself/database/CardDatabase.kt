package hu.szg.improveyourself.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import hu.szg.improveyourself.database.dao.CardDao
import hu.szg.improveyourself.models.CardModel

@Database(entities = [CardModel::class], version = 1)
abstract class CardDatabase : RoomDatabase() {
    abstract fun cardDao(): CardDao

//    companion object {
//
//        private fun buildDatabase(context: Context): CardDatabase {
//            return Room.databaseBuilder(
//                context.applicationContext,
//                CardDatabase::class.java,
//                "cards_db"
//            ).build()
//        }
//
//        @Volatile
//        private lateinit var INSTANCE: CardDatabase
//
//        fun getDB(context: Context): CardDatabase {
//            synchronized(this) {
//                if (!::INSTANCE.isInitialized) {
//                    INSTANCE = buildDatabase(context)
//                }
//            }
//
//            return INSTANCE
//        }
//    }
}