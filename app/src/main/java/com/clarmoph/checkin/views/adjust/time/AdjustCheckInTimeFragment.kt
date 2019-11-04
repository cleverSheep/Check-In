package com.clarmoph.checkin.views.adjust.time

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.clarmoph.checkin.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_adjust_check_in_time.*


class AdjustCheckInTimeFragment : Fragment(), View.OnClickListener {

    companion object {
        fun newInstance() = AdjustCheckInTimeFragment()
        private val mListeners: ArrayList<Listener> = ArrayList(1)
    }

    private lateinit var mAdjustCheckInTimeGeofence: AdjustCheckInTimeGeofence

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mAdjustCheckInTimeGeofence = AdjustCheckInTimeGeofence(inflater, container)
        return mAdjustCheckInTimeGeofence.getRootView()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupButtonClickListener()
    }

    private fun setupButtonClickListener() {
        btn_cont_timer.setOnClickListener(this)
        btn_set_time.setOnClickListener(this)
        btn_stop_tracking.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            btn_set_time.id -> setDurationInGeofence()
            btn_cont_timer.id -> startLocationTracking()
            btn_stop_tracking.id -> stopLocationTracking()
        }
    }

    private fun setDurationInGeofence() {
        btn_set_time.visibility = View.INVISIBLE
        btn_cont_timer.visibility = View.VISIBLE

        val setTimeFragment =
            SetTimeDialog.newInstance()
        fragmentManager?.let { setTimeFragment.show(it, "setDurationInGeofence") }
    }

    /**
     * Notify observers to add geofences and start location tracking
     */
    private fun startLocationTracking() {

        btn_cont_timer.visibility = View.INVISIBLE
        btn_stop_tracking.visibility = View.VISIBLE

        for (listener in mListeners) {
            listener.onAddGeofences()
        }

        val snackbar = Snackbar.make(
            activity!!.findViewById(R.id.root_view),
            "We'll start the timer when you enter your room.",
            Snackbar.LENGTH_INDEFINITE
        )
        snackbar.setAction("Ok") { snackbar.dismiss() }
        snackbar.setActionTextColor(context!!.resources.getColor(R.color.colorPrimary))
        snackbar.show()

    }

    /**
     * Notify observers to remove geofences and stop location tracking
     */
    private fun stopLocationTracking() {

        btn_cont_timer.visibility = View.VISIBLE
        btn_stop_tracking.visibility = View.INVISIBLE

        for (listener in mListeners) {
            listener.onRemoveGeofences()
        }
        val snackbar = Snackbar.make(
            activity!!.findViewById(R.id.root_view),
            "Got it. Location tracking is removed.",
            Snackbar.LENGTH_INDEFINITE
        )
        snackbar.setAction("Ok") { snackbar.dismiss() }
        snackbar.setActionTextColor(context!!.resources.getColor(R.color.colorPrimary))
        snackbar.show()

    }

    interface Listener {
        fun onAddGeofences() {}
        fun onRemoveGeofences() {}
    }

    fun registerListener(listener: Listener) {
        mListeners.add(listener)
    }

    // TODO: UNREGISTER THE LISTENERS

}
