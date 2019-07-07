package com.example.hawi.mal3b.staduim

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

/**
 * Created by Hawi on 15/09/17.
 */
class StaduimDB : SQLiteOpenHelper {

    private final var KEY_ID = "id"
    private final var KEY_NAME = "staduim_name"
    private final var KEY_RATE = "rate"
    //latitude and longitude
    private final var KEY_LATITUDE = "latitude"
    private final var KEY_LONGITUDE = "longitude"
    private final var KEY_SIZE = "size"
    private final var KEY_PRICE = "price"
    private final var KEY_REGION = "region"
    private final var KEY_CITY = "city"
    private final var KEY_OWNER_PHONE = "owner_phone"
    private final var KEY_MANAG_PHONE = "manager_phone"
    private final var KEY_IMG = "image"
    //staduim brevlege
    private final var KEY_WATER = "water"
    private final var KEY_GRASS = "grass"
    private final var KEY_TOILET = "toilet"
    private final var KEY_SHOWER = "shower"
    private final var KEY_BALL = "ball"
    private final var KEY_DRESS = "dress"
    private final var KEY_STADUIM = "satduim"
    private final var KEY_BUFFET = "bufeet"
    private final var TABLE_NAME = "STADUIM_TABLE"

    var contextSQL:Context

    constructor(context: Context?)
                :super(context, "staduim_db", null, 6){
        this.contextSQL = context!!
    }

    override fun onCreate(p0: SQLiteDatabase?) {
//        CREATE TABLE "+TABLE_NAME+ "("+KEY_ID+" integer primary key
        var creat_table = "CREATE TABLE "+TABLE_NAME+ "("+KEY_ID+" integer primary key, "+KEY_NAME+" varchar(40), "+
                KEY_RATE+" float, "+KEY_LATITUDE+" double , "+KEY_LONGITUDE+" double, "+KEY_SIZE+" varchar(30), "+
                KEY_PRICE+" integer, "+KEY_REGION+" varchar(20), "+KEY_CITY+" varchar(20), "+KEY_OWNER_PHONE+ " integeer, "+
                KEY_MANAG_PHONE+" integer, "+KEY_IMG+" varchar(5), "+KEY_WATER+" integer, "+KEY_GRASS+" integer, "+
                KEY_TOILET+" integer, "+KEY_SHOWER+" integer, "+KEY_BALL+" integer, "+KEY_DRESS+" integer, "+
                KEY_STADUIM+" integer, "+KEY_BUFFET+" integer )"

        p0!!.execSQL(creat_table)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        val delete_table = "DROP TABLE " + TABLE_NAME
        p0!!.execSQL(delete_table)
        onCreate(p0)
    }

    fun addStaduimToDB(staduimAllData: StaduimAllData , context: Context){
        val sqliteDB:SQLiteDatabase = this.writableDatabase

        val mval = ContentValues()
        mval.put(KEY_NAME,staduimAllData.nameS)
        mval.put(KEY_RATE,staduimAllData.rateS)
        mval.put(KEY_LATITUDE,staduimAllData.latitude)
        mval.put(KEY_LONGITUDE,staduimAllData.longitude)
        mval.put(KEY_SIZE,staduimAllData.sizeStrinS)
        mval.put(KEY_PRICE,staduimAllData.priceS)
        mval.put(KEY_REGION,staduimAllData.regionS)
        mval.put(KEY_CITY,staduimAllData.cityS)
        mval.put(KEY_OWNER_PHONE,staduimAllData.phoneOwnerS)
        mval.put(KEY_MANAG_PHONE,staduimAllData.phoneMangS)
        mval.put(KEY_IMG,staduimAllData.backgroundS)
        mval.put(KEY_WATER,staduimAllData.waterS)
        mval.put(KEY_GRASS,staduimAllData.grassS)
        mval.put(KEY_TOILET,staduimAllData.toiletS)
        mval.put(KEY_SHOWER,staduimAllData.showerS)
        mval.put(KEY_BALL,staduimAllData.ballS)
        mval.put(KEY_DRESS,staduimAllData.dressS)
        mval.put(KEY_STADUIM,staduimAllData.stadS)
        mval.put(KEY_BUFFET,staduimAllData.buffetS)

        sqliteDB.insert(TABLE_NAME,null,mval)

        Toast.makeText(context,"Adding toSQL success",Toast.LENGTH_SHORT).show()
    }

