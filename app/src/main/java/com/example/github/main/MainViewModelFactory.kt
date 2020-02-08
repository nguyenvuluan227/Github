package com.example.github.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecase.GetRepositoryUseCase
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(
    private val repositoryUseCase: GetRepositoryUseCase
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repositoryUseCase) as T
    }
}