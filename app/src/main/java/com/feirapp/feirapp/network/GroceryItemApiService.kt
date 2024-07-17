package com.feirapp.feirapp.network

import com.feirapp.feirapp.models.groceryItem.dtos.GroceryListItemModel
import com.feirapp.feirapp.models.groceryItem.responses.*
import com.feirapp.feirapp.models.groceryItem.requests.*
import com.feirapp.feirapp.models.groceryItem.queries.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query
import java.math.BigInteger

interface GroceryItemApiService {
    // Grocery Item Endpoints
    @GET("/api/grocery-item")
    fun getGroceryItems(@Query("query") body: SearchGroceryItemQuery): Call<List<SearchGroceryItemResponse>>

    @GET("/api/grocery-item/by-id")
    fun getGroceryItemById(@Query("id") id: BigInteger): Call<GetGroceryItemByIdResponse>

    @GET("/api/grocery-item/by-store")
    fun getGroceryItemsByStore(@Query("storeId") storeId: Number): Call<List<SearchGroceryItemResponse>>

    @GET("/api/grocery-item/by-store")
    fun getRandomGroceryItems(@Query("quantity") quantity: Number): Call<GetGroceryItemFromStoreIdResponse>

    @GET("/api/grocery-item/by-invoice")
    fun getGroceryItemsFromInvoice(@Query("invoiceId") invoiceId: String): Call<GetGroceryItemResponse>

    @POST("/api/grocery-item/insert-list")
    fun insertGroceryList(@Body body: InsertGroceryItemList): Call<Unit>

    @PUT
    fun updateGroceryItem(@Body body: InsertGroceryItemList): Call<Unit>

    @DELETE
    fun deleteGroceryItem(@Query("groceryId") groceryId: Number): Call<Unit>

    @GET("/api/import/mateus")
    fun getGroceryListItemsFromMateus(
        @Query("searchTerm") searchTerm: String?,
        @Query("count") count: Number = 10
    ): Call<List<GroceryListItemModel>>
}
