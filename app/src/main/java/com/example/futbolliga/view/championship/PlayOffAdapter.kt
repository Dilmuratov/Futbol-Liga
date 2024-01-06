package com.example.futbolliga.view.championship

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.futbolliga.data.models.PlayOffMatchData
import com.example.futbolliga.databinding.ItemPlayOffBinding

class PlayOffAdapter(private val poMatchAdapter: POMatchAdapter) : ListAdapter<List<PlayOffMatchData>, PlayOffAdapter.ViewHolder>(
    object : DiffUtil.ItemCallback<List<PlayOffMatchData>>() {
        override fun areItemsTheSame(
            oldItem: List<PlayOffMatchData>,
            newItem: List<PlayOffMatchData>
        ) = newItem == oldItem

        override fun areContentsTheSame(
            oldItem: List<PlayOffMatchData>,
            newItem: List<PlayOffMatchData>
        ) = newItem.size == oldItem.size
    }
) {

    inner class ViewHolder(private val binding: ItemPlayOffBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val list = getItem(position)
            binding.rvPlayOff.adapter = poMatchAdapter
            poMatchAdapter.submitList(list)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemPlayOffBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(position)
}