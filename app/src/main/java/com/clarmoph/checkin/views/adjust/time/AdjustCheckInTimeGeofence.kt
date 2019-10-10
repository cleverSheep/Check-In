package com.clarmoph.checkin.views.adjust.time

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clarmoph.checkin.GeofenceBroadcastReceiver
import com.clarmoph.checkin.R
import com.clarmoph.checkin.utils.GeofenceUtil
import com.google.android.gms.location.Geofence
import com.google.android.gms.location.GeofencingClient
import com.google.android.gms.location.GeofencingRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task

@Suppress("JoinDeclarationAndAssignment")
class AdjustCheckInTimeGeofence(inflater: LayoutInflater, parent: ViewGroup?) :
    AdjustCheckInTimeFragment.Listener, OnCompleteListener<Void> {

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
        mGeofencingClient.addGeofences(getGeofencingRequest(), geofencePendingIntent)
            .addOnCompleteListener(this)
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
        return GeofencingRequest.Builder().apply {
            setInitialTrigger(GeofencingRequest.INITIAL_TRIGGER_EXIT)
            addGeofences(mGeofenceList)
        }.build()
    }

    private val geofencePendingIntent: PendingIntent by lazy {
        val intent = Intent(getContext(), GeofenceBroadcastReceiver::class.java)
        // We use FLAG_UPDATE _CURRENT so that we get the same pending intent back when calling
        // addGeofences() and removeGeofences().
        PendingIntent.getBroadcast(getContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
    }

    /**
     * Notify the user that the result of calling addGeofences()
     * was a success or a failure
     */
    override fun onComplete(task: Task<Void>) {
        if (task.isSuccessful) {
            Log.d(javaClass.simpleName, "Geofence Added")
        } else {
            Log.w(javaClass.simpleName, "Geofence Not Added")
        }
    }

    private fun getContext(): Context {
        return mRootView.context
    }

    fun getRootView(): View {
        return mRootView
    }
}