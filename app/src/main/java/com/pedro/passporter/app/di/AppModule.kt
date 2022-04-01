package com.pedro.passporter.app.di

import com.pedro.passporter.data.api.ApiRestImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by pedro on 1/4/22.
 */
@Module
@InstallIn(SingletonComponent::class)
class AppModule {

  @Provides
  @Singleton
  fun provideApiRest() = ApiRestImp()
}