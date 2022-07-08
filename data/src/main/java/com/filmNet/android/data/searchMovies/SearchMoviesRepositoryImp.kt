package com.filmNet.android.data.searchMovies

import com.filmNet.android.domain.model.Movie
import com.filmNet.android.domain.model.Result
import com.filmNet.android.domain.repository.SearchMovieRepository


class SearchMoviesRepositoryImp(private val searchMoviesRemoteDataSource: SearchMoviesRemoteDataSource):
    SearchMovieRepository {

     override suspend fun searchMovies(query: String): Result<List<Movie>> {

        return searchMoviesRemoteDataSource.searchMovies(query)

    }


}
