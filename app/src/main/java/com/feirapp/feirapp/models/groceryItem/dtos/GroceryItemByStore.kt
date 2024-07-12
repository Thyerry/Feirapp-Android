package com.feirapp.feirapp.models.groceryItem.dtos

import android.os.Parcelable
import com.feirapp.feirapp.models.enums.MeasureUnitEnum
import kotlinx.parcelize.Parcelize

@Parcelize
data class GroceryItemByStore (
    val id : Number,
    val name : String,
    val description : String?,
    val imageUrl : String?,
    val barcode : String,
    val measureUnit : MeasureUnitEnum,
    val priceHistory : List<PriceLogByStore>?
) : Parcelable