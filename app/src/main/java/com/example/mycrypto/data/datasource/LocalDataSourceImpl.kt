package com.example.mycrypto.data.datasource

import androidx.lifecycle.LiveData
import com.example.mycrypto.data.database.CoinInfoDao
import com.example.mycrypto.data.database.model.CoinInfoDb
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val coinInfoDao: CoinInfoDao
) : LocalDataSource {

    override fun insertList(list: List<CoinInfoDb>) {
        coinInfoDao.insertData(list)
    }

    override fun getList(): LiveData<List<CoinInfoDb>> {
        return coinInfoDao.getFullPriceList()
    }

    override fun getDetailedInfo(fSyms: String): LiveData<CoinInfoDb> {
        return coinInfoDao.getCoinDetails(fSyms)
    }
}