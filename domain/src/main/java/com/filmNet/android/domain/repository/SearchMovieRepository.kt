package com.filmNet.android.domain.repository

import com.filmNet.android.domain.model.Movie
import com.filmNet.android.domain.model.Result


interface SearchMovieRepository{
    suspend fun searchMovies(query: String): Result<List<Movie>>
}