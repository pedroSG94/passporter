package com.pedro.passporter.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by pedro on 1/4/22.
 */
class ApiRestImp {

  private val url = "https://api.github.com"
  private val service = getRetrofit().create(ApiRestService::class.java)

  private fun getRetrofit(): Retrofit {
    return Retrofit.Builder()
      .baseUrl(url)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
  }

  suspend fun getRepositories(userName: String) = service.getRepositories(userName)
}