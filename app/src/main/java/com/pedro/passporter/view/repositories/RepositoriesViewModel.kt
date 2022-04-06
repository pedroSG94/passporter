package com.pedro.passporter.view.repositories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.pedro.passporter.data.models.LocalRepository
import com.pedro.passporter.data.models.PassporterConfig
import com.pedro.passporter.task.ApiRestRepository
import com.pedro.passporter.view.repositories.adapter.RepositoriesPagingSource
import kotlinx.coroutines.flow.Flow

class RepositoriesViewModel(private val apiRestRepository: ApiRestRepository): ViewModel() {

  private val config = PassporterConfig()

  fun getRepositories(): Flow<PagingData<LocalRepository>> {
    val pager = Pager(config = PagingConfig(config.pageSize), pagingSourceFactory = { RepositoriesPagingSource(apiRestRepository, config) })
    return pager.flow.cachedIn(viewModelScope)
  }
}