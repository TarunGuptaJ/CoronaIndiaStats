package com.androiddevs.confused.ui.fragments

import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.androiddevs.confused.R
import org.jsoup.Jsoup
import org.jsoup.nodes.Document


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

@Suppress("UNUSED_VARIABLE")
private class stateTest : AsyncTask<Void, Void, Void>() {

    var displayText: String = ""
    lateinit var singleParsed: String
    lateinit var finalParsed: String
    lateinit var json : String


    override fun doInBackground(vararg params: Void?): Void? {

        json = Jsoup
            .connect("https://api.covid19india.org/v2/state_district_wise.json")
            .ignoreContentType(true)
            .execute()
            .body()




        return null
    }

    override fun onPostExecute(result: Void?) {
        super.onPostExecute(result)
        stateText.text = json
        stateLoading.visibility = View.GONE
    }

}

////        val document : Document
//        val url : URL = URL("https://api.covid19india.org/v2/state_district_wise.json")
//        val httpUrlConn : HttpURLConnection = url.openConnection() as HttpURLConnection
//        val inputStream : InputStream = httpUrlConn.getInputStream()
//        val reader : InputStreamReader = InputStreamReader(inputStream)
//        val bufferedReader : BufferedReader = BufferedReader(reader)
//        var line : String? = ""
////        while (line != null)
//
//        for (i in 1..100) {
//            line = bufferedReader.readLine()
//            displayText += line
//        }
//
//        var teststr : String = "[{}]"
////        var jsonObj_temp : JSONObject = teststr as JSONObject
//        var jsonArr : JSONArray = [{ val s = "name":"kaustubh"}] as JSONArray
////        finalParsed = jsonArr.toString()
////        for (i in 0 until jsonArr.length()) {
////            var jsonObj : JSONObject = jsonArr.getJSONObject(i)
////            var district : district
////            var distData : JSONObject = jsonObj.getJSONObject("districtData")
////            singleParsed =  "district:" + jsonObj.get("district") + "\n" +
////                            "active:" + jsonObj.get("active") + "\n" +
////                            "confirmed:" + jsonObj.get("confirmed") +"\n"
////            finalParsed += singleParsed + "\n"
////        }
