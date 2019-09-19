package com.clarmoph.attendenceappprototype.views.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.clarmoph.attendenceappprototype.R
import kotlinx.android.synthetic.main.activity_radius.*

class RadiusActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radius)
        setSupportActionBar(findViewById(R.id.toolbar))

        setBackgroundColor()
        setUpNavigation()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setBackgroundColor() {
        window.decorView.setBackgroundColor(resources.getColor(R.color.colorShadow))
    }

    private fun setUpNavigation() {
        btn_cont_radius.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
