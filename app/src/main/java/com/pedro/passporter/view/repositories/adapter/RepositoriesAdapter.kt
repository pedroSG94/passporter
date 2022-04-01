package com.pedro.passporter.view.repositories.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.pedro.passporter.data.models.LocalRepository
import com.pedro.passporter.databinding.RepositoryItemBinding

/**
 * Created by pedro on 1/4/22.
 */
class RepositoriesAdapter(private val listener: ClickListener):
  PagingDataAdapter<LocalRepository, RepositoriesAdapter.ViewHolder>(UserDiffCallback()) {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val binding = RepositoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return ViewHolder(binding, listener)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val item = getItem(position)
    holder.bind(item)
  }

  class ViewHolder(private val itemBinding: RepositoryItemBinding, private val listener: ClickListener) :
    RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(repository: LocalRepository?) {
      repository?.let { localRepository ->
        itemBinding.repository = localRepository
        itemBinding.executePendingBindings()
        itemBinding.root.setOnLongClickListener {
          listener.onClick(localRepository)
        }
      }
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

  interface ClickListener {
    fun onClick(localRepository: LocalRepository): Boolean
  }
}