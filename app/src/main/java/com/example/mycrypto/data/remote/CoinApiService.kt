package com.example.mycrypto.data.remote

import com.example.mycrypto.data.remote.dto.CoinInfoJsonContainerDto
import com.example.mycrypto.data.remote.dto.CoinNamesListDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CoinApiService {

    @GET("top/totalvolfull")
    suspend fun loadCoinList(
        @Query(QUERY_PARAM_PAGE) page: Int,
        @Query(QUERY_PARAM_LIMIT) limit: Int = 20,
        @Query(QUERY_PARAM_TO_SYMBOL) tSym: String = CURRENCY,
        @Header(QUERY_PARAM_API_KEY) apiKey: String = API_KEY,
    ): CoinNamesListDto

    @GET("pricemultifull")
    suspend fun loadCoinDetailsById(
        @Query(QUERY_PARAM_FROM_SYMBOLS) fSyms: String,
        @Query(QUERY_PARAM_TO_SYMBOLS) tSyms: String = CURRENCY,
        @Header(QUERY_PARAM_API_KEY) apiKey: String = API_KEY,
    ): CoinInfoJsonContainerDto

    companion object {
        private const val QUERY_PARAM_API_KEY = "api_key"
        private const val QUERY_PARAM_LIMIT = "limit"
        private const val QUERY_PARAM_PAGE = "page"
        private const val QUERY_PARAM_TO_SYMBOL = "tsym"
        private const val QUERY_PARAM_TO_SYMBOLS = "tsyms"
        private const val QUERY_PARAM_FROM_SYMBOLS = "fsyms"
        private const val CURRENCY = "USD"
        private const val API_KEY =
            "80f2e30fd7f6f45a800a4dc8bbc4c76244271687ae80938068d58a5c6f905c11"
    }
}