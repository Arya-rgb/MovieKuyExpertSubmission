package com.thorin.ngemovieeuy.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.thorin.ngemovieeuy.databinding.FragmentSettingBinding

class SettingFragment : Fragment() {

    private var _binding: FragmentSettingBinding? = null
    private val binding get() = _binding!!
    private lateinit var sharedPref: SettingSharedPref

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPref = activity?.let { SettingSharedPref(it) }!!
        if (sharedPref.loadNightModeState()) {
            binding.darkMode.isChecked = true
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        binding.darkMode.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                sharedPref.setNightModeState(true)
            } else {
                sharedPref.setNightModeState(false)
            }
            requireActivity().recreate()
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}