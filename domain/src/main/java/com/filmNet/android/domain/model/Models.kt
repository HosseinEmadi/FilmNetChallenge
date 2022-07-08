package com.filmNet.android.domain.model



data class Movie(val title: String?,
                 val rate: Double?,
                 val duration: String?,
                 val cover_image: CoverImage?,
)

data class CoverImage( val path: String)

sealed class Failure {

    abstract class ServerException: Failure()  {

        data class UnknownError(val message: String = "Unknown Error") : GeneralException()

    }
    abstract class GeneralException: Failure()  {

        data class UnknownError(val message: String = "Unknown Error") : GeneralException()
        data class ConnectionError(val message: String = "Connection Error") : GeneralException()

    }
    abstract class SearchMovieException: Failure()  {

        data class AccessDenied(val message: String = "Upgrade to premium for use this feature") : SearchMovieException()


    }
}

