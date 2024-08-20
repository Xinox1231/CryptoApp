package com.example.mycrypto.domain

import com.example.mycrypto.domain.model.Coin
import com.example.mycrypto.domain.model.CoinDetails

interface CoinRepository {

    fun getCoinList(): List<Coin>

    fun getCoinDetailsById(id: String): List<CoinDetails>
}