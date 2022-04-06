package com.pedro.passporter.data.api

import com.pedro.passporter.data.api.models.Repository

/**
 * Created by pedro on 6/4/22.
 */
interface ApiRest {
  suspend fun getRepositories(userName: String, page: Int, pageSize: Int, headers: Map<String, String>): List<Repository>
}