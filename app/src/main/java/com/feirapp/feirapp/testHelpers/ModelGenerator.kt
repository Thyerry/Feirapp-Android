package com.feirapp.feirapp.testHelpers

import com.feirapp.feirapp.models.StoreModel
import com.feirapp.feirapp.models.enums.MeasureUnitEnum
import com.feirapp.feirapp.models.enums.StatesEnum
import com.feirapp.feirapp.models.groceryItem.dtos.GroceryListItemModel

fun generateGroceryItems(): MutableList<GroceryListItemModel> {
    val groceryItems = mutableListOf(
        GroceryListItemModel(
            "name",
            2.0,
            MeasureUnitEnum.UNIT,
            "brand",
            "altname",
            2.0,
            "barcode",
            "ncmcode",
            "cestcode",
            "purchasedate"
        ),
        GroceryListItemModel(
            "name2",
            3.0,
            MeasureUnitEnum.KILO,
            "brand2",
            "altname2",
            3.5,
            "barcode2",
            "ncmcode2",
            "cestcode2",
            "purchasedate2"
        ),

        GroceryListItemModel(
            "name3",
            1.5,
            MeasureUnitEnum.LITER,
            "brand3",
            "altname3",
            2.0,
            "barcode3",
            "ncmcode3",
            "cestcode3",
            "purchasedate3"
        )
    )

    return groceryItems
}

fun generateStoreItems(): StoreModel {
    return StoreModel(
        "Loja do Zé",
        "Rua do Zé",
        "51347360",
        "Ulisses Guimarães",
        "55",
        "Ibura",
        "Recife",
        StatesEnum.PERNAMBUCO,
    )
}
