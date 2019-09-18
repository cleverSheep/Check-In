package com.clarmoph.attendenceappprototype.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.clarmoph.attendenceappprototype.R

class RadiusActivity : AppCompatActivity() {
    companion object {
        fun newInstance() =
            RadiusActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radius)
        setSupportActionBar(findViewById(R.id.toolbar))

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
