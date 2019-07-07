package com.example.hawi.mal3b.staduim

import android.location.Location

/**
 * Created by Hawi on 15/09/17.
 */
class StaduimAllData {

    var idS:Int? = null
    var nameS:String
    var rateS:Float
    var location:Location? = null
    var latitude:Double
    var longitude:Double
    var sizeArrayS:Array<String>? = null
    var sizeStrinS:String
    var priceS:Int
    var regionS:String
    var cityS:String
    var phoneOwnerS:Int
    var phoneMangS:Int
    var backgroundS:String
    //for staduim brevlage
    var waterS:Int
    var grassS:Int
    var toiletS:Int
    var showerS:Int
    var ballS:Int
    var dressS:Int
    var stadS:Int
    var buffetS:Int

    constructor(nameS: String,backgroundS:String, phoneOwnerS:Int,phoneMangS:Int,rateS:Float,sizeStrinS:String,priceS:Int,
                regionS:String, cityS:String,latitudeS:Double,longitudeS:Double,waterS:Int,grassS:Int, toiletS:Int,showerS:Int,ballS:Int,
                dressS:Int,stadS:Int,buffetS:Int){

        this.nameS = nameS
        this.backgroundS = backgroundS
        this.phoneOwnerS = phoneOwnerS
        this.phoneMangS = phoneMangS
        this.rateS = rateS
        this.sizeStrinS = sizeStrinS
        this.priceS = priceS
        this.regionS = regionS
        this.cityS = cityS
//        this.location!!.latitude = latit
//        this.location!!.longitude = longet
        this.latitude = latitudeS
        this.longitude = longitudeS
        this.waterS = waterS
        this.toiletS = toiletS
        this.grassS = grassS
        this.showerS = showerS
        this.ballS = ballS
        this.dressS = dressS
        this.stadS = stadS
        this.buffetS = buffetS
    }

    constructor(idS:Int , nameS: String,backgroundS:String, phoneOwnerS:Int,phoneMangS:Int,rateS:Float,sizeStrinS:String,priceS:Int,
                regionS:String, cityS:String,latitudeS:Double,longitudeS:Double,waterS:Int,grassS:Int, toiletS:Int,showerS:Int,ballS:Int,
                dressS:Int,stadS:Int,buffetS:Int){
        this.idS = idS
        this.nameS = nameS
        this.backgroundS = backgroundS
        this.phoneOwnerS = phoneOwnerS
        this.phoneMangS = phoneMangS
        this.rateS = rateS
        this.sizeStrinS = sizeStrinS
        this.priceS = priceS
        this.regionS = regionS
        this.cityS = cityS
//        this.location!!.latitude = lat
//        this.location!!.longitude = long
        this.latitude = latitudeS
        this.longitude = longitudeS
        this.waterS = waterS
        this.toiletS = toiletS
        this.grassS = grassS
        this.showerS = showerS
        this.ballS = ballS
        this.dressS = dressS
        this.stadS = stadS
        this.buffetS = buffetS
    }

//    var sizeSTA:String = convertListToString(sizeArrayS!!)
//    fun convertListToString(stringList:Array<String>):String {
//        val stringBuffer = StringBuffer()
//        for (str in stringList)
//        {
//            stringBuffer.append(str).append(sizeSTA)
//        }
//        // Remove last separator
//        val lastIndex = stringBuffer.lastIndexOf(sizeSTA)
//        stringBuffer.delete(lastIndex, lastIndex + sizeSTA.length + 1)
//        return stringBuffer.toString()
//    }
//    fun convertStringToList(str:String): MutableList<Array<String>>? {
//        return Arrays.asList(str.split((sizeSTA).toRegex()).dropLastWhile({ it.isEmpty() }).toTypedArray())
//    }

}