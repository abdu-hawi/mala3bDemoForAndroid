package com.example.hawi.mal3b.staduimLocationFolder

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import java.util.ArrayList

/**
 * Created by Hawi on 27/08/17.
 */
class StaduimFragmentAdapter(fm:FragmentManager):FragmentPagerAdapter(fm) {

    private var mFragmentList = ArrayList<Fragment>()

    override fun getItem(position: Int): Fragment {
        return mFragmentList.get(position)
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }

    fun addFragment(fragment: Fragment){
        mFragmentList.add(fragment)
    }
}