package com.pedro.passporter.app.di

import com.pedro.passporter.task.ApiRestRepository
import com.pedro.passporter.task.ApiRestRepositoryImp
import com.pedro.passporter.view.repositories.RepositoriesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by pedro on 1/4/22.
 */
object RepositoriesModule {
  operator fun invoke() = module {
    factory<ApiRestRepository> { ApiRestRepositoryImp(get()) }

    viewModel { RepositoriesViewModel(get()) }
  }
}