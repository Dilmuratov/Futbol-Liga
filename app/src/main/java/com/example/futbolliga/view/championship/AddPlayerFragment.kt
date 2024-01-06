package com.example.futbolliga.view.championship

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.futbolliga.R
import com.example.futbolliga.data.models.Player
import com.example.futbolliga.databinding.FragmentAddPlayersBinding
import com.example.futbolliga.presentation.MainViewModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.math.log2
import kotlin.math.pow

class AddPlayerFragment : Fragment(R.layout.fragment_add_players) {
    private lateinit var binding: FragmentAddPlayersBinding
    private lateinit var adapter: PlayersAdapter
    private val mainViewModel: MainViewModel by viewModel()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAddPlayersBinding.bind(view)
        adapter = PlayersAdapter()
        binding.rvPlayer.adapter = adapter

        initObservers()

        initListeners()

    }

    @SuppressLint("ClickableViewAccessibility", "NotifyDataSetChanged")
    private fun initListeners() {
        binding.btnAdd.setOnClickListener {
            if (binding.etPlayer.text != null && binding.etPlayer.text.toString() != "") {
                MainScope().launch {
                    mainViewModel.addPlayer(
                        Player(
                            0, binding.etPlayer.text.toString()
                        )
                    )
                    mainViewModel.getAllPlayers()
                    binding.etPlayer.setText("")
                    binding.etPlayer.clearFocus()
                }
            } else {
                binding.etPlayer.error = "Qatnasıwshını kiritiń"
            }
        }

        binding.etPlayer.addTextChangedListener {
            if (it == null) {
                binding.etPlayer.error = "Qatnasıwshını kiritiń"
            }
        }

        adapter.setOnDeleteClickListener { player ->
            MainScope().launch {
                mainViewModel.deletePlayer(player)
                mainViewModel.getAllPlayers()
                adapter.notifyDataSetChanged()
            }
        }

        adapter.setOnSaveClickListener { player, name ->
            MainScope().launch {
                mainViewModel.updatePlayer(
                    Player(
                        player.id, name
                    )
                )
                initObservers()
            }
        }

        binding.llRandom.setOnClickListener {
            adapter.submitList(adapter.currentList.shuffled())
        }
    }

    private fun setState(players: List<Player>) {
        val count = players.size
        val a = if (log2(count.toFloat()) % 1.0 == 0.0) log2(count.toFloat()).toInt()
        else log2(count.toFloat()).toInt() + 1
        val delta = (2f.pow(a) - count).toInt()
        if (count == 0) {
            binding.tvState.text = "*"
        } else if (delta != 0) {
            binding.tvState.text =
                "*Jámi $count komanda bar. $delta adam 1-turdı oynamay keyingi basqıshqa shıǵadı."
        } else {
            binding.tvState.text = "*Jámi $count komanda bar."
        }
    }

    private fun initObservers() {
        mainViewModel.allPlayersLiveData.observe(requireActivity()) {
            adapter.submitList(it)
            setState(it)
        }

        MainScope().launch {
            mainViewModel.getAllPlayers()
        }
    }
}