package com.clarmoph.attendenceappprototype.views

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.clarmoph.attendenceappprototype.R
import com.clarmoph.attendenceappprototype.viewmodels.CourseProximityViewModel

class AdjustProximityFragment : Fragment() {

    companion object {
        fun newInstance() = AdjustProximityFragment()
    }

    private lateinit var viewModel: CourseProximityViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.adjust_proximity_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CourseProximityViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
