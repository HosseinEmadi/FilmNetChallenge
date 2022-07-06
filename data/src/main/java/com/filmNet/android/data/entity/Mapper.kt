package com.filmNet.android.data.entity

import com.filmNet.android.domain.model.CoverImage
import com.filmNet.android.domain.model.Movie



fun List<MovieDto>.mapToMovies() = map { movieDto ->
    Movie(movieDto.title, movieDto.rate, movieDto.duration, movieDto.cover_image?.mapToCoverImage())
}

fun CoverImageDto.mapToCoverImage() = CoverImage(path)




