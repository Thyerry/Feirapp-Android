package com.feirapp.feirapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val FEIRAPP_BACKEND_API_URL = "backend-url"

    fun create(): GroceryItemApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(FEIRAPP_BACKEND_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(GroceryItemApiService::class.java)
    }
}
