package com.feirapp.feirapp.models

import android.os.Parcelable
import com.feirapp.feirapp.models.enums.StatesEnum
import kotlinx.parcelize.Parcelize

@Parcelize
data class StoreModel(
    val name: String,
    val cnpj: String,
    val cep: String,
    val street: String,
    val streetNumber: String,
    val neighborhood: String,
    val cityName: String,
    val state: StatesEnum
) : Parcelable
