package com.feirapp.feirapp.models.groceryItem.dtos

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
data class PriceLogByStore(
    val price : Double,
    val logDate : Date
) : Parcelable
