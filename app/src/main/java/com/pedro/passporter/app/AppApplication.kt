package com.pedro.passporter.app

import android.app.Application
import com.pedro.passporter.app.di.AppModule
import com.pedro.passporter.app.di.RepositoriesModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Created by pedro on 1/4/22.
 */
class AppApplication: Application() {
  override fun onCreate() {
    super.onCreate()
    startKoin {
      androidLogger()
      androidContext(this@AppApplication)
      modules(listOf(AppModule(), RepositoriesModule()))
    }
  }
}