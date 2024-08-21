package com.example.mycrypto.data.datasource

import com.example.mycrypto.data.remote.CoinApiService
import com.example.mycrypto.data.remote.dto.CoinDetailsDto
import com.example.mycrypto.data.remote.dto.CoinDto
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val apiService: CoinApiService
) : RemoteDataSource {
    override suspend fun getCoinDetailsById(coinId: String): CoinDetailsDto {
        return apiService.getCoinDetailsById(coinId)
    }

    override suspend fun getAllCoins(): List<CoinDto> {
        return apiService.getCoinList()
    }

}