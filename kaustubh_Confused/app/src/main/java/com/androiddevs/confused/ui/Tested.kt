package com.androiddevs.confused.ui

import com.google.gson.annotations.SerializedName

data class Tested (

	@SerializedName("individualstestedperconfirmedcase") val individualstestedperconfirmedcase : Double,
	@SerializedName("positivecasesfromsamplesreported") val positivecasesfromsamplesreported : String,
	@SerializedName("samplereportedtoday") val samplereportedtoday : String,
	@SerializedName("source") val source : String,
	@SerializedName("testpositivityrate") val testpositivityrate : String,
	@SerializedName("testsconductedbyprivatelabs") val testsconductedbyprivatelabs : String,
	@SerializedName("testsperconfirmedcase") val testsperconfirmedcase : Double,
	@SerializedName("testspermillion") val testspermillion : Int,
	@SerializedName("totalindividualstested") val totalindividualstested : Int,
	@SerializedName("totalpositivecases") val totalpositivecases : Int,
	@SerializedName("totalsamplestested") val totalsamplestested : Int,
	@SerializedName("updatetimestamp") val updatetimestamp : String
)