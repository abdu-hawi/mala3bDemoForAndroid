package com.example.hawi.mal3b.staduimSearchFolder

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.hawi.mal3b.R

/**
 * Created by Hawi on 27/08/17.
 */
class StaduimSearchFragment : Fragment() {
    private final val TAG:String = "Search Stars Fragment"

    lateinit var btn: Button

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(R.layout.staduim_search_fragment,container,false)

        Log.d(TAG, ": is Started")

        btn = view.findViewById(R.id.btnSearchFragment)
        btn.setOnClickListener(View.OnClickListener {
            Toast.makeText(activity, "Search Map Fragment", Toast.LENGTH_LONG).show()
        })

        return view
    }
}