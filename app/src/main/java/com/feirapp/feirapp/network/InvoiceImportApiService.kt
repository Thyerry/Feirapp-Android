package com.feirapp.feirapp.network

import com.feirapp.feirapp.models.GroceryListItemModel
import com.feirapp.feirapp.models.InvoiceImportResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface InvoiceImportApiService {
    @GET("/api/GroceryItem")
    fun getGroceryItems(): Call<List<GroceryListItemModel>>

    @GET("/api/Import/mateus")
    fun getGroceryListItemsFromMateus(@Query("searchTerm") searchTerm: String?, @Query("count") count: Number = 10): Call<List<GroceryListItemModel>>

    @GET("/api/Import/invoice")
    fun importGroceryItemsFromInvoice(@Query("invoiceCode") invoiceCode: String?): Call<InvoiceImportResponse>
}