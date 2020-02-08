package com.example.github.main

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.example.base.di.ActivityContext
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    @ActivityContext
    fun provideActivityContext(activity: MainActivity): Context = activity

    @Provides
    fun provideViewModel(
        activity: MainActivity,
        factory: MainViewModelFactory
    ): MainViewModel {
        return ViewModelProvider(activity, factory)
            .get(MainViewModel::class.java)
    }
}