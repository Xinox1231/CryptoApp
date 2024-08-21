package com.example.mycrypto.di

import com.example.mycrypto.data.CoinRepositoryImpl
import com.example.mycrypto.domain.CoinRepository
import dagger.Binds
import dagger.Module

@Module
interface DomainModule {

    @Binds
    fun bindCoinRepository(impl: CoinRepositoryImpl): CoinRepository
}