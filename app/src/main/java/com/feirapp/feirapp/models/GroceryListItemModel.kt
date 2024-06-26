package com.feirapp.feirapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
data class GroceryListItemModel(
    val name: String = "",
    val price: Double = 0.0,
    val measureUnit: String = "",
    val quantity: Double = 0.0,
    val barcode: String = "",
    val storeName: String = "",
    val category: String = "",
    val ncm: String? = "",
    val cest: String? = "",
    val value: Float = 0.0f,
    val purchaseDate: String,
    val priceHistory: List<PriceLog> = listOf()
) : Parcelable