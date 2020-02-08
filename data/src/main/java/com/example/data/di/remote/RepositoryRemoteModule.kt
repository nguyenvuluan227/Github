package com.example.data.di.remote

import com.example.data.remote.response.RepositoryService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class RepositoryRemoteModule {

    @Provides
    @Singleton
    fun provideRepositoryService(retrofit: Retrofit): RepositoryService {
        return retrofit.create(RepositoryService::class.java)
    }
}