package com.example.mycrypto.data.remote

import com.example.mycrypto.data.remote.dto.CoinDetailsDto
import com.example.mycrypto.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinApiService {

    @GET("v1/coins")
    suspend fun getCoinList(): List<CoinDto>

    @GET("v1/coins/{coinId}")
    suspend fun getCoinDetailsById(
        @Path("coinId") coinId: String
    ): CoinDetailsDto
}