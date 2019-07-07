package com.example.hawi.mal3b.staduimChoiseAndConfirmPay

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hawi.mal3b.R
import kotlinx.android.synthetic.main.staduim_appointment_time.view.*
import java.util.ArrayList

/**
 * Created by Hawi on 11/08/17.
 */


internal class StaduimFootballTimeAdapter(private val staduimFootballArrayList: ArrayList<StaduimFootballTimeItem>,
                                          private val context: Context,
                                          private val layout: Int) : RecyclerView.Adapter<StaduimFootballTimeAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindItems(staduimFootballArrayList[position])

        var btnSelect  = holder.img
        holder.img.setOnClickListener(View.OnClickListener {
//            if(btnSelect.isSelected == false){
//                btnSelect.setImageResource(R.drawable.football_red)
//
//            }else{
//                btnSelect.setImageResource(R.drawable.football_green)
//            }
            (R.drawable.football_green).takeIf {
                btnSelect.isSelected == true
            }
            (R.drawable.football_red).takeIf {
                btnSelect.isSelected == false
            }
        })
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun getItemCount(): Int {
        return staduimFootballArrayList.size
    }

    internal inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var img = itemView.footballpic

        fun bindItems(items: StaduimFootballTimeItem){
            img.setImageResource(items.img!!)
            itemView.txtTimePlay.text = items.timePlay!!
        }

    }
}