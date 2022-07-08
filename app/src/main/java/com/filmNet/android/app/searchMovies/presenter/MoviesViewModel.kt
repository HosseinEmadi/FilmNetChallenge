package com.filmNet.android.app.searchMovies.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.filmNet.android.app.baseviewmodel.CoroutineDispatcherProvider
import com.filmNet.android.app.baseviewmodel.FilmNetViewModel
import com.filmNet.android.domain.intractor.SearchMoviesUseCase
import com.filmNet.android.domain.model.Movie
import com.filmNet.android.domain.model.Result
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MoviesViewModel(
    coroutineDispatcherProvider: CoroutineDispatcherProvider,
    private val searchPlaceUseCase: SearchMoviesUseCase
): FilmNetViewModel(coroutineDispatcherProvider) {


    private val _movies = MutableLiveData<Result<List<Movie>>>()
    val moviesLiveData: LiveData<Result<List<Movie>>>
        get() = _movies

    private var searchJob : Job? = null
    private var lastQuery = ""

    fun searchMovie(query: String){

        if(lastQuery == query.trim())
            return

        lastQuery = query.trim()

        _movies.postValue(Result.Loading)

        searchJob?.cancel()
         searchJob = launch {
             delay(SEARCH_DELAY_TIME)

             onBg {
                 val r = searchPlaceUseCase.execute(query)
                 _movies.postValue(r)
             }
         }
    }

    companion object{
        private const val SEARCH_DELAY_TIME = 1000L
    }
}