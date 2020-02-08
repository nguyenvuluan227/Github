package com.example.data.remote.model

import com.google.gson.annotations.SerializedName

data class OwnerApi(
    @SerializedName("login") val login: String,
    @SerializedName("id") val id: Int,
    @SerializedName("node_id") val nodeId: String,
    @SerializedName("avatar_url") val avatarUrl: String
)