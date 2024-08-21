package com.example.mycrypto.di

import com.example.mycrypto.presentation.MainActivity
import dagger.Component

@Component(modules = [DomainModule::class, DataModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun inject(activity: MainActivity)
}