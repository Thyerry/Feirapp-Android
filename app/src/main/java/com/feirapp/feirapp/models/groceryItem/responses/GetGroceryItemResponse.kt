package com.feirapp.feirapp.models.groceryItem.responses

import android.os.Parcelable
import com.feirapp.feirapp.models.StoreModel
import com.feirapp.feirapp.models.groceryItem.dtos.GroceryListItemModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class GetGroceryItemResponse (
    val store: StoreModel,
    var items: List<GroceryListItemModel>
): Parcelable