package com.feirapp.feirapp.models.groceryItem.queries

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SearchGroceryItemQuery (
    val name: String?,
    val storeId : Long,
    val page : Int = 0,
    val pageSize : Int = 10
) : Parcelable