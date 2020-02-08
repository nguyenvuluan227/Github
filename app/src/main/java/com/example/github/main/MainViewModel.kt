package com.example.github.main

import android.util.Log
import com.example.base.BaseViewModel
import com.example.base.Event
import com.example.base.adapter.DisplayableItem
import com.example.domain.model.Repository
import com.example.domain.usecase.GetRepositoryUseCase
import com.example.github.main.adapter.RepositoryItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val repositoryUseCase: GetRepositoryUseCase) :
    BaseViewModel<RepositoryState>() {

    override fun initState(): RepositoryState = RepositoryState()

    fun getRepository() {
        repositoryUseCase.createObservable(GetRepositoryUseCase.Params())
            .subscribeOn(Schedulers.io())
            .map { convertDataToUI(it) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Log.d("REPOSITORY", "HAS DATA")
                    setState {
                        copy(
                            uiItems = it
                        )
                    }
                },
                {
                    it.printStackTrace()
                    Log.e("ERROR", "${it.printStackTrace()}")
                    setState {
                        copy(
                            error = Event(data = true)
                        )
                    }
                }
            )
            .addToDisposables()
    }

    internal fun convertDataToUI(repository: List<Repository>): List<DisplayableItem> {
        return repository.map {
            RepositoryItem(it)
        }
    }
}

data class RepositoryState(
    val error: Event<Boolean>? = null,
    val uiItems: List<DisplayableItem> = listOf()
)