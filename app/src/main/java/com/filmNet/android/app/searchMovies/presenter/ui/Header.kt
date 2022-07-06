package com.filmNet.android.app.searchMovies.presenter.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import com.filmNet.android.app.R

@Composable
fun Header() {
    Text(
        text = LocalContext.current.getString(R.string.app_name) ,
        color = MaterialTheme.colors.secondary,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(all = dimensionResource(R.dimen.header_pading))

        ,
        // If the message is expanded, we display all its content
        // otherwise we only display the first line
        style = MaterialTheme.typography.h5
    )
}