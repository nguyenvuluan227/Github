package com.example.base

import android.app.Application
import androidx.lifecycle.*
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.addTo

abstract class BaseAndroidViewModel<S>(application: Application) : AndroidViewModel(application),
    LifecycleObserver {

    private val disposables: CompositeDisposable = CompositeDisposable()
    val state: MutableLiveData<S> = MutableLiveData()

    abstract fun initState(): S

    fun state() = state.value ?: initState()

    fun setState(block: S.() -> S) {
        state.value = block(state.value ?: initState())
    }

    fun Disposable.addToDisposables() {
        this.addTo(disposables)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        disposables.clear()
    }
}
