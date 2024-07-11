package com.feirapp.feirapp.network

import com.feirapp.feirapp.models.groceryItem.GetGroceryItemResponse
import com.feirapp.feirapp.models.groceryItem.GroceryListItemModel
import com.feirapp.feirapp.models.groceryItem.InsertGroceryItemList
import com.feirapp.feirapp.models.groceryItem.SearchGroceryItemQuery
import com.feirapp.feirapp.models.groceryItem.SearchGroceryItemResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface GroceryItemApiService {
    // Grocery Item Endpoints
    @GET("/api/grocery-item")
    fun getGroceryItems(@Query("query") body: SearchGroceryItemQuery): Call<List<SearchGroceryItemResponse>>

    @GET("/api/grocery-item/by-store")
    fun getGroceryItemsByStore(@Query("storeId") storeId: Number) : Call<List<SearchGroceryItemResponse>>

    @GET("/api/grocery-item/by-invoice/")
    fun getGroceryItemsFromInvoice(@Query("invoiceId") invoiceId : Number): Call<GetGroceryItemResponse>

    @POST("/api/grocery-item/insert-list")
    fun insertGroceryList(@Body body: InsertGroceryItemList): Call<Unit>

    @GET("/api/import/mateus")
    fun getGroceryListItemsFromMateus(@Query("searchTerm") searchTerm: String?, @Query("count") count: Number = 10): Call<List<GroceryListItemModel>>
}