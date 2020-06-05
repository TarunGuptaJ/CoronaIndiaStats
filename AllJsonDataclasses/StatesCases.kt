package com.androiddevs.coronaapp.models

data class StatesCases(
    val cases_time_series: List<CasesTimeSery>,
    val statewise: List<Statewise>,
    val tested: List<Tested>
)