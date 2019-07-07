package com.example.hawi.mal3b.challenges

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.example.hawi.mal3b.R

class ChallengesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.challenges_activity)
    }

    fun btnMakeChallenge(v:View){
        startActivity(Intent(this,ChallengeDeclarationActivity::class.java))
    }

    fun btnLookForChallenge(v: View){
        //TODO
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item!!.getItemId()){
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

}
