package com.example.github

import android.app.Application
import com.example.github.di.AppComponent
import com.example.github.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>
    private var appComponent: AppComponent? = null

    override fun onCreate() {
        super.onCreate()
        inject()
    }

    private fun inject() {
        appComponent = DaggerAppComponent
            .builder()
            .application(this)
            .build()
        appComponent?.inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        inject()
        return androidInjector
    }
}