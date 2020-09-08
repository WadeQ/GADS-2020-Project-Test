package com.wadektech.aadpracticeproject2020.ui.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.wadektech.aadpracticeproject2020.R
import com.wadektech.aadpracticeproject2020.ui.adapters.ViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val toolbar : androidx.appcompat.widget.Toolbar= findViewById(R.id.toolbar)
    setSupportActionBar(toolbar)

    val pagerAdapter = ViewPagerAdapter(supportFragmentManager)
    view_pager.adapter = pagerAdapter
    tab_layout.setupWithViewPager(view_pager)

    btn_submit.setOnClickListener {
      val fragment: Fragment = SubmitFragment()
      val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
      transaction.replace(R.id.submit_fragment_container, fragment)
      transaction.commit()
    }
  }
}