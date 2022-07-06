package com.filmNet.android.data

import com.filmNet.android.data.entity.SearchMoviesDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface SearchMoviesNetwork {

    @GET("search")
    suspend fun searchMovies(@Query("query") query: String): Response<SearchMoviesDto>

}