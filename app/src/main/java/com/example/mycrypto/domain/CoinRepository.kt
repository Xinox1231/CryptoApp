package com.example.mycrypto.domain

import androidx.lifecycle.LiveData
import com.example.mycrypto.domain.model.CoinInfo

interface CoinRepository {

    fun getCoinList(): LiveData<List<CoinInfo>>

    fun getCoinDetails(fSyms: String): LiveData<CoinInfo>

    suspend fun loadData()
}