package com.example.mycrypto.data.datasource

import com.example.mycrypto.data.remote.CoinApiService
import com.example.mycrypto.data.remote.dto.CoinInfoJsonContainerDto
import com.example.mycrypto.data.remote.dto.CoinNamesListDto
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val apiService: CoinApiService
) : RemoteDataSource {

    override suspend fun loadData(page: Int): CoinNamesListDto? = apiService.loadCoinList(page)

    override suspend fun loadCoinDetailsById(fSyms: String): CoinInfoJsonContainerDto? =
        apiService.loadCoinDetailsById(fSyms)
}