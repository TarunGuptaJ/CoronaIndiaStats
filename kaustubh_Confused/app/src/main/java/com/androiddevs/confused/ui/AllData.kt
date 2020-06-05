package com.androiddevs.confused.ui

import com.google.gson.annotations.SerializedName

data class AllData (

	@SerializedName("cases_time_series") val cases_time_series : List<CasesTimeSeries>,
	@SerializedName("statewise") val statewise : List<Statewise>,
	@SerializedName("tested") val tested : List<Tested>
)
