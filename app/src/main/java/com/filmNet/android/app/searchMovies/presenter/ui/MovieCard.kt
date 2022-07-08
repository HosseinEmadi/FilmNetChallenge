package com.filmNet.android.app.searchMovies.presenter.ui

import androidx.compose.foundation.layout.*

import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.filmNet.android.app.R
import com.filmNet.android.domain.model.Movie

@Composable
fun MovieCard(movie: Movie,
              modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .padding(all = 8.dp)) {
        Row(
            modifier = Modifier
                .padding(all = 10.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically

        ) {

            movie.cover_image?.path?.let {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(it)
                        .crossfade(true)
                        .build(),
                    contentScale = ContentScale.Inside,
                    contentDescription = stringResource(R.string.description),
                    modifier = Modifier.size(dimensionResource(id = R.dimen.item_icon_size))
                )
            }

            Spacer(
                modifier = Modifier.width(8.dp)
            )
            Column(
                modifier = Modifier.fillMaxWidth()
            ){
                Text(
                    text = movie.title ?: "",
                    modifier = Modifier.padding(all = 4.dp),
                    color = Color.Black,
                    // If the message is expanded, we display all its content
                    // otherwise we only display the first line
                    style = MaterialTheme.typography.body1,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))
                movie.duration?.let {
                    Text(
                        text = "${LocalContext.current.getString(R.string.movie_duration)} ${it}" ,
                        color = MaterialTheme.colors.secondary,
                        modifier = Modifier
                            .padding(all = 4.dp)
                            .align(alignment = Alignment.End),
                        // If the message is expanded, we display all its content
                        // otherwise we only display the first line
                        style = MaterialTheme.typography.caption
                    )
                }

            }

        }
    }

}