package com.example.hawi.mal3b.staduim

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import com.example.hawi.mal3b.R
import kotlin.collections.ArrayList

/**
 * Created by Hawi on 16/09/17.
 */

class StaduimListAdapter(context: Context, resource:Int, objects: ArrayList<StaduimAllData>)
    :ArrayAdapter<StaduimAllData> (context, resource, objects){

    var resourceA:Int = resource
    var contextA:Context = context

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        view = LayoutInflater.from(contextA).inflate(resourceA,parent,false)

        var tvNameList:TextView = view.findViewById(R.id.txtSListName)
        var tvDistanceList:TextView = view.findViewById(R.id.txtSListDistance)
        var tvPriceList:TextView = view.findViewById(R.id.txtSListprice)
        var tvSizeList:TextView = view.findViewById(R.id.txtSListSize)
        var tvRegionList:TextView = view.findViewById(R.id.txtSListReigon)
        var rateBarList:RatingBar = view.findViewById(R.id.ratingBarSList)
        var backgroundList:LinearLayout = view.findViewById(R.id.staduimBackgrounList)

        var currentStaduim:StaduimAllData = getItem(position)

        val resId = context.resources.getIdentifier(currentStaduim.backgroundS, "drawable", context.packageName)

        tvNameList.setText(currentStaduim.nameS)
        tvDistanceList.setText("65 km")
        tvPriceList.setText(""+ currentStaduim.priceS + " SR")
        tvSizeList.setText(currentStaduim.sizeStrinS)
        tvRegionList.setText(currentStaduim.regionS + " / " + currentStaduim.cityS)
        rateBarList.rating = currentStaduim.rateS
        backgroundList.setBackgroundResource(resId)

        return view
    }

}