package com.feirapp.feirapp.models.groceryItem.dtos

import android.os.Parcelable
import com.feirapp.feirapp.models.enums.MeasureUnitEnum
import kotlinx.parcelize.Parcelize

@Parcelize
data class GroceryListItemModel(
    val name: String = "",
    val price: Double = 0.0,
    val measureUnit: MeasureUnitEnum?,
    val quantity: Double = 0.0,
    val barcode: String = "",
    val ncmCode: String? = "",
    val cestCode: String? = "",
    val purchaseDate: String,
) : Parcelable
