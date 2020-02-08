package com.example.domain.usecase

import com.example.domain.UseCase
import com.example.domain.model.Repository
import com.example.domain.repository.MainRepository
import io.reactivex.Single
import javax.inject.Inject

class GetRepositoryUseCase @Inject constructor(
    private val repository: MainRepository
) : UseCase<GetRepositoryUseCase.Params, Single<List<Repository>>>() {

    override fun createObservable(params: Params?): Single<List<Repository>> {
        if (params == null) return Single.error(Exception("params == null"))

        return repository.getRepository()
    }

    class Params
}