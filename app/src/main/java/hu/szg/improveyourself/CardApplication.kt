package hu.szg.improveyourself

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import hu.szg.improveyourself.database.CardDatabase
import hu.szg.improveyourself.database.repository.CardRepositoryImpl

@HiltAndroidApp
class CardApplication : Application() {
//    public val database   by lazy { CardDatabase.getDB(this) }
//    val repository by lazy { CardRepositoryImpl(database.cardDao()) }

}