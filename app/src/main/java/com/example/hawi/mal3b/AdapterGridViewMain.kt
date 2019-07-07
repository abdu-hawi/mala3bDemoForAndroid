package com.example.hawi.mal3b

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import com.example.hawi.mal3b.academy.AcademyActivity
import com.example.hawi.mal3b.challenges.ChallengesActivity
import com.example.hawi.mal3b.staduim.StadiumActivity
import kotlinx.android.synthetic.main.single_item_gridview_main.view.*

/**
 * Created by Hawi on 13/08/17.
 */

class AdapterGridViewMain:BaseAdapter{

    var context:Context? = null
    var valueGridView = arrayOf<String>()
    var imgGrideViewMain = intArrayOf()
    var view:View? = null
    lateinit var layoutInflater:LayoutInflater

    constructor(context: Context?, valueGridView: Array<String>, imgGrideViewMain: IntArray) : super() {
        this.context = context
        this.valueGridView = valueGridView
        this.imgGrideViewMain = imgGrideViewMain
    }


    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        layoutInflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        if(p1 == null) {
            view = View(context)
            view = layoutInflater.inflate(R.layout.single_item_gridview_main, null)
            view!!.img_single_grid_view_main.setImageResource(imgGrideViewMain[p0])
            view!!.tv_single_grid_view_main.setText(valueGridView[p0])

            // pass diffrent activity
            view!!.setOnClickListener({

                Toast.makeText(context,""+p0,Toast.LENGTH_SHORT).show()

                var intent = Intent()
                when(p0){
                    0 -> intent = Intent(context, StadiumActivity::class.java)
                    1 -> intent = Intent(context, AcademyActivity::class.java)

                    ///////////////////////////////////////////////////////////
                    ///////                                             ///////
                    ///////            Gride View Change Activity       ///////
                    ///////                                             ///////
                    ///////////////////////////////////////////////////////////
//                    2-9 -> intent = Intent(context, AcademyActivity::class.java)
                    2 -> intent = Intent(context, AcademyActivity::class.java)
                    3 -> intent = Intent(context, ChallengesActivity::class.java)
                    5 -> intent = Intent(context, AcademyActivity::class.java)
                }
                context!!.startActivity(intent)
            })
        }
        return view!!
    }

    override fun getItem(p0: Int): Any {
        return p0
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return valueGridView.size
    }

}