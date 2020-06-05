package com.androiddevs.confused.ui

import com.google.gson.annotations.SerializedName


data class Statewise (

	@SerializedName("active") val active : Int,
	@SerializedName("confirmed") val confirmed : Int,
	@SerializedName("deaths") val deaths : Int,
	@SerializedName("deltaconfirmed") val deltaconfirmed : Int,
	@SerializedName("deltadeaths") val deltadeaths : Int,
	@SerializedName("deltarecovered") val deltarecovered : Int,
	@SerializedName("lastupdatedtime") val lastupdatedtime : String,
	@SerializedName("migratedother") val migratedother : String,
	@SerializedName("recovered") val recovered : Int,
	@SerializedName("state") val state : String,
	@SerializedName("statecode") val statecode : String,
	@SerializedName("statenotes") val statenotes : String
)