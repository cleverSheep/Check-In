package com.clarmoph.checkin.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.clarmoph.checkin.views.adjust.AdjustCheckInTimeFragment
import com.clarmoph.checkin.views.adjust.AdjustProximityFragment

class PagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    companion object PagerAdapter {
        const val NUM_IITEMS = 2
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> AdjustProximityFragment.newInstance()
            1 -> AdjustCheckInTimeFragment.newInstance()
            else -> null
        }!!
    }

    override fun getCount(): Int {
        return NUM_IITEMS
    }
}