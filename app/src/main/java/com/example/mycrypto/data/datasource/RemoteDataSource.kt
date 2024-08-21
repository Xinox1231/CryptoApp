package com.example.mycrypto.data.datasource

import com.example.mycrypto.data.remote.dto.CoinDetailsDto
import com.example.mycrypto.data.remote.dto.CoinDto

interface RemoteDataSource {
    suspend fun getCoinDetailsById(coinId: String): CoinDetailsDto
    suspend fun getAllCoins(): List<CoinDto>
}