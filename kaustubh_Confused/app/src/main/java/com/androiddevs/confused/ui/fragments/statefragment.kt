package com.androiddevs.confused.ui.fragments

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.nfc.Tag
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.androiddevs.confused.R
import com.androiddevs.confused.ui.*
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URL


lateinit var stateText: TextView
lateinit var stateLoading: ProgressBar

class statefragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.state_fragment, container, false)
        stateTest().execute()
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        stateText = view.findViewById(R.id.state_text)
        stateLoading = view.findViewById(R.id.stateProgressBar)
    }
}

private class stateTest : AsyncTask<Void, Void, Void>() {

    var displayText: String = ""
    lateinit var singleParsed: String
    var finalParsed: String = ""
    lateinit var json: String
    val url: URL = URL("https://api.covid19india.org/v2/")
    var districts : MutableList<List<districtData>>? = mutableListOf()
    var allStates: List<State>? = null
    var api : Api? = null
    var call : Call<List<State>>? = null

    override fun doInBackground(vararg params: Void?): Void? {

        val retrofit: Retrofit =
            Retrofit.Builder()
                .baseUrl("https://api.covid19india.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        api = retrofit.create(Api::class.java)
        call = api?.getState()

        return null
    }

    @SuppressLint("SetTextI18n")
    override fun onPostExecute(result: Void?) {
        super.onPostExecute(result)
        Log.d(TAG, "here state 0 is : " + allStates?.get(0)?.state)
        call?.enqueue(object : Callback<List<State>> {
            override fun onFailure(call: Call<List<State>>, t: Throwable) {
                Log.e(TAG, "ERROR : " + t.message)
            }

            override fun onResponse(call: Call<List<State>>, response: Response<List<State>>) {
                Log.d(TAG, "code is : " + response.code().toString())
                allStates = response.body()
                districts = getDistrictData(allStates, districts)
                Log.d(TAG, "districts is : $districts")
                stateLoading.visibility = View.GONE
                displayInfo(allStates, districts)
            }

            private fun displayInfo(
                allStates: List<State>?,
                districts: MutableList<List<districtData>>?
            ) {
                for (i in 0 until allStates?.size!!) {
                    singleParsed = "State: " + allStates?.get(i)?.state + "\n\n"
                    for (j in 0 until districts?.get(i)?.size!!) {
                        singleParsed += "District: " + districts?.get(i)?.get(j).district + "\n" +
                                        "Active: " + districts?.get(i)?.get(j).active + "\n" +
                                        "Confirmed: " + districts?.get(i)?.get(j).confirmed + "\n" +
                                        "Deceased: " + districts?.get(i)?.get(j).deceased + "\n" +
                                        "Recovered: " + districts?.get(i)?.get(j).recovered + "\n\n"
                    }
                    finalParsed += singleParsed + "\n"
                }
                stateText.text = finalParsed
            }

            private fun getDistrictData(
                allStates: List<State>?,
                districts: MutableList<List<districtData>>?
            ): MutableList<List<districtData>>? {
                for (i in 0 until allStates?.size!!) {
                    districts?.add(allStates[i].districtData)
                }
                return districts
            }
        })
    }

}