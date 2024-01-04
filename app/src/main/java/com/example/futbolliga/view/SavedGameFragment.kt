package com.example.futbolliga.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.futbolliga.R
import com.example.futbolliga.data.models.MatchData
import com.example.futbolliga.databinding.FragmentSavedGamesBinding
import com.example.futbolliga.presentation.MainViewModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class SavedGameFragment : Fragment(R.layout.fragment_saved_games) {
    private lateinit var binding: FragmentSavedGamesBinding
    private lateinit var matches: List<MatchData>
    private lateinit var adapter: SavedGameAdapter
    private val mainViewModel: MainViewModel by viewModel()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSavedGamesBinding.bind(view)
        adapter = SavedGameAdapter(requireActivity())
        binding.recyclerViewSavedGames.adapter = adapter

        initListeners()

        initObservers()
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
    }

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