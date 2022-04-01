package com.pedro.passporter.app.di

import com.pedro.passporter.data.api.ApiRestImp
import com.pedro.passporter.task.ApiRestRepository
import com.pedro.passporter.task.ApiRestRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

/**
 * Created by pedro on 1/4/22.
 */
@Module
@InstallIn(ViewModelComponent::class)
class RepositoriesModule {

  @Provides
  fun provideTaskGetRepositories(apiRestImp: ApiRestImp): ApiRestRepository = ApiRestRepositoryImp(apiRestImp)
}