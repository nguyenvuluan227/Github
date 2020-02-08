package com.example.data.di.repository

import com.example.data.repository.RepositoryRemoteSourceImp
import com.example.domain.repository.MainRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(repositoryRemoteSourceImp: RepositoryRemoteSourceImp): MainRepository =
        repositoryRemoteSourceImp
}