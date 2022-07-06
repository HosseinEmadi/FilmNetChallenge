package com.filmNet.android.data.entity


data class SearchMoviesDto(val data: MoviesDto?)

data class MoviesDto(val videos: List<MovieDto>?)

data class MovieDto( val title: String?,
                      val rate: Double?,
                      val duration: String?,
                      val cover_image: CoverImageDto?,
)

data class CoverImageDto( val path: String)