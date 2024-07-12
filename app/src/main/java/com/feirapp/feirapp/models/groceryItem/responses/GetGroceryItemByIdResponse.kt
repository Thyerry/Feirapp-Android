package com.feirapp.feirapp.models.groceryItem.responses

import android.os.Parcelable
import com.feirapp.feirapp.models.PriceLog
import com.feirapp.feirapp.models.enums.MeasureUnitEnum
import kotlinx.parcelize.Parcelize

@Parcelize
data class GetGroceryItemByIdResponse(
    val id : Number,
    val name : String,
    val description : String?,
    val imageUrl : String?,
    val barcode : String,
    val measureUnit : MeasureUnitEnum,
    val priceHistory : List<PriceLog>?
) : Parcelable