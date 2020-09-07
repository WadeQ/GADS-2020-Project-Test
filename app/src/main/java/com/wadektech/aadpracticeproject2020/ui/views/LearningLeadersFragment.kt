package com.wadektech.aadpracticeproject2020.ui.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.wadektech.aadpracticeproject2020.R
import com.wadektech.aadpracticeproject2020.databinding.FragmentLearningLeadersBinding
import com.wadektech.aadpracticeproject2020.ui.adapters.LearningLeadersAdapter
import com.wadektech.aadpracticeproject2020.ui.viewmodels.AppViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * A simple [Fragment] subclass.
 * Use the [LearningLeadersFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@ExperimentalCoroutinesApi
@AndroidEntryPoint
class LearningLeadersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentLearningLeadersBinding.inflate(inflater)

        val appViewModel : AppViewModel by viewModels()
        binding.lifecycleOwner = this
        binding.viewModel = appViewModel
        binding.rvLearners.adapter = LearningLeadersAdapter()
        return binding.root
    }
}