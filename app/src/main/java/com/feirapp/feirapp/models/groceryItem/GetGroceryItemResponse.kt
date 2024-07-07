package com.feirapp.feirapp.models.groceryItem

import android.os.Parcelable
import com.feirapp.feirapp.models.StoreModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class GetGroceryItemResponse (
    val store: StoreModel,
    var items: List<GroceryListItemModel>
): Parcelable