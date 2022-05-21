package hu.bme.aut.android.kimiquotes.mock.persistence

import hu.bme.aut.android.kimiquotes.persistence.KimiQuotesDao
import hu.bme.aut.android.kimiquotes.persistence.Quote

class MockQuotesDao: KimiQuotesDao {
    override fun getAll(): List<Quote> {
        TODO("Not yet implemented")
    }

    override fun getFavourites(): List<Quote> {
        TODO("Not yet implemented")
    }

    override fun insertAll(vararg quotes: Quote) {
        TODO("Not yet implemented")
    }
}