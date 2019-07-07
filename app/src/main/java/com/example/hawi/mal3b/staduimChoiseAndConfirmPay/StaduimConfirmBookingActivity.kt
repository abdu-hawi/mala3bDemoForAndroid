package com.example.hawi.mal3b.staduimChoiseAndConfirmPay

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.hawi.mal3b.R

class StaduimConfirmBookingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.staduim_confirm_booking_activity)

        if(supportActionBar != null){
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        //return super.onOptionsItemSelected(item)

        if (item!!.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item)
    }
}
