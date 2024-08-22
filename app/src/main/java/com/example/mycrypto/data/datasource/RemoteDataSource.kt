package com.example.mycrypto.data.datasource

import com.example.mycrypto.data.remote.dto.CoinInfoJsonContainerDto
import com.example.mycrypto.data.remote.dto.CoinNamesListDto

interface RemoteDataSource {
    suspend fun loadData(
        page: Int
    ): CoinNamesListDto?

    suspend fun loadCoinDetailsById(
        fSyms: String,
    ): CoinInfoJsonContainerDto?
}