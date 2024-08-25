package com.example.mycrypto.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mycrypto.data.database.model.CoinInfoDb

@Dao
interface CoinInfoDao {

    @Query("SELECT * FROM full_price_list ORDER BY lastUpdate DESC")
    fun getFullPriceList(): LiveData<List<CoinInfoDb>>

    @Query("SELECT * FROM full_price_list WHERE fromSymbol=:fSym")
    fun getCoinDetails(fSym: String): LiveData<CoinInfoDb>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(list: List<CoinInfoDb>)

}