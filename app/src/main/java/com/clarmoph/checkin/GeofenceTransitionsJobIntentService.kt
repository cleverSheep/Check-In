package com.clarmoph.checkin

import android.content.Context
import android.content.Intent
import androidx.core.app.JobIntentService

class GeofenceTransitionsJobIntentService : JobIntentService() {

    companion object {
        private const val JOB_ID = 274

        fun enqueueWork(context: Context, intent: Intent) {
            enqueueWork(context, GeofenceTransitionsJobIntentService::class.java, JOB_ID, intent)
        }
    }

    override fun onHandleWork(intent: Intent) {}

}