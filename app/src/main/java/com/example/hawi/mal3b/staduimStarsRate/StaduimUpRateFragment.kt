package com.example.hawi.mal3b.staduimStarsRate

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import com.example.hawi.mal3b.R
import com.example.hawi.mal3b.staduim.StaduimAllData
import com.example.hawi.mal3b.staduim.StaduimDB
import com.example.hawi.mal3b.staduim.StaduimListAdapter
import com.example.hawi.mal3b.staduimChoiseAndConfirmPay.StaduimChoiseActivity

/**
 * Created by Hawi on 27/08/17.
 */
class StaduimUpRateFragment : Fragment() {
    private final val TAG:String = "Staduim Stars Fragment"

    lateinit var staduimList:ListView
    lateinit var db:StaduimDB
    lateinit var staduimAdapter:StaduimListAdapter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater!!.inflate(R.layout.staduim_stars_fragment,container,false)
        Log.d(TAG, ": is Started")

        staduimList = view.findViewById(R.id.staduim_stars_fragment_list)

        db = StaduimDB(context)

        var staduim = db.sortByUpRate()

        staduimAdapter = StaduimListAdapter(context,R.layout.staduim_item_list,staduim)
        staduimList.adapter = staduimAdapter

        staduimList.setOnItemClickListener(staduimListOnClick())

        return view
    }



    private fun staduimListOnClick() : AdapterView.OnItemClickListener= AdapterView.OnItemClickListener() {
        adapterView: AdapterView<*>, view1: View, i: Int, l: Long ->

        var select_staduim:StaduimAllData = adapterView.getItemAtPosition(i) as StaduimAllData

        var intent = Intent(activity , StaduimChoiseActivity::class.java)
        intent.putExtra("id",select_staduim.idS)

        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()

        var stad = db.sortByUpRate()
        staduimAdapter = StaduimListAdapter(context,R.layout.staduim_item_list,stad)
        staduimList.adapter = staduimAdapter
    }
}