package com.pedro.passporter.view.repositories

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.pedro.passporter.R
import com.pedro.passporter.data.models.LocalRepository
import com.pedro.passporter.databinding.DialogLayoutBinding
import com.pedro.passporter.databinding.RepositoriesFragmentBinding
import com.pedro.passporter.view.repositories.adapter.RepositoriesAdapter
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel


class RepositoriesFragment : Fragment(), RepositoriesAdapter.ClickListener {

  private val repositoriesViewModel: RepositoriesViewModel by viewModel()
  private lateinit var binding: RepositoriesFragmentBinding
  private val adapter = RepositoriesAdapter(this)

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
    binding = RepositoriesFragmentBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.repositoriesList.adapter = adapter
    val dividerItemDecoration = DividerItemDecoration(context, LinearLayoutManager.VERTICAL)
    binding.repositoriesList.addItemDecoration(dividerItemDecoration)
    lifecycleScope.launchWhenCreated {
      repositoriesViewModel.getRepositories().collectLatest {
        adapter.submitData(it)
      }
    }
  }

  override fun onClick(localRepository: LocalRepository): Boolean {
    context?.let {
      openDialog(localRepository, it)
    }
    return true
  }

  private fun openDialog(localRepository: LocalRepository, context: Context) {
    val dialogBinding = DialogLayoutBinding.inflate(layoutInflater)
    val dialog = MaterialAlertDialogBuilder(context)
    dialog.setTitle(localRepository.name)
    dialog.setView(dialogBinding.root)
    dialogBinding.repoUrl.text = getString(R.string.go_to, localRepository.htmlUrl)
    dialogBinding.ownerUrl.text = getString(R.string.go_to, localRepository.htmlUrlOwner)
    dialogBinding.repoUrl.setOnClickListener {
      openBrowser(localRepository.htmlUrl)
    }
    dialogBinding.ownerUrl.setOnClickListener {
      openBrowser(localRepository.htmlUrlOwner)
    }
    dialog.show()
  }

  private fun openBrowser(url: String) {
    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    startActivity(browserIntent)
  }
}