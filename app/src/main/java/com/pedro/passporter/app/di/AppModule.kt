package com.pedro.passporter.app.di

import com.pedro.passporter.data.api.ApiRest
import com.pedro.passporter.data.api.ApiRestImp
import org.koin.dsl.module

/**
 * Created by pedro on 1/4/22.
 */
object AppModule {
  operator fun invoke() = module {
    single<ApiRest> { ApiRestImp() }
  }
}