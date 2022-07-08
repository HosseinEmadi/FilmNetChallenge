package com.filmNet.android.data

import com.filmNet.android.data.entity.mapToMovies
import com.filmNet.android.domain.model.Movie
import com.filmNet.android.domain.repository.SearchMovieRepository


class SearchMoviesRepositoryImp(private val searchMoviesNetwork: SearchMoviesNetwork):
    SearchMovieRepository {

    override suspend fun searchMovies(query: String): List<Movie> {
        val response = searchMoviesNetwork.searchMovies(query)

        return response.body()!!.data!!.videos!!.mapToMovies()

    }


}
