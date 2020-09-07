package com.wadektech.aadpracticeproject2020.ui.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wadektech.aadpracticeproject2020.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * A simple [Fragment] subclass.
 * Use the [SkillIQLeadersFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@ExperimentalCoroutinesApi
@AndroidEntryPoint
class SkillIQLeadersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_skill_i_q_leaders, container, false)
    }

}