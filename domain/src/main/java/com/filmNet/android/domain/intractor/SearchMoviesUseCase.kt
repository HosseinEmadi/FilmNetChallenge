package com.filmNet.android.domain.intractor



class SearchMoviesUseCase() {

    fun execute(query: String): Result<Unit> {
         return Result.failure(Throwable(""))
    }
}