package com.example.hawi.mal3b.staduimChoiseAndConfirmPay

/**
 * Created by Hawi on 11/08/17.
 */

internal class StaduimFootballTimeItem {
    var name: String? = null
    var number: String? = null
    var nameDay:String? = null

    var img:Int? = null
    var timePlay:String? = null

    constructor(img: Int?, timePlay: String?) {
        this.img = img
        this.timePlay = timePlay
    }
}