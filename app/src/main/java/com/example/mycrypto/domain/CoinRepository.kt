package com.example.mycrypto.domain

import com.example.mycrypto.domain.model.Coin
import com.example.mycrypto.domain.model.CoinDetails

interface CoinRepository {

    suspend fun getCoinList(): List<Coin>

    suspend fun getCoinDetailsById(id: String): CoinDetails
}