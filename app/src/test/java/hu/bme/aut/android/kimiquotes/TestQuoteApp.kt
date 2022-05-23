package hu.bme.aut.android.kimiquotes

import hu.bme.aut.android.kimiquotes.mock.network.MockApi
import hu.bme.aut.android.kimiquotes.mock.persistence.MockQuotesDao
import hu.bme.aut.android.kimiquotes.persistence.Quote
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.*

class TestQuoteApp {
    private lateinit var daoMock: MockQuotesDao
    private lateinit var apiMock: MockApi

    @Before
    fun before() {
        daoMock = MockQuotesDao()
        apiMock = MockApi()
    }

    @After
    fun after() {
        daoMock.deleteAll()
    }

    @Test
    fun TestQuoteAddMock() {
        val q = Quote(9, "Test quote", 2022, false)
        daoMock.insertAll(q)
        val list = daoMock.getAll()
        assert(list.size == 1)
        assert(list[0] == q)
    }

    @Test
    fun TestQuoteDeleteAllMock() {
        val q = Quote(2, "Test quote delete", 2022, false)
        daoMock.insertAll(q)
        var list = daoMock.getAll()
        assert(list.size == 1)
        assert(list[0] == q)
        daoMock.deleteAll()
        list = daoMock.getAll()
        assert(list.size == 0)
    }

    @Test
    fun TestQuoteGetFavourites() {
        val q = Quote(2, "Test quote fav", 2022, true)
        val q2 = Quote(3, "Test quote not fav", 2022, false)
        daoMock.insertAll(q)
        daoMock.insertAll(q2)
        val list = daoMock.getAll()
        assert(list.size == 2)
        val listfav = daoMock.getFavourites()
        assert(listfav.size == 1)
        assert(listfav[0] == q)
    }

    @Test
    fun TestQuotesGet() = runBlocking {
        val quotes = apiMock.handleGetQuotes().body()
        assert(quotes!!.size == 1)
        assert(quotes[0].id!! == 1L)
    }

    @Test
    fun TestQuotesRandomQuote() = runBlocking {
        val quotes = apiMock.handleGetRandomQuote().body()
        assert(quotes!!.id == 1L)
    }
}