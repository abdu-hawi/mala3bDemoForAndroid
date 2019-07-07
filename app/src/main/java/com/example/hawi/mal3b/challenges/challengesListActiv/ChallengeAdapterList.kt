package com.example.hawi.mal3b.challenges.challengesListActiv

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.hawi.mal3b.R

/**
 * Created by Hawi on 03/10/17.
 */

class ChallengeAdapterList(context: Context, resource:Int, objects: ArrayList<ChallengeListData>)
    : ArrayAdapter<ChallengeListData>(context, resource, objects) {

    var contextA = context
    var resoursA = resource

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view = convertView
        view = LayoutInflater.from(contextA).inflate(resoursA,parent,false)

        val challengeData:ChallengeListData = getItem(position)
        val txtName:TextView = view.findViewById(R.id.txtChallengeName)
        val txtAge:TextView = view.findViewById(R.id.txtChallengeAge)
        val txtcity:TextView = view.findViewById(R.id.txtChallengeCity)

        txtName.text = challengeData.nameChall
        txtAge.text = challengeData.ageChall.toString()
        txtcity.text = challengeData.cityChall

        return view
    }
}