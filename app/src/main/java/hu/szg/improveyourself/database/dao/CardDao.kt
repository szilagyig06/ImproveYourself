package hu.szg.improveyourself.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import hu.szg.improveyourself.models.CardModel
import hu.szg.improveyourself.models.enums.CardType
import kotlinx.coroutines.flow.Flow

@Dao
interface CardDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(card: CardModel)

    @Update
    suspend fun update(card: CardModel)

    @Delete
    suspend fun delete(card: CardModel)

    @get:Query("SELECT * FROM cardmodel")
    val cardsLiveData: LiveData<List<CardModel>>

    @get:Query("SELECT * FROM cardmodel")
    val cardsFlow: Flow<List<CardModel>>

//    @Query("SELECT * FROM cardmodel WHERE type = :type")
//    fun getAllByType(type: CardType): Flow<List<CardModel>>
//
//    @Query("SELECT COUNT(*) FROM cardmodel WHERE type = :type")
//    fun getCount(type: CardType): Flow<List<CardModel>>

//    @Query("SELECT * FROM cardmodel WHERE date = :date")
//    fun getAllByDate(date: CardType): Flow<List<CardModel>>

    @Query("SELECT * FROM cardmodel")
    fun findByDate(): Flow<CardModel>
}