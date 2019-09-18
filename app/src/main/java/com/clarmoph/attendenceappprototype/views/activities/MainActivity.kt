package com.clarmoph.attendenceappprototype.views.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.clarmoph.attendenceappprototype.R
import com.clarmoph.attendenceappprototype.adapters.PagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewPager: ViewPager
    private lateinit var mPagerAdapter: PagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpViewPager()
        setUpNavButtons()
        setUpNavigation()


    }

    override fun onBackPressed() {
        if (mViewPager.currentItem == 0) {
            super.onBackPressed()
        } else {
            mViewPager.currentItem = mViewPager.currentItem - 1
        }
    }

    private fun setUpViewPager() {
        mPagerAdapter = PagerAdapter(supportFragmentManager)
        mViewPager = findViewById(R.id.proto_viewpager)
        mViewPager.adapter = mPagerAdapter
        tab_indicator.setupWithViewPager(mViewPager)
    }

    private fun setUpNavigation() {
        btn_next.setOnClickListener(this)
        btn_back.setOnClickListener(this)
    }

    private fun setUpNavButtons() {
        if (mViewPager.currentItem == 0) {
            hideBackButton()
            showNextButton()
        } else {
            hideNextButton()
            showBackButton()
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            btn_next.id -> swipeNext()
            btn_back.id -> swipeBack()
        }
    }

    private fun swipeBack() {
        mViewPager.currentItem = mViewPager.currentItem - 1
        hideBackButton()
        showNextButton()
    }

    private fun swipeNext() {
        mViewPager.currentItem = mViewPager.currentItem + 1
        hideNextButton()
        showBackButton()
    }

    private fun hideNextButton() {
        btn_next.visibility = View.INVISIBLE
    }

    private fun showNextButton() {
        btn_next.visibility = View.VISIBLE
    }

    private fun hideBackButton() {
        btn_back.visibility = View.INVISIBLE
    }

    private fun showBackButton() {
        btn_back.visibility = View.VISIBLE
    }
}
