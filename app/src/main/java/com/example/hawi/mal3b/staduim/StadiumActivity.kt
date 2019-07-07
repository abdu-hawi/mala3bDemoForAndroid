package com.example.hawi.mal3b.staduim

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import com.example.hawi.mal3b.R
import com.example.hawi.mal3b.staduimChoiseAndConfirmPay.StaduimChoiseActivity
import com.example.hawi.mal3b.staduimLocationFolder.StaduimFragmentAdapter
import com.example.hawi.mal3b.staduimLocationFolder.StaduimMapFragment
import com.example.hawi.mal3b.staduimStarsRate.StaduimDownRateFragment
import com.example.hawi.mal3b.staduimStarsRate.StaduimUpRateFragment

class StadiumActivity : AppCompatActivity() {

    lateinit private var adapterOfStudim: StaduimFragmentAdapter
    lateinit private var viewPagerStudim: ViewPager

/// For recycle
/*
private var mAdapterRecycleViewStadium: AdapterRecycleViewStadium? = null
    private var mDataItemRecycleStadium: ArrayList<DataItemRecycleStadium>? = null
    private var mRecyclerViewLayoutManager: RecyclerView.LayoutManager? = null
 */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stadium)


        if(supportActionBar != null){
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }

        adapterOfStudim = StaduimFragmentAdapter(supportFragmentManager)

        viewPagerStudim = findViewById(R.id.staduimContainer)

        setUpViewPager(viewPagerStudim)

        val tabStaduim:TabLayout = findViewById(R.id.staduimToolbarTop)
        tabStaduim.setupWithViewPager(viewPagerStudim)

        tabStaduim.getTabAt(0)!!.setIcon(R.drawable.ic_search_black_48dp)
        tabStaduim.getTabAt(1)!!.setIcon(R.drawable.ic_location_on_black_48dp)
        tabStaduim.getTabAt(2)!!.setIcon(R.drawable.ic_star_rate_up)
        tabStaduim.getTabAt(3)!!.setIcon(R.drawable.ic_star_rate_down)

/// For recycle
/*
initialize()
    setupList()
    loaddata()
 */

} // END ONCREATE

    private fun setUpViewPager(viewPagerStudim: ViewPager?) {
        val SFAdapter = StaduimFragmentAdapter(supportFragmentManager)
        SFAdapter.addFragment(StaduimMainFragment())
        SFAdapter.addFragment(StaduimMapFragment())
        SFAdapter.addFragment(StaduimUpRateFragment())
        SFAdapter.addFragment(StaduimDownRateFragment())

        viewPagerStudim!!.adapter = SFAdapter
    }

/// For recycle
/*
private fun loaddata() {
    mDataItemRecycleStadium!!.add(DataItemRecycleStadium("الخريطة" , R.drawable.ic_location_on_white_48dp ))
    mDataItemRecycleStadium!!.add(DataItemRecycleStadium("التقييم" , R.drawable.ic_star_rate_white_18dp ))
    mDataItemRecycleStadium!!.add(DataItemRecycleStadium("المدينة" , R.drawable.ic_location_on_white_48dp ))
    mAdapterRecycleViewStadium!!.notifyDataSetChanged()
}

private fun setupList() {
    rvStadium!!.layoutManager = mRecyclerViewLayoutManager
    rvStadium!!.adapter = mAdapterRecycleViewStadium
}

private fun initialize() {
    mDataItemRecycleStadium = ArrayList<DataItemRecycleStadium>()
    mRecyclerViewLayoutManager = LinearLayoutManager(this, LinearLayout.HORIZONTAL, false)
    mAdapterRecycleViewStadium = AdapterRecycleViewStadium(mDataItemRecycleStadium!!, this, R.layout.item_cell_recycler_view_stadium)
}
 */

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    //return super.onCreateOptionsMenu(menu) StaduimsearchBar
    menuInflater.inflate(R.menu.stadium_menu,menu)

    var searchManager:SearchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
    var searchView:SearchView = menu!!.findItem(R.id.StaduimsearchBar).getActionView() as SearchView
    searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))

    var co:Context = this
    var staduimList: ListView
    var db:StaduimDB
    var staduimAdapter:StaduimListAdapter

    searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
        override fun onQueryTextSubmit(query: String?): Boolean {

            staduimList = findViewById(R.id.staduim_stars_fragment_list)
            db = StaduimDB(co)
            var staduimSearch = db.searchFromDB(query!!)
            staduimAdapter = StaduimListAdapter(co,R.layout.staduim_item_list,staduimSearch)
            staduimList.adapter = staduimAdapter
            staduimList.setOnItemClickListener(staduimListOnClick())
            return true
        }

        override fun onQueryTextChange(newText: String?): Boolean {

            staduimList = findViewById(R.id.staduim_stars_fragment_list)
            db = StaduimDB(co)
            var staduimSearch = db.searchFromDB(newText!!)
            staduimAdapter = StaduimListAdapter(co,R.layout.staduim_item_list,staduimSearch)
            staduimList.adapter = staduimAdapter
            staduimList.setOnItemClickListener(staduimListOnClick())
            return true
        }

    })
    return true
}

    fun staduimListOnClick(): AdapterView.OnItemClickListener= AdapterView.OnItemClickListener() {
        adapterView: AdapterView<*>, view1: View, i: Int, l: Long ->

        var select_staduim:StaduimAllData = adapterView.getItemAtPosition(i) as StaduimAllData

        var intent = Intent(this , StaduimChoiseActivity::class.java)
        intent.putExtra("id",select_staduim.idS)
        startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

    when(item!!.getItemId()){
        android.R.id.home-> finish()
        R.id.addStaduim-> startActivity(Intent(this,StaduimAddActivity::class.java))
    }
    return super.onOptionsItemSelected(item)
}

}