    fun updateStaduimToDB(stad: StaduimAllData , context: Context){
        val sqliteDB:SQLiteDatabase = this.writableDatabase

        val mval = ContentValues()
        mval.put(KEY_NAME,stad.nameS)
        mval.put(KEY_RATE,stad.rateS)
        mval.put(KEY_LATITUDE,stad.latitude)
        mval.put(KEY_LONGITUDE,stad.longitude)
        mval.put(KEY_SIZE,stad.sizeStrinS)
        mval.put(KEY_PRICE,stad.priceS)
        mval.put(KEY_REGION,stad.regionS)
        mval.put(KEY_CITY,stad.cityS)
        mval.put(KEY_OWNER_PHONE,stad.phoneOwnerS)
        mval.put(KEY_MANAG_PHONE,stad.phoneMangS)
        mval.put(KEY_IMG,stad.backgroundS)
        mval.put(KEY_WATER,stad.waterS)
        mval.put(KEY_GRASS,stad.grassS)
        mval.put(KEY_TOILET,stad.toiletS)
        mval.put(KEY_SHOWER,stad.showerS)
        mval.put(KEY_BALL,stad.ballS)
        mval.put(KEY_DRESS,stad.dressS)
        mval.put(KEY_STADUIM,stad.stadS)
        mval.put(KEY_BUFFET,stad.buffetS)

//        var query = "UPDATE "+TABLE_NAME+" SET "+KEY_NAME+" = "+stad.nameS+" WHERE "+KEY_ID+" = "+stad.idS
//        sqliteDB.rawQuery(query,null)
        var update_query = sqliteDB.update( TABLE_NAME,mval,""+KEY_ID+"=?", arrayOf<String>(stad.idS.toString()) )
        Toast.makeText(context,"Update to SQL success",Toast.LENGTH_SHORT).show()



    }

