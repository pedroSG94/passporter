package com.pedro.passporter.view.repositories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.pedro.passporter.databinding.RepositoriesFragmentBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RepositoriesFragment : Fragment() {

  private val viewModel: RepositoriesViewModel by viewModels()
  private lateinit var binding: RepositoriesFragmentBinding
  private val adapter = RepositoriesAdapter()

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    binding = RepositoriesFragmentBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.repositoriesList.adapter = adapter
    val dividerItemDecoration = DividerItemDecoration(context, LinearLayoutManager.VERTICAL)
    binding.repositoriesList.addItemDecoration(dividerItemDecoration)
    viewModel.usersObserver.observe(viewLifecycleOwner) {
      adapter.submitList(it)
    }
    viewModel.loadRepositories("pedroSG94")
  }
}