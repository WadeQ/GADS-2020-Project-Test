package com.wadektech.aadpracticeproject2020.ui.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wadektech.aadpracticeproject2020.R

/**
 * A simple [Fragment] subclass.
 * Use the [SubmitFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SubmitFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_submit, container, false)
    }
}