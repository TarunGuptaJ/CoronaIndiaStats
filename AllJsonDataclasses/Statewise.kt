package com.androiddevs.coronaapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(
    tableName = "Country"
)
data class Statewise(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val active: String,
    val confirmed: String,
    val deaths: String,
    val deltaconfirmed: String,
    val deltadeaths: String,
    val deltarecovered: String,
    val lastupdatedtime: String,
    val migratedother: String,
    val recovered: String,
    val state: String,
    val statecode: String,
    val statenotes: String
)