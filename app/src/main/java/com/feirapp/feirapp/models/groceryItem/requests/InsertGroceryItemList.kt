package com.feirapp.feirapp.models.groceryItem.requests

import android.os.Parcelable
import com.feirapp.feirapp.models.StoreModel
import com.feirapp.feirapp.models.groceryItem.dtos.GroceryListItemModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class InsertGroceryItemList (
    var groceryItems: List<GroceryListItemModel>,
    val store: StoreModel
) : Parcelable