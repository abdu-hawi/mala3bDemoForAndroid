package com.example.hawi.mal3b.academy

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import com.example.hawi.mal3b.R

class AcademySubActivity : AppCompatActivity() {

    lateinit var headerAcad:LinearLayout
    lateinit var txtAcadName:TextView
    lateinit var txtAcadCity:TextView
    lateinit var txtAcadDist:TextView
    lateinit var ratingBarAcad:RatingBar
    lateinit var txtAcadPrice:TextView
    lateinit var txtAcadService:TextView
    lateinit var txtAcadAgeFrom:TextView
    lateinit var txtAcadAgeTo:TextView

    lateinit var academyData:AcademyData

    var idS:Int? = null
    lateinit var nameS:String
    lateinit var regionS:String
    lateinit var cityS:String
    lateinit var distS:String
    var latitS:Double? = null
    var longetS:Double? = null
    var rateS:Float? = null
    var price:Int? = null
    lateinit var imgS:String
    var serviceS:Int? = null
    var ageFromS:Int? = null
    var ageToS:Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.academy_sub_activity)

        idS = intent.getIntExtra("id",0)
        nameS = intent.getStringExtra("name")
        regionS = intent.getStringExtra("region")
        cityS = intent.getStringExtra("city")
        distS = intent.getStringExtra("dist")
        latitS = intent.getDoubleExtra("latit",21.009)
        longetS = intent.getDoubleExtra("long",39.003)
        rateS = intent.getFloatExtra("rate",3.5F)
        price = intent.getIntExtra("price",0)
        imgS = intent.getStringExtra("img")
        serviceS = intent.getIntExtra("service",0)
        ageFromS = intent.getIntExtra("ageFrom",0)
        ageToS = intent.getIntExtra("ageTo",0)


        if(supportActionBar != null){
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }

        initilaizeLayout()

    }

    @SuppressLint("SetTextI18n")
    fun initilaizeLayout(){
        headerAcad = findViewById(R.id.headerAcademySub)
        txtAcadName = findViewById(R.id.txtAcadNameLayout)
        txtAcadCity = findViewById(R.id.txtAcadCityLayout)
        txtAcadDist = findViewById(R.id.txtAcadDistLayout)
        ratingBarAcad = findViewById(R.id.ratingBarAcadSub)
        txtAcadPrice = findViewById(R.id.txtAcadPriceLayout)
        txtAcadService = findViewById(R.id.txtAcadServiceLayout)
        txtAcadAgeFrom = findViewById(R.id.txtAcadAgeFromLayout)
        txtAcadAgeTo = findViewById(R.id.txtAcadAgeToLayout)

        var resID:Int = this.resources.getIdentifier(imgS,"drawable",this.packageName)
        headerAcad.setBackgroundResource(resID)
        txtAcadName.text = nameS
        txtAcadCity.text = regionS + " / " + cityS
        txtAcadDist.text = distS
        ratingBarAcad.rating = rateS!!
        txtAcadPrice.text = "" + price +" SR"
        txtAcadService.text = "TODO// Change value of var in database"
        txtAcadAgeFrom.text = ageFromS.toString()
        txtAcadAgeTo.text = ageToS.toString()

        //regionS + "  " + cityS
    }

    fun btnLocationAcadEvent(view: View){
        //TODO: Location Academy
    }

    fun btnAcademyBooking(view:View){
        var alertBuilder = AlertDialog.Builder(this)
        alertBuilder.setTitle("BOOKING")
                .setMessage("To booking please call: 0563081535")
                .setPositiveButton("Call", DialogInterface.OnClickListener() { dialogInterface: DialogInterface, i: Int ->
                    //TODO:Delete Method
                })
                .setNegativeButton("NO", DialogInterface.OnClickListener() { dialogInterface: DialogInterface, i: Int ->
                    dialogInterface.dismiss()
                })

        var dailog = alertBuilder.create()
        dailog.show()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item!!.getItemId()){
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
