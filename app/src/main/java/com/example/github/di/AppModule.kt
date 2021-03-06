package com.example.github.di

import android.content.Context
import com.example.base.di.ApplicationContext
import com.example.github.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    @ApplicationContext
    fun provideApplicationContext(app: App): Context = app.applicationContext!!
}