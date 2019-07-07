package com.example.hawi.mal3b.academy

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.hawi.mal3b.R


class AcademyActivity : AppCompatActivity(){

    fun Spinner.setOnItemSelectedListener(listener: AdapterView.OnItemSelectedListener) {
        onItemSelectedListener = listener
    }

    lateinit var spinnerRegion: Spinner
    lateinit var spinnerCity: Spinner
    lateinit var arraySpinnerRegion : ArrayAdapter<CharSequence>
    lateinit var arraySpinnerCity : ArrayAdapter<CharSequence>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_academy)

        spinnerRegion = findViewById(R.id.spinnerRegion)
        spinnerCity = findViewById(R.id.spinnerCity)
        spinnerRegionLoad()
    }

    private fun spinnerRegionLoad() {

        arraySpinnerRegion = ArrayAdapter.createFromResource(this, R.array.spinner_region_item,
                android.R.layout.simple_spinner_item)

        arraySpinnerRegion.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerRegion.adapter = arraySpinnerRegion

        spinnerRegion.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                spinnerCityLoad(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
    }

    private fun spinnerCityLoad(id:Int) {

        arraySpinnerCity = ArrayAdapter.createFromResource(this, R.array.spinner_region_item,
                android.R.layout.simple_spinner_item)

        when(id){
            0-> spinnerCity.isActivated = false
            1-> arraySpinnerCity = ArrayAdapter.createFromResource(this, R.array.spinner_makkah_item,
                    android.R.layout.simple_spinner_item)
            2-> arraySpinnerCity = ArrayAdapter.createFromResource(this, R.array.spinner_riyadh_item,
                    android.R.layout.simple_spinner_item)
            3-> arraySpinnerCity = ArrayAdapter.createFromResource(this, R.array.spinner_EasternProvince_item,
                    android.R.layout.simple_spinner_item)
        }

        arraySpinnerCity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCity.adapter = arraySpinnerCity
    }

    fun btnSeachAcademy(view:View){
        var intent = Intent(this,AcademyListViewActivity::class.java)
        startActivity(intent)
    }
}
