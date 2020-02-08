package com.example.data.mapper

import com.example.data.remote.model.RepositoryApi
import com.example.domain.model.Repository
import javax.inject.Inject

class RepositoryApiMapper @Inject constructor(
    private val ownerApiMapper: OwnerApiMapper
) {

    fun mapToDomain(api: RepositoryApi): Repository {
        return Repository(
            id = api.id,
            nodeId = api.nodeId,
            name = api.name,
            fullName = api.fullName,
            private = api.private,
            owner = ownerApiMapper.mapToDoMain(api.owner)
        )
    }
}