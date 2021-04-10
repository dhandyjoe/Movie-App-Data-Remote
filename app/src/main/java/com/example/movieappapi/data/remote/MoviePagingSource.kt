package com.example.movieappapi.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import retrofit2.HttpException
import java.io.IOException

private const val STARTING_PAGE_INDEX = 1

class MoviePagingSource (private val movieAPI: MovieAPI): PagingSource<Int, DataMovie>() {
    override fun getRefreshKey(state: PagingState<Int, DataMovie>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DataMovie> {
        return try {
            val position = params.key ?: STARTING_PAGE_INDEX
            val response = movieAPI.getNowPlaying(position)
            val movies = response.result

            LoadResult.Page(
                data = movies,
                prevKey = if (position == STARTING_PAGE_INDEX) null else position-1,
                nextKey = if (movies.isEmpty()) null else position+1
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

}