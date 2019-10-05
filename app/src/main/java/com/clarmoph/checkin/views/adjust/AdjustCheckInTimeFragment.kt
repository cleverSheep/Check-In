package com.clarmoph.checkin.views.adjust

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.clarmoph.checkin.R
import com.clarmoph.checkin.location.AdjustCheckInTimeManager
import kotlinx.android.synthetic.main.fragment_adjust_check_in_time.*


class AdjustCheckInTimeFragment : Fragment(), View.OnClickListener {
    companion object {
        fun newInstance() = AdjustCheckInTimeFragment()
        private val mListeners: ArrayList<Listener> = ArrayList(1)
    }

    private lateinit var mAdjustCheckInTimeManager: AdjustCheckInTimeManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mAdjustCheckInTimeManager = AdjustCheckInTimeManager(
            LayoutInflater.from(activity),
            activity!!.findViewById(R.id.root_view)
        )
        return mAdjustCheckInTimeManager.getRootView()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUpNavigation()
    }

    private fun setUpNavigation() {
        btn_cont_timer.setOnClickListener(this)
        btn_set_time.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            btn_set_time.id -> setTime()
            btn_cont_timer.id -> startLocationTracking()
        }
    }

    private fun setTime() {
        btn_set_time.visibility = View.INVISIBLE
        btn_cont_timer.visibility = View.VISIBLE

        val setTimeFragment =
            SetTimeDialog.newInstance()
        fragmentManager?.let { setTimeFragment.show(it, "setTime") }
    }

    private fun startLocationTracking() {
        for (listener in mListeners) {
            listener.onStartTracking()
        }

    }

    interface Listener {
        fun onStartTracking() {}
    }

    fun registerListener(listener: Listener) {
        mListeners.add(listener)
    }

    fun unregisterListener(listener: Listener) {
        mListeners.remove(listener)
    }

}
