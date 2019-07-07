package com.example.hawi.mal3b.staduimChoiseAndConfirmPay

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.staduim_appointment_calendar.view.*
import java.util.ArrayList

/**
 * Created by Hawi on 12/09/17.
 */
internal class StaduimCalendarAdapter(private val arrayList: ArrayList<StaduimCalendarItem>,
                                      private val context: Context,
                                      private val layout: Int) : RecyclerView.Adapter<StaduimCalendarAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])

        var btnSelect = holder.button

        holder.button.setOnClickListener{
            //Toast.makeText(context,""+ position +"/"+btnSelect.text ,Toast.LENGTH_SHORT).show()
            if (btnSelect.isSelected == false){

                btnSelect.isSelected = true
                Toast.makeText(context,""+ position +"/"+btnSelect.text , Toast.LENGTH_SHORT).show()
            }else{
                btnSelect.isSelected = false
            }
        }
    }



    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    internal inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){


        var button = itemView.button


        fun bindItems(items: StaduimCalendarItem) {
            itemView.tvName.text = items.name
            itemView.tvNumber.text = items.nameDay
            button.setText(items.number)
        }

        var btnSelect = button
        var posSelect = ArrayList<Int>()

//        override fun onClick(p0: View?) {
////            Toast.makeText(context,""+ position +""+button.text ,Toast.LENGTH_LONG).show()
//            if (btnSelect.isSelected == false){
//                button.isSelected = true
//                posSelect.add(adapterPosition)
//                Toast.makeText(context,"as" + posSelect.size ,Toast.LENGTH_LONG).show()
//            }else{
//                button.isSelected = false
//            }
//
//        }
    }
}

