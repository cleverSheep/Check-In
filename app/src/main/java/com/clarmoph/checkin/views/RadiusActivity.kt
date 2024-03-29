package com.clarmoph.checkin.views

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.clarmoph.checkin.R
import com.warkiz.widget.IndicatorSeekBar
import com.warkiz.widget.OnSeekChangeListener
import com.warkiz.widget.SeekParams
import kotlinx.android.synthetic.main.fragment_setradius.*

class RadiusActivity : AppCompatActivity(), View.OnClickListener, OnSeekChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_setradius)
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
        val extras = Bundle()
        extras.putBoolean("RADIUS_SET", true)

        val intent = Intent(this, MainActivity::class.java)
        intent.putExtras(extras)

        startActivity(intent)
    }

    override fun onSeeking(seekParams: SeekParams?) {}

    override fun onStartTrackingTouch(seekBar: IndicatorSeekBar?) {}

    override fun onStopTrackingTouch(seekBar: IndicatorSeekBar?) {
        proxi_view.radiusSize = seekBar!!.progressFloat
        Log.d("RadiusActivity", seekBar.progressFloat.toString())
    }


}
