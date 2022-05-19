package hu.bme.aut.android.kimiquotes.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.bme.aut.android.kimiquotes.persistence.KimiQuotesDao
import hu.bme.aut.android.kimiquotes.persistence.Quote
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val interactor: QuotesInteractor) : ViewModel() {
    val quotes: MutableLiveData<List<Quote>> by lazy {
        MutableLiveData<List<Quote>>().also {
            loadQuotes()
        }
    }

    fun loadQuotes() {
        viewModelScope.launch {
            quotes.postValue(interactor.getQuotes())
        }
    }

}

class QuotesInteractor @Inject constructor(
    private val dao: KimiQuotesDao
) {
    suspend fun getQuotes(): List<Quote> = withContext(Dispatchers.IO){
        dao.getAll()
    }
}