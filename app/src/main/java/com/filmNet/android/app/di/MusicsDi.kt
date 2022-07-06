package com.filmNet.android.app.di

import com.filmNet.android.app.searchMovies.presenter.MoviesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val musicsModule = module {

    //config viewModel di
    viewModel {
        MoviesViewModel()
    }

}