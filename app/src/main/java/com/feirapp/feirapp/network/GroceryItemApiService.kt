package com.feirapp.feirapp.network

import com.feirapp.feirapp.models.groceryItem.GetGroceryItemResponse
import com.feirapp.feirapp.models.groceryItem.GroceryListItemModel
import com.feirapp.feirapp.models.groceryItem.InsertGroceryItemList
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface GroceryItemApiService {
    @GET("/api/GroceryItem")
    fun getGroceryItems(): Call<List<GroceryListItemModel>>

    @GET("/api/GroceryItem/getFromInvoice/")
    fun getGroceryItemsFromInvoice(@Query("invoiceId") invoiceId : String): Call<GetGroceryItemResponse>

    @POST("/api/GroceryItem/InsertList")
    fun insertGroceryList(@Body body: InsertGroceryItemList): Call<Unit>

    @GET("/api/Import/mateus")
    fun getGroceryListItemsFromMateus(@Query("searchTerm") searchTerm: String?, @Query("count") count: Number = 10): Call<List<GroceryListItemModel>>
}