package hu.szg.improveyourself.database.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import hu.szg.improveyourself.models.CardModel
import kotlinx.coroutines.flow.Flow

interface CardRepository {
    @WorkerThread
    suspend fun insertCard(cardModel: CardModel)
    @WorkerThread
    suspend fun updateCard(cardModel: CardModel)
    suspend fun getCards() : LiveData<List<CardModel>>
    suspend fun getCardsFlow() : Flow<List<CardModel>>
    @WorkerThread
    suspend fun deleteCard(cardModel: CardModel)

}