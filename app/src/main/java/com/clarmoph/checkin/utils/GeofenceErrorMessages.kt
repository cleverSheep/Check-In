package com.clarmoph.checkin.utils

import android.content.Context
import com.clarmoph.checkin.R
import com.google.android.gms.location.GeofenceStatusCodes

class GeofenceErrorMessages private constructor() {

    companion object {

        /**
         * Returns the error string for a geofencing error code
         */
        fun getErrorString(context: Context, errorCode: Int): String {
            val mResources = context.resources

            return when (errorCode) {
                GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE -> mResources.getString(R.string.geofence_not_available)
                GeofenceStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES -> mResources.getString(R.string.geofence_too_many_geofences)
                GeofenceStatusCodes.GEOFENCE_TOO_MANY_PENDING_INTENTS -> mResources.getString(R.string.geofence_too_many_pending_intents)
                else -> mResources.getString(R.string.unknown_geofence_error)
            }
        }

    }

}