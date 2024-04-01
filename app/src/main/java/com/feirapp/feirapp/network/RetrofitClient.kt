package com.feirapp.feirapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val INVOICE_IMPORT_API_URL = "https://701f-45-187-171-214.ngrok-free.app"
    private const val FEIRAPP_BACKEND_API_URL = "123456789"

    fun create(): InvoiceImportApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(INVOICE_IMPORT_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(InvoiceImportApiService::class.java)
    }
}