package com.example.hawi.mal3b.staduimChoiseAndConfirmPay

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import com.example.hawi.mal3b.*
import com.example.hawi.mal3b.staduim.StaduimAllData
import com.example.hawi.mal3b.staduim.StaduimDB
import com.example.hawi.mal3b.staduim.StaduimUpdateActivity
import kotlinx.android.synthetic.main.staduim_choise_activity.*
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Hawi on 12/09/17.
 */
class StaduimChoiseActivity : AppCompatActivity() {
    ////////////////////
    // Calenadr
    private var staduimCalendarAdapter: StaduimCalendarAdapter? = null
    private var arrayList: ArrayList<StaduimCalendarItem>? = null
    private var layoutManager: RecyclerView.LayoutManager? = null
    lateinit var cal: Calendar
    // Time choise
    private var staduimFootballTimeAdapter: StaduimFootballTimeAdapter? = null
    private var staduimFootballTimeArray: ArrayList<StaduimFootballTimeItem>? = null

    lateinit var spinnerSize: Spinner
    lateinit var spinnerTime: Spinner
    private var arraySpinnerSize = ArrayList<String>()
    lateinit var arraySpinnerTime : ArrayAdapter<CharSequence>
    ////////////////////////
    // intent
    var idC:Int? = null

    //database & staduimAllData
    lateinit var db:StaduimDB
    lateinit var staduimAllData:StaduimAllData

