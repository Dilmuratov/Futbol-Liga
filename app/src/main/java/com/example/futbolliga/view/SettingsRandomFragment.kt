package com.example.futbolliga.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.futbolliga.R
import com.example.futbolliga.databinding.FragmentSettingsRandomBinding

class SettingsRandomFragment : Fragment(R.layout.fragment_settings_random) {
    private lateinit var binding: FragmentSettingsRandomBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSettingsRandomBinding.bind(view)

        var iv1 = true
        binding.ivCountry1.isSelected = false
        binding.ivCountry1.setOnClickListener {
            binding.ivCountry1.isSelected = iv1
            iv1 = iv1.not()
        }
    }
}