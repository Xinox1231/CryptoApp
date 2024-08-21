package com.example.mycrypto.di

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

    companion object {

        @Provides
        fun provideCoinApiService(): CoinApiService = ApiFactory.apiService
    }
}