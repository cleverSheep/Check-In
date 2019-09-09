package com.clarmoph.attendenceappprototype.views

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.clarmoph.attendenceappprototype.R
import com.clarmoph.attendenceappprototype.viewmodels.CheckInTimeViewModel
import kotlinx.android.synthetic.main.adjust_check_in_time_fragment.*

class AdjustCheckInTimeFragment : Fragment() {

    companion object {
        fun newInstance() = AdjustCheckInTimeFragment()
    }

    private lateinit var viewModel: CheckInTimeViewModel
    private var TAG = AdjustCheckInTimeFragment::class.java.name

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.adjust_check_in_time_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CheckInTimeViewModel::class.java)
        btn_checkin_date.setOnClickListener { showDateFragment() }
        // TODO: Use the ViewModel
    }

    private fun showDateFragment() {
        Log.d(TAG, "Set date button clicked")
    }

}
