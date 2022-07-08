package com.filmNet.android.domain.intractor

import com.filmNet.android.domain.model.Movie
import com.filmNet.android.domain.model.Result
import com.filmNet.android.domain.repository.SearchMovieRepository


class SearchMoviesUseCase(private val searchMovieRepository: SearchMovieRepository) {

    suspend fun execute(query: String): Result<List<Movie>> {
         return searchMovieRepository.searchMovies(query)
    }
}