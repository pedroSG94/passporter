package com.pedro.passporter.view.repositories

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedro.passporter.data.models.LocalRepository
import com.pedro.passporter.task.ApiRestRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepositoriesViewModel @Inject constructor(private val apiRestRepository: ApiRestRepository): ViewModel() {

  val usersObserver = MutableLiveData<List<LocalRepository>>()

  fun loadRepositories(userName: String) {
    this.viewModelScope.launch {
      val repositories = apiRestRepository.getRepositories(userName)
      usersObserver.value = repositories
    }
  }
}