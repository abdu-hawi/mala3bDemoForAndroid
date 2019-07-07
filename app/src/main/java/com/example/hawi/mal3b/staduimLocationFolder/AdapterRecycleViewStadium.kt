package com.example.hawi.mal3b.staduimLocationFolder

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.util.ArrayList

/**
 * Created by Hawi on 14/08/17.
 */

class AdapterRecycleViewStadium(private val arrayList: ArrayList<DataItemRecycleStadium>,
                                private val context: Context,
                                private val layout: Int) : RecyclerView.Adapter<AdapterRecycleViewStadium.ViewHolder>(){
    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.bindItems(arrayList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent!!.context).inflate(layout, parent, false)
        return ViewHolder(v)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(items: DataItemRecycleStadium) {

            //itemView.tvRecycleName.text = items.name
            //itemView.imgRecycleView.setImageResource(items.imgItem!!)

        }
    }

}