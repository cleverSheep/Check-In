package com.clarmoph.checkin.utils

import android.Manifest


class GeofenceUtil {

    companion object {

        const val GEOFENCE_ID: String = "Austin"

        val GEOFENCE_PERMISSIONS = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)

        const val LOCATION_REQUEST_CODE = 1

        /**
         * Used to define the radius of the geofence. Temporarily hardcoded for ease
         * of testing.
         */
        const val GEOFENCE_RADIUS_IN_METERS: Float = 1609F
        /**
         * Used to define the latitude and longitude of the geofence. Temporarily hardcoded for ease
         * of testing.
         */
        const val GEOFENCE_LATITUDE: Double = 35.605878
        const val GEOFENCE_LONGITUDE: Double = -77.362965

        /**
         * Used to define the duration of the geofence in seconds. Temporarily hardcoded for ease
         * of testing.
         */
        private const val GEOFENCE_DURATION_IN_SECONDS: Long = 10

        /**
         * Used to define the duration of the geofence in milliseconds. Temporarily hardcoded for ease
         * of testing.
         */
        const val GEOFENCE_DURATION_IN_MILLISECONDS: Long = 1000 * GEOFENCE_DURATION_IN_SECONDS

    }
}
