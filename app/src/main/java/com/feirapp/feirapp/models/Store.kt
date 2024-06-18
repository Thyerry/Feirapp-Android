package com.feirapp.feirapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Store (
    val name : String,
    val cnpj : String,
    val cep : String,
    val street : String,
    val streetNumber : String,
    val neighborhood : String,
    val cityName : String,
    val state : String
) : Parcelable
