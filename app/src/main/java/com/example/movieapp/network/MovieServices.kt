package com.example.movieapp.network

import com.example.movieapp.model.data.PopularMovie
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieServices {
    @GET("movie/popular")
    suspend fun getPopularMovieS(
        @Query("language") language: String ,
        @Query("page") page: Int,
        @Query("api_key") apiKey: String,
    ): Response<PopularMovie>
}