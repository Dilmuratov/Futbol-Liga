package com.example.futbolliga.view.championship

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.futbolliga.R
import com.example.futbolliga.databinding.FragmentChampionshipBinding
import com.example.futbolliga.presentation.MainViewModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChampionshipFragment : Fragment(R.layout.fragment_championship) {
    private lateinit var binding: FragmentChampionshipBinding
    private val mainViewModel: MainViewModel by viewModel()
    private lateinit var playOffAdapter: PlayOffAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentChampionshipBinding.bind(view)
        playOffAdapter = PlayOffAdapter(POMatchAdapter())
        binding.rvPlayOff.adapter = playOffAdapter

        initObservers()

    }

    private fun initObservers() {
        mainViewModel.allPOMatchesLiveData.observe(requireActivity()) {
//            val list = mutableListOf<List<PlayOffMatchData>>()
//            list.add(it)
            playOffAdapter.submitList(listOf(it))
        }

        MainScope().launch {
            mainViewModel.getAllPOMatches()
        }
    }
}