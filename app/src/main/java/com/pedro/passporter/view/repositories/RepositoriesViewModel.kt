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
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class RepositoriesViewModel @Inject constructor(private val apiRestRepository: ApiRestRepository): ViewModel() {

  private val config = PassporterConfig()

  fun getRepositories(): Flow<PagingData<LocalRepository>> {
    val pager = Pager(config = PagingConfig(config.pageSize), pagingSourceFactory = { RepositoriesPagingSource(apiRestRepository, config) })
    return pager.flow.cachedIn(viewModelScope)
  }
}