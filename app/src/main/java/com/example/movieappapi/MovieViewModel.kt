package com.example.movieappapi

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.movieappapi.data.remote.MovieRepository

class MovieViewModel @ViewModelInject constructor(private val repository: MovieRepository): ViewModel() {

    val movies = repository.getNowPlayingMovies()

}



