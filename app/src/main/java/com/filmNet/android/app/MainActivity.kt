package com.filmNet.android.app

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import com.filmNet.android.app.searchMovies.presenter.ui.Header
import com.filmNet.android.app.ui.theme.FilmNetChallengeTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setMainView()

    }

    private fun setMainView() {
        setContent {
            FilmNetChallengeTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colors.background),
                    topBar = {Header()}
                ) {
                }
            }
        }
    }

}
