package com.filmNet.android.app.searchMovies.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.filmNet.android.base.baseviewmodel.CoroutineDispatcherProvider
import com.filmNet.android.base.baseviewmodel.FilmNetViewModel
import com.filmNet.android.domain.intractor.SearchMoviesUseCase
import com.filmNet.android.domain.model.Movie
import com.filmNet.android.utils.Failed
import com.filmNet.android.utils.LoadableData
import com.filmNet.android.utils.Loaded
import com.filmNet.android.utils.Loading
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MoviesViewModel(
    coroutineDispatcherProvider: CoroutineDispatcherProvider,
    private val searchPlaceUseCase: SearchMoviesUseCase
): FilmNetViewModel(coroutineDispatcherProvider) {


    private val _movies = MutableLiveData<List<Movie>>()
    val moviesLiveData: LiveData<List<Movie>>
        get() = _movies

    private val _moviesState = MutableLiveData<LoadableData<List<Movie>>>()
    val moviesStateLiveData: LiveData<LoadableData<List<Movie>>>
        get() = _moviesState

    private var searchJob : Job? = null

    var lastQuery = ""
    fun searchMovie(query: String){

        if(lastQuery == query.trim())
            return
        lastQuery = query.trim()
        _moviesState.postValue(Loading)

        searchJob?.cancel()
         searchJob = launch {
             delay(SEARCH_DELAY_TIME)

            onBg {
                runCatching {
                    searchPlaceUseCase.execute(query)
                    }

                }.onSuccess { upComingList ->
                _moviesState.postValue(Loaded(upComingList))
                _movies.postValue(upComingList)

                }.onFailure {
                _moviesState.postValue(Failed(it))

                }
            }
        }

    companion object{
        private const val SEARCH_DELAY_TIME = 1000L
    }
}