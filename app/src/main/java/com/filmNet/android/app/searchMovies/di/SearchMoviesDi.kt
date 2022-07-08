package com.filmNet.android.app.searchMovies.di

import com.filmNet.android.app.baseviewmodel.coroutineDispatcherProvider
import com.filmNet.android.app.searchMovies.presenter.MoviesViewModel
import com.filmNet.android.data.searchMovies.SearchMoviesApi
import com.filmNet.android.data.searchMovies.SearchMoviesRemoteDataSource
import com.filmNet.android.data.searchMovies.SearchMoviesRepositoryImp
import com.filmNet.android.di.AUTHENTICATED_RETROFIT
import com.filmNet.android.di.createNetwork
import com.filmNet.android.domain.intractor.SearchMoviesUseCase
import com.filmNet.android.domain.repository.SearchMovieRepository
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named


val searchMoviesModule = module {

    single { createNetwork(SearchMoviesApi::class.java,get(named(AUTHENTICATED_RETROFIT))) }

    single { SearchMoviesUseCase(get()) }
    single { SearchMoviesRemoteDataSource(get(), coroutineDispatcherProvider().ioDispatcher()) }

    single<SearchMovieRepository> { SearchMoviesRepositoryImp(get()) }

    viewModel {

        MoviesViewModel(coroutineDispatcherProvider(), get())
    }
}