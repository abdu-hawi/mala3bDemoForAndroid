package com.example.hawi.mal3b.staduimLocationFolder

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hawi.mal3b.R

/**
 * Created by Hawi on 27/08/17.
 */
class StaduimMarkerClick:Fragment(){

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {


        return inflater!!.inflate(R.layout.staduim_marker_maps_click,container,false)
    }
}