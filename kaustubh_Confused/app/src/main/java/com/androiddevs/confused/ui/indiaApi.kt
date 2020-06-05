package com.androiddevs.confused.ui

import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.GET

public interface indiaApi {
    @GET("data.json")
//    @GET("eeaebee")
    fun getFullData() : Call<AllData>
}