package com.pedro.passporter.view.repositories.adapter

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.pedro.passporter.data.models.LocalRepository
import com.pedro.passporter.data.models.PassporterConfig
import com.pedro.passporter.task.ApiRestRepository

/**
 * Created by pedro on 1/4/22.
 */
class RepositoriesPagingSource(private val apiRestRepository: ApiRestRepository,
  private val config: PassporterConfig): PagingSource<Int, LocalRepository>() {

  override fun getRefreshKey(state: PagingState<Int, LocalRepository>): Int? {
    return state.anchorPosition
  }

  override suspend fun load(params: LoadParams<Int>): LoadResult<Int, LocalRepository> {
    return try {
      val nextPage = params.key ?: 1
      val headers = HashMap<String, String>()
      //optional token. Discard token if empty.
      if (config.token.isNotEmpty()) {
        headers["Authorization"] = "token ${config.token}"
      }
      val repositories = apiRestRepository.getRepositories(config.userName, nextPage, config.pageSize, headers)
      //check if we are in the final page
      val validPage = if (repositories.isEmpty()) null else nextPage + 1
      LoadResult.Page(data = repositories, prevKey = null, nextKey = validPage)
    } catch (e: Exception) {
      LoadResult.Error(e)
    }
  }
}