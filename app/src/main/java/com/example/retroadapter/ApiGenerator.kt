package com.example.retroadapter

import com.example.retrofit.TokenInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiGenerator {
    private val client = OkHttpClient.Builder()
        .addInterceptor(TokenInterceptor())
        .build()
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://anc-events.apa1906.app/public/api/")
        .addConverterFactory(GsonConverterFactory
        .create()).client(client).build()

    fun<T> buildServices(service : Class<T>) :T{
        return retrofit.create(service)
    }
}