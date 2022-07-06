package com.filmNet.android.domain.model





sealed class Failure {

    abstract class SearchMovieException: Failure()  {

        data class AccessDenied(val message: String = "Upgrade to premium for use this feature") : SearchMovieException()


    }
}

