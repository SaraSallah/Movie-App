package com.example.movieapp.model.repo

import com.example.movieapp.network.API
import com.example.movieapp.utils.Constant
import com.example.movieapp.utils.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class MovieRepository {
    fun getPopularMovies() =
        wrapWithFlow { API.apiService.getPopularMovieS("en-US",1,Constant.API_KEY) }

    private fun <T> wrapWithFlow(function: suspend () -> Response<T>): Flow<State<T?>> {
        return flow {
            emit(State.Loading)
            try {
                val result = function()
                if (result.isSuccessful) {
                    emit(State.Success(result.body()))
                } else {
                    emit(State.Error(result.message()))
                }

            } catch (e: Exception) {
                emit(State.Error(e.message.toString()))

            }

        }
    }
}