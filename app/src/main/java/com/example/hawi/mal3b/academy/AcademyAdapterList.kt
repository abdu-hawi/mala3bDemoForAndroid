package com.example.hawi.mal3b.academy

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import com.example.hawi.mal3b.R

/**
 * Created by Hawi on 20/09/17.
 */

class AcademyAdapterList(context: Context, resource:Int, objects: ArrayList<AcademyData>)
    : ArrayAdapter<AcademyData>(context, resource, objects){

    var contextA = context
    var resoursA = resource

    @SuppressLint("ViewHolder", "SetTextI18n")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        view = LayoutInflater.from(contextA).inflate(resoursA,parent,false)

//        var resID:Int = contextA.resources.getIdentifier(imgS,"drawable",this.packageName)

        val academyData:AcademyData = getItem(position)
        val txtName:TextView = view.findViewById(R.id.txtAcadListName)
        val txtPrice:TextView = view.findViewById(R.id.txtAcadListprice)
        val txtRegion:TextView = view.findViewById(R.id.txtAcadRegion)
        val rate:RatingBar = view.findViewById(R.id.ratingBarAcadList)
        val linearBack:LinearLayout = view.findViewById(R.id.academyBackgrounList)

        txtName.setText(academyData.nameA)
        txtPrice.setText(academyData.priceA.toString())
        txtRegion.text = academyData.cityA+ " / " + academyData.nighboreA
        rate.rating = academyData.rateA!!

        val resID:Int = contextA.resources.getIdentifier(academyData.imgA,"drawable",contextA.packageName)
        linearBack.setBackgroundResource(resID)

        return view
    }
}