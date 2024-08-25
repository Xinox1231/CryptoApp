package com.example.mycrypto.data.datasource

import androidx.lifecycle.LiveData
import com.example.mycrypto.data.database.model.CoinInfoDb

interface LocalDataSource {

    suspend fun insertList(list: List<CoinInfoDb>)

    fun getList(): LiveData<List<CoinInfoDb>>

    fun getDetailedInfo(fSyms: String): LiveData<CoinInfoDb>
}