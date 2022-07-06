package com.filmNet.android.domain.repository

import com.filmNet.android.domain.model.Movie


interface SearchMovieRepository{
    suspend fun searchMovies(query: String): List<Movie>
}