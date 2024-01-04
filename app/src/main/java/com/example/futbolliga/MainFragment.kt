package com.example.futbolliga

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.futbolliga.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {
    private lateinit var binding: FragmentMainBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        initListeners()
    }

    private fun initListeners() {
        binding.llCategoryRandom.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_randomFragment)
        }
    }
}