    fun getAllStaduim(): ArrayList<StaduimAllData>{
        var stad = ArrayList<StaduimAllData>()

        var select_query = "SELECT * FROM " + TABLE_NAME
        var sqliteDB:SQLiteDatabase = this.readableDatabase

        var cursor:Cursor = sqliteDB.rawQuery(select_query,null)
        if(cursor.moveToFirst()){
            do{
                var idDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_ID))
                var nameDB:String = cursor.getString(cursor.getColumnIndex(KEY_NAME))
                var rateDB:Float = cursor.getFloat(cursor.getColumnIndex(KEY_RATE))
                var latitDB:Double = cursor.getDouble(cursor.getColumnIndex(KEY_LATITUDE))
                var longDB:Double = cursor.getDouble(cursor.getColumnIndex(KEY_LONGITUDE))
                var sizeDB:String = cursor.getString(cursor.getColumnIndex(KEY_SIZE))
                var priceDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_PRICE))
                var regionDB:String = cursor.getString(cursor.getColumnIndex(KEY_REGION))
                var cityDB:String = cursor.getString(cursor.getColumnIndex(KEY_CITY))
                var ownerPhoneDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_OWNER_PHONE))
                var managPhoneDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_MANAG_PHONE))
                var backgroundDB:String = cursor.getString(cursor.getColumnIndex(KEY_IMG))
                var waterDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_WATER))
                var grassDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_GRASS))
                var toiletDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_TOILET))
                var showerDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_SHOWER))
                var ballDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_BALL))
                var dressDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_DRESS))
                var staduimDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_SHOWER))
                var buffetDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_BUFFET))

                var stadDB = StaduimAllData(idDB,nameDB,backgroundDB,ownerPhoneDB,managPhoneDB,rateDB,
                        sizeDB,priceDB,regionDB,cityDB,latitDB,longDB,waterDB,grassDB,toiletDB,showerDB,
                        ballDB,dressDB,staduimDB,buffetDB)

                stad.add(stadDB)

            }while (cursor.moveToNext())
        }

        return stad
    }

    fun sortByUpRate():ArrayList<StaduimAllData>{
        var fillStaduim = ArrayList<StaduimAllData>()
        var select_query = "SELECT * FROM " +TABLE_NAME+ " ORDER BY " +KEY_RATE+ " DESC"
        var sqliteDB: SQLiteDatabase = this.readableDatabase
        var cursor:Cursor = sqliteDB.rawQuery(select_query,null)

        if (cursor.moveToFirst()){
            do{
                var idDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_ID))
                var nameDB:String = cursor.getString(cursor.getColumnIndex(KEY_NAME))
                var rateDB:Float = cursor.getFloat(cursor.getColumnIndex(KEY_RATE))
                var latitDB:Double = cursor.getDouble(cursor.getColumnIndex(KEY_LATITUDE))
                var longDB:Double = cursor.getDouble(cursor.getColumnIndex(KEY_LONGITUDE))
                var sizeDB:String = cursor.getString(cursor.getColumnIndex(KEY_SIZE))
                var priceDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_PRICE))
                var regionDB:String = cursor.getString(cursor.getColumnIndex(KEY_REGION))
                var cityDB:String = cursor.getString(cursor.getColumnIndex(KEY_CITY))
                var ownerPhoneDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_OWNER_PHONE))
                var managPhoneDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_MANAG_PHONE))
                var backgroundDB:String = cursor.getString(cursor.getColumnIndex(KEY_IMG))
                var waterDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_WATER))
                var grassDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_GRASS))
                var toiletDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_TOILET))
                var showerDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_SHOWER))
                var ballDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_BALL))
                var dressDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_DRESS))
                var staduimDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_SHOWER))
                var buffetDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_BUFFET))

                var staduim = StaduimAllData(idDB,nameDB,backgroundDB,ownerPhoneDB,managPhoneDB,rateDB,
                        sizeDB,priceDB,regionDB,cityDB,latitDB,longDB,waterDB,grassDB,toiletDB,showerDB,
                        ballDB,dressDB,staduimDB,buffetDB)
                fillStaduim.add(staduim)
            }while (cursor.moveToNext())
        }
        return fillStaduim
    }

    fun sortByDownRate():ArrayList<StaduimAllData>{
        var fillStaduim = ArrayList<StaduimAllData>()
        var select_query = "SELECT * FROM " +TABLE_NAME+ " ORDER BY " +KEY_RATE+ " ASC"
        var sqliteDB: SQLiteDatabase = this.readableDatabase
        var cursor:Cursor = sqliteDB.rawQuery(select_query,null)

        if (cursor.moveToFirst()){
            do{
                var idDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_ID))
                var nameDB:String = cursor.getString(cursor.getColumnIndex(KEY_NAME))
                var rateDB:Float = cursor.getFloat(cursor.getColumnIndex(KEY_RATE))
                var latitDB:Double = cursor.getDouble(cursor.getColumnIndex(KEY_LATITUDE))
                var longDB:Double = cursor.getDouble(cursor.getColumnIndex(KEY_LONGITUDE))
                var sizeDB:String = cursor.getString(cursor.getColumnIndex(KEY_SIZE))
                var priceDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_PRICE))
                var regionDB:String = cursor.getString(cursor.getColumnIndex(KEY_REGION))
                var cityDB:String = cursor.getString(cursor.getColumnIndex(KEY_CITY))
                var ownerPhoneDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_OWNER_PHONE))
                var managPhoneDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_MANAG_PHONE))
                var backgroundDB:String = cursor.getString(cursor.getColumnIndex(KEY_IMG))
                var waterDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_WATER))
                var grassDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_GRASS))
                var toiletDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_TOILET))
                var showerDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_SHOWER))
                var ballDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_BALL))
                var dressDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_DRESS))
                var staduimDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_SHOWER))
                var buffetDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_BUFFET))

                var staduim = StaduimAllData(idDB,nameDB,backgroundDB,ownerPhoneDB,managPhoneDB,rateDB,
                        sizeDB,priceDB,regionDB,cityDB,latitDB,longDB,waterDB,grassDB,toiletDB,showerDB,
                        ballDB,dressDB,staduimDB,buffetDB)
                fillStaduim.add(staduim)
            }while (cursor.moveToNext())
        }
        return fillStaduim
    }

    fun searchFromDB(name:String):ArrayList<StaduimAllData>{
        var fillStaduim = ArrayList<StaduimAllData>()
        var select_query = "SELECT * FROM " +TABLE_NAME+ " WHERE " + KEY_NAME + " LIKE '%" + name + "%'"
        var sqliteDB: SQLiteDatabase = this.readableDatabase
        var cursor:Cursor = sqliteDB.rawQuery(select_query,null)

        if (cursor.moveToFirst()){
            do{
                var idDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_ID))
                var nameDB:String = cursor.getString(cursor.getColumnIndex(KEY_NAME))
                var rateDB:Float = cursor.getFloat(cursor.getColumnIndex(KEY_RATE))
                var latitDB:Double = cursor.getDouble(cursor.getColumnIndex(KEY_LATITUDE))
                var longDB:Double = cursor.getDouble(cursor.getColumnIndex(KEY_LONGITUDE))
                var sizeDB:String = cursor.getString(cursor.getColumnIndex(KEY_SIZE))
                var priceDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_PRICE))
                var regionDB:String = cursor.getString(cursor.getColumnIndex(KEY_REGION))
                var cityDB:String = cursor.getString(cursor.getColumnIndex(KEY_CITY))
                var ownerPhoneDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_OWNER_PHONE))
                var managPhoneDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_MANAG_PHONE))
                var backgroundDB:String = cursor.getString(cursor.getColumnIndex(KEY_IMG))
                var waterDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_WATER))
                var grassDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_GRASS))
                var toiletDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_TOILET))
                var showerDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_SHOWER))
                var ballDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_BALL))
                var dressDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_DRESS))
                var staduimDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_SHOWER))
                var buffetDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_BUFFET))

                var staduim = StaduimAllData(idDB,nameDB,backgroundDB,ownerPhoneDB,managPhoneDB,rateDB,
                        sizeDB,priceDB,regionDB,cityDB,latitDB,longDB,waterDB,grassDB,toiletDB,showerDB,
                        ballDB,dressDB,staduimDB,buffetDB)
                fillStaduim.add(staduim)
            }while (cursor.moveToNext())
        }
        return fillStaduim
    }

    fun getStaduimById(id:Int):StaduimAllData{

        var sqliteDB:SQLiteDatabase = this.readableDatabase
//        var cursor = sqliteDB.query(TABLE_NAME, arrayOf<String>(KEY_ID,KEY_NAME,KEY_RATE,KEY_LATITUDE,KEY_LONGITUDE,
//                KEY_SIZE,KEY_PRICE,KEY_REGION,KEY_CITY,KEY_OWNER_PHONE,KEY_MANAG_PHONE,KEY_IMG,KEY_WATER,KEY_GRASS,
//                KEY_TOILET, KEY_SHOWER,KEY_BALL,KEY_DRESS,KEY_SHOWER,KEY_BUFFET) ,"id=?",
//                arrayOf<String>(id.toString()), null,null,null)

        var select_query = "SELECT * FROM "+ TABLE_NAME +" WHERE "+KEY_ID+" = "+id
        var cursor:Cursor = sqliteDB.rawQuery(select_query,null)
        var fillStaduim:StaduimAllData?= null

        if (cursor.moveToFirst()){
            do{
                var idDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_ID))
                var nameDB:String = cursor.getString(cursor.getColumnIndex(KEY_NAME))
                var rateDB:Float = cursor.getFloat(cursor.getColumnIndex(KEY_RATE))
                var latitDB:Double = cursor.getDouble(cursor.getColumnIndex(KEY_LATITUDE))
                var longDB:Double = cursor.getDouble(cursor.getColumnIndex(KEY_LONGITUDE))
                var sizeDB:String = cursor.getString(cursor.getColumnIndex(KEY_SIZE))
                var priceDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_PRICE))
                var regionDB:String = cursor.getString(cursor.getColumnIndex(KEY_REGION))
                var cityDB:String = cursor.getString(cursor.getColumnIndex(KEY_CITY))
                var ownerPhoneDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_OWNER_PHONE))
                var managPhoneDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_MANAG_PHONE))
                var backgroundDB:String = cursor.getString(cursor.getColumnIndex(KEY_IMG))
                var waterDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_WATER))
                var grassDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_GRASS))
                var toiletDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_TOILET))
                var showerDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_SHOWER))
                var ballDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_BALL))
                var dressDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_DRESS))
                var staduimDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_SHOWER))
                var buffetDB:Int = cursor.getInt(cursor.getColumnIndex(KEY_BUFFET))

                fillStaduim = StaduimAllData(idDB,nameDB,backgroundDB,ownerPhoneDB,managPhoneDB,rateDB,
                        sizeDB,priceDB,regionDB,cityDB,latitDB,longDB,waterDB,grassDB,toiletDB,showerDB,
                        ballDB,dressDB,staduimDB,buffetDB)
            }while (cursor.moveToNext())
        }
        return fillStaduim!!

    }
}