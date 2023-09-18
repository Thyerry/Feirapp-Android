package com.feirapp.feirapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GroceryListItemModel(
    val name: String = "",
    val price: Double = 0.0,
    val measure: String = "",
    val quantity: Double = 0.0,
    val cean: String = "",
    val storeName: String = "",
    val category: GroceryCategoryModel,
    val value: Float = 0.0f,
    val purchaseDate: String = "",
    val priceHistory: List<PriceLog> = listOf()
) : Parcelable