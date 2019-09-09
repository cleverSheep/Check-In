package com.clarmoph.attendenceappprototype

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.clarmoph.attendenceappprototype.adapters.PagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mViewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpViewPager()
    }

    private fun setUpViewPager() {
        val mPagerAdapter = PagerAdapter(supportFragmentManager)
        mViewPager = findViewById(R.id.proto_viewpager)
        mViewPager.adapter = mPagerAdapter
        tab_indicator.setupWithViewPager(mViewPager)
    }

    override fun onBackPressed() {
        if (mViewPager.currentItem == 0) {
            super.onBackPressed()
        } else {
            mViewPager.currentItem = mViewPager.currentItem - 1
        }
    }
}
