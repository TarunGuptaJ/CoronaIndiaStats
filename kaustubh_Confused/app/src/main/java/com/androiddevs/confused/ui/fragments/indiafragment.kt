package com.androiddevs.confused.ui.fragments

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
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
import com.androiddevs.confused.ui.AllData
import com.androiddevs.confused.ui.indiaApi
import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


private lateinit var indiaText: TextView
private lateinit var indiaLoading: ProgressBar

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
        indiaText = view.findViewById(R.id.india_text)
        indiaLoading = view.findViewById(R.id.indiaProgressBar)
    }
}

private class allInfo : AsyncTask<Void, Void, Void>() {

    lateinit var singleParsed: String
    var finalParsed: String = ""
    var ind_api: indiaApi? = null
    var ind_call: Call<AllData>? = null
    var allData: AllData? = null
//    "https://api.covid19india.org/"
//    "https://extendsclass.com/api/json-storage/bin/"

    override fun doInBackground(vararg params: Void?): Void? {

        val okHttpClient = OkHttpClient.Builder()
            .callTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)


        val retrofit: Retrofit =
            Retrofit.Builder()
                .baseUrl("https://api.covid19india.org/")
                .client(okHttpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        ind_api = retrofit.create(indiaApi::class.java)

        return null
    }

    @SuppressLint("SetTextI18n")
    override fun onPostExecute(result: Void?) {
        super.onPostExecute(result)

        ind_call = ind_api?.getFullData()

        ind_call?.enqueue(object : Callback<AllData> {
            override fun onFailure(call: Call<AllData>, t: Throwable) {
                Log.e(TAG, "ERROR : " + t.message)
                indiaLoading.visibility = View.GONE
                indiaText.text = "No internet. Please retry."
            }

            override fun onResponse(call: Call<AllData>, response: Response<AllData>) {
                Log.d(TAG, "code is : " + response.code().toString())
                allData = response.body()
                indiaText.text = allData.toString()
            }

        })

    }


}

