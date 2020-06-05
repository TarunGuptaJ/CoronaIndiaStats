package com.androiddevs.coronaapp.models

data class Tested(
    val individualstestedperconfirmedcase: String,
    val positivecasesfromsamplesreported: String,
    val samplereportedtoday: String,
    val source: String,
    val testpositivityrate: String,
    val testsconductedbyprivatelabs: String,
    val testsperconfirmedcase: String,
    val testspermillion: String,
    val totalindividualstested: String,
    val totalpositivecases: String,
    val totalsamplestested: String,
    val updatetimestamp: String
)