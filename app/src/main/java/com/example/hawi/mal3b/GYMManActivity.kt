package com.example.hawi.mal3b

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.app_bar_main.*

/**
 * Created by Hawi on 21/09/17.
 */
class GYMManActivity: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gym_woman_activity)
        setSupportActionBar(toolbar)
    }
}