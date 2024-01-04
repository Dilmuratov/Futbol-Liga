package com.example.futbolliga.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.futbolliga.data.local.Constants
import com.example.futbolliga.R
import com.example.futbolliga.data.models.MatchData
import com.example.futbolliga.data.models.TeamData
import com.example.futbolliga.databinding.FragmentRandomBinding
import com.example.futbolliga.presentation.MainViewModel
import com.example.futbolliga.utils.set
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class RandomFragment : Fragment(R.layout.fragment_random) {
    private lateinit var binding: FragmentRandomBinding
    private val mainViewModel: MainViewModel by viewModel()
    private lateinit var teamA: TeamData
    private lateinit var teamB: TeamData
    private var scoreA = 0
    private var scoreB = 0
    private lateinit var listOfResult: List<MatchData>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRandomBinding.bind(view)

        initListeners()

        setInitialData()

        initObservers()

        test1()
    }

    private fun test1() {

    }

    private fun initObservers() {
        try {
            mainViewModel.allMatchesLiveData.observe(requireActivity()) {
                listOfResult = it
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun setInitialData() {
        val real = Constants.teamsForRandom[1]
        val barca = Constants.teamsForRandom[3]
        teamA = real
        teamB = barca
        binding.ivCountryFirst.set(Constants.countriesLogo[1].second, requireActivity())
        binding.ivCountrySecond.set(Constants.countriesLogo[1].second, requireActivity())
        binding.ivFirst.set(real.teamLogo, requireActivity())
        binding.ivSecond.set(barca.teamLogo, requireActivity())
        binding.tvStatsFirst.text = processingStats(real.stats)
        binding.tvStatsSecond.text = processingStats(barca.stats)
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun initListeners() {

        binding.ivAddFirst.setOnClickListener {
            var scoreFirst = binding.etScoreFirst.text.toString()
            if (scoreFirst.isEmpty()) {
                scoreFirst = "1"
            } else {
                scoreFirst = "${scoreFirst.toInt() + 1}"
                if (scoreFirst.toInt() >= 20) {
                    scoreFirst = "20"
                }
            }
            binding.etScoreFirst.setText(scoreFirst)
            scoreA = scoreFirst.toInt()
        }

        binding.ivRemoveFirst.setOnClickListener {
            var scoreFirst = binding.etScoreFirst.text.toString()
            if (scoreFirst.isEmpty()) {
                scoreFirst = "0"
            } else {
                scoreFirst = "${scoreFirst.toInt() - 1}"
                if (scoreFirst.toInt() <= 0) {
                    scoreFirst = "0"
                }
            }
            binding.etScoreFirst.setText(scoreFirst)
            scoreA = scoreFirst.toInt()
        }

        binding.etScoreFirst.addTextChangedListener {
            if (it != null && it.toString().isNotEmpty() && it.toString().toInt() > 20) {
                binding.etScoreFirst.setText("20")
                scoreA = 20
            }
        }

        binding.ivAddSecond.setOnClickListener {
            var scoreSecond = binding.etScoreSecond.text.toString()
            if (scoreSecond.isEmpty()) {
                scoreSecond = "1"
            } else {
                scoreSecond = "${scoreSecond.toInt() + 1}"
                if (scoreSecond.toInt() >= 20) {
                    scoreSecond = "20"
                }
            }
            binding.etScoreSecond.setText(scoreSecond)
            scoreB = scoreSecond.toInt()
        }

        binding.ivRemoveSecond.setOnClickListener {
            var scoreSecond = binding.etScoreSecond.text.toString()
            if (scoreSecond.isEmpty()) {
                scoreSecond = "0"
            } else {
                scoreSecond = "${scoreSecond.toInt() - 1}"
                if (scoreSecond.toInt() <= 0) {
                    scoreSecond = "0"
                }
            }
            binding.etScoreSecond.setText(scoreSecond)
            scoreB = scoreSecond.toInt()
        }

        binding.etScoreSecond.addTextChangedListener {
            if (it != null && it.toString().isNotEmpty() && it.toString().toInt() > 20) {
                binding.etScoreSecond.setText("20")
                scoreB = 20
            }
        }

        binding.llRandom.setOnClickListener {
            val teamList = Constants.teamsForRandom.shuffled()

            val timer = object : CountDownTimer(2400, 100) {
                override fun onTick(millisUntilFinished: Long) {
                    val teamData1 = teamList.shuffled()[0]
                    binding.tvFirst.text = teamData1.teamName.apply {
                        binding.ivFirst.set(teamData1.teamLogo, requireActivity())
                        binding.tvStatsFirst.text = processingStats(teamData1.stats)
                        binding.ivCountryFirst.set(getUrl(teamData1.country), requireActivity())
                    }
                    val teamData2 = teamList.shuffled()[0]
                    binding.tvSecond.text = teamData2.teamName.apply {
                        binding.ivSecond.set(teamData2.teamLogo, requireActivity())
                        binding.tvStatsSecond.text = processingStats(teamData2.stats)
                        binding.ivCountrySecond.set(getUrl(teamData2.country), requireActivity())
                    }

                    teamA = teamData1
                    teamB = teamData2
                }

                override fun onFinish() {

                }
            }

            timer.start()
        }

        binding.btnSave.setOnClickListener {
            MainScope().launch {
                mainViewModel.addMatch(
                    MatchData(
                        0,
                        teamA.teamName,
                        teamB.teamName,
                        scoreA,
                        scoreB
                    )
                )
            }
        }

        binding.llResults.setOnClickListener {
            MainScope().launch {
                mainViewModel.getAllMatches()
            }

            if (::listOfResult.isInitialized) {
                Log.d("TAG", "initListeners: ${listOfResult.joinToString { it.scoreA.toString() }}")
            }
        }
    }

    private fun getUrl(country: String): String {
        val countries = Constants.countriesLogo
        when (country) {
            countries[0].first -> {
                return countries[0].second
            }

            countries[1].first -> {
                return countries[1].second
            }

            countries[2].first -> {
                return countries[2].second
            }

            countries[3].first -> {
                return countries[3].second
            }

            countries[4].first -> {
                return countries[4].second
            }

            countries[5].first -> {
                return countries[5].second
            }
        }
        return countries[1].second
    }

    private fun processingStats(stats: String): String {
        return if (stats.length == 8) {
            val ova = "${stats[0]}${stats[1]}"
            val att = "${stats[2]}${stats[3]}"
            val mid = "${stats[4]}${stats[4]}"
            val def = "${stats[6]}${stats[7]}"
            "Ovr: $ova\t\t\tAtt: $att\nMid: $mid\t\t\tDef: $def"
        } else {
            "Ovr: 77\t\t\tAtt: 77\nMid: 77\t\t\tDef: 77"
        }
    }
}