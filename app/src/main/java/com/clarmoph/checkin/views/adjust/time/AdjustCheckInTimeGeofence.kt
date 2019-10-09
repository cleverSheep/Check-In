package com.clarmoph.checkin.views.adjust.time

import android.util.Log

@Suppress("JoinDeclarationAndAssignment")
class AdjustCheckInTimeGeofence : AdjustCheckInTimeFragment.Listener {

    companion object {
        fun newInstance() = AdjustCheckInTimeGeofence()
        private val TAG = AdjustCheckInTimeGeofence::class.java.name
    }

    private val mAdjustCheckInTimeFragment: AdjustCheckInTimeFragment

    init {
        mAdjustCheckInTimeFragment = AdjustCheckInTimeFragment()
        mAdjustCheckInTimeFragment.registerListener(this)

    }

    /*
        Work to be completed when notified that user
        has started tracking
     */
    override fun onStartTracking() {
        super.onStartTracking()

        Log.d(TAG, "Now tracking...")
        /*
            TODO : Initialize Geofence clients
            TODO : Add Geofence to mGeofenceArrayList
            TODO : Define Broadcast receiver
         */
    }
}