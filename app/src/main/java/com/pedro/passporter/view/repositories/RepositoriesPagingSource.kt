package com.pedro.passporter.view.repositories

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.pedro.passporter.data.models.LocalRepository
import com.pedro.passporter.task.ApiRestRepository

/**
 * Created by pedro on 1/4/22.
 */
class RepositoriesPagingSource(private val apiRestRepository: ApiRestRepository, private val userName: String,
  private val pageSize: Int, private val token: String): PagingSource<Int, LocalRepository>() {

  override fun getRefreshKey(state: PagingState<Int, LocalRepository>): Int? {
    return state.anchorPosition
  }

  override suspend fun load(params: LoadParams<Int>): LoadResult<Int, LocalRepository> {
    return try {
      val nextPage = params.key ?: 1
      val headers = HashMap<String, String>()
      //optional token. Discard token if empty.
      if (token.isNotEmpty()) {
        headers["Authorization"] = "token $token"
      }
      val repositories = apiRestRepository.getRepositories(userName, nextPage, pageSize, headers)
      LoadResult.Page(data = repositories, prevKey = null, nextKey = nextPage + 1)
    } catch (e: Exception) {
      LoadResult.Error(e)
    }
  }
}