package com.example.hawi.mal3b.challenges.challengesListActiv

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListView
import com.example.hawi.mal3b.R

class ChallengeListActivity : AppCompatActivity() {

    lateinit var challengeListAdapter:ChallengeAdapterList
    lateinit var challengeList: ListView
    lateinit var challengeArrayList:ArrayList<ChallengeListData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.challenge_list_activity)

        challengeList = findViewById(R.id.listChallenge)
        challengeArrayList = ArrayList<ChallengeListData>()
        challengeArrayList.add(ChallengeListData("Abdu Hussain",20,"Jeddah"))
        challengeArrayList.add(ChallengeListData("Abdu",30,"Jeddah"))
        challengeArrayList.add(ChallengeListData("Mohd Ali",25,"Jeddah"))

        challengeListAdapter = ChallengeAdapterList(this,R.layout.challenge_item_list,challengeArrayList)
        challengeList.adapter = challengeListAdapter

        challengeList.onItemClickListener = challengeItemOnClick()

        if(supportActionBar != null){
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }
    }// End onCreate

    private fun challengeItemOnClick(): OnItemClickListener? = AdapterView.OnItemClickListener {
            adapterView: AdapterView<*>, view1: View, i: Int, l: Long ->

        var challengeData:ChallengeListData = adapterView.getItemAtPosition(i) as ChallengeListData
        //TODO : Intent chating
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.getItemId()){
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

}// End class
