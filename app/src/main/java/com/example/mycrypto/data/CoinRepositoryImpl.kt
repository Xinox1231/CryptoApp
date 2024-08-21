package com.example.mycrypto.data

import com.example.mycrypto.data.datasource.RemoteDataSource
import com.example.mycrypto.data.mapper.CoinMapper
import com.example.mycrypto.domain.CoinRepository
import com.example.mycrypto.domain.model.Coin
import com.example.mycrypto.domain.model.CoinDetails
import kotlinx.coroutines.delay
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val mapper: CoinMapper
) : CoinRepository {
    override suspend fun getCoinList(): List<Coin> {
        return remoteDataSource.getAllCoins().map { mapper.mapCoinDtoToCoin(it) }
    }

    override suspend fun getCoinDetailsById(id: String): CoinDetails {
        return mapper.mapCoinDetailsDtoToCoinDetails(remoteDataSource.getCoinDetailsById(id))
    }
}