package com.example.hawi.mal3b

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.app_bar_main.*

class ResetPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)
        setSupportActionBar(toolbar)

        if(supportActionBar != null){
            supportActionBar!!.setDisplayShowHomeEnabled(true)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item!!.getItemId() == android.R.id.home) {
            finish();
        }
        return super. onOptionsItemSelected(item)

    }

    fun reLoginEvent (view : View){
        val intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)
    }
}
