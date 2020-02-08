package com.example.domain.repository

import com.example.domain.model.Repository
import io.reactivex.Single

interface MainRepository {
    fun getRepository(): Single<List<Repository>>
}