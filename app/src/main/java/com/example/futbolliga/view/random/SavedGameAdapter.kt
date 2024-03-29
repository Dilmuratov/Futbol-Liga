package com.example.futbolliga.view.random

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.futbolliga.data.models.RandomMatchData
import com.example.futbolliga.databinding.ItemResultGameBinding
import com.example.futbolliga.utils.gone
import com.example.futbolliga.utils.set
import com.example.futbolliga.utils.visible

class SavedGameAdapter(private val context: Context) :
    ListAdapter<RandomMatchData, SavedGameAdapter.ViewHolder>(
        object : DiffUtil.ItemCallback<RandomMatchData>() {
            override fun areItemsTheSame(oldItem: RandomMatchData, newItem: RandomMatchData) =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: RandomMatchData, newItem: RandomMatchData) =
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

            var selected = true
            binding.root.setOnLongClickListener {
                if (selected) {
                    binding.root.setBackgroundColor(Color.parseColor("#07F468"))
                    binding.ivCheck.visible()
                } else {
                    binding.root.setBackgroundColor(Color.parseColor("#FEF7FF"))
                    binding.ivCheck.gone()
                }
                onItemLongClickListener?.invoke(match)
                selected = selected.not()
                true
            }

            val a = selectAll?.invoke(match)
            if (a != null) {
                selected = if (a) {
                    binding.root.setBackgroundColor(Color.parseColor("#07F468"))
                    binding.ivCheck.visible()
                    false
                } else {
                    binding.root.setBackgroundColor(Color.parseColor("#FEF7FF"))
                    binding.ivCheck.gone()
                    true
                }
            }
        }
    }

    private var onItemLongClickListener: ((RandomMatchData) -> Unit)? = null
    fun setOnItemLongClickListener(block: ((RandomMatchData) -> Unit)) {
        onItemLongClickListener = block
    }

    private var selectAll: ((RandomMatchData) -> (Boolean))? = null
    fun selectAll(block: ((RandomMatchData) -> (Boolean))) {
        selectAll = block
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemResultGameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(position)
}