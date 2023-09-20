package com.feirapp.feirapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://97f9-45-187-171-214.ngrok-free.app"

    fun create(): InvoiceImportApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(InvoiceImportApiService::class.java)
    }
}