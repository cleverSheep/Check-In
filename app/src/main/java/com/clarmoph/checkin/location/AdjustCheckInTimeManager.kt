package com.clarmoph.checkin.location

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clarmoph.checkin.R
import com.clarmoph.checkin.views.adjust.AdjustCheckInTimeFragment
import com.google.android.material.snackbar.Snackbar

@Suppress("JoinDeclarationAndAssignment")
class AdjustCheckInTimeManager(inflater: LayoutInflater, parent: ViewGroup) :
    AdjustCheckInTimeFragment.Listener {

    private val mRootView: View
    private val mAdjustCheckInTimeFragment: AdjustCheckInTimeFragment

    init {
        mRootView = inflater.inflate(R.layout.fragment_adjust_check_in_time, parent, false)
        mAdjustCheckInTimeFragment = AdjustCheckInTimeFragment()
        mAdjustCheckInTimeFragment.registerListener(this)
    }

    override fun onStartTracking() {
        super.onStartTracking()

        val snackbar = Snackbar.make(
            getRootView(),
            "We'll start the timer when you enter your room.",
            Snackbar.LENGTH_INDEFINITE
        )
        snackbar.setAction("Ok") { snackbar.dismiss() }
        snackbar.setActionTextColor(getContext().resources.getColor(R.color.colorPrimary))
        snackbar.show()

        /*
            TODO : Initialize Geofence clients
            TODO : Add Geofence to mGeofenceArrayList
            TODO : Define Broadcast receiver
         */
    }


    fun getRootView(): View {
        return mRootView
    }

    private fun getContext(): Context {
        return mRootView.context
    }
}