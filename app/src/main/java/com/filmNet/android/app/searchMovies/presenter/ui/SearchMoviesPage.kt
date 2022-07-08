package com.filmNet.android.app.searchMovies.presenter.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import com.filmNet.android.app.searchMovies.presenter.MoviesViewModel
import com.filmNet.android.domain.model.Result
import org.koin.androidx.compose.getViewModel
import java.lang.reflect.Modifier
@Composable
fun SearchMoviesPage(modifier: Modifier = Modifier()) {

    val viewModel = getViewModel<MoviesViewModel>()
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    when (val it = viewModel.moviesLiveData.observeAsState().value){

        is Result.Error -> {
            val message = it.message
            Toast.makeText(LocalContext.current, message, Toast.LENGTH_SHORT).show()

        }
        is Result.Loading -> {
            Column {

                SearchView(textState)
                Progress()
            }
        }
        is Result.Success -> {
            Column {
                SearchView(textState)
                MoviesList(
                    list = it.data ?: listOf()
                )
            }
        }
    }

    Column {
        SearchView(textState)
    }

}