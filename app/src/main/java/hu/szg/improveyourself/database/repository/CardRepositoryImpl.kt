package hu.szg.improveyourself.database.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import hu.szg.improveyourself.database.dao.CardDao
import hu.szg.improveyourself.models.CardModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CardRepositoryImpl @Inject constructor(
    private val cardDao: CardDao
) : CardRepository {

    @WorkerThread
    override suspend fun insertCard(cardModel: CardModel) {
        try {
            cardDao.insert(cardModel)
        } catch (error: Throwable) {
            throw InsertCardError("Unable to save card", error)
        }
    }

    @WorkerThread
    override suspend fun updateCard(cardModel: CardModel) {
        try {
            cardDao.update(cardModel)
        } catch (error: Throwable) {
            throw UpdateCardError("Unable to update card", error)
        }
    }

    override suspend fun getCards() : LiveData<List<CardModel>> {
        try {
            return cardDao.cardsLiveData
        } catch (error: Throwable) {
            throw UpdateCardError("Unable to update card", error)
        }
    }

    override suspend fun getCardsFlow() : Flow<List<CardModel>> {
        try {
            return cardDao.cardsFlow
        } catch (error: Throwable) {
            throw UpdateCardError("Unable to update card", error)
        }
    }

    @WorkerThread
    override suspend fun deleteCard(cardModel: CardModel) {
        try {
            cardDao.delete(cardModel)
        } catch (error: Throwable) {
            throw DeleteCardError("Unable to delete card", error)
        }
    }
}

class InsertCardError(message: String, cause: Throwable) : Throwable(message, cause)
class UpdateCardError(message: String, cause: Throwable) : Throwable(message, cause)
class DeleteCardError(message: String, cause: Throwable) : Throwable(message, cause)