package com.example.futbolliga.view

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.futbolliga.data.models.MatchData
import com.example.futbolliga.databinding.ItemResultGameBinding
import com.example.futbolliga.utils.gone
import com.example.futbolliga.utils.set
import com.example.futbolliga.utils.visible

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

    private var onItemLongClickListener: ((MatchData) -> Unit)? = null
    fun setOnItemLongClickListener(block: ((MatchData) -> Unit)) {
        onItemLongClickListener = block
    }

    private var selectAll: ((MatchData) -> (Boolean))? = null
    fun selectAll(block: ((MatchData) -> (Boolean))) {
        selectAll = block
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemResultGameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(position)
}