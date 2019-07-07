package com.example.hawi.mal3b.academy

/**
 * Created by Hawi on 20/09/17.
 */
class AcademyData {

    var idA:Int? = null
    var nameA:String
    var regionA:String
    var cityA:String
    lateinit var nighboreA:String
    var LatitA:Double?= null
    var longetA:Double?= null
    var rateA:Float?= null
    var priceA:Int? = null
//    var imgA:Int? = null
    var imgA:String
    var serviceA:Int? = null
    var ageFromA:Int? = null
    var ageToA:Int? = null

    constructor(idA: Int?, nameA: String, regionA: String, cityA: String, nighboreA: String,
                LatitA: Double?, longetA: Double?, rateA: Float?, priceA: Int?, imgA: String,
                serviceA: Int?, ageFromA: Int?, ageToA: Int?) {
        this.idA = idA
        this.nameA = nameA
        this.regionA = regionA
        this.cityA = cityA
        this.nighboreA = nighboreA
        this.LatitA = LatitA
        this.longetA = longetA
        this.rateA = rateA
        this.priceA = priceA
        this.imgA = imgA
        this.serviceA = serviceA
        this.ageFromA = ageFromA
        this.ageToA = ageToA
    }

    constructor(nameA: String, regionA: String, cityA: String, nighboreA: String, LatitA: Double?,
                longetA: Double?, rateA: Float?, priceA: Int?, imgA: String, serviceA: Int?,
                ageFromA: Int?, ageToA: Int?) {
        this.nameA = nameA
        this.regionA = regionA
        this.cityA = cityA
        this.nighboreA = nighboreA
        this.LatitA = LatitA
        this.longetA = longetA
        this.rateA = rateA
        this.priceA = priceA
        this.imgA = imgA
        this.serviceA = serviceA
        this.ageFromA = ageFromA
        this.ageToA = ageToA
    }

    constructor(nameA: String, regionA: String, cityA: String, rateA: Float?, priceA: Int?, imgA: String) {
        this.nameA = nameA
        this.regionA = regionA
        this.cityA = cityA
        this.rateA = rateA
        this.priceA = priceA
        this.imgA = imgA
    }


}