package com.example.github.di

import android.app.Application
import com.example.data.di.remote.RemoteModule
import com.example.data.di.remote.RepositoryRemoteModule
import com.example.data.di.repository.RepositoryModule
import com.example.github.App
import com.example.github.main.MainModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AppModule::class,
        RemoteModule::class,
        RepositoryModule::class,
        RepositoryRemoteModule::class,
        AndroidSupportInjectionModule::class,
        ActivityBuilderModule::class,
        MainModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: App): Builder

        fun build(): AppComponent
    }

    fun inject(application: Application)
}