    ///
    lateinit var LLayoutBackgroundChoise:LinearLayout
    lateinit var txtCityChoi:TextView
    lateinit var imgGrassChoi:ImageView
    lateinit var imgBallChoi:ImageView
    lateinit var imgToiletChoi:ImageView
    lateinit var imgDressChoi:ImageView
    lateinit var imgShowerChoi:ImageView
    lateinit var imgWaterChoi:ImageView
    lateinit var imgStaduimChoi:ImageView
    lateinit var imgBuffetChoi:ImageView
    lateinit var txtPriceChoi:TextView
    lateinit var txtSaleChoi:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.staduim_choise_activity)

        //init DB
        var idA = intent.getIntExtra("id",0)
        db = StaduimDB(this)
        staduimAllData = db.getStaduimById(idA)

        // intent
        initializeLayoutC()

        if(supportActionBar != null){
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }
//        txtSale.setText("")

        cal = Calendar.getInstance()
        spinnerSize = findViewById(R.id.spinnerSize)
        spinnerTime = findViewById(R.id.spinnerTime)

        initialize()
        setupList()
        loadCalendarData()

        initializeFootballTime()
        setupListFootballTime()
        loadFootballTimeData()

        spinnerSizeLoad()
        spinnerTimeLoad()
    }

    private fun initializeLayoutC() {
        LLayoutBackgroundChoise = findViewById(R.id.linerBackgroundChoise)
        txtCityChoi = findViewById(R.id.txtCityLayoutChoise)
        imgGrassChoi = findViewById(R.id.imgGrassLayout)
        imgBallChoi = findViewById(R.id.imgBallLayout)
        imgToiletChoi = findViewById(R.id.imgToiletLayout)
        imgDressChoi = findViewById(R.id.imgDressLayout)
        imgShowerChoi = findViewById(R.id.imgShowerLayout)
        imgWaterChoi = findViewById(R.id.imgWaterLayout)
        imgStaduimChoi = findViewById(R.id.imgStaduimLayout)
        imgBuffetChoi = findViewById(R.id.imgBuffetLayout)
        txtPriceChoi = findViewById(R.id.txtPriceLayout)
        txtSaleChoi = findViewById(R.id.txtSaleLayout)


        title = staduimAllData.nameS
        var resID:Int = this.resources.getIdentifier(staduimAllData.backgroundS,"drawable",this.packageName)
        LLayoutBackgroundChoise.setBackgroundResource(resID)
        txtCityChoi.setText(staduimAllData.regionS +" / "+ staduimAllData.cityS)
        txtPriceChoi.setText(staduimAllData.priceS.toString() + " RS")
        txtSaleChoi.setText("")

        if (staduimAllData.grassS == 0) imgGrassChoi.setColorFilter(R.color.colorGray1)
        if (staduimAllData.ballS == 0) imgBallChoi.setColorFilter(R.color.colorGray1)
        if (staduimAllData.toiletS == 0) imgToiletChoi.setColorFilter(R.color.colorGray1)
        if (staduimAllData.dressS == 0) imgDressChoi.setColorFilter(R.color.colorGray1)
        if (staduimAllData.showerS == 0) imgShowerChoi.setColorFilter(R.color.colorGray1)
        if (staduimAllData.waterS == 0) imgWaterChoi.setColorFilter(R.color.colorGray1)
        if (staduimAllData.stadS == 0) imgStaduimChoi.setColorFilter(R.color.colorGray1)
        if (staduimAllData.buffetS == 0) imgBuffetChoi.setColorFilter(R.color.colorGray1)
    }

    fun btnLocationChoi(view: View){

    }

    fun btnCountinueToPayment(view: View){
        startActivity(Intent(this, StaduimConfirmBookingActivity::class.java))
    }

    private fun spinnerSizeLoad() {
        arraySpinnerSize.add("12 × 12")
        arraySpinnerSize.add("9 × 9")
        arraySpinnerSize.add("8 × 8")
        arraySpinnerSize.add("6 × 6")

        var adapter: ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_spinner_item,arraySpinnerSize)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerSize.adapter = adapter
    }

    private fun spinnerTimeLoad() {

        arraySpinnerTime = ArrayAdapter.createFromResource(this, R.array.spinner_time_item,
                android.R.layout.simple_spinner_item)

        arraySpinnerTime.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerTime.adapter = arraySpinnerTime
    }

    private fun loadCalendarData() {

        //Simple Date Format
        var sdfDay: SimpleDateFormat = SimpleDateFormat("dd")
        var sdfNamDay: SimpleDateFormat = SimpleDateFormat("E")
        var sdfMonth: SimpleDateFormat = SimpleDateFormat("MMM")

        for( i in 0.. 25){
            val myItem = StaduimCalendarItem()

            myItem.name = sdfMonth.format(cal.time)
            myItem.number = sdfDay.format(cal.time)
            myItem.nameDay = sdfNamDay.format(cal.time)
            cal.add(Calendar.DATE,1)
            arrayList!!.add(myItem)
        }
        staduimCalendarAdapter!!.notifyDataSetChanged()

    }

    private fun loadFootballTimeData() {
        staduimFootballTimeArray!!.add(StaduimFootballTimeItem(R.drawable.football_green, "09:00 PM"))
        staduimFootballTimeArray!!.add(StaduimFootballTimeItem(R.drawable.football_green, "11:00 PM"))
        staduimFootballTimeArray!!.add(StaduimFootballTimeItem(R.drawable.football_green, "01:00 AM"))
        staduimFootballTimeArray!!.add(StaduimFootballTimeItem(R.drawable.football_red, "03:00 AM"))

        staduimFootballTimeAdapter!!.notifyDataSetChanged()
    }

    private fun setupList() {
        calendarView!!.layoutManager = layoutManager
        calendarView!!.adapter = staduimCalendarAdapter
    }

    private fun setupListFootballTime() {
        footballView!!.layoutManager = layoutManager
        footballView!!.adapter = staduimFootballTimeAdapter
    }

    private fun initialize() {
        // rlItems = findViewById(R.id.rlItems) as RecyclerView
        arrayList = ArrayList<StaduimCalendarItem>()
        layoutManager = LinearLayoutManager(this, LinearLayout.HORIZONTAL, false)
        staduimCalendarAdapter = StaduimCalendarAdapter(arrayList!!, this, R.layout.staduim_appointment_calendar)

    }

    private fun initializeFootballTime() {
        staduimFootballTimeArray = ArrayList<StaduimFootballTimeItem>()
        layoutManager = LinearLayoutManager(this, LinearLayout.HORIZONTAL, false)
        staduimFootballTimeAdapter = StaduimFootballTimeAdapter(staduimFootballTimeArray!!, this, R.layout.staduim_appointment_time)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.staduim_menu_icon_update,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item!!.getItemId()){
            android.R.id.home -> finish()
            R.id.staduimMenuUpdateIcon -> goToUdateStaduim()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun goToUdateStaduim() {
        var intentUpdate = Intent(this,StaduimUpdateActivity::class.java)

        intentUpdate.putExtra("idU",staduimAllData.idS)
        startActivity(intentUpdate)
    }

    override fun onResume() {
        super.onResume()

        db = StaduimDB(this)
        staduimAllData = db.getStaduimById(staduimAllData.idS!!)

        // intent
        initializeLayoutC()
    }

}
