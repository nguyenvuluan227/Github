package com.example.data.remote.response

import com.example.data.remote.model.RepositoryApi
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RepositoryService {

    @GET("users/sr/repos")
    fun getRepository(
        @Query("per_page") perPage: String,
        @Query("page") page: String
    ): Single<List<RepositoryApi>>
}