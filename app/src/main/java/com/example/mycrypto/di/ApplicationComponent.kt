package com.example.mycrypto.di

import android.app.Application
import com.example.mycrypto.presentation.ApplicationActivity
import com.example.mycrypto.presentation.CoinDetailsFragment
import com.example.mycrypto.presentation.CoinListFragment
import dagger.BindsInstance
import dagger.Component

@Component(modules = [DomainModule::class, DataModule::class, ViewModelModule::class])
@ApplicationScope
interface ApplicationComponent {

    fun inject(fragment: CoinListFragment)
    fun inject(fragment: CoinDetailsFragment)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}