package com.feirapp.feirapp.models.groceryItem.responses

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
data class SearchGroceryItemResponse (
    val id : Long,
    val name : String,
    val description : String = "",
    val lastPrice : Double,
    val imageUrl: String,
    val barcode : String,
    val lastUpdate : Date,
    val measureUnit : String,
    val storeId : Long,
    val storeName : String,
): Parcelable