package com.feirapp.feirapp.network

import com.feirapp.feirapp.models.GroceryListItemModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface InvoiceImportApiService {
    @GET("/api/GroceryItem")
    fun getGroceryListItemsFromInvoice(@Query("url") url: String?): Call<List<GroceryListItemModel>>
}