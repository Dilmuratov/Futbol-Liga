package com.example.futbolliga.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.futbolliga.data.models.MatchData
import com.example.futbolliga.databinding.ItemResultGameBinding
import com.example.futbolliga.utils.set

class SavedGameAdapter(private val context: Context) :
    ListAdapter<MatchData, SavedGameAdapter.ViewHolder>(
        object : DiffUtil.ItemCallback<MatchData>() {
            override fun areItemsTheSame(oldItem: MatchData, newItem: MatchData) =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: MatchData, newItem: MatchData) =
                oldItem.id == newItem.id
        }
    ) {

    inner class ViewHolder(private val binding: ItemResultGameBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val match = getItem(position)
            binding.tvScoreA.text = match.scoreA.toString()
            binding.tvScoreB.text = match.scoreB.toString()
            binding.ivTeamA.set(match.teamAUrl, context)
            binding.ivTeamB.set(match.teamBUrl, context)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemResultGameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(position)
}