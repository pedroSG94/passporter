package com.pedro.passporter.view.repositories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pedro.passporter.data.models.LocalRepository
import com.pedro.passporter.databinding.RepositoryItemBinding

/**
 * Created by pedro on 1/4/22.
 */
class RepositoriesAdapter: ListAdapter<LocalRepository, RepositoriesAdapter.ViewHolder>(UserDiffCallback()) {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val binding = RepositoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return ViewHolder(binding)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val item = getItem(position)
    holder.bind(item)
  }

  class ViewHolder(private val itemBinding: RepositoryItemBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(repository: LocalRepository) {
      itemBinding.repository = repository
      itemBinding.executePendingBindings()
    }
  }

  class UserDiffCallback: DiffUtil.ItemCallback<LocalRepository>() {
    override fun areItemsTheSame(oldItem: LocalRepository, newItem: LocalRepository): Boolean {
      return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: LocalRepository, newItem: LocalRepository): Boolean {
      return oldItem.id == newItem.id
    }
  }
}