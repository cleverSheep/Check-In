package com.clarmoph.checkin.views

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.clarmoph.checkin.R
import com.clarmoph.checkin.adapters.PagerAdapter
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.coursesetup_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener, ViewPager.OnPageChangeListener {

    private lateinit var mViewPager: ViewPager
    private lateinit var mPagerAdapter: PagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.coursesetup_main)

        setUpViewPager()
        setUpNavButtonVisibility()
        setupButtonClickListener()
        confirmSetProximity()
    }

    private fun confirmSetProximity() {
        val intent = intent
        val extras = intent.extras ?: return

        if (extras.getBoolean("RADIUS_SET")) {
            Snackbar.make(
                findViewById(R.id.root_view),
                "Course location entrance proximity now set.",
                Snackbar.LENGTH_SHORT
            ).show()
        }
    }

    private fun setUpViewPager() {
        mPagerAdapter = PagerAdapter(supportFragmentManager)
        mViewPager = findViewById(R.id.proto_viewpager)
        mViewPager.adapter = mPagerAdapter
        mViewPager.addOnPageChangeListener(this)
        tab_indicator.setupWithViewPager(mViewPager)
    }

    private fun setupButtonClickListener() {
        btn_next.setOnClickListener(this)
        btn_back.setOnClickListener(this)
    }

    private fun setUpNavButtonVisibility() {
        if (mViewPager.currentItem == 0) {
            hideBackButton()
            showNextButton()
        } else {
            hideNextButton()
            showBackButton()
        }
    }

    override fun onBackPressed() {
        if (mViewPager.currentItem == 0) {
            super.onBackPressed()
        } else {
            mViewPager.currentItem = mViewPager.currentItem - 1
        }
    }


    override fun onClick(view: View?) {
        when (view?.id) {
            btn_next.id -> swipeNextPage()
            btn_back.id -> swipeBackPage()
        }
    }

    override fun onPageSelected(position: Int) {
        if (position == 0) {
            hideBackButton()
            showNextButton()
        } else {
            hideNextButton()
            showBackButton()
        }
    }

    private fun swipeBackPage() {
        mViewPager.currentItem = mViewPager.currentItem - 1
        hideBackButton()
        showNextButton()
    }

    private fun swipeNextPage() {
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

    override fun onPageScrollStateChanged(state: Int) {
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }
}
