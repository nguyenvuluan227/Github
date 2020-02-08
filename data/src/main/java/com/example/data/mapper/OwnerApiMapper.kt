package com.example.data.mapper

import com.example.data.remote.model.OwnerApi
import com.example.domain.model.Owner
import javax.inject.Inject

class OwnerApiMapper @Inject constructor() {

    fun mapToDoMain(api: OwnerApi): Owner {
        return Owner(
            login = api.login,
            id = api.id,
            nodeId = api.nodeId,
            avatarUrl = api.avatarUrl
        )
    }
}