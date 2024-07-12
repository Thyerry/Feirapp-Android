package com.feirapp.feirapp.models.groceryItem.responses

import android.os.Parcelable
import com.feirapp.feirapp.models.StoreModel
import com.feirapp.feirapp.models.groceryItem.dtos.GroceryItemByStore
import kotlinx.parcelize.Parcelize

@Parcelize
data class GetGroceryItemFromStoreIdResponse(
    val store: StoreModel,
    val items: List<GroceryItemByStore>,
) : Parcelable
