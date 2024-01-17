package hu.szg.improveyourself.ui.compose.screen.page.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.szg.improveyourself.database.repository.CardRepositoryImpl
import hu.szg.improveyourself.models.CardModel
import hu.szg.improveyourself.models.ui.CardItem.Word
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NewCardViewModel
@Inject constructor(
    private val repository: CardRepositoryImpl
) : ViewModel() {
    var content: String = ""
    var meaning: String = ""
    var explanation: String = ""
    var example: String = ""

    private lateinit var mCards: LiveData<List<CardModel>>
    private lateinit var mCardsFlow: Flow<List<CardModel>>

    fun getCards(): LiveData<List<CardModel>> {
        return mCards
    }

    fun getCardsFlow(): Flow<List<CardModel>> {
        return mCardsFlow
    }

    init {
        loadCards()
//        loadCardsFlow()
    }

    fun saveCard(card: CardModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertCard(card)
        }
    }

    fun loadCards() {
        viewModelScope.launch {
            mCards = repository.getCards()
        }
    }

    fun loadCardsFlow() {
        viewModelScope.launch {
            mCardsFlow = repository.getCardsFlow()
        }
    }

}