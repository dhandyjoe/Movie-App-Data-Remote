package com.example.movieappapi.data.remote

import com.example.movieappapi.R
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {

    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val API_KEY = R.string.movie_api_key
    }

    @GET("/movie/now_playing?api_key=$API_KEY")
    suspend fun getNowPlaying(
        @Query("page") position: Int
    ): MovieResponse
}