package com.example.hawi.mal3b.academy

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import com.example.hawi.mal3b.R

class AcademyListViewActivity : AppCompatActivity() {

    lateinit var academyListAdapter:AcademyAdapterList
    lateinit var academyList:ListView
    lateinit var academyArrayList:ArrayList<AcademyData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.academy_list_view_activity)

        academyList = findViewById(R.id.listViewAcademy)

        academyArrayList = ArrayList<AcademyData>()

        academyArrayList.add(AcademyData(1,"Abdu","Makkah","Jeddah","Al Muntazhat",
                21.0909, 39.1232,4.0F,500,"w001",0,8,36))
        academyArrayList.add(AcademyData(2,"Mohd","Makkah","Jeddah","Al Muntazhat",
                21.0909, 39.1232,5.0F,700,"w002",0,8,18))
        academyArrayList.add(AcademyData(3,"Hassan","Jizan","Sabea","Al Muntazhat",
                21.0909, 39.1232,3.0F,300,"w003",0,7,15))

        academyListAdapter = AcademyAdapterList(this,R.layout.academy_item_list,academyArrayList)

        academyList.adapter = academyListAdapter

        academyList.onItemClickListener = academyItemOnClick()

        if(supportActionBar != null){
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun academyItemOnClick(): AdapterView.OnItemClickListener= AdapterView.OnItemClickListener() {
        adapterView: AdapterView<*>, view1: View, i: Int, l: Long ->

        var academyData:AcademyData = adapterView.getItemAtPosition(i) as AcademyData

        var intent = Intent(this,AcademySubActivity::class.java)

        intent.putExtra("id",academyData.idA)
        intent.putExtra("name",academyData.nameA)
        intent.putExtra("region",academyData.regionA)
        intent.putExtra("city",academyData.cityA)
        intent.putExtra("dist",academyData.nighboreA)
        intent.putExtra("latit",academyData.LatitA)
        intent.putExtra("long",academyData.longetA)
        intent.putExtra("rate",academyData.rateA)
        intent.putExtra("price",academyData.priceA)
        intent.putExtra("img",academyData.imgA)
        intent.putExtra("service",academyData.serviceA)
        intent.putExtra("ageFrom",academyData.ageFromA)
        intent.putExtra("ageTo",academyData.ageToA)

        startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item!!.getItemId()){
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
