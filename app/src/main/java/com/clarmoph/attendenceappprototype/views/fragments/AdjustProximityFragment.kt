package com.clarmoph.attendenceappprototype.views.fragments

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.clarmoph.attendenceappprototype.R
import com.clarmoph.attendenceappprototype.viewmodels.CourseProximityViewModel
import com.clarmoph.attendenceappprototype.views.activities.RadiusActivity
import kotlinx.android.synthetic.main.adjust_proximity_fragment.*

class AdjustProximityFragment : Fragment(), View.OnClickListener {
    companion object {
        fun newInstance() =
            AdjustProximityFragment()
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
        setUpNavigation()
    }

    private fun setUpNavigation() {
        btn_set_radius.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent = Intent(context, RadiusActivity::class.java)
        startActivity(intent)
    }
}
