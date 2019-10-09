package com.clarmoph.checkin.views.adjust.time

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clarmoph.checkin.R
import com.google.android.gms.location.Geofence
import com.google.android.gms.location.GeofencingClient
import com.google.android.gms.location.LocationServices

@Suppress("JoinDeclarationAndAssignment")
class AdjustCheckInTimeGeofence(inflater: LayoutInflater, parent: ViewGroup?) :
    AdjustCheckInTimeFragment.Listener {

    /**
     * Provides access to the Geofencing API
     */
    private var mGeofencingClient: GeofencingClient

    private val mGeofenceList: ArrayList<Geofence>

    private val mAdjustCheckInTimeFragment: AdjustCheckInTimeFragment
    private val mRootView: View

    init {
        mRootView = inflater.inflate(R.layout.fragment_adjust_check_in_time, parent, false)

        mGeofencingClient = LocationServices.getGeofencingClient(getContext())
        mGeofenceList = ArrayList()

        mAdjustCheckInTimeFragment = AdjustCheckInTimeFragment()
        mAdjustCheckInTimeFragment.registerListener(this)
    }

    /**
     * Complete this work when notified that user
     * has started tracking
     */
    override fun onStartTracking() {
        super.onStartTracking()

        /*
            TODO : Initialize Geofence clients
            TODO : Add Geofence to mGeofenceArrayList
            TODO : Define Broadcast receiver
         */
    }

    private fun getContext(): Context {
        return mRootView.context
    }

    fun getRootView(): View {
        return mRootView
    }
}