package com.clarmoph.attendenceappprototype.views

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.clarmoph.attendenceappprototype.R
import com.clarmoph.attendenceappprototype.viewmodels.CheckInTimeViewModel

class AdjustCheckInTimeFragment : Fragment() {

    companion object {
        fun newInstance() = AdjustCheckInTimeFragment()
    }

    private lateinit var viewModel: CheckInTimeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.adjust_check_in_time_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CheckInTimeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
