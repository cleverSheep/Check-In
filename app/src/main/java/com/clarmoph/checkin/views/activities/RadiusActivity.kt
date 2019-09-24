package com.clarmoph.checkin.views.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.clarmoph.checkin.R
import com.warkiz.widget.IndicatorSeekBar
import com.warkiz.widget.OnSeekChangeListener
import com.warkiz.widget.SeekParams
import kotlinx.android.synthetic.main.activity_radius.*

class RadiusActivity : AppCompatActivity(), View.OnClickListener, OnSeekChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radius)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setBackgroundColor()
        setUpNavigation()
        updateCustomView()
    }

    private fun setBackgroundColor() {
        window.decorView.setBackgroundColor(resources.getColor(R.color.colorShadow))
    }

    private fun setUpNavigation() {
        btn_cont_radius.setOnClickListener(this)
    }

    private fun updateCustomView() {
        seekbar_custom.onSeekChangeListener = this
    }

    override fun onClick(view: View?) {
        // TODO: SEND AN INTENT EXTRA CONTAINING THE RADIUS AND DISPLAY RADIUS CONFIRMATION IN SNACKBAR
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onSeeking(seekParams: SeekParams?) {}

    override fun onStartTrackingTouch(seekBar: IndicatorSeekBar?) {}

    override fun onStopTrackingTouch(seekBar: IndicatorSeekBar?) {
        proxi_view.radiusSize = seekBar!!.progressFloat
        Log.d("RadiusActivity", seekBar.progressFloat.toString())
    }


}
