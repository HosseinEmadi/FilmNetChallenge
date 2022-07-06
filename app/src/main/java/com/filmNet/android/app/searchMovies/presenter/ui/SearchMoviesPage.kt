package com.filmNet.android.app.searchMovies.presenter.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import com.filmNet.android.app.R
import com.filmNet.android.app.searchMovies.presenter.MoviesViewModel
import com.filmNet.android.utils.Failed
import com.filmNet.android.utils.Loaded
import com.filmNet.android.utils.Loading
import org.koin.androidx.compose.getViewModel
import java.lang.reflect.Modifier
@Composable
fun SearchMoviesPage(modifier: Modifier = Modifier()) {

    val viewModel = getViewModel<MoviesViewModel>()
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    when (val it = viewModel.moviesStateLiveData.observeAsState().value){
        is Failed -> {
            var message = LocalContext.current.getString(R.string.unknown_error)
            it.throwble.message?.let { m ->
                message = m
            }
            Toast.makeText(LocalContext.current, message, Toast.LENGTH_SHORT).show()

        }
        Loading -> {
            Column {

                SearchView(textState)

                Progress()
            }
        }
        else -> {
            Column {
                SearchView(textState)
                MoviesList(
                    list = viewModel.moviesLiveData.observeAsState().value ?: listOf()
                )
            }
        }

    }
    Column {
        SearchView(textState)


    }


}