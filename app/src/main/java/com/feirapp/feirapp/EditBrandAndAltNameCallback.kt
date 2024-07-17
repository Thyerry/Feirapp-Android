package com.feirapp.feirapp

import com.feirapp.feirapp.models.groceryItem.dtos.GroceryListItemModel

data class EditBrandAndAltNameCallback(
    var onEditBrandAndAltNameCallback: ((item: GroceryListItemModel) -> Unit)? = null
)
