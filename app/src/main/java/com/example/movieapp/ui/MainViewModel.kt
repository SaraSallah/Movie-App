package com.example.movieapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.movieapp.MovieInteractionListener
import com.example.movieapp.model.data.Movie
import com.example.movieapp.model.data.PopularMovie
import com.example.movieapp.model.repo.MovieRepository
import com.example.movieapp.utils.State
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(), MovieInteractionListener {
    val repository = MovieRepository()
    val popularMovies = repository.getPopularMovies().asLiveData()
    val movie = MutableLiveData<State<PopularMovie?>>()

//    init {
//        getPopularMovies()
//    }
//
//    fun getPopularMovies() {
//        viewModelScope.launch {
//            repository.getPopularMovies()
//        }
//    }


    override fun onClickMovie(movie: Movie) {
    }
}
