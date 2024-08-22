package com.example.mycrypto.data.mapper

import com.example.mycrypto.data.database.model.CoinInfoDb
import com.example.mycrypto.data.remote.dto.CoinInfoDto
import com.example.mycrypto.data.remote.dto.CoinInfoJsonContainerDto
import com.example.mycrypto.data.remote.dto.CoinNamesListDto
import com.example.mycrypto.domain.model.CoinInfo
import com.google.gson.Gson
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.time.Instant
import java.util.Date
import java.util.Locale
import java.util.TimeZone
import javax.inject.Inject

class CoinMapper @Inject constructor() {

    fun mapCoinInfoDtoToDb(dto: CoinInfoDto) = CoinInfoDb(
        fromSymbol = dto.fromSymbol,
        toSymbol = dto.toSymbol,
        price = dto.price,
        lastUpdate = dto.lastUpdate,
        highDay = dto.highDay,
        lowDay = dto.lowDay,
        lastMarket = dto.lastMarket,
        imageUrl = BASE_IMAGE_URL + dto.imageUrl
    )

    fun mapCoinInfoDbToCoinInfo(db: CoinInfoDb) = CoinInfo(
        fromSymbol = db.fromSymbol,
        toSymbol = db.toSymbol,
        price = db.price,
        lastUpdate = convertTimestampToTime(db.lastUpdate),
        highDay = db.highDay,
        lowDay = db.lowDay,
        lastMarket = db.lastMarket,
        imageUrl = db.imageUrl
    )

    private fun convertTimestampToTime(timestamp: Long?): String {
        if (timestamp == null) return ""
        val stamp = Timestamp(timestamp * 1000)
        val date = Date(stamp.time)
        val pattern = "HH:mm:ss"
        val sdf = SimpleDateFormat(pattern, Locale.getDefault())
        sdf.timeZone = TimeZone.getDefault()
        return sdf.format(date)
    }

    fun mapCoinNamesListToString(list: CoinNamesListDto?): String {
        return list?.names?.map { it.coinName?.name }?.joinToString { "," } ?: EMPTY_STRING
    }

    // jsonObject содержит набор ключей, каждый из которых приводит к другому jsonObject - монету

    fun mapJsonContainerToListCoinInfo(jsonContainerDto: CoinInfoJsonContainerDto?): List<CoinInfoDto> {
        val result = mutableListOf<CoinInfoDto>()
        val jsonObject = jsonContainerDto?.json ?: return result
        val coinKeySet = jsonObject.keySet()
        for (coinKey in coinKeySet) {
            val currencyCoinJson = jsonObject.getAsJsonObject(coinKey)
            val currencyKeySet = currencyCoinJson.keySet()
            for (currencyKey in currencyKeySet) {
                val priceInfo = Gson().fromJson(
                    currencyCoinJson.getAsJsonObject(currencyKey),
                    CoinInfoDto::class.java
                )
                result.add(priceInfo)
            }
        }
        return result
    }

    companion object {

        private const val EMPTY_STRING = ""
        private const val BASE_IMAGE_URL = "https://cryptocompare.com"
    }
}