package com.example.hawi.mal3b.staduim

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import com.example.hawi.mal3b.R

class StaduimUpdateActivity : AppCompatActivity() {

    lateinit var cbGrass: CheckBox
    lateinit var cbToilet: CheckBox
    lateinit var cbShower: CheckBox
    lateinit var cbWater: CheckBox
    lateinit var cbBall: CheckBox
    lateinit var cbDress: CheckBox
    lateinit var cbStaduim: CheckBox
    lateinit var cbBuffet: CheckBox

    var cbGrassResult:Int = 0
    var cbToiletResult:Int = 0
    var cbShowerResult:Int = 0
    var cbWaterResult:Int = 0
    var cbBallResult:Int = 0
    var cbDressResult:Int = 0
    var cbStaduimResult:Int = 0
    var cbBuffetResult:Int = 0

    lateinit var etName: EditText
    lateinit var etRate: EditText
    lateinit var etLatit: EditText
    lateinit var etLong: EditText
    lateinit var etPrice: EditText
    lateinit var etSize: EditText
    lateinit var etRegion: EditText
    lateinit var etCity: EditText
    lateinit var etOwnerPhone: EditText
    lateinit var etManagPhone: EditText
    lateinit var etIMG: EditText

    lateinit var staduimDB:StaduimDB
    lateinit var stadUpdate:StaduimAllData
    var idU:Int?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.staduim_update_activity)

        staduimDB = StaduimDB(this)

        idU = intent.getIntExtra("idU",0)
        stadUpdate = staduimDB.getStaduimById(idU!!)

        intilizeIntent()

        intilizeLayout()

        if(supportActionBar != null){
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun intilizeLayout() {

        etName.setText(stadUpdate.nameS)
        etRate.setText(stadUpdate.rateS.toString())
        etLatit.setText(stadUpdate.latitude.toString())
        etLong.setText(stadUpdate.longitude.toString())
        etPrice.setText(stadUpdate.priceS.toString())
        etSize.setText(stadUpdate.sizeStrinS)
        etRegion.setText(stadUpdate.regionS)
        etCity.setText(stadUpdate.cityS)
        etOwnerPhone.setText(stadUpdate.phoneOwnerS.toString())
        etManagPhone.setText(stadUpdate.phoneMangS.toString())
        etIMG.setText(stadUpdate.backgroundS)

        if(stadUpdate.grassS == 1) cbGrass!!.isChecked = true


    }

    private fun intilizeIntent(){
        cbGrass = findViewById(R.id.cbStaduimGrassUpdate)
        cbToilet = findViewById(R.id.cbStaduimToiletUpdate)
        cbShower = findViewById(R.id.cbStaduimShowerUpdate)
        cbWater = findViewById(R.id.cbStaduimWaterUpdate)
        cbBall = findViewById(R.id.cbStaduimBallUpdate)
        cbDress = findViewById(R.id.cbStaduimDressUpdate)
        cbStaduim = findViewById(R.id.cbStaduimStaduimUpdate)
        cbBuffet = findViewById(R.id.cbStaduimBuffetUpdate)

        etName = findViewById(R.id.txtStaduimNameUpdate)
        etRate = findViewById(R.id.txtStaduimRateUpdate)
        etLatit = findViewById(R.id.txtStaduimLatitUpdate)
        etLong = findViewById(R.id.txtStaduimLongUpdate)
        etPrice = findViewById(R.id.txtStaduimPriceUpdate)
        etSize = findViewById(R.id.txtStaduimSizeUpdate)
        etRegion = findViewById(R.id.txtStaduimRegionUpdate)
        etCity = findViewById(R.id.txtStaduimCityUpdate)
        etOwnerPhone = findViewById(R.id.txtStaduimPhoneOwnerUpdate)
        etManagPhone = findViewById(R.id.txtStaduimPhoneManagerUpdate)
        etIMG = findViewById(R.id.txtStaduimImageNameUpdate)

    }

    fun btnStaduimUpdtae(view:View){
        var newName:String = etName!!.text.toString()
        var newRate:Float = etRate!!.text.toString().toFloat()
        var newLatit:Double = etLatit!!.text.toString().toDouble()
        var newLongt:Double = etLong!!.text.toString().toDouble()
        var newSize:String = etSize!!.text.toString()
        var newPrice:Int = etPrice!!.text.toString().toInt()
        var newRegion:String = etRegion!!.text.toString()
        var newCity:String = etCity!!.text.toString()
        var newOwnerPhone:Int = etOwnerPhone!!.text.toString().toInt()
        var newManagPhone:Int = etManagPhone!!.text.toString().toInt()
        var newBackground:String = etIMG!!.text.toString()

        var newStaduim = StaduimAllData(idU!!,newName,newBackground,newOwnerPhone,newManagPhone,newRate,newSize,newPrice,
                newRegion,newCity,newLatit,newLongt,cbWaterResult,cbGrassResult,cbToiletResult,cbShowerResult,
                cbBallResult,cbDressResult,cbStaduimResult,cbBuffetResult)

        staduimDB.updateStaduimToDB(newStaduim,this)

        finish()
    }
    // 0555 693 887

    fun cbGrassEvent(view: View){
        if(cbGrass!!.isChecked) cbGrassResult = 1
    }
    fun cbToiletEvent(view: View){
        if(cbToilet!!.isChecked) cbToiletResult = 1
    }
    fun cbShowerEvent(view: View){
        if(cbShower!!.isChecked) cbShowerResult = 1
    }
    fun cbWaterEvent(view: View){
        if(cbWater!!.isChecked) cbWaterResult = 1
    }
    fun cbBallEvent(view: View){
        if(cbBall!!.isChecked) cbBallResult = 1
    }
    fun cbDressEvent(view: View){
        if(cbDress!!.isChecked) cbDressResult = 1
    }
    fun cbStaduimEvent(view: View){
        if(cbStaduim.isChecked) cbStaduimResult = 1
    }
    fun cbBuffetEvent(view: View){
        if(cbBuffet.isChecked) cbBuffetResult = 1
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.staduim_menu_icon_delete,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item!!.getItemId()){
            android.R.id.home-> finish()
        }
        return super.onOptionsItemSelected(item)
    }

}
