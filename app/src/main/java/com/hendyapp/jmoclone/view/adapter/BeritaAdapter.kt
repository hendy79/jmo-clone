package com.hendyapp.jmoclone.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hendyapp.jmoclone.databinding.ItemBeritaBinding
import com.hendyapp.jmoclone.model.PostResponse

class BeritaAdapter(private val context: Context): ListAdapter<PostResponse, BeritaAdapter.ViewHolder>(DiffCallback()) {
    private class DiffCallback : DiffUtil.ItemCallback<PostResponse>() {
        override fun areItemsTheSame(oldItem: PostResponse, newItem: PostResponse)
                = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: PostResponse, newItem: PostResponse)
                = oldItem == newItem
    }

    class ViewHolder(val binding: ItemBeritaBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBeritaBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.iBeritaTitle.text = currentList[position].title
    }
}