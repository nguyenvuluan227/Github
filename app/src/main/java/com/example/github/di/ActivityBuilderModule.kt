package com.example.github.di

import com.example.github.main.MainActivity
import com.example.github.main.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun mainActivity(): MainActivity
}