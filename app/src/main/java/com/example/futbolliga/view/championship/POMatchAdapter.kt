package com.example.futbolliga.view.championship

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.futbolliga.data.models.PlayOffMatchData
import com.example.futbolliga.databinding.ItemPlayOffGameBinding
import com.example.futbolliga.utils.gone
import com.example.futbolliga.utils.visible

class POMatchAdapter : ListAdapter<PlayOffMatchData, POMatchAdapter.ViewHolder>(
    object : DiffUtil.ItemCallback<PlayOffMatchData>() {
        override fun areItemsTheSame(
            oldItem: PlayOffMatchData,
            newItem: PlayOffMatchData
        ) = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: PlayOffMatchData,
            newItem: PlayOffMatchData
        ) = oldItem.id == newItem.id
    }
) {

    inner class ViewHolder(private val binding: ItemPlayOffGameBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val match = getItem(position)
            binding.tvTeamA.text = match.teamA
            binding.tvTeamB.text = match.teamB
            binding.etScoreA.setText(match.scoreA.toString())
            binding.etScoreB.setText(match.scoreB.toString())

            binding.etScoreA.isEnabled = false
            binding.etScoreB.isEnabled = false

            if (match.teamB == "Bot") {
                binding.ivEdit.isClickable = false
                binding.ivSave.isClickable = false
            }

            initListeners(binding, match)
        }

        private fun initListeners(binding: ItemPlayOffGameBinding, match: PlayOffMatchData?) {
            binding.ivEdit.setOnClickListener {
                binding.etScoreA.isEnabled = true
                binding.etScoreB.isEnabled = true
                binding.ivEdit.gone()
                binding.ivSave.visible()
            }

            binding.ivSave.setOnClickListener {
                binding.etScoreA.isEnabled = false
                binding.etScoreB.isEnabled = false
                binding.ivEdit.visible()
                binding.ivSave.gone()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemPlayOffGameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(position)
}