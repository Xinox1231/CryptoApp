package com.example.mycrypto.di

import android.app.Application
import com.example.mycrypto.data.database.AppDataBase
import com.example.mycrypto.data.database.CoinInfoDao
import com.example.mycrypto.data.datasource.LocalDataSource
import com.example.mycrypto.data.datasource.LocalDataSourceImpl
import com.example.mycrypto.data.datasource.RemoteDataSource
import com.example.mycrypto.data.datasource.RemoteDataSourceImpl
import com.example.mycrypto.data.remote.ApiFactory
import com.example.mycrypto.data.remote.CoinApiService
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    fun bindRemoteDataSource(impl: RemoteDataSourceImpl): RemoteDataSource

    @Binds
    fun bindLocalDataSource(impl: LocalDataSourceImpl): LocalDataSource

    companion object {

        @Provides
        fun provideCoinApiService(): CoinApiService = ApiFactory.apiService

        @Provides
        fun provideCoinInfoDao(application: Application): CoinInfoDao =
            AppDataBase.getInstance(application).coinInfoDao()
    }
}