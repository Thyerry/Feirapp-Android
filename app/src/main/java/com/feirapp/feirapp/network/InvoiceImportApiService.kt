package com.feirapp.feirapp.network

import com.feirapp.feirapp.models.GroceryListItemModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface InvoiceImportApiService {
    @GET("/api/GroceryItem/invoice")
    fun getGroceryListItemsFromInvoice(@Query("url") url: String?): Call<List<GroceryListItemModel>>
    @GET("/api/GroceryItem/mateus")
    fun getGroceryListItemsFromMateus(@Query("searchTerm") searchTerm: String?, @Query("count") count: Number = 10): Call<List<GroceryListItemModel>>
}