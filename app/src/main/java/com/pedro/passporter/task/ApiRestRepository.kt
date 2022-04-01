package com.pedro.passporter.task

import com.pedro.passporter.data.models.LocalRepository

/**
 * Created by pedro on 1/4/22.
 */
interface ApiRestRepository {

  suspend fun getRepositories(userName: String): List<LocalRepository>
}