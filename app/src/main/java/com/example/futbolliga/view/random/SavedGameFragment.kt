package com.example.futbolliga.view.random

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.futbolliga.R
import com.example.futbolliga.data.models.MatchData
import com.example.futbolliga.databinding.FragmentSavedGamesBinding
import com.example.futbolliga.presentation.MainViewModel
import com.example.futbolliga.utils.gone
import com.example.futbolliga.utils.visible
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class SavedGameFragment : Fragment(R.layout.fragment_saved_games) {
    private lateinit var binding: FragmentSavedGamesBinding
    private lateinit var matches: List<MatchData>
    private lateinit var adapter: SavedGameAdapter
    private val mainViewModel: MainViewModel by viewModel()
    private val deletedMatches = mutableListOf<MatchData>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSavedGamesBinding.bind(view)
        adapter = SavedGameAdapter(requireActivity())
        binding.recyclerViewSavedGames.adapter = adapter

        initListeners()

        initObservers()

        checkSelectAll()
    }

    private fun checkSelectAll() {
        if (deletedMatches.isNotEmpty()) {
            if (deletedMatches.size == adapter.currentList.size) {
                binding.ivSelectAll.gone()
                binding.ivAntiSelectAll.visible()
            } else {
                binding.ivSelectAll.visible()
                binding.ivAntiSelectAll.gone()
            }
            binding.ivDelete.visible()
        } else {
            binding.ivSelectAll.gone()
            binding.ivAntiSelectAll.gone()
            binding.ivDelete.gone()
        }
    }

    private fun initObservers() {
        mainViewModel.allMatchesLiveData.observe(requireActivity()) {
            matches = it
            adapter.submitList(it)
            setData()
        }

        MainScope().launch {
            mainViewModel.getAllMatches()
        }
    }

    private fun initListeners() {
        if (::matches.isInitialized) {
            setData()
        }

        adapter.setOnItemLongClickListener { matchData ->
            if (matchData in deletedMatches) {
                deletedMatches.remove(matchData)
            } else {
                deletedMatches.add(matchData)
            }
            checkSelectAll()
        }

        binding.ivDelete.setOnClickListener {
            if (deletedMatches.isNotEmpty()) {
                deletedMatches.forEach { matchData ->
                    MainScope().launch {
                        mainViewModel.deleteMatch(matchData)
                        mainViewModel.getAllMatches()
                    }
                    checkSelectAll()
                }
            }
            binding.ivSelectAll.gone()
            binding.ivAntiSelectAll.gone()
            binding.ivDelete.gone()
        }

        binding.ivSelectAll.setOnClickListener {
            adapter.selectAll {
                adapter.currentList.forEach { matchData ->
                    if ((matchData in deletedMatches).not()) {
                        deletedMatches.add(matchData)
                    }
                }
                true
            }
            adapter.notifyDataSetChanged()
            checkSelectAll()
            binding.ivSelectAll.gone()
            binding.ivAntiSelectAll.visible()
        }

        binding.ivAntiSelectAll.setOnClickListener {
            adapter.selectAll {
                adapter.currentList.forEach { matchData ->
                    deletedMatches.remove(matchData)
                }
                false
            }
            adapter.notifyDataSetChanged()
            checkSelectAll()
            binding.ivSelectAll.gone()
            binding.ivAntiSelectAll.gone()
            binding.ivDelete.gone()
        }

    }

    override fun onResume() {
        super.onResume()
        checkSelectAll()
    }

    @SuppressLint("SetTextI18n")
    private fun setData() {
        var winA = 0
        var winB = 0
        var draw = 0
        var scoreA = 0
        var scoreB = 0
        for (match in matches) {
            scoreA += match.scoreA
            scoreB += match.scoreB

            if (match.scoreA > match.scoreB) {
                winA += 1
            } else if (match.scoreA < match.scoreB) {
                winB += 1
            } else {
                draw += 1
            }
        }

        binding.tvWinA.text = winA.toString()
        binding.tvWinB.text = winB.toString()
        binding.tvDraw.text = draw.toString()
        binding.tvGoals.text = "$scoreA:$scoreB"
    }
}