package com.feirapp.feirapp.models.groceryItem

import android.os.Parcelable
import com.feirapp.feirapp.models.StoreModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class InsertGroceryItemList (
    var groceryItems: List<GroceryListItemModel>,
    val store: StoreModel
) : Parcelable