package com.example.domain.model


data class Repository(
    val id: Long,
    val nodeId: String,
    val name: String,
    val fullName: String,
    val private: Boolean,
    val owner: Owner
)