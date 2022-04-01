package com.pedro.passporter.data.api

import com.pedro.passporter.data.api.models.Repository
import okhttp3.Headers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
/**
 * Created by pedro on 1/4/22.
 */
class ApiRestImp {

  private val url = "https://api.github.com"
  private val service = getRetrofit().create(ApiRestService::class.java)

  private fun getRetrofit(): Retrofit {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
    return Retrofit.Builder()
      .baseUrl(url)
      .client(client)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
  }

  suspend fun getRepositories(userName: String, page: Int, pageSize: Int, headers: Map<String, String>): List<Repository> {
    return service.getRepositories(userName, page, pageSize, headers)
  }
}