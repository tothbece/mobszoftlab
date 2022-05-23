package hu.bme.aut.android.kimiquotes.mock.persistence

import hu.bme.aut.android.kimiquotes.persistence.KimiQuotesDao
import hu.bme.aut.android.kimiquotes.persistence.Quote

class MockQuotesDao: KimiQuotesDao {
    companion object {
        private val  quotes = mutableListOf<Quote>()
    }

    override fun getAll(): List<Quote> {
        return quotes
    }

    override fun getFavourites(): List<Quote> {
        val list = mutableListOf<Quote>()
        quotes.forEach {
            if (it.favourite) {
                list.add(it)
            }
        }
        return list
    }

    override fun insertAll(vararg quotesIn: Quote) {
        quotesIn.forEach {
            quotes.add(it)
        }
    }

    override fun deleteAll() {
        quotes.clear()
    }
}