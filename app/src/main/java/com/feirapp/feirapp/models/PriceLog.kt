package com.feirapp.feirapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PriceLog(
    val price: Double,
    val date: String?
) : Parcelable
