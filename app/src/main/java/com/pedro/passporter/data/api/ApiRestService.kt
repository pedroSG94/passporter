package com.pedro.passporter.data.api

import com.pedro.passporter.data.api.models.Repository
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by pedro on 1/4/22.
 */
interface ApiRestService {

  @GET("/users/{userName}/repos")
  suspend fun getRepositories(@Path("userName") userName: String): List<Repository>
}