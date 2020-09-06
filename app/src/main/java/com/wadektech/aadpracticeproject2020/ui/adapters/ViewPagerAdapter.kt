package com.wadektech.aadpracticeproject2020.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.wadektech.aadpracticeproject2020.ui.views.LearningLeadersFragment
import com.wadektech.aadpracticeproject2020.ui.views.SkillIQLeadersFragment

class ViewPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
       return when(position){
           0 ->  LearningLeadersFragment()
           1 -> SkillIQLeadersFragment()
           else -> LearningLeadersFragment()
       }
    }
}