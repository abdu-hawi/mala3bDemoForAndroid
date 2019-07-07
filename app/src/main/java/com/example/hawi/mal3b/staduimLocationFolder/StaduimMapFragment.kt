package com.example.hawi.mal3b.staduimLocationFolder

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import com.example.hawi.mal3b.staduimChoiseAndConfirmPay.StaduimChoiseActivity
import com.example.hawi.mal3b.R
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import java.util.ArrayList

/**
 * Created by Hawi on 27/08/17.
 */
class StaduimMapFragment:Fragment(),OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener, GoogleMap.InfoWindowAdapter {


    private final val TAG:String = "Staduim Map Fragment"

    lateinit private var mGoogleMap:GoogleMap
    lateinit private var mMapView:MapView
    lateinit private var mView:View

    var listOfSubStaduim = ArrayList<StaduimSubObject>()


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView = inflater!!.inflate(R.layout.staduim_map_fragment,container,false)

        Log.d(TAG,": is Started")
        return mView
    }

    override fun onMapReady(p0: GoogleMap?) {
//        val mMap = p0
//        var marker:LatLng = LatLng(-31.007 , 151.206)
//        mMap!!.moveCamera(CameraUpdateFactory.newLatLng(marker))
//        mMap!!.addMarker(MarkerOptions().title("toto").position(marker).snippet("hi"))
//        Toast.makeText(activity,"nul",Toast.LENGTH_LONG).show()
        //221.4827723,39.3321924


        MapsInitializer.initialize(context)
        mGoogleMap = p0!!

        var librt:CameraPosition = CameraPosition.builder().target(LatLng(21.4827723,39.3321924)).zoom(13f).bearing(0f).tilt(45f).build()
        mGoogleMap.moveCamera(CameraUpdateFactory.newCameraPosition(librt))

        // Loop for sub staduim
        for(i in 0..listOfSubStaduim.size-1){


            var oneStad = listOfSubStaduim[i]

            // show stad
            var stadLocation = LatLng(oneStad.location!!.latitude,oneStad.location!!.longitude)
            mGoogleMap.mapType = GoogleMap.MAP_TYPE_NORMAL
            mGoogleMap.addMarker(MarkerOptions().position(stadLocation).title(oneStad.name))
            //On click Window Marker
            mGoogleMap.setOnInfoWindowClickListener(this)
            //On click Marker
            mGoogleMap.setInfoWindowAdapter(this)

        }


//        MapsInitializer.initialize(context)
//        mGoogleMap = p0!!
//        var lat = LatLng(21.4030433,39.3108818)
//        mGoogleMap.mapType = GoogleMap.MAP_TYPE_NORMAL
//        mGoogleMap.addMarker(MarkerOptions().position(lat).title("ملعب الجوهرة"))
//        var librt:CameraPosition = CameraPosition.builder().target(lat).zoom(16f).bearing(0f).tilt(45f).build()
//        mGoogleMap.moveCamera(CameraUpdateFactory.newCameraPosition(librt))


    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mMapView = mView.findViewById(R.id.fragmentMap)

        if(true){
            mMapView.onCreate(null)
            mMapView.onResume()
            mMapView.getMapAsync(this)
        }
        loadSubStaduim()
    }

    override fun onInfoWindowClick(p0: Marker?) {
        Toast.makeText(activity,"nul",Toast.LENGTH_LONG).show()

        var intent = Intent(activity, StaduimChoiseActivity::class.java)
        startActivity(intent)
    }



    // تعبئة الملاعب
    fun loadSubStaduim(){
        //21.4769046!4d39.3365934
        listOfSubStaduim.add(StaduimSubObject(5, "mal3b 1", 21.4804726, 39.3101455))
        listOfSubStaduim.add(StaduimSubObject(4, "mal3b 2", 21.4821361, 39.3106887))
        listOfSubStaduim.add(StaduimSubObject(3, "mal3b 3", 21.4867758, 39.3102247))
        listOfSubStaduim.add(StaduimSubObject(5, "mal3b 4", 21.4829547, 39.317016))

        listOfSubStaduim.add(StaduimSubObject(5, "mal3b 1", 21.4820188, 39.3215436))
        listOfSubStaduim.add(StaduimSubObject(5, "mal3b 2", 21.4793332, 39.3327874))
        listOfSubStaduim.add(StaduimSubObject(5, "mal3b 3", 21.4769046, 39.3365934))
        listOfSubStaduim.add(StaduimSubObject(5, "mal3b 4", 21.5836243, 39.2122985))

    }

    override fun getInfoContents(p0: Marker?): View {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getInfoWindow(p0: Marker?): View {

        var view:View = layoutInflater.inflate(R.layout.staduim_marker_maps_click,null,false)

        view.findViewById<TextView>(R.id.txt_distance_marker).setText("65.0 km")
        view.findViewById<TextView>(R.id.txt_name_marker).setText("AL-GWHRA STADUIM")
        view.findViewById<RatingBar>(R.id.ratingBar_staduim_marker).rating = 3f

        return view
    }

}