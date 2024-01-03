package com.example.movieapp.network

import com.example.movieapp.utils.Constant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object API {

    private val loginInterceptor =HttpLoggingInterceptor()
        .apply { level = HttpLoggingInterceptor.Level.BODY }
    private val myClient = OkHttpClient.Builder()
        .addInterceptor(loginInterceptor).build()
    private val retrofit = Retrofit
        .Builder()
        .baseUrl(Constant.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val apiService = retrofit.create(MovieServices::class.java)
}