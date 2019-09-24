package com.clarmoph.checkin.views.fragments

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
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_adjust_check_in_time, container, false)
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

        val setTimeFragment = SetTimeDialog.newInstance()
        fragmentManager?.let { setTimeFragment.show(it, "setTime") }
    }

    private fun startLocationTracking() {
        val snackbar = Snackbar.make(
            this.view!!,
            "We'll start tracking when you enter your room.",
            Snackbar.LENGTH_INDEFINITE
        )
        snackbar.setAction("Ok") { snackbar.dismiss() }
        snackbar.setActionTextColor(resources.getColor(R.color.colorPrimary))
        snackbar.show()

    }

}
