package com.example.futbolliga.view.championship

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.futbolliga.data.models.Player
import com.example.futbolliga.databinding.ItemPlayerBinding
import com.example.futbolliga.utils.gone
import com.example.futbolliga.utils.visible

class PlayersAdapter :
    ListAdapter<Player, PlayersAdapter.ViewHolder>(
        object : DiffUtil.ItemCallback<Player>() {
            override fun areItemsTheSame(oldItem: Player, newItem: Player) = oldItem == newItem

            override fun areContentsTheSame(oldItem: Player, newItem: Player) =
                oldItem.name == newItem.name
        }
    ) {

    inner class ViewHolder(private val binding: ItemPlayerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val player = getItem(position)
            binding.etPlayer.setText(player.name)
            binding.etPlayer.isEnabled = false

            initListeners(binding, player)

        }

        private fun initListeners(binding: ItemPlayerBinding, player: Player) {
            binding.ivEdit.setOnClickListener {
                binding.ivEdit.gone()
                binding.ivSave.visible()
                binding.etPlayer.isEnabled = true
            }

            binding.ivDelete.setOnClickListener {
                onDeleteClickListener?.invoke(player)
                removeItem(player)
            }

            binding.ivSave.setOnClickListener {
                onSaveClickListener?.invoke(player, binding.etPlayer.text.toString())
                binding.etPlayer.isEnabled = false
                binding.ivEdit.visible()
                binding.ivSave.gone()
            }
        }
    }

    private var onDeleteClickListener: ((Player) -> Unit)? = null
    fun setOnDeleteClickListener(block: ((Player) -> Unit)) {
        onDeleteClickListener = block
    }

    private var onSaveClickListener: ((Player, String) -> Unit)? = null
    fun setOnSaveClickListener(block: ((Player, String) -> Unit)) {
        onSaveClickListener = block
    }

    fun removeItem(player: Player) {
        val list = currentList.toMutableList()
        list.remove(player)
        submitList(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemPlayerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(position)
}