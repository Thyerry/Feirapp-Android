package com.feirapp.feirapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GroceryCategoryModel(
    val cest: String = "",
    val ncm: String = "",
    val item: String = "",
    val name: String = "",
    val description: String = ""
) : Parcelable
