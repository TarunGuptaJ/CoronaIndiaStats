package com.androiddevs.confused.ui

import com.google.gson.annotations.SerializedName

data class CasesTimeSeries (
	@SerializedName("dailyconfirmed") val dailyconfirmed : Int,
	@SerializedName("dailydeceased") val dailydeceased : Int,
	@SerializedName("dailyrecovered") val dailyrecovered : Int,
	@SerializedName("date") val date : String,
	@SerializedName("totalconfirmed") val totalconfirmed : Int,
	@SerializedName("totaldeceased") val totaldeceased : Int,
	@SerializedName("totalrecovered") val totalrecovered : Int
)
