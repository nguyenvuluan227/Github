package com.example.data.repository

import com.example.data.mapper.RepositoryApiMapper
import com.example.data.remote.response.RepositoryService
import com.example.domain.model.Repository
import com.example.domain.repository.MainRepository
import io.reactivex.Single
import javax.inject.Inject

class RepositoryRemoteSource @Inject constructor(
    private val repositoryService: RepositoryService,
    private val repositoryApiMapper: RepositoryApiMapper
) : MainRepository {
    override fun getRepository(): Single<List<Repository>> {
        return repositoryService.getRepository(perPage = "25", page = "1")
            .map { it.map { repositoryApiMapper.mapToDomain(it) } }

    }
}
