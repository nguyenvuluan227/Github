package com.example.data.repository


import com.example.domain.model.Repository
import com.example.domain.repository.MainRepository
import io.reactivex.Single
import javax.inject.Inject

class RepositoryRemoteSourceImp @Inject constructor(
    private val repositoryRemoteSource: RepositoryRemoteSource
) : MainRepository {
    override fun getRepository(): Single<List<Repository>> {
        return repositoryRemoteSource.getRepository()
    }
}