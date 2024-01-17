package hu.szg.improveyourself.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import hu.szg.improveyourself.CardApplication
import hu.szg.improveyourself.database.CardDatabase
import hu.szg.improveyourself.database.dao.CardDao
import hu.szg.improveyourself.database.repository.CardRepository
import hu.szg.improveyourself.database.repository.CardRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideCardDatabase(@ApplicationContext appContext: Context): CardDatabase {
        return Room.databaseBuilder(
            appContext,
            CardDatabase::class.java,
            "cards_db"
        ).build()

//        return CardDatabase.getDB(appContext)
    }

    @Provides
    @Singleton
    fun provideCardDao(database: CardDatabase): CardDao {
        return database.cardDao()
    }

    @Provides
    @Singleton
    fun provideCardRepository(dao: CardDao) : CardRepository {
        return CardRepositoryImpl(dao)
    }
}