package com.clarmoph.checkin.views.adjust.proximity

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.clarmoph.checkin.R
import com.clarmoph.checkin.RadiusActivity
import kotlinx.android.synthetic.main.fragment_adjust_proximity.*

class AdjustProximityFragment : Fragment(), View.OnClickListener {

    companion object {
        fun newInstance() =
            AdjustProximityFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_adjust_proximity, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupButtonClickListener()
    }

    private fun setupButtonClickListener() {
        btn_set_radius.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent = Intent(context, RadiusActivity::class.java)
        startActivity(intent)
    }
}
