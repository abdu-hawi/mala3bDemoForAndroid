package com.example.hawi.mal3b.staduimLocationFolder

import android.location.Location

/**
 * Created by Hawi on 27/08/17.
 */
class StaduimSubObject {

    var name:String? = null
    var stars:Int? = null
    var location:Location? = null

    constructor(stars:Int,name:String,lat:Double,long:Double){
        this.name = name
        this.stars = stars
        this.location = Location(name)
        location!!.longitude = long
        location!!.latitude = lat

    }
}