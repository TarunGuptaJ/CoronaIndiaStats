package com.androiddevs.confused.ui.fragments

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ContentValues.TAG
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androiddevs.confused.R
import com.androiddevs.confused.ui.*
import kotlinx.android.synthetic.main.india_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private lateinit var errorMsg: TextView
private lateinit var indiaLoading: ProgressBar
private lateinit var rv : RecyclerView
private lateinit var thisActivity : Activity

class indiafragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.india_fragment, container, false)
        allInfo().execute()
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        indiaLoading = view.findViewById(R.id.indiaProgressBar)
        rv = view.findViewById<RecyclerView>(R.id.listofstatesrv)
        thisActivity = activity!!
        errorMsg = view.findViewById(R.id.error_msg)
    }

}

private class allInfo : AsyncTask<Void, Void, Void>() {

    var singleParsed: String = ""
    var finalParsed: String = ""
    var ind_api: indiaApi? = null
    var ind_call: Call<AllData>? = null
    var allData: AllData? = null
    var allStates : MutableList<RegionData>? = mutableListOf()
    var allStatesList : MutableList<RegionData> = mutableListOf()

//    "https://api.covid19india.org/"
//    "https://api.apify.com/v2/key-value-stores/toDWvRj1JpTXiM8FF/records/LATEST?disableRedirect=true"

    override fun doInBackground(vararg params: Void?): Void? {

        val retrofit: Retrofit =
            Retrofit.Builder()
                .baseUrl("https://api.apify.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        ind_api = retrofit.create(indiaApi::class.java)
        ind_call = ind_api?.getFullData()

        return null
    }

    @SuppressLint("SetTextI18n")
    override fun onPostExecute(result: Void?) {
        super.onPostExecute(result)

        ind_call?.enqueue(object : Callback<AllData> {
            override fun onFailure(call: Call<AllData>, t: Throwable) {
                Log.e(TAG, "ERROR : " + t.message)
                Log.e(TAG, "ERROR : $call")
                indiaLoading.visibility = View.GONE
                errorMsg.text = "No internet. Please retry."
            }

            override fun onResponse(call: Call<AllData>, response: Response<AllData>) {
                Log.d(TAG, "code is : " + response.code().toString())
                allData = response.body()
                allStates = getStates(allData, allStates)
                indiaLoading.visibility = View.GONE
                populateAllStatesList(allStatesList, allStates)
                val adapter1 = Adapter(allStatesList)
                rv.adapter = adapter1
                rv.layoutManager = LinearLayoutManager(thisActivity?.applicationContext)
            }

            private fun populateAllStatesList(
                allStatesList: MutableList<RegionData>,
                allStates: MutableList<RegionData>?
            ) {
                for (i in 0 until allStates?.size!!) {
                    allStatesList.add(allStates.get(i))
                }
            }

//            private fun displayInfo(allData: AllData?, allStates: MutableList<RegionData>?) {
//                finalParsed =  "India Data:" + "\n" +
//                                "Confirmed: " + allData?.confirmed + "\n" +
//                                "Active: " + allData?.active + "\n" +
//                                "Deceased: " + allData?.deaths + "\n" +
//                                "Recovered: " + allData?.recovered + "\n" +
//                                "Last Updates: " + allData?.dateLastModified +
//                                "\n\n" + "State Data:"
//                for (i in 0 until allStates?.size!!) {
//                    var stateObj = allStates?.get(i)
//                    singleParsed = "\n" + "State: " + stateObj.state + "\n" +
//                                    "Confirmed: " + stateObj.confirmed + "\n" +
//                                    "Active: " + stateObj.active + "\n" +
//                                    "Deceased: " + stateObj.deceased + "\n" +
//                                    "Recovered: " + stateObj.recovered + "\n"
//
//                    finalParsed += singleParsed + "\n"
//                }
////                indiaText.text = finalParsed
//            }

            private fun getStates(
                allData: AllData?,
                allStates: MutableList<RegionData>?
            ): MutableList<RegionData>? {
                for (i in 0 until allData?.regionData?.size!!) {
                    allStates?.add(allData?.regionData?.get(i))
                }
                return allStates
            }

        })

    }


}

