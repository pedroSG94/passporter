package com.pedro.passporter.task

import com.pedro.passporter.data.api.ApiRest
import com.pedro.passporter.data.api.ApiRestImp
import com.pedro.passporter.data.models.LocalRepository
import com.pedro.passporter.utils.toLocalRepository

/**
 * Created by pedro on 1/4/22.
 */
class ApiRestRepositoryImp(private val apiRest: ApiRest) : ApiRestRepository {

  override suspend fun getRepositories(userName: String, page: Int, pageSize: Int,
    headers: Map<String, String>): List<LocalRepository> {
    val remoteRepositories = apiRest.getRepositories(userName, page, pageSize, headers)
    return remoteRepositories.map { it.toLocalRepository() }
  }
}