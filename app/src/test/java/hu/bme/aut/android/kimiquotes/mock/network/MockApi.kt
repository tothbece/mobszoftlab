package hu.bme.aut.android.kimiquotes.mock.network

import hu.bme.aut.android.kimiquotes.network.api.QuoteApi
import hu.bme.aut.android.kimiquotes.network.model.Quote
import retrofit2.Response

class MockApi : QuoteApi {
    override suspend fun handleGetQuotes(): Response<Array<Quote>> {
        val q = Quote(
            id = 1, quote = "Quote",
            year = 2022,
        )
        var qts: Array<Quote> = emptyArray()
        qts += q
        return Response.success(qts)

    }

    override suspend fun handleGetRandomQuote(): Response<Quote> {
        return Response.success(Quote(
            id = 1, quote = "Random",
            year = 2022,
        ))
    }

    override suspend fun handlePostQuote(quote: Quote) {
        // ...
    }
}