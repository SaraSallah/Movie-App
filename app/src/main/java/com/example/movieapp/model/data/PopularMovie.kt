package com.example.movieapp.model.data


import com.example.movieapp.model.data.Movie
import com.google.gson.annotations.SerializedName

data class PopularMovie(
    @SerializedName("page")
    val page: Int? = null,
    @SerializedName("results")
    val results: List<Movie?>? = null,
    @SerializedName("total_pages")
    val totalPages: Int? = null,
    @SerializedName("total_results")
    val totalResults: Int? = null
)