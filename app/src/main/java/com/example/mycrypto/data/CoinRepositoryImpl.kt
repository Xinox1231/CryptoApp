package com.example.mycrypto.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.mycrypto.data.components.Constants
import com.example.mycrypto.data.datasource.LocalDataSource
import com.example.mycrypto.data.datasource.RemoteDataSource
import com.example.mycrypto.data.mapper.CoinMapper
import com.example.mycrypto.data.remote.dto.CoinInfoDto
import com.example.mycrypto.domain.CoinRepository
import com.example.mycrypto.domain.model.CoinInfo
import kotlinx.coroutines.delay
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val mapper: CoinMapper
) : CoinRepository {

    var page = 1
        set(value) {
            if (value < 1) throw RuntimeException("Page can't be less than 1")
            field = value
        }

    override fun getCoinList(): LiveData<List<CoinInfo>> {
        return localDataSource.getList().map {
            it.map {
                mapper.mapCoinInfoDbToCoinInfo(it)
            }
        }
    }

    override fun getCoinDetails(fSyms: String): LiveData<CoinInfo> {
        return localDataSource.getDetailedInfo(fSyms).map { mapper.mapCoinInfoDbToCoinInfo(it) }
    }

    override suspend fun loadData() {
        while (true) {
            try {
                val listCoinInfoDto = getCoinInfoDtoList()
                val listCoinInfoDb = listCoinInfoDto.map {
                    mapper.mapCoinInfoDtoToDb(it)
                }
                localDataSource.insertList(listCoinInfoDb)
            } catch (e: Exception) {
                Log.d("CoinRepositoryImpl", e.toString())
            }
            delay(20 * Constants.MILLIS_IN_SECOND)
        }
    }

    private suspend fun getCoinInfoDtoList(): List<CoinInfoDto> {
        val coinNamesListDto = remoteDataSource.loadData(page)
        val fSyms = mapper.mapCoinNamesListToString(coinNamesListDto)
        val coinJsonContainer = remoteDataSource.loadCoinDetailsById(fSyms)
        val listCoinInfo = mapper.mapJsonContainerToListCoinInfo(coinJsonContainer)
        return listCoinInfo
    }
}