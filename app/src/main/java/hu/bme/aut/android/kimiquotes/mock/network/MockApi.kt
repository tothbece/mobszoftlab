package hu.bme.aut.android.kimiquotes.mock.network

import hu.bme.aut.android.kimiquotes.network.api.QuoteApi
import hu.bme.aut.android.kimiquotes.network.model.Quote
import retrofit2.Response

class MockApi: QuoteApi {
    override suspend fun handleGetQuotes(): Response<Array<Quote>> {
        TODO("Not yet implemented")
    }

    override suspend fun handleGetRandomQuote(): Response<Quote> {
        TODO("Not yet implemented")
    }

    override suspend fun handlePostQuote(quote: Quote) {
        TODO("Not yet implemented")
    }
}