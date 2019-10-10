package com.clarmoph.checkin.views.adjust.time

import android.app.PendingIntent
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clarmoph.checkin.R
import com.clarmoph.checkin.utils.GeofenceUtil
import com.google.android.gms.location.Geofence
import com.google.android.gms.location.GeofencingClient
import com.google.android.gms.location.GeofencingRequest
import com.google.android.gms.location.LocationServices

@Suppress("JoinDeclarationAndAssignment")
class AdjustCheckInTimeGeofence(inflater: LayoutInflater, parent: ViewGroup?) :
    AdjustCheckInTimeFragment.Listener {

    /**
     * Provides access to the Geofencing API
     */
    private var mGeofencingClient: GeofencingClient

    /**
     * Store all registered geofences
     */
    private val mGeofenceList: ArrayList<Geofence>

    private val mAdjustCheckInTimeFragment: AdjustCheckInTimeFragment
    private val mRootView: View

    init {
        mRootView = inflater.inflate(R.layout.fragment_adjust_check_in_time, parent, false)

        mGeofencingClient = LocationServices.getGeofencingClient(getContext())
        mGeofenceList = ArrayList()

        populateGeofenceList(mGeofenceList)

        mAdjustCheckInTimeFragment = AdjustCheckInTimeFragment()
        mAdjustCheckInTimeFragment.registerListener(this)
    }

    /**
     * Begin this work when notified that user has started tracking
     */
    override fun onStartTracking() {
        super.onStartTracking()
        mGeofencingClient.addGeofences(getGeofencingRequest(), getGeofencePendingIntent())
    }

    /**
     * Geofence data will be hardcoded for prototype. Use dynamic data for production app.
     */
    private fun populateGeofenceList(geofenceList: ArrayList<Geofence>) {
        geofenceList.add(
            Geofence.Builder()
                .setRequestId(GeofenceUtil.GEOFENCE_ID)
                .setCircularRegion(
                    GeofenceUtil.GEOFENCE_LATITUDE,
                    GeofenceUtil.GEOFENCE_LONGITUDE,
                    GeofenceUtil.GEOFENCE_RADIUS_IN_METERS
                )
                .setExpirationDuration(GeofenceUtil.GEOFENCE_DURATION_IN_MILLISECONDS)
                .setTransitionTypes(Geofence.GEOFENCE_TRANSITION_ENTER or Geofence.GEOFENCE_TRANSITION_EXIT)
                .build()
        )
    }

    /**
     *  Builds and returns a GeofencingRequest. Specifies the list of geofences
     *  to be monitored. Also specifies how the geofence notifications are initially triggered.
     */
    private fun getGeofencingRequest(): GeofencingRequest {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun getGeofencePendingIntent(): PendingIntent {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private fun getContext(): Context {
        return mRootView.context
    }

    fun getRootView(): View {
        return mRootView
    }
}