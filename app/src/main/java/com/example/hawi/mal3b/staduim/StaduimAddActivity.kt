package com.example.hawi.mal3b.staduim

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.example.hawi.mal3b.R

class StaduimAddActivity : AppCompatActivity() {

    lateinit var cbGrass:CheckBox
    lateinit var cbToilet:CheckBox
    lateinit var cbShower:CheckBox
    lateinit var cbWater:CheckBox
    lateinit var cbBall:CheckBox
    lateinit var cbDress:CheckBox
    lateinit var cbStaduim:CheckBox
    lateinit var cbBuffet:CheckBox

    var cbGrassResult:Int = 0
    var cbToiletResult:Int = 0
    var cbShowerResult:Int = 0
    var cbWaterResult:Int = 0
    var cbBallResult:Int = 0
    var cbDressResult:Int = 0
    var cbStaduimResult:Int = 0
    var cbBuffetResult:Int = 0

    lateinit var etName:EditText
    lateinit var etRate:EditText
    lateinit var etLatit:EditText
    lateinit var etLong:EditText
    lateinit var etPrice:EditText
    lateinit var etSize:EditText
    lateinit var etRegion:EditText
    lateinit var etCity:EditText
    lateinit var etOwnerPhone:EditText
    lateinit var etManagPhone:EditText
    lateinit var etIMG:EditText

    lateinit var staduimDB:StaduimDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.staduim_add_activity)

        staduimDB = StaduimDB(this)

        intilize()

        if(supportActionBar != null){
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun intilize(){
        cbGrass = findViewById(R.id.cbStaduimGrass)
        cbToilet = findViewById(R.id.cbStaduimToilet)
        cbShower = findViewById(R.id.cbStaduimShower)
        cbWater = findViewById(R.id.cbStaduimWater)
        cbBall = findViewById(R.id.cbStaduimBall)
        cbDress = findViewById(R.id.cbStaduimDress)
        cbStaduim = findViewById(R.id.cbStaduimStaduim)
        cbBuffet = findViewById(R.id.cbStaduimBuffet)

        etName = findViewById(R.id.txtStaduimName)
        etRate = findViewById(R.id.txtStaduimRate)
        etLatit = findViewById(R.id.txtStaduimLatit)
        etLong = findViewById(R.id.txtStaduimLong)
        etPrice = findViewById(R.id.txtStaduimPrice)
        etSize = findViewById(R.id.txtStaduimSize)
        etRegion = findViewById(R.id.txtStaduimRegion)
        etCity = findViewById(R.id.txtStaduimCity)
        etOwnerPhone = findViewById(R.id.txtStaduimPhoneOwner)
        etManagPhone = findViewById(R.id.txtStaduimPhoneManager)
        etIMG = findViewById(R.id.txtStaduimImageName)
    }

    fun btnStaduimAdd(view: View){
        val nameA:String = etName.text.toString()
        val rateA:Float = etRate.text.toString().toFloat()
        val latitA:Double = etLatit.text.toString().toDouble()
        val longtA:Double = etLong.text.toString().toDouble()
        val sizeA:String = etSize.text.toString()
        val priceA:Int = etPrice.text.toString().toInt()
        val regionA:String = etRegion.text.toString()
        val cityA:String = etCity.text.toString()
        val ownerPhoneA:Int = etOwnerPhone.text.toString().toInt()
        val managPhoneA:Int = etManagPhone.text.toString().toInt()
        val backgroundA:String = etIMG.text.toString()

        var staduimA = StaduimAllData(nameA,backgroundA,ownerPhoneA,managPhoneA,rateA,sizeA,priceA,
                regionA,cityA,latitA,longtA,cbWaterResult,cbGrassResult,cbToiletResult,cbShowerResult,
                cbBallResult,cbDressResult,cbStaduimResult,cbBuffetResult)

//        var staduimA = StaduimAllData("Abdu","w001",5666,5555,3.5F,"6t6",300,
//                "makk","jedd",21.08780,39.65676,1,1,1,0,
//                1,1,0,0)

        staduimDB.addStaduimToDB(staduimA,this)

        Toast.makeText(this,"Adding Staduim success",Toast.LENGTH_SHORT).show()

        finish()
    }

    fun cbGrassEvent(view: View){
        if(cbGrass.isChecked) cbGrassResult = 1
    }
    fun cbToiletEvent(view: View){
        if(cbToilet.isChecked) cbToiletResult = 1
    }
    fun cbShowerEvent(view: View){
        if(cbShower.isChecked) cbShowerResult = 1
    }
    fun cbWaterEvent(view: View){
        if(cbWater.isChecked) cbWaterResult = 1
    }
    fun cbBallEvent(view: View){
        if(cbBall.isChecked) cbBallResult = 1
    }
    fun cbDressEvent(view: View){
        if(cbDress.isChecked) cbDressResult = 1
    }
    fun cbStaduimEvent(view: View){
        if(cbStaduim.isChecked) cbStaduimResult = 1
    }
    fun cbBuffetEvent(view: View){
        if(cbBuffet.isChecked) cbBuffetResult = 1
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item!!.getItemId()){
            android.R.id.home-> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
