package com.example.data.remote.model

import com.google.gson.annotations.SerializedName


data class RepositoryApi(
    @SerializedName("id") val id: Long,
    @SerializedName("node_id") val nodeId: String,
    @SerializedName("name") val name: String,
    @SerializedName("full_name") val fullName: String,
    @SerializedName("private") val private: Boolean,
    @SerializedName("owner") val owner: OwnerApi
)