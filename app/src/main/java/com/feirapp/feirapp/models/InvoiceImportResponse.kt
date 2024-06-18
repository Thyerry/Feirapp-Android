package com.feirapp.feirapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class InvoiceImportResponse (
    val store: Store,
    var items: List<GroceryListItemModel>
): Parcelable