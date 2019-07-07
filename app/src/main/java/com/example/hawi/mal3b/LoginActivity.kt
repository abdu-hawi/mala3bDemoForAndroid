package com.example.hawi.mal3b

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }


    fun registerEvent(v: View){
        val intent = Intent(this,RegisterActivity::class.java)
        startActivity(intent)
    }

    fun resetPasswordEvent (v: View){
        val intent = Intent(this, ResetPasswordActivity::class.java)
        startActivity(intent)
    }

    fun loginEvent (v:View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
