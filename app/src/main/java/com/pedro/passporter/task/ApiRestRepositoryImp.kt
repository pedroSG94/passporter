package com.pedro.passporter.task

import com.pedro.passporter.data.api.ApiRestImp
import com.pedro.passporter.data.models.LocalRepository
import com.pedro.passporter.utils.toLocalRepository

/**
 * Created by pedro on 1/4/22.
 */
class ApiRestRepositoryImp(private val apiRestImp: ApiRestImp) : ApiRestRepository {

  override suspend fun getRepositories(userName: String): List<LocalRepository> {
    val remoteRepositories = apiRestImp.getRepositories(userName)
    return remoteRepositories.map { it.toLocalRepository() }
  }